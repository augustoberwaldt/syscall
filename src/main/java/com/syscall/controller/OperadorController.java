package com.syscall.controller;

import com.syscall.domain.Operador;
import com.syscall.service.OperadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/operador")
public class OperadorController {

    private final OperadorService operadorService;


    public OperadorController(OperadorService operadorService) {
        this.operadorService =  operadorService;

    }

    @GetMapping("/listagem")
    public ModelAndView listagem() {

        return new ModelAndView("operador/index").addObject(
                "operadores",
                this.operadorService.getAll()
        );
    }


    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        Operador operador = new Operador();
        return new ModelAndView("operador/cadastrar").addObject("operador", operador);
    }

    @PostMapping("/save")
    public String save(@Valid Operador operador, BindingResult bindingResult, Model model) {

        if (!bindingResult.hasErrors()) {
    	 operador.setStatus(1);
    	 this.operadorService.save(operador);
    	}
        
    	return "redirect:/operador/cadastrar";
    }

}
