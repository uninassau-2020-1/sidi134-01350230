package com.br.uati.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.br.uati.models.User;
import com.br.uati.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User user = new User(null, "Fernando Araújo", "fernando@email.com", "50060-070", "", "Rua Sete de Setembro",
				"Boa Vista", "Recife", "PE", "", "2611606", "");
		
		List<User> listaUser = new ArrayList<User>();
		listaUser.add(user);
		
		userRepository.saveAll(Arrays.asList(user));

	}

}