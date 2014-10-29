package com.moss.rjs.controller;

import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moss.rjs.message.MessageMapSource;

@Controller
public class HomeController {
	
	private Environment environmnet;
	private MessageMapSource messageMapSource;    

    @Inject
	public void setEnvironmnet(Environment environmnet) {
		this.environmnet = environmnet;
	}
    
    @Inject
    public void setMessageMapSource(MessageMapSource messageMapSource) {
        this.messageMapSource = messageMapSource;
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
    @RequestMapping(value="message/{locale}.json", method=RequestMethod.GET)
	public Map<String, String> getMessageList(@PathVariable Locale locale) {
	    return messageMapSource.getMessageMap(locale);
	}
}
