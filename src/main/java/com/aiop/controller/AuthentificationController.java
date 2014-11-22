package com.aiop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aiop.model.Token;

import com.aiop.service.TokenService;

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
	public @ResponseBody int connexion(
			@PathVariable("motDepasse") long motDepasse, HttpServletRequest request) {
		Token t= new Token();
		String mdp =request.getParameter("motDepasse");
		int tk=tockenService.connexion(t,mdp);
		return tk;
	}
}
