package com.models;

import java.util.Set;

import com.modelUtility.EditableInfo;
import com.modelUtility.HeaderFooter;
import com.modelUtility.HostLaunchConfig;

public class HostResponse {

private Long id;
	
	private String hostName;
	private String aliasName;
	private HeaderFooter header;
	private HeaderFooter footer;
	private boolean isHeader;
	private boolean isFooter;
	private HostLaunchConfig hostLaunchConfig;
	private String welcomePage;
	private Set<PageResponse> pages;
	private EditableInfo editableInfo;
	
	public Long getId() {
		return id;
	}
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
	public void setId(Long id) {
		this.id = id;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public Set<PageResponse> getPages() {
		return pages;
	}
	public void setPages(Set<PageResponse> pages) {
		this.pages = pages;
	}
	public EditableInfo getEditableInfo() {
		return editableInfo;
	}
	public void setEditableInfo(EditableInfo editableInfo) {
		this.editableInfo = editableInfo;
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
