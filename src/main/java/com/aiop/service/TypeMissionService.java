package com.aiop.service;  
  
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
  
}  