package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.FamilyTreeDAO;


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
	@RequestMapping(path="view.do", method=RequestMethod.GET)
	  public ModelAndView getlist(@RequestParam("data") String s) {
	    
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.CurrentTree());
	    return mv;
	  }
	@RequestMapping(path="route.do", method=RequestMethod.GET)
	  public ModelAndView getPeopleByName(@RequestParam("data") String s) {
	    
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.getPeopleByName(s));
	    return mv;
	  }
	@RequestMapping(path="route.do", method=RequestMethod.GET)
	  public ModelAndView getPeopleByName(@RequestParam("data") String s) {
	    
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.getPeopleByName(s));
	    return mv;
	  }







}

