package com.aiop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aiop.dao.EtatObjetDaoI;
import com.aiop.model.EtatObjet;

@Repository("etatObjetDao")
public class EtatObjetDaoImpl implements EtatObjetDaoI {
	// sessionfactory
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public Serializable save(EtatObjet a) {
		// TODO Auto-generated method stub
		  return getSession().save(a);
	}

	@Override
	public void update(EtatObjet a) {
		// TODO Auto-generated method stub
		EtatObjet ld=this.load(a.getIdObjet(), a.getIdTypeMission());
		if(ld!=null){
		ld.setCommentaire(a.getCommentaire());
		ld.setFait(a.getFait());
		getSession().update(ld);
		}
	}

	@Override
	public EtatObjet load(long idObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("from EtatObjet eo where eo.idTypeMission=:idTypeMission and eo.idObjet=:idObjet");
		query.setLong("idTypeMission", idTypeMission);
		query.setLong("idObjet", idObjet);
		
		@SuppressWarnings("rawtypes")
		List list=query.list();
		if(list.size()==0){
			return null;
		}
		return (EtatObjet) list.get(0);
	}

	@Override
	public void delete(long idObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		EtatObjet ld=this.load(idObjet, idTypeMission);
		if(ld!=null){
		getSession().delete(ld);
		}
	}


}