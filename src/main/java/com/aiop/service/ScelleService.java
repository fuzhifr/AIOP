package com.aiop.service;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.aiop.dao.ScelleDaoI;
import com.aiop.dao.TypeObjetDaoI;
import com.aiop.model.Objet;
import com.aiop.model.Scelle;
import com.aiop.model.TypeObjet;

@Service("scelleService")  
@Transactional  
public class ScelleService    
{     
    //typeObjetdao  
    @Autowired  
    private ScelleDaoI scelleDao;  
    
    @Autowired  
    private TypeObjetService typeObjetService;
    
    @Autowired  
    private TypeObjetDaoI typeObjetDao;
    
    public void addScelle(Scelle s)  
    {  
    	scelleDao.save(s);  
    }  
  
    public Scelle getScelle(long idScelle){
    	return scelleDao.load(idScelle);
    }
    
    public void updateScelle(Scelle s){

    	scelleDao.update(s);
    }
    
    public Set<TypeObjet> getAllTypesObjetsAffaire(Set<Scelle> scelles) {
		Set<TypeObjet> typeObjets = new HashSet<TypeObjet>();
		
		//List<Objet> objets = new ArrayList<Objet>();
		Set<Objet> objets=new HashSet<Objet>();
		Set<Long> listeIdTypeObjet = new HashSet<Long>();
		Iterator <Scelle> it=scelles.iterator();
		while(it.hasNext()){
			objets=it.next().getObjets();
			Iterator <Objet> iterator = objets.iterator();
			while (iterator.hasNext()) {
				Objet obj =iterator.next();
				listeIdTypeObjet.add(obj.getIdTypeObjet());
			 
			}
		}
		
		Iterator<Long> listeID=listeIdTypeObjet.iterator();
		while(listeID.hasNext()){
			typeObjets.add(typeObjetDao.load(listeID.next()));
		}
		return typeObjets;
	}

	
}  