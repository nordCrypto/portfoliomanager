package com.nordcrypto.portfoliomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EntityScan(basePackages = {"com.nordcrypto.portfoliomanager.models"})
@EnableJpaRepositories(basePackages = {"com.nordcrypto.portfoliomanager.repository"})
@EnableResourceServer
public class PortfoliomanagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortfoliomanagerApplication.class, args);
	}
}
