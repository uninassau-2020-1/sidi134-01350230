package com.br.uninassau.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.uninassau.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
