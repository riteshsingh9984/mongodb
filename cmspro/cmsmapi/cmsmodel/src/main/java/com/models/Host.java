package com.models;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.modelUtility.EditableInfo;
import com.modelUtility.Page;

@Document(collection = "host")
public class Host implements Serializable {

	private static final long serialVersionUID = 7746218756589213487L;
	
	@Id
	private Long id;
	
	private String hostName;
	private String aliasName;
	private Set<Page> pages;
	private EditableInfo editableInfo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public Set<Page> getPages() {
		return pages;
	}
	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}
	public EditableInfo getEditableInfo() {
		return editableInfo;
	}
	public void setEditableInfo(EditableInfo editableInfo) {
		this.editableInfo = editableInfo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
}
