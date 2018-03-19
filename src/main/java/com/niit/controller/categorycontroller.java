package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.categoryDAO;
import com.niit.model.category;
import com.niit.model.supplier;

@Controller
public class categorycontroller {
	@Autowired
	private categoryDAO categoryDAO;

	@RequestMapping(value = { "/category" }, method = RequestMethod.GET)

	public String categorycontroller(Model m) {
		List<category> catlist = categoryDAO.getallcategory();
		m.addAttribute("catlist", catlist);
		m.addAttribute("category", new category());
		return "category";
	}

	@RequestMapping(value = { "/savecategory" }, method = RequestMethod.POST)
	public String savecat(@ModelAttribute("category") category cat,Model m) {
		categoryDAO.addCategory(cat);
		List<category> catlist = categoryDAO.getallcategory();
		m.addAttribute("catlist", catlist);
		
		return "category";
	}
	@RequestMapping(value={"updatecategory{cat}"}, method= RequestMethod.GET)
	public String updatecategory(@PathVariable("cat") int cat, Model m) {
		category category = categoryDAO.getOnecategory(cat);
		List<category> catlist = categoryDAO.getallcategory();
		m.addAttribute("catlist", catlist);
		m.addAttribute("category", category);
		return "category";
	}
	@RequestMapping(value={"updatecategory"}, method= RequestMethod.POST)
	public String updatecategoryInDB(@RequestParam("catid")int catid,@RequestParam("catname") String catname,@RequestParam("catDesc") String catDesc,Model m)
	{
	category category=categoryDAO.getOnecategory(catid);
	category.setCatname(catname);
	category.setCatDesc(catDesc);
	
	categoryDAO.updatecategory(category);
	List<category> catlist=categoryDAO.getallcategory();
	m.addAttribute("catlist",catlist);
	return "category";
	}
	@RequestMapping(value = { "deletecategory{catid}"})
	public String deletecat(@PathVariable("catid") int catid) {
		categoryDAO.deletecategory(catid);
		return "redirect:category";
	  }

}
