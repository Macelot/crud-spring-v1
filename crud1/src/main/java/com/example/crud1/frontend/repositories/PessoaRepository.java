package com.example.crud1.frontend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud1.frontend.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    
}
