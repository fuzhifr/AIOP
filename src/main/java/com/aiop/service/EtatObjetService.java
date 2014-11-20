package com.aiop.service;  
  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import com.aiop.dao.EtatObjetDaoI;
import com.aiop.model.EtatObjet;




@Service("etatObjetService")  
@Transactional  
public class EtatObjetService    
{     
    //typeObjetdao  
    @Autowired  
    private EtatObjetDaoI etatObjetDao;

	public String addEtatObjet(long idTypeObjet, long idTypeMission, int forfait) {
		// TODO Auto-generated method stub
		/*String msg = "fail";
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
		}*/
		return null;
	}

  
	public EtatObjet getEtatObjet(long idObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		EtatObjet t=etatObjetDao.load(idObjet, idTypeMission);
		return t;
	}  

}  