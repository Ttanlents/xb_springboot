package com.yjf.controller;

import com.yjf.constant.LoginUser;
import com.yjf.entity.Result;
import com.yjf.entity.User;
import com.yjf.services.UserService;
import com.yjf.utils.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 余俊锋
 * @date 2020/12/4 13:16
 * @Description
 */
@RestController
public class WxLoginController {

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.appSecret}")
    private String appSecret;

    @Value("${wx.redirect_uri}")
    private String redirect_uri;

    @Autowired
    private HttpServletResponse response;
    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/toWx_login")
    public void toWx_login() {
        String url = null;
        try {
            url = "https://open.weixin.qq.com/connect/qrconnect?response_type=code" +
                    "&appid=" + appId +
                    "&redirect_uri=" + URLEncoder.encode(redirect_uri, "utf-8") +
                    "&scope=snsapi_login";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/wx_login")
    public void wx_login(HttpServletRequest request) throws Exception {
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=" + appId +
                "&secret=" + appSecret +
                "&code=" + code +
                "&grant_type=authorization_code";
        Map map = execute(url); //获取access_token


        url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + map.get("access_token") +
                "&openid=" + map.get("openid");
        Map userInfo = execute(url); //获取用户信息
        System.out.println(userInfo);
        User one=userService.findByWxOpenid(userInfo.get("openid")+"");

        if (one==null){
            one=new User();
            one.setWxOpenid(userInfo.get("openid")+"");
            String nickName = new String((userInfo.get("nickname")+"").getBytes("ISO-8859-1"), "UTF-8");
            one.setUsername(UUID.randomUUID().toString().substring(36 - 15));
            one.setRealName(nickName);
            one.setGender(userInfo.get("sex")+"");
            one.setPic(userInfo.get("headimgurl")+"");
            one.setRegisterTime(new Date());
            one.setInfo(userInfo.get("city")+"");
            userService.save(one);
            one=userService.findByWxOpenid(userInfo.get("openid")+"");
        }
        redisTemplate.opsForValue().set(LoginUser.REDIS_LOGINUSER_KEY+one.getId(),one);
        redisTemplate.opsForValue().set(LoginUser.REDIS_WXLOGINUSERID_KEY,one.getId());
        try {
            response.sendRedirect("html/wxLogin.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/saveWxLoginUser")
    @ResponseBody
    public Result saveWxLoginUser(){
       int loginUserId = (int)redisTemplate.opsForValue().get(LoginUser.REDIS_WXLOGINUSERID_KEY);
        User user=(User)redisTemplate.opsForValue().get(LoginUser.REDIS_LOGINUSER_KEY+loginUserId);
        return new Result(true,"登录成功",user);
    }

    private static Map execute(String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String json = EntityUtils.toString(entity);
            Map map = JsonUtils.jsonToPojo(json, HashMap.class);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
