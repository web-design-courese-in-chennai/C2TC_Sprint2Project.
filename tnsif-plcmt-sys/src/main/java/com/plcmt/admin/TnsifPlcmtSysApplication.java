package com.plcmt.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.plcmt") //starts spring boot project
public class TnsifPlcmtSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(TnsifPlcmtSysApplication.class, args);
	}

}
