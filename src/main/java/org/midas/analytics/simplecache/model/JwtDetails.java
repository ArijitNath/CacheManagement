package org.midas.analytics.simplecache.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "jwtDetails")
public class JwtDetails {
	
	@PrimaryKey
	private String userName;
	private String jwt;
	private boolean isActive;
	
	public String getUserName() { return userName; }
	
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getJwt() { return jwt; }
	
	public void setJwt(String jwt) { this.jwt = jwt; }

	public boolean isActive() {	return isActive; }

	public void setActive(boolean isActive) { this.isActive = isActive; }

	public JwtDetails(String userName, String jwt, boolean isActive) {
		super();
		this.userName = userName;
		this.jwt = jwt;
		this.isActive = isActive;
	}

	public JwtDetails() {
		super();
	}

	@Override
	public String toString() {
		return "JwtLogin [userName=" + userName + ", jwt=" + jwt + ", isActive = " + isActive +"]";
	}	
}