package com.syscall.http.controller;

import com.syscall.service.gutinho.GutinhoService;

public class TesteController {

    private final GutinhoService gutinhoService;
	
	TesteController(GutinhoService gutinhoService) {
		
		this.gutinhoService =  gutinhoService;
	}
	
}
