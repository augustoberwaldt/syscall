package com.syscall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/report")
public class RelatorioController {

	
	@GetMapping("/")
	public ModelAndView report() {
		return  new  ModelAndView("report/index");
	}
 
	
}
