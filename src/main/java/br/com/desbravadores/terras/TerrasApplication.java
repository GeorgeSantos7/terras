package br.com.desbravadores.terras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "br.com.desbravadores.terras.credencial.infra")
public class TerrasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerrasApplication.class, args);
	}

}
