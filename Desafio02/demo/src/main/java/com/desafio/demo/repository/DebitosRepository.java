package com.desafio.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.desafio.demo.model.Debitos;

@Repository
public interface DebitosRepository extends JpaRepository<Debitos, Integer>{
    
}
