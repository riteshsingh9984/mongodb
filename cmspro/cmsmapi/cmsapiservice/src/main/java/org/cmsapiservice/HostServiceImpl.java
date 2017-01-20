package org.cmsapiservice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.modelUtility.EditableInfo;
import com.modelUtility.Page;
import com.models.Host;

import mongo.cmsrepository.HostRepository;


@Service("hostService")
@ComponentScan("mongo.cmsrepository")
public class HostServiceImpl implements HostService {

	@Autowired
	@Qualifier("hostRepository")
	private HostRepository hostRepository;
	
	@Override
	public Host saveHost(Host host) {
		
		if(host != null){
			if(host.getEditableInfo() == null){
				EditableInfo editableInfo = new EditableInfo();
				editableInfo.setCreatedAt();
				editableInfo.setCreatedBy("Unkown-User");
				host.setEditableInfo(editableInfo);
				Set<Page> pages = new HashSet<Page>();
				host.setPages(pages);
			}else
				host.getEditableInfo().setCreatedAt();
			
			return hostRepository.save(host);
		}else
			return null;
	}

	@Override
	public Long count() {
		
		return hostRepository.count();
	}

	@Override
	public List<Host> getHosts() {
		
		return hostRepository.findAll();
	}

	@Override
	public List<Host> getHosts(Sort sort) {
		
		return hostRepository.findAll(sort);
	}

	@Override
	public Host getHostById(Long hostId) {
		
		return hostRepository.findOne(hostId);
	}

	@Override
	public Host getHostByName(String hostName) {
		
		return hostRepository.getHostByName(hostName);
	}

}
