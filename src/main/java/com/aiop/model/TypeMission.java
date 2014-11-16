package com.aiop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name= "TypeMission" )
public class TypeMission implements java.io.Serializable{

	private long idTypeMission;
	private String libTypeMission;
	private List<TypeObjet> typeObjets;

	public TypeMission() {
		typeObjets=new ArrayList<TypeObjet>();
	}
	
	@Id
	@Column(name="idTypeMission", nullable = false, length = 20)
	public long getIdTypeMission() {
		return idTypeMission;
	}

	public void setIdTypeMission(long idTypeMission) {
		this.idTypeMission = idTypeMission;
	}
	
	@Column(name="libTypeMission",length=50)
	public String getLibTypeMission() {
		return libTypeMission;
	}

	public void setLibTypeMission(String libTypeMission) {
		this.libTypeMission = libTypeMission;
	}

	@OneToMany(mappedBy="idTypeMission",cascade = { CascadeType.ALL },targetEntity = Tarif.class,fetch = FetchType.LAZY)
	@JsonIgnore
	public List<TypeObjet> getTypeObjets() {
		return typeObjets;
	}

	public void setTypeObjets(List<TypeObjet> typeObjets) {
		this.typeObjets = typeObjets;
	}

}
