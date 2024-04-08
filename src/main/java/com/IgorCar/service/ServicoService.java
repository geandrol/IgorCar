package com.IgorCar.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IgorCar.entity.ProdutoServico;
import com.IgorCar.entity.Servico;
import com.IgorCar.repository.ProdutoServicoRepository;
import com.IgorCar.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ProdutoServicoRepository prodServicoRepository;
	
	public Servico cadastrarServico(Servico servico) {
		
		BigDecimal sumVlrProd = new BigDecimal(0);
		
		for (ProdutoServico prod : servico.getProdutos()) {
			sumVlrProd.add(prod.getProduto().getValorVendal());
		}
		
		servico.setVlrTotalProdutos(sumVlrProd);
		servico.setVlrTotal(sumVlrProd.add(servico.getVlrTotalMaoDeObra()));
	
		
		//Salvar o Sevico
		Servico servicoSalvo = servicoRepository.save(servico);
		
		//Salvar os ProdutosServicos
		for (ProdutoServico prod : servico.getProdutos()) {
			prod.getServico().setId(servicoSalvo.getId());
			
			prodServicoRepository.save(prod);
		}
		
		return servicoRepository
				.findById(servico.getId()).get();
	}

}
