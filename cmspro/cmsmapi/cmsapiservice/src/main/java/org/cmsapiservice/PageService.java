package org.cmsapiservice;

import java.util.Set;

import com.modelUtility.Page;
import com.requestBean.PageRequest;

public interface PageService {

	void savePage(PageRequest pageRequest, String userName);
}
