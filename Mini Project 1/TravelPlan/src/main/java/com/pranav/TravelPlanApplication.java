package com.pranav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.pranav.config.AppConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfigProperties.class)
public class TravelPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelPlanApplication.class, args);
		System.out.println(" +++++++++++++ Application Up and running ++++++++++++++++    ");
	}

}
