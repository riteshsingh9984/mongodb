package com.services;

import java.io.IOException;
import java.util.Set;

import com.models.Host;

public interface HostService {

	public Host getHostByHostName(String hostName);
	
	public Set<Host> getHosts();
	
	public void save(Object host) throws IOException;
}
