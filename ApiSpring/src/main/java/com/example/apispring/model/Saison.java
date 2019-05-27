package com.example.apispring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Saison {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idsaison;
	private String libellesaison;
	public Integer getIdsaison() {
		return idsaison;
	}
	public void setIdsaison(Integer idsaison) {
		this.idsaison = idsaison;
	}
	public String getLibellesaison() {
		return libellesaison;
	}
	public void setLibellesaison(String libellesaison) {
		this.libellesaison = libellesaison;
	}
	
	
}
