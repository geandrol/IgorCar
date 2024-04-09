package com.IgorCar.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IgorCar.Dto.ProdutoServicoDTO;
import com.IgorCar.Dto.ServicoDTO;
import com.IgorCar.entity.Carro;
import com.IgorCar.entity.Cliente;
import com.IgorCar.entity.Produto;
import com.IgorCar.entity.ProdutoServico;
import com.IgorCar.entity.Servico;
import com.IgorCar.repository.ProdutoRepository;
import com.IgorCar.repository.ProdutoServicoRepository;
import com.IgorCar.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ProdutoServicoRepository prodServicoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService prodService;
	
	public Servico cadastrarServico(ServicoDTO servicoDto) {
		
		Double sumVlrProd = 0d;
		Servico servico = new Servico();
		
		for (ProdutoServicoDTO prod : servicoDto.getProdutos()) {
			
			Produto produtoBanco = produtoRepository
					.findById(prod.getIdProduto()).get();
			
			sumVlrProd += Double.parseDouble(produtoBanco.getValorVendal().toString());
			
			if(produtoBanco.getQuantidade() == 0)
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não há este produto em estoque");
			
			prodService.changeQtdProduto(produtoBanco.getId(), (produtoBanco.getQuantidade() - 1));
		}
		
		servico.setDescricao(servicoDto.getDescricao());
		
		Cliente cliente = new Cliente();
		cliente.setId(servicoDto.getClienteId());
		servico.setCliente(cliente);
		
		Carro carro = new Carro();
		carro.setId(servicoDto.getCarroId());
		servico.setCarro(carro);
		
		servico.setVlrTotalProdutos(new BigDecimal(sumVlrProd));
		
		BigDecimal varFinal = new BigDecimal((sumVlrProd 
				+ Double.parseDouble(servicoDto.getVlrTotalMaoDeObra().toString())));
		
		servico.setVlrTotal(varFinal);
	
		servico.setFimGarantia(servicoDto.getFimGarantia());
		servico.setVlrTotalMaoDeObra(servicoDto.getVlrTotalMaoDeObra());
		//Salvar o Sevico
		Servico servicoSalvo = servicoRepository.save(servico);
		
		//Salvar os ProdutosServicos
		for (ProdutoServicoDTO prod : servicoDto.getProdutos()) {
			Produto produto = new Produto();
			produto.setId(prod.getIdProduto());
			
			ProdutoServico prodServico = new ProdutoServico();
			prodServico.setProduto(produto);
			prodServico.setServico(servicoSalvo);
			
			prodServicoRepository.save(prodServico);
		}
		
		return servicoRepository
				.findById(servico.getId()).get();
	}

}
