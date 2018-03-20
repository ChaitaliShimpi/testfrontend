package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.DAO.SupplierDAO;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	private SupplierDAO supplierDAO;

	@RequestMapping(value = { "supplier" }, method = RequestMethod.GET)
	public String supplierController(Model m) {
		List<Supplier> supplist = supplierDAO.getAllSupplier();
		m.addAttribute("supplist", supplist);
		m.addAttribute("supplier", new Supplier());
		return "supplier";
	}

	@RequestMapping(value = { "savesupplier" }, method = RequestMethod.POST)
	public String savesupp(@ModelAttribute("supplier") Supplier supp) {
		supplierDAO.addSupplier(supp);
		return "redirect:supplier";
	}

	@RequestMapping(value = { "/updatesupplier{supp}" })
	public String updatesupp(@PathVariable("supp") int supp, Model m) {
		Supplier s = supplierDAO.getOneSupplier(supp);
		List<Supplier> supplist = supplierDAO.getAllSupplier();
		m.addAttribute("supplist", supplist);
		m.addAttribute("supplier", s);
		return "supplier";
	}

	@RequestMapping(value = { "deletesupplier{suppid}" })
	public String deletesupp(@PathVariable("suppid") int suppid) {
		supplierDAO.deleteSupplier(suppid);
		return "redirect:supplier";
	}
}
