package com.controllers;

import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.cmsapiservice.EmployeeService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
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

@Controller("employeeController")
@ComponentScan("org.cmsapiservice")
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;

	@CrossOrigin /*
					 * this annotation works with
					 * <spring.version>4.2.2.RELEASE</spring.version> spring
					 * version
					 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String saveEmployee(ModelMap model, @RequestBody Employee employee,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		employeeService.saveEmployee(employee);
		return new Gson().toJson(employee);
	}

	@CrossOrigin /*
					 * this annotation works with
					 * <spring.version>4.2.2.RELEASE</spring.version> spring
					 * version
					 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String UpdateEmployee(ModelMap model, @RequestBody Employee employee,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		employeeService.saveEmployee(employee);
		model.addAttribute("movie", "this is default movie");
		return new Gson().toJson(employee);
	}

	@CrossOrigin /*
					 * this annotation works with
					 * <spring.version>4.2.2.RELEASE</spring.version> spring
					 * version
					 */
	@RequestMapping(value = "/get-employee", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getEmployee(ModelMap model,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		/*
		 * System.out.println(new
		 * Gson().toJson(employeeService.getEmployees()));
		 * System.out.println(new Gson().toJson(employeeService.getEmployees(new
		 * Sort(Sort.Direction.ASC, "name")))); System.out.println(new
		 * Gson().toJson(employeeService.getEmployees(new
		 * Sort(Sort.Direction.DESC, "name")))); System.out.println(new
		 * Gson().toJson(employeeService.getEmployeeById((long) 101)));
		 */
		List<Employee> employees = employeeService.getEmployees();
		
		Response responseData = new Response();
		responseData.setData(employees);
		responseData.setStatus("200");

		return new Gson().toJson(responseData);
	}

	@CrossOrigin /*
					 * this annotation works with
					 * <spring.version>4.2.2.RELEASE</spring.version> spring
					 * version
					 */
	@RequestMapping(value = "/datademo1", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String save(ModelMap model, @RequestBody Employee employee,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		System.out.println(">>>>>>>>>>>>>>" + new Gson().toJson(employee));
		System.out.println(userAgent);

		employeeService.saveEmployee(employee);
		System.out.println("Controller Call");

		return new Gson().toJson(employee);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/get-employee/{employeeId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getEmployeeById(ModelMap model,@PathVariable("employeeId") long employeeId,
			@RequestHeader(value = "token", defaultValue = "foo") String userAgent, HttpServletResponse response)
			throws UnknownHostException {

		Employee employee = employeeService.getEmployeeById(employeeId);
		Response responseData = new Response();
		responseData.setData(employee);
		responseData.setStatus("200");

		return new Gson().toJson(responseData);
	}
}
