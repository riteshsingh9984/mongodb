package com.controllers;

import java.net.UnknownHostException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.cmsapiservice.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Response;
import com.google.gson.Gson;
import com.modelUtility.Page;
import com.models.Host;
import com.requestBean.PageRequest;

@Controller("pageController")
@ComponentScan("org.cmsapiservice")
@RequestMapping("page")
public class PageController {

	@Autowired
	@Qualifier("pageService")
	private PageService pageService;
	
	@CrossOrigin
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String savePage(ModelMap model, @RequestBody PageRequest pageRequest,
			@RequestHeader(value = "token", defaultValue = "foo") String token, HttpServletResponse response)
			throws UnknownHostException {

		pageService.savePage(pageRequest, token);
		Response responseData = new Response();
		responseData.setData(pageRequest);
		responseData.setStatus("200");
		
		return new Gson().toJson(responseData);
	}
}
