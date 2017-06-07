package com.syscall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syscall.service.AccountUserDetailsService;
import com.syscall.service.NotificationService;
import com.syscall.util.Response;

@Controller
public class LoginController {

	
	
	
	private  final AccountUserDetailsService accountUserDetailsService;

	LoginController(AccountUserDetailsService accountUserDetailsService) {
		this.accountUserDetailsService = accountUserDetailsService;
	}
	
	@PostMapping(value= "/rememberPassword", produces={"application/json"})
	public @ResponseBody Response rememberPassword(@RequestParam String email) {
		
		String mensage = "Erro";
		if (accountUserDetailsService.existAccount(email)) {
			accountUserDetailsService.sendPasswordMail(email);
			mensage= "Senha enviado para o e-mail" ;
		}
		
		return new Response(mensage);
		
	}
	
	
}
