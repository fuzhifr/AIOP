package com.aiop.dao;  
  
import java.io.Serializable;  
import java.util.List;

import com.aiop.model.Affaire;
import com.aiop.model.Objet;
  
public interface ObjetDaoI  
{  
    public Serializable save(Objet a); 
    public void update(Objet a);
    public Objet load(long id);
	void delete(Objet o);
}  
