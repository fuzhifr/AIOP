package com.aiop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "TypeMission" )
public class TypeMission implements java.io.Serializable{

	private long idTypeMission;
	private String libTypeMission;

	@Id
	@Column(name="idTypeMission", nullable = false, length = 20)
	public long getIdTypeMission() {
		return idTypeMission;
	}

	public void setIdTypeMission(long idTypeMission) {
		this.idTypeMission = idTypeMission;
	}
	
	@Column(name="libTypeMission")
	public String getLibTypeMission() {
		return libTypeMission;
	}

	public void setLibTypeMission(String libTypeMission) {
		this.libTypeMission = libTypeMission;
	}

}
