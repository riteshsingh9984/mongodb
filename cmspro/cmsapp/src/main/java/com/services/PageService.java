package com.services;

import java.io.IOException;
import java.util.Set;

import com.models.PageRequest;
import com.models.PageResponse;

public interface PageService {

	public PageResponse getPageByPageName(String pageName);

	public Set<PageResponse> getPages(String hostName) throws IOException;

	public void save(Object pageRequest) throws IOException;
}
