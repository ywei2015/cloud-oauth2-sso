package com.cjs.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2SsoAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2SsoAuthServerApplication.class, args);
	}

}

