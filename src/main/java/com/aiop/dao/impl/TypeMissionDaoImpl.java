package com.aiop.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aiop.dao.TypeMissionDaoI;
import com.aiop.model.TypeMission;

@Repository("typeMissionDao")
public class TypeMissionDaoImpl<T> implements TypeMissionDaoI<T> {
	// sessionfactory
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Serializable save(T o) {
		return getSession().save(o);
	}

	@Override
	public TypeMission load(long idTypeMission) {
		// TODO Auto-generated method stub
		return (TypeMission) getSession().load(TypeMission.class, idTypeMission);
	}

	@Override
	public void update(TypeMission tm) {
		// TODO Auto-generated method stub
		getSession().update(tm);
		
	}

}