package com.aiop.service;  
  
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import com.aiop.dao.TarifDaoI;
import com.aiop.dao.TypeMissionDaoI;
import com.aiop.dao.TypeObjetDaoI;
import com.aiop.model.Tarif;
import com.aiop.model.TypeMission;
import com.aiop.model.TypeObjet;
@Service("typeObjetService")  
@Transactional  
public class TypeObjetService    
{     
    //typeObjetdao  
    @Autowired  
    private TypeObjetDaoI<TypeObjet> typeObjetDao;  
    
    @Autowired  
    private TypeMissionDaoI<TypeMission> typeMissionDao;  
      
    @Autowired  
    private TarifDaoI tarifDao; 
    
    public void addTypeObjet(TypeObjet to)  
    {  
        typeObjetDao.save(to);  
    }  
  
    public TypeObjet getTypeObjet(Long id){
    	return typeObjetDao.load(id);
    }
    
    public List<TypeObjet> getTypeObjets(){
		return typeObjetDao.getTypeObjets();
    	
    }

	public Tarif getTypeMission(long idTypeObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		TypeObjet to=typeObjetDao.load(idTypeObjet);
		Set<Tarif> typeMissions=to.getTarifs();
		Iterator<Tarif> it=typeMissions.iterator();
		while(it.hasNext()){
			Tarif temps=it.next();
			if(temps.getIdTypeMission()==idTypeMission){
				return temps;
			}
		}
		return null;
	}

	public void modifieInfo(long idTypeObjet, long idTypeMission,
			String libTypeMission, int forfait) {
		// TODO Auto-generated method stub
		TypeObjet to=typeObjetDao.load(idTypeObjet);
		Set<Tarif> ts=to.getTarifs();
		Tarif t=new Tarif();
		Iterator<Tarif> it=ts.iterator();
		while(it.hasNext()){
			Tarif temps=it.next();
			if(temps.getIdTypeMission()==idTypeMission){
				t=temps;
				break;
			}
		}
		t.setForfait(forfait);
		TypeMission  tm=typeMissionDao.load(idTypeMission);
		tm.setLibTypeMission(libTypeMission);
		tarifDao.update(t);
		typeMissionDao.update(tm);
	}
	
	public TypeObjet getObjetById(long idTypeObjet) {
		return  typeObjetDao.getProduitById(idTypeObjet);
	}

}  