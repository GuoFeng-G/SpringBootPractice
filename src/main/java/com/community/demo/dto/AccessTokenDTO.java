package com.community.demo.dto;

public class AccessTokenDTO {

	private String client_id;
	private String client_secret;
	private String code;
	private String redirect_uri;
	private String state;


	public String getClientID() {
		return client_id;
	}

	public void setClientID(String clientID) {
		this.client_id = clientID;
	}

	public String getClientSecret() {
		return client_secret;
	}

	public void setClientSecret(String clientSecret) {
		this.client_secret = clientSecret;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRedirect_uri() {
		return redirect_uri;
	}

	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
