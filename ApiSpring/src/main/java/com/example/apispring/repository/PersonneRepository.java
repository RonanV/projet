package com.example.apispring.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.apispring.model.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Integer>{

	Personne findByNumlicence(String numlicence);
	List<Personne> findByNomPersonneContainingOrPrenomPersonneContainingOrEmailPersonneContaining(String nomPersonne,
			String prenomPersonne, String emailPersonne);

	Personne findById(int id);
}
