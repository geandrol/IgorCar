package com.IgorCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IgorCar.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria , Long>{

}
