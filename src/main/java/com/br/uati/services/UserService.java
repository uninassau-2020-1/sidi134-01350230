package com.br.uati.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.uati.dto.CepDto;
import com.br.uati.models.User;
import com.br.uati.repositories.UserRepository;

@Service
public class UserService {
	
	private String URL = "https://viacep.com.br/ws/";
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> objUser = userRepository.findById(id);
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
	
	public User updateUser(Integer id, User user) {
		User entity = userRepository.getOne(id);
		updateDados(entity, user);
		return userRepository.save(entity);
	}

	private void updateDados(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setCep(user.getCep());
		entity.setComplemento(user.getComplemento());
		entity.setLogradouro(user.getLogradouro());
		entity.setBairro(user.getBairro());
		entity.setLocalidade(user.getLocalidade());
		entity.setUf(user.getUf());
		entity.setUnidade(user.getUnidade());
		entity.setGia(user.getGia());
	}

}
