package com.syscall.repository;

import com.syscall.domain.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by harley on 27/05/2017.
 */
@Repository
public  interface  OperadorRepository  extends JpaRepository<Operador, Long> {

    Optional<Operador> findByEmail(String username);
    Operador findOneByEmail(String email);
    Operador findOneById(Long id);

}
