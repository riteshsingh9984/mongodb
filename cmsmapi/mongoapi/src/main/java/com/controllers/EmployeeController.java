package com.controllers;

import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.cmsapiservice.EmployeeService;
import org.joda.time.LocalDate;
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
import com.models.Employee;

@Controller("employeeController")
@ComponentScan("org.cmsapiservice")
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;
	
	@CrossOrigin   /* this annotation works with <spring.version>4.2.2.RELEASE</spring.version> spring version */
	@RequestMapping(value = "/save", method = RequestMethod.POST,   produces="application/json")
	public  @ResponseBody String getDefaultMovie(ModelMap model,
			@RequestBody Employee employee,
			@RequestHeader(value="User-Data", defaultValue="foo") String userAgent,
			HttpServletResponse response) throws UnknownHostException {
			
			System.out.println("API RESPOSE >>>>>>>>>>>>>>"+new Gson().toJson(employee));
			System.out.println(userAgent);
			
			//employee.setSalary(new BigDecimal(10000));
			//employee.setSsn("ssn00000001");
			
			employeeService.saveEmployee(employee);
			System.out.println("Controller Call");
			
			//jsonString.setStatus("OK");
			model.addAttribute("movie", "this is default movie");
		return new Gson().toJson(employee);
	}
	
	@CrossOrigin   /* this annotation works with <spring.version>4.2.2.RELEASE</spring.version> spring version */
	@RequestMapping(value = "/get-employee", method = RequestMethod.POST,   produces="application/json")
	public  @ResponseBody String getEmployee(ModelMap model,
			@RequestBody Employee employee,
			@RequestHeader(value="User-Data", defaultValue="foo") String userAgent,
			HttpServletResponse response) throws UnknownHostException {
			
			//employee = employeeService.findBySsn(employee.getSsn());
			
			Response responseData = new Response();
			responseData.setData(new Gson().toJson(employee));
			responseData.setStatus("200");
			
			return new Gson().toJson(responseData);
	}
	
	@CrossOrigin   /* this annotation works with <spring.version>4.2.2.RELEASE</spring.version> spring version */
	@RequestMapping(value = "/datademo1", method = RequestMethod.POST,   produces="application/json")
	public  @ResponseBody String save(ModelMap model,
			@RequestBody Employee employee,
			@RequestHeader(value="User-Data", defaultValue="foo") String userAgent,
			HttpServletResponse response) throws UnknownHostException {
			
			System.out.println(">>>>>>>>>>>>>>"+new Gson().toJson(employee));
			System.out.println(userAgent);
			
			employeeService.saveEmployee(employee);
			System.out.println("Controller Call");
			
			return new Gson().toJson(employee);
	}
}
