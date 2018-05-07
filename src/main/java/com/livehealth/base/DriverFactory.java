package com.livehealth.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class DriverFactory {

	private static List<WebDriverThread> webDriverThreadPool = Collections
			.synchronizedList(new ArrayList<WebDriverThread>());
	private static ThreadLocal<WebDriverThread> driverThread;

	/**
	 * Method to instantiate driver and assign a thread pool.
	 */
	public static void instantiateDriverObject() {

		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				WebDriverThread webDriverThread = new WebDriverThread();
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
			}
		};
	}

	/**
	 * Method to get the current webdriver instance.
	 *
	 * @return
	 * @throws Exception
	 */

	public static WebDriver getWindowDriver(String title) throws Exception {

		WebDriver driverWindow = null;

		for (String handle : DriverFactory.getDriver().getWindowHandles()) {
			driverWindow = DriverFactory.getDriver().switchTo().window(handle);
			String titleWindow = driverWindow.getTitle();

			if (titleWindow.equals(title)) {
				return driverWindow;
			}

		}

		return driverWindow;
	}

	public static WebDriver getDriver() throws Exception {

		WebDriver driver;
		if (driverThread == null) {
			instantiateDriverObject();

		}

		driver = driverThread.get().getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	public static WebDriverWait getDriverWait() throws Exception {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

		return wait;

	}

	/**
	 * Method to clear cookies after each test method.
	 *
	 * @throws Exception
	 */
	@AfterMethod
	public static void clearCookies() throws Exception {
		getDriver().manage().deleteAllCookies();
	}

	/**
	 * Method to clean up webdriver instance after every suite.
	 */

	public static void closeDriverObjects() {
		for (WebDriverThread webDriverThread : webDriverThreadPool) {
			webDriverThread.quitDriver();
		}
	}

}