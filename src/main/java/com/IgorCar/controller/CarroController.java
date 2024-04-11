package com.IgorCar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IgorCar.entity.Carro;
import com.IgorCar.repository.CarroRepository;

@RestController
@RequestMapping("/carro")
@CrossOrigin("*")
public class CarroController {

	@Autowired
	private CarroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Carro>> get() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> getById(@PathVariable long id) {
		Optional<Carro> carroExist = repository.findById(id);
		
		if (carroExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.ok(carroExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Carro> post(@RequestBody Carro carro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(carro));
	}

	@PutMapping
	public ResponseEntity<Carro> put (@RequestBody Carro carro) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(carro));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
}