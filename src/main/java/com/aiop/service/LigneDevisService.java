package com.aiop.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiop.dao.FraisDaoI;
import com.aiop.dao.LigneDevisDaoI;
import com.aiop.model.TypeMission;

@Service("ligneDevisService")  
@Transactional  
public class LigneDevisService {
	@Autowired  
    private LigneDevisDaoI ligneDevisDao;

	public Set<TypeMission> getAllTypeMissionsForTypeObjetAffaire(
			long idAffaire, long idTypeObjet) {
		//récuprer la liste des id de types missions
		Set<TypeMission> typesMission=ligneDevisDao.load(idAffaire,idTypeObjet);
		return typesMission;
	} 
	
	

}
