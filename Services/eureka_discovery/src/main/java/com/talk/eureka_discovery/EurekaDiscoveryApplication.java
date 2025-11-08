package com.talk.eureka_discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryApplication.class, args);
	}

}
