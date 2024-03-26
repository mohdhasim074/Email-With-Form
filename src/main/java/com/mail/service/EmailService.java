package com.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mail.model.Email;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(Email email, MultipartFile attachment) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			// Enable multipart mode
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom("myjio0189@gmail.com"); // Replace with your actual sender email
			helper.setTo(email.getToEmail());
			helper.setSubject(email.getSubject());
			helper.setText(email.getMessage());

			// Check if there's an attachment
			if (attachment != null && !attachment.isEmpty()) {
				// Add the attachment
				helper.addAttachment(attachment.getOriginalFilename(), new ByteArrayResource(attachment.getBytes()));
			}

			mailSender.send(message);
			System.out.println("Mail sent successfully (with attachment if any).");
		} catch (Exception e) {
			System.out.println("Exception while sending email: " + e.getMessage());
		}
	}
}
