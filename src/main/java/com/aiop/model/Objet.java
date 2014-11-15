package com.aiop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@SuppressWarnings("serial")
@Entity
@Table(name="Objet")
public class Objet {
	private long idObjet;
	private String libelleObjet;
	private long idTypeObjet;
	
	public Objet(){
		
	}
	
	public Objet(long idObjet){
		this.idObjet=idObjet;
	}
	
public Objet(long idObjet, String libelleObjet, long idTypeObjet) {
	this.idObjet=idObjet;
	this.libelleObjet=libelleObjet;
	this.setIdTypeObjet(idTypeObjet);
	
	}

/**
 * Setters and Getters
 */	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idObjet",nullable=false)
	public long getIdObjet() {
		return idObjet;
	}
	
	@Column(name = "libelleObjet", length = 50)
	public String getLibelleObjet() {
		return libelleObjet;
	}
	
	public void setLibelleObjet(String libelleObjet) {
		this.libelleObjet = libelleObjet;
	}
	
	@OneToOne(targetEntity = TypeObjet.class,fetch = FetchType.EAGER, mappedBy = "idObjet")
	public long getIdTypeObjet() {
		return idTypeObjet;
	}

	public void setIdTypeObjet(long idTypeObjet) {
		this.idTypeObjet = idTypeObjet;
	}


}