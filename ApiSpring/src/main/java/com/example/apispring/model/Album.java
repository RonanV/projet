package com.example.apispring.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idalbum;
	
	private String titre_Album;
	private String description_Album;
	private Date date_Album;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="album_photo",
				joinColumns= {@JoinColumn(name="idalbum")},
				inverseJoinColumns= {@JoinColumn(name="idphoto")})
	private Set<Photo> photo;
	
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
	public Set<Photo> getPhoto() {
		return photo;
	}
	public void setPhoto(Set<Photo> photo) {
		this.photo = photo;
	}
	
	
}
