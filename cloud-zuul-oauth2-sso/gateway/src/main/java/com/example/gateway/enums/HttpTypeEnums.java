package com.example.gateway.enums;

public enum HttpTypeEnums {
	GET(1, "get"),
	PUT(2, "put"),
	POST(3, "post");

	private Integer type;
	private String name;

	HttpTypeEnums(Integer type, String name) {
		this.name = name;
		this.type = type;
	}

}
