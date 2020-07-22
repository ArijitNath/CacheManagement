package org.midas.analytics.simplecache.model;

public class JwtLogin {
	
	private String userName;
	private String jwt;
	
	public String getUserName() { return userName; }
	
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getJwt() { return jwt; }
	
	public void setJwt(String jwt) { this.jwt = jwt; }

	public JwtLogin(String userName, String jwt) {
		super();
		this.userName = userName;
		this.jwt = jwt;
	}

	public JwtLogin() {
		super();
	}

	@Override
	public String toString() {
		return "JwtLogin [userName=" + userName + ", jwt=" + jwt + "]";
	}	
}
