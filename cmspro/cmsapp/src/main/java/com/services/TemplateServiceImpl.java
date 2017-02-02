package com.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Response;
import com.dao.DataAccessObject;
import com.google.gson.Gson;
import com.models.TemplateResponse;

@Service("templateService")
public class TemplateServiceImpl extends DataAccessObject implements TemplateService {

	@Value("${get.template.templateName.api}")
	private String getTemplateByNameApi;
	
	@Value("${get.templates.api}")
	private String getTemplatesApi;
	
	@Value("${save.template.api}")
	private String saveTemplateApi;
	
	@Value("${update.template.api}")
	private String updateTemplateApi;
	
	@Value("${ip}")
	private String ip;
	
	@Value("${port}")
	private String port;
	
	@Override
	public TemplateResponse getTemplateByTemplateName(String templateName) {
		Gson gson = new Gson();
		String url = ip+port;
		try{
			
			Map<String, String> header = new HashMap<String, String>();
			header.put("token", "myToken");
			
			Response apiResponse = gson.fromJson(sendGET(url+getTemplateByNameApi+templateName, header), Response.class);
			if(apiResponse.getStatus().equals("200")){
				TemplateResponse template = gson.fromJson(gson.toJson(apiResponse.getData()), TemplateResponse.class);
				return template;
			}
		}catch(Exception ee){}
		
		return null;
	}

	@Override
	public Set<TemplateResponse> getTemplates() {
		Gson gson = new Gson();
		
		String url = ip+port;
		try{
			
			Map<String, String> header = new HashMap<String, String>();
			
			header.put("token", "myToken");
			
			Response apiResponse = gson.fromJson(sendGET(url+getTemplatesApi, header), Response.class);
			if(apiResponse.getStatus().equals("200")){
				Set<TemplateResponse> templates = gson.fromJson(gson.toJson(apiResponse.getData()), Set.class);
				return templates;
			}
		}catch(Exception ee){}
		
		return null;
	}

	@Override
	public void save(Object template) throws IOException {
		String url = ip+port;
		String data = new Gson().toJson(template);
		
		Map<String, String> header = new HashMap<String, String>();
		
		header.put("token", "myToken");
		
		sendPOST(url+saveTemplateApi, data, header);
	}
	
	@Override
	public void update(Object template) throws IOException {
		String url = ip+port;
		String data = new Gson().toJson(template);
		
		Map<String, String> header = new HashMap<String, String>();
		
		header.put("token", "myToken");
		
		sendPOST(url+updateTemplateApi, data, header);
	}
}
