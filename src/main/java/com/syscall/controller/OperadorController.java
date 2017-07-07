package com.syscall.controller;

import com.syscall.config.Messages;
import com.syscall.domain.Operador;
import com.syscall.service.ClienteService;
import com.syscall.service.OperadorService;
import com.syscall.service.UploadService;

import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StringMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

@Controller
@RequestMapping("/operador")
public class OperadorController {

    private final OperadorService operadorService;

    private final ClienteService clienteService;

    private final UploadService uploadService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringMultipartFileEditor());
    }

    public OperadorController(OperadorService operadorService,
                              ClienteService clienteService,
                              UploadService uploadService) {
        this.operadorService =  operadorService;
        this.clienteService  =  clienteService;
        this.uploadService   =  uploadService;

    }

    @GetMapping("/")
    public ModelAndView listagem() {

        return new ModelAndView("operator/index").addObject(
                "operadores",
                this.operadorService.getAll()
        );
    }

    @GetMapping("/perfil/{id}")
    public ModelAndView perfil(@PathVariable Long id) {
        return new ModelAndView("operator/profile").addObject("id", id);
    }

    @PostMapping(value="/perfil/save",  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String save(@RequestParam("current_password") String current_password,
    		           @RequestParam("new_password") String new_password,
    		           @RequestParam("confirmation_password") String confirmation_password,
    		           @RequestParam("id")  Long id,  RedirectAttributes redirectAttrs) {

    	Operador operador =  this.operadorService.get(id);   
    	
    	String encrypt_current_passowd = new  BCryptPasswordEncoder().encode(current_password); 
    	if (new_password.equalsIgnoreCase(confirmation_password) ) {
    		operador.setSenha(new BCryptPasswordEncoder().encode(new_password));
    		this.operadorService.save(operador);
     	    redirectAttrs.addFlashAttribute("message", "cascascascascasc");
    	}
    	

        return "redirect:/operador/perfil/" + id ;
    }


    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        Operador operador = new Operador();
        return new ModelAndView("operator/add_edit")
        		   .addObject("operador", operador)
        		   .addObject("clientes", this.clienteService.getAll());
    }

    @PostMapping("/save")
    public String save(@RequestParam("foto") MultipartFile file, @Valid Operador operador, BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttrs, Locale locale) {


        String url = "";
        if (operador.getId() == null) {
            url = "redirect:/operador/cadastrar";
        } else {
            url =  "redirect:/operador/edit/"+ operador.getId();
        }

       if (!bindingResult.hasErrors()) {
            String foto = uploadService.process(file);
    	    operador.setStatus(1);
            operador.setFoto(foto);
    	    this.operadorService.save(operador);
    	    redirectAttrs.addFlashAttribute("message", Messages.get("messages.save", locale));
    	}


        return url;


    }

    @RequestMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Long id) {
        Operador operador = this.operadorService.get(id);
        return new ModelAndView("operator/add_edit").addObject("operador", operador);
    }


    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
        Operador operador = this.operadorService.get(id);
        if (operador != null) {
            operador.setStatus(0);
            this.operadorService.save(operador);
            redirectAttrs.addFlashAttribute("message",  Messages.get("messages.delete", locale));
        }

        return "redirect:/operador/";
    }

}
