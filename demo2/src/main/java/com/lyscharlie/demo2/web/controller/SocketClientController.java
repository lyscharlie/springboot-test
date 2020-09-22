package com.lyscharlie.demo2.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
	@RequestMapping(value = "/socket")
public class SocketClientController {

	@RequestMapping(value = "client.html", method = RequestMethod.GET)
	public String socket(){
		return "socket";
	}
}
