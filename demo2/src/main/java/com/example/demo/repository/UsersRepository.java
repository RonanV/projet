package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.users;

public interface UsersRepository extends CrudRepository<users, Integer> {

}
