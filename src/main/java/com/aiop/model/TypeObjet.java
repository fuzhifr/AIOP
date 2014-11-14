package com.aiop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TypeObjet")
public class TypeObjet implements java.io.Serializable {

	private long idTypeObjet;
	private String libTypeObjet;
	private List<TypeMission> typeMissions;

	/*
	 * Constructeur
	 */
	public TypeObjet() {
		typeMissions=new ArrayList<TypeMission>();
	}

	@Id
	@Column(name = "idTypeObjet", nullable = false, length = 20)
	public long getIdTypeObjet() {
		return idTypeObjet;
	}

	public void setIdTypeObjet(long idTypeObjet) {
		this.idTypeObjet = idTypeObjet;
	}

	@Column(name = "libTypeObjet", length = 50)
	public String getLibTypeObjet() {
		return libTypeObjet;
	}

	public void setLibTypeObjet(String libTypeObjet) {
		this.libTypeObjet = libTypeObjet;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "Tarif", joinColumns =@JoinColumn(name = "idTypeObjet"), inverseJoinColumns =@JoinColumn(name = "idTypeMission"))
	public List<TypeMission> getTypeMissions() {
		return typeMissions;
	}

	public void setTypeMissions(List<TypeMission> typeMissions) {
		this.typeMissions = typeMissions;
	}

}
