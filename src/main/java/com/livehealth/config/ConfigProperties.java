package com.livehealth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "com.livehealth")
@Component
public class ConfigProperties {

	private String livehealthUrl;

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLivehealthUrl() {
		return livehealthUrl;
	}

	public void setLivehealthUrl(String livehealthUrl) {
		this.livehealthUrl = livehealthUrl;
	}

}
