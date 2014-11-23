package com.aiop.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aiop.dao.TokenDaoI;
import com.aiop.model.Token;

@Repository("tokenDao")
public class TokenDaoImpl implements TokenDaoI {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int save(Token t) {
		 getSession().save(t);
		 return t.getIdToken();

	}
	@Override
	public int lastInsert() {
		int id=0;
		String SQL = "SELECT LAST_INSERT_ID() FROM Token ";
		id=(Integer) getSession().createQuery(SQL.toString()).uniqueResult();
		return id;
	}
	@Override
	public Token load(int idTokenLast) {
		Token t=(Token)getSession().get(Token.class, idTokenLast) ;
		return t;
	}
	@Override
	public void delete(int idToken) {
		Token t=(Token) getSession().load(Token.class, idToken);
		getSession().delete(t);
		
	}

}
