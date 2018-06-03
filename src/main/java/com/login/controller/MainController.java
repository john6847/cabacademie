package com.login.controller;

import com.login.model.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.login.model.LocalUser;
import com.login.social.providers.FacebookProvider;
import com.login.social.providers.GoogleProvider;
import com.login.social.providers.LinkedInProvider;

@Controller
public class MainController {

	@Autowired 
	FacebookProvider facebookProvider;
	
	@Autowired 
	GoogleProvider googleProvider;

	@Autowired 
	LinkedInProvider linkedInProvider;

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String loginToFacebook(Model model) {
		return facebookProvider.getFacebookUserData(model, new LocalUser());
	}

	@RequestMapping(value = "/google", method = RequestMethod.GET)
	public String loginToGoogle(Model model) {
		return googleProvider.getGoogleUserData(model, new LocalUser());
	}

	@RequestMapping(value = { "/login" })
	public String login() {
		return "login";
	}


	@RequestMapping(value = "/linkedin", method = RequestMethod.GET)
	public String helloFacebook(Model model) {
		return linkedInProvider.getLinkedInUserData(model, new LocalUser());
	}

	@RequestMapping(value = { "/" })
	public String index() {
		return "index";
	}
}
