package com.aiop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;



@SuppressWarnings("serial")
@Entity
@Table(name="scelle")
public class Scelle implements java.io.Serializable {
	// Numéro
	private long idScelle;
	private long numeroScelle;
	private long numeroPV;
	private String nom;
	//manytoOne relation
	private long idAffaire;
	//objets dans le scelle
	private Set<Objet> objets;

	/**
	 * Constructeur par defaut
	 */
	public Scelle() {
		objets=new HashSet<Objet>();
	}
	/*
	 * Setters and Getters
	 */
	@Column(name = "numeroScelle")
	public long getNumeroScelle() {
		return numeroScelle;
	}

	public void setNumeroScelle(long numeroScelle) {
		this.numeroScelle = numeroScelle;
	}
	
	@Column(name = "numeroPV", length = 20)
	public long getNumeroPV() {
		return numeroPV;
	}

	public void setNumeroPV(long numeroPV) {
		this.numeroPV = numeroPV;
	}
	
	@Column(name = "nom", length = 50)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

	@Column(name="idAffaire",length=20)
	public long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(long idAffaire) {
		this.idAffaire = idAffaire;
	}

	

	@OneToMany(targetEntity = Objet.class,fetch = FetchType.EAGER, mappedBy = "idScelle")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.DELETE })
	@JsonIgnore
	public Set<Objet> getObjets() {
		return this.objets;
	}

	public void setObjets(Set<Objet> objets) {
		this.objets = objets;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idScelle",nullable=false)
	public long getIdScelle() {
		return idScelle;
	}
	public void setIdScelle(long idScelle) {
		this.idScelle = idScelle;
	}
	
	

}
