package com.syscall.domain;

import java.util.Date;

import javax.persistence.Column;
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
   
    @Column(columnDefinition="LONGVARCHAR")
    private String comentario;      
    
    @ManyToOne
    private Operador operador;      
    
   
	private Date data;
    
	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Operador getOperador() {
		return operador;
	}


	public void setOperador(Operador operador) {
		this.operador = operador;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}

	
    
}
