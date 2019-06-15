package com.example.apispring.model;

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
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Groupe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idgroupe;
	
	private String libellegrp;
	private String tache_Groupe;
	private String limitemax;
	private String tarif_Groupe;
	private String annee_Min;
	private String annee_Max;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idphoto")
	@Fetch(FetchMode.JOIN)
	private Photo idphoto;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="groupe_horaire",
				joinColumns= {@JoinColumn(name="idgroupe")},
				inverseJoinColumns= {@JoinColumn(name="idhoraire")})
	@JsonIgnore
	private Set<Horaire> horaire;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsaison")
	@Fetch(FetchMode.JOIN)
	private Saison idsaison;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="groupe_personne",
				joinColumns= {@JoinColumn(name="idgroupe")},
				inverseJoinColumns= {@JoinColumn(name="idpersonne")})
	@JsonIgnoreProperties("groupe")
	private Set<Personne> personne;
	
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
	public String getAnnee_Min() {
		return annee_Min;
	}
	public void setAnnee_Min(String annee_Min) {
		this.annee_Min = annee_Min;
	}
	public String getAnnee_Max() {
		return annee_Max;
	}
	public void setAnne_Max(String annee_Max) {
		this.annee_Max = annee_Max;
	}
	public Photo getIdphoto() {
		return idphoto;
	}
	public void setIdphoto(Photo idphoto) {
		this.idphoto = idphoto;
	}
	public Set<Horaire> getHoraires() {
		return horaire;
	}
	public void setHoraires(Set<Horaire> horaire) {
		this.horaire = horaire;
	}
	public Set<Personne> getPersonne() {
		return personne;
	}
	public void setPersonne(Set<Personne> personne) {
		this.personne = personne;
	}
	public Saison getIdsaison() {
		return idsaison;
	}
	public void setIdsaison(Saison idsaison) {
		this.idsaison = idsaison;
	}
	
	
	
}
