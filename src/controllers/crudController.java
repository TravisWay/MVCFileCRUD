package controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@RequestMapping(path="viewtree.do", method=RequestMethod.POST)
	  public ModelAndView getlist(HttpSession session,RedirectAttributes redir) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("redirect:viewtree2.do");
	    redir.addFlashAttribute("result", familyTreeDAO.CurrentTree());
	    return mv;
	  }
	@RequestMapping(path="viewtree2.do", method=RequestMethod.GET)
	public ModelAndView getlist2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		return mv;
	}

	@RequestMapping(path="searchrelation.do", method=RequestMethod.GET)
	  public ModelAndView getPeopleByRelation(@RequestParam("relation") String s, HttpSession session) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("result.jsp");
	    mv.addObject("result", familyTreeDAO.getPeopleByRelation(s));
	    //session.setAttribute("result", familyTreeDAO.getPeopleByRelation(s));
	    return mv;
	  }
	@RequestMapping(path="addpeople.do", method=RequestMethod.POST)
	  public ModelAndView addMember(People people,HttpSession session,RedirectAttributes redir) {
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("redirect:addpeople2.do");
	    redir.addFlashAttribute("result", familyTreeDAO.addPeople(people));	    
	    return mv;
	  }
	@RequestMapping(path="addpeople2.do", method=RequestMethod.GET)
	public ModelAndView addMember2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultaddPeople.jsp");	    
		return mv;
	}
	@RequestMapping(path="killpeople.do", method=RequestMethod.POST)
	public ModelAndView killMember(People people,HttpSession session, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:killpeople2.do");
		redir.addFlashAttribute("result", familyTreeDAO.killPeople(people));
		return mv;
	}
	@RequestMapping(path="killpeople2.do", method=RequestMethod.GET)
	public ModelAndView killMember(People people,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultkillPeople.jsp");
		return mv;
	}







}

