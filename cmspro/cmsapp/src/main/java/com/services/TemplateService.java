package com.services;

import java.io.IOException;
import java.util.Set;

import com.models.TemplateResponse;

public interface TemplateService {

public TemplateResponse getTemplateByTemplateName(String templateName);
	
	public Set<TemplateResponse> getTemplates();
	
	public void save(Object template) throws IOException;
}
