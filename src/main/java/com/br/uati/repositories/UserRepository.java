package com.br.uati.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.uati.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
