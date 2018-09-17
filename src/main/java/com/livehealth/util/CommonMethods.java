package com.livehealth.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	public static void waitForElementToVisible(WebElement element) throws Exception {

		DriverFactory.getDriverWait().until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitForAllElementsToVisible(List<WebElement> elements) throws Exception {

		DriverFactory.getDriverWait().until(ExpectedConditions.visibilityOfAllElements(elements));

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

	public static String generateRandomName() {

		String text = "";
		String possible = "abcdefghijklnmopqrstuvwxyzhahdgyskwioiuwyebjdjs";

		for (int i = 0; i < 6; i++)
			text += possible.charAt((int) Math.floor(Math.random() * possible.length()));
		return text;

	}

	public static String generateRandomPatientId() {

		String text = "";
		String possible = "1234567894561455548248554458815";

		for (int i = 0; i < 4; i++)
			text += possible.charAt((int) Math.floor(Math.random() * possible.length()));
		return text;

	}

	public static String generateRandomContact() {

		String text = "";
		String possible = "1234567894561455548248554458815";

		for (int i = 0; i < 10; i++)
			text += possible.charAt((int) Math.floor(Math.random() * possible.length()));
		return text;

	}

	public static String generateRandomContactForIndia() {

		String text = "";
		String possible = "1234567894561455548248554458815";

		for (int i = 0; i < 8; i++)
			text += possible.charAt((int) Math.floor(Math.random() * possible.length()));
		return text;

	}

	public String getRandomNumber() {

		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);

		String pNumber = String.valueOf(n);

		return "6000" + pNumber;
	}

	public String getInternationalNumber() {

		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);

		String pNumber = String.valueOf(n);

		return "6004" + pNumber;
	}

	public static String getBackDate(int add1) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Calendar cal = Calendar.getInstance();
		sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, -add1);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}

	public static String getBackD(int add1) {

		SimpleDateFormat sdf = new SimpleDateFormat("E,MMM dd yyyy ");
		Calendar cal = Calendar.getInstance();
		sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, -add1);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}

	public static String getstartDate(int add1) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, -add1);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}

	public static String getBackOrgDate(int add1) {

		SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
		Calendar cal = Calendar.getInstance();
		sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, -add1);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}

	public static int getAge(int day, int month, int year) {
		Calendar dob = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		dob.set(year, month, day);
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		return age;
	}

	public static String getTime(int add1) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm ");
		Calendar cal = Calendar.getInstance();
		sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, +add1);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}

	public static String reduceTime(int hrs) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm ");
		Calendar cal = Calendar.getInstance();
		sdf.format(cal.getTime());
		cal.add(Calendar.HOUR, +hrs);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}

	public static String getTimeForReschedule(int hr) {

		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
		Calendar cal = Calendar.getInstance();
		sdf.format(cal.getTime());
		cal.add(Calendar.HOUR, +hr);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}
	
	public static String getBackDatee(int add1) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
		Calendar cal = Calendar.getInstance();
		sdf.format(cal.getTime());
		cal.add(Calendar.DATE, -add1);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}
	
	

}