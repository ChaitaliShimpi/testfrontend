package com.niit.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

@Controller
public class RegistrationController {

	@Autowired
	UserDAO userDAO;

	@RequestMapping("/register")
	private String Registration(Model m) {
		m.addAttribute("user", new User());
		return ("register");
	}

	@RequestMapping("saveUser")
	private String SaveUser(@ModelAttribute("User") User u, Model m) {
		u.setRole("ROLE_USER");
		u.setEnabled(true);
		userDAO.saveUser(u);
		return ("home");

	}

	@RequestMapping("/login")
	private String login() {

		return ("login");
	}

	@RequestMapping("/login_successful")
	private String HomePage(HttpSession session, Model m) {

		String page = "";
		boolean loggedIn = false;

		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();

		String username = authentication.getName();

		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) authentication.getAuthorities();
		for (GrantedAuthority role : roles) {
			session.setAttribute("role", role);

			if (role.getAuthority().equals("ROLE_ADMIN")) {
				loggedIn = true;
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
				page = "home";

			} else {
				loggedIn = true;
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
				page = "home";
			}
		}

		return page;
	}

	@RequestMapping("/login_failure")
	private String showError(Model m) {
		m.addAttribute("message", "Please check your login details!!!!!!!!");

		return "login";
	}
}
