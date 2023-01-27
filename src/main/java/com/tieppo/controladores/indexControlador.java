package com.tieppo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class indexControlador {
	
	@GetMapping("/")
	public ModelAndView index(ModelMap model) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
}
