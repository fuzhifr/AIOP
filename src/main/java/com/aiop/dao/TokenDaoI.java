package com.aiop.dao;

import java.io.Serializable;

import com.aiop.model.Token;

public interface TokenDaoI {
	 public Serializable save(Token t);

	public int lastInsert();

	public Token load(int idTokenLast);

	public void delete(int idToken); 

}
