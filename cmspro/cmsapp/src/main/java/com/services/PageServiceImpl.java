package com.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Response;
import com.dao.DataAccessObject;
import com.google.gson.Gson;
import com.models.HostResponse;
import com.models.PageRequest;
import com.models.PageResponse;

@Service("pageService")
public class PageServiceImpl extends DataAccessObject implements PageService {

	@Value("${save.page.api}")
	private String savePageApi;
	
	@Value("${update.page.api}")
	private String updatePageApi;
	
	@Value("${ip}")
	private String ip;
	
	@Value("${port}")
	private String port;
	
	@Autowired
	@Qualifier("hostService")
	private HostService hostService;
	
	@Override
	public PageResponse getPageByPageName(String pageName, String hostName) {
		PageResponse pageResponse = null;
		HostResponse hostResponse = hostService.getHostByHostName(hostName);
		if((hostResponse!=null) && (hostResponse.getPages() != null )){
			Set<PageResponse> pages = hostResponse.getPages();
			if(pages != null)
				pageResponse = pages.stream()
									.filter(page-> pageName.equals(page.getPageName()))
									.findAny()
									.orElse(null);
			if(pageResponse != null ){
				pageResponse.setHostName(hostName);
				return pageResponse;
			}
		}
		
		return null;
	}

	@Override
	public Set<PageResponse> getPages(String hostName) throws IOException {
		
		HostResponse hostResponse = hostService.getHostByHostName(hostName);
		if((hostResponse!=null) && (hostResponse.getPages() != null )){
			Set<PageResponse> pages = hostResponse.getPages();
			if(pages != null)
				pages.stream().forEach(page -> page.setHostName(hostName));
			return pages;
		}
		
		return null;
	}

	@Override
	public void save(Object pageRequest) throws IOException {
		
		String url = ip+port;
		String data = new Gson().toJson(pageRequest);
		Map<String, String> header = new HashMap<String, String>();
		header.put("token", "myToken");
		
		sendPOST(url+savePageApi, data, header);
	}
	
	@Override
	public void update(Object pageRequest) throws IOException {
		
		String url = ip+port;
		String data = new Gson().toJson(pageRequest);
		Map<String, String> header = new HashMap<String, String>();
		header.put("token", "myToken");
		
		sendPOST(url+updatePageApi, data, header);
	}

}
