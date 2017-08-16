package com.syscall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.syscall.domain.Cliente;
import com.syscall.domain.Operador;
import com.syscall.repository.ChamadoRepository;
import com.syscall.repository.ClienteRepository;
import com.syscall.repository.OperadorRepository;
import org.json.JSONObject;
@Service
public class ReportService {


	private final ChamadoRepository chamadoRepository;

	ReportService(ChamadoRepository chamadoRepository) {
		this.chamadoRepository = chamadoRepository;
	}
	
	public String reportKindCalls() {
		JSONObject response = new JSONObject();
		this.chamadoRepository.findAll().forEach(item -> {
			
			
		});
		
		return response.toString();
	}
	  
}
