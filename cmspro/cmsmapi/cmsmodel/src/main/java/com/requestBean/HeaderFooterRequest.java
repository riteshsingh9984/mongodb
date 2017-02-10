package com.requestBean;

import com.modelUtility.EditableInfo;

public class HeaderFooterRequest {

	private long id;
	private String hostName;
	private String headerFooterName;
	private String templateName;
	private String content;
	private String type; /* type will be either header or footer. */
	private EditableInfo editableInfo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getHeaderFooterName() {
		return headerFooterName;
	}
	public void setHeaderFooterName(String headerFooterName) {
		this.headerFooterName = headerFooterName;
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
	public EditableInfo getEditableInfo() {
		return editableInfo;
	}
	public void setEditableInfo(EditableInfo editableInfo) {
		this.editableInfo = editableInfo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
