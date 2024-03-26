package com.mail.model;

import org.springframework.web.multipart.MultipartFile;

public class Email {

	private String toEmail;
	private String subject;
	private String message;

//	private String body;
	private MultipartFile attachment;

//	
	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MultipartFile getAttachment() {
		return attachment;
	}

	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}

//
	@Override
	public String toString() {
		return "Email [toEmail=" + toEmail + ", subject=" + subject + ", message=" + message + " attachment="
				+ attachment + "]";
	}
}
