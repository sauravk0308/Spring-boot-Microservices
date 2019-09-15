package com.springmvc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.StudentDao;
import com.springmvc.model.Student;

@Controller
public class HomeController {

	@Autowired
	private StudentDao studentDao;
	
	@ModelAttribute
	public void ModelData(Model m) {
		
		m.addAttribute("name", "Saurav");
	}
	
	@RequestMapping("/")
	 public String home() 
	 {
		 return "index";
	 }
	
	/*@RequestMapping("/add")
	 public String add(HttpServletRequest req) 
	 {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int num3 = i+ j;000
		
		HttpSession session = req.getSession();
		session.setAttribute("num3", num3);
		 return "result.jsp";
	 }*/
	
	/*@RequestMapping("/add")
	 public ModelAndView add(@RequestParam("num1") int i,
			 			@RequestParam("num2") int j) 
	 {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result1");
		int num3 = i+ j;
		mv.addObject("num3", num3);
		
		 return mv;
	 }*/
	
	
	/*@RequestMapping("/add")
	 public String add(@RequestParam("num1") int i,
			 			@RequestParam("num2") int j, Model model) 
	 {
		int num3 = i+ j;
		model.addAttribute("num3", num3);
		 return "result1";
	 }*/
	
	@RequestMapping("/add")
	 public String add(@RequestParam("num1") int i,
			 			@RequestParam("num2") int j, ModelMap model) 
	 {
		int num3 = i+ j;
		model.addAttribute("num3", num3);
		 return "result1";
	 }
	
	 @GetMapping("/add")
	 public String getAllStudents(Model m) 
	 {
		m.addAttribute("students", studentDao.getUsers());
		 return "result1";
	 }
	
	@RequestMapping("addStudent")
	 public String addStudent(@ModelAttribute("student") Student s, ModelMap model) 
	 {
		 return "result1";
	 }
}
