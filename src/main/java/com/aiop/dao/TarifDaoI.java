package com.aiop.dao;  
  
import java.io.Serializable;  
import java.util.Set;

import com.aiop.model.Tarif;
import com.aiop.model.TypeMission;
  
public interface TarifDaoI  
{  
    public Serializable save(Tarif a); 
    public void update(Tarif a);
	public Tarif load(long idTypeMission, long idTypeObjet);
	public void delete(Tarif t);
	public Set<TypeMission> loadNotAffected(long idTypeObjet);
}  
