package com.itau.dados_cadastrais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.itau.dados_cadastrais"})
public class DadosCadastraisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DadosCadastraisApplication.class, args);
	}

}
