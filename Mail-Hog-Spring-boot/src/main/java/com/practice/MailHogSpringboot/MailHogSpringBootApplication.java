package com.practice.MailHogSpringboot;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class MailHogSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MailHogSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("localhost");
		sender.setPort(1025);

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom("from@gmail.com");
		helper.setSubject("Hello, world!");
		helper.setTo("to@gmail.com");
		helper.setText("Thank you for ordering!");

		sender.send(message);
	}
}
