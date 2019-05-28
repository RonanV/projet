package com.example.apispring.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tache{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idtache;
	private String libelletache;
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Personne> personne = new HashSet<Personne>();
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
	public Set<Personne> getPersonne() {
		return personne;
	}
	public void setPersonne(Set<Personne> personne) {
		this.personne = personne;
	}	
	
}
