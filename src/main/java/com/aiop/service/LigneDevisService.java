package com.aiop.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiop.dao.LigneDevisDaoI;
import com.aiop.dao.TarifDaoI;
import com.aiop.model.LigneDevis;
import com.aiop.model.TypeMission;

@Service("ligneDevisService")  
@Transactional  
public class LigneDevisService {
	@Autowired  
    private LigneDevisDaoI ligneDevisDao;
	@Autowired  
    private TarifDaoI tarifDao;
//Les types mission non affectées à un type objet
	public Set<JSONObject> getAllTypeMissionsForTypeObjetAffaire(
			long idAffaire, long idTypeObjet) {
		//récuprer la liste des id de types missions
		Set<JSONObject> sJson=new HashSet<JSONObject>();
		Set<TypeMission> typesMission=ligneDevisDao.load(idAffaire,idTypeObjet);
		Iterator<TypeMission> itm=typesMission.iterator();
		while(itm.hasNext()){
			TypeMission tm=itm.next();
			int forfait=tarifDao.load(tm.getIdTypeMission(), idTypeObjet).getForfait();
			Map<String, Comparable> mapTM=new HashMap<String, Comparable>();
			mapTM.put("idTypeMission", tm.getIdTypeMission());
			mapTM.put("libTypeMission", tm.getLibTypeMission());
			mapTM.put("forfait", forfait);
			sJson.add(JSONObject.fromObject(mapTM));
		}
		return sJson;
	}
	
//Les types mission affectées à un typeObjet
	@SuppressWarnings("rawtypes")
	public Set<JSONObject> getAllTypeMissionsAffectedToTypeObjet(
			long idAffaire, long idTypeObjet) {
		Set<JSONObject> sJson=new HashSet<JSONObject>();
		Set<TypeMission> typesMission=ligneDevisDao.loadAffected(idAffaire,idTypeObjet);
		Iterator<TypeMission> itm=typesMission.iterator();
		while(itm.hasNext()){
			TypeMission tm=itm.next();
			int forfait=tarifDao.load(tm.getIdTypeMission(), idTypeObjet).getForfait();
			long idLigneDevis=ligneDevisDao.load(idAffaire, idTypeObjet, tm.getIdTypeMission()).getIdLigneDevis();
			Map<String, Comparable> mapTM=new HashMap<String, Comparable>();
			mapTM.put("idTypeMission", tm.getIdTypeMission());
			mapTM.put("idLigneDevis", idLigneDevis);
			mapTM.put("libTypeMission", tm.getLibTypeMission());
			mapTM.put("forfait", forfait);
			sJson.add(JSONObject.fromObject(mapTM));
		}
		return sJson;
	}

	public void putLigneDevis(long idAffaire, long idTypeObjet,
			long idTypeMission, LigneDevis ld) {
		// TODO Auto-generated method stub
		LigneDevis ligneDevis=ligneDevisDao.load(idAffaire, idTypeObjet, idTypeMission);
		ligneDevis.setMontantDevis(ld.getMontantDevis());
		ligneDevis.setQuantiteDevis(ld.getQuantiteDevis());
		ligneDevis.setNbObjets(ld.getNbObjets());
		ligneDevisDao.update(ligneDevis);
	} 
	
	
	
	
	

}
