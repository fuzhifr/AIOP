package com.aiop.service;  
  
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import com.aiop.dao.TypeMissionDaoI;
import com.aiop.model.TypeMission;

@Service("typeMissionService")  
@Transactional  
public class TypeMissionService    
{     
    //typeObjetdao  
    @Autowired  
    private TypeMissionDaoI<TypeMission> typeMissionDao;  
      
    public void addTypeMission(TypeMission tm)  
    {  
        typeMissionDao.save(tm);  
    }

	public Set<TypeMission> getTypeMissionNotAssignedWTypeObjet() {
		 
		Set<TypeMission>tm=typeMissionDao.getTypeMissionNotAssignedWTypeObjet();
		Set<TypeMission> typeMiss = new HashSet<TypeMission>();
		Iterator<TypeMission> it=tm.iterator();
		while(it.hasNext()){
			TypeMission temp=it.next();
			if(temp.getTypeObjets().isEmpty()){
				typeMiss.add(temp);		
			}
		}
		return typeMiss;
	}  
  
}  