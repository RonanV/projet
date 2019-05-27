package com.example.apispring.model;

import java.util.Collection;

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
public class Groupe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idgroupe;
	private String libellegrp;
	private String tache_Groupe;
	private String limitemax;
	private String tarif_Groupe;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idphoto", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Photo idphoto;
	
	@ManyToMany
	private Collection<Horaire> horaires;
	
	public Integer getIdgroupe() {
		return idgroupe;
	}
	public void setIdgroupe(Integer idgroupe) {
		this.idgroupe = idgroupe;
	}
	public String getLibellegrp() {
		return libellegrp;
	}
	public void setLibellegrp(String libellegrp) {
		this.libellegrp = libellegrp;
	}
	public String getTache_Groupe() {
		return tache_Groupe;
	}
	public void setTache_Groupe(String tache_Groupe) {
		this.tache_Groupe = tache_Groupe;
	}
	public String getLimitemax() {
		return limitemax;
	}
	public void setLimitemax(String limitemax) {
		this.limitemax = limitemax;
	}
	public String getTarif_Groupe() {
		return tarif_Groupe;
	}
	public void setTarif_Groupe(String tarif_Groupe) {
		this.tarif_Groupe = tarif_Groupe;
	}
	public Photo getIdphoto() {
		return idphoto;
	}
	public void setIdphoto(Photo idphoto) {
		this.idphoto = idphoto;
	}
	public Collection<Horaire> getHoraires() {
		return horaires;
	}
	public void setHoraires(Collection<Horaire> horaires) {
		this.horaires = horaires;
	}
	
}
