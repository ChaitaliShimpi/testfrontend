package com.niit.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.*;
import com.niit.model.Cart;
import com.niit.model.Product;
@Controller
public class CartController {
	
		@Autowired
		private CartDAO cartDAO;
		@Autowired
		private ProductDAO productDAO;
		@Autowired
		private OrderDAO orderDAO;

		@RequestMapping(value = { "AddToCart" })
		public String addToCart(@RequestParam("quantity") int quantity, @RequestParam("prodId") int prodId, Model m,
				HttpSession hs) {
			Product prod = productDAO.getOneProduct(prodId);
			double subtotal = (prod.getPrice()) * (quantity);
			String username = (String) hs.getAttribute("username");
			Cart ca = new Cart();
			ca.setPaymentStatus("np");
			ca.setProdId(prodId);
			ca.setQuantity(quantity);
			ca.setSubtotal(subtotal);
			ca.setUsername(username);
			ca.setOrderId(0);
			cartDAO.addCart(ca);
			m.addAttribute("c", ca);
			return "redirect:cart";
		}

		@RequestMapping(value = { "/cart" })
		public String showCart(Model m, HttpSession hs) {
			double price = 0, quantity = 0;
			String username = (String) hs.getAttribute("username");
			List<Cart> cartItems = cartDAO.getAllUnpaidItem(username);
			for (Cart cartItem : cartItems) {
				price = price + cartItem.getSubtotal();
				quantity = quantity + cartItem.getQuantity();
			}
			m.addAttribute("cart", cartItems);
			m.addAttribute("prod", listProducts());
			m.addAttribute("price", price);
			m.addAttribute("quantity", (int) quantity);
			return "cart";
		}

		public LinkedHashMap<Integer, String> listProducts() {
			List<Product> listProducts = productDAO.getAllProduct();
			LinkedHashMap<Integer, String> prodlist = new LinkedHashMap<Integer, String>();
			for (Product product : listProducts) {
				prodlist.put(product.getProdId(), product.getProdName());
			}
			return prodlist;
		}

		@RequestMapping("DeleteCartItem{cartId}")
		public String deletecartitem(@PathVariable("cartId") int cartId,Model m, HttpSession hs) {
			cartDAO.deleteCart(cartId);
			double price = 0, quantity = 0;
			String username = (String) hs.getAttribute("username");
			List<Cart> cartItems = cartDAO.getAllUnpaidItem(username);
			for (Cart cart : cartItems) {
				price = price + cart.getSubtotal();
				quantity = quantity + cart.getQuantity();
			}
			m.addAttribute("cartItems", cartItems);
			m.addAttribute("prodItems", listProducts());
			m.addAttribute("price", price);
			m.addAttribute("quantity", (int) quantity);
			return "redirect:cart";
		}
}
