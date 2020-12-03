package com.yjf.entity;

import java.io.Serializable;

/**
 * @description：操作结果集

 */
public class Result implements Serializable {

    public static final int SUCCESS = 1;
    public static final int FAILURE = -1;

    private static final long serialVersionUID = 5576237395711742681L;

    private boolean success = false;

    private String msg = "";

    private Object obj = null;

    public Result() {
        this.success=true;
        this.msg="操作成功";
    }
    public Result(Object obj) {
        this();
        this.obj=obj;
    }

    public Result(boolean success, String msg, Object obj) {
        this.success = success;
        this.msg = msg;
        this.obj = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
