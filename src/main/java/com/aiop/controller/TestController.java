package com.aiop.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aiop.model.TypeMission;
import com.aiop.model.TypeObjet;
import com.aiop.service.TypeMissionService;
import com.aiop.service.TypeObjetService;

@RestController
public class TestController {
	@Autowired
	private TypeObjetService toService;
	@RequestMapping("/addTypeObjet")
	public <typeObjetService> ModelAndView addTypeObjet(){
		System.out.println("enter addTypeObjet");
		TypeObjet to=new TypeObjet(Long.parseLong("9838499283"));
	
		ModelAndView mav=null;
		to.setLibTypeObjet("new TypeObjet");
		
		try {
			toService.addTypeObjet(to);
			mav = new ModelAndView();
			mav.setViewName("success");
			mav.addObject("objet", to);
			mav.addObject("msg", "success");
			return mav;
		} catch (Exception e) {
			mav.addObject("objet", null);
			mav.addObject("msg", "fail");
			return mav;
		}
	}
	/**
	 * Méthode de récupération des types d'objet
	 * @return liste des type d'objets
	 */
	@RequestMapping(value = "/typeObjets", method = RequestMethod.GET)
	public ModelAndView getTypeObjets() {
		System.out.println("get all TypeObjet");
		// Il faudra load toutes les typeObjets depuis la bdd
		List<TypeObjet> x = toService.getTypeObjets();
		ModelAndView mav=null;
		try {
			mav = new ModelAndView();
			mav.addObject("objets",x);
			mav.setViewName("success");
			mav.addObject("msg", "success");
			return mav;
		} catch (Exception e) {
			mav.addObject("objets", null);
			mav.addObject("msg", "fail");
			return mav;
		}
	}
	
	@Autowired
	private TypeMissionService tmService;
	@RequestMapping("/addTypeMission")
	public <typeMissionService> ModelAndView addTypeMission(){
		System.out.println("enter addTypeMission");
		TypeMission tm=new TypeMission(Long.parseLong("9838499283"));
	
		ModelAndView mav=null;
		tm.setLibTypeMission("new TypeMission");
		try {
			tmService.addTypeMission(tm);;
			mav = new ModelAndView();
			mav.setViewName("success");
			mav.addObject("objet", tm);
			mav.addObject("msg", "success");
			return mav;
		} catch (Exception e) {
			mav.addObject("objet", null);
			mav.addObject("msg", "fail");
			return mav;
		}
	}
}
