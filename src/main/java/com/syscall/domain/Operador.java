package com.syscall.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.Set;
import com.syscall.domain.Cliente;
import static javax.persistence.TemporalType.TIMESTAMP;

@Entity
public class Operador {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    private Date data;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    private String senha;

    @OneToMany
    private Set<Cliente> Cliente;

    private int status;
    
    @NotNull
    private boolean ativo;
    

    public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@NotNull
    private String grupo;

    private String foto;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Set<Cliente> getCliente() {
        return Cliente;
    }

    public void setCliente(Set<Cliente> cliente) {
        Cliente = cliente;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
