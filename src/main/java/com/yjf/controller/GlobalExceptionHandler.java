package com.yjf.controller;

import com.yjf.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

/**
 * @author 余俊锋
 * @date 2020/12/1 12:01
 * @Description
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({GeneralSecurityException.class, MessagingException.class})
    public Result emailException() {
        return new Result(false, "发送失败，请检查邮箱是否正确", null);
    }
}
