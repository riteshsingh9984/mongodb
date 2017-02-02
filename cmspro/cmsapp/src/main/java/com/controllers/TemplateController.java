package com.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.models.HostRequest;
import com.models.HostResponse;
import com.models.TemplateRequest;
import com.models.TemplateResponse;
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
		return new ModelAndView("admin/templateBank/list", "data", data);
	}
	
	@RequestMapping(value = { "/edit/{templateName}" }, method = RequestMethod.GET)
	public ModelAndView formEditTemplate(@PathVariable("templateName") String templateName) throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		TemplateResponse templateResponse = null;
		try{
			templateResponse = templateService.getTemplateByTemplateName(templateName);
			
			System.out.println("con= "+templateResponse.getContent());
			
		}catch(Exception ee){}
		
		data.put("template", templateResponse);
		return new ModelAndView("admin/templateBank/edit", "data", data);
	}
	
	@RequestMapping(value = { "/update" }, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("hostSave") TemplateRequest templateRequest, BindingResult result,
			HttpServletRequest request) throws Exception {
		System.out.println("Template Details : " + new Gson().toJson(templateRequest));
		try {
			templateService.update(templateRequest);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Map<String, Object> data = new HashMap<String, Object>();
		return new ModelAndView("admin/templateBank/list", "data", data);
	}
	
	@RequestMapping(value = "/gettemplate/{templateName}", method = RequestMethod.GET)
    public @ResponseBody String getTemplateName(@PathVariable("templateName") String templateName) {
 
		if((templateService.getTemplateByTemplateName(templateName)) != null)
			return "FOUND";
		
		return "NOT-FOUND";
    }
	
	@RequestMapping(value = { "/view/{templateName}" }, method = RequestMethod.GET)
	public ModelAndView formTemplate(@PathVariable("templateName")String templateName) throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		TemplateResponse templateResponse = null;
		try{
			templateResponse = templateService.getTemplateByTemplateName(templateName);
			
			System.out.println("con= "+templateResponse.getContent());
			
		}catch(Exception ee){}
		
		data.put("template", templateResponse);
		return new ModelAndView("admin/templateBank/view", "data", data);
	}
	
	@RequestMapping(value = { "/get-templates" }, method = RequestMethod.GET)
	public ModelAndView getEmployees() throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		return new ModelAndView("admin/templateBank/list", "data", data);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/gettemplates", method = RequestMethod.GET)
    public @ResponseBody Object getTemplateList() {
		Gson gson = new Gson();
		Set<TemplateResponse> templates = templateService.getTemplates();
		TemplateResponse template = null;
		Set<TemplateResponse> templateList = new HashSet<TemplateResponse>();
		
		for(Object object : templates){
			template = gson.fromJson(gson.toJson(object), TemplateResponse.class);
			templateList.add(template);
		}
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("data", templateList);
		
		return new Gson().toJson(data);
    }
}