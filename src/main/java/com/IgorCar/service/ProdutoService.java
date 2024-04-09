package com.IgorCar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.IgorCar.entity.Produto;
import com.IgorCar.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository prodRepository;
	
	public Produto changeQtdProduto (long idProd, int qtd) {
		Optional<Produto> prod = prodRepository.findById(idProd);
		
		if (prod.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não localizado!");
		
		prod.get().setQuantidade(qtd);
		
		return prodRepository.save(prod.get());
		
	}
	

}
