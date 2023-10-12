package com.example.crud1.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud1.frontend.model.Pessoa;
import com.example.crud1.frontend.repositories.PessoaRepository;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RestController
public class Crud1Application {

	private static final Logger log = LoggerFactory.getLogger(Crud1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Crud1Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(PessoaRepository repository) {
		return (args) -> {
			// salvando as pessoas
			repository.save(new Pessoa("Jack", 10));
			repository.save(new Pessoa("Chloe", 20));

			// selecionando as pessoas
			log.info("pessoas:");
			log.info("----------------------------------------------------");
			for (Pessoa pessoa : repository.findAll()) {
				log.info(pessoa.toString());
			}
			log.info("");
		};
	}
}
