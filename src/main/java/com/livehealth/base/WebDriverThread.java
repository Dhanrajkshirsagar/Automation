package com.livehealth.base;

import static com.livehealth.base.DriverType.BROWSER_STACK;
import static com.livehealth.base.DriverType.valueOf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.livehealth.config.Configuration;

public class WebDriverThread {

	private final DriverType defaultDriverType = BROWSER_STACK;
	private WebDriver webdriver;
	private DriverType selectedDriverType;

	private static String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * Method to get the specified webdriver handle.
	 *
	 * @return
	 * @throws Exception
	 */
	public WebDriver getDriver() {

		try {

			if (null == webdriver) {

				if (isMac()) {
					System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/mac/chromedriver");
					System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/mac/geckodriver");
				} else if (isWindows()) {

					System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/windows/chromedriver");
				}
				else {
					System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/linux/chromedriver");
					System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/linux/geckodriver");
				}

				selectedDriverType = determineEffectiveDriverType();
				DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
				instantiateWebDriver(desiredCapabilities);
				webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		}

		catch (Exception ex) {

			System.out.println("Error=>>>>>>>>>>>" + ex.getMessage());
		}

		return webdriver;
	}

	/**
	 * Method to clean up the webdriver session.
	 */
	public void quitDriver() {
		if (null != webdriver) {
			webdriver.quit();
		}
	}

	/**
	 * Method to determine the specified driverType.
	 *
	 * @return
	 */
	private DriverType determineEffectiveDriverType() {
		DriverType driverType = defaultDriverType;
		try {
			driverType = valueOf(Configuration.browser);
		} catch (IllegalArgumentException ignored) {
			System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
		} catch (NullPointerException ignored) {
			System.err.println("No driver specified, defaulting to '" + driverType + "'...");
		}
		return driverType;
	}

	/**
	 * Method to instantiate the webdriver.
	 *
	 * @param desiredCapabilities
	 */
	private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) {
		webdriver = selectedDriverType.getWebDriver(desiredCapabilities);
	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isWindows() {

		return (OS.indexOf("windows") >= 0);

	}
}
