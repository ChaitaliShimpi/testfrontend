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
public class OrderController {
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping(value = { "Pay" })
	public String doPayment(Model m, HttpSession hs) {
		double price = 0, quantity = 0;
		String username = (String) hs.getAttribute("username");
		List<Cart> cartItems = cartDAO.getAllUnpaidItem(username);
		for (Cart cartItem : cartItems) {
			int subquan=cartItem.getQuantity();
			Product p=productDAO.getOneProduct(cartItem.getProdId());	
			int temp=p.getQuantity()-subquan;
			p.setQuantity(temp);
			productDAO.addProduct(p);
			
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
		List<Product> listProducts = productDAO.getAllProduct();
		LinkedHashMap<Integer, String> prodlist = new LinkedHashMap<Integer, String>();
		for (Product product : listProducts) {
			prodlist.put(product.getProdId(), product.getProdName());
		}
		return prodlist;
	}

	@RequestMapping(value = { "ConfirmPayment" })
	public String confirmPayment(@RequestParam("paymode") String paymode, @RequestParam("pincode") int pincode, @RequestParam("state") String state,
			@RequestParam("shpAddr") String shpAddr, Model m, HttpSession hs) {
		double price = 0;
		String username = (String) hs.getAttribute("username");
		List<Cart> cartlist = cartDAO.getAllUnpaidItem(username);
		for (Cart cartItem : cartlist) {
			price = price + cartItem.getSubtotal();
		}

		Order o = new Order();
		o.setOrderId(1101);
		o.setUsername(username);
		o.setDeliveryStatus("Pending");
		o.setOrderDate(new Date());
		o.setPincode(pincode);
		o.setState(state);
		o.setShippingAddress(shpAddr);
		o.setTransactionType(paymode);
		o.setTotalAmount(price);
		orderDAO.addOrder(o);

		for (Cart cartItem : cartlist) {
			cartItem.setPaymentStatus("p");
			cartItem.setOrderId(o.getOrderId());
			cartDAO.addCart(cartItem);
		}
		m.addAttribute("oid", o.getOrderId());
		return "PaymentConfirmed";
	}

}
