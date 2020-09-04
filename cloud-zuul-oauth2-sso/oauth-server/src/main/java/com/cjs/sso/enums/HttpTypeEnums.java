package com.cjs.sso.enums;

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

	public static HttpTypeEnums from(Integer type) {
		for (HttpTypeEnums httpTypeEnums : HttpTypeEnums.values()) {
			if (httpTypeEnums.type.equals(type)) {
				return httpTypeEnums;
			}
		}
		return null;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
