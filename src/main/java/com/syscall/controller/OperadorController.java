package com.syscall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operador")
public class OperadorController {

    @GetMapping("/listagem")
    public String listagem() {
        return "operador/listagem";
    }


    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "operador/cadastrar";
    }

}
