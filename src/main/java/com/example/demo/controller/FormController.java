package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String greetingSubmit(@Valid Form form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		String oldData = "";
		try {
			FileReader fr = new FileReader("users.txt");
			Scanner in = new Scanner(fr);
			while (in.hasNextLine()) {
				oldData += in.nextLine() + "\n";
			}

		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}

		try (FileWriter nFile = new FileWriter("users.txt", false)) {
			oldData += "\n" + form.toString();
			nFile.write(oldData);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return "sended";
	}

}
