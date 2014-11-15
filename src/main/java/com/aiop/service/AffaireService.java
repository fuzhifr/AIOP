package com.aiop.service;  
  
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import com.aiop.dao.AffaireDaoI;
import com.aiop.dao.ScelleDaoI;
import com.aiop.model.Affaire;
import com.aiop.model.Frais;
import com.aiop.model.Objet;
import com.aiop.model.Scelle;



@Service("affaireService")  
@Transactional  
public class AffaireService    
{     
    //typeObjetdao  
    @Autowired  
    private AffaireDaoI affaireDao;  
     
    @Autowired  
    private ScelleDaoI scelleDao; 
    
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
  
    public Scelle getScelle(long idAffaire,long numeroScelle){
    	Affaire a=affaireDao.load(idAffaire);
    	List<Scelle> scelles=a.getScelles();
    	Scelle sRetour=new Scelle();
    	for(Scelle s:scelles){
    		if(s.getNumeroScelle()==numeroScelle){
    			sRetour=s;
    		}
    	}
		return sRetour;
    }

	public List<Scelle> getScelles(long idAffaire) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		return a.getScelles();
	}

	public void deleteScelle(long idAffaire, long numeroScelle) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		List<Scelle> scelles=a.getScelles();
    	for(int i=0;i<scelles.size();i++){
    		if(scelles.get(i).getNumeroScelle()==numeroScelle){
    			scelles.remove(i);
    		}
    	}
    	
    	a.setScelles(scelles);
    	affaireDao.update(a);
    	scelleDao.delete(numeroScelle);
	}

	public void addFrais(long idAffaire, Frais newFrais) {
    	Affaire aff = affaireDao.load(idAffaire);
    	List<Frais> frais = aff.getFrais();
    	frais.add(newFrais);
    	aff.setFrais(frais);
    	affaireDao.update(aff);		
	}

	public void addObjet(long idAffaire, long numeroScelle, Objet newObjet) {
		Affaire aff = affaireDao.load(idAffaire);
		Scelle sc = getScelle(idAffaire, numeroScelle);
		List<Objet> obj = sc.getListeObjets();
		obj.add(newObjet);
		affaireDao.update(aff);
		
	}
}  