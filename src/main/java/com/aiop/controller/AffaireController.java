package com.aiop.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aiop.model.*;
import com.aiop.service.AffaireService;
import com.aiop.service.FraisService;
import com.aiop.service.ScelleService;
import com.aiop.service.TarifService;
import com.aiop.service.TypeObjetService;

@RestController
public class AffaireController {

	@Autowired
	private AffaireService affaireService;

	@Autowired
	private ScelleService scelleService;

	@Autowired
	private FraisService fraisService;
	
	@Autowired
	private TypeObjetService typeObjetService;
	
	@Autowired
	private TarifService tarifService;

	/*
	 * ---------------------------------------------------- METHODE POST---------------------------------------------------------------
	 */

	/**
	 * Méthode de création d'une affaire
	 * 
	 * @param nomAffaire
	 *            nom de l'affaire créée
	 * @return l'affaire créée
	 * @author Hugo Terminé Testé
	 */
	@RequestMapping(value = "/affaires", method = RequestMethod.POST)
	public @ResponseBody Affaire createAffaire(
			@RequestParam(value = "nomAffaire", required = true) String nomAffaire) {

		Affaire newAffaire = new Affaire();
		newAffaire.setNomAffaire(nomAffaire);
		affaireService.addAffaire(newAffaire);
		return newAffaire;
	}

	/**
	 * Méthode de création d'un frais pour une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire concernée
	 * @param libFrais
	 *            libellé du nouveau Frais
	 * @param prixFrais
	 *            prix du nouveau Frais
	 * @return le Frais créé
	 * @author Hugo
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/frais", method = RequestMethod.POST)
	public @ResponseBody Frais createFraisAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@RequestParam("libFrais") String libFrais,
			@RequestParam("prixFrais") double prixFrais) {
		Frais newFrais = new Frais();
		newFrais.setLibFrais(libFrais);
		newFrais.setPrixFrais(prixFrais);
		newFrais.setIdAffaire(idAffaire);
		affaireService.addFrais(idAffaire, newFrais);
		return newFrais;
	}

	/**
	 * Méthode de création d'un scellé pour une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire concernée
	 * @param numeroScelle
	 *            numéro pénal du scellé
	 * @param numeroPV
	 *            numéro du procés verbal
	 * @param commentaire
	 *            commentaire concernant le scellé
	 * @return le scellé créé
	 * @author Zhi
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles", method = RequestMethod.POST)
	public @ResponseBody Scelle createScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@RequestParam("numeroPV") long numeroPV,
			@RequestParam("commentaire") String commentaire) {
		Scelle newScelle = new Scelle();
		newScelle.setNumeroPV(numeroPV);
		newScelle.setCommentaire(commentaire);
		newScelle.setIdAffaire(idAffaire);
		affaireService.addScelle(idAffaire, newScelle);
		return newScelle;
	}

	/**
	 * Méthode de création d'un objet pour une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire concernée
	 * @param numeroScelle
	 *            numéro du scellé concerné
	 * @author Narjisse
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}/objets", method = RequestMethod.POST)
	public @ResponseBody Objet createObjetScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle,
			@RequestParam("libelleObjet") String libelleObjet,
			@RequestParam("idTypeObjet") long idTypeObjet) {
		Objet newObjet = new Objet();
		newObjet.setIdTypeObjet(idTypeObjet);
		newObjet.setLibelleObjet(libelleObjet);
		newObjet.setNumeroScelle(numeroScelle);
		affaireService.addObjet(idAffaire, numeroScelle, newObjet);
		return newObjet;
	}

	/**
	 * Méthode de liaison d'une type mission à un type d'objet pour un scellé
	 * d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire concernée
	 * @param idScelle
	 *            identifiant du scellé concerné
	 * @param idTypeObjet
	 *            identifiant du type d'objet à lier
	 * @param idTypeMission
	 *            identifiant du type de mission à lier
	 * @author Hugo et Zhi terminé testé
	 * 
	 *         
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/typeObjet/{idTypeObjet}/typeMissions", method = RequestMethod.POST)
	public @ResponseBody String createTypeMissionForTypeObjeteInAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idTypeObjet") long idTypeObjet,
			@RequestParam("idTypeMission") long idTypeMission) {

		LigneDevis newLigne = new LigneDevis();
		newLigne.setIdAffaire(idAffaire);
		newLigne.setIdTypeMission(idTypeMission);
		newLigne.setIdTypeObjet(idTypeObjet);
		// Calculer le nombre d'objet d'un type mission
		// Mettre ce nombre dans "quantiteDevis"
		// Récupérer le prix de cette mission => Zhi
		// Le mettre dans "montantDevis"
		Affaire a=affaireService.loadAffaire(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator itS=scelles.iterator();
		int nbObjet=0;
		while(itS.hasNext()){
			Scelle s=(Scelle) itS.next();
			Set<Objet> objets=s.getObjets();
			Iterator itO=objets.iterator();
			while(itO.hasNext()){
				Objet o=(Objet) itO.next();
				if(o.getIdTypeObjet()==idTypeObjet){
					nbObjet++;
				}
			}
		}
		newLigne.setQuantiteDevis(nbObjet);
		int prix=tarifService.getTarif(idTypeObjet, idTypeMission).getForfait();
		long montant=prix*nbObjet;
		newLigne.setMontantDevis(montant);
		affaireService.addLigneDevis(idAffaire,newLigne);
		return "Success";
	}

	/*
	 * ---------------------------------------------------- METHODE GET---------------------------------------------------------------
	 */

	/**
	 * Méthode de récupération d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @return l'affaire recherchée
	 * @author Hugo
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}", method = RequestMethod.GET)
	public @ResponseBody Affaire getAffaire(
			@PathVariable("idAffaire") long idAffaire) {
		return affaireService.loadAffaire(idAffaire);
	}

	/**
	 * Méthode de récupération de toutes les affaires
	 * 
	 * @return liste des affaire
	 * @author Hugo
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaires", method = RequestMethod.GET)
	public @ResponseBody List<Affaire> getAffaires() {

		return affaireService.getAllAffaires();
	}

	/**
	 * Méthode de récupération des Frais d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @return liste des Frais de l'affaire
	 * @author Hugo
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/frais", method = RequestMethod.GET)
	public @ResponseBody Set<Frais> getFraisAffaire(
			@PathVariable("idAffaire") long idAffaire) {

		return affaireService.getFrais(idAffaire);
	}

	/**
	 * Méthode de récupération de l'état d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @return l'état d'une affaire
	 * testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/etat", method = RequestMethod.GET)
	public @ResponseBody String getEtatAffaire(@PathVariable("idAffaire") long idAffaire) {

		return affaireService.getEtat(idAffaire);
	}

	// nana
	/**
	 * Méthode de récupération des types objets d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @return liste des types objets de l'affaire
	 * @author narjisse Zaki Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/typeObjets", method = RequestMethod.GET)
	public @ResponseBody Set<TypeObjet> getAllTypesObjetsAffaire(
			@PathVariable("idAffaire") long idAffaire) {
		Set<Scelle> scelles = new HashSet<Scelle>();
		scelles = affaireService.getScelles(idAffaire);
		return scelleService.getAllTypesObjetsAffaire(scelles);

	}

	// nana
	/**
	 * Méthode de récupération des objets d' un type objet d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param idTypeObjet
	 *            identifiant d'un type objet d'une affaire
	 * @return liste des objets d'un type objet d'une affaire
	 * @author Zhi testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/typeObjet/{idTypeObjet}/objets", method = RequestMethod.GET)
	public @ResponseBody Set<Objet> getAllObjetsTypeObjetAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idTypeObjet") long idTypeObjet) {
		return affaireService.getObjetTypeObjet(idAffaire, idTypeObjet);
	}

	/**
	 * Méthode de récupération d'un scellé d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param numeroScelle
	 *            numéro du scellé a récupérer
	 * @return le scellé souhaité
	 * @author Zhi
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.GET)
	public @ResponseBody Scelle getScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle) {

		return affaireService.getScelle(idAffaire, numeroScelle);
	}

	/**
	 * Méthode de récupération des scellés d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @return liste des scellés de l'affaire
	 * @author Zhi
	 * 
	 *         Terminé testé
	 */

	@RequestMapping(value = "/affaire/{idAffaire}/scelles", method = RequestMethod.GET)
	public @ResponseBody Set<Scelle> getScelleAffaire(
			@PathVariable("idAffaire") long idAffaire) {
		Set<Scelle> scelles = new HashSet<Scelle>();
		scelles = affaireService.getScelles(idAffaire);
		return scelles;
	}

	/**
	 * Méthode de récupération des objets d'un scelle d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param numeroScelle
	 *            numéro du scelle
	 * @return liste des objets d'un scelle d'une affaire
	 * @author narjisse Zaki
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}/objets", method = RequestMethod.GET)
	public @ResponseBody Set<Objet> getAllObjetsScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle) {

		return affaireService.getObjetScelle(idAffaire, numeroScelle);
	}

	// nana
	/**
	 * Méthode de récupération d'un objet d'un scelle d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param numeroScelle
	 *            numéro du scelle qui contient l'objet
	 * @param idObjet
	 *            l'identifiant de l'objet à recuperer
	 * @return l'objet souhaité
	 * @author zhi testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}/objet/{idObjet}", method = RequestMethod.GET)
	public @ResponseBody Objet getObjetScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle,
			@PathVariable("idObjet") long idObjet) {
		
		return affaireService.getObjetScelle(idAffaire,numeroScelle,idObjet);
	}

	/**  ???
	 * Méthode pour connaitre le nombre d'objet d'un type objet concernés par
	 * une mission pour une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param idTypeObjet
	 *            identifiant du type objet recherché
	 * @param idTypeMission
	 *            identifiant du type de Mission concerné
	 * @author zhi testé   peut etre
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/typeObjet/{idTypeObjet}/typeMissions/{idTypeMission}/nbObjet", method = RequestMethod.GET)
	public @ResponseBody int getNbObjetForTypeObjetOfTypeMissionInAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission) {
		Tarif t=tarifService.getTarif(idTypeObjet, idTypeMission);
		if(t==null){
			return 0;
		}
		Affaire a=affaireService.loadAffaire(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator itS=scelles.iterator();
		int nbObjet=0;
		while(itS.hasNext()){
			Scelle s=(Scelle) itS.next();
			Set<Objet> objets=s.getObjets();
			Iterator itO=objets.iterator();
			while(itO.hasNext()){
				Objet o=(Objet) itO.next();
				if(o.getIdTypeObjet()==idTypeObjet){
					nbObjet++;
				}
			}
		}
		return nbObjet;
	}

	/*
	 * ----------------------------------------------------METHODE PUT---------------------------------------------------------------
	 */

	/**
	 * Méthode de modification d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire à modifier
	 * @param nom
	 *            nom de l'affaire à modifier
	 * @param dossier
	 *            numéro de dossier de l'affaire à modifier
	 * @param parquet
	 *            numéro de parquet de l'affaire à modifier
	 * @param dateOrdre
	 * @param dateMax
	 * @param dateProrogation
	 * @param pageNb
	 * @param pageCoul
	 * @param hExp
	 * @param hDepl
	 * @param dateDevis
	 * @param pourcentDevis
	 * @param facture
	 * @param montantFacture
	 * @param pourcentRemise
	 * @param delais10j
	 * @param dateRemise
	 * @param instruction
	 * 
	 * zhi 
	 */
	@RequestMapping(value = "/affaire/{idAffaire}", method = RequestMethod.PUT)
	public @ResponseBody Affaire PutAffaire(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("nomAffaire") String nom,
			@RequestParam("numDossier") long dossier,
			@RequestParam("numParquet") long parquet,
			@RequestParam("dateOrdre") String dateOrdre,
			@RequestParam("dateMax") String dateMax,
			@RequestParam("dateProrogation") String dateProrogation,
			@RequestParam("nbPageNb") long pageNb,
			@RequestParam("nbPageCouleur") long pageCoul,
			@RequestParam("nbHExpertise") long hExp,
			@RequestParam("nbHDepalacement") long hDepl,
			@RequestParam("dateDevis") String dateDevis,
			@RequestParam("pourcentageDevis") double pourcentDevis,
			@RequestParam("numFacture") long facture,
			@RequestParam("montantFacture") double montantFacture,
			@RequestParam("pourcentageRemise") double pourcentRemise,
			@RequestParam("delais10j") boolean delais10j,
			@RequestParam("dateRemise") String dateRemise,
			@RequestParam("numInstruction") long instruction) {

		Affaire aff = affaireService.loadAffaire(idAffaire);
		aff.setIdAffaire(idAffaire);
		aff.setNomAffaire(nom);
		aff.setNumDossier(dossier);
		aff.setNumParquet(parquet);
		aff.setDateOrdre(dateOrdre);
		aff.setDateMax(dateMax);
		aff.setDateProrogation(dateProrogation);
		aff.setNbPageNb(pageNb);
		aff.setNbPageCouleur(pageCoul);
		aff.setNbHExpertise(hExp);
		aff.setNbHDeplacement(hDepl);
		aff.setDateDevis(dateDevis);
		aff.setPourcentageDevis(pourcentDevis);
		aff.setNumFacture(facture);
		aff.setMontantFacture(montantFacture);
		aff.setPourcentageRemise(pourcentRemise);
		aff.setDelais10j(delais10j);
		aff.setDateRemise(dateRemise);
		aff.setNumInstruction(instruction);
		affaireService.updateAffaire(aff);
		return aff;
	}

	/**
	 * Méthode de modification de l'état d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param etat
	 *            nouvel état de l'affaire
	 *     zhi     testé
	 */

	@RequestMapping(value = "/affaire/{idAffaire}/etat", method = RequestMethod.PUT)
	public @ResponseBody String putEtat(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("etat") String etat) {
		Affaire a=affaireService.loadAffaire(idAffaire);
		a.setEtat(etat);
		affaireService.updateAffaire(a);
		return "Success";
	}

	/**
	 * Méthode de modification d'un frais d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param idFrais
	 *            identifiant du frais à modifier
	 * @param libFrais
	 *            nouveau libellé
	 * @param prixFrais
	 *            nouveau prix
	 *      zhi      testé
	 */

	@RequestMapping(value = "/affaire/{idAffaire}/frais/{idFrais}", method = RequestMethod.PUT)
	public @ResponseBody String putFrais(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idFrais") long idFrais,
			@RequestParam("libFrais") String libFrais,
			@RequestParam("prixFrais") double prixFrais) {
		Affaire a=affaireService.loadAffaire(idAffaire);
		Set<Frais> frais=a.getFrais();
		Iterator it=frais.iterator();
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
		affaireService.updateAffaire(a);
		return "Success";
	}

	/**
	 * Méthode de modification d'un scellé d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param numeroScelle
	 *            numéro du scellé à modifier
	 * @param numeroPV
	 *            nouveau numéro du PV
	 * @param commentaire
	 *            nouveau commentaire
	 *      zhi      testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.PUT)
	public @ResponseBody Scelle putScelle(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle,
			@RequestParam("numeroPV") long numeroPV,
			@RequestParam("commentaire") String commentaire) {
		Affaire a=affaireService.loadAffaire(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator itS=scelles.iterator();
		Scelle temps=null;
		while(itS.hasNext()){
			 temps=(Scelle) itS.next();
			if(temps.getNumeroScelle()==numeroScelle){
				temps.setNumeroPV(numeroPV);
				temps.setCommentaire(commentaire);
				break;
			}
		}
		affaireService.updateAffaire(a);
		return temps;
	}

	// nana
	/**
	 * Méthode de modification d'un objet dans un scelle dans une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param numeroScelle
	 *            numéro du scellé qui contient l'objet
	 * @param idObjet
	 *            identifiant de l'objet à modifier
	 * @param libelleObjet
	 *            nouveau libelle de l'objet
	 * @param idTypeObjet
	 *            nouveau type de l'objet
	 * @param numeroScelle
	 *            nouveau numéro du scellé qui contient l'objet
	 * @author zhi testé
	 */

	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}/objets/{idObjet}", method = RequestMethod.PUT)
	public @ResponseBody String putObjet(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelleOld,
			@PathVariable("idObjet") long idObjet,
			@RequestParam("libelleObjet") String libelleObjet,
			@RequestParam("idTypeObjet") long idTypeObjet,
			@RequestParam("numeroScelle") long numeroScelleNew) {
		Affaire a=affaireService.loadAffaire(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator itS=scelles.iterator();
		while(itS.hasNext()){
			Scelle s=(Scelle) itS.next();
			if(s.getNumeroScelle()==numeroScelleOld){
				Set<Objet> obs=s.getObjets();
				Iterator itO=obs.iterator();
				while(itO.hasNext()){
					Objet o=(Objet) itO.next();
					if(o.getIdObjet()==idObjet){
						o.setLibelleObjet(libelleObjet);
						o.setIdTypeObjet(idTypeObjet);
						o.setNumeroScelle(numeroScelleNew);
						break;
					}
				}
			}
		}
		affaireService.updateAffaire(a);
		return "Success";
	}

	/**  ???
	 * Méthode de modification d'une type mission pour un type d'objet d'un
	 * scellé d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire concernée
	 * @param numeroScelle
	 *            identifiant du scellé concerné
	 * @param idTypeObjet
	 *            identifiant du type d'objet concerné
	 * @param idTypeMission
	 *            identifiant du type de mission à modifier
	 * @param libTypeMission
	 *            nouveau libellé
	 * @param prixMission
	 *            nouveau prix
	 *            pb
	 */

	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}/typeObjet/{idTypeObjet}/typeMissions/{idTypeMission}", method = RequestMethod.PUT)
	public void putTypeMissionForTypeObjetInScelle(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle,
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission,
			@RequestParam("libTypeMission") long libTypeMission,
			@RequestParam("prixMission") String prixMission) {

		// Je ne sais pas comment ça va marcher avec l'ORM Scelle x = new
		// Scelle(numeroScelle);
		// x.load();
		// x.updateTypeMissionForTypeObjetInScelle(idTypeObjet,
		// idTypeMission,libTypeMission, prixMission);
	}

	/*
	 * -------------------------------------------------- METHODE DELETE ------------------------------------------------------------
	 */

	/**
	 * Méthode de suppression d'un frais d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param idFrais
	 *            identifiant du frais à supprimer
	 * @author narjissezaki Terminé testé
	 */
	@RequestMapping(value = "/affaires/{idAffaire}/frais/{idFrais}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteFrais(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idFrais") long idFrais) {

		affaireService.deleteFrais(idAffaire, idFrais);
		return "Success";
	}

	/**
	 * Méthode de suppression d'un scellé d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param numeroScelle
	 *            identifiant du scellé à supprimer
	 *            zhi testé
	 */

	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.DELETE, produces = "text/plain")
	public @ResponseBody String deleteScelle(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle) {
		affaireService.deleteScelle(idAffaire, numeroScelle);
		return "success";
	}

	// nana
	/**
	 * Méthode de suppression d'un objet d'un scelle d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param numeroScelle
	 *            identifiant du scellé contenant l'objet
	 * @param idObjet
	 *            identifiant de l'objet à supprimer
	 * @author narjisse Zaki pas reussi pb
	 */

	@RequestMapping(value = "/affaires/{idAffaire}/scelles/{numeroScelle}/objet/{idObjet}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteObjetInScelle(@PathVariable("idAffaire") long idAffaire,
	@PathVariable("numeroScelle") long numeroScelle,
	@PathVariable("idObjet") long idObjet) {
		Affaire a=affaireService.loadAffaire(idAffaire);
		Set<Scelle> scelles=a.getScelles();
		Iterator<Scelle> itS=scelles.iterator();
		while(itS.hasNext()){
			Scelle s=(Scelle) itS.next();
			if(s.getNumeroScelle()==numeroScelle){
				Set<Objet> objets=s.getObjets();
				Iterator itO=objets.iterator();
				while(itO.hasNext()){
					Objet o=(Objet) itO.next();
					if(o.getIdObjet()==idObjet){
						itO.remove();
						scelleService.updateScelle(s);
						break;
					}
				}
			}
		}
		affaireService.updateAffaire(a);
		return "Success";
	}

}
