package controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.FamilyTreeDAO;
import data.People;


@Controller
public class crudController {
	@Autowired
	private FamilyTreeDAO familyTreeDAO;

	@RequestMapping(path="searchname.do", method=RequestMethod.GET)
	  public ModelAndView getPeopleByName(@RequestParam("data") String s, HttpSession session) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.getPeopleByName(s));
	    
	    return mv;
	  }
	@RequestMapping(path="viewtree.do", method=RequestMethod.GET)
	  public ModelAndView getlist(HttpSession session) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.CurrentTree());
	    return mv;
	  }
	@RequestMapping(path="searchrelation.do", method=RequestMethod.GET)
	  public ModelAndView getPeopleByRelation(@RequestParam("relation") String s, HttpSession session) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.getPeopleByRelation(s));
	    
	    return mv;
	  }
	@RequestMapping(path="addpeople.do", method=RequestMethod.GET)
	  public ModelAndView addMember(People people,HttpSession session) {
	    ModelAndView mv = new ModelAndView();
	    familyTreeDAO.addPeople(people);
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.CurrentTree());
	    session.setAttribute("result", familyTreeDAO.CurrentTree());
	    
	    return mv;
	  }
	@RequestMapping(path="killpeople.do", method=RequestMethod.GET)
	public ModelAndView killMember(People people,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		familyTreeDAO.killPeople(people);
		mv.setViewName("result.jsp");
		mv.addObject("result", familyTreeDAO.CurrentTree());
		
		return mv;
	}







}

