package com.IgorCar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_carro")
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Atributo título é Obrigatório!") // Exclusivo para String
	@Size(min = 5, max = 100, message = "O atributo título deve ter no minimo 05 e no máximo 100 caracteres")
	private String placa;

	@NotBlank(message = "O Atributo título é Obrigatório!") // Exclusivo para String
	@Size(min = 1, max = 100, message = "O atributo título deve ter no minimo 05 e no máximo 100 caracteres")
	private String modelo;
	
	@ManyToOne
	@JsonIgnoreProperties("carros")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModele(String modelo) {
		this.modelo = modelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
