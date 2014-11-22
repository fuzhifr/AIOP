package com.aiop.dao;

import java.io.Serializable;  
import java.util.Set;

import com.aiop.model.LigneDevis;
import com.aiop.model.TypeMission;

public interface LigneDevisDaoI {
	
    public Serializable save(LigneDevis ligne); 
    public LigneDevis load(long idAffaire, long idTypeObjet, long idTypeMission);
    public Set<TypeMission> load(long idAffaire, long idTypeObjet);
    public void update(LigneDevis ligne);
	public void delete(long idAffaire, long idTypeObjet, long idTypeMission);
	public Set<TypeMission> loadAffected(long idAffaire, long idTypeObjet);

}
