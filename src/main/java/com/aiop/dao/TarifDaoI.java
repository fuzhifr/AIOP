package com.aiop.dao;  
  
import java.io.Serializable;  
import com.aiop.model.Tarif;
  
public interface TarifDaoI  
{  
    public Serializable save(Tarif a); 
    public void update(Tarif a);
	public Tarif load(long idTypeMission, long idTypeObjet);
	public void delete(Tarif t);
}  
