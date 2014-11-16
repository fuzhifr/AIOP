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
    	Scelle scelleUpdate=getScelle(s.getNumeroScelle());
    	scelleUpdate.setNumeroPV(s.getNumeroPV());
    	scelleUpdate.setCommentaire(s.getCommentaire());
    	scelleDao.update(scelleUpdate);
    }
    
    public List<TypeObjet> getAllTypesObjetsAffaire(List scelles) {
		List<TypeObjet> typeObjets = new ArrayList<TypeObjet>();
		
		//List<Objet> objets = new ArrayList<Objet>();
		Set<Objet> objets=new HashSet<Objet>();
		List<Long> listeIdTypeObjet = new ArrayList();
		HashSet hs = new HashSet();
		
		for(int i=0;i<scelles.size();i++){
			objets=((Scelle) scelles.get(i)).getObjets();
			/*for(int j=0;j<objets.size();j++){
				listeIdTypeObjet.add(objets.get(j).getIdTypeObjet());		
			}*/
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
		
		for(int i=0;i<listeIdTypeObjet.size();i++){
			//typeObjets.add(listeIdTypeObjet.get(i).getObjetById());
			typeObjets.add(typeObjetService.getObjetById(listeIdTypeObjet.get(i)));
		}
		return typeObjets;
	}
}  