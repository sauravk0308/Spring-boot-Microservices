package com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("home")
	public ModelAndView home(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.setViewName("home");
		return mv;
		//return "home";
	}
}
