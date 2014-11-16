package com.aiop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lignedevis")
public class LigneDevis {
	
	private long idLigneDevis;
	private long idAffaire;
	private long idTypeObjet;
	private long idTypeMission;
	
	private long montantDevis;
	private long quantiteDevis;
	private long montantFacture;
	private long quantiteFacture;
	
	public LigneDevis() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLigneDevis",length=20)
	public long getIdLigneDevis() {
		return idLigneDevis;
	}

	public void setIdLigneDevis(long idLigneDevis) {
		this.idLigneDevis = idLigneDevis;
	}
	
	@Column(name="idAffaire",length=20)
	public long getIdAffaire() {
		return idAffaire;
	}
	public void setIdAffaire(long idAffaire) {
		this.idAffaire = idAffaire;
	}
	
	@Column(name="idTypeObjet",length=20)
	public long getIdTypeObjet() {
		return idTypeObjet;
	}
	public void setIdTypeObjet(long idTypeObjet) {
		this.idTypeObjet = idTypeObjet;
	}
	
	@Column(name="idTypeMission",length=20)
	public long getIdTypeMission() {
		return idTypeMission;
	}
	public void setIdTypeMission(long idTypeMission) {
		this.idTypeMission = idTypeMission;
	}
	
	@Column(name="montantDevis",length=20)
	public long getMontantDevis() {
		return montantDevis;
	}
	public void setMontantDevis(long montantDevis) {
		this.montantDevis = montantDevis;
	}
	
	@Column(name="quantiteDevis",length=20)
	public long getQuantiteDevis() {
		return quantiteDevis;
	}
	public void setQuantiteDevis(long quantiteDevis) {
		this.quantiteDevis = quantiteDevis;
	}
	
	@Column(name="montantFacture",length=20)
	public long getMontantFacture() {
		return montantFacture;
	}
	public void setMontantFacture(long montantFacture) {
		this.montantFacture = montantFacture;
	}
	
	@Column(name="quantiteFacture",length=20)
	public long getQuantiteFacture() {
		return quantiteFacture;
	}
	public void setQuantiteFacture(long quantiteFacture) {
		this.quantiteFacture = quantiteFacture;
	}
	
	
}
