package com.blz.addressBook;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class FinalAssignmentAddressBookApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FinalAssignmentAddressBookApplication.class, args);
		log.info("Address Book app started!!!");
		log.info("Address Book app started started in {} environment",
				context.getEnvironment().getProperty("environment"));
		log.info("Address Book DB user {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	}
}
