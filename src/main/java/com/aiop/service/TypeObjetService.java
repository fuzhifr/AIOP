package com.aiop.service;  
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import com.aiop.dao.TypeMissionDaoI;
import com.aiop.dao.TypeObjetDaoI;
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

	public void addTypeMission(long idTypeObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		TypeObjet to=typeObjetDao.load(idTypeObjet);
		List<TypeMission> typeMissions=to.getTypeMissions();
		TypeMission tm=typeMissionDao.load(idTypeMission);
		typeMissions.add(tm);
		to.setTypeMissions(typeMissions);
		typeObjetDao.update(to);
	}
	
	public void deleteTypeMission(long idTypeObjet,long idTypeMission){
		TypeObjet to=typeObjetDao.load(idTypeObjet);
		List<TypeMission> typeMissions=to.getTypeMissions();
		TypeMission tm=typeMissionDao.load(idTypeMission);
		typeMissions.remove(tm);
		to.setTypeMissions(typeMissions);
		typeObjetDao.update(to);
	}
}  