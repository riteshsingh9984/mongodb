package com.modelUtility;

import java.util.Calendar;

public class HostLaunchConfig {

	private boolean isActive;
	private long activeAt;
	private long activePeriods;  // In milliseconds
	private long expiredAt;
	private long downTime;
	public HostLaunchConfig(){}
	
	public HostLaunchConfig(long activatePeriods){
		long activeAt = Calendar.getInstance().getTimeInMillis();
		this.isActive = true;
		this.activeAt = activeAt;
		this.activePeriods = activatePeriods;
		this.expiredAt = activeAt + activatePeriods;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public long getActiveAt() {
		return activeAt;
	}
	public void setActiveAt() {
		long activeAt = Calendar.getInstance().getTimeInMillis();
		this.activeAt = activeAt;
	}
	public long getActivePeriods() {
		return activePeriods;
	}
	public void setActivePeriods(long activePeriods) {
		this.activePeriods = activePeriods;
	}
	public long getExpiredAt() {
		return expiredAt;
	}
	public void setExpiredAt(long expiredAt) {
		this.expiredAt = expiredAt;
	}

	public long getDownTime() {
		return downTime;
	}

	public void setDownTime(long downTime) {
		this.downTime = downTime;
	}
}
