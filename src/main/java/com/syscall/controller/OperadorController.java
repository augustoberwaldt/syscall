package com.syscall.controller;

import com.syscall.domain.Operador;
import com.syscall.service.OperadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

import javax.validation.Valid;

@Controller
@RequestMapping("/operador")
public class OperadorController {

    private final OperadorService operadorService;


    public OperadorController(OperadorService operadorService) {
        this.operadorService =  operadorService;

    }

    @GetMapping("/")
    public ModelAndView listagem() {

        return new ModelAndView("operator/index").addObject(
                "operadores",
                this.operadorService.getAll()
        );
    }


    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        Operador operador = new Operador();
        return new ModelAndView("operator/add_edit").addObject("operador", operador);
    }

    @PostMapping("/save")
    public String save(@Valid Operador operador, BindingResult bindingResult, Model model,
    		RedirectAttributes redirectAttrs, Locale locale) {

        if (!bindingResult.hasErrors()) {
    	    operador.setStatus(1);
    	    this.operadorService.save(operador);
    	    redirectAttrs.addFlashAttribute("message", "scascascs");
    	}
        
        return "redirect:/operador/cadastrar";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Long id) {
        Operador operador = this.operadorService.get(id);
        return new ModelAndView("operator/add_edit").addObject("operador", operador);
    }


}
