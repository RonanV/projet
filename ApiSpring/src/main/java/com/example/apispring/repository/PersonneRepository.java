package com.example.apispring.repository;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.apispring.model.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Integer>{

	Personne findByNumlicence(String numlicence);
	List<Personne> findByNomPersonneContainingOrPrenomPersonneContainingOrEmailPersonneContaining(String nomPersonne,
			String prenomPersonne, String emailPersonne);
	Personne findByNomPersonneAndPrenomPersonne(String nomPersonne, String prenomPersonne);
	
	Personne findByLoginPersonne(String loginPersonne);
}
