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
@RequestMapping(value = "admin/templates")
public class TemplateController {

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public ModelAndView form() throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("content", "Woowwwww");
		return new ModelAndView("admin/templateBank/templates", "data", data);
	}
	
	@RequestMapping(value = { "/createTemplate" }, method = RequestMethod.GET)
	public ModelAndView formTemplate() throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("content", "Woowwwww");
		return new ModelAndView("admin/templateBank/create", "data", data);
	}
}