package com.syscall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.syscall.domain.Cliente;
import com.syscall.domain.Operador;
import com.syscall.repository.ClienteRepository;
import com.syscall.repository.OperadorRepository;

@Service
public class ClienteService {


	    private final ClienteRepository clienteRepository;

	    public  ClienteService(ClienteRepository clienteRepository) {
	        this.clienteRepository = clienteRepository;
	    }
	
	    
	    /**
	     * save
	     * @param operador
	     */
	    public void save(Cliente cliente) {
	        this.clienteRepository.save(cliente);
	    }
	    
	    
	    /**
	     * getAll
	     * @return List<Operador>
	     */
	    public List<Cliente> getAll() {
	        return  this.clienteRepository.findAll();
	    }

	    /**
	     *  get operador
	     * @param id
	     * @return
	     */
	    public Cliente get(Long id) {

	        return this.clienteRepository.findOne(id);
	    }
	
}
