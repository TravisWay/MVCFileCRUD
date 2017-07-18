package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import data.FamilyTreeDAO;
import data.People;

@Controller
public class crudController {
	@Autowired
	private FamilyTreeDAO familyTreeDAO;
	 

	@RequestMapping(path = "searchname.do", method = RequestMethod.GET)
	public ModelAndView getPeopleByName(@RequestParam("data") String s, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultsearch.jsp");
		//session.setAttribute("searchresults", familyTreeDAO.getPeopleByName(s));
		mv.addObject("result", familyTreeDAO.getPeopleByName(s));
		return mv;
	}

	@RequestMapping(path = "viewtree.do", method = RequestMethod.GET)
	public ModelAndView getlist(HttpSession session, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		session.getAttribute("searchresults");
		session.getAttribute("searchresultsRelation");
		mv.addObject("Parents", familyTreeDAO.Relatives().get("Parents"));
		mv.addObject("Spouse", familyTreeDAO.Relatives().get("Spouse"));
		mv.addObject("You", familyTreeDAO.Relatives().get("You"));
		mv.addObject("Children", familyTreeDAO.Relatives().get("Children"));
		mv.addObject("Grandparents", familyTreeDAO.Relatives().get("GrandParents"));
		mv.addObject("GreatGrandparents", familyTreeDAO.Relatives().get("GreatGrandParents"));
		mv.addObject("Sibling", familyTreeDAO.Relatives().get("Siblings"));
		mv.addObject("AuntsUncles", familyTreeDAO.Relatives().get("AuntsUncles"));
		return mv;
	}

	@RequestMapping(path = "searchrelation.do", method = RequestMethod.GET)
	public ModelAndView getPeopleByRelation(@RequestParam("relation") String s, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultsearch.jsp");
		//session.setAttribute("searchresultsRelation", familyTreeDAO.getPeopleByRelation(s));
		mv.addObject("result", familyTreeDAO.getPeopleByRelation(s));
		return mv;
	}

	@RequestMapping(path = "addpeople.do", method = RequestMethod.POST)
	public ModelAndView addMember(People people, HttpSession session, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:addpeople2.do");
		redir.addFlashAttribute("result", familyTreeDAO.addPeople(people));
		return mv;
	}

	@RequestMapping(path = "addpeople2.do", method = RequestMethod.GET)
	public ModelAndView addMember2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultaddPeople.jsp");
		return mv;
	}

	@RequestMapping(path = "killpeople.do", method = RequestMethod.POST)
	public ModelAndView killMember(People people, HttpSession session, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:killpeople2.do");
		redir.addFlashAttribute("result", familyTreeDAO.killPeople(people));
		return mv;
	}

	@RequestMapping(path = "killpeople2.do", method = RequestMethod.GET)
	public ModelAndView killMember2(People people, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultkillPeople.jsp");
		return mv;
	}

	@RequestMapping(path = "killallpeople.do", method = RequestMethod.POST)
	public ModelAndView DeleteAll(People people, HttpSession session, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:killallpeople2.do");
		redir.addFlashAttribute("result", familyTreeDAO.DeleteAll());
		return mv;
	}

	@RequestMapping(path = "killallpeople2.do", method = RequestMethod.GET)
	public ModelAndView DeleteAll(People people, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("resultallPeople.jsp");
		return mv;
	}

	
}
