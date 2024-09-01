package br.com.eurotech.treinamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.eurotech.treinamentos.firebase.config.FirebaseConfig;

@SpringBootApplication
public class TreinamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentosApplication.class, args);
	}
	
}