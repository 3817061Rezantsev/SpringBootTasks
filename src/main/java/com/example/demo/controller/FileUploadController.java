package com.example.demo.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@GetMapping("/upload")
	public String greetingFrom(Model model) {
		model.addAttribute("file", new File("file"));
		return "upload";
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			String oldData = "";
			try {
				FileReader fr = new FileReader("users.txt");
				Scanner in = new Scanner(fr);
				while (in.hasNextLine()) {
					oldData += in.nextLine() + "\n";
				}
				in.close();
				byte[] bytes = file.getBytes();
				String str = new String(bytes);
				oldData += str + "\n";
				FileWriter nFile = new FileWriter("users.txt");
				nFile.write(oldData);
				nFile.close();
				return "uploaded";
			} catch (Exception e) {
				return "error";
			}
		} else {
			return "upload";
		}
	}

}