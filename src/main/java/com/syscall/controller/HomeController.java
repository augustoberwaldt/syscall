package com.syscall.controller;



import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

/**
 * Created by rodrigo on 2/21/17.
 */
@Controller
public class HomeController {

	@GetMapping("/home")
	public ModelAndView home() {
		return  new ModelAndView("index");
	}

}