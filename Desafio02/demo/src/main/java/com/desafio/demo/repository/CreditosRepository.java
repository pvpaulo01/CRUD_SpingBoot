package com.desafio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.demo.model.Creditos;

@Repository
public interface CreditosRepository extends JpaRepository<Creditos, Integer>{
    
}
