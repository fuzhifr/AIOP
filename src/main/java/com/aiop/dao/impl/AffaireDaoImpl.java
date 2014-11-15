package com.aiop.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
		return getSession().save(a);
	}

	@Override
	public void update(Affaire a) {
		Affaire affaire=load(a.getIdAffaire());
		//fait ajouter l'autre paramtre
		affaire.setScelles(a.getScelles());
		getSession().update(affaire);
	}

	@Override
	public Affaire load(long id) {
		Affaire a=(Affaire)getSession().get(Affaire.class, id) ;
		return a;
	}
	
	public List<Affaire> getAllAffaires() {
		return getSession().createQuery("from Produit").list();
	}

}