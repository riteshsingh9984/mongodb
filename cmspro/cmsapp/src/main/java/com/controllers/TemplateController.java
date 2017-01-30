package com.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import com.models.HostRequest;
import com.models.TemplateRequest;
import com.services.TemplateService;

@Controller
@ComponentScan("com.services, com.repo")
@RequestMapping(value = "admin/templates")
public class TemplateController {

	@Autowired
	@Qualifier("templateService")
	private TemplateService templateService;
	
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
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("hostSave") TemplateRequest templateRequest, BindingResult result,
			HttpServletRequest request) throws Exception {
		System.out.println("Template Details : " + new Gson().toJson(templateRequest));
		try {
			templateService.save(templateRequest);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("admin/host/create", "data", data);
	}
	
	@RequestMapping(value = "/gettemplate/{templateName}", method = RequestMethod.GET)
    public @ResponseBody String getTemplateName(@PathVariable("templateName") String templateName) {
 
		if((templateService.getTemplateByTemplateName(templateName)) != null)
			return "FOUND";
		
		return "NOT-FOUND";
    }
}