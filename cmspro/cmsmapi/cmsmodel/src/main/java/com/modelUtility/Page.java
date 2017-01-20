package com.modelUtility;

import com.requestBean.PageRequest;

public class Page {

	private String pageName;
	private EditableInfo editableInfo;
	private String templateName;
	private String content;
	
	public Page(PageRequest pageRequest){
		if(pageRequest != null){
			if(pageRequest.getPageName()!=null)
				this.pageName = pageRequest.getPageName();
			if(pageRequest.getTemplateName()!=null)
				this.templateName = pageRequest.getTemplateName();
			
			EditableInfo editableInfo = new EditableInfo();
			editableInfo.setCreatedAt();
			this.editableInfo = editableInfo;
		}
	}
	
	public Page() {}
	
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public EditableInfo getEditableInfo() {
		return editableInfo;
	}
	public void setEditableInfo(EditableInfo editableInfo) {
		this.editableInfo = editableInfo;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
