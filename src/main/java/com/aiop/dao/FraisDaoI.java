package com.aiop.dao;  

import java.io.Serializable;  

import com.aiop.model.Frais;

  
public interface FraisDaoI  
{  
    public Serializable save(Frais f); 
    public void update(Frais f);
    public Frais load(long id);
    public void delete( long id);
	//public List<Frais> getAllFrais();
}  