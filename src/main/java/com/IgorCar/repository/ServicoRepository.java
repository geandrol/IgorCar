package com.IgorCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IgorCar.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico , Long>{

}
