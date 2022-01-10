package com.example.studentCrud.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.studentCrud.domain.Login;
import com.example.studentCrud.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService userService;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new Login());
		return mav;
	}

	//
	@GetMapping("/new1")
	public String add(Model model) {
		model.addAttribute("login", new Login());
		return "new1";
	}

	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("login") Login std) {
		userService.save(std);
		return "redirect:/login";
	}

	//
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("user") Login user, ModelAndView model, String error) {

		Login oauthUser = userService.login(user.getUsername(), user.getPassword());

		System.out.print(oauthUser);
		
		if (Objects.nonNull(oauthUser)) {
			model.addObject("sucMsg", "Login Successful");
			model.setViewName("redirect:/");
			return model;

		} else {
			model.addObject("failMsg", "Login Fail try again pls");

			//model.addObject("failMsg", "Login Fail try again pls");
	        model.setViewName("redirect:/login");
			return model;
		}

	}
	
	/*@PostMapping("/login")
	public String  login(@ModelAttribute("user") Login user, HttpServletRequest  model, String error) {

		Login oauthUser = userService.login(user.getUsername(), user.getPassword());

		  HttpSession session = model.getSession(false);
		  
		   System.out.print(oauthUser);
		   
		if (Objects.nonNull(oauthUser)) {
			
			//model.addObject("sucMsg", "Login Successful");
			//model.setViewName("redirect:/");
			
			return "redirect:/";

		} else {
			//model.addObject("failMsg", "Login Fail try again pls");
	        //model.setViewName("redirect:/login");
			String errorMessage="login fail pls try again";
			model.setAttribute("errorMessage", errorMessage);
			return "redirect:/login";
		}

	}*/
	
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new Login());
		return mav;
	}
	
	

	
	
}
