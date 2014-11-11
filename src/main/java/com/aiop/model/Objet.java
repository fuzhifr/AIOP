package com.aiop.model;

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
	public long getIdObjet() {
		return idObjet;
	}
	
	public String getLibelleObjet() {
		return libelleObjet;
	}
	
	public void setLibelleObjet(String libelleObjet) {
		this.libelleObjet = libelleObjet;
	}
	
	public long getIdTypeObjet() {
		return idTypeObjet;
	}

	public void setIdTypeObjet(long idTypeObjet) {
		this.idTypeObjet = idTypeObjet;
	}


/*
 * Méthodes liées à l'ORM
 */

public Objet load() {
		return null;
	}

public void save(long numeroScelle) {
	// TODO Auto-generated method stub
	//parcourir tous les scelles pour trouver celui qui a dans sa liste d'objet l'objet courant (this)
	//et comparer si cet ancien scelle que l'on vient de trouver est le meme ou non que celui dont l'identifiant
	//nous a ete passe en parametre; si oui rien a changer sinon il faut supprimer le lien dans l'ancien scelle
	//et creer le nouveau lien
}

//Supprime un élément de la base
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}