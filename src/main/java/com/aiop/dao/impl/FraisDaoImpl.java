package com.aiop.dao.impl;

import java.io.Serializable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aiop.dao.FraisDaoI;
import com.aiop.model.Frais;

@Repository("fraisDao")
public class FraisDaoImpl implements FraisDaoI {
	// sessionfactory
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public Serializable save(Frais f) {
		return getSession().save(f);
	}

	@Override
	public void update(Frais f) {
		Frais fr=load(f.getIdFrais());
		//fait ajouter l'autre paramtre
		getSession().update(fr);
	}

	@Override
	public Frais load(long id) {
		Frais f=(Frais)getSession().get(Frais.class, id) ;
		return f;
	}
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Frais f=(Frais) getSession().load(Frais.class, id);
		getSession().delete(f);
	}
	}

