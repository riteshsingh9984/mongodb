package com.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Response;
import com.dao.DataAccessObject;
import com.google.gson.Gson;
import com.models.Employee;

@Service("employeeService")
public class EmployeeServiceImpl extends DataAccessObject implements EmployeeService {

	@Value("${employee.save.api}")
	private String saveApi;
	
	@Value("${employee.get.api}")
	private String getApi;
	
	@Value("${ip}")
	private String ip;
	
	@Value("${port}")
	private String port;
	
	public void save(Object employee) throws IOException{
 
		String url = ip+port;
		String data = new Gson().toJson(employee);
		sendPOST(url+saveApi, data);
	}
	
	public Employee fetchEmployeeBySsn(Object employee) throws IOException{
		 
		String url = ip+port;
		String data = new Gson().toJson(employee);
		try{
			
			Employee fetchedEmployee = new Gson().fromJson(new Gson().toJson(sendPOST(url+getApi, data)), Employee.class);
			 
			return fetchedEmployee;
		}catch(Exception ee){
			
		}
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		
		String url = ip+port;
		try{
			
			Response apiResponse = new Gson().fromJson(sendGET(url+getApi), Response.class);
			
			System.out.println("apiResponse = "+new Gson().toJson(apiResponse));
			
			if(apiResponse.getStatus().equals("200")){
				List<Employee> employees = (List<Employee>) apiResponse.getData();
				return employees;
			}
		}catch(Exception ee){
			
		}
		
		return null;
	}
}
