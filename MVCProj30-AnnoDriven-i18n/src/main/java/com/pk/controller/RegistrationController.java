package com.pk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pk.command.RegistrationCommand;

@Controller
public class RegistrationController {
	
	@GetMapping("/home.htm")
	public String showForm(@ModelAttribute("regCmd")RegistrationCommand cmd) {
		return "register_form";
	}

}
