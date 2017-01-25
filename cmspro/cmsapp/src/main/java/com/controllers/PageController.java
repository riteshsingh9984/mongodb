package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.models.HostResponse;
import com.models.PageRequest;
import com.models.PageResponse;
import com.services.PageService;

@Controller
@ComponentScan("com.services, com.repo")
@RequestMapping(value = "admin/page")
public class PageController {

	@Autowired
	@Qualifier("pageService")
	private PageService pageService;
	
	@RequestMapping(value = { "/create/{hostName}" }, method = RequestMethod.GET)
	public ModelAndView form(@PathVariable("hostName") String hostName) throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("hostName", hostName);
		
		return new ModelAndView("admin/pages/create", "data", data);
	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("hostSave") PageRequest page, BindingResult result,
			HttpServletRequest request) throws Exception {
		System.out.println("Page Details : " + new Gson().toJson(page));
		try {
			pageService.save(page);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("hostName", page.getHostName());
		
		return new ModelAndView("admin/pages/list", "data", data);
	}
	
	@RequestMapping(value = { "/get-pages/{hostName}" }, method = RequestMethod.GET)
	public ModelAndView getEmployees(@PathVariable("hostName")String hostName) throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("hostName", hostName);
		
		return new ModelAndView("admin/pages/list", "data", data);
	}
	
	@RequestMapping(value = "/getpages/{hostName}", method = RequestMethod.GET)
    public @ResponseBody Object getHostList(@PathVariable("hostName")String hostName) throws IOException {
		
		Set<PageResponse> pages = pageService.getPages(hostName);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("data", pages);
		
		return new Gson().toJson(data);
    }
	
	@RequestMapping(value = { "/page-design/{hostName}/{pageName}" }, method = RequestMethod.GET)
	public ModelAndView pageDesign(@PathVariable("hostName")String hostName,@PathVariable("pageName")String pageName) throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("template", "3col");
		data.put("hostName", hostName);
		data.put("pageName", pageName);
		return new ModelAndView("admin/pages/pageDesign", "data", data);
	}
	
	@RequestMapping(value = { "/page-update" }, method = RequestMethod.GET)
	public ModelAndView pageUpdate() throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("template", "3col");
		return new ModelAndView("admin/pages/create", "data", data);
	}
}
