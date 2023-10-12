package com.example.crud1.frontend.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud1.frontend.model.Pessoa;
import com.example.crud1.frontend.repositories.PessoaRepository;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaResource {
    
    private PessoaRepository pessoaRepository;

    public PessoaResource(PessoaRepository pessoaRepository) {
        super();
        this.pessoaRepository = pessoaRepository;
    }
    //Arqui temos o C do nosso CRUD
    //ou seja temos o CREATE, no spring é o save
    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
        pessoaRepository.save(pessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    //Arqui temos o R do nosso CRUD
    //neste caso temos o RETRIEVED de todos
    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll(){
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas = pessoaRepository.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    //Arqui temos o R do nosso CRUD
    //neste caso temos o RETRIEVED de apenas 1
    @GetMapping(path="/{id}")
    public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Integer id){
        Optional<Pessoa> pessoa;
        try {
            pessoa = pessoaRepository.findById(id);
            return new ResponseEntity<Optional<Pessoa>>(pessoa, HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Pessoa>>(HttpStatus.NOT_FOUND);
        }
    }

    //aqui teremos o D do nosso CRUD


    //aqui teremos o U do nosso CRUD

    
}
