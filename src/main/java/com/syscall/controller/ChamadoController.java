package com.syscall.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syscall.config.Messages;
import com.syscall.domain.Chamado;
import com.syscall.domain.Cliente;
import com.syscall.service.ChamadoService;
import com.syscall.service.ClienteService;

@Controller
@RequestMapping("/call")
public class ChamadoController {

	private final ChamadoService chamadoService;


    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService =  chamadoService;

    }
	
	
    @GetMapping("/")
    public ModelAndView report() {
        return  new  ModelAndView("call/index");
    }

    
    @GetMapping("/create")
    public ModelAndView create() {
        return  new  ModelAndView("call/add_edit").addObject("chamado", new Chamado());
    }

    @PostMapping("/save")
    public String save(@Valid Chamado chamado,
					   BindingResult bindingResult,
    		           RedirectAttributes redirectAttrs, Locale locale) {

        if (!bindingResult.hasErrors()) {
        	chamado.setStatus(1);
			this.chamadoService.save(chamado);
    	    redirectAttrs.addFlashAttribute("message", Messages.get("messages.save", locale));
    	}
        
        return "redirect:/call/create";
    }
}
