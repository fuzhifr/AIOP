package com.aiop.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



@SuppressWarnings("serial")
@Entity
@Table(name="scelle")
public class Scelle implements java.io.Serializable {
	// Numéro
	private long numeroScelle;
	private long numeroPV;
	private String commentaire;
	//manytoOne relation
	private long idAffaire;
	//objets dans le scelle
	private List<Objet> objets;

	/**
	 * Constructeur par defaut
	 */
	public Scelle() {

	}

	public Scelle(long numeroScelle){
		this.setNumeroScelle(numeroScelle);
	}
	/**
	 * Constructeur avec numeroScelle, numeroPV,commentaire
	 * 
	 * @param numeroScelle
	 * @param numeroPV
	 * @param commentaire
	 */
	public Scelle(long numeroPV, String commentaire) {
		this.setNumeroPV(numeroPV);
		this.setCommentaire(commentaire);
	}
	
	/*
	 * Méthodes 
	 */

	

	@Override
	public String toString() {
		return "Scelle [numeroScelle=" + numeroScelle + ", numeroPV="
				+ numeroPV + ", commentaire=" + commentaire + "]";
	}
	/*
	 * Méthodes lidées à l'ORM
	 */

	/**
	 * Charge un Scelle
	 * 
	 * @param numeroScelle
	 * @return
	 */
	public void updateTypeMissionForTypeObjetInScelle(long idTypeObjet,
			long idTypeMission, long libTypeMission, String prixMission) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Setters and Getters
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numeroScelle",nullable=false)
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
	
	@Column(name = "commentaire", length = 50)
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	

	@Column(name="idAffaire",length=20)
	public long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(long idAffaire) {
		this.idAffaire = idAffaire;
	}

<<<<<<< Updated upstream
=======
	

	@OneToMany(targetEntity = Objet.class,fetch = FetchType.EAGER, mappedBy = "numeroScelle")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.DELETE })
	public List<Objet> getListeObjets() {
		return this.objets;
	}

	public void setListeObjets(List<Objet> objets) {
		this.objets = objets;
	}





>>>>>>> Stashed changes
}
