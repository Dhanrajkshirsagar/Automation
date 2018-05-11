
package com.livehealth.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.livehealth.config.Configuration;

@Component
public class WebContext implements InitializingBean {

	@Value("${wapUrl}")
	private String wapURL;

	@Value("${browser}")
	private String browserName;

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("====== Setting Up Suite Execution ======");

		try {

			Configuration.wapBaseURL = wapURL;
			Configuration.browser = browserName;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
