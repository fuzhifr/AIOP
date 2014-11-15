package com.aiop.dao.impl;  
  
import java.io.Serializable;  
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;  

import com.aiop.dao.TypeObjetDaoI; 
import com.aiop.model.TypeObjet;
  
@Repository("typeObjetDao")  
public class TypeObjetDaoImpl<T> implements TypeObjetDaoI<T> {  
    //sessionfactory  
    @Autowired  
    private SessionFactory sessionFactory;  
  
    public Session getSession(){
    	return sessionFactory.getCurrentSession();
    }
    public Serializable save(T o) {  
        return getSession().save(o);  
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getTypeObjets() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from TypeObjet").list();
	}
	@Override
	public TypeObjet load(long id) {
		// TODO Auto-generated method stub
		return (TypeObjet) getSession().get(TypeObjet.class, id);
	}
	@Override
	public void update(TypeObjet to) {
		// TODO Auto-generated method stub
		getSession().update(to);
	}
}  