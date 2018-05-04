package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverSetup {

	WebDriver getWebDriver(DesiredCapabilities desiredCapabilities);

	DesiredCapabilities getDesiredCapabilities();

}
