package com.modelUtility;

public class HeaderFooter {

	private String headerFooterName;
	private String templateName;
	private String content;
	private String height;
	private EditableInfo editableInfo;
	
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
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public EditableInfo getEditableInfo() {
		return editableInfo;
	}
	public void setEditableInfo(EditableInfo editableInfo) {
		this.editableInfo = editableInfo;
	}
	public String getHeaderFooterName() {
		return headerFooterName;
	}
	public void setHeaderFooterName(String headerFooterName) {
		this.headerFooterName = headerFooterName;
	}
}
