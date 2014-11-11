package com.aiop.service;  
  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import com.aiop.dao.TypeObjetDaoI;
import com.aiop.model.TypeObjet;
@Service("typeObjetService")  
@Transactional  
public class TypeObjetService    
{     
    //typeObjetdao  
    @Autowired  
    private TypeObjetDaoI<TypeObjet> typeObjetDao;  
      
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
}  