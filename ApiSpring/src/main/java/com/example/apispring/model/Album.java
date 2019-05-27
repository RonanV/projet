package com.example.apispring.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idalbum;
	private String titre_Album;
	private String description_Album;
	private Date date_Album;
	@ManyToMany
	private Collection<Photo> photo;
	
	public Integer getIdalbum() {
		return idalbum;
	}
	public void setIdalbum(Integer idalbum) {
		this.idalbum = idalbum;
	}
	public String getTitre_Album() {
		return titre_Album;
	}
	public void setTitre_Album(String titre_Album) {
		this.titre_Album = titre_Album;
	}
	public String getDescription_Album() {
		return description_Album;
	}
	public void setDescription_Album(String description_Album) {
		this.description_Album = description_Album;
	}
	public Date getDate_Album() {
		return date_Album;
	}
	public void setDate_Album(Date date_Album) {
		this.date_Album = date_Album;
	}
	public Collection<Photo> getPhoto() {
		return photo;
	}
	public void setPhoto(Collection<Photo> photo) {
		this.photo = photo;
	}
	
	
}
