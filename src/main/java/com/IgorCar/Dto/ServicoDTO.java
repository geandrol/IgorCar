package com.IgorCar.Dto;

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

public class ServicoDTO {

	private String descricao;
	
	private Long clienteId;
	
	private Long carroId;
	
	private List<ProdutoServicoDTO> produtos;
	
	private BigDecimal vlrTotalMaoDeObra;
	
	private LocalDate fimGarantia;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getCarroId() {
		return carroId;
	}

	public void setCarroId(Long carroId) {
		this.carroId = carroId;
	}

	public List<ProdutoServicoDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoServicoDTO> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getVlrTotalMaoDeObra() {
		return vlrTotalMaoDeObra;
	}

	public void setVlrTotalMaoDeObra(BigDecimal vlrTotalMaoDeObra) {
		this.vlrTotalMaoDeObra = vlrTotalMaoDeObra;
	}

	public LocalDate getFimGarantia() {
		return fimGarantia;
	}

	public void setFimGarantia(LocalDate fimGarantia) {
		this.fimGarantia = fimGarantia;
	}
}
