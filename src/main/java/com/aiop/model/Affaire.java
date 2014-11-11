package com.aiop.model;

import java.util.ArrayList;
import java.util.List;

public class Affaire {

	private String nomAffaire;
	// Numéros
	private long idAffaire;
	private long numInstruction;
	private long numParquet;
	private long numDossier;
	private long numFacture;
	// Dates
	private String DateOrdre;
	private String DateMax;
	private String dateProrogation;
	private String DateRecupScelle;
	private String DateRetourScelle;
	private String dateDevis;
	private String dateRemise;

	private String LieuRecupScelle;
	private String LieuRetourScelle;
	private long nbPageNb;
	private long nbPageCouleur;
	private long nbHExpertise;
	private long nbHDeplacement;
	private double pourcentageDevis;
	private double montantFacture;
	private double pourcentageRemise;
	private boolean delais10j;

	// Frais à gérer
	private List<Frais> frais;
	// Etat
	private String Etat;

	// Scelle à gérer
	private List<Scelle> scelles;

	/**
	 * Constructeurs
	 */

	public Affaire() {

	}

	public Affaire(long id) {

		setIdAffaire(id);
		setNomAffaire("Affaire" + id);
		setNumInstruction(1);
		setNumDossier(875);
		setNumParquet(5);
		setDateOrdre("3 Janvier 2015");
		setDateMax("9 Février 2045");
		setDateProrogation("5 Aout 2598");
		setNbPageNb(5);
		setNbPageCouleur(15);
		setNbHExpertise(80);
		setNbHDeplacement(68);
		setDateDevis("9 Mars 2016");
		setPourcentageDevis(0.8);
		setNumFacture(8);
		setMontantFacture(1258.59);
		setPourcentageRemise(0.2);
		setDelais10j(true);
		setDateRemise("7 Juillet 2147");
		this.frais = new ArrayList<Frais>();
		this.frais.add(new Frais(1));
		this.frais.add(new Frais(2));
		this.scelles = new ArrayList<Scelle>();
		this.scelles.add(new Scelle(123,4,"scelle essai"));

	}

	public Affaire(String nom) {
		setNomAffaire(nom);
	}

	public Affaire(long id, String nom) {
		setIdAffaire(id);
		setNomAffaire(nom);
	}

	/**
	 * Setters and Getters
	 */
	public List<Frais> getFrais() {
		return frais;
	}

	public void setFrais(List<Frais> frais) {
		this.frais = frais;
	}

	public long getNumInstruction() {
		return numInstruction;
	}

	public void setNumInstruction(long numInstruction) {
		this.numInstruction = numInstruction;
	}

	public long getNumParquet() {
		return numParquet;
	}

	public void setNumParquet(long numParquet) {
		this.numParquet = numParquet;
	}

	public long getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(long numDossier) {
		this.numDossier = numDossier;
	}

	public long getNumFacture() {
		return numFacture;
	}

	public void setNumFacture(long numFacture) {
		this.numFacture = numFacture;
	}

	public String getDateOrdre() {
		return DateOrdre;
	}

	public void setDateOrdre(String dateOrdre) {
		DateOrdre = dateOrdre;
	}

	public String getDateMax() {
		return DateMax;
	}

	public void setDateMax(String dateMax) {
		DateMax = dateMax;
	}

	public String getDateProrogation() {
		return dateProrogation;
	}

	public void setDateProrogation(String dateProrogation) {
		this.dateProrogation = dateProrogation;
	}

	public String getDateRecupScelle() {
		return DateRecupScelle;
	}

	public void setDateRecupScelle(String dateRecupScelle) {
		DateRecupScelle = dateRecupScelle;
	}

	public String getDateRetourScelle() {
		return DateRetourScelle;
	}

	public void setDateRetourScelle(String dateRetourScelle) {
		DateRetourScelle = dateRetourScelle;
	}

	public String getDateDevis() {
		return dateDevis;
	}

	public void setDateDevis(String dateDevis) {
		this.dateDevis = dateDevis;
	}

	public String getDateRemise() {
		return dateRemise;
	}

	public void setDateRemise(String dateRemise) {
		this.dateRemise = dateRemise;
	}

	public String getLieuRecupScelle() {
		return LieuRecupScelle;
	}

	public void setLieuRecupScelle(String lieuRecupScelle) {
		LieuRecupScelle = lieuRecupScelle;
	}

	public String getLieuRetourScelle() {
		return LieuRetourScelle;
	}

	public void setLieuRetourScelle(String lieuRetourScelle) {
		LieuRetourScelle = lieuRetourScelle;
	}

	public long getNbPageNb() {
		return nbPageNb;
	}

	public void setNbPageNb(long nbPageNb) {
		this.nbPageNb = nbPageNb;
	}

	public long getNbPageCouleur() {
		return nbPageCouleur;
	}

	public void setNbPageCouleur(long nbPageCouleur) {
		this.nbPageCouleur = nbPageCouleur;
	}

	public long getNbHExpertise() {
		return nbHExpertise;
	}

	public void setNbHExpertise(long nbHExpertise) {
		this.nbHExpertise = nbHExpertise;
	}

	public long getNbHDeplacement() {
		return nbHDeplacement;
	}

	public void setNbHDeplacement(long nbHDepalacement) {
		this.nbHDeplacement = nbHDepalacement;
	}

	public double getPourcentageDevis() {
		return pourcentageDevis;
	}

	public void setPourcentageDevis(double pourcentageDevis) {
		this.pourcentageDevis = pourcentageDevis;
	}

	public double getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(double montantFacture) {
		this.montantFacture = montantFacture;
	}

	public double getPourcentageRemise() {
		return pourcentageRemise;
	}

	public void setPourcentageRemise(double pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}

	public boolean isDelais10j() {
		return delais10j;
	}

	public void setDelais10j(boolean delais10j) {
		this.delais10j = delais10j;
	}

	public long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(long idAffaire) {
		this.idAffaire = idAffaire;
	}

	public String getNomAffaire() {
		return nomAffaire;
	}

	public void setNomAffaire(String nomAffaire) {
		this.nomAffaire = nomAffaire;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public List<Scelle> getScelles() {
		return scelles;
	}

	public void setScelles(List<Scelle> scelle) {
		this.scelles = scelle;
	}

	/*
	 * Méthodes lidées à l'ORM
	 */

	// Sauvegarde de l'affaire en base
	public void save() {

	}

	// création d'une nouvelle affaire en base
	public void create() {

	}

	// Recherche de toute les affaires de la base.
	public List<Affaire> getAllAffaires() {
		return null;
	}

	// Recherche un scelle d'affaire
	public Scelle getScelle(long numeroScelle) {
		for(int i=0;i<scelles.size();i++){
			if(this.scelles.get(i).getNumeroScelle()==numeroScelle){
				return scelles.get(i);
				
			}
		}
		return null ;
	}
	
	//delete un scelle d'affaire
	public void deleteScelle(long numeroScelle){
		
	}
	// charge une affaire
	public void load(long id) {

	}

	// créer un type de mission pour un type d'objet d'un scellé
	public void createMissionForTypeObjetInScelle(long idScelle,
			long idTypeObjet, String idTypeMission) {
		// TODO Auto-generated method stub
		
	}

	public void nbObjet(long idTypeObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		
	}

	public List<TypeObjet> getTypesObjets() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Objet> getObjetsFindByIdTypeObjet(long idTypeObjet) {
		// TODO Auto-generated method stub
		return null;
	}

}
