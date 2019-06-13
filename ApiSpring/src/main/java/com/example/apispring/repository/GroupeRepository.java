package com.example.apispring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.apispring.model.Groupe;

public interface GroupeRepository extends CrudRepository<Groupe, Integer>{

	@Query("SELECT g from Groupe g")
	List<Groupe> findAllGroupe();
}
