package com.osttra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String  getindex() {
		return "index";
	}
	@GetMapping("/register")
	public String  getRegisterPage() {
		return "register_page";
	}

}
