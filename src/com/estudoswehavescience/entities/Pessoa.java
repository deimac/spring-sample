package com.estudoswehavescience.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.estudoswehavescience.util.StringUtils;

@Entity
@Table(name = "pessoas")
public class Pessoa {
	private Long id;
	private String nome;
	private Integer idade;
	private String email;
	private String informacoes;

	@Id
	@GeneratedValue
	@Column(name = "pessoas_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "pessoas_nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "pessoas_idade")
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Column(name = "pessoas_email", unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "pessoas_informacoes")
	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	@Transient
	public void validate() {
		if (StringUtils.isEmptyOrNull(getEmail())) {
			throw new IllegalArgumentException(
					"É necessário preencher todos os campos");
		}
		if (StringUtils.isEmptyOrNull(getNome())) {
			throw new IllegalArgumentException(
					"É necessário preencher todos os campos");
		}
		if (StringUtils.isEmptyOrNull(getInformacoes())) {
			throw new IllegalArgumentException(
					"É necessário preencher todos os campos");
		}
		if (getIdade() == 0 || StringUtils.isEmptyOrNull(getIdade().toString())) {
			throw new IllegalArgumentException(
					"É necessário preencher todos os campos");
		}
		
		if (getIdade() < 18) {
			throw new IllegalArgumentException(
					"Você não pode realizar o cadastro pois você não possui 18 anos");
		}
	}
}