package com.livehealth.pageobject;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;

import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;
import com.livehealth.util.CommonMethods;

public class AppointmentPage {
	static SoftAssert SoftAssert = new SoftAssert();

	public String appointmenttime;
	public static String rescheduleTime;
	public LocalTime getTime;
	public static String calAge;

	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement adminHover;

	@FindBy(linkText = "Appointments")
	private static WebElement appointmentTab;

	@FindBy(xpath = "//*[@id=\"nav-sidebar\"]/div[3]/ul/li[1]/a")
	public WebElement registrationTab;

	@FindBy(id = "takeNewRequest")
	private static WebElement bookNewAppointment;

	@FindBy(id = "bookAppointmentBtn")
	private static WebElement bookAppointmentBtn;

	@FindBy(id = "patientName")
	private static WebElement patientName;

	@FindBy(id = "genderAlert")
	private WebElement genderAlert;

	@FindBy(id = "appointmentTime")
	private static WebElement appointmentTime;

	@FindBy(id = "newAppointmentTime")
	private static WebElement newAppointmentTime;

	@FindBy(xpath = "//*[@id=\"bookAppointmentModal\"]/div[1]/div/div[3]/div/button[1]")
	private static WebElement closeModal;

	@FindBy(xpath = "//*[@id=\"rescheduleAppointmentModal\"]/div[1]/div/div[3]/div/button[1]")
	private static WebElement close;

	@FindBy(id = "regMobile")
	private WebElement regMobile;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "age")
	private static WebElement age;

	@FindBy(id = "designation")
	private WebElement designation;

	@FindBy(id = "radiobutton")
	private static WebElement male;

	@FindBy(id = "area")
	private WebElement area;

	@FindBy(id = "comment")
	private WebElement comment;

	@FindBy(id = "appointmentListDiv")
	private static WebElement edit;

	@FindBy(id = "patientInfo")
	private WebElement patientInfo;

	@FindBy(id = "confirmBtn")
	private static WebElement confirmBtn;

	@FindBy(className = "alert-success")
	private static WebElement alertSuccess;

	@FindBy(id = "pcontact")
	private WebElement pcontact;

	@FindBy(id = "pcomment")
	private WebElement pcomment;

	@FindBy(id = "rescheduleBtn")
	private static WebElement rescheduleBtn;

	@FindBy(xpath = "//*[@id=\"rescheduleAppointmentModal\"]/div[1]/div/div[2]/div[12]/label")
	private static WebElement sideClick;

	@FindBy(className = "fc-content")
	private WebElement AppointmentList;

	@FindBy(id = "reconfirmFlag")
	private static WebElement reconfirmFlag;

	@FindBy(id = "billingBtn")
	private static WebElement billingBtn;

	@FindBy(className = "btn-danger ")
	private static WebElement delete;

	@FindBy(id = "patientType")
	private static WebElement PatientType;

	@FindBy(id = "bookAppDoctor")
	private static WebElement bookAppDoctor;

	@FindBy(id = "rescheduleAppDoctor")
	private static WebElement rescheduleAppDoctor;

	@FindBy(id = "day")
	private static WebElement day;

	@FindBy(id = "month")
	private static WebElement month;

	@FindBy(id = "year")
	private static WebElement year;

	@FindBy(id = "errorDiv")
	private static WebElement errorDiv;

	@FindBy(id = "rescheduleErrorDiv")
	private static WebElement rescheduleErrorDiv;

	@FindBy(id = "confirmFlag")
	private static WebElement confirmFlag;

	@FindBy(id = "newDirectFirstName")
	private static WebElement newDirectFirstName;

	@FindBy(id = "newDirectPatientType")
	private static WebElement newDirectPatientType;

	@FindBy(id = "newDirectDesignation")
	private static WebElement newDirectDesignation;

	@FindBy(xpath = "//*[@id=\"rescheduleAppointmentModal\"]/div[1]/div/div[2]/div[17]/div/button[1]")
	private static WebElement CloseModal;

	@FindBy(xpath = "//a[contains(text(),'Advance Collection')]")
	private WebElement advanceCollectionTab;
	
	@FindBy(id = "searchPatient")
	private WebElement searchPatient;

	@FindBy(xpath = "/html/body/section/div[2]/h4")
	private WebElement pagetittle;

	@FindBy(id = "submit")
	private WebElement submit;

	@FindBy(id = "advanceAmount")
	private WebElement advanceAmount;

	@FindBy(id = "advanceGiven")
	private WebElement advanceGiven;

	@FindBy(id = "print")
	private WebElement submitAndPrint;

	@PostConstruct
	public void loadDriver() throws Exception {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}

	public void signIn(String userName, String password) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signIn.click();
		CommonMethods.waitForElementToClickable(adminHover);
		driver.navigate().to(Constants.Billing_URL);
	}

	public ArrayList<String> bookAppointment() throws Exception {

		appointmentTab.click();
		bookNewAppointment.click();
		CommonMethods.waitForElementToClickable(bookAppointmentBtn);
		bookAppointmentBtn.click();
		Thread.sleep(500);

		String nameValidation = patientName.getCssValue("border-color");
		String gender = genderAlert.getCssValue("border-color");
		String appointmentTim = appointmentTime.getCssValue("border-color");

		ArrayList<String> list = new ArrayList<>();
		list.add(nameValidation);
		list.add(gender);
		list.add(appointmentTim);

		closeModal.click();
		return list;
	}

	public String bookNewAppointment(String mobNo, String name, String Age) throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(bookNewAppointment);
		bookNewAppointment.click();
		CommonMethods.waitForElementToClickable(bookAppointmentBtn);
		regMobile.sendKeys(mobNo);
		email.sendKeys("dhanraj.kshirsagar@livehealth.in");
		patientName.sendKeys(name);
		age.sendKeys(Age);
		male.click();
		appointmentTime.click();
		comment.sendKeys("comment for testing");
		CommonMethods.waitForElementToClickable(bookAppointmentBtn);
		appointmenttime = appointmentTime.getAttribute("value");
		bookAppointmentBtn.click();
		String successMessage = null;
		String error = errorDiv.getText();
		if (error.equals("×\n" + "Server Error !")) {
			Assert.assertFalse(true);
		} else {
			Thread.sleep(500);
			successMessage = alertSuccess.getText();
		}
		return successMessage;

	}

	public ArrayList<String> verifyAppointmentPatientDetails(String mobNo, String name, String Age) throws Exception {
		Thread.sleep(1000);

		List<WebElement> options = edit.findElements(By.tagName("div"));
		int length = options.size();
		WebElement Appointment = options.get(length - 1);
		Appointment.click();
		CommonMethods.waitForElementToClickable(confirmBtn);
		String confirmName = patientInfo.getText();
		String actualname = confirmName.substring(0, 7);

		CommonMethods.waitForElementToClickable(confirmBtn);
		String contact = pcontact.getText();
		String text = pcomment.getText();

		ArrayList<String> list = new ArrayList<>();
		list.add(actualname);
		list.add(contact);
		list.add(text);
		return list;

	}

	public String bookNewAppointmentForExistingPatient(String name) throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		CommonMethods.waitForElementToClickable(bookNewAppointment);
		bookNewAppointment.click();
		CommonMethods.waitForElementToClickable(bookAppointmentBtn);
		patientName.sendKeys(name);
		Thread.sleep(2000);
		patientName.sendKeys(Keys.ARROW_DOWN);
		patientName.sendKeys(Keys.ENTER);
		appointmentTime.click();
		CommonMethods.waitForElementToClickable(bookAppointmentBtn);
		bookAppointmentBtn.click();
		String error = errorDiv.getText();
		String sucess = null;
		if (error.equals("×\n" + "Server Error !")) {
			Assert.assertFalse(true);
		} else {
			Thread.sleep(500);
			sucess = alertSuccess.getText();
		}
		return sucess;

	}

	public String bookNewAppointmentWithDOB() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(bookNewAppointment);
		bookNewAppointment.click();
		CommonMethods.waitForElementToClickable(bookAppointmentBtn);
		String name = CommonMethods.generateRandomName();
		patientName.sendKeys(name);
		CommonMethods.waitForElementToClickable(day);
		Select day1 = new Select(day);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		day1.selectByVisibleText("7");
		Select Mont = new Select(month);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Mont.selectByVisibleText("Mar");
		Select yeear = new Select(year);
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		yeear.selectByVisibleText("1992");
		male.click();
		appointmentTime.click();
		CommonMethods.waitForElementToClickable(bookAppointmentBtn);
		bookAppointmentBtn.click();
		String error = errorDiv.getText();
		String sucess = null;
		if (error.equals("×\n" + "Server Error !")) {
			Assert.assertFalse(true);
		} else {
			sucess = alertSuccess.getText();
		}
		return sucess;

	}

	public String RescheduleAppointment(int add) throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		Thread.sleep(2000);
		List<WebElement> options = edit.findElements(By.tagName("div"));
		int length = options.size();
		WebElement Appointment = options.get(length - 1);
		Appointment.click();
		CommonMethods.waitForElementToClickable(newAppointmentTime);
		newAppointmentTime.click();
		Thread.sleep(1000);
		rescheduleTime = CommonMethods.getTime(add);
		getTime = LocalTime.now();
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("document.getElementById('newAppointmentTime').value = arguments[0];", rescheduleTime);
		String myDate = (String) js.executeScript("return document.getElementById('newAppointmentTime').value");
		sideClick.click();
		CommonMethods.waitForElementToClickable(rescheduleBtn);
		rescheduleBtn.click();
		String error = rescheduleErrorDiv.getText();
		String alert = null;
		if (error.equals("×\n" + "Error in reschedule appointment.")) {
			Assert.assertFalse(true);
		} else {
			Thread.sleep(500);
			alert = alertSuccess.getText();
		}
		return alert;

	}

	public static void getAppointmentList() throws Exception {
		appointmentTab.click();
		Thread.sleep(1000);

		List<WebElement> list = edit.findElements(By.tagName("div"));
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getCssValue("background-color").equals("rgba(245, 245, 245, 1)")) {
				WebElement Appointment = list.get(i);
				Appointment.click();
				break;
			}

		}
		CommonMethods.waitForElementToClickable(confirmBtn);
		confirmBtn.click();
		String error = rescheduleErrorDiv.getText();
		if (error.equals("×\n" + "Error in confirm appointment.")) {
			Assert.assertFalse(true);
		}

	}

	public String confirmAppointment() throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		clickToOpenAppointment(1); // Type 1 = Normal appointment Type 2= Confirmed Appointment
		CommonMethods.waitForElementToClickable(confirmBtn);
		confirmBtn.click();
		String error = rescheduleErrorDiv.getText();
		String alert = null;
		if (error.equals("×\n" + "Error in confirm appointment.")) {
			Assert.assertFalse(true);
		} else {
			CommonMethods.waitForElementToVisible(alertSuccess);
			alert = alertSuccess.getText();
		}
		return alert;

	}

	public static void clickToOpenAppointment(int type) throws InterruptedException {

		Thread.sleep(2000);
		List<WebElement> options = edit.findElements(By.tagName("div"));

		for (int i = 0; i < options.size(); i++) {
			if (type == 1) {

				if (options.get(i).getCssValue("background-color").equals("rgba(245, 245, 245, 1)")) {
					WebElement Appointment = options.get(i);
					Appointment.click();
					break;
				}
			} else {
				if (options.get(i).getCssValue("background-color").equals("rgba(185, 230, 253, 1)")) {
					WebElement Appointment = options.get(i);
					Appointment.click();
					break;
				}
			}
		}
	}

	public String rescheduleConfirmAppointment() throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		clickToOpenAppointment(2);
		CommonMethods.waitForElementToClickable(newAppointmentTime);
		newAppointmentTime.click();
		CommonMethods.waitForElementToClickable(newAppointmentTime);
		rescheduleTime = CommonMethods.getTime(2);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("document.getElementById('newAppointmentTime').value = arguments[0];", rescheduleTime);
		String myDate = (String) js.executeScript("return document.getElementById('newAppointmentTime').value");
		sideClick.click();
		CommonMethods.waitForElementToClickable(rescheduleBtn);
		rescheduleBtn.click();
		String error = rescheduleErrorDiv.getText();
		String alert = null;
		if (error.equals("×\n" + "Error in reschedule appointment.")) {
			Assert.assertFalse(true);
		} else {
			Thread.sleep(500);
			alert = alertSuccess.getText();

		}
		return alert;

	}

	public String dismissAppointment() throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		appointmentTab.click();
		clickToOpenAppointment(1);
		CommonMethods.waitForElementToVisible(delete);
		delete.click();
		String error = rescheduleErrorDiv.getText();
		String alert1 = null;
		if (error.equals("×\n" + "Error in cancel appointment.")) {
			Assert.assertFalse(true);
		} else {
			Thread.sleep(500);
			alert1 = alertSuccess.getText();
		}
		return alert1;

	}

	public String appontmentWithPatientType(String patientType, String value) throws Exception {
		Thread.sleep(1000);
		appointmentTab.click();
		CommonMethods.waitForElementToClickable(bookNewAppointment);
		bookNewAppointment.click();
		Thread.sleep(1000);
		String name = CommonMethods.generateRandomName();
		String subname = name.substring(0, 5);
		patientName.sendKeys(name);
		Thread.sleep(1000);
		if (patientType.contentEquals("Patient Type (Default : Direct)")) {
			Select DirectPatient = new Select(PatientType);
			DirectPatient.selectByIndex(0);
		}
		if (patientType.contentEquals("Indirect (I)")) {
			Select InDirectPatient = new Select(PatientType);
			InDirectPatient.selectByIndex(1);
		}
		if (patientType.contentEquals("OPD (OP)")) {
			Select OPDPatient = new Select(PatientType);
			OPDPatient.selectByIndex(2);
		}
		if (patientType.contentEquals("IPD (IP)")) {
			Select IPDPatient = new Select(PatientType);
			IPDPatient.selectByIndex(3);
		}
		if (patientType.contentEquals("RB")) {
			Select RBPatient = new Select(PatientType);
			RBPatient.selectByIndex(4);
		}
		if (patientType.contentEquals("Main Lab (ML)")) {
			Select MLPatient = new Select(PatientType);
			MLPatient.selectByIndex(5);
		}
		if (patientType.contentEquals("Baby or Just Born (B/O)")) {
			Select MLPatient = new Select(PatientType);
			MLPatient.selectByIndex(6);
		}

		if (patientType.contentEquals("Corporate (CC)")) {
			Select CCPatient = new Select(PatientType);
			CCPatient.selectByIndex(7);
		}

		male.click();
		appointmentTime.click();
		CommonMethods.waitForElementToClickable(bookAppointmentBtn);
		bookAppointmentBtn.click();
		String error = errorDiv.getText();
		if (error.equals("×\n" + "Server Error !")) {
			Assert.assertFalse(true);
		} else {
			Thread.sleep(1500);
			registrationTab.click();
			CommonMethods.waitForElementToVisible(newDirectFirstName);
			newDirectFirstName.sendKeys(subname);
			Thread.sleep(2000);
			newDirectFirstName.sendKeys(Keys.ARROW_DOWN);
			newDirectFirstName.sendKeys(Keys.ENTER);
		}
		Thread.sleep(1000);
		String patientTyp = newDirectPatientType.getAttribute("value");

		return patientTyp;

	}

	public String appontmentWithDesignation(String patientDesignation, String value) throws Exception {
		Thread.sleep(1000);
		appointmentTab.click();
		CommonMethods.waitForElementToClickable(bookNewAppointment);
		bookNewAppointment.click();
		Thread.sleep(1000);
		String name = CommonMethods.generateRandomName();
		String subname = name.substring(0, 5);
		patientName.sendKeys(name);
		Thread.sleep(1000);
		if (patientDesignation.equals("Mr.")) {
			Select MrPatient = new Select(designation);
			MrPatient.selectByVisibleText("Mr.");
		}
		if (patientDesignation.equals("Mrs.")) {
			Select MrsPatient = new Select(designation);
			MrsPatient.selectByVisibleText("Mrs.");
		}
		if (patientDesignation.equals("Ms.")) {
			Select MsPatient = new Select(designation);
			MsPatient.selectByVisibleText("Ms.");
		}
		if (patientDesignation.equals("Master")) {
			Select MrPatient = new Select(designation);
			MrPatient.selectByVisibleText("Master");
		}
		if (patientDesignation.equals("Miss")) {
			Select MissPatient = new Select(designation);
			MissPatient.selectByVisibleText("Miss");
		}
		if (patientDesignation.equals("Smt.")) {
			Select smtPatient = new Select(designation);
			smtPatient.selectByVisibleText("Smt.");
		}
		if (patientDesignation.equals("Dr.")) {
			Select DrPatient = new Select(designation);
			DrPatient.selectByVisibleText("Dr.");
			male.click();
		}
		if (patientDesignation.equals("Baby or Just Born (B/O)")) {
			Select MrPatient = new Select(designation);
			MrPatient.selectByVisibleText("Baby or Just Born (B/O)");
			male.click();
		}

		appointmentTime.click();
		CommonMethods.waitForElementToClickable(bookAppointmentBtn);
		bookAppointmentBtn.click();
		String error = errorDiv.getText();
		String Designation = null;
		if (error.equals("×\n" + "Server Error !")) {
			Assert.assertFalse(true);
		} else {
			Thread.sleep(1500);
			registrationTab.click();
			CommonMethods.waitForElementToVisible(newDirectFirstName);
			newDirectFirstName.sendKeys(subname);
			Thread.sleep(2000);
			newDirectFirstName.sendKeys(Keys.ARROW_DOWN);
			newDirectFirstName.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			Designation = newDirectDesignation.getAttribute("value");
		}
		return Designation;

	}

	public String bookAppointmentWithSelectedDoc() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		appointmentTab.click();
		bookNewAppointment.click();
		CommonMethods.waitForElementToClickable(bookAppDoctor);
		String name = CommonMethods.generateRandomName();
		patientName.sendKeys(name);
		Select Doctor = new Select(bookAppDoctor);
		Doctor.selectByVisibleText("dhanraj");
		male.click();
		appointmentTime.click();
		bookAppointmentBtn.click();
		String error = errorDiv.getText();
		String doc = null;
		if (error.equals("×\n" + "Server Error !")) {
			Assert.assertFalse(true);
		} else {
			Thread.sleep(2000);
			List<WebElement> options = edit.findElements(By.tagName("div"));
			int length = options.size();
			WebElement Appointment = options.get(length - 1);
			Appointment.click();
			Thread.sleep(2000);
			doc = rescheduleAppDoctor.getAttribute("value");
		}
		return doc;

	}

	public static void ageCalculate(String Day, String Month, String yr) throws Exception {
		Thread.sleep(1000);
		WebDriver driver = DriverFactory.getDriver();
		appointmentTab.click();
		CommonMethods.waitForElementToClickable(bookNewAppointment);
		bookNewAppointment.click();
		CommonMethods.waitForElementToClickable(day);

		Select day1 = new Select(day);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		day1.selectByVisibleText(Day);
		Select Mont = new Select(month);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Mont.selectByVisibleText(Month);
		Select yeear = new Select(year);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		yeear.selectByVisibleText(yr);

		Thread.sleep(2000);
		calAge = age.getAttribute("value");
		closeModal.click();

	}

	public String verifyAdvanceCollectionPage() {
		advanceCollectionTab.click();
		return pagetittle.getText();
	}

	public void selectPatient(String name) throws InterruptedException {
		searchPatient.sendKeys(name);
		Thread.sleep(2000);
		searchPatient.sendKeys(Keys.ARROW_DOWN);
		searchPatient.sendKeys(Keys.ENTER);

	}

	public String checkValidation(String name) throws InterruptedException {
		// advanceCollectionTab.click();
		String colour = null;
		if (submit.isEnabled()) {
			Assert.assertFalse(true);
		} else {
			selectPatient(name);
			if (submit.isEnabled()) {
				SoftAssert.assertFalse(false);
				submit.click();
				Thread.sleep(1000);
				colour = advanceAmount.getCssValue("border-bottom-color");
			}
		}
		return colour;

	}

	public void collectAdvance(String mobNo, String amount) throws InterruptedException {
		advanceCollectionTab.click();
		searchPatient.clear();
		if (mobNo.equals("827536")) {
			selectPatient(mobNo);
		}
		if (mobNo.equals("774050")) {
			selectPatient(mobNo);
		}
		if (mobNo.equals("441559")) {
			selectPatient(mobNo);
		}

		String actualadvance = advanceGiven.getText();
		int expectedAdv = Integer.parseInt(actualadvance);
		int finalAdv = expectedAdv + Integer.parseInt(amount);
		String advAmount = Integer.toString(finalAdv);
		searchPatient.clear();
		selectPatient(mobNo);
		advanceAmount.sendKeys(amount);
		submit.click();
		searchPatient.clear();
		selectPatient(mobNo);
		String actualAdvAmt = advanceGiven.getText();
		SoftAssert.assertEquals(actualAdvAmt, advAmount);
		SoftAssert.assertAll();

	}

	public void collectAdanceAndPrintReceipt(String name, String amount) throws Exception {
		// advanceCollectionTab.click();
		WebDriver driver = DriverFactory.getDriver();
		searchPatient.clear();
		selectPatient(name);
		advanceAmount.sendKeys(amount);
		String winHandleBefore = driver.getWindowHandle();
		submitAndPrint.click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String actualUrl = DriverFactory.getDriver().getCurrentUrl();
		String afterSubmitUrl = actualUrl.substring(0, 53);
		Assert.assertEquals(afterSubmitUrl, "https://beta.livehealth.solutions/printAdvanceReceipt");
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

}
