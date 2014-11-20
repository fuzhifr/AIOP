package com.aiop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aiop.dao.LigneDevisDaoI;
import com.aiop.model.LigneDevis;

@Repository("ligneDevisDao")
public class LigneDevisDaoImpl implements LigneDevisDaoI {
	// sessionfactory
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(LigneDevis ligne) {
		// TODO Auto-generated method stub
		 return getSession().save(ligne);
	}

	@Override
	public LigneDevis load(long idAffaire, long idTypeObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("from LigneDevis ld where ld.idTypeObjet=:idTypeObjet and ld.idTypeMission=:idTypeMission and ld.idAffaire=:idAffaire");
		query.setLong("idTypeObjet", idTypeObjet);
		query.setLong("idTypeMission", idTypeMission);
		query.setLong("idAffaire", idAffaire);
		
		@SuppressWarnings("rawtypes")
		List list=query.list();
		if(list.size()==0){
			return null;
		}
		return (LigneDevis) list.get(0);
	}

	@Override
	public void update(LigneDevis ligne) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long idAffaire, long idTypeObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		LigneDevis ld=this.load(idAffaire, idTypeObjet, idTypeMission);
		if(ld!=null){
		getSession().delete(ld);
		}
	}

}