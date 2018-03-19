package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.categoryDAO;
import com.niit.DAO.productDAO;
import com.niit.DAO.supplierDAO;
import com.niit.model.cart;
import com.niit.model.category;
import com.niit.model.product;
import com.niit.model.supplier;
import com.niit.DAO.cartDAO;

@Controller
public class pagecontroller {
	@Autowired
	private categoryDAO categoryDAO;
	@Autowired
	private supplierDAO supplierDAO;
	@Autowired
	private productDAO productDAO;
	@Autowired
	private cartDAO cartDAO;

	@RequestMapping("ProductDisplay")
	public String proddisp(Model m) {
		List<product> prodlist = productDAO.getallproduct();
		for (product product : prodlist) {
			System.out.println(product);
		}
		m.addAttribute("prodlist", prodlist);
		return "ProductDisplay";
	}

	@RequestMapping(value = { "ProductDescription{prodid}" })
	public String proddesc(@PathVariable("prodid") int prodId, Model m) {
		product prod = productDAO.getOneproduct(prodId);
		m.addAttribute("proditem", prod);
		return "ProductDesc";
	}

	@RequestMapping(value = { "/home" })
	public String homecontroller() {
		return "home";

	}

	@RequestMapping(value = { "/" })
	public String indexcontroller() {
		return "index";
	}

}