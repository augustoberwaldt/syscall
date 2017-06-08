package com.syscall.service;

import com.syscall.domain.Operador;
import com.syscall.repository.OperadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by harley on 28/05/2017.
 */
@Service
public class OperadorService {

    private final OperadorRepository operadorRepository;

    public  OperadorService(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }

    /**
     * save
     * @param operador
     */
    public void save(Operador operador) {
        this.operadorRepository.save(operador);
    }

    /**
     * getAll
     * @return List<Operador>
     */
    public List<Operador> getAll() {
        return  this.operadorRepository.findAll();
    }

    /**
     *  get operador
     * @param id
     * @return
     */
    public Operador get(Long id) {

        return this.operadorRepository.findOneById(id);
    }
}
