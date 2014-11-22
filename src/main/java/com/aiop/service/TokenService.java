package com.aiop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.aiop.dao.TokenDaoI;

import com.aiop.model.Token;


@Service("tokenService")  
@Transactional  
public class TokenService {
	 @Autowired  
	    private TokenDaoI tokenDao;
	 	private String motDePasse="judiciaire";

	public int connexion(Token t, String mdp) {
		Token tockenLast=null;
		if(mdp.equals(this.motDePasse)){
			tokenDao.save(t);
			//récuperer l'id du dernier token ajouuté
			int idTokenLast=tokenDao.lastInsert();
			//charger le dernier token ajouté
			tockenLast=tokenDao.load(idTokenLast);
			if(tockenLast!=null){
			return tockenLast.getIdToken();
			}
			else{
				return 0;
			}
		}
			return 0;
	}

	public String deconnexion(int idToken) {
		tokenDao.delete(idToken);
		return "Deconnexion";
		
	}
	
	 

}
