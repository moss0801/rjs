package com.moss.rjs.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.MessageSource;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moss.rjs.message.ExposedMessageSource;
import com.moss.rjs.message.MessageMapSource;

@Controller
public class HomeController {
	
	private Environment environmnet;
	private MessageSource messageSource;
	private Map<Locale, Map<String, String>> messageList = new HashMap<Locale, Map<String, String>>();
	
	private MessageMapSource messageMapSource;    

    @Inject
	public void setEnvironmnet(Environment environmnet) {
		this.environmnet = environmnet;
	}
    
    @Inject
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    @Inject
    public void setMessageMapSource(MessageMapSource messageMapSource) {
        this.messageMapSource = messageMapSource;
    }
    
    /*@PostConstruct
    public void afterProperties() {
        Locale locale = Locale.KOREA;
        Map<String, String> localeMessageList = new HashMap<String, String>();
        if (messageSource instanceof DelegatingMessageSource) {
            ExposedMessageSource source = (ExposedMessageSource)((DelegatingMessageSource) messageSource).getParentMessageSource();
            Set<String> keys = source.getKeys("message/app", locale);
            for (String key : keys) {
                localeMessageList.put(key, messageSource.getMessage(key, null, locale));
            }
        }
        messageList.put(locale, localeMessageList);
    }*/

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
	    //return messageList.get(locale);
	}
}
