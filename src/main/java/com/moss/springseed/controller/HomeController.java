package com.moss.springseed.controller;

import javax.inject.Inject;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	private Environment environmnet;
	
	@Inject
	public void setEnvironmnet(Environment environmnet) {
		this.environmnet = environmnet;
	}

	@ResponseBody
	@RequestMapping(value="", method=RequestMethod.GET)
	public String helloWorld() {
		return "Hello, World!";
	}
	
	@ResponseBody
	@RequestMapping(value="name", method=RequestMethod.GET)
	public String getName() {
		return environmnet.getProperty("name");
	}
}
