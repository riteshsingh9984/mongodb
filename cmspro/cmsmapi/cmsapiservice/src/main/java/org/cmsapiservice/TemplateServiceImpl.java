package org.cmsapiservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.modelUtility.EditableInfo;
import com.models.Template;

import mongo.cmsrepository.TemplateRepository;

@Service("templateService")
@ComponentScan("mongo.cmsrepository")
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	@Qualifier("templateRepository")
	private TemplateRepository templateRepository;
	
	@Override
	public Template saveTemplate(Template template) {
		
		if(template != null){
			if(template.getEditableInfo() == null){
				EditableInfo editableInfo = new EditableInfo();
				editableInfo.setCreatedAt();
				editableInfo.setCreatedBy("Unkown-User");
				template.setEditableInfo(editableInfo);
				
			}else
				template.getEditableInfo().setCreatedAt();
			
			return templateRepository.save(template);
		}else
			return null;
	}

	@Override
	public Long count() {
		
		return templateRepository.count();
	}

	@Override
	public List<Template> getTemplates() {
		
		return templateRepository.findAll();
	}

	@Override
	public List<Template> getTemplates(Sort sort) {
		
		return templateRepository.findAll(sort);
	}

	@Override
	public Template getTemplateById(Long templateId) {
		
		return templateRepository.findOne(templateId);
	}

	@Override
	public Template getTemplateByName(String templateName) {
		
		return templateRepository.getTemplateByName(templateName);
	}
}
