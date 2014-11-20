package com.aiop.dao;  
  
import java.io.Serializable;  
import com.aiop.model.Objet;
  
public interface ObjetDaoI  
{  
    public Serializable save(Objet a); 
    public void update(Objet a);
    public Objet load(long id);
	void delete(Objet o);
}  
