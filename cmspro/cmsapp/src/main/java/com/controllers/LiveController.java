package com.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

@Controller("liveController")
@ComponentScan("org.cmsapiservice")
@RequestMapping("live")
public class LiveController {

	@Autowired
	@Qualifier("pageService")
	private PageService pageService;
	
	@RequestMapping(value = { "/{hostName}/{pageName}" }, method = RequestMethod.GET)
	public ModelAndView formPageDesignPreview(@PathVariable("hostName") String hostName, @PathVariable("pageName") String pageName) throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		PageResponse pageResponse = null;
		try{
			pageResponse = pageService.getPageByPageName(pageName,hostName);
			if(pageResponse != null){
				data.put("page", pageResponse);
				return new ModelAndView("admin/live/live", "data", data);
			}
		}catch(Exception ee){}
		
		data.put("page", pageResponse);
		return new ModelAndView("admin/live/404", "data", data);
	}
	
	@RequestMapping(value = { "/{hostName}" }, method = RequestMethod.GET)
	public ModelAndView formPageDesignew(@PathVariable("hostName") String hostName) throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		return new ModelAndView("admin/live/404", "data", data);
	}
}
