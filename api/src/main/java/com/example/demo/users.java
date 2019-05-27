package com.example.demo;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class users {
	  
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Integer id;
   private String nom;
   private String prenom;
   private String telephone;
   private String rue;
   private String codePostal;
   private String ville;
   private String email;
   private String telPere;
   private String telMere;
   private Date dateNaissance;
   private String numlicence;
   public String getPrenom() {
	return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Integer getId() {
      return id;
	}
	public void setId(Integer id) {
      this.id = id;
	}
	public String getNom() {
	  return nom;
	}
	public void setNom(String nom) {
      this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelPere() {
		return telPere;
	}
	public void setTelPere(String telPere) {
		this.telPere = telPere;
	}
	public String getTelMere() {
		return telMere;
	}
	public void setTelMere(String telMere) {
		this.telMere = telMere;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getNumlicence() {
		return numlicence;
	}
	public void setNumlicence(String numlicence) {
		this.numlicence = numlicence;
	}
	
	
	
	
}
