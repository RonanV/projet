package com.example.apispring.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Photo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idphoto;
	
	private String chemin_Photo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idgroupe")
	@Fetch(FetchMode.JOIN)
	private Groupe idgroupe;
	
	@ManyToMany(mappedBy="photo")
	private Set<Album> album;
	
	public Integer getIdphoto() {
		return idphoto;
	}
	public void setIdphoto(Integer idphoto) {
		this.idphoto = idphoto;
	}
	public String getChemin_Photo() {
		return chemin_Photo;
	}
	public void setChemin_Photo(String chemin_Photo) {
		this.chemin_Photo = chemin_Photo;
	}
	public Groupe getIdgroupe() {
		return idgroupe;
	}
	public void setIdgroupe(Groupe idgroupe) {
		this.idgroupe = idgroupe;
	}
	public Set<Album> getAlbum() {
		return album;
	}
	public void setAlbum(Set<Album> album) {
		this.album = album;
	}
	
	
	
	
}
