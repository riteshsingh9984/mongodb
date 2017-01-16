package com.services;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Response;
import com.dao.DataAccessObject;
import com.google.gson.Gson;
import com.models.Employee;
import com.models.Host;

@Service("hostService")
public class HostServiceImpl extends DataAccessObject implements HostService {

	@Value("${get.host.hostName.api}")
	private String getHostByNameApi;
	
	@Value("${get.hosts.api}")
	private String getHostsApi;
	
	@Value("${save.host.api}")
	private String saveHostApi;
	
	@Value("${ip}")
	private String ip;
	
	@Value("${port}")
	private String port;
	
	@Override
	public Host getHostByHostName(String hostName) {
		Gson gson = new Gson();
		String url = ip+port;
		try{
			
			Response apiResponse = gson.fromJson(sendGET(url+getHostByNameApi+hostName), Response.class);
			System.out.println("apiResponse = "+new Gson().toJson(apiResponse));
			if(apiResponse.getStatus().equals("200")){
				Host host = gson.fromJson(gson.toJson(apiResponse.getData()), Host.class);
				return host;
			}
		}catch(Exception ee){}
		
		return null;
	}

	@Override
	public Set<Host> getHosts() {
		Gson gson = new Gson();
		
		String url = ip+port;
		try{
			
			Response apiResponse = gson.fromJson(sendGET(url+getHostsApi), Response.class);
			if(apiResponse.getStatus().equals("200")){
				Set<Host> hosts = gson.fromJson(gson.toJson(apiResponse.getData()), Set.class);
				return hosts;
			}
		}catch(Exception ee){}
		
		return null;
	}

	@Override
	public void save(Object host) throws IOException {
		String url = ip+port;
		String data = new Gson().toJson(host);
		sendPOST(url+saveHostApi, data);
	}
}
