package com.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan("com.services, com.repo")
@RequestMapping(value = "admin/page")
public class PageController {

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public ModelAndView form() throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		return new ModelAndView("admin/pages/create", "data", data);
	}
	
	@RequestMapping(value = { "/page-design" }, method = RequestMethod.GET)
	public ModelAndView pageDesign() throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("template", "3col");
		return new ModelAndView("admin/pages/pageDesign", "data", data);
	}
	
	@RequestMapping(value = { "/page-update" }, method = RequestMethod.GET)
	public ModelAndView pageUpdate() throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("template", "3col");
		return new ModelAndView("admin/pages/create", "data", data);
	}
}
