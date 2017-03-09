package com.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.models.PageResponse;
import com.services.PageService;

@Controller("menuController")
@ComponentScan("org.cmsapiservice")
@RequestMapping("admin/menu")
public class MenuController {

	@Autowired
	@Qualifier("pageService")
	private PageService pageService;
	
	@RequestMapping(value = { "/create/{hostName}" }, method = RequestMethod.GET)
	public ModelAndView getEmployees(@PathVariable("hostName")String hostName) throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("hostName", hostName);
		Set<PageResponse> pages = pageService.getPages(hostName);
		data.put("pages", pages);
		
		return new ModelAndView("admin/menu/create", "data", data);
	}
}
