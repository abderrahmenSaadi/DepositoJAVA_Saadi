package com.example.mohamed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.mohamed.service.ProdottoService;

@SpringBootApplication
public class MohamedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MohamedApplication.class, args);

		
	}
	@Bean
    public CommandLineRunner avvia(ProdottoService prodottoService) {
        return args -> {
            prodottoService.stampaCatalogo(20); // Applica sconto del 20%
        };
    }

}
