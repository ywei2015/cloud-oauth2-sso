package com.example.common.exception;

public class BusinessException extends  BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(IResponseBase iResponseBase, Object[] args, String message) {
        super(iResponseBase, args, message);
    }

    public BusinessException(IResponseBase iResponseBase, Object[] args, String message, Throwable cause) {
        super(iResponseBase, args, message, cause);
    }

}