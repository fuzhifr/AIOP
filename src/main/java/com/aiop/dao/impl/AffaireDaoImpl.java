package com.aiop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aiop.dao.AffaireDaoI;
import com.aiop.model.Affaire;

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
		getSession().update(a);
	}

	@Override
	public Affaire load(long id) {
		Affaire a=(Affaire)getSession().get(Affaire.class, id) ;
		return a;
	}
	
	@SuppressWarnings("unchecked")
	public List<Affaire> getAllAffaires() {
		return getSession().createQuery("from Affaire").list();
	}

	@Override
	public void delete(long idAffaire) {
		Affaire a=(Affaire) getSession().load(Affaire.class, idAffaire);
		getSession().delete(a);
		
	}

}