package com.example.apispring.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Membre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idmembre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpersonne", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Personne idpersonne;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idgroupe", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Groupe idgroupe;
	public Integer getIdmembre() {
		return idmembre;
	}
	public void setIdmembre(Integer idmembre) {
		this.idmembre = idmembre;
	}
	public Personne getIdpersonne() {
		return idpersonne;
	}
	public void setIdpersonne(Personne idpersonne) {
		this.idpersonne = idpersonne;
	}
	public Groupe getIdgroupe() {
		return idgroupe;
	}
	public void setIdgroupe(Groupe idgroupe) {
		this.idgroupe = idgroupe;
	}
	
	
	
}
