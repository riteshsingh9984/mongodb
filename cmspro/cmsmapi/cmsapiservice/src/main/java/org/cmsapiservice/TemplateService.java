package org.cmsapiservice;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.models.Template;

public interface TemplateService {

public Template saveTemplate(Template template);
	
	public Long count();
	
	public List<Template> getTemplates();
	
	public List<Template> getTemplates(Sort sort);
	
	public Template getTemplateById(Long templateId);
	
	public Template getTemplateByName(String templateName);
}
