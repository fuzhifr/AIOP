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

import com.aiop.dao.TarifDaoI;
import com.aiop.model.Tarif;
import com.aiop.model.TypeMission;



@Service("tarifService")  
@Transactional  
public class TarifService    
{     
    //typeObjetdao  
    @Autowired  
    private TarifDaoI tarifDao;

	public Tarif addTypeMission(long idTypeObjet, long idTypeMission, int forfait) {
		// TODO Auto-generated method stub
		Tarif t=tarifDao.load(idTypeMission, idTypeObjet);
		if(t!=null){
			return t;
		}else{
			t=new Tarif();
			t.setIdTypeMission(idTypeMission);
			t.setIdTypeObjet(idTypeObjet);
			t.setForfait(forfait);
			tarifDao.save(t);
		}
		return t;
	}

	public void deleteTypeMission(long idTypeObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		Tarif t=tarifDao.load(idTypeMission, idTypeObjet);
		tarifDao.delete(t);
	}  
  
	public Tarif getTarif(long idTypeObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		Tarif t=tarifDao.load(idTypeMission, idTypeObjet);
		return t;
	}
	@SuppressWarnings("rawtypes")
	public Set<TypeMission> getTypeMissionNotAssignedWTypeObjetID(
			long idTypeObjet) {
				Set<TypeMission> typesMission=tarifDao.loadNotAffected(idTypeObjet);
				return typesMission;
	}  

}  