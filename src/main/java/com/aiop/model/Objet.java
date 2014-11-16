package com.aiop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Objet")
public class Objet implements java.io.Serializable{
	private long idObjet;
	private String libelleObjet;
	private long idTypeObjet;
	private long numeroScelle;
	
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
	
	public void setIdObjet(long idObjet){
		this.idObjet=idObjet;
		
	}
	@Column(name = "libelleObjet", length = 50)
	public String getLibelleObjet() {
		return libelleObjet;
	}
	
	public void setLibelleObjet(String libelleObjet) {
		this.libelleObjet = libelleObjet;
	}
	
	@OneToOne(targetEntity = TypeObjet.class,cascade=CascadeType.ALL)
	@JoinColumn(name="idTypeObjet")
	public long getIdTypeObjet() {
		return idTypeObjet;
	}

	public void setIdTypeObjet(long idTypeObjet) {
		this.idTypeObjet = idTypeObjet;
	}

	@Column(name = "numeroScelle", length = 20)
	public long getNumeroScelle() {
		return numeroScelle;
	}

	public void setNumeroScelle(long numeroScelle) {
		this.numeroScelle = numeroScelle;
	}


}