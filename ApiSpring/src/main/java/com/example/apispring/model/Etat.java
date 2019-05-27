package com.example.apispring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idetat;
	private String libelleetat;
	public Integer getIdetat() {
		return idetat;
	}
	public void setIdetat(Integer idetat) {
		this.idetat = idetat;
	}
	public String getLibelleetat() {
		return libelleetat;
	}
	public void setLibelleetat(String libelleetat) {
		this.libelleetat = libelleetat;
	}
	
	
}
