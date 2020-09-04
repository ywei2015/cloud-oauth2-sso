package com.example.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class UrlFilterSecurityInterceptor extends FilterSecurityInterceptor {
	@Autowired
	private IgnoreUrlsConfig ignoreUrlsConfig;
	private String[] ignore;
	@Autowired
	private UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
	@Autowired
	private AffirmativeBased affirmativeBased;
	@Autowired
	private AuthenticationManager authenticationManager;

	public UrlFilterSecurityInterceptor() {
		super();
	}

	@PostConstruct
	public void initProperties() {
		List<String> ignos = ignoreUrlsConfig.getUrls();
		this.ignore = new String[ignos.size()];
		ignos.toArray(ignore);
		this.setAuthenticationManager(authenticationManager);
		this.setAccessDecisionManager(affirmativeBased);
		this.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
	}

	@Override
	public void init(FilterConfig arg0) {
		super.init(arg0);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
		AtomicReference<Boolean> flag = new AtomicReference<>(false);
		Arrays.stream(ignore).forEach(s -> {
			AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(s);
			if (antPathRequestMatcher.matches(httpServletRequest)) {
				flag.set(true);
				return;
			}
		});
		if (flag.get()) {
			chain.doFilter(request, response);
		} else {
			super.doFilter(request, response, chain);
		}
	}

	@Override
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return super.getSecurityMetadataSource();
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return super.obtainSecurityMetadataSource();
	}

	@Override
	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource) {
		super.setSecurityMetadataSource(newSource);
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return super.getSecureObjectClass();
	}

	@Override
	public void invoke(FilterInvocation fi) throws IOException, ServletException {
		super.invoke(fi);
	}

	@Override
	public boolean isObserveOncePerRequest() {
		return super.isObserveOncePerRequest();
	}

	@Override
	public void setObserveOncePerRequest(boolean observeOncePerRequest) {
		super.setObserveOncePerRequest(observeOncePerRequest);
	}
}