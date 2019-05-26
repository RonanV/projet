package com.example.apispring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idpersonne;
	private String nom_Personne;
	private String prenom_Personne;
	private String telephone;
	private String rue_Personne;
	private String codepostal_Personne;
	private String ville_Personne;
	private String email_Personne;
	private String telephonepere;
	private String telephonemere;
	private String datenaissance_Personne;
	private String numlicence;
	
	
	public Integer getIdpersonne() {
		return idpersonne;
	}
	public void setIdpersonne(Integer idpersonne) {
		this.idpersonne = idpersonne;
	}
	public String getNom_Personne() {
		return nom_Personne;
	}
	public void setNom_Personne(String nom_Personne) {
		this.nom_Personne = nom_Personne;
	}
	public String getPrenom_Personne() {
		return prenom_Personne;
	}
	public void setPrenom_Personne(String prenom_Personne) {
		this.prenom_Personne = prenom_Personne;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue_Personne() {
		return rue_Personne;
	}
	public void setRue_Personne(String rue_Personne) {
		this.rue_Personne = rue_Personne;
	}
	public String getCodepostal_Personne() {
		return codepostal_Personne;
	}
	public void setCodepostal_Personne(String codepostal_Personne) {
		this.codepostal_Personne = codepostal_Personne;
	}
	public String getVille_Personne() {
		return ville_Personne;
	}
	public void setVille_Personne(String ville_Personne) {
		this.ville_Personne = ville_Personne;
	}
	public String getEmail_Personne() {
		return email_Personne;
	}
	public void setEmail_Personne(String email_Personne) {
		this.email_Personne = email_Personne;
	}
	public String getTelephonepere() {
		return telephonepere;
	}
	public void setTelephonepere(String telephonepere) {
		this.telephonepere = telephonepere;
	}
	public String getTelephonemere() {
		return telephonemere;
	}
	public void setTelephonemere(String telephonemere) {
		this.telephonemere = telephonemere;
	}
	public String getDatenaissance_Personne() {
		return datenaissance_Personne;
	}
	public void setDatenaissance_Personne(String datenaissance_Personne) {
		this.datenaissance_Personne = datenaissance_Personne;
	}
	public String getNumlicence() {
		return numlicence;
	}
	public void setNumlicence(String numlicence) {
		this.numlicence = numlicence;
	}
	
	
}
