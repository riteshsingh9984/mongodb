package com.controllers;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletResponse;

import org.cmsapiservice.UserService;
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

import com.google.gson.Gson;
import com.models.Employee;
import com.models.User;

@Controller("userController")
@ComponentScan("org.cmsapiservice")
@RequestMapping("user")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@CrossOrigin   /* this annotation works with <spring.version>4.2.2.RELEASE</spring.version> spring version */
	@RequestMapping(value = "/save", method = RequestMethod.POST,   produces="application/json")
	public  @ResponseBody String getDefaultMovie(ModelMap model,
			@RequestBody User user,
			@RequestHeader(value="User-Data", defaultValue="foo") String userAgent,
			HttpServletResponse response) throws UnknownHostException {
			
			System.out.println("API RESPOSE >>>>>>>>>>>>>>"+new Gson().toJson(user));
			System.out.println(userAgent);
			
			userService.saveUser(user);
			System.out.println("Controller Call");
			
			//jsonString.setStatus("OK");
			model.addAttribute("movie", "this is default movie");
		return new Gson().toJson(user);
	}
}
