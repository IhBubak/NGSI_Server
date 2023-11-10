package com.NGSI.Server.NGSIServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class NgsiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgsiServerApplication.class, args);
	}

}
