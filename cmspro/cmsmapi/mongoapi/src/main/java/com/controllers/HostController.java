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
import com.models.Employee;
import com.models.Host;

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
			@RequestHeader(value = "User-Data", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		long id = hostService.count();
		host.setId(id);
		hostService.saveHost(host);
		
		return new Gson().toJson(host);
	}

	@CrossOrigin
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String UpdateHost(ModelMap model, @RequestBody Host host,
			@RequestHeader(value = "User-Data", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		hostService.saveHost(host);
		return new Gson().toJson(host);
	}

	@CrossOrigin
	@RequestMapping(value = "/get-hosts", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getHosts(ModelMap model,
			@RequestHeader(value = "User-Data", defaultValue = "foo") String userAgent, HttpServletResponse response)
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
			@RequestHeader(value = "User-Data", defaultValue = "foo") String userAgent, HttpServletResponse response)
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
			@RequestHeader(value = "User-Data", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		Host host = hostService.getHostByName(hostName);
		System.out.println(new Gson().toJson(host));
		Response responseData = new Response();
		responseData.setData(host);
		responseData.setStatus("200");

		return new Gson().toJson(responseData);
	}
}
