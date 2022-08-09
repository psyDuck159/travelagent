package com.nashintern.travelagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@EnableWebSecurity(debug = true)
@SpringBootApplication
		(exclude = SecurityAutoConfiguration.class)
public class TravelagentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelagentApplication.class, args);
	}

}
