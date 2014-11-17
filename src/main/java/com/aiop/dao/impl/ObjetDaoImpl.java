package com.aiop.dao.impl;

import java.io.Serializable;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aiop.dao.FraisDaoI;
import com.aiop.dao.ObjetDaoI;
import com.aiop.model.Frais;
import com.aiop.model.Objet;

@Repository("objetDao")
public class ObjetDaoImpl implements ObjetDaoI {
	// sessionfactory
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public Serializable save(Objet f) {
		return getSession().save(f);
	}

	@Override
	public void update(Objet f) {	
		getSession().update(f);
	}

	@Override
	public Objet load(long id) {
		
		return (Objet) getSession().load(Objet.class, id);
	}
	@Override
	public void delete(Objet o) {
		// TODO Auto-generated method stub
		getSession().delete(o);
	}
	}

