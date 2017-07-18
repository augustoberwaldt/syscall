package com.syscall.controller;

import java.security.Principal;
import java.util.Locale;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syscall.config.Messages;
import com.syscall.domain.Chamado;
import com.syscall.domain.Cliente;
import com.syscall.domain.Operador;
import com.syscall.service.AccountUserDetailsService;
import com.syscall.service.ChamadoService;
import com.syscall.service.ClienteService;

@Controller
@RequestMapping("/call")
public class ChamadoController {

	private final ChamadoService chamadoService;

	private final ClienteService clienteService;
	
	private final AccountUserDetailsService accountUserDetailsService;
	
	public ChamadoController(ChamadoService chamadoService,
			ClienteService clienteService,
			AccountUserDetailsService accountUserDetailsService) {
        this.chamadoService =  chamadoService;
        this.clienteService =  clienteService;
        
        this.accountUserDetailsService =  accountUserDetailsService;
    }
	
	
    @GetMapping("/")
    public ModelAndView report() {
        return  new  ModelAndView("call/index").addObject("chamados", this.chamadoService.getAll());
    }

    
    @GetMapping("/create")
    public ModelAndView create() {
        return  new  ModelAndView("call/add_edit").addObject("chamado", new Chamado());
    }

    @PostMapping("/save")
    public String save(@Valid Chamado chamado,
					   BindingResult bindingResult,
    		           RedirectAttributes redirectAttrs,
    		           Locale locale, Principal  principal) {

    	
        if (!bindingResult.hasErrors()) {
        	
        	Operador operador =  accountUserDetailsService.getUserByUserName(
        			principal.getName()
        	);
        	
        	chamado.setStatus(1);
        	
        	chamado.setOperador(operador);
        	chamado.setCliente(
        			operador.getCliente()
        	);
        	
			this.chamadoService.save(chamado);
    	    redirectAttrs.addFlashAttribute("message", Messages.get("messages.save", locale));
    	}
        
        return "redirect:/call/create";
    }
    
    
    @RequestMapping("/edit/{id}")
	 public ModelAndView update(@PathVariable Long id) {
		 Chamado chamado = this.chamadoService.get(id);
	     return new ModelAndView("call/add_edit").addObject("chamado", chamado);
	 }
    
    
   
    
    
}
