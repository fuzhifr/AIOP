package com.aiop.model;

public class LigneDevis {
	
	private long idAffaire;
	private long idTypeObjet;
	private long idTypeMission;
	
	private long montantDevis;
	private long quantiteDevis;
	private long montantFacture;
	private long quantiteFacture;
	
	public LigneDevis() {
		
	}
	
	public long getIdAffaire() {
		return idAffaire;
	}
	public void setIdAffaire(long idAffaire) {
		this.idAffaire = idAffaire;
	}
	public long getIdTypeObjet() {
		return idTypeObjet;
	}
	public void setIdTypeObjet(long idTypeObjet) {
		this.idTypeObjet = idTypeObjet;
	}
	public long getIdTypeMission() {
		return idTypeMission;
	}
	public void setIdTypeMission(long idTypeMission) {
		this.idTypeMission = idTypeMission;
	}
	public long getMontantDevis() {
		return montantDevis;
	}
	public void setMontantDevis(long montantDevis) {
		this.montantDevis = montantDevis;
	}
	public long getQuantiteDevis() {
		return quantiteDevis;
	}
	public void setQuantiteDevis(long quantiteDevis) {
		this.quantiteDevis = quantiteDevis;
	}
	public long getMontantFacture() {
		return montantFacture;
	}
	public void setMontantFacture(long montantFacture) {
		this.montantFacture = montantFacture;
	}
	public long getQuantiteFacture() {
		return quantiteFacture;
	}
	public void setQuantiteFacture(long quantiteFacture) {
		this.quantiteFacture = quantiteFacture;
	}
	
	
}
