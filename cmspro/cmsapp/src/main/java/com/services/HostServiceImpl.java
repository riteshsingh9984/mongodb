package com.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Response;
import com.dao.DataAccessObject;
import com.google.gson.Gson;
import com.models.HeaderFooterRequest;
import com.models.HostRequest;
import com.models.HostResponse;

@Service("hostService")
public class HostServiceImpl extends DataAccessObject implements HostService {

	@Value("${get.host.hostName.api}")
	private String getHostByNameApi;
	
	@Value("${get.hosts.api}")
	private String getHostsApi;
	
	@Value("${save.host.api}")
	private String saveHostApi;
	
	@Value("${save.host.header.footer.api}")
	private String saveHostHeaderFooterApi;
	
	@Value("${ip}")
	private String ip;
	
	@Value("${port}")
	private String port;
	
	@Override
	public HostResponse getHostByHostName(String hostName) {
		Gson gson = new Gson();
		String url = ip+port;
		try{
			
			Map<String, String> header = new HashMap<String, String>();
			header.put("token", "myToken");
			
			Response apiResponse = gson.fromJson(sendGET(url+getHostByNameApi+hostName, header), Response.class);
			if(apiResponse.getStatus().equals("200")){
				HostResponse host = gson.fromJson(gson.toJson(apiResponse.getData()), HostResponse.class);
				return host;
			}
		}catch(Exception ee){}
		
		return null;
	}

	@Override
	public Set<HostResponse> getHosts() {
		Gson gson = new Gson();
		
		String url = ip+port;
		try{
			
			Map<String, String> header = new HashMap<String, String>();
			
			header.put("token", "myToken");
			
			Response apiResponse = gson.fromJson(sendGET(url+getHostsApi, header), Response.class);
			if(apiResponse.getStatus().equals("200")){
				Set<HostResponse> hosts = gson.fromJson(gson.toJson(apiResponse.getData()), Set.class);
				return hosts;
			}
		}catch(Exception ee){}
		
		return null;
	}

	@Override
	public void save(Object host) throws IOException {
		String url = ip+port;
		String data = new Gson().toJson(host);
		
		Map<String, String> header = new HashMap<String, String>();
		
		header.put("token", "myToken");
		
		sendPOST(url+saveHostApi, data, header);
	}

	@Override
	public void saveHeaderFooter(HeaderFooterRequest headerFooterRequest) throws IOException {
		String url = ip+port;
		String data = new Gson().toJson(headerFooterRequest);
		Map<String, String> header = new HashMap<String, String>();
		header.put("token", "myToken");
		sendPOST(url+saveHostHeaderFooterApi, data, header);
	}
}
