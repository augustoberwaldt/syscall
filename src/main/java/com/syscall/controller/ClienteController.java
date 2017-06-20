package com.syscall.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import javax.validation.Valid;

import com.syscall.config.Messages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    public String save(@Valid Cliente cliente,
					   BindingResult bindingResult,
    		           RedirectAttributes redirectAttrs, Locale locale) {

        if (!bindingResult.hasErrors()) {
			cliente.setStatus(1);
    	    this.clienteService.save(cliente);
    	    redirectAttrs.addFlashAttribute("message", Messages.get("messages.save", locale));
    	}
        
        return "redirect:/customer/cadastrar";
    }
	
	@RequestMapping("/edit/{id}")
	 public ModelAndView update(@PathVariable Long id) {
		 Cliente cliente = this.clienteService.get(id);
	     return new ModelAndView("customer/add_edit").addObject("cliente", cliente);
	 }
}
