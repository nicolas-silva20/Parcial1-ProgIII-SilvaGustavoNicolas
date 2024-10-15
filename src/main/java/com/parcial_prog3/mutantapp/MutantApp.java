package com.parcial_prog3.mutantapp;

import com.parcial_prog3.mutantapp.services.MutantEvaluator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MutantApp {

	public static void main(String[] args) {
		SpringApplication.run(com.parcial_prog3.mutantapp.MutantApp.class, args);
	}

	@Bean
	public org.springframework.boot.web.server.WebServerFactoryCustomizer<org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory> configurePort(Environment environment) {
		return factory -> {
			String port = environment.getProperty("PORT");
			if (port != null) {
				factory.setPort(Integer.parseInt(port));
			} else {
				factory.setPort(8080); // Default to port 8080
			}
		};
	}
}
