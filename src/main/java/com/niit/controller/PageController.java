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

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.DAO.SupplierDAO;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.DAO.CartDAO;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CartDAO cartDAO;

	@RequestMapping("ProductDisplay")
	public String proddisp(Model m) {
		List<Product> prodlist = productDAO.getAllProduct();
		m.addAttribute("prodlist", prodlist);
		return "ProductDisplay";
	}

	@RequestMapping(value = { "ProductDescription{prodid}" })
	public String proddesc(@PathVariable("prodid") int prodId, Model m) {
		Product prod = productDAO.getOneProduct(prodId);
		m.addAttribute("proditem", prod);
		return "ProductDesc";
	}

	@RequestMapping(value = { "/home" })
	public String homeController() {
		return "home";

	}

	@RequestMapping(value = { "/" })
	public String indexController() {
		return "index";
	}

}