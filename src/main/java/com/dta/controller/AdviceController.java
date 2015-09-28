package com.dta.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@ControllerAdvice
public class AdviceController {
	
	@ExceptionHandler(Exception.class)
	// Le type d'exception interceptée
	public ModelAndView exceptionHandler(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.getModel().put("message", e.getMessage());// Varibales passées à la cible
		mav.setViewName("error");// Page cible
		return mav;
	}
	
}