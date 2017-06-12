package com.syscall.repository;

import com.syscall.domain.Cliente;
import com.syscall.domain.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by harley on 27/05/2017.
 */
@Repository
public  interface  ClienteRepository  extends JpaRepository<Cliente, Long> {

    Operador findOneByEmail(String email);

}
