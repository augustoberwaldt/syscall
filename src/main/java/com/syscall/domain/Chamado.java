package com.syscall.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Chamado {

    @Id
    @GeneratedValue
    private Long id;

    private String assunto;
    
    private String descricao;
    
    private int  tipo;
    
    @ManyToOne
    private Operador criador;
    
    
    @ManyToOne
    private Operador responsavel;
    
    @ManyToOne
    private Cliente  cliente;
    
    private Date data;
    
    private int status;
    
    
    
    public Operador getCriador() {
		return criador;
	}

	public void setCriador(Operador criador) {
		this.criador = criador;
	}

	@OneToMany(cascade = {CascadeType.ALL})
    private List<Interacao> interacoes;

   
	public List<Interacao> getInteracoes() {
		return interacoes;
	}

	public void setInteracoes(List<Interacao> interacoes) {
		this.interacoes = interacoes;
	}

	public Operador getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Operador responsavel) {
		this.responsavel = responsavel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		tipo = tipo;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	
    
}
