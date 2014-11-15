package com.aiop.dao;

import java.io.Serializable;  
import com.aiop.model.LigneDevis;

public interface LigneDevisDaoI {
	
    public Serializable save(LigneDevis ligne); 
    public LigneDevis load(long idAffaire, long idTypeObjet, long idTypeMission);
    public void update(LigneDevis ligne);
	public void delete(long idAffaire, long idTypeObjet, long idTypeMission);

}
