package org.midas.analytics.simplecache.model;

public class Response {
	private JwtDetails jwtDetails;
	private String statusCode;
	private String statusMessage;
	
	public JwtDetails getJwtDetails() { return jwtDetails; }
	
	public void setJwtDetails(JwtDetails jwtDetails) { this.jwtDetails = jwtDetails; }
	
	public String getStatusCode() { return statusCode; }
	
	public void setStatusCode(String statusCode) { this.statusCode = statusCode; }
	
	public String getStatusMessage() { return statusMessage; }
	
	public void setStatusMessage(String statusMessage) { this.statusMessage = statusMessage; }

	public Response(JwtDetails jwtDetails, String statusCode, String statusMessage) {
		super();
		this.jwtDetails = jwtDetails;
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}
	
	public Response(JwtDetails jwtDetails) {
		super();
		this.jwtDetails = jwtDetails;
		this.statusCode = "";
		this.statusMessage = "";
	}

	public Response() {
		super();
	}

	@Override
	public String toString() {
		return "Response [jwtDetails=" + jwtDetails + ", statusCode=" + statusCode + ", statusMessage=" + statusMessage
				+ "]";
	}	
}
