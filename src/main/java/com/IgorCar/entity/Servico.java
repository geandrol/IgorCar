package com.IgorCar.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Atributo título é Obrigatório!") // Exclusivo para String
	@Size(min = 2, max = 100, message = "O atributo título deve ter no minimo 05 e no máximo 100 caracteres")
	private String descricao;
	
	@ManyToOne
	@JsonIgnoreProperties("servicos")
	private Cliente cliente;
	
	@ManyToOne
	@JsonIgnoreProperties("cliente")
	private Carro carro;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "servico", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"servico"})
	private List<ProdutoServico> produtos;
	
    //Cadastrado via service
	private BigDecimal vlrTotalProdutos;
	
	@Min(value = 0, message = "O valor não pode ser menor do que 0")
	private BigDecimal vlrTotalMaoDeObra;
	
	//Cadastrado via service
	private BigDecimal vlrTotal;
	
	@UpdateTimestamp
	private LocalDate data;
	
	private LocalDate fimGarantia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<ProdutoServico> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoServico> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getVlrTotalProdutos() {
		return vlrTotalProdutos;
	}

	public void setVlrTotalProdutos(BigDecimal vlrTotalProdutos) {
		this.vlrTotalProdutos = vlrTotalProdutos;
	}

	public BigDecimal getVlrTotalMaoDeObra() {
		return vlrTotalMaoDeObra;
	}

	public void setVlrTotalMaoDeObra(BigDecimal vlrTotalMaoDeObra) {
		this.vlrTotalMaoDeObra = vlrTotalMaoDeObra;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDate getFimGarantia() {
		return fimGarantia;
	}

	public void setFimGarantia(LocalDate fimGarantia) {
		this.fimGarantia = fimGarantia;
	}

}
