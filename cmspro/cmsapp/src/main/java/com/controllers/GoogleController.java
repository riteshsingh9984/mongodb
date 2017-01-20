package com.controllers;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.models.UserProfile;

@Controller
@RequestMapping(value = "admin/google")
public class GoogleController {

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView form() throws IOException {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("content", "Woowwwww");
		return new ModelAndView("google/login", "data", data);
	}
	
	@CrossOrigin   /* this annotation works with <spring.version>4.2.2.RELEASE</spring.version> spring version */
	@RequestMapping(value = "/social-login", method = RequestMethod.POST,   produces="application/json")
	public  @ResponseBody String getDefaultMovie(ModelMap model,
			@RequestBody UserProfile userProfile,
			@RequestHeader(value="User-Data", defaultValue="foo") String userAgent,
			HttpServletResponse response) throws UnknownHostException {
			
			System.out.println("API RESPOSE >>>>>>>>>>>>>>"+new Gson().toJson(userProfile));
			System.out.println(userAgent);
			
			//jsonString.setStatus("OK");
			model.addAttribute("movie", "this is default movie");
		return new Gson().toJson(userProfile);
	}
	
}
