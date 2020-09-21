package com.lyscharlie.demo1.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	@RequestMapping(value = "index.php", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "login.php", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "userCenter.php", method = RequestMethod.GET)
	public ModelAndView userCenter(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		request.getSession().getAttribute("");

		modelAndView.setViewName("userCenter");
		return modelAndView;
	}

	@RequestMapping(value = "loginError.php", method = RequestMethod.GET)
	@ResponseBody
	public String loginError() {
		return "error";
	}

}
