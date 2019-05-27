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
public class Droit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer iddroit;
	private String libelledroit;
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="droit_personne",
				joinColumns= {@JoinColumn(name="iddroit")},
				inverseJoinColumns= {@JoinColumn(name="idpersonne")})
	private Set<Personne> personne;
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
	public Set<Personne> getPersonne() {
		return personne;
	}
	public void setPersonne(Set<Personne> personne) {
		this.personne = personne;
	}
	
	
	
}
