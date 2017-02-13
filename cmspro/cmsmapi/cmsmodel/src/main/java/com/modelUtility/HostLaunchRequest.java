package com.modelUtility;

public class HostLaunchRequest {

	private String hostName;
	private String welcomePageName;
	private long activePeriod;
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getWelcomePageName() {
		return welcomePageName;
	}
	public void setWelcomePageName(String welcomePageName) {
		this.welcomePageName = welcomePageName;
	}
	public long getActivePeriod() {
		return activePeriod;
	}
	public void setActivePeriod(long activePeriod) {
		this.activePeriod = activePeriod;
	}
}
