package com.syscall.repository;

import com.syscall.domain.Chamado;
import com.syscall.domain.Cliente;
import com.syscall.domain.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by harley on 27/05/2017.
 */
@Repository
public  interface  ChamadoRepository  extends JpaRepository<Chamado, Long> {

	
	List <Chamado> findAllByOperador_Id(Long idUser);
	
}
