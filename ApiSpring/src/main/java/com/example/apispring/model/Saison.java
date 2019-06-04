package com.example.apispring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Saison {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idsaison;
	
	private String libellesaison;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Personne> personne = new HashSet<Personne>();
	
	public Integer getIdsaison() {
		return idsaison;
	}
	public void setIdsaison(Integer idsaison) {
		this.idsaison = idsaison;
	}
	public String getLibellesaison() {
		return libellesaison;
	}
	public void setLibellesaison(String libellesaison) {
		this.libellesaison = libellesaison;
	}
	public Set<Personne> getPersonne() {
		return personne;
	}
	public void setPersonne(Set<Personne> personne) {
		this.personne = personne;
	}
	
	
	
}
