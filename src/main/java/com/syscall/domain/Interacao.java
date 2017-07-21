package com.syscall.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Interacao {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne	
    private Chamado chamado;      
    
    
	public Chamado getChamado() {
		return chamado;
	}


	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	
    
}
