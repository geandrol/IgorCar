package com.IgorCar.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private Cliente cliente;
	
	private Carro carro;
	
	private List<Produto> produtos;
	
	private BigDecimal vlrTotalProdutos;
	
	private BigDecimal vlrTotalMaoDeObra;
	
	private BigDecimal vlrTotal;
	
	private Date dataServico;
	
	private Date fimGarantia;

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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
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

	public Date getDataServico() {
		return dataServico;
	}

	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}

	public Date getFimGarantia() {
		return fimGarantia;
	}

	public void setFimGarantia(Date fimGarantia) {
		this.fimGarantia = fimGarantia;
	}
}
