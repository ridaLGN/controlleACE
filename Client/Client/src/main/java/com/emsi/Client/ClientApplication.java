package com.emsi.Client;

import com.emsi.Client.entites.Client;
import com.emsi.Client.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	CommandLineRunner initialize(ClientRepository clientRepository){
		return args -> {
			clientRepository.save(new Client(Integer.parseInt("1"),"Imane",Float.parseFloat("23")));
			clientRepository.save(new Client(Integer.parseInt("2"),"Imane1",Float.parseFloat("23")));
			clientRepository.save(new Client(Integer.parseInt("3"),"Imane2",Float.parseFloat("23")));

		};
	}
}
