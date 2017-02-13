package com.services;

import java.io.IOException;
import java.util.Set;

import com.models.HeaderFooterRequest;
import com.models.HostRequest;
import com.models.HostResponse;

public interface HostService {

	public HostResponse getHostByHostName(String hostName);
	
	public Set<HostResponse> getHosts();
	
	public void save(Object host) throws IOException;
	
	public void saveHeaderFooter(HeaderFooterRequest headerFooterRequest) throws IOException;

	public void saveLaunch(Object host, String type) throws IOException;
}
