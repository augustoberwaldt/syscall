package com.syscall.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syscall.domain.Cliente;
import com.syscall.domain.Operador;
import com.syscall.service.ClienteService;
import com.syscall.service.OperadorService;

@Controller
@RequestMapping("/customer")
public class ClienteController {
	
	
   private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService =  clienteService;

    }
	
	@GetMapping("/")
	public ModelAndView report() {
		return new ModelAndView("customer/index").addObject(
                "clientes",
                this.clienteService.getAll()
        );
	}
	
	
	@GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        Cliente cliente = new Cliente();
        return new ModelAndView("customer/add_edit").addObject("cliente", cliente);
    }

	@PostMapping("/save")
    public String save(@Valid Cliente cliente, BindingResult bindingResult, Model model,
    		RedirectAttributes redirectAttrs, Locale locale) {

        if (!bindingResult.hasErrors()) {
        	cliente.setStatus(1);
    	    this.clienteService.save(cliente);
    	    redirectAttrs.addFlashAttribute("message", "scascascs");
    	}
        
        return "redirect:/customer/cadastrar";
    }
	
	@RequestMapping("/edit/{id}")
	 public ModelAndView update(@PathVariable Long id) {
		 Cliente cliente = this.clienteService.get(id);
	     return new ModelAndView("customer/add_edit").addObject("cliente", cliente);
	 }
}
