package com.example.apispring.jointure;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class tache_personne_key implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5191711573384043009L;


	@Column(name = "idtache")
	private Integer idtache;
	
	
	@Column(name = "idpersonne")
	private Integer idpersonne;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public tache_personne_key() {
		super();
	}

	public tache_personne_key(Integer tache_id, Integer personne_id) {
		super();
		this.idtache = tache_id;
		this.idpersonne = personne_id;
	}
	
	public Integer getIdtache() {
		return idtache;
	}

	public void setIdtache(Integer idtache) {
		this.idtache = idtache;
	}

	public Integer getIdpersonne() {
		return idpersonne;
	}

	public void setIdpersonne(Integer idpersonne) throws Exception {
		this.idpersonne = idpersonne;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idpersonne ^ (idpersonne >>> 32));
		result = prime * result + (int) (idtache ^ (idtache >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tache_personne_key other = (tache_personne_key) obj;
		if (idpersonne != other.idpersonne)
			return false;
		if (idtache != other.idtache)
			return false;
		return true;
	}
}
