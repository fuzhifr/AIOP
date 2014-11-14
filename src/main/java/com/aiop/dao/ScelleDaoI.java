package com.aiop.dao;  
  
import java.io.Serializable;  


import com.aiop.model.Scelle;

  
public interface ScelleDaoI  
{  
    public Serializable save(Scelle s); 
    public Scelle load(long idScelle);
    public void update(Scelle s);
	public void delete(long numeroScelle);
}  

