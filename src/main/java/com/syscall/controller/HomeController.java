package com.syscall.controller;



import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home() {
		return  "home";
	}

}