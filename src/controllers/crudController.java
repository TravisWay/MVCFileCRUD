package controllers;

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
	//example
	@RequestMapping(path="searchname.do", method=RequestMethod.GET)
	  public ModelAndView getPeopleByName(@RequestParam("data") String s) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.getPeopleByName(s));
	    return mv;
	  }
	@RequestMapping(path="viewtree.do", method=RequestMethod.GET)
	  public ModelAndView getlist() {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.CurrentTree());
	    return mv;
	  }
	@RequestMapping(path="searchrelation.do", method=RequestMethod.GET)
	  public ModelAndView getPeopleByRelation(@RequestParam("data1") String s) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.getPeopleByRelation(s));
	    return mv;
	  }
	@RequestMapping(path="addmember.do", method=RequestMethod.GET)
	  public ModelAndView addMember(@RequestParam("addmember1") People people) {
	    ModelAndView mv = new ModelAndView();
	    familyTreeDAO.addPeople(people);
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.CurrentTree());
	    return mv;
	  }
	@RequestMapping(path="killmember.do", method=RequestMethod.GET)
	public ModelAndView killMember(@RequestParam("killmember1") People people) {
		ModelAndView mv = new ModelAndView();
		familyTreeDAO.killPeople(people);
		mv.setViewName("result.jsp");
		mv.addObject("result", familyTreeDAO.CurrentTree());
		return mv;
	}







}

