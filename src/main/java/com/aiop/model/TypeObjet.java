package com.aiop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "typeobjet")
public class TypeObjet implements java.io.Serializable {

	private long idTypeObjet;
	private String libTypeObjet;
	private Set<Tarif> tarifs;

	/*
	 * Constructeur
	 */
	public TypeObjet() {
		tarifs=new HashSet<Tarif>();
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
	public Set<Tarif> getTarifs() {
		return tarifs;
	}

	public void setTarifs(Set<Tarif> tarifs) {
		this.tarifs = tarifs;
	}

}
