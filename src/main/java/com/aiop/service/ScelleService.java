package com.aiop.service;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.aiop.dao.ScelleDaoI;
import com.aiop.model.Frais;
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
		Set<Long> listeIdTypeObjet = new HashSet();
		HashSet hs = new HashSet();
		Iterator <Scelle> it=scelles.iterator();
		while(it.hasNext()){
			objets=it.next().getObjets();
			Iterator <Objet> iterator = objets.iterator();
			while (iterator.hasNext()) {
				Objet obj =iterator.next();
				listeIdTypeObjet.add(obj.getIdTypeObjet());
			 
			}
		}
		// add elements including duplicates
		hs.addAll(listeIdTypeObjet);
		listeIdTypeObjet.clear();
		//delete duplicate
		listeIdTypeObjet.addAll(hs);
		
		Iterator<Long> listeID=listeIdTypeObjet.iterator();
		while(listeID.hasNext()){
			typeObjets.add(typeObjetService.getObjetById(listeID.next()));
		}
		return typeObjets;
	}
}  