package com.mail.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mail.model.Email;
import com.mail.service.EmailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/")
	public String showSendEmailForm(Model model) {
		model.addAttribute("email", new Email());
		return "index";
	}

	@PostMapping("/sendMail")
	public String sendEmail(Email email, @RequestParam("attachment") MultipartFile attachment) {
		emailService.sendMail(email, attachment);
		return "redirect:/success";
	}

	@GetMapping("/success")
	public String showSuccessPage() {
		return "success";
	}
}
