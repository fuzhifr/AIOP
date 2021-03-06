package com.aiop.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.aiop.model.*;
import com.aiop.service.TarifService;
import com.aiop.service.TypeMissionService;
import com.aiop.service.TypeObjetService;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Zhi Narjisse
 *
 */
@RestController
public class BackendController {
	

	@Autowired
	private TypeObjetService typeObjetService;
	@Autowired
	private TarifService tarifService;
	@Autowired
	private TypeMissionService typeMissionService;
	/* ---------------------------------------------------- METHODE POST ---------------------------------------------------------------*/
	
	/**
	 * Méthode de création d'un typeMission d'un typeObjet
	 * @param idTypeObjet identifiant du type d'objet
	 * @param idTypeMission identifiant du type de mission
	 * @param libTypeMission libellé du type de Mission
	 */
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMissions", method = RequestMethod.POST)
	public @ResponseBody Tarif createFraisAffaire(
			@PathVariable("idTypeObjet") long idTypeObjet, HttpServletRequest request) {
		Long idTypeMission = Long.parseLong(request.getParameter("idTypeMission"));
		int forfait = Integer.parseInt(request.getParameter("forfait"));
		
		return tarifService.addTypeMission(idTypeObjet,idTypeMission,forfait);
	}

	/* ---------------------------------------------------- METHODE GET ---------------------------------------------------------------*/

	/**
	 * Méthode de récupération des types d'objet
	 * @return liste des type d'objets
	 */
	@RequestMapping(value = "/typeObjets", method = RequestMethod.GET)
	public @ResponseBody List<TypeObjet> getTypeObjets() {
		return typeObjetService.getTypeObjets();
	}

	//nouvelle fonction
	/**
	 * Méthode de récupération des types mission
	 * @return liste des type mission
	 * @author narjissezaki
	 */
	@RequestMapping(value = "/typeMissions", method = RequestMethod.GET)
	public @ResponseBody List<TypeMission> getTypeMissions() {
		return typeMissionService.getTypeMissions();
	}
	/**
	 * Méthode de récupération des type sMissions d'un type objet
	 * @param idTypeObjet identifiant du type d'objet
	 * @return liste des types mission du type objet
	 */
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMissions", method = RequestMethod.GET)
	public @ResponseBody Set<Tarif> getTypeMssions(
			@PathVariable("idTypeObjet") long idTypeObjet) {	
		return typeObjetService.getTypeObjet(idTypeObjet).getTarifs();
	}
	

	/**
	 * Méthode de récupération d'un type Mission d'un type objet
	 * @param idTypeObjet identifiant du type d'objet
	 * @param idTypeMission identifiant du type de mission
	 * @return type mission
	 */
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMission/{idTypeMission}", method = RequestMethod.GET)
	public @ResponseBody Tarif getTypeMssion(
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission) {

		// Il faudra load un typeMissions d'un typeObjet depuis la bdd
		return typeObjetService.getTypeMission(idTypeObjet,idTypeMission);
	}
	
	/**
	 * Méthode de récupération des types de mission non liées à un type objet
	 * @return liste des type d'objets
	 * @author narjisse Zaki
	 */
	@RequestMapping(value = "/typeMissionsNotAffected", method = RequestMethod.GET)
	public @ResponseBody Set<TypeMission> getTypeMissionsNotAssignedWTypeObjet() {
		return typeMissionService.getTypeMissionNotAssignedWTypeObjet();
	}
	
	/**
	 * Méthode qui pour 1 type d'objet, renvoie les type de mission non affectés
	 * @param
	 * @return liste des type mission, qui pour 1 type d'objet, ne sont pas affectées
	 * @author narjisse Zaki
	 */
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMissionNotAffectedWTypeObjet", method = RequestMethod.GET)
	public @ResponseBody Set<TypeMission> getTypeMssion(
			@PathVariable("idTypeObjet") long idTypeObjet) {

		return tarifService.getTypeMissionNotAssignedWTypeObjetID(idTypeObjet);
	}

	/* ---------------------------------------------------- METHODE PUT ---------------------------------------------------------------*/

	/**
	 * Méthode de modification d'un type Mission d'un typeObjet
	 * @param idTypeObjet identifiant du type d'objet
	 * @param idTypeMission identifiant du type de mission à modifier
	 * @param libTypeMission nouveau libellé
	 */
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMission/{idTypeMission}", method = RequestMethod.PUT)
	public @ResponseBody String putScelle(@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission,HttpServletRequest request) {
		String libTypeMission =request.getParameter("libTypeMission");
		int forfait = Integer.parseInt(request.getParameter("forfait"));
		typeObjetService.modifieInfo(idTypeObjet,idTypeMission,libTypeMission,forfait);
		return "Success";
	}

	/* ---------------------------------------------------- METHODE DELET ---------------------------------------------------------------*/

	/**
	 * Méthode de suppression d'un type Mission d'un type Objet
	 * @param idTypeObjet identifiant du type d'objet
	 * @param idTypeMission identifiant du type de mission à supprimer
	 */
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMission/{idTypeMission}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteTypeMission(
			@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission) {
		tarifService.deleteTypeMission(idTypeObjet, idTypeMission);
		return "Success";
	}
	
}
