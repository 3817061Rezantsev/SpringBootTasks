package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Sender;

@Controller
public class EmailController {

	@GetMapping("/email")
	public String greetingFrom(Model model) {
		model.addAttribute("sender", new Sender());
		return "email";
	}

	@Autowired
	private JavaMailSender javaMailSender;

	private void sendmail(String text, String email) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);

		msg.setSubject("Testing from Spring Boot");

		msg.setText(text);
		javaMailSender.send(msg);
	}

	@PostMapping("/email")
	public String greetingSubmit(@ModelAttribute Sender sender) {

		sendmail(sender.getText(), sender.getEmail());

		return "sendedEmail";
	}

}
