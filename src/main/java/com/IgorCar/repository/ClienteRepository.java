package com.IgorCar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IgorCar.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente , Long>{

}
