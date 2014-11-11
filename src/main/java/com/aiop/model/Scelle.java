package com.aiop.model;

import java.util.List;

public class Scelle {
	// Numéro
	private long numeroScelle;
	private long numeroPV;
	private String commentaire;
	
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
	public Scelle(long numeroScelle, long numeroPV, String commentaire) {
		this.setNumeroScelle(numeroScelle);
		this.setNumeroPV(numeroPV);
		this.setCommentaire(commentaire);
	}
	
	/*
	 * Méthodes 
	 */
	public Objet getObjetfindById(long idObjet) {
		for(int i=0;i<this.objets.size();i++){
			if(this.objets.get(i).getIdObjet()==idObjet){
				return this.objets.get(i);
			}		
		}
		return null;
	}
	

	@Override
	public String toString() {
		return "Scelle [numeroScelle=" + numeroScelle + ", numeroPV="
				+ numeroPV + ", commentaire=" + commentaire + "]";
	}
	/*
	 * Méthodes lidées à l'ORM
	 */

	/**
	 * Sauvegarde un scelle dans une affaire
	 * 
	 * @param idAffaire
	 */
	public void save(long idAffaire) {
		// TODO Auto-generated method stub

	}

	/**
	 * Charge un Scelle
	 * 
	 * @param numeroScelle
	 * @return
	 */
	public Scelle load() {
		return null;
	}
	
	public void load(long numeroScelle2) {
		// TODO Auto-generated method stub
		
	}
	
	public void deleteObjectById(long idObjet) {
		
	}
	
	public void updateTypeMissionForTypeObjetInScelle(long idTypeObjet,
			long idTypeMission, long libTypeMission, String prixMission) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Setters and Getters
	 */

	public long getNumeroScelle() {
		return numeroScelle;
	}

	public void setNumeroScelle(long numeroScelle) {
		this.numeroScelle = numeroScelle;
	}

	public long getNumeroPV() {
		return numeroPV;
	}

	public void setNumeroPV(long numeroPV) {
		this.numeroPV = numeroPV;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public List<Objet> getObjets() {
		return objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}

	







}
