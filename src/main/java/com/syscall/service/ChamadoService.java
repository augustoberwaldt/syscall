package com.syscall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.syscall.domain.Chamado;
import com.syscall.domain.Cliente;
import com.syscall.domain.Operador;
import com.syscall.repository.ChamadoRepository;
import com.syscall.repository.ClienteRepository;
import com.syscall.repository.OperadorRepository;

@Service
public class ChamadoService {


	    private final ChamadoRepository chamadoRepository;

	    public  ChamadoService(ChamadoRepository chamadoRepository) {
	        this.chamadoRepository = chamadoRepository;
	    }
	
	    
	    /**
	     * save
	     * @param chamado
	     */
	    public void save(Chamado chamado) {
	        this.chamadoRepository.save(chamado);
	    }
	    
	    
	    /**
	     * getAll
	     * @return List<Operador>
	     */
	    public List<Chamado> getAll() {
	        return  this.chamadoRepository.findAll();
	    }

	    /**
	     *  get chamado
	     * @param id
	     * @return
	     */
	    public Chamado get(Long id) {

	        return this.chamadoRepository.findOne(id);
	    }
	
}
