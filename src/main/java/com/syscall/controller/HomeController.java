package com.syscall.controller;



import com.syscall.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
	private  final NotificationService notificationService;

	HomeController(NotificationService notificationService) {
		this.notificationService =  notificationService;
	}

	@Autowired
	private ConfigurableApplicationContext c;
	@GetMapping("/")
	public String index() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home() {

		return  "home";
	}

}