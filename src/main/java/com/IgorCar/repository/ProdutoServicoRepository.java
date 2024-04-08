package com.IgorCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IgorCar.entity.ProdutoServico;

@Repository
public interface ProdutoServicoRepository extends JpaRepository<ProdutoServico , Long>{

}
