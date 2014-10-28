package com.moss.rjs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private Environment environmnet;
	
	@Inject
	public void setEnvironmnet(Environment environmnet) {
		this.environmnet = environmnet;
	}

	@RequestMapping(value="*", method=RequestMethod.GET)
	public ModelAndView index() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("index");
	    return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="name", method=RequestMethod.GET)
	public String getName() {
		return environmnet.getProperty("name");
	}
	
	@ResponseBody
    @RequestMapping(value="message", method=RequestMethod.GET)
	public Map<String, String> getMessageList() {
	    Map<String, String> messageList = new HashMap<String, String>();
	    messageList.put("ABC", "에이비씨");
	    messageList.put("DEF", "디이에프");
	    return messageList;
	}
}
