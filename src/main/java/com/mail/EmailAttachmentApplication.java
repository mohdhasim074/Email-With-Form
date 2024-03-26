package com.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailAttachmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailAttachmentApplication.class, args);
		System.out.println("End...");
	}

}
