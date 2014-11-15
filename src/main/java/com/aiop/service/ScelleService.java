package com.aiop.service;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import com.aiop.dao.ScelleDaoI;
import com.aiop.model.Scelle;


@Service("scelleService")  
@Transactional  
public class ScelleService    
{     
    //typeObjetdao  
    @Autowired  
    private ScelleDaoI scelleDao;  
      
    public void addScelle(Scelle s)  
    {  
    	scelleDao.save(s);  
    }  
  
    public Scelle getScelle(long idScelle){
    	return scelleDao.load(idScelle);
    }
    
    public void updateScelle(Scelle s){
    	Scelle scelleUpdate=getScelle(s.getNumeroScelle());
    	scelleUpdate.setNumeroPV(s.getNumeroPV());
    	scelleUpdate.setCommentaire(s.getCommentaire());
    	scelleDao.update(scelleUpdate);
    }
}  