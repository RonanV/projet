package com.example.apispring.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.apispring.model.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Integer>{

}
