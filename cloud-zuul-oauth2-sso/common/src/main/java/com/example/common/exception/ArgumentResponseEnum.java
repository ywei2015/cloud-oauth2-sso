package com.example.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArgumentResponseEnum {

	VALID_ERROR(5001,"参数绑定错误");

	private int code;
	private String mssage;

}
