package com.IgorCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IgorCar.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto , Long>{

}
