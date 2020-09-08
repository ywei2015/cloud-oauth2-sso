package com.example.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert {

    /**
     * Bad licence type
     */
    BAD_LICENCE_TYPE(7001, "Bad licence type."),
    /**
     * Licence not found
     */
    LICENCE_NOT_FOUND(7002, "Licence not found."),
	/**
	 * UserId not found
	 */
	NOT_NULL(7003, "{0} not null.")
	;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}