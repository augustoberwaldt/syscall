package com.syscall.controller;



import com.syscall.service.ChamadoService;
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

	private final ChamadoService chamadoService;
	
	HomeController(NotificationService notificationService, ChamadoService chamadoService) {
		this.notificationService =  notificationService;
		this.chamadoService      =  chamadoService;
	}

	@Autowired
	private ConfigurableApplicationContext c;
	@GetMapping("/")
	public String index() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public ModelAndView home() {

		return  new ModelAndView("home")
				.addObject("chamados", chamadoService.getCallsByUser(
				     1L      
				));
	}

}