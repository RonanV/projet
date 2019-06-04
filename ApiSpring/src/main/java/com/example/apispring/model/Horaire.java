package com.example.apispring.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Horaire {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idhoraire;
	
	private String libellehoraire;
	private String jour_horaire;
	private String heuredebut;
	private String heurefin;
	
	@ManyToMany(mappedBy="horaire")
	private Set<Groupe> groupe;
	
	public Integer getIdhoraire() {
		return idhoraire;
	}
	public void setIdhoraire(Integer idhoraire) {
		this.idhoraire = idhoraire;
	}
	public String getLibellehoraire() {
		return libellehoraire;
	}
	public void setLibellehoraire(String libellehoraire) {
		this.libellehoraire = libellehoraire;
	}
	public String getJour_horaire() {
		return jour_horaire;
	}
	public void setJour_horaire(String jour_horaire) {
		this.jour_horaire = jour_horaire;
	}
	public String getHeuredebut() {
		return heuredebut;
	}
	public void setHeuredebut(String heuredebut) {
		this.heuredebut = heuredebut;
	}
	public String getHeurefin() {
		return heurefin;
	}
	public void setHeurefin(String heurefin) {
		this.heurefin = heurefin;
	}
	public Set<Groupe> getGroupe() {
		return groupe;
	}
	public void setGroupe(Set<Groupe> groupe) {
		this.groupe = groupe;
	}
	
	
}
