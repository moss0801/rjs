package com.moss.rjs;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class TestControllerAdvice {
    
    @ExceptionHandler(Exception.class) 
    public ModelAndView exception(Exception e) {
        ModelAndView mav = new ModelAndView();
        return mav;
    }

}
