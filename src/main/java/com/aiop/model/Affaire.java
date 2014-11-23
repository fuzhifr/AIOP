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
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;

@SuppressWarnings("serial")
@Entity
@Table(name = "affaire")
public class Affaire implements java.io.Serializable {

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
	// Etat
	private String Etat;
		
	// Liste de Frais
	private Set<Frais> frais;
	
	// Liste de scellés
	private Set<Scelle> scelles;
	
	// Liste de LignesDevis
	private Set<LigneDevis> devis;
	
	public Affaire()
	{
		this.scelles=new HashSet<Scelle>();
		this.frais = new HashSet<Frais>();
		this.devis = new HashSet<LigneDevis>();
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAffaire", nullable = false, length = 20)
	public long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(long idAffaire) {
		this.idAffaire = idAffaire;
	}

	@Column(name = "nomAffaire",length = 50)
	public String getNomAffaire() {
		return nomAffaire;
	}

	public void setNomAffaire(String nomAffaire) {
		this.nomAffaire = nomAffaire;
	}

	@Column(name = "NumInstruction",length = 20)
	public long getNumInstruction() {
		return numInstruction;
	}

	public void setNumInstruction(long numInstruction) {
		this.numInstruction = numInstruction;
	}

	@Column(name = "NumParquet",length = 20)
	public long getNumParquet() {
		return numParquet;
	}

	public void setNumParquet(long numParquet) {
		this.numParquet = numParquet;
	}

	@Column(name = "NumDossier",length = 20)
	public long getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(long numDossier) {
		this.numDossier = numDossier;
	}

	@Column(name = "NumFacture",length = 20)
	public long getNumFacture() {
		return numFacture;
	}

	public void setNumFacture(long numFacture) {
		this.numFacture = numFacture;
	}

	@Column(name = "dateOrder",length = 30)
	public String getDateOrdre() {
		return DateOrdre;
	}

	public void setDateOrdre(String dateOrdre) {
		DateOrdre = dateOrdre;
	}

	@Column(name = "dateMax",length = 30)
	public String getDateMax() {
		return DateMax;
	}

	public void setDateMax(String dateMax) {
		DateMax = dateMax;
	}

	@Column(name = "dateProrogation",length = 30)
	public String getDateProrogation() {
		return dateProrogation;
	}

	public void setDateProrogation(String dateProrogation) {
		this.dateProrogation = dateProrogation;
	}

	@Column(name = "dateRecupScelle",length = 30)
	public String getDateRecupScelle() {
		return DateRecupScelle;
	}

	public void setDateRecupScelle(String dateRecupScelle) {
		DateRecupScelle = dateRecupScelle;
	}

	@Column(name = "dateRetourScelle",length = 30)
	public String getDateRetourScelle() {
		return DateRetourScelle;
	}

	public void setDateRetourScelle(String dateRetourScelle) {
		DateRetourScelle = dateRetourScelle;
	}

	@Column(name = "dateDevis",length = 30)
	public String getDateDevis() {
		return dateDevis;
	}

	public void setDateDevis(String dateDevis) {
		this.dateDevis = dateDevis;
	}

	@Column(name = "dateRemise",length = 30)
	public String getDateRemise() {
		return dateRemise;
	}

	public void setDateRemise(String dateRemise) {
		this.dateRemise = dateRemise;
	}

	@Column(name = "LieuRecupScelle",length = 50)
	public String getLieuRecupScelle() {
		return LieuRecupScelle;
	}

	public void setLieuRecupScelle(String lieuRecupScelle) {
		LieuRecupScelle = lieuRecupScelle;
	}

	@Column(name = "LieuRetourScelle",length = 50)
	public String getLieuRetourScelle() {
		return LieuRetourScelle;
	}

	public void setLieuRetourScelle(String lieuRetourScelle) {
		LieuRetourScelle = lieuRetourScelle;
	}

	@Column(name = "nbPageNb",length = 20)
	public long getNbPageNb() {
		return nbPageNb;
	}

	public void setNbPageNb(long nbPageNb) {
		this.nbPageNb = nbPageNb;
	}

	@Column(name = "nbPageCouleur",length = 20)
	public long getNbPageCouleur() {
		return nbPageCouleur;
	}

	public void setNbPageCouleur(long nbPageCouleur) {
		this.nbPageCouleur = nbPageCouleur;
	}

	@Column(name = "NbHExpertise",length = 20)
	public long getNbHExpertise() {
		return nbHExpertise;
	}

	public void setNbHExpertise(long nbHExpertise) {
		this.nbHExpertise = nbHExpertise;
	}

	@Column(name = "NbHDeplacement",length = 20)
	public long getNbHDeplacement() {
		return nbHDeplacement;
	}

	public void setNbHDeplacement(long nbHDeplacement) {
		this.nbHDeplacement = nbHDeplacement;
	}

	@Column(name = "PourcentageDevis",length = 20)
	public double getPourcentageDevis() {
		return pourcentageDevis;
	}

	public void setPourcentageDevis(double pourcentageDevis) {
		this.pourcentageDevis = pourcentageDevis;
	}

	@Column(name = "MontantFacture",length = 20)
	public double getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(double montantFacture) {
		this.montantFacture = montantFacture;
	}

	@Column(name = "PourcentageRemise",length = 20)
	public double getPourcentageRemise() {
		return pourcentageRemise;
	}

	public void setPourcentageRemise(double pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}

	@Transient
	public boolean isDelais10j() {
		return delais10j;
	}

	public void setDelais10j(boolean delais10j) {
		this.delais10j = delais10j;
	}

	@OneToMany(targetEntity = Frais.class,fetch = FetchType.EAGER, mappedBy = "idAffaire")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.DELETE })
	@JsonIgnore
	public Set<Frais> getFrais() {
		return frais;
	}

	public void setFrais(Set<Frais> frais) {
		this.frais = frais;
	}

	@Column(name = "etat",length = 50)
	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	@OneToMany(targetEntity = Scelle.class,fetch = FetchType.EAGER, mappedBy = "idAffaire")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.DELETE })
	@JsonIgnore
	public Set<Scelle> getScelles() {
		return scelles;
	}

	public void setScelles(Set<Scelle> scelles) {
		this.scelles = scelles;
	}
	
	@OneToMany(targetEntity = LigneDevis.class,fetch = FetchType.EAGER, mappedBy = "idAffaire")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			org.hibernate.annotations.CascadeType.DELETE })
	@JsonIgnore
	public Set<LigneDevis> getLignesDevis() {
		return devis;
	}

	public void setLignesDevis(Set<LigneDevis> devis) {
		this.devis = devis;
	}

}
