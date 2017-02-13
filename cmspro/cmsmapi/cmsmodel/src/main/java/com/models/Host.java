package com.models;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.modelUtility.EditableInfo;
import com.modelUtility.HeaderFooter;
import com.modelUtility.HostLaunchConfig;
import com.modelUtility.Page;

@Document(collection = "host")
public class Host implements Serializable {

	private static final long serialVersionUID = 7746218756589213487L;
	
	@Id
	private Long id;
	
	private String hostName;
	private String aliasName;
	private String welcomePage;
	private HostLaunchConfig hostLaunchConfig;
	private HeaderFooter header;
	private HeaderFooter footer;
	private boolean isHeader;
	private boolean isFooter;
	
	public HeaderFooter getHeader() {
		return header;
	}
	public void setHeader(HeaderFooter header) {
		this.header = header;
	}
	public HeaderFooter getFooter() {
		return footer;
	}
	public void setFooter(HeaderFooter footer) {
		this.footer = footer;
	}
	public boolean isHeader() {
		return isHeader;
	}
	public void setHeader(boolean isHeader) {
		this.isHeader = isHeader;
	}
	public boolean isFooter() {
		return isFooter;
	}
	public void setFooter(boolean isFooter) {
		this.isFooter = isFooter;
	}
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
	public String getWelcomePage() {
		return welcomePage;
	}
	public void setWelcomePage(String welcomePage) {
		this.welcomePage = welcomePage;
	}
	public HostLaunchConfig getHostLaunchConfig() {
		return hostLaunchConfig;
	}
	public void setHostLaunchConfig(HostLaunchConfig hostLaunchConfig) {
		this.hostLaunchConfig = hostLaunchConfig;
	}
}
