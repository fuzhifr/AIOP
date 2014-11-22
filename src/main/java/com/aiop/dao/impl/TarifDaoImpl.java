package com.aiop.dao.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aiop.dao.ScelleDaoI;
import com.aiop.dao.TarifDaoI;
import com.aiop.model.Scelle;
import com.aiop.model.Tarif;
import com.aiop.model.TypeMission;

@Repository("tarifDao")
public class TarifDaoImpl implements TarifDaoI {
	// sessionfactory
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Serializable save(Tarif s) {
		return getSession().save(s);
	}

	@Override
	public Tarif load(long idTypeMission,long idTypeObjet) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("from Tarif t where t.idTypeObjet=:idTypeObjet and t.idTypeMission=:idTypeMission");
		query.setLong("idTypeObjet", idTypeObjet);
		query.setLong("idTypeMission", idTypeMission);
		List list=query.list();
		if(list.size()==0){
			return null;
		}
		return (Tarif) list.get(0);
	}

	@Override
	public void update(Tarif s) {
		// TODO Auto-generated method stub
		getSession().update(s);
	}

	@Override
	public void delete(Tarif t) {
		// TODO Auto-generated method stub
		getSession().delete(t);
	}

	@Override
	public Set<TypeMission> loadNotAffected(long idTypeObjet) {
		Query query=getSession().createQuery("from TypeMission as typMiss where typMiss.idTypeMission in (select t.idTypeMission from Tarif as t where t.idTypeMission=:idTypeObjet)");
		query.setLong("idTypeObjet", idTypeObjet);
		Set<TypeMission>tm=null;
		List<TypeMission> list=query.list();
		tm=new HashSet<TypeMission>(list);
		return tm;
	}

}