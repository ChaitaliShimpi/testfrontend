package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.DAO.supplierDAO;
import com.niit.model.supplier;

@Controller
public class suppliercontroller {
	@Autowired
	private supplierDAO supplierDAO;

	@RequestMapping(value = { "supplier" }, method = RequestMethod.GET)
	public String suppliercontroller(Model m) {
		List<supplier> supplist = supplierDAO.getAllsupplier();
		m.addAttribute("supplist", supplist);
		m.addAttribute("supplier", new supplier());
		return "supplier";
	}

	@RequestMapping(value = { "savesupplier" }, method = RequestMethod.POST)
	public String savesupp(@ModelAttribute("supplier") supplier supp) {
		supplierDAO.addsupplier(supp);
		return "redirect:supplier";
	}

	@RequestMapping(value = { "/updatesupplier{supp}" })
	public String updatesupp(@PathVariable("supp") int supp, Model m) {
		supplier s = supplierDAO.getOnesupplier(supp);
		List<supplier> supplist = supplierDAO.getAllsupplier();
		m.addAttribute("supplist", supplist);
		m.addAttribute("supplier", s);
		return "supplier";
	}

	@RequestMapping(value = { "deletesupplier{suppid}" })
	public String deletesupp(@PathVariable("suppid") int suppid) {
		supplierDAO.deletesupplier(suppid);
		return "redirect:supplier";
	}
}
