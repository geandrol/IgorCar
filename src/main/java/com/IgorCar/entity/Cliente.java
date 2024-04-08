package com.IgorCar.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Atributo título é Obrigatório!") // Exclusivo para String
	@Size(min = 1, max = 100, message = "O atributo título deve ter no minimo 05 e no máximo 100 caracteres")
	private String nome;
	
	@NotBlank(message = "O Atributo título é Obrigatório!") // Exclusivo para String
	@Size(min = 5, max = 100, message = "O atributo título deve ter no minimo 05 e no máximo 100 caracteres")
	private String contato;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("cliente")
	private List<Carro> carros;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("cliente")
	private List<Servico> servicos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
}
