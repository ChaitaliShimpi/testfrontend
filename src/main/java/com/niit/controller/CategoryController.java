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

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/category" }, method = RequestMethod.GET)

	public String categorycontroller(Model m) {
		List<Category> catlist = categoryDAO.getAllCategory();
		m.addAttribute("catlist", catlist);
		m.addAttribute("category", new Category());
		return "category";
	}

	@RequestMapping(value = { "/savecategory" }, method = RequestMethod.POST)
	public String savecat(@ModelAttribute("category") Category cat,Model m) {
		categoryDAO.addCategory(cat);
		List<Category> catlist = categoryDAO.getAllCategory();
		m.addAttribute("catlist", catlist);
		
		return "category";
	}
	@RequestMapping(value={"updatecategory{cat}"}, method= RequestMethod.GET)
	public String updatecategory(@PathVariable("cat") int cat, Model m) {
		Category category = categoryDAO.getOneCategory(cat);
		List<Category> catlist = categoryDAO.getAllCategory();
		m.addAttribute("catlist", catlist);
		m.addAttribute("category", category);
		return "category";
	}
	@RequestMapping(value={"updatecategory"}, method= RequestMethod.POST)
	public String updatecategoryInDB(@RequestParam("catid")int catid,@RequestParam("catname") String catname,@RequestParam("catDesc") String catDesc,Model m)
	{
	Category category=categoryDAO.getOneCategory(catid);
	category.setCatname(catname);
	category.setCatDesc(catDesc);
	
	categoryDAO.updateCategory(category);
	List<Category> catlist=categoryDAO.getAllCategory();
	m.addAttribute("catlist",catlist);
	return "category";
	}
	@RequestMapping(value = { "deletecategory{catid}"})
	public String deletecat(@PathVariable("catid") int catid) {
		categoryDAO.deleteCategory(catid);
		return "redirect:category";
	  }

}
