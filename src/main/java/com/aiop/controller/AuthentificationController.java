package com.aiop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aiop.model.Token;
import com.aiop.service.TokenService;

@RestController
public class AuthentificationController {

	@Autowired
	private TokenService tockenService;	
/* ---------------------------------------------------- METHODE POST ---------------------------------------------------------------*/
	
	/**
	 * Méthode de connexion
	 * @param mot de passe 
	 * @return tocken
	 * @author narjissezaki
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody int connexion(HttpServletRequest request) {
		Token t= new Token();
		String mdp =request.getParameter("motDepasse");
		int tk=tockenService.connexion(t,mdp);
		return tk;
	}
	
	/**
	 * Méthode de connexion
	 * @param mot de passe 
	 * @return tocken
	 * @author narjissezaki
	 */
	@RequestMapping(value = "/tokens/{idToken}", method = RequestMethod.DELETE)
	public @ResponseBody String deconnexion(
			@PathVariable("idToken") int idToken) {
			String var="Echec";
		    var=tockenService.deconnexion(idToken);
		    return var;
	}
}
