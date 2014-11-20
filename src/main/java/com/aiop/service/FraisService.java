
package com.aiop.service;  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import com.aiop.dao.FraisDaoI;
import com.aiop.model.Frais;


@Service("fraisService")  
@Transactional  
public class FraisService    
{     
    @Autowired  
    private FraisDaoI fraisDao;  
      
    public void addFrais(Frais f)  
    {  
    	fraisDao.save(f);  
    }  
    
    public void delete(long idFrais) {	
    	fraisDao.delete(idFrais);
	}
  
    
}  