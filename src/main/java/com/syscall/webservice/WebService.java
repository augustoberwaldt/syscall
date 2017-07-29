package com.syscall.webservice;
import com.syscall.domain.Operador;

import java.util.List;
import com.syscall.service.OperadorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/webservice")
public class WebService {

	private final OperadorService operadorService;
	
	WebService(OperadorService operadorService) {
		this.operadorService = operadorService;
	}
	
    @RequestMapping("/getAllOperators")
    public List<Operador> greeting() {
        return  this.operadorService.getAll() ;
    }
	
}
