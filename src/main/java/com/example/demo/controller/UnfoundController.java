package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnfoundController {
	@GetMapping("/unfound")
	public String greetingFrom(Model model) {
		return "unfound";
	}
}
