package com.aiop.dao;  
  
import java.io.Serializable;  
import com.aiop.model.EtatObjet;
  
public interface EtatObjetDaoI  
{  
    public Serializable save(EtatObjet a); 
    public void update(EtatObjet a);
	public EtatObjet load(long idObjet, long idTypeMission);
	public void delete(long idObjet, long idTypeMission);
}  
