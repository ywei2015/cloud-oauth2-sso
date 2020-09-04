package com.example.gateway.config;

import com.example.gateway.util.EnvironmentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


/**
 * @author yinweiwei
 * @date 2019-03-03
 */
@EnableOAuth2Sso
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private EnvironmentUtils environmentUtils;

	@Autowired
	private UrlFilterSecurityInterceptor urlFilterSecurityInterceptor;

	@Autowired
	private AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/res/**", "/bootstrap/**", "/assets/**", "/css/**", "/images/**","/actuator/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if ("local".equals(environmentUtils.getActiveProfile())) {
			http.authorizeRequests().anyRequest().permitAll();
		} else {
			http.logout().logoutSuccessUrl("http://localhost:8080/logout")
					.and()
					.authorizeRequests()
					.anyRequest().authenticated()
					.and()
					.addFilterBefore(urlFilterSecurityInterceptor, FilterSecurityInterceptor.class)
					.csrf().disable().exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
		}
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}

