package com.controllers;

import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.cmsapiservice.HostService;
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
import com.modelUtility.HeaderFooter;
import com.models.Employee;
import com.models.Host;
import com.requestBean.HeaderFooterRequest;

@Controller("hostController")
@ComponentScan("org.cmsapiservice")
@RequestMapping("host")
public class HostController {

	@Autowired
	@Qualifier("hostService")
	private HostService hostService;

	@CrossOrigin
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String saveHost(ModelMap model, @RequestBody Host host,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		long id = hostService.count();
		host.setId(id);
		hostService.saveHost(host);
		
		Response responseData = new Response();
		responseData.setData(host);
		responseData.setStatus("200");
		
		return new Gson().toJson(responseData);
	}

	@CrossOrigin
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String UpdateHost(ModelMap model, @RequestBody Host host,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		hostService.saveHost(host);
		
		Response responseData = new Response();
		responseData.setData(host);
		responseData.setStatus("200");
		
		return new Gson().toJson(responseData);
	}

	@CrossOrigin
	@RequestMapping(value = "/get-hosts", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getHosts(ModelMap model,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		List<Host> hosts = hostService.getHosts();

		Response responseData = new Response();
		responseData.setData(hosts);
		responseData.setStatus("200");

		return new Gson().toJson(responseData);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/get-host/{hostId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getHostById(ModelMap model,@PathVariable("hostId") long hostId,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		Host host = hostService.getHostById(hostId);
		Response responseData = new Response();
		responseData.setData(host);
		responseData.setStatus("200");

		return new Gson().toJson(responseData);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/get-host/hostName/{hostName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getHostById(ModelMap model,@PathVariable("hostName") String hostName,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		Host host = hostService.getHostByName(hostName);
		System.out.println(new Gson().toJson(host));
		Response responseData = new Response();
		responseData.setData(host);
		responseData.setStatus("200");

		return new Gson().toJson(responseData);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/save/header-footer", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String saveHostHeaderFooter(ModelMap model, @RequestBody HeaderFooterRequest headerFooterRequest,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {
		Host host = hostService.getHostByName(headerFooterRequest.getHostName());
		if(host != null){
			HeaderFooter headerFooter= new HeaderFooter();
			headerFooter.setContent(headerFooterRequest.getContent());
			headerFooter.setHeaderFooterName(headerFooterRequest.getHeaderFooterName());
			headerFooter.setTemplateName(headerFooterRequest.getTemplateName());
			headerFooter.setHeight("200");
			headerFooter.setEditableInfo(headerFooterRequest.getEditableInfo());
			if(headerFooterRequest.getType().equals("header")){
				host.setHeader(headerFooter);
				host.setHeader(true);
			}else{
				host.setFooter(headerFooter);
				host.setFooter(true);
			}
			hostService.saveHost(host);
		}
		Response responseData = new Response();
		responseData.setData(host);
		responseData.setStatus("200");
		
		return new Gson().toJson(responseData);
	}
}
