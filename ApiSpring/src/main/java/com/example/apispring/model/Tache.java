package com.example.apispring.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tache {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idtache;
	private String libelletache;
	@ManyToMany
	private Collection<Personne> personne;
	public Integer getIdtache() {
		return idtache;
	}
	public void setIdtache(Integer idtache) {
		this.idtache = idtache;
	}
	public String getLibelletache() {
		return libelletache;
	}
	public void setLibelletache(String libelletache) {
		this.libelletache = libelletache;
	}
	
	
}
