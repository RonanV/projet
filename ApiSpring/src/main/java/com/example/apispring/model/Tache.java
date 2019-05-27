package com.example.apispring.model;

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

@Entity
public class Tache {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idtache;
	private String libelletache;
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="tache_personne",
				joinColumns= {@JoinColumn(name="idtache")},
				inverseJoinColumns= {@JoinColumn(name="idpersonne")})
	private Set<Personne> personne;
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
