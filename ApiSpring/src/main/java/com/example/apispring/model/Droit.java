package com.example.apispring.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Droit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer iddroit;
	private String libelledroit;
	@ManyToMany
	private Collection<Personne> personne;
	public Integer getIddroit() {
		return iddroit;
	}
	public void setIddroit(Integer iddroit) {
		this.iddroit = iddroit;
	}
	public String getLibelledroit() {
		return libelledroit;
	}
	public void setLibelledroit(String libelledroit) {
		this.libelledroit = libelledroit;
	}
	public Collection<Personne> getPersonne() {
		return personne;
	}
	public void setPersonne(Collection<Personne> personne) {
		this.personne = personne;
	}
	
	
	
}
