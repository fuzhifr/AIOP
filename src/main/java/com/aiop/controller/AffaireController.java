package com.aiop.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aiop.model.Affaire;
import com.aiop.model.EtatObjet;
import com.aiop.model.Frais;
import com.aiop.model.LigneDevis;
import com.aiop.model.Objet;
import com.aiop.model.Scelle;
import com.aiop.model.Tarif;
import com.aiop.model.TypeMission;
import com.aiop.model.TypeObjet;
import com.aiop.service.AffaireService;
import com.aiop.service.EtatObjetService;
import com.aiop.service.FraisService;
import com.aiop.service.LigneDevisService;
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
	
	@Autowired
	private EtatObjetService etatObjetService;
	
	@Autowired
	private LigneDevisService ligneDevisService;


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
	public @ResponseBody Affaire createAffaire( HttpServletRequest request) {
		String nomAffaire = request.getParameter("nomAffaire");
		Affaire newAffaire = new Affaire();
		newAffaire.setNomAffaire(nomAffaire);
		newAffaire.setEtat("create");
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
	public @ResponseBody Frais createFraisAffaire(HttpServletRequest request,
			@PathVariable("idAffaire") long idAffaire) {
		Frais newFrais = new Frais();
		String libFrais = request.getParameter("libFrais");
		Long prixFrais = Long.parseLong(request.getParameter("prixFrais"));
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
	 * @param idScelle
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
			@PathVariable("idAffaire") long idAffaire,HttpServletRequest request) {
		
		Scelle newScelle = new Scelle();
		String nom = request.getParameter("nom");
		Long numeroPV = Long.parseLong(request.getParameter("numeroPV"));
		Long numeroScelle = Long.parseLong(request.getParameter("numeroScelle"));
		
		newScelle.setNumeroPV(numeroPV);
		newScelle.setNumeroScelle(numeroScelle);
		newScelle.setNom(nom);
		newScelle.setIdAffaire(idAffaire);
		affaireService.addScelle(idAffaire, newScelle);
		return newScelle;
	}

	/**
	 * Méthode de création d'un objet pour une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire concernée
	 * @param idScelle
	 *            numéro du scellé concerné
	 * @author Narjisse Zaki
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{idScelle}/objets", method = RequestMethod.POST)
	public @ResponseBody Objet createObjetScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idScelle") long idScelle, HttpServletRequest request) {
		Objet newObjet = new Objet();
		String libelleObjet = request.getParameter("libelleObjet");
		Long idTypeObjet = Long.parseLong(request.getParameter("idTypeObjet"));
		newObjet.setIdTypeObjet(idTypeObjet);
		newObjet.setLibelleObjet(libelleObjet);
		newObjet.setIdScelle(idScelle);
		affaireService.addObjet(idAffaire, idScelle, newObjet);
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
	public @ResponseBody LigneDevis createTypeMissionForTypeObjeteInAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idTypeObjet") long idTypeObjet, HttpServletRequest request) {

		LigneDevis newLigne = new LigneDevis();
		
		String sIdTypeMission = request.getParameter("idTypeMission");
		if ( sIdTypeMission == null) 
		{	return null;	}
		
		Long idTypeMission = Long.parseLong(sIdTypeMission);
		
		String sprixD = request.getParameter("prix");
		Integer prix = null;
		if (sprixD == null)
		{	 prix=tarifService.getTarif(idTypeObjet, idTypeMission).getForfait(); }
		else {
			prix = Integer.parseInt(sprixD);
		}
		
		newLigne.setIdAffaire(idAffaire);
		newLigne.setIdTypeMission(idTypeMission);
		newLigne.setIdTypeObjet(idTypeObjet);
		int nbObjet=affaireService.getNbObjetTypeObjet(idAffaire,idTypeObjet);
		newLigne.setQuantiteDevis(nbObjet);
		
		long montant=prix*nbObjet;
		newLigne.setMontantDevis(montant);
		affaireService.addLigneDevis(idAffaire,newLigne);
		
		return newLigne;
		
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
	 * @author Narjisse Zaki testé
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
	 * @author Narjisse Zaki
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
	 * @author Narjisse Zaki testé
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
	 * @param idScelle
	 *            numéro du scellé a récupérer
	 * @return le scellé souhaité
	 * @author Zhi
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{idScelle}", method = RequestMethod.GET)
	public @ResponseBody Scelle getScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idScelle") long idScelle) {

		return affaireService.getScelle(idAffaire, idScelle);
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
	 * @param idScelle
	 *            numéro du scelle
	 * @return liste des objets d'un scelle d'une affaire
	 * @author narjisse Zaki
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{idScelle}/objets", method = RequestMethod.GET)
	public @ResponseBody Set<Objet> getAllObjetsScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idScelle") long idScelle) {

		return affaireService.getObjetScelle(idAffaire, idScelle);
	}

	// nana
	/**
	 * Méthode de récupération d'un objet d'un scelle d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param idScelle
	 *            numéro du scelle qui contient l'objet
	 * @param idObjet
	 *            l'identifiant de l'objet à recuperer
	 * @return l'objet souhaité
	 * @author zhi testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{idScelle}/objet/{idObjet}", method = RequestMethod.GET)
	public @ResponseBody Objet getObjetScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idScelle") long idScelle,
			@PathVariable("idObjet") long idObjet) {
		
		return affaireService.getObjetScelle(idAffaire,idScelle,idObjet);
	}
	
	//nouvelle fonction
	/**
	 * Méthode de récupération des types mission non affectés à un type objet d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param idTypeObjet
	 *            identifiant d'un type objet d'une affaire
	 * @return liste des types missions non affectés aun type d'objet donné d'une affaire donnée
	 * @author Narjisse Zaki terminé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/typeObjet/{idTypeObjet}/typeMissionsNotAffected", method = RequestMethod.GET)
	public @ResponseBody Set<TypeMission> getAllTypeMissionsForTypeObjetAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idTypeObjet") long idTypeObjet) {
		return ligneDevisService.getAllTypeMissionsForTypeObjetAffaire(idAffaire, idTypeObjet);
	}

	//-------------nouvelle fonction
	
	/**
	 * Méthode de récupération des types mission d' un type objet d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param idTypeObjet
	 *            identifiant d'un type objet d'une affaire
	 * @return liste des types mission d'un type objet d'une affaire
	 * @author Narjisse Zaki 
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/typeObjet/{idTypeObjet}/typeMissions", method = RequestMethod.GET)
	public @ResponseBody Set<TypeMission> getAllTypeMissionTypeObjetAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idTypeObjet") long idTypeObjet) {
		return ligneDevisService.getAllTypeMissionsAffectedToTypeObjet(idAffaire, idTypeObjet);
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
		return affaireService.getObjetScelleAffaire(idAffaire,idTypeObjet);
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
	 * hugo
	 */
	@RequestMapping(value = "/affaire/{idAffaire}", method = RequestMethod.PUT)
	public @ResponseBody Affaire PutAffaire(@PathVariable("idAffaire") long idAffaire,
			HttpServletRequest request) {
			
		Affaire aff = affaireService.loadAffaire(idAffaire);
		
		String nom = request.getParameter("nom");
		if (nom != null)
		{	aff.setNomAffaire(nom);	}
		
		String dateOrdre = request.getParameter("DateOrdre");
		if (dateOrdre != null)
		{	aff.setDateOrdre(dateOrdre);	}
		
		String dateMax = request.getParameter("dateMax");
		if (dateMax != null)
		{	aff.setDateMax(dateMax);	}
		
		String dateProrogation = request.getParameter("dateProrogation");
		if (dateProrogation != null)
		{	aff.setDateProrogation(dateProrogation);	}
		
		String dateDevis = request.getParameter("dateDevis");
		if (dateDevis != null)
		{	aff.setDateDevis(dateDevis);	}
		
		String dateRemise = request.getParameter("dateRemise");
		if (dateRemise != null)
		{	aff.setDateRemise(dateRemise);	}
		
		
		String test = request.getParameter("dossier");
		if (test != null)
		{	Long dossier = Long.parseLong(test);
			aff.setNumDossier(dossier);	}
		
		test = request.getParameter("parquet");
		if (test != null)
		{	Long parquet = Long.parseLong(test);
			aff.setNumParquet(parquet);	}
		
		test = request.getParameter("pageNb");
		if (test != null)
		{	Long pageNb = Long.parseLong(test);
			aff.setNbPageNb(pageNb);	}
		
		test = request.getParameter("pageCoul");
		if (test != null)
		{	Long pageCoul = Long.parseLong(test);
			aff.setNbPageCouleur(pageCoul);	}
		
		test = request.getParameter("nbHExpertise");
		if (test != null)
		{	Long nbHExpertise = Long.parseLong(test);
			aff.setNbHExpertise(nbHExpertise);	}
		
		test = request.getParameter("nbHDeplacement");
		if (test != null)
		{	Long nbHDeplacement = Long.parseLong(test);
			aff.setNbHDeplacement(nbHDeplacement);	}
		
		test = request.getParameter("facture");
		if (test != null)
		{	Long facture = Long.parseLong(test);
			aff.setNumFacture(facture);	}
		
		test = request.getParameter("instruction");
		if (test != null)
		{	Long instruction = Long.parseLong(test);
			aff.setNumInstruction(instruction);	}
		
		
		test = request.getParameter("pourcentageDevis");
		if (test != null)
		{	Double pourcentDevis = Double.parseDouble(test);
			aff.setPourcentageDevis(pourcentDevis);	}
		
		test = request.getParameter("montantFacture");
		if (test != null)
		{	Double montantFacture = Double.parseDouble(test);
			aff.setMontantFacture(montantFacture);	}
		
		test = request.getParameter("pourcentRemise");
		if (test != null)
		{	Double pourcentRemise = Double.parseDouble(test);
			aff.setPourcentageRemise(pourcentRemise);	}
		
		test = request.getParameter("delais10j");
		if (test != null)
		{	Boolean delais10j = Boolean.parseBoolean(test);
			aff.setDelais10j(delais10j);	}
		
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
			HttpServletRequest request) {
		
		String etat = request.getParameter("etat");
		
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
			@PathVariable("idFrais") long idFrais, HttpServletRequest request) {
		
		Long prixFrais = Long.parseLong(request.getParameter("prixFrais"));
		affaireService.putFrais(idAffaire,idFrais,prixFrais);
		return "Success";
	}

	/**
	 * Méthode de modification d'un scellé d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param idScelle
	 *            numéro du scellé à modifier
	 * @param numeroPV
	 *            nouveau numéro du PV
	 * @param commentaire
	 *            nouveau commentaire
	 *      zhi      testé
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{idScelle}", method = RequestMethod.PUT)
	public @ResponseBody Scelle putScelle(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idScelle") long idScelle, HttpServletRequest request) {
		
		Long numeroPV = Long.parseLong(request.getParameter("numeroPV"));
		String nom = request.getParameter("nom");
		Long numeroScelle = Long.parseLong(request.getParameter("numeroScelle"));
		
		return affaireService.putScelle(idAffaire,idScelle,numeroPV,nom,numeroScelle);
	}

	// nana
	/**
	 * Méthode de modification d'un objet dans un scelle dans une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param idScelle
	 *            numéro du scellé qui contient l'objet
	 * @param idObjet
	 *            identifiant de l'objet à modifier
	 * @param libelleObjet
	 *            nouveau libelle de l'objet
	 * @param idTypeObjet
	 *            nouveau type de l'objet
	 * @param idScelle
	 *            nouveau numéro du scellé qui contient l'objet
	 * @author zhi testé
	 */

	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{idScelle}/objets/{idObjet}", method = RequestMethod.PUT)
	public @ResponseBody String putObjet(@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idScelle") long idScelleOld,
			@PathVariable("idObjet") long idObjet, HttpServletRequest request) {
		
		String libelleObjet =request.getParameter("libelleObjet");
		Long idTypeObjet = Long.parseLong(request.getParameter("idTypeObjet"));
		Long idScelleNew = Long.parseLong(request.getParameter("idScelle"));
		affaireService.putObjet(idAffaire,libelleObjet,idTypeObjet,idScelleNew,idScelleOld,idObjet);
		return "Success";
	}

	/**  ???
	 * Méthode de modification d'une type mission pour un type d'objet d'un
	 * scellé d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire concernée
	 * @param idScelle
	 *            identifiant du scellé concerné
	 * @param idTypeObjet
	 *            identifiant du type d'objet concerné
	 * @param idTypeMission
	 *            identifiant du type de mission à modifier
	 * @param libTypeMission
	 *            nouveau libellé
	 * @param prixMission
	 *            nouveau prix
	 *            zhi
	 */

	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{idScelle}/typeObjet/{idTypeObjet}/typeMissions/{idTypeMission}", method = RequestMethod.PUT)
	public TypeMission putTypeMissionForTypeObjetInScelle(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idScelle") long idScelle,
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission, HttpServletRequest request) {
		String libTypeMission=request.getParameter("libTypeMission");
		return affaireService.putTypeMissionForTypeObjetInScelle(idAffaire, idScelle, idTypeObjet, idTypeMission, libTypeMission);
	}

	/*
	 * -------------------------------------------------- METHODE DELETE ------------------------------------------------------------
	 */
	//nouvelle fonction 
	/**
	 * Méthode de suppression d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @author narjissezaki Terminé 
	 */
	@RequestMapping(value = "/affaires/{idAffaire}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteAffaire(
			@PathVariable("idAffaire") long idAffaire){
		String var="Echec";
		var=affaireService.deleteAffaire(idAffaire);
		return var;
	}
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
	 * @param idScelle
	 *            identifiant du scellé à supprimer
	 *            zhi testé
	 */

	@RequestMapping(value = "/affaire/{idAffaire}/scelles/{idScelle}", method = RequestMethod.DELETE, produces = "text/plain")
	public @ResponseBody String deleteScelle(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idScelle") long idScelle) {
		affaireService.deleteScelle(idAffaire, idScelle);
		return "success";
	}

	// nana
	/**
	 * Méthode de suppression d'un objet d'un scelle d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire
	 * @param idScelle
	 *            identifiant du scellé contenant l'objet
	 * @param idObjet
	 *            identifiant de l'objet à supprimer
	 * @author narjisse Zaki terminée testée
	 */

	@RequestMapping(value = "/affaires/{idAffaire}/scelles/{idScelle}/objet/{idObjet}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteObjetInScelle(@PathVariable("idAffaire") long idAffaire,
	@PathVariable("idScelle") long idScelle,
	@PathVariable("idObjet") long idObjet) {
		String var;
		var=affaireService.deleteObjetInScelleInAffaire(idAffaire, idScelle, idObjet);
		return var;
	}
	
	//nouvelle fonctinon par Zhi------------------------------------------------------------------------------------
	
	/**
	 * Méthode de delete liaison d'une type mission à un type d'objet d'une affaire
	 * 
	 * @param idAffaire
	 *            identifiant de l'affaire concernée
	 * @param idScelle
	 *            identifiant du scellé concerné
	 * @param idTypeObjet
	 *            identifiant du type d'objet à lier
	 * @param idTypeMission
	 *            identifiant du type de mission à lier
	 * @author Zhi terminé testé
	 * 
	 *         
	 */
	@RequestMapping(value = "/affaire/{idAffaire}/typeObjet/{idTypeObjet}/typeMissions", method = RequestMethod.DELETE)
	public @ResponseBody String deleteTypeMissionForTypeObjeteInAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idTypeObjet") long idTypeObjet,
			@RequestParam("idTypeMission") long idTypeMission) {
		affaireService.deleteTypeMissionForTypeObjeteInAffaire(idAffaire,idTypeObjet,idTypeMission);
		return "Success";
	}
	
	/**  
	 * Méthode pour obtenir des objets d'un type objet concernés par
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
	@RequestMapping(value = "/affaire/{idAffaire}/typeObjet/{idTypeObjet}/typeMissions/{idTypeMission}/objets", method = RequestMethod.GET)
	public @ResponseBody Set<Objet> getObjetForTypeObjetOfTypeMissionInAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission) {
	
		return affaireService.getObjetForTypeObjetOfTypeMissionInAffaire(idAffaire,idTypeObjet,idTypeMission);
	}

	/**  
	 * Méthode pour obtenir des etat objets d'un type objet concernés par
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
	@RequestMapping(value = "/affaire/{idAffaire}/typeObjet/{idTypeObjet}/typeMissions/{idTypeMission}/etat", method = RequestMethod.GET)
	public @ResponseBody Set<EtatObjet> getEtatObjetForTypeObjetOfTypeMissionInAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission) {
		
		return affaireService.getEtatObjetForTypeObjetOfTypeMissionInAffaire(idAffaire,idTypeObjet,idTypeMission);
	}
	

	/**
	 * Méthode de création d'un etat objet pour une typeMission
	 * 
	 * @author Zhi
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/objet/{idObjet}/TypeMission/{idTypeMission}/etat", method = RequestMethod.POST)
	public @ResponseBody EtatObjet createEtatObjet(
			@PathVariable("idObjet") long idObjet,
			@PathVariable("idTypeMission") long idTypeMission, HttpServletRequest request) {
		
		EtatObjet newEtatObjet = new EtatObjet();
		
		String commentaire=request.getParameter("commentaire");
		String fait=request.getParameter("fait");
		
		newEtatObjet.setIdTypeMission(idTypeMission);
		newEtatObjet.setIdObjet(idObjet);
		newEtatObjet.setCommentaire(commentaire);
		newEtatObjet.setFait(fait);
		
		return etatObjetService.addEtatObjet(newEtatObjet);
	}
	
	/**
	 * Méthode de modification d'un etat objet pour une typeMission
	 * 
	 * @author Zhi
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/objet/{idObjet}/TypeMission/{idTypeMission}/etat", method = RequestMethod.PUT)
	public @ResponseBody EtatObjet PutEtatObjet(
			@PathVariable("idObjet") long idObjet,
			@PathVariable("idTypeMission") long idTypeMission, HttpServletRequest request) {
		
		EtatObjet newEtatObjet = new EtatObjet();
		
		String commentaire=request.getParameter("commentaire");
		String fait=request.getParameter("fait");
		
		newEtatObjet.setIdTypeMission(idTypeMission);
		newEtatObjet.setIdObjet(idObjet);
		newEtatObjet.setCommentaire(commentaire);
		newEtatObjet.setFait(fait);
		
		return etatObjetService.updateEtatObjet(newEtatObjet);
	}
	
	/**
	 * Méthode de modification d'un etat objet pour une typeMission
	 * 
	 * @author Zhi
	 * 
	 *         Terminé testé
	 */
	@RequestMapping(value = "/objet/{idObjet}/TypeMission/{idTypeMission}/etat", method = RequestMethod.GET)
	public @ResponseBody EtatObjet GetEtatObjet(
			@PathVariable("idObjet") long idObjet,
			@PathVariable("idTypeMission") long idTypeMission, HttpServletRequest request) {

		
		return etatObjetService.getEtatObjet(idObjet, idTypeMission);
	}
}
