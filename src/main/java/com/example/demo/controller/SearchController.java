package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Form;

@Controller
public class SearchController {
	@GetMapping("/search")
	public String searchFrom(Model model) {
		model.addAttribute("form", new Form());
		return "search";
	}

	@PostMapping("/search")
	public String searchSubmit(@ModelAttribute Form form) {

		String oldData = "";
		String[] res = null;
		try {
			FileReader fr = new FileReader("users.txt");
			Scanner in = new Scanner(fr);
			while (in.hasNextLine()) {
				String str = in.nextLine();
				String[] strings = str.split(" ");
				if (strings[0].trim().equals(form.getFirstName()) && strings[2].trim().equals(form.getLastName())) {
					res = strings;
				}
				oldData += str + "\n";

			}

		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		if (res == null) {
			return "redirect:/unfound";
		}
		form.setFirstName(res[0].trim());
		form.setSecondName(res[1].trim());
		form.setLastName(res[2].trim());
		form.setAge(Integer.parseInt(res[3].trim()));
		form.setSalary(Integer.parseInt(res[4].trim()));
		form.setWorkplace(res[5].trim());
		form.setEmail(res[6].trim());
		try (FileWriter nFile = new FileWriter("users.txt", false)) {
			nFile.write(oldData);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return "found";
	}
}
