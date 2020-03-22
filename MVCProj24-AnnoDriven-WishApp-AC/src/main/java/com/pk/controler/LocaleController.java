package com.pk.controler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pk.service.LocaleService;

@Controller
public class LocaleController {
	
	@Autowired
	private LocaleService service;
	
	@RequestMapping("/allLang.htm")
	public ModelAndView getAllLanguages() {
		System.out.println("LocaleController.getAllLanguages()");
		Locale[] allLocale = service.getAllLocale();
		System.out.println(allLocale.toString());
		return new ModelAndView("view_language", "allLocale", allLocale);
	}

}
