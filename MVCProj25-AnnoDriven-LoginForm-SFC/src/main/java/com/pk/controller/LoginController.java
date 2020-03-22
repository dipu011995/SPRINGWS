package com.pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pk.command.UserCommand;
import com.pk.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@GetMapping("/login.htm")
	public String displayForm(Model model) {
		UserCommand cmd = new UserCommand();
		model.addAttribute("userCmd", cmd);
		return "login";
	}

}
