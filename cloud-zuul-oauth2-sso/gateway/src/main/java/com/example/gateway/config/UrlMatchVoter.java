package com.example.gateway.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collection;

public class UrlMatchVoter implements AccessDecisionVoter<Object> {
	@Override
	public boolean supports(ConfigAttribute attribute) {
		if (attribute instanceof UrlConfigAttribute) return true;
		return false;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
		if (authentication == null) {
			return ACCESS_DENIED;
		}
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (ConfigAttribute attribute : attributes) {
			if (!(attribute instanceof UrlConfigAttribute)) continue;
			UrlConfigAttribute urlConfigAttribute = (UrlConfigAttribute) attribute;
			for (GrantedAuthority authority : authorities) {
				//if (!(authority instanceof UrlGrantedAuthority)) continue;
				SimpleGrantedAuthority urlGrantedAuthority = (SimpleGrantedAuthority) authority;
				if (StringUtils.isBlank(urlGrantedAuthority.getAuthority())) continue;
				//如果数据库的method字段为null，则默认为所有方法都支持
				//String httpMethod = StringUtils.isNotBlank(urlGrantedAuthority.getHttpMethod()) ? urlGrantedAuthority.getHttpMethod()
				//		: urlConfigAttribute.getHttpServletRequest().getMethod();
				//用Spring已经实现的AntPathRequestMatcher进行匹配，这样我们数据库中的url也就支持ant风格的配置了（例如：/xxx/user/**）

				AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(urlGrantedAuthority.getAuthority());
				if (antPathRequestMatcher.matches(urlConfigAttribute.getHttpServletRequest())) {
					return ACCESS_GRANTED;
				}
			}
		}
		return ACCESS_ABSTAIN;
	}
}