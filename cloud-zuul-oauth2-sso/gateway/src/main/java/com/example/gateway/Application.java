package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext,
												 OAuth2ProtectedResourceDetails details) {
		return new OAuth2RestTemplate(details, oauth2ClientContext);
	}

}
