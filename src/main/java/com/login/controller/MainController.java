package com.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
//
//	@Autowired
//	FacebookProvider facebookProvider;
//
//	@Autowired
//	GoogleProvider googleProvider;
//
//	@Autowired
//	LinkedInProvider linkedInProvider;
//
//	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
//	public String loginToFacebook(Model model) {
//		return facebookProvider.getFacebookUserData(model, new LocalUser());
//	}
//
//	@RequestMapping(value = "/google", method = RequestMethod.GET)
//	public String loginToGoogle(Model model) {
//		return googleProvider.getGoogleUserData(model, new LocalUser());
//	}
//
//	@RequestMapping(value = { "/login" })
//	public String login() {
//		return "login";
//	}
//
//
//	@RequestMapping(value = "/linkedin", method = RequestMethod.GET)
//	public String helloFacebook(Model model) {
//		return linkedInProvider.getLinkedInUserData(model, new LocalUser());
//	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index() {
		return "index";
	}
@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homePage() {
		return "partials/home";
	}

	@RequestMapping(value = { "/course" }, method = RequestMethod.GET)
	public String course() {
		return "partials/course";
	}
	@RequestMapping(value = { "/registerCourse" }, method = RequestMethod.GET)
	public String registerCourse() {
		return "partials/register_course";
	}
	@RequestMapping(value = { "/login" },method = { RequestMethod.GET})
	public String login() {
		return "partials/login";
	}
@RequestMapping(value = { "/category" }, method = RequestMethod.GET)
	public String category() {
		return "partials/category";
	}


}
