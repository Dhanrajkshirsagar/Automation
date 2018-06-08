package com.livehealth.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;

@Component
public class CommonMethods {

	/**
	 * Method to wait until pageLoad complete event.
	 */

	public void waitForPageToLoad() {
		try {
			int count = Integer.parseInt(Constants.TIMEOUT) / 1000;
			String pageLoaded;
			final JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
			final String status = "return window.document.readyState;";
			do {
				pageLoaded = (String) js.executeScript(status);
				Thread.sleep(1000);
				count--;
				if (count <= 0) {
					pageLoaded = "complete";
					break;
				}
			} while (!pageLoaded.equalsIgnoreCase("complete"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public CommonMethods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void waitForElementToClickable(WebElement element) throws Exception {

		DriverFactory.getDriverWait().until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * @param filePath
	 * @return
	 */
	public String readFileContent(String filePath) {
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	public static void setTestDescription(String message) {
		ITestResult result = Reporter.getCurrentTestResult();
		result.setAttribute("INFO", message);
	}

	public String getRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 8) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public String getRandomNumber() {

		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);

		String pNumber = String.valueOf(n);

		return "6000" + pNumber;
	}
}