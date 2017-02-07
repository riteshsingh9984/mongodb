package org.cmsapiservice;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.modelUtility.Page;
import com.models.Host;
import com.requestBean.PageRequest;

@Service("pageService")
public class PageServiceImpl implements PageService {

	@Autowired
	@Qualifier("hostService")
	private HostService hostService;

	@Override
	public void savePage(PageRequest pageRequest, String token) {

		if ((pageRequest != null) && (pageRequest.getHostName() != null)) {
			Page page = new Page(pageRequest);
			page.getEditableInfo().setCreatedBy(token);
			Host host = hostService.getHostByName(pageRequest.getHostName());
			Set<Page> pages = null;
			boolean flag = true;
			if (host != null) {
				if (host.getPages() != null) {
					pages = host.getPages();
					/* Checking the page existence in host-page-list */
					for (Page pageCheck : pages) {
						if (pageCheck.getPageName().equals(pageRequest.getPageName())) {
							flag = false;
							break;
						}
					}
					/* Done Checking the page existence in host-page-list */
					if (flag)
						pages.add(page);
				} else {
					pages = new HashSet<Page>();
					pages.add(page);
				}
				host.setPages(pages);
				hostService.saveHost(host);
			}
		}
	}

	@Override
	public void updatePage(PageRequest pageRequest, String userName) {

		if ((pageRequest != null) && (pageRequest.getHostName() != null)) {
			Host host = hostService.getHostByName(pageRequest.getHostName());
			Set<Page> pages = null;
			Set<Page> updatePages = new HashSet<Page>();
			if (host != null) {
				if (host.getPages() != null) {
					pages = host.getPages();
					/* Checking the page existence in host-page-list */
					if (pages != null)
						for (Page pageCheck : pages) {
							if (pageCheck.getPageName().equals(pageRequest.getPageName())) {
								pageCheck.setContent(pageRequest.getContent());
							}
							updatePages.add(pageCheck);
						}
					host.setPages(updatePages);
					hostService.saveHost(host);
				}
			}
		}
	}

}
