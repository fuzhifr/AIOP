package com.aiop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "TypeObjet")
public class TypeObjet implements java.io.Serializable {

	private long idTypeObjet;
	private String libTypeObjet;
	private List<Tarif> typeMissions;

	/*
	 * Constructeur
	 */
	public TypeObjet() {
		typeMissions=new ArrayList<Tarif>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToMany(mappedBy="idTypeObjet",cascade = { CascadeType.ALL },targetEntity = Tarif.class,fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Tarif> getTypeMissions() {
		return typeMissions;
	}

	public void setTypeMissions(List<Tarif> typeMissions) {
		this.typeMissions = typeMissions;
	}

}
