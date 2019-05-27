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
public class Inscription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idinscription;
	private String certificat;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpersonne", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Personne idpersonne;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idetat", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Etat idetat;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsaison", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Saison idsaison;
	public Integer getIdinscription() {
		return idinscription;
	}
	public void setIdinscription(Integer idinscription) {
		this.idinscription = idinscription;
	}
	public String getCertificat() {
		return certificat;
	}
	public void setCertificat(String certificat) {
		this.certificat = certificat;
	}
	public Personne getIdpersonne() {
		return idpersonne;
	}
	public void setIdpersonne(Personne idpersonne) {
		this.idpersonne = idpersonne;
	}
	public Etat getIdetat() {
		return idetat;
	}
	public void setIdetat(Etat idetat) {
		this.idetat = idetat;
	}
	public Saison getIdsaison() {
		return idsaison;
	}
	public void setIdsaison(Saison idsaison) {
		this.idsaison = idsaison;
	}
	
	
}
