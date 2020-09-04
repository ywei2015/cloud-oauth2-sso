package com.example.gateway.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface RbacService {
	/**
	 * 返回权限验证的接口
	 */
	boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
