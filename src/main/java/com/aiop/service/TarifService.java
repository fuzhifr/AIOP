package com.aiop.service;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  
import com.aiop.dao.TarifDaoI;
import com.aiop.model.Tarif;



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

}  