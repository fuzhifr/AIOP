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

import com.aiop.dao.LigneDevisDaoI;
import com.aiop.model.LigneDevis;
import com.aiop.model.TypeMission;

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

	@Override
	public Set<TypeMission> load(long idAffaire, long idTypeObjet) {
		Query query=getSession().createQuery("from TypeMission as typMiss where typMiss.idTypeMission not in (select ld.idTypeMission from LigneDevis as ld where ld.idAffaire=:idAffaire and ld.idTypeObjet=:idTypeObjet) AND typMiss.idTypeMission in (select t.idTypeMission from Tarif as t where t.idTypeObjet=:idTypeObjet)");
		query.setLong("idTypeObjet", idTypeObjet);
		query.setLong("idAffaire", idAffaire);
		Set<TypeMission>tm=null;
		List<TypeMission> list=query.list();
		tm=new HashSet<TypeMission>(list);
		return tm;
	}

	@Override
	public Set<TypeMission> loadAffected(long idAffaire, long idTypeObjet) {
		
		Query query=getSession().createQuery("from TypeMission as typMiss where typMiss.idTypeMission in (select ld.idTypeMission from LigneDevis as ld where ld.idAffaire=:idAffaire and ld.idTypeObjet=:idTypeObjet)");
		query.setLong("idTypeObjet", idTypeObjet);
		query.setLong("idAffaire", idAffaire);
		Set<TypeMission>tm=null;
		List<TypeMission> list=query.list();
		tm=new HashSet<TypeMission>(list);
		return tm;
	}

}