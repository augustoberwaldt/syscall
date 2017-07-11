package com.syscall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/call")
public class ChamadoController {

    @GetMapping("/")
    public ModelAndView report() {
        return  new  ModelAndView("call/index");
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return  new  ModelAndView("call/add_edit");
    }

}
