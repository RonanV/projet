package com.example.apispring.jointure;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.example.apispring.model.Personne;
import com.example.apispring.model.Tache;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class tache_personne {
	
	@EmbeddedId
	private tache_personne_key id = new tache_personne_key();
   
	public tache_personne() {
		super();
	}

	public tache_personne(tache_personne_key id, Tache tache, Personne personne, String detail) {
		super();
		this.id = id;
		this.tache = tache;
		this.personne = personne;
		this.detail = detail;
	}


	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("idtache")
	@JoinColumn(name = "idtache")
	@JsonIgnoreProperties("personne")
    private Tache tache;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("idpersonne")
	@JoinColumn(name = "idpersonne")
	@JsonIgnoreProperties("tache")
	private Personne personne;
	private String detail;
	
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
