package com.aiop.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="token")
public class Token implements java.io.Serializable {
	private int idToken;

	public Token() {
		//Random rd = new Random();
		//this.idToken=rd.nextLong();
	}
	@Id
	@Column(name="idToken",nullable=false)
	public int getIdToken() {
		return idToken;
	}

	public void setIdToken(int idToken) {
		this.idToken = idToken;
	}
	

}
