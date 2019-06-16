package com.example.apispring.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Indexed;

import com.example.apispring.jointure.tache_personne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Personne{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idpersonne;
	@Column(unique=true)
	private String loginPersonne;
	private String nomPersonne;
	private String prenomPersonne;
	private String telephone;
	private String rue_Personne;
	private String codepostal_Personne;
	private String ville_Personne;
	private String emailPersonne;
	private String telephonepere;
	private String telephonemere;
	private Date datenaissance_Personne;
	private String numlicence;
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idphoto", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Photo idphoto;
	
	@ManyToMany(mappedBy="personne")
	private Set<Droit> droit;
	
	@ManyToMany(mappedBy="personne")
	private Set<Saison> idsaison;
	
	@OneToMany(mappedBy = "personne", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<tache_personne> tache = new HashSet<tache_personne>();
	
	@ManyToMany(mappedBy = "personne")
	@JsonIgnoreProperties("personne")
	private Set<Groupe> groupe;
	
	public Personne() {
		super();
	}
	



	public Personne(String loginPersonne, String password) {
		this.loginPersonne = loginPersonne;
		this.password = password;
	}

	public Personne(Personne personne) {
	}

	public Integer getIdpersonne() {
		return idpersonne;
	}
	public void setIdpersonne(Integer idpersonne) {
		this.idpersonne = idpersonne;
	}
	
	public String getLoginPersonne() {
		return loginPersonne;
	}
	public void setLoginPersonne(String loginPersonne) {
		this.loginPersonne = loginPersonne;
	}
	public String getNomPersonne() {
		return nomPersonne;
	}
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
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
	public String getEmailPersonne() {
		return emailPersonne;
	}
	public void setEmailPersonne(String emailPersonne) {
		this.emailPersonne = emailPersonne;
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
	public Date getDatenaissance_Personne() {
		return datenaissance_Personne;
	}
	public void setDatenaissance_Personne(Date datenaissance_Personne) {
		this.datenaissance_Personne = datenaissance_Personne;
	}
	public String getNumlicence() {
		return numlicence;
	}
	public void setNumlicence(String numlicence) {
		this.numlicence = numlicence;
	}
	public Set<Droit> getDroit() {
		return droit;
	}
	public void setDroit(Set<Droit> droit) {
		this.droit = droit;
	}
	public Set<Saison> getIdsaison() {
		return idsaison;
	}
	public void setIdsaison(Set<Saison> idsaison) {
		this.idsaison = idsaison;
	}
	public Collection<tache_personne> getTache() {
		return tache;
	}
	public void setTache(Collection<tache_personne> tache) {
		this.tache = tache;
	}
	public Photo getIdphoto() {
		return idphoto;
	}
	public void setIdphoto(Photo idphoto) {
		this.idphoto = idphoto;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Groupe> getGroupe() {
		return groupe;
	}
	public void setGroupe(Set<Groupe> groupe) {
		this.groupe = groupe;
	}
	
	
}
