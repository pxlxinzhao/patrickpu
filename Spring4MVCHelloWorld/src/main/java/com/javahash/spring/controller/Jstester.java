package com.javahash.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Jstester {

	@RequestMapping("/js")
    public String test( Model model) {
		
		return "testjs";
	}
}
