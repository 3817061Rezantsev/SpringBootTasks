package com.example.demo.controller;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Form;

@Controller
public class FormController {
	@GetMapping("/form")
	public String greetingFrom(Model model) {
		model.addAttribute("form", new Form());
		return "form";
	}

	@PostMapping("/form")
	public String greetingSubmit(@ModelAttribute Form form) {
		try (FileWriter writer = new FileWriter("users.txt", false)) {
			writer.write(form.toString());
			writer.append('\n');
			writer.flush();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return "sended";
	}

}
