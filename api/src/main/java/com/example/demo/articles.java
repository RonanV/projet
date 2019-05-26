package com.example.demo;

import java.sql.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class articles {
	  
	   @Id
	   @GeneratedValue(strategy=GenerationType.AUTO)
	   private Integer id;
	   
	   private String titre;
	   private String texte;
	   private Date date;// date de parution de l'article
	   private int id_photo;
	   private int id_personne;
	   
	   
	   public articles() {
		super();
		// TODO Auto-generated constructor stub
	   }
	   public Integer getId() {
	      return id;
	   }
	   public void setId(Integer id) {
	      this.id = id;
	   }
	   
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getId_photo() {
		return id_photo;
	}
	public void setId_photo(int id_photo) {
		this.id_photo = id_photo;
	}
	public int getId_personne() {
		return id_personne;
	}
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	   
	   
	   
	   
}
