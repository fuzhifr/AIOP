package com.aiop.dao.impl;  
  
import java.io.Serializable;  
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;  
import com.aiop.dao.UserDaoI;  
  
@Repository("userDao")  
public class UserDaoImpl<T> implements UserDaoI<T> {  
    //sessionfactory  
    @Autowired  
    private SessionFactory sessionFactory;  
  
    public Serializable save(T o) {  
        return sessionFactory.getCurrentSession().save(o);  
    }  
    
}  