package com.aiop.model;

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

	}

	public TypeObjet(long idTypeObjet) {
		// TODO Auto-generated constructor stub
		this.setIdTypeObjet(idTypeObjet);
	}

	/*
	 * Methode
	 */
	public void deleteTypeMission(long idTypeMission) {

	}

	public TypeMission getTypeMission(long idTypeMission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Id
	@Column(name = "idTypeObjet", nullable = false, length = 20)
	public long getIdTypeObjet() {
		return idTypeObjet;
	}

	public void setIdTypeObjet(long idTypeObjet) {
		this.idTypeObjet = idTypeObjet;
	}

	@Column(name = "libTypeObjet", length = 30)
	public String getLibTypeObjet() {
		return libTypeObjet;
	}

	public void setLibTypeObjet(String libTypeObjet) {
		this.libTypeObjet = libTypeObjet;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_typeobjet_typeMission", joinColumns =@JoinColumn(name = "typeObjet_id"), inverseJoinColumns =@JoinColumn(name = "typeMission_id"))
	public List<TypeMission> getTypeMissions() {
		return typeMissions;
	}

	public void setTypeMissions(List<TypeMission> typeMissions) {
		this.typeMissions = typeMissions;
	}

}
