package com.aiop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Frais")
public class Frais {
	
	private long idFrais;
	private String libFrais;
	private double prixFrais;
	private long idAffaire;

	/*
	 * GETTERS and SETTERS
	 */


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFrais",length=20)
	public long getIdFrais() {
		return idFrais;
	}

	public void setIdFrais(long idFrais) {
		this.idFrais = idFrais;
	}

	@Column(name="libFrais",length=50)
	public String getLibFrais() {
		return libFrais;
	}

	public void setLibFrais(String libFrais) {
		this.libFrais = libFrais;
	}

	@Column(name="prixFrais",length=20)
	public double getPrixFrais() {
		return prixFrais;
	}

	public void setPrixFrais(double prixFrais) {
		this.prixFrais = prixFrais;
	}
	
	@Column(name="idAffaire",length=20)
	public long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(long idAffaire) {
		this.idAffaire = idAffaire;
	}

	

}
