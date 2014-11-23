package com.aiop.service;  
  
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

import com.aiop.dao.AffaireDaoI;
import com.aiop.dao.LigneDevisDaoI;
import com.aiop.dao.ObjetDaoI;
import com.aiop.dao.ScelleDaoI;
import com.aiop.dao.TypeMissionDaoI;
import com.aiop.model.Affaire;
import com.aiop.model.EtatObjet;
import com.aiop.model.Frais;
import com.aiop.model.LigneDevis;
import com.aiop.model.Objet;
import com.aiop.model.Scelle;
import com.aiop.model.TypeMission;



@Service("affaireService")  
@Transactional  
public class AffaireService    
{     
    //typeObjetdao  
    @Autowired  
    private AffaireDaoI affaireDao;

     
    @Autowired  
    private ScelleDaoI scelleDao;
    
    @Autowired  
    private ObjetDaoI objetDao;
    
    @Autowired  
    private LigneDevisDaoI ligneDevisDao;
    
    @Autowired  
    private TypeMissionDaoI typeMissionDao;
    
    @Autowired  
    private FraisService fraisService;
    
    @Autowired  
    private EtatObjetService etatObjetService;
    
    public Affaire loadAffaire(long idAffaire)  
    {  
    	return affaireDao.load(idAffaire); 
    } 
    
    												/* GET simples methodes*/
   
	
    public Scelle getScelle(long idAffaire,long idScelle){
    	Affaire a=affaireDao.load(idAffaire);
    	Set<Scelle> scelles=a.getScelles();
    	Scelle sRetour=new Scelle();
    	for(Scelle s:scelles){
    		long numero=s.getIdScelle();
    		if(numero==idScelle){
    			sRetour=s;
    		}
    	}
		return sRetour;
    }
    
    public Frais getFrais(long idAffaire,long idFrais){
    	Affaire aff = affaireDao.load(idAffaire);
    	Set<Frais> scelles=aff.getFrais();
    	Frais sRetour=new Frais();
    	for(Frais s:scelles){
    		if(s.getIdFrais()==idFrais){
    			sRetour=s;
    		}
    	}
		return sRetour;
    }
    
    public String getEtat(long idAffaire) {
		Affaire a=affaireDao.load(idAffaire);
		return a.getEtat();
	}
  
												/* GET liste methodes*/
    
	public List<Affaire> getAllAffaires() {
		return affaireDao.getAllAffaires();
	}
	
    public Set<Scelle> getScelles(long idAffaire) {
		Affaire a=affaireDao.load(idAffaire);
		return a.getScelles();
	}
    
    public Set<Frais> getFrais(long idAffaire) {
		Affaire a=affaireDao.load(idAffaire);
		return a.getFrais();
	}
    public Set<LigneDevis> getLignesDevis(long idAffaire) {
		Affaire a=affaireDao.load(idAffaire);
		return a.getLignesDevis();
	}
	public Set<Objet> getObjetScelle(long idAffaire, long idScelle) {
		Scelle sc = getScelle(idAffaire,idScelle);
		return sc.getObjets();
	}
	
	public void deleteFrais(long idAffaire, long idFrais) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		Set<Frais> frais=a.getFrais();
		Iterator <Frais> iterator = frais.iterator();
		while (iterator.hasNext()) {
			Frais f =iterator.next();
		 if(f.getIdFrais()==idFrais){
			 iterator.remove();
		 }
		}
		
    	a.setFrais(frais);
    	affaireDao.update(a);
    	fraisService.delete(idFrais);
    	//fraisDao.delete(idFrais);
	}

													/* ADD methodes*/
    
    public void addAffaire(Affaire a)  
    {  
    	affaireDao.save(a);  
    } 
    
    public void addScelle(long idAffaire,Scelle s){
    	Affaire aff = affaireDao.load(idAffaire);
    	Set<Scelle> scelles = aff.getScelles();
    	scelles.add(s);
    	aff.setScelles(scelles);
    	affaireDao.update(aff);
    }
    
	public void addFrais(long idAffaire, Frais newFrais) {
    	Affaire aff = affaireDao.load(idAffaire);
    	Set<Frais> frais = aff.getFrais();
    	frais.add(newFrais);
    	aff.setFrais(frais);
    	affaireDao.update(aff);		
	}

	public void addObjet(long idAffaire, long idScelle, Objet newObjet) {
		Affaire aff = affaireDao.load(idAffaire);
		Scelle sc = getScelle(idAffaire, idScelle);
		Set<Objet> obj = sc.getObjets();
		if(obj==null){
			obj=new HashSet<Objet>();
		}
		obj.add(newObjet);
		scelleDao.update(sc);
		affaireDao.update(aff);
		
	}
	
	public String addLigneDevis(long idAffaire, LigneDevis newLigne) {
		Affaire aff = affaireDao.load(idAffaire);
		Set<LigneDevis> devis = aff.getLignesDevis();
		Iterator<LigneDevis> itD=devis.iterator();
		while(itD.hasNext()){
			LigneDevis ld=itD.next();
			if(ld.getIdAffaire()==newLigne.getIdAffaire()&&ld.getIdTypeObjet()==newLigne.getIdTypeObjet()&&ld.getIdTypeMission()==newLigne.getIdTypeMission()){
				return "ligneDevis exist";
			}
		}
		devis.add(newLigne);
		affaireDao.update(aff);
		return "success";
	}

	public void deleteScelle(long idAffaire, long idScelle) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		Set<Scelle> scelles=a.getScelles();
    	Iterator<Scelle> iterator = scelles.iterator();
		while (iterator.hasNext()) {
			Scelle s =iterator.next();
		 if(s.getIdScelle()==idScelle){
			 iterator.remove();
		 }
		}
    	a.setScelles(scelles);
    	affaireDao.update(a);
    	scelleDao.delete(idScelle);
	}

	public void updateAffaire(Affaire aff) {
		
		 affaireDao.update(aff);
	}

	public Set<Objet> getObjetTypeObjet(long idAffaire, long idTypeObjet) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator<Scelle> itScelle=scelles.iterator();
		Set<Objet> Robjets=new HashSet<Objet>();
		while(itScelle.hasNext()){
			Set<Objet> objets=((Scelle)itScelle.next()).getObjets();
			Iterator<Objet> itObjet=objets.iterator();
			while(itObjet.hasNext()){
				Objet objet=(Objet) itObjet.next();
				if(objet.getIdTypeObjet()==idTypeObjet){
					Robjets.add(objet);
				}
			}
		}
		return Robjets;
	}

	public Objet getObjetScelle(long idAffaire, long idScelle, long idObjet) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator<Scelle> itS=scelles.iterator();
		Scelle s=null;
		while(itS.hasNext()){
			Scelle t=(Scelle) itS.next();
			if(t.getIdScelle()==idScelle){
				s=t;
				break;
			}
		}
		Set<Objet> objets=s.getObjets();
		Iterator<Objet> itO=objets.iterator();
		while(itO.hasNext()){
			Objet o=(Objet) itO.next();
			if(o.getIdObjet()==idObjet){
				return o;
			}
		}
		return null;
	}

	public String deleteObjetInScelleInAffaire(long idAffaire, long idScelle,
			long idObjet) {
		Affaire a=affaireDao.load(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator<Scelle> itS=scelles.iterator();
		Scelle s=new Scelle();
		while(itS.hasNext()){
			Scelle temps=(Scelle) itS.next();
			if(temps.getIdScelle()==idScelle){
				s=temps;
			}
		}
		Set<Objet> objets=s.getObjets();
		Iterator<Objet> itO=objets.iterator();
		String var="Echec";
		
		while(itO.hasNext()){
			Objet obj=(Objet) itO.next();
			if(obj.getIdObjet()==idObjet){
				objetDao.delete(obj);
				itO.remove();
				var="Success";
				break;
				}
			}
		s.setObjets(objets);
		scelleDao.update(s);
		//Pas sur que ca marche sans setScelles
		affaireDao.update(a);
		//objetService.delete(idObjet);
		
		return var;
	}

	public void deleteTypeMissionForTypeObjeteInAffaire(long idAffaire,
			long idTypeObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		ligneDevisDao.delete(idAffaire, idTypeObjet, idTypeMission);
	}

	public String deleteAffaire(long idAffaire) {
		affaireDao.delete(idAffaire);
		return "Success";
	}

	public int getNbObjetTypeObjet(long idAffaire, long idTypeObjet) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator<Scelle> itS=scelles.iterator();
		int nbObjet=0;
		while(itS.hasNext()){
			Scelle s=(Scelle) itS.next();
			Set<Objet> objets=s.getObjets();
			Iterator<Objet> itO=objets.iterator();
			while(itO.hasNext()){
				Objet o=(Objet) itO.next();
				if(o.getIdTypeObjet()==idTypeObjet){
					nbObjet++;
				}
			}
		}
		return nbObjet;
	}

	public Set<Objet> getObjetForTypeObjetOfTypeMissionInAffaire(long idAffaire,
			long idTypeObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator<Scelle> itS=scelles.iterator();
		Set<Objet> setObjets=new HashSet<Objet>();
		while(itS.hasNext()){
			Scelle s=(Scelle) itS.next();
			Set<Objet> objets=s.getObjets();
			Iterator<Objet> itO=objets.iterator();
			while(itO.hasNext()){
				Objet o=(Objet) itO.next();
				if(o.getIdTypeObjet()==idTypeObjet){
					EtatObjet eo=etatObjetService.getEtatObjet(o.getIdObjet(), idTypeMission);
					if(eo!=null){
						setObjets.add(o);
					}
				}
			}
		}
		return setObjets;
	}

	public Set<EtatObjet> getEtatObjetForTypeObjetOfTypeMissionInAffaire(long idAffaire,
			long idTypeObjet, long idTypeMission) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator<Scelle> itS=scelles.iterator();
		Set<EtatObjet> setEtatObjets=new HashSet<EtatObjet>();
		while(itS.hasNext()){
			Scelle s=(Scelle) itS.next();
			Set<Objet> objets=s.getObjets();
			Iterator<Objet> itO=objets.iterator();
			while(itO.hasNext()){
				Objet o=(Objet) itO.next();
				if(o.getIdTypeObjet()==idTypeObjet){
					EtatObjet eo=etatObjetService.getEtatObjet(o.getIdObjet(), idTypeMission);
					if(eo!=null){
						setEtatObjets.add(eo);
					}
				}
			}
		}
		return setEtatObjets;
	}

	public void putObjet(long idAffaire, String libelleObjet, Long idTypeObjet,
			Long idScelleNew, long idScelleOld, long idObjet) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator<Scelle> itS=scelles.iterator();
		while(itS.hasNext()){
			Scelle s=(Scelle) itS.next();
			if(s.getIdScelle()==idScelleOld){
				Set<Objet> obs=s.getObjets();
				Iterator<Objet> itO=obs.iterator();
				while(itO.hasNext()){
					Objet o=(Objet) itO.next();
					if(o.getIdObjet()==idObjet){
						o.setLibelleObjet(libelleObjet);
						o.setIdTypeObjet(idTypeObjet);
						o.setIdScelle(idScelleNew);
						break;
					}
				}
			}
		}
		affaireDao.update(a);
	}

	public Scelle putScelle(long idAffaire, long idScelle, Long numeroPV,
			String commentaire, Long numeroScelle) {
		// TODO Auto-generated method stub
		
		Affaire a=affaireDao.load(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator<Scelle> itS=scelles.iterator();
		Scelle temps=null;
		while(itS.hasNext()){
			 temps=(Scelle) itS.next();
			if(temps.getIdScelle()==idScelle){
				temps.setNumeroPV(numeroPV);
				temps.setNom(commentaire);
				temps.setNumeroScelle(numeroScelle);
				break;
			}
		}
		affaireDao.update(a);
		return temps;
	}

	public void putFrais(long idAffaire, long idFrais, Long prixFrais) {
		// TODO Auto-generated method stub
		Affaire a=affaireDao.load(idAffaire);
		Set<Frais> frais=a.getFrais();
		Iterator<Frais> it=frais.iterator();
		Frais f = null;
		while(it.hasNext()){
			Frais temps=(Frais) it.next();
			if(temps.getIdFrais()==idFrais){
				f=temps;
				break;
			}
		}
		f.setIdFrais(idFrais);
		f.setPrixFrais(prixFrais);
		affaireDao.update(a);
	}

	public int getObjetScelleAffaire(long idAffaire, long idTypeObjet) {
		Affaire a=affaireDao.load(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator<Scelle> itS=scelles.iterator();
		int nbObjet=0;
		while(itS.hasNext()){
			Scelle s=(Scelle) itS.next();
			Set<Objet> objets=s.getObjets();
			Iterator<Objet> itO=objets.iterator();
			while(itO.hasNext()){
				Objet o=(Objet) itO.next();
				if(o.getIdTypeObjet()==idTypeObjet){
					nbObjet++;
				}
			}
		}
		// TODO Auto-generated method stub
		return nbObjet;
	}

	public TypeMission putTypeMissionForTypeObjetInScelle(long idAffaire,
			long idScelle, long idTypeObjet, long idTypeMission, String libTypeMission) {
		// TODO Auto-generated method stub
		LigneDevis ld=ligneDevisDao.load(idAffaire, idTypeObjet, idTypeMission);
		if(ld!=null){
			TypeMission tm=typeMissionDao.load(idTypeMission);
			tm.setLibTypeMission(libTypeMission);
			typeMissionDao.update(tm);
			return tm;
		}
		return null;
	}

}  