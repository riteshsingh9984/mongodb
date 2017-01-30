package com.controllers;

import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.cmsapiservice.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Response;
import com.google.gson.Gson;
import com.models.Template;

@Controller("templateController")
@ComponentScan("org.cmsapiservice")
@RequestMapping("template")
public class TemplateController {

	@Autowired
	@Qualifier("templateService")
	private TemplateService templateService;
	
	@CrossOrigin
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String saveHost(ModelMap model, @RequestBody Template template,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		long id = templateService.count();
		template.setId(id);
		templateService.saveTemplate(template);
		
		Response responseData = new Response();
		responseData.setData(template);
		responseData.setStatus("200");
		
		return new Gson().toJson(responseData);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String UpdateTemplate(ModelMap model, @RequestBody Template template,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		templateService.saveTemplate(template);
		
		Response responseData = new Response();
		responseData.setData(template);
		responseData.setStatus("200");
		
		return new Gson().toJson(responseData);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/get-templates", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getTemplates(ModelMap model,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		List<Template> templates = templateService.getTemplates();

		Response responseData = new Response();
		responseData.setData(templates);
		responseData.setStatus("200");

		return new Gson().toJson(responseData);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/get-template/{templateId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getHostById(ModelMap model,@PathVariable("templateId") long templateId,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		Template template = templateService.getTemplateById(templateId);
		Response responseData = new Response();
		responseData.setData(template);
		responseData.setStatus("200");

		return new Gson().toJson(responseData);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/get-template/templateName/{templateName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getHostById(ModelMap model,@PathVariable("templateName") String templateName,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		Template template = templateService.getTemplateByName(templateName);
		System.out.println(new Gson().toJson(template));
		Response responseData = new Response();
		responseData.setData(template);
		responseData.setStatus("200");

		return new Gson().toJson(responseData);
	}
}
