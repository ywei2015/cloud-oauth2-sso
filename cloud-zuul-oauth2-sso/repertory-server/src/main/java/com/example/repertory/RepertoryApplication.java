package com.example.repertory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yww
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value = "com.example")
public class RepertoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepertoryApplication.class, args);
	}

}
