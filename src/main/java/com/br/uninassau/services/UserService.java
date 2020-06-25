package com.br.uninassau.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.uninassau.dto.CepDto;
import com.br.uninassau.models.User;
import com.br.uninassau.repositories.UserRepository;

@Service
public class UserService {

	private String URL = "https://viacep.com.br/ws/";

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Integer id) {
		Optional<User> objUser = userRepository.findById(id);
		return objUser.get();
	}
	
	public User findByCep(String cep) {
		Optional<User> objUser = userRepository.findByCep(cep);
		return objUser.get();
	}

	public User insertUsers(User objUser) {
		RestTemplate restTemplate = new RestTemplate();

		CepDto cepDto = restTemplate.getForObject(URL + objUser.getCep() + "/json", CepDto.class);
		objUser.setLogradouro(cepDto.getLogradouro());
		objUser.setComplemento(cepDto.getComplemento());
		objUser.setBairro(cepDto.getBairro());
		objUser.setLocalidade(cepDto.getLocalidade());
		objUser.setUf(cepDto.getUf());
		objUser.setUnidade(cepDto.getUnidade());
		objUser.setIbge(cepDto.getIbge());
		objUser.setGia(cepDto.getGia());

		return userRepository.save(objUser);
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	public User updateUser(Integer id, User objUser) {
		User entity = userRepository.getOne(id);
		updateDados(entity, objUser);
		return userRepository.save(entity);
	}

	private void updateDados(User entity, User objUser) {
		entity.setName(objUser.getName());
		entity.setEmail(objUser.getEmail());
		entity.setCep(objUser.getCep());
		
		RestTemplate restTemplate = new RestTemplate();

		CepDto cepDto = restTemplate.getForObject(URL + objUser.getCep() + "/json", CepDto.class);
		entity.setLogradouro(cepDto.getLogradouro());
		entity.setComplemento(cepDto.getComplemento());
		entity.setBairro(cepDto.getBairro());
		entity.setLocalidade(cepDto.getLocalidade());
		entity.setUf(cepDto.getUf());
		entity.setUnidade(cepDto.getUnidade());
		entity.setIbge(cepDto.getIbge());
		entity.setGia(cepDto.getGia());
	}
}