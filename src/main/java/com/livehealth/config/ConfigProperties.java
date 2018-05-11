package com.livehealth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "com.livehealth")
@Component
public class ConfigProperties {

	private String livehealthUrl;

	public String getLivehealthUrl() {
		return livehealthUrl;
	}

	public void setLivehealthUrl(String livehealthUrl) {
		this.livehealthUrl = livehealthUrl;
	}

}
