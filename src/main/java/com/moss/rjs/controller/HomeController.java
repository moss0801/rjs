package com.moss.rjs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.moss.rjs.message.MessageMapSource;
import com.moss.rjs.model.Book;

@Controller
public class HomeController {
	
	private Environment environmnet;
	private MessageMapSource messageMapSource;
	private MappingJackson2JsonView jsonView;

    @Inject
	public void setEnvironmnet(Environment environmnet) {
		this.environmnet = environmnet;
	}
    
    @Inject
    public void setMessageMapSource(MessageMapSource messageMapSource) {
        this.messageMapSource = messageMapSource;
    }
    
    @PostConstruct
    public void afterPropertiesSet() {
        jsonView = new MappingJackson2JsonView();
        jsonView.setContentType("text/palin");
        jsonView.setExtractValueFromSingleKeyModel(true);
    }

	@RequestMapping(value="*", method=RequestMethod.GET)
	public ModelAndView index() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("index");
	    System.out.println(new Date());
	    return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="name", method=RequestMethod.GET)
	public List<String> getName() {
	    List<String> list = new ArrayList<String>();
	    for (int i = 0; i < 10; i++) {
	        list.add(environmnet.getProperty("name") + i);
	    }
		return list;
	}
	
	@ResponseBody
    @RequestMapping(value="book", method=RequestMethod.GET)
    public List<Book> getBookList() throws InterruptedException {
        List<Book> list = new ArrayList<Book>();
        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            book.setTitle("book title" + i);
            book.setContent("book content" + i);
            list.add(book);
        }
        //Thread.sleep(150);
        return list;
    }
	
	@ResponseBody
    @RequestMapping(value="message/{locale}.json", method=RequestMethod.GET)
	public Map<String, String> getMessageList(@PathVariable Locale locale) {
	    return messageMapSource.getMessageMap(locale);
	}
	
	@RequestMapping(value="app/templates/directives/ticketTable.html", method=RequestMethod.GET)
	public ModelAndView ticketTableTemplate(@RequestParam(required=false) List<String> columnList) {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("columnList", columnList);
	    mav.setViewName("templates/directives/ticketTable");
	    return mav;
	}
	
	@RequestMapping(value="file", method=RequestMethod.GET)
    public ModelAndView file() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("file");
        return mav;
    }
	
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public ModelAndView fileUpload(@ModelAttribute MultipartFile file) {
	    ModelAndView mav = new ModelAndView();
	    System.out.println("test");
	    Book book = new Book();
	    book.setTitle(file.getName());
	    mav.addObject("result", book);
	    mav.setView(jsonView);
	    return mav;
	}
}
