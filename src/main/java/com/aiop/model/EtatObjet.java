package com.aiop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="etatObjet")
public class EtatObjet implements java.io.Serializable{
	private long idEtat;
	
	private long idObjet;
	private long idTypeMission;
	private String commentaire;
	private String fait;
	

/**
 * Setters and Getters
 */	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEtat",nullable=false)
	public long getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(long idEtat) {
		this.idEtat = idEtat;
	}

	@Column(name = "idTypeMission", length = 20)
	public long getIdTypeMission() {
		return idTypeMission;
	}

	public void setIdTypeMission(long idTypeMission) {
		this.idTypeMission = idTypeMission;
	}

	@Column(name = "commentaire", length = 50)
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Column(name = "fait", length = 50)
	public String getFait() {
		return fait;
	}

	public void setFait(String fait) {
		this.fait = fait;
	}

	@Column(name = "idObjet", length = 20)
	public long getIdObjet() {
		return idObjet;
	}
	
	public void setIdObjet(long idObjet){
		this.idObjet=idObjet;
		
	}

}