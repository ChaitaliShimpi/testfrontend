package com.niit.controller;

import java.util.Date;
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
import com.niit.model.*;

@Controller
public class ordercontroller {
	@Autowired
	private cartDAO cartDAO;
	@Autowired
	private productDAO productDAO;
	@Autowired
	private orderDAO orderDAO;

	@RequestMapping(value = { "Pay" })
	public String doPayment(Model m, HttpSession hs) {
		double price = 0, quantity = 0;
		String username = (String) hs.getAttribute("username");
		List<cart> cartItems = cartDAO.getAllUnpaidItem(username);
		for (cart cartItem : cartItems) {
			price = price + cartItem.getSubtotal();
			quantity = quantity + cartItem.getQuantity();
		}
		m.addAttribute("cartItems", cartItems);
		m.addAttribute("prodItems", listProducts());
		m.addAttribute("price", price);
		m.addAttribute("quantity", (int) quantity);

		return "PaymentPage";
	}

	public LinkedHashMap<Integer, String> listProducts() {
		List<product> listProducts = productDAO.getallproduct();
		LinkedHashMap<Integer, String> prodlist = new LinkedHashMap<Integer, String>();
		for (product product : listProducts) {
			prodlist.put(product.getProdId(), product.getProdName());
		}
		return prodlist;
	}

	@RequestMapping(value = { "ConfirmPayment" })
	public String confirmPayment(@RequestParam("paymode") String paymode, @RequestParam("shpAddr") String shpAddr,
			Model m, HttpSession hs) {
		double price = 0;
		String username = (String) hs.getAttribute("username");
		List<cart> cartlist = cartDAO.getAllUnpaidItem(username);
		for (cart cartItem : cartlist) {
			price = price + cartItem.getSubtotal();
		}

		order o = new order();
		o.setOrderId(1101);
		o.setUsername(username);
		o.setDeliveryStatus("Pending");
		o.setOrderDate(new Date());
		o.setShippingAddress(shpAddr);
		o.setTransactionType(paymode);
		o.setTotalAmount(price);
		orderDAO.addOrder(o);

		for (cart cartItem : cartlist) {
			cartItem.setPaymentStatus("p");
			cartItem.setOrderId(o.getOrderId());
			cartDAO.addCart(cartItem);
		}
		m.addAttribute("oid", o.getOrderId());
		return "PaymentConfirmed";
	}

}
