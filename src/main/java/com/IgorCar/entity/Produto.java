package com.IgorCar.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Atributo título é Obrigatório!") // Exclusivo para String
	@Size(min = 1, max = 100, message = "O atributo título deve ter no minimo 05 e no máximo 100 caracteres")
	private String nome;
	
	private String Descricao;
	
	@NotBlank(message = "O Atributo título é Obrigatório!") // Exclusivo para String
	@Size(min = 1, max = 100, message = "O atributo título deve ter no minimo 05 e no máximo 100 caracteres")
	private String marca;
	
	@NotBlank(message = "O Atributo título é Obrigatório!") // Exclusivo para String
	@Size(min = 1, max = 100, message = "O atributo título deve ter no minimo 05 e no máximo 100 caracteres")
	private String modelo;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;
	
	@Min(value = 0, message = "O valor não pode ser menor do que 0")
	private Integer quantidade;
	
	@Min(value = 0, message = "O valor não pode ser menor do que 0")
	private BigDecimal valorCusto;
	
	@Min(value = 0, message = "O valor não pode ser menor do que 0")
	private BigDecimal valorVendal;

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

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(BigDecimal valorCusto) {
		this.valorCusto = valorCusto;
	}

	public BigDecimal getValorVendal() {
		return valorVendal;
	}

	public void setValorVendal(BigDecimal valorVendal) {
		this.valorVendal = valorVendal;
	}
}

