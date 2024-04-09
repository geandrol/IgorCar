package com.IgorCar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IgorCar.Dto.ServicoDTO;
import com.IgorCar.entity.Servico;
import com.IgorCar.repository.ServicoRepository;
import com.IgorCar.service.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ServicoRepository repository;
	
	@Autowired
	private ServicoService service;
	
	@GetMapping
	public ResponseEntity<List<Servico>> get() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Servico> getById(@PathVariable long id) {
		Optional<Servico> servicoExist = repository.findById(id);
		
		if (servicoExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(servicoExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Servico> post(@RequestBody ServicoDTO servico) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(service.cadastrarServico(servico));
	}

	@PutMapping
	public ResponseEntity<Servico> put (@RequestBody Servico servico) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(servico));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}