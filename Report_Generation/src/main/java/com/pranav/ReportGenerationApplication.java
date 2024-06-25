package com.pranav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReportGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportGenerationApplication.class, args);
		System.out.println("++++++++++++ Report App : Up and Running +++++++++++++++++");
	}

}
