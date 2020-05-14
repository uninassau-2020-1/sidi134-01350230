package com.br.uninassau.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.uninassau.models.User;
import com.br.uninassau.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> listaUser = userService.findAll();
		return ResponseEntity.ok().body(listaUser);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id){
		User objUser = userService.findById(id);
		return ResponseEntity.ok().body(objUser);
	}
	
	@PostMapping
	public ResponseEntity<User> insertUsers(@RequestBody User objUser) {
		objUser = userService.insertUsers(objUser);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(objUser.getId()).toUri();
		return ResponseEntity.created(uri).body(objUser);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id,
			@RequestBody User user) {
		user = userService.updateUser(id, user);
		return ResponseEntity.ok().body(user);
	}
}