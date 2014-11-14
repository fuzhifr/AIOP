package com.aiop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aiop.model.Scelle;
import com.aiop.service.AffaireService;

@RestController
public class AffaireController {

// ---------------------------------------------------- METHODE POST ---------------------------------------------------------------

	/**
	 * Méthode de création d'une affaire
	 * @param nomAffaire nom de l'affaire créée
	 * @return l'affaire créée
	 *//*
	@RequestMapping(value = "/affaires", method = RequestMethod.POST)
	public Affaire createAffaire(
			@RequestParam(value = "nomAffaire", required = true) String nomAffaire) {
		Affaire x = new Affaire(nomAffaire);
		x.create();
		return x;
	}

	*//**
	 * Méthode de création d'un frais pour une affaire
	 * @param idAffaire identifiant de l'affaire concernée
	 * @param libFrais libellé du nouveau Frais
	 * @param prixFrais prix du nouveau Frais
	 * @return le Frais créé
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/frais", method = RequestMethod.POST)
	public Frais createFraisAffaire(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("libFrais") String libFrais,
			@RequestParam("prixFrais") double prixFrais) {
		Frais x = new Frais(libFrais, prixFrais);
		x.save(idAffaire);
		return x;
	}
*/
	/**
	 * Méthode de création d'un scellé pour une affaire
	 * @param idAffaire identifiant de l'affaire concernée
	 * @param numeroScelle numéro pénal du scellé
	 * @param numeroPV numéro du procés verbal
	 * @param commentaire commentaire concernant le scellé
	 * @return le scellé créé
	 */
	@Autowired
	private AffaireService affaireService;
	@RequestMapping(value = "/affaire/{idAffaire}/scelles", method = RequestMethod.POST)
	public @ResponseBody Scelle createScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@RequestParam("numeroPV") long numeroPV,
			@RequestParam("commentaire") String commentaire) {
		Scelle newScelle = new Scelle(numeroPV, commentaire);
		newScelle.setIdAffaire(idAffaire);
		affaireService.addScelle(idAffaire, newScelle);
		return newScelle;
	}

	/* //nana
	/**
	 * Méthode de création d'un objet pour une affaire
	 * @param idAffaire identifiant de l'affaire concernée
	 * @param numeroScelle numéro du scellé concerné
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}/objets", method = RequestMethod.POST)
	public Objet createObjetScelleAffaire(@PathVariable("idAffaire") long idAffaire, @PathVariable("numeroScelle") long numeroScelle,
			@RequestParam("idObjet") long idObjet,
			@RequestParam("libelleObjet") String libelleObjet,
			@RequestParam("idTypeObjet") long idTypeObjet) {
		Objet newObjet = new Objet(idObjet, libelleObjet, idTypeObjet);
		newObjet.save(numeroScelle);
		return newObjet;
	}

	*//**
	 * Méthode de liaison d'une type mission à un type d'objet pour un scellé d'une affaire
	 * @param idAffaire identifiant de l'affaire concernée
	 * @param idScelle identifiant du scellé concerné
	 * @param idTypeObjet identifiant du type d'objet à lier
	 * @param idTypeMission identifiant du type de mission à lier
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/scelle/{numeroScelle}/typeObjet/{idTypeObjet}/typeMissions", method = RequestMethod.POST)
	public void createTypeMissionForTypeObjetInScelleInAffaire(@PathVariable("idAffaire") long idAffaire, @PathVariable("numeroScelle") long numeroScelle,
			@PathVariable("idTypeObjet") long idTypeObjet,
			@RequestParam("idTypeMission") String idTypeMission) {
		Affaire x = new Affaire(idAffaire);
		x.load(idAffaire);
		x.createMissionForTypeObjetInScelle(numeroScelle,idTypeObjet,idTypeMission);
	}
	
 ---------------------------------------------------- METHODE GET ---------------------------------------------------------------

	*//**
	 * Méthode de récupération d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @return l'affaire recherchée
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}", method = RequestMethod.GET)
	public Affaire getAffaire(@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire();
		// x.load(idAffaire);

		return x;
	}

	*//**
	 * Méthode de récupération de toutes les affaires
	 * @return liste des affaire
	 *//*
	@RequestMapping(value = "/affaires", method = RequestMethod.GET)
	public List<Affaire> getAffaires() {

		// Il faudra load toutes les affaires depuis la bdd
		// Affaire x = new Affaire();
		// return x.getAllAffaires();

		// en attendant :
		List<Affaire> x = new ArrayList<Affaire>();
		x.add(new Affaire(1));
		x.add(new Affaire(2));
		x.add(new Affaire(3));
		return x;
	}

	*//**
	 * Méthode de récupération des Frais d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @return liste des Frais de l'affaire
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/frais", method = RequestMethod.GET)
	public List<Frais> getFraisAffaire(@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getFrais();
	}

	*//**
	 * Méthode de récupération de l'état d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @return l'état d'une affaire
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/etat", method = RequestMethod.GET)
	public String getEtatAffaire(@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getEtat();
	}
	
//nana
	*//**
	 * Méthode de récupération des types objets d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @return liste des types objets de l'affaire
	 * @author narjisse Zaki
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/typesObjets", method = RequestMethod.GET)
	public List<TypeObjet> getAllTypesObjetsAffaire(
			@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire a = new Affaire();
		a.load(idAffaire);
		return a.getTypesObjets();
	}
//nana
	*//**
	 * Méthode de récupération des objets d' un type objet d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param idTypeObjet identifiant d'un type objet d'une affaire
	 * @return liste des objets d'un type objet d'une affaire
	 * @author narjisse Zaki
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/typeObjet/{idTypeObjet}/objets", method = RequestMethod.GET)
	public List<Objet> getAllObjetsTypeObjetAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idTypeObjet") long idTypeObjet) {
		Affaire a = new Affaire();
		a.load(idAffaire);
		return a.getObjetsFindByIdTypeObjet(idTypeObjet);
	}
	
	*//**
	 * Méthode de récupération d'un scellé d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param numeroScelle numéro du scellé a récupérer
	 * @return le scellé souhaité
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.GET)
	public Scelle getScelleAffaire(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getScelle(numeroScelle);
	}

	*//**
	 * Méthode de récupération des scellés d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @return liste des scellés de l'affaire
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/scelles", method = RequestMethod.GET)
	public List<Scelle> getScelleAffaire(
			@PathVariable("idAffaire") long idAffaire) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		return x.getScelles();
	}
	
	//nana
	*//**
	 * Méthode de récupération des objets d'un scelle d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param numeroScelle numéro du scelle
	 * @return liste des objets d'un scelle d'une affaire
	 * @author narjisse Zaki
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}/objets", method = RequestMethod.GET)
	public List<Objet> getAllObjetsScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle) {
		Scelle sc = new Scelle();
		sc.load(numeroScelle);
		return sc.getObjets();
	}
	//nana
	*//**
	 * Méthode de récupération d'un objet d'un scelle d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param numeroScelle numéro du scelle qui contient l'objet 
	 * @param idObjet l'identifiant de l'objet à recuperer
	 * @return l'objet souhaité
	 * @author narjisse Zaki
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}/objet/{idObjet}", method = RequestMethod.GET)
	public Objet getObjetScelleAffaire(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle,
			@PathVariable("idObjet") long idObjet) {
		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Scelle sc = new Scelle();
		sc.load(numeroScelle);	
		return sc.getObjetfindById(idObjet);
	}

	@RequestMapping(value = "/affaire/{idAffaire}/typeObjet/{idTypeObjet}/typeMissions/{idTypeMission}/nbObjet", method = RequestMethod.GET)
	public void getNbObjetForTypeObjetOfTypeMissionInAffaire(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle,
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission,
			@RequestParam("libTypeMission") long libTypeMission,
			@RequestParam("prixMission") String prixMission) {
		
		// Je ne sais pas comment ça va marcher avec l'ORM
		Affaire x = new Affaire(idAffaire);
		x.load(idAffaire);
		x.nbObjet(idTypeObjet,idTypeMission);
	}
	
	 ---------------------------------------------------- METHODE PUT ---------------------------------------------------------------
	
	*//**
	 * Méthode de modification d'une affaire
	 * @param idAffaire identifiant de l'affaire à modifier
	 * @param nom nom de l'affaire à modifier
	 * @param dossier numéro de dossier de l'affaire à modifier
	 * @param parquet numéro de parquet de l'affaire à modifier
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
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}", method = RequestMethod.PUT)
	public void PutAffaire(@PathVariable("idAffaire") long idAffaire,
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

		Affaire x = new Affaire(idAffaire);
		x.setNomAffaire(nom);
		x.setNumDossier(dossier);
		x.setNumParquet(parquet);
		x.setDateOrdre(dateOrdre);
		x.setDateMax(dateMax);
		x.setDateProrogation(dateProrogation);
		x.setNbPageNb(pageNb);
		x.setNbPageCouleur(pageCoul);
		x.setNbHExpertise(hExp);
		x.setNbHDeplacement(hDepl);
		x.setDateDevis(dateDevis);
		x.setPourcentageDevis(pourcentDevis);
		x.setNumFacture(facture);
		x.setMontantFacture(montantFacture);
		x.setPourcentageRemise(pourcentRemise);
		x.setDelais10j(delais10j);
		x.setDateRemise(dateRemise);
		x.setNumInstruction(instruction);
		x.save();
	}

	*//**
	 * Méthode de modification de l'état d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param etat nouvel état de l'affaire
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/etat", method = RequestMethod.PUT)
	public void putEtat(@PathVariable("idAffaire") long idAffaire,
			@RequestParam("etat") String etat) {

		// il faudra le charger depuis la bdd et appeller le constructeur vide
		Affaire x = new Affaire(idAffaire);
		// x.load(idAffaire);

		x.setEtat(etat);
		x.save();
	}

	*//**
	 * Méthode de modification d'un frais d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param idFrais identifiant du frais à modifier
	 * @param libFrais nouveau libellé
	 * @param prixFrais nouveau prix
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/frais/{idFrais}", method = RequestMethod.PUT)
	public void putFrais(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idFrais") long idFrais,
			@RequestParam("libFrais") String libFrais,
			@RequestParam("prixFrais") double prixFrais) {

		Frais x = new Frais(idFrais);
		x.setLibFrais(libFrais);
		x.setPrixFrais(prixFrais);
		x.save(idAffaire);
	}

	*//**
	 * Méthode de modification d'un scellé d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param numeroScelle numéro du scellé à modifier
	 * @param numeroPV nouveau numéro du PV
	 * @param commentaire nouveau commentaire
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.PUT)
	public void putScelle(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle,
			@RequestParam("numeroPV") long numeroPV,
			@RequestParam("commentaire") String commentaire) {

		Scelle x = new Scelle(numeroScelle);
		x.load();
		x.setNumeroPV(numeroPV);
		x.setCommentaire(commentaire);
		x.save(numeroScelle);
	}
	
	//nana
	*//**
	 * Méthode de modification d'un objet dans un scelle dans une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param numeroScelle numéro du scellé qui contient l'objet
	 * @param idObjet identifiant de l'objet à modifier
	 * @param libelleObjet nouveau libelle de l'objet
	 * @param idTypeObjet nouveau type de l'objet
	 * @param numeroScelle nouveau numéro du scellé qui contient l'objet
	 * @author narjisse Zaki
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}/objets/{idObjet}", method = RequestMethod.PUT)
	public void putObjet(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelleOld,
			@PathVariable("idObjet") long idObjet,
			@RequestParam("libelleObjet") String libelleObjet,
			@RequestParam("idTypeObjet") long idTypeObjet, 
			@RequestParam("numeroScelle") long numeroScelleNew){

		Objet obj = new Objet();
		obj.load();
		obj.setLibelleObjet(libelleObjet);
		obj.setIdTypeObjet(idTypeObjet);
		obj.save(numeroScelleNew);
	}
	

	*//**
	 * Méthode de modification d'une type mission pour un type d'objet d'un scellé d'une affaire
	 * @param idAffaire identifiant de l'affaire concernée
	 * @param numeroScelle identifiant du scellé concerné
	 * @param idTypeObjet identifiant du type d'objet concerné
	 * @param idTypeMission identifiant du type de mission à modifier
	 * @param libTypeMission nouveau libellé
	 * @param prixMission nouveau prix
	 *//*
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{numeroScelle}/typeObjet/{idTypeObjet}/typeMissions/{idTypeMission}", method = RequestMethod.PUT)
	public void putTypeMissionForTypeObjetInScelle(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle,
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission,
			@RequestParam("libTypeMission") long libTypeMission,
			@RequestParam("prixMission") String prixMission) {
		
		// Je ne sais pas comment ça va marcher avec l'ORM
		Scelle x = new Scelle(numeroScelle);
		x.load();
		x.updateTypeMissionForTypeObjetInScelle(idTypeObjet,idTypeMission,libTypeMission,prixMission);
	}
	 -------------------------------------------------- METHODE DELETE -------------------------------------------------------------
	
	*//**
	 * Méthode de suppression d'un frais d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param idFrais identifiant du frais à supprimer
	 *//*
	@RequestMapping(value = "/affaires/{idAffaire}/frais/{idFrais}", method = RequestMethod.DELETE)
	public void getAffaire2(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idFrais") long idFrais) {
		Frais x = new Frais(idAffaire, idFrais);
		x.delete();
	}

	*//**
	 * Méthode de suppression d'un scellé d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param numeroScelle identifiant du scellé à supprimer
	 *//*
	@RequestMapping(value = "/affaires/{idAffaire}/scelles/{numeroScelle}", method = RequestMethod.DELETE)
	public void deleteScelle(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle) {
		Affaire a = new Affaire();
		a.load(idAffaire);
		a.deleteScelle(numeroScelle);
	}
	
	//nana
	*//**
	 * Méthode de suppression d'un objet d'un scelle d'une affaire
	 * @param idAffaire identifiant de l'affaire
	 * @param numeroScelle identifiant du scellé contenant l'objet
	 * @param idObjet identifiant de l'objet à supprimer
	 * @author narjisse Zaki
	 *//*
	@RequestMapping(value = "/affaires/{idAffaire}/scelles/{numeroScelle}/objet/{idObjet}", method = RequestMethod.DELETE)
	public void deleteObjetInScelle(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("numeroScelle") long numeroScelle,
			@PathVariable("idObjet") long idObjet) {
		Scelle sc = new Scelle();
		sc.load(numeroScelle);
		sc.deleteObjectById(idObjet);
	}
*/
}
