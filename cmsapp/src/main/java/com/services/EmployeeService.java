package com.services;

import java.io.IOException;

public interface EmployeeService {

	public void save(Object employee) throws IOException;
	
	public Object fetchEmployeeBySsn(Object employee) throws IOException;
}
