package com.aiop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aiop.model.Scelle;
import com.aiop.service.AffaireService;

@RestController
public class TestController {
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
	 */
	@Autowired
	private AffaireService affaireService;

	//@RequestMapping(value = "/affaire/{idAffaire}/scelles", method = RequestMethod.POST)
	public @ResponseBody Scelle createScelleAffaire(
			@PathVariable("idAffaire") long idAffaire,
			@RequestParam("numeroScelle") long numeroScelle,
			@RequestParam("numeroPV") long numeroPV,
			@RequestParam("commentaire") String commentaire) {
		Scelle newScelle = new Scelle(numeroPV, commentaire);
		newScelle.setIdAffaire(idAffaire);
		affaireService.addScelle(idAffaire, newScelle);
		return newScelle;
	}
}
