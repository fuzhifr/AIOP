package com.aiop.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aiop.dao.ScelleDaoI;
import com.aiop.model.Scelle;

@Repository("scelleDao")
public class ScelleDaoImpl implements ScelleDaoI {
	// sessionfactory
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Serializable save(Scelle s) {
		return getSession().save(s);
	}

	@Override
	public Scelle load(long idScelle) {
		// TODO Auto-generated method stub
		return (Scelle) getSession().load(Scelle.class, idScelle);
	}

	@Override
	public void update(Scelle s) {
		// TODO Auto-generated method stub
		getSession().update(s);
	}

	@Override
	public void delete(long numeroScelle) {
		// TODO Auto-generated method stub
		Scelle s=(Scelle) getSession().load(Scelle.class, numeroScelle);
		getSession().delete(s);
	}

}