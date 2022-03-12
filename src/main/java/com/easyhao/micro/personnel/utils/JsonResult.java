package com.easyhao.micro.personnel.utils;

public class JsonResult {

    private Integer code;
    private String msg;
    private Object data;

    public static JsonResult success(String msg) {
        return new JsonResult(200, msg, null);
    }

    public static JsonResult success(String msg, Object obj) {
        return new JsonResult(200, msg, obj);
    }

    public static JsonResult error(String msg) {
        return new JsonResult(500, msg, null);
    }

    public static JsonResult error(String msg, Object obj) {
        return new JsonResult(500, msg, obj);
    }

    private JsonResult() {
    }

    private JsonResult(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.data = obj;
    }

    public Integer getcode() {
        return code;
    }

    public void setcode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
