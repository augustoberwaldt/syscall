package com.syscall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.syscall.service.ReportService;

@Controller
@RequestMapping("/report")
public class RelatorioController {

	private final ReportService reportService;
	 
	RelatorioController(ReportService  reportService) {
		this.reportService = reportService;
	}
	
	@GetMapping("/kindCalls")
	public ModelAndView report() {
		return  new  ModelAndView("report/index");
	}
 
	
}
