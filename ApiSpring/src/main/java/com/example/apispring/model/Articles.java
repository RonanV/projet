package com.example.apispring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Articles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idarticle;
	private String texte_article;
	private String titre_article;
	private Date date_article;
	private String id_personne;
	private String photo_idphoto;
	public Integer getIdarticle() {
		return idarticle;
	}
	public void setIdarticle(Integer idarticle) {
		this.idarticle = idarticle;
	}
	public String getTexte_article() {
		return texte_article;
	}
	public void setTexte_article(String texte_article) {
		this.texte_article = texte_article;
	}
	public String getTitre_article() {
		return titre_article;
	}
	public void setTitre_article(String titre_article) {
		this.titre_article = titre_article;
	}
	public Date getDate_article() {
		return date_article;
	}
	public void setDate_article(Date date_article) {
		this.date_article = date_article;
	}
	public String getId_personne() {
		return id_personne;
	}
	public void setId_personne(String id_personne) {
		this.id_personne = id_personne;
	}
	public String getPhoto_idphoto() {
		return photo_idphoto;
	}
	public void setPhoto_idphoto(String photo_idphoto) {
		this.photo_idphoto = photo_idphoto;
	}
	
	
	
}
