package com.livehealth.base;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.livehealth.config.Configuration;

public enum DriverType implements DriverSetup {

	FIREFOX {
		public DesiredCapabilities getDesiredCapabilities() {
			try {
				final FirefoxProfile profile = new FirefoxProfile();
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(FirefoxDriver.MARIONETTE, true);
				capabilities.setCapability(FirefoxDriver.PROFILE, profile);
				return capabilities;
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}

		public WebDriver getWebDriver(DesiredCapabilities capabilities) {
			try {
				return new FirefoxDriver(capabilities);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
	},

	CHROME {
		public DesiredCapabilities getDesiredCapabilities() {
			final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			return capabilities;
		}

		public WebDriver getWebDriver(DesiredCapabilities capabilities) {
			try {
				final ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--no-sandbox");
				return new ChromeDriver(chromeOptions);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
	},

	BROWSER_STACK {
		public DesiredCapabilities getDesiredCapabilities() {
			try {

				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "62.0");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.5.2");

				/*
				 * DesiredCapabilities caps = new DesiredCapabilities();
				 * caps.setCapability("os", "Windows"); caps.setCapability("os_version", "10");
				 * caps.setCapability("browser", "Firefox");
				 * caps.setCapability("browser_version", "58.0");
				 * caps.setCapability("browserstack.local", "false");
				 * caps.setCapability("browserstack.selenium_version", "3.5.2");
				 */

				return caps;
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}

		public WebDriver getWebDriver(DesiredCapabilities capabilities) {
			try {
				return new RemoteWebDriver(new URL(Configuration.browserURL), capabilities);
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
	};
}