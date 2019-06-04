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
import javax.persistence.OneToMany;

import com.example.apispring.jointure.tache_personne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Tache{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idtache;
	
	private String libelletache;
	
	@OneToMany(mappedBy = "tache", cascade = CascadeType.ALL)
	private Set<tache_personne> personne = new HashSet<tache_personne>();
	
	public Tache() {
		super();
	}
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
	public Set<tache_personne> getPersonne() {
		return personne;
	}
	public void setPersonne(Set<tache_personne> personne) {
		this.personne = personne;
	}	
	
}
