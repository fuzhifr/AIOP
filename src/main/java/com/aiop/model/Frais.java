package com.aiop.model;

public class Frais {
	
	private long idFrais;
	private String libFrais;
	private double prixFrais;
	
	/*
	 * CONSTRUCTEURS
	 */
	
	public Frais () {
			
		}
	
	public Frais (long id) {
		setIdFrais(id);
		setLibFrais("frais " + id);
		setPrixFrais(id * 12.8);
	}

	public Frais(long id, long idFrais) {
		load(id, idFrais);
	}
	
	public Frais(String libFrais, double prixFrais) {
		this.setLibFrais(libFrais);
		this.setPrixFrais(prixFrais);
	}
	
	/*
	 * GETTERS and SETTERS
	 */


	public long getIdFrais() {
		return idFrais;
	}

	public void setIdFrais(long idFrais) {
		this.idFrais = idFrais;
	}

	public String getLibFrais() {
		return libFrais;
	}

	public void setLibFrais(String libFrais) {
		this.libFrais = libFrais;
	}

	public double getPrixFrais() {
		return prixFrais;
	}

	public void setPrixFrais(double prixFrais) {
		this.prixFrais = prixFrais;
	}
	
	
	/*
	 * Méthodes lidées à l'ORM
	 */
	
	// Supprime un élément de la base
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	// charge un frais d'une affaire
	public void load(long idAffaire, long idFrais) {
		
	}
	
	// Sauvegarde un frais dans une affaire
	public void save(long idAffaire) {
		// TODO Auto-generated method stub
		
	}

	

}
