package com.aiop.service;  
  
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import com.aiop.dao.AffaireDaoI;
import com.aiop.dao.ScelleDaoI;
import com.aiop.model.Affaire;
import com.aiop.model.Scelle;



@Service("affaireService")  
@Transactional  
public class AffaireService    
{     
    //typeObjetdao  
    @Autowired  
    private AffaireDaoI affaireDao;  
      
    public void addAffaire(Affaire a)  
    {  
    	affaireDao.save(a);  
    }  
    
    public void addScelle(long idAffaire,Scelle s){
    	Affaire a=affaireDao.load(idAffaire);
    	List<Scelle> scelles=a.getScelles();
    	scelles.add(s);
    	a.setScelles(scelles);
    	affaireDao.update(a);
    }
  
}  