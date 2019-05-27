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
public class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idarticle;
	private String texte_article;
	private String titre_article;
	private String date_article;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpersonne", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Personne idpersonne;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idphoto", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Photo idphoto;


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
	public String getDate_article() {
		return date_article;
	}
	public void setDate_article(String date_article) {
		this.date_article = date_article;
	}
	public Personne getIdpersonne() {
		return idpersonne;
	}
	public void setIdpersonne(Personne idpersonne) {
		this.idpersonne = idpersonne;
	}
	public Photo getPhoto_idphoto() {
		return idphoto;
	}
	public void setPhoto_idphoto(Photo idphoto) {
		this.idphoto = idphoto;
	}
	
	
	
}
