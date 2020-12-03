package com.yjf.utils;

import com.yjf.constant.LoginUser;
import com.yjf.entity.User;
import com.yjf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 余俊锋
 * @date 2020/12/1 13:43
 * @Description
 */
@Component
public class LoginUserUtils {
    private static RedisTemplate redisTemplate;
    private static HttpSession session;
    private static HttpServletRequest request;
    private static UserService userService;

    @Autowired
    public  void setRedisTemplate(RedisTemplate redisTemplate) {
        LoginUserUtils.redisTemplate = redisTemplate;
    }

    @Autowired
    public  void setSession(HttpSession session) {
        LoginUserUtils.session = session;
    }

    @Autowired
    public  void setRequest(HttpServletRequest request) {
        LoginUserUtils.request = request;
    }
    @Autowired
    public  void setUserService(UserService userService) {
        LoginUserUtils.userService = userService;
    }

    public static User getLoginUser(){
        Cookie cookie = getCookie();
        User loginUser = (User)redisTemplate.opsForValue().get(LoginUser.REDIS_LOGINUSER_KEY+cookie.getValue());
        if (loginUser!=null){
            return loginUser;
        }
       User user= userService.findById(Integer.parseInt(cookie.getValue()));
        if (user!=null){
            redisTemplate.opsForValue().set(LoginUser.REDIS_LOGINUSER_KEY+cookie.getValue(),user);
        }
        return user;
    }

    public static Integer getLoginUserId(){
       if (getLoginUser()!=null){
           return getLoginUser().getId();
       }
       return null;
    }





    public static Cookie getCookie(){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginUserId")){
                    return  cookie;
                }
            }
        }
        return null;
    }
}
