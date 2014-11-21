package com.aiop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="objet")
public class Objet implements java.io.Serializable{
	private long idObjet;
	private String libelleObjet;
	private long idTypeObjet;
	private long idScelle;
	
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
	
	/*@OneToOne(targetEntity = TypeObjet.class,cascade=CascadeType.ALL)
	@JoinColumn(name="idTypeObjet")*/
	@Column(name="idTypeObjet",length=20)
	public long getIdTypeObjet() {
		return idTypeObjet;
	}

	public void setIdTypeObjet(long idTypeObjet) {
		this.idTypeObjet = idTypeObjet;
	}

	@Column(name = "idScelle", length = 20)
	public long getIdScelle() {
		return idScelle;
	}

	public void setIdScelle(long idScelle) {
		this.idScelle = idScelle;
	}


}