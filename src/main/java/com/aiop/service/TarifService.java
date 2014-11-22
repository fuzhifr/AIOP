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

	public String addTypeMission(long idTypeObjet, long idTypeMission, int forfait) {
		// TODO Auto-generated method stub
		String msg = "fail";
		Tarif t=tarifDao.load(idTypeMission, idTypeObjet);
		if(t!=null){
			msg="le Tarif existe";
		}else{
			t=new Tarif();
			t.setIdTypeMission(idTypeMission);
			t.setIdTypeObjet(idTypeObjet);
			t.setForfait(forfait);
			tarifDao.save(t);
			msg="Success";
		}
		return msg;
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
	public Set<JSONObject> getTypeMissionNotAssignedWTypeObjetID(
			long idTypeObjet) {
		//récuprer la liste des id de types missions
				Set<JSONObject> sJson=new HashSet<JSONObject>();
				Set<TypeMission> typesMission=tarifDao.loadNotAffected(idTypeObjet);
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

}  