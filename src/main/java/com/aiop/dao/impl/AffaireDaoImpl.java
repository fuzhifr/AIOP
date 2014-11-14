package com.aiop.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aiop.dao.AffaireDaoI;
import com.aiop.dao.ScelleDaoI;
import com.aiop.model.Affaire;
import com.aiop.model.Scelle;

@Repository("affaireDao")
public class AffaireDaoImpl implements AffaireDaoI {
	// sessionfactory
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(Affaire a) {
		// TODO Auto-generated method stub
		return getSession().save(a);
	}

	@Override
	public void update(Affaire a) {
		// TODO Auto-generated method stub
		Affaire affaire=load(a.getIdAffaire());
		affaire.setScelles(a.getScelles());
		getSession().update(affaire);
	}

	@Override
	public Affaire load(long id) {
		// TODO Auto-generated method stub
		Affaire a=(Affaire)getSession().get(Affaire.class, id) ;
		if(a.getScelles()==null){
			a.setScelles(new ArrayList<Scelle>());
		}
		return a;
	}

}