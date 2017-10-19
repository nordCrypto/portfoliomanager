package com.nordcrypto.portfoliomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.nordcrypto.portfoliomanager.model"})
@EnableJpaRepositories(basePackages = {"com.nordcrypto.portfoliomanager.repository"})
public class PortfoliomanagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortfoliomanagerApplication.class, args);
	}
}
