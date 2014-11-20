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

	public EtatObjet addEtatObjet(EtatObjet eo) {
		// TODO Auto-generated method stub
		EtatObjet t=etatObjetDao.load(eo.getIdObjet(), eo.getIdTypeMission());
		if(t!=null){
			String msg="l'etat existe";
			return null;
		}else{
			etatObjetDao.save(eo);
			return eo;
		}
	}

  
	public EtatObjet getEtatObjet(long idObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		EtatObjet t=etatObjetDao.load(idObjet, idTypeMission);
		return t;
	}


	public EtatObjet updateEtatObjet(EtatObjet newEtatObjet) {
		// TODO Auto-generated method stub
		EtatObjet t=etatObjetDao.load(newEtatObjet.getIdObjet(), newEtatObjet.getIdTypeMission());
		t.setCommentaire(newEtatObjet.getCommentaire());
		t.setFait(newEtatObjet.getFait());
		etatObjetDao.update(t);
		return t;
	}  

}  