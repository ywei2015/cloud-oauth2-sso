package com.example.common.exception;


/**
 * 自定义API异常
 * Created by yww on 2020/2/27.
 */
public class BaseException extends RuntimeException {

    private IResponseBase responseEnum;


    BaseException(IResponseBase responseEnum, Object[] args, String message){
        super(message);
        this.responseEnum = responseEnum;
    }

    BaseException(IResponseBase responseEnum, Object[] args, String message, Throwable cause){
        super(message,cause);
        this.responseEnum = responseEnum;
    }


    public IResponseBase getResponseEnum() {
        return responseEnum;
    }
}
