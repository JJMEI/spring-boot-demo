package com.meijunjie.springboot.common;


import java.io.Serializable;

/**
 *
 * @author meijunjie
 * @date 2018/9/20
 */


public class JsonResult implements Serializable{

    private static final long serialVersionUID = 4414488834190623365L;
    private  int code;
    private  String message;
    private  Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonResult(){

    }

    public JsonResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static JsonResult success(Object data){
        return new JsonResult(0,"success",data);
    }

    public static JsonResult failed(Object data){
        return new JsonResult(-1,"error",data);
    }

}
