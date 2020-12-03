package com.yjf.controller;

import com.yjf.constant.LoginUser;
import com.yjf.entity.Dept;
import com.yjf.entity.PageResult;
import com.yjf.entity.Result;
import com.yjf.entity.User;
import com.yjf.services.DeptService;
import com.yjf.services.UserService;
import com.yjf.utils.EmailUtil;
import com.yjf.utils.LoginUserUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author 余俊锋
 * @date 2020/11/30 19:55
 * @Description
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    HttpSession session;
    @Autowired
    DeptService deptService;
    @Autowired
    Environment environment;


    /**
     * @return com.yjf.entity.Result
     * @Description TODO:true已经注册，false还没有注册
     * @author 余俊锋
     * @date 2020/12/1 9:30
     * @params email
     */


    @GetMapping("/checkEmail/{email}")
    @ResponseBody
    public Result checkEmail(@PathVariable String email) {
        User user = userService.checkEmail(email);
        if (user != null) {
            return new Result(true, "邮箱已注册", null);
        }
        return new Result(false, "邮箱还没有注册", null);
    }


    @GetMapping("/checkUsername/{username}")
    @ResponseBody
    public Result checkUsername(@PathVariable String username) {
        User user = userService.checkUsername(username);
        if (user != null) {
            return new Result(true, "用户名已注册", null);
        }
        return new Result(false, "用户名还没有注册", null);
    }

    @PostMapping("/register")
    @ResponseBody
    public Result toRegister(@RequestBody User user) {
        user.setLoginTime(new Date());
        user.setRegisterTime(new Date());
        user.setInfo("好吃");
        user.setLook(0);
        user.setIsSecret("1");
        user.setPic("https://www.baidu.com/favicon.ico");
        userService.save(user);
        return new Result(true, "注册成功", null);
    }

    @PostMapping("/sendEmailCode/{email}")
    @ResponseBody
    public Result resetPassword(@PathVariable String email) throws GeneralSecurityException, MessagingException {
        String code = RandomStringUtils.randomNumeric(6);
        EmailUtil.sendEmail(email, code);
        redisTemplate.opsForValue().set("user:" + email, code, 60, TimeUnit.SECONDS);
        return new Result(true, "发送成功", null);
    }

    @PutMapping("/resetPassword/{code}")
    @ResponseBody
    public Result resetPassword(@PathVariable String code, @RequestBody User user) {

        Object redisCode = redisTemplate.opsForValue().get("user:" + user.getEmail());
        if (!Objects.equals(redisCode, code)) {
            return new Result(false, "验证码有误或已失效", null);
        }
        User one = userService.checkEmail(user.getEmail());
        if (one != null) {
            one.setPassword(user.getPassword());
            userService.resetPassword(one);
            return new Result(true, "重置密码成功", null);
        }
        return new Result(false, "重置密码失败", null);

    }

    @PostMapping("/doLogin/{code}")
    @ResponseBody
    public Result doLogin(@PathVariable String code, @RequestBody User user) {
        String safeCode = (String) session.getAttribute("safeCode");
        if (!Objects.equals(safeCode, code)) {
            return new Result(false, "验证码错误", null);
        }
        User one = userService.doLogin(user.getUsername(), user.getPassword());
        if (one != null) {
            one.setLoginTime(new Date());
            userService.updateUser(one);
            one.setPassword(null);
            Map<Object, Object> map = new HashMap<>();
            map.put(LoginUser.STORAGE_LOGINUSER_KEY, one);
            map.put(LoginUser.COOKIE_LOGINUSERID_KEY, one.getId());
            redisTemplate.opsForValue().set(LoginUser.REDIS_LOGINUSER_KEY + one.getId(), one, 3, TimeUnit.DAYS);

            return new Result(true, "登录成功", map);
        }
        return new Result(false, "账号或密码有误", null);

    }


    @GetMapping("/selectPage/{pageCurrent}")
    @ResponseBody
    public Result selectPage(@PathVariable Integer pageCurrent, String username) {
        if (username == null) {
            username = "";
        }
        Page<User> userPage = userService.selectPage(pageCurrent, username);
        PageResult<User> pageResult = new PageResult<>();
        pageResult.setPageTotal(userPage.getTotalPages());
        pageResult.setRows(userPage.getContent());

        List<Integer> ids = userService.findFocusById(LoginUserUtils.getLoginUserId());
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);
        map.put("pageResult", pageResult);
        return new Result(true, "查询成功", map);
    }

    @GetMapping("/getUserDetail/{id}")
    @ResponseBody
    public Result getUserDetail(@PathVariable Integer id) {
        if (LoginUserUtils.getLoginUserId() != id) {
            userService.updateUserLookById(id);
        }
        User user = userService.getUserDetail(id);
        Integer focusCount = userService.getFocusCount(id);
        Integer fansCount = userService.getFansCount(id);
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("focusCount", focusCount);
        map.put("fansCount", fansCount);
        return new Result(true, "查询成功", map);
    }

    @PutMapping("/changeFocus/{id}")
    @ResponseBody
    public Result changeFocus(@PathVariable Integer id) {
        Integer loginUserId = LoginUserUtils.getLoginUserId();
        Boolean flag = userService.isFocusOtherById(loginUserId, id);
        if (flag) { //关注过了
            userService.deleteFocus(loginUserId, id);
            return new Result(true, "取关成功", null);
        }
        userService.insertFocus(loginUserId, id);
        return new Result(true, "关注成功", null);

    }


    @GetMapping("/selectAllDept")
    @ResponseBody
    public Result selectAllDept() {
        List<Dept> list = deptService.selectAllDept();
        return new Result(true, "查询成功", list);

    }

    /**
     * @return com.yjf.entity.Result
     * @Description TODO:上传头像到nginx服务器
     * @author 余俊锋
     * @date 2020/11/28 16:48
     * @params file
     */


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Result getCode(MultipartFile file) throws IOException {
        String picName = UUID.randomUUID().toString().replace("-", "");
        String prefix = environment.getProperty("uploads.file.prefix");
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.indexOf("."));
        File file1 = new File(prefix + picName + suffix);
        file.transferTo(file1);
        String url = "http://localhost:8080/xb/upload/" + picName + suffix;
        return new Result(true, "上传成功", url);
    }


    @RequestMapping(value = "/doSave", method = RequestMethod.POST)
    @ResponseBody
    public Result doSave(@RequestBody User user) {
        User one = userService.findById(user.getId());
        one.setPic(user.getPic());
        one.setDeptId(user.getDeptId());
        one.setDeptName(deptService.findById(user.getDeptId()).getName());
        one.setPhone(user.getPhone());
        one.setAge(user.getAge());
        one.setGender(user.getGender());
        one.setIsSecret(user.getIsSecret());
        userService.updateUser(one);
        redisTemplate.opsForValue().set(LoginUser.REDIS_LOGINUSER_KEY + one.getId(), one, 30, TimeUnit.DAYS);
        return new Result(true, "保存成功", one);
    }

    @GetMapping(value = "/myFocus/{pageCurrent}")
    @ResponseBody
    public Result myFocus(@PathVariable Integer pageCurrent) {
        Integer loginUserId = LoginUserUtils.getLoginUserId();
        Page<User> page = userService.getMyFocus(loginUserId,pageCurrent);
        PageResult<User> userPageResult = new PageResult<>(page.getTotalPages(), page.getContent());
        return new Result(true, "查询成功", userPageResult);
    }


    @DeleteMapping(value = "/toChancelFocus/{id}")
    @ResponseBody
    public Result toChancelFocus(@PathVariable Integer id) {
        Integer loginUserId = LoginUserUtils.getLoginUserId();
        userService.toChancelFocus(loginUserId,id);
        return new Result(true, "取关成功", null);
    }
}
