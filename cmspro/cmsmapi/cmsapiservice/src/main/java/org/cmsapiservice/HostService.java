package org.cmsapiservice;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.models.Host;

public interface HostService {

public Host saveHost(Host host);
	
	public Long count();
	
	public List<Host> getHosts();
	
	public List<Host> getHosts(Sort sort);
	
	public Host getHostById(Long hostId);
	
	public Host getHostByName(String hostName);
}
