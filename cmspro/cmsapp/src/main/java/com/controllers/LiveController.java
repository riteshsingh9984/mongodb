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

import com.models.HostResponse;
import com.models.PageResponse;
import com.services.HostService;
import com.services.PageService;

@Controller("liveController")
@ComponentScan("org.cmsapiservice")
@RequestMapping("live")
public class LiveController {

	@Autowired
	@Qualifier("pageService")
	private PageService pageService;
	
	@Autowired
	@Qualifier("hostService")
	private HostService hostService;
	
	@RequestMapping(value = { "/{hostName}/{pageName}" }, method = RequestMethod.GET)
	public ModelAndView formPageDesignPreview(@PathVariable("hostName") String hostName, @PathVariable("pageName") String pageName) throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		PageResponse pageResponse = null;
		try{
			HostResponse hostResponse = hostService.getHostByHostName(hostName);
			if(hostResponse!=null){
				if(hostResponse.getHostLaunchConfig().isActive()){
				pageResponse = pageService.getPageByPageName(pageName,hostName);
				if(pageResponse != null){
					data.put("page", pageResponse);
					data.put("header", hostResponse.getHeader());
					data.put("footer", hostResponse.getFooter());
					return new ModelAndView("admin/live/live", "data", data);
				}
				data.put("pageType", pageName);
				data.put("hostName", hostName);
				data.put("hostType", null);
				}else{
					if(hostName!=null){
						data.put("hostType", hostName);
					}
					return new ModelAndView("admin/live/not-active", "data", data);
				}
			}else{
				data.put("pageType", null);
				data.put("hostName", null);
				data.put("hostType", hostName);
			}
		}catch(Exception ee){}
		
		return new ModelAndView("admin/live/404", "data", data);
	}
	
	@RequestMapping(value = { "/{hostName}" }, method = RequestMethod.GET)
	public ModelAndView formPageDesignew(@PathVariable("hostName") String hostName) throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		PageResponse pageResponse = null;
		try{
			HostResponse hostResponse = hostService.getHostByHostName(hostName);
			if(hostResponse!=null){
				if(hostResponse.getHostLaunchConfig().isActive()){
					pageResponse = pageService.getPageByPageName(hostResponse.getWelcomePage(),hostName);
					if(pageResponse != null){
						data.put("page", pageResponse);
						data.put("header", hostResponse.getHeader());
						data.put("footer", hostResponse.getFooter());
						return new ModelAndView("admin/live/live", "data", data);
					}
					data.put("pageType", hostResponse.getWelcomePage());
					data.put("hostName", hostName);
					data.put("hostType", null);
				}else{
					if(hostName!=null){
						data.put("hostType", hostName);
					}
					return new ModelAndView("admin/live/not-active", "data", data);
				}
				
			}else{
				data.put("pageType", null);
				data.put("hostName", null);
				data.put("hostType", hostName);
			}
		}catch(Exception ee){}
		
		if(hostService.getHostByHostName(hostName)==null){
			data.put("pageType", null);
			data.put("hostName", null);
			data.put("hostType", hostName);
		}
		
		return new ModelAndView("admin/live/404", "data", data);
	}
}
