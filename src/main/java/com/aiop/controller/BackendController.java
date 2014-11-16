package com.aiop.controller;

import java.util.List;
import java.util.Set;

import com.aiop.model.*;
import com.aiop.service.TarifService;
import com.aiop.service.TypeObjetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Zhi
 *
 */
@RestController
public class BackendController {
	

	@Autowired
	private TypeObjetService typeObjetService;
	@Autowired
	private TarifService tarifService;
	/* ---------------------------------------------------- METHODE POST ---------------------------------------------------------------*/
	
	/**
	 * Méthode de création d'un typeMission d'un typeObjet
	 * @param idTypeObjet identifiant du type d'objet
	 * @param idTypeMission identifiant du type de mission
	 * @param libTypeMission libellé du type de Mission
	 */
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMissions", method = RequestMethod.POST)
	public @ResponseBody String createFraisAffaire(
			@PathVariable("idTypeObjet") long idTypeObjet,
			@RequestParam("idTypeMission") long idTypeMission,
			@RequestParam("forfait") int forfait) {
		String msg=tarifService.addTypeMission(idTypeObjet,idTypeMission,forfait);
		return msg;
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

	/**
	 * Méthode de récupération des type sMissions d'un type objet
	 * @param idTypeObjet identifiant du type d'objet
	 * @return liste des types mission du type objet
	 */
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMissions", method = RequestMethod.GET)
	public @ResponseBody Set<Tarif> getTypeMssions(
			@PathVariable("idTypeObjet") long idTypeObjet) {	
		return typeObjetService.getTypeObjet(idTypeObjet).getTypeMissions();
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

	/* ---------------------------------------------------- METHODE PUT ---------------------------------------------------------------*/

	/**
	 * Méthode de modification d'un type Mission d'un typeObjet
	 * @param idTypeObjet identifiant du type d'objet
	 * @param idTypeMission identifiant du type de mission à modifier
	 * @param libTypeMission nouveau libellé
	 */
	@RequestMapping(value = "/typeObjet/{idTypeObjet}/typeMission/{idTypeMission}", method = RequestMethod.PUT)
	public @ResponseBody String putScelle(@PathVariable("idTypeObjet") long idTypeObjet,
			@PathVariable("idTypeMission") long idTypeMission,
			@RequestParam("libTypeMission") String libTypeMission,
			@RequestParam("forfait") int forfait) {
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
