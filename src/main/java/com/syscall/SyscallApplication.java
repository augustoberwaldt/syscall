package com.syscall;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SyscallApplication {

	private static Logger logger = LoggerFactory.getLogger(SyscallApplication.class);
	
	public static void main(String[] args) {
		logger.info("Test debug: {}");
		SpringApplication.run(SyscallApplication.class, args);
	}
}
