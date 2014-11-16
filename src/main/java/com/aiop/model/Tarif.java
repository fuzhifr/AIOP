package com.aiop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tarif")
public class Tarif  implements java.io.Serializable{

	private long id;
	private long idTypeObjet;
	private long idTypeMission;
	private int forfait;
	
	@Id
	@Column(name="id",nullable=false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="idTypeObjet", length=20)
	public long getIdTypeObjet() {
		return idTypeObjet;
	}
	public void setIdTypeObjet(long idTypeObjet) {
		this.idTypeObjet = idTypeObjet;
	}
	@Column(name="idTypeMission", length=20)
	public long getIdTypeMission() {
		return idTypeMission;
	}
	public void setIdTypeMission(long idTypeMission) {
		this.idTypeMission = idTypeMission;
	}
	
	@Column(name="forfait")
	public int getForfait() {
		return forfait;
	}
	public void setForfait(int forfait) {
		this.forfait = forfait;
	}
}
