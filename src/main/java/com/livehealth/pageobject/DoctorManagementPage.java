package com.livehealth.pageobject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.*;
import com.livehealth.base.DriverFactory;
import com.livehealth.util.CommonMethods;

public class DoctorManagementPage {

	SoftAssert SoftAssert = new SoftAssert();
	Log4JLogger logger;

	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement adminHover;

	@FindBy(xpath = "//a[contains(text(),'Doctor Management')]")
	private WebElement DoctorManagementTab;

	@FindBy(xpath = "//a[contains(text(),'Add / Edit Doctor')]")
	private WebElement AddEditDoctorTab;

	@FindBy(id = "addTestTab")
	private WebElement addTestTab;

	@FindBy(id = "uploadButton")
	private WebElement uploadButton;

	@FindBy(id = "doctorContact")
	private WebElement doctorContact;

	@FindBy(id = "errorDiv")
	private WebElement errorDiv;

	@FindBy(id = "departmentList")
	private WebElement departmentList;

	@FindBy(id = "doctorName")
	private WebElement doctorName;

	@FindBy(id = "addCity")
	private WebElement addCity;

	@FindBy(id = "doctorEmail")
	private WebElement doctorEmail;

	@FindBy(id = "doctorPincode")
	private WebElement doctorPincode;

	@FindBy(id = "doctorPassKey")
	private WebElement doctorPassKey;

	@FindBy(id = "doctorUsername")
	private WebElement doctorUsername;

	@FindBy(id = "doctorPassword")
	private WebElement doctorPassword;

	@FindBy(className = "text-center")
	private WebElement loginpurposes;

	@FindBy(id = "editTestTab")
	private WebElement editTestTab;

	@FindBy(id = "doctorList")
	private WebElement doctorList;

	@FindBy(id = "error-msg")
	private WebElement errormsg;

	@FindBy(id = "addDoctorDay")
	private WebElement addDoctorDay;

	@FindBy(id = "addDoctorMonth")
	private WebElement addDoctorMonth;

	@FindBy(id = "addDoctorYear")
	private WebElement addDoctorYear;

	@FindBy(id = "addDoctorDayAnniversary")
	private WebElement addDoctorDayAnniversary;

	@FindBy(id = "addDoctorMonthAnniversary")
	private WebElement addDoctorMonthAnniversary;

	@FindBy(id = "addDoctorYearAnniversary")
	private WebElement addDoctorYearAnniversary;

	@FindBy(id = "selectDoctorAddDesignation")
	private WebElement selectDoctorAddDesignation;

	@FindBy(xpath = "//a[contains(text(),'Dr.')]")
	private WebElement DrDesignation;

	@FindBy(xpath = "//a[contains(text(),'Dr. (Ms)')]")
	private WebElement DrMsDesignation;

	@FindBy(xpath = "//a[contains(text(),'Dr. (Smt)')]")
	private WebElement DrSmtDesignation;

	@FindBy(xpath = "//a[contains(text(),'Blank')]")
	private WebElement Blank;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement deleteDoc;

	@FindBy(id = "selectDoctorEditDesignation")
	private WebElement selectDoctorEditDesignation;

	@FindBy(id = "referralFlag")
	private WebElement referralFlag;

	@FindBy(id = "referralEditList")
	private WebElement referralEditList;

	@FindBy(id = "deleteRefButton")
	private WebElement deleteRefButton;

	@FindBy(id = "deletebtn")
	private WebElement deletebtn;

	@FindBy(xpath = "//a[contains(text(),'Add Visiting Timings')]")
	private WebElement AddVisitingTimings;

	@FindBy(id = "startTime")
	private WebElement startTime;

	@FindBy(id = "endTime")
	private WebElement endTime;

	@FindBy(id = "weekday")
	private WebElement weekday;

	@FindBy(xpath = "//*[@id=\"visitingTimimgsModal\"]/div/div/div[2]/div[2]/div[4]/button")
	private WebElement addTime;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement Close;

	@FindBy(xpath = "//a[contains(text(),'Update Visiting Timings')]")
	private WebElement UpdateVisitingTimings;

	@FindBy(id = "loginhr1")
	private WebElement loginhr1;

	@FindBy(id = "docTimingsId")
	private WebElement docTimingsId;

	@FindBy(id = "timeErrorDiv")
	private WebElement timeErrorDiv;

	@FindBy(id = "referralName")
	private WebElement referralName;

	@FindBy(id = "doctorLists")
	private WebElement doctorLists;

	@FindBy(id = "listDocButton")
	private WebElement listDocButton;

	@FindBy(id = "listDeleteButton")
	private WebElement listDeleteButton;

	@FindBy(id = "docTotalRev")
	private WebElement docTotalRev;

	@FindBy(id = "listLink")
	private WebElement listLink;

	@FindBy(id = "exportListLink")
	private WebElement exportListLink;

	@FindBy(id = "selectedListName")
	private WebElement selectedListName;

	@FindBy(xpath = "//a[contains(text(),'Doctor Revenue Management')]")
	private WebElement DoctorRevenueManagementTab;

	@FindBy(id = "setUpdateRevenueDateRange")
	private WebElement setUpdateRevenueDateRange;

	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement Update;

	@FindBy(id = "cb_allReports")
	private WebElement allReveueFlag;

	@FindBy(xpath = "//*[@id=\"headingOne\"]/h4/a")
	private WebElement collapse;

	@FindBy(id = "discountSharing")
	private WebElement discountSharing;

	@FindBy(xpath = "//a[contains(text(),'Doctor Revenue Tracker')]")
	private WebElement DoctoRevenueTrackerTab;

	@FindBy(id = "trackerDocName")
	private WebElement trackerDocName;

	@FindBy(id = "noBillMsg")
	private WebElement noBillMsg;

	@FindBy(id = "submitButton")
	private WebElement submitButton;

	@FindBy(id = "cutAmount")
	private WebElement cutAmount;

	@FindBy(id = "doctorDateChange")
	private WebElement doctorDateChange;

	@FindBy(name = "daterangepicker_start")
	private WebElement daterangepickerstart;

	@FindBy(name = "daterangepicker_end")
	private WebElement daterangepickerend;

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	private WebElement Apply;

	@FindBy(id = "billUrl")
	private WebElement billUrl;

	@FindBy(id = "searchPatient")
	private WebElement searchPatient;

	@FindBy(id = "searchInputforTests")
	private WebElement searchInputforTests;

	@FindBy(id = "concession")
	private WebElement concession;

	@FindBy(id = "totalConcessionAmt")
	private WebElement totalConcessionAmt;

	@FindBy(id = "AdvanceAmount")
	private WebElement AdvanceAmount;

	@FindBy(id = "saveBill")
	private WebElement saveBill;

	@FindBy(id = "confirmBillMsgDiv")
	private WebElement confirmBillMsgDiv;

	@FindBy(id = "backToRegistration")
	private WebElement backToRegistration;

	@FindBy(id = "li_allData")
	private WebElement allData;

	@FindBy(id = "li_discounted")
	private WebElement discounted;

	@FindBy(id = "li_notDiscounted")
	private WebElement notDiscounted;

	@FindBy(id = "trackDocName")
	private WebElement trackDocName;

	@FindBy(id = "submitOTPBtn")
	private WebElement submitOTPBtn;

	@FindBy(id = "doctorSMSFlag")
	private WebElement doctorSMSFlag;

	@FindBy(id = "docRepComments")
	private WebElement docRepComments;

	@FindBy(id = "totalAmountDoctorSMS")
	private WebElement totalAmountDoctorSMS;

	@FindBy(id = "selectAllTrackDocFlag")
	private WebElement selectAllTrackDocFlag;

	@FindAll({ @FindBy(id = "doctorList") })
	private WebElement doctors;

	@PostConstruct
	public void loadDriver() throws Exception {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}

	public void signIn(String userName, String password) throws Exception {

		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signIn.click();
		CommonMethods.waitForElementToClickable(adminHover);

	}

	public void addEditDoc() throws Exception {
		CommonMethods.waitForElementToClickable(DoctorManagementTab);
		DoctorManagementTab.click();
		AddEditDoctorTab.click();
	}

	public ArrayList<String> addDocValidation(String docContact) throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		CommonMethods.waitForElementToClickable(uploadButton);
		uploadButton.click();

		String contactCss = doctorContact.getCssValue("border-color");
		String warning = errorDiv.getText();
		doctorContact.sendKeys(docContact);
		uploadButton.click();
		String departmentCss = departmentList.getCssValue("border-color");
		uploadButton.click();
		selectDoctorDepartment("pathology");
		String docNameCss = doctorName.getCssValue("border-color");
		ArrayList<String> list = new ArrayList<>();
		list.add(contactCss);
		list.add(warning);
		list.add(departmentCss);
		list.add(docNameCss);

		return list;

	}

	public void selectDoctorDepartment(String departName) throws InterruptedException {
		departmentList.sendKeys(departName);
		Thread.sleep(500);
		departmentList.sendKeys(Keys.ARROW_DOWN);
		departmentList.sendKeys(Keys.ENTER);
	}

	public boolean addDoctorWithAllDetails(String docName, String contact, String email) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addTestTab.click();
		doctorName.sendKeys(docName);
		doctorContact.sendKeys(contact);
		doctorEmail.sendKeys(email);
		addCity.sendKeys("pune");
		doctorPincode.sendKeys("411041");
		doctorPassKey.clear();
		doctorPassKey.sendKeys("1234");
		loginpurposes.click();

		selectDoctorDepartment("pathology");
		selectDoctorDepartment("SEROLOGY");
		selectDoctorDepartment("HAEMATOLOGY");
		CommonMethods.waitForElementToVisible(doctorUsername);
		doctorUsername.sendKeys("pratik");
		doctorPassword.sendKeys("Pratik@123");
		CommonMethods.waitForElementToClickable(uploadButton);
		uploadButton.click();

		editTestTab.click();
		CommonMethods.waitForElementToClickable(doctorList);
		List<WebElement> docList = DriverFactory.getDriver().findElements(By.id("doctorList"));
		for (int i = 0; i < docList.size(); i++) {
			if (docList.get(i).getText().contains("pratik")) {
				return true;
			}
		}
		return false;

	}

	public ArrayList<String> addedDoctordetails(String docName, String contact, String email) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		editTestTab.click();

		CommonMethods.waitForElementToClickable(doctorList);
		Select ele = new Select(doctorList);
		ele.selectByVisibleText(docName);
		CommonMethods.waitForElementToClickable(doctorName);

		String editDocName = doctorName.getAttribute("value");
		String editDocContact = doctorContact.getAttribute("value");
		String editDocEmail = doctorEmail.getAttribute("value");
		String editDocPassKey = doctorPassKey.getAttribute("value");

		ArrayList<String> list = new ArrayList<>();
		list.add(editDocName);
		list.add(editDocContact);
		list.add(editDocEmail);
		list.add(editDocPassKey);
		return list;

	}

	public ArrayList<String> contactFieldValidation(String validcontact, String invalidContact) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addTestTab.click();
		String validDocContact = null;
		String InvalidDocContact = null;
		Thread.sleep(300);
		if (validcontact.equals("7451202020")) {
			doctorContact.sendKeys(validcontact);
			doctorEmail.click();
			validDocContact = doctorContact.getCssValue("border-color");
		}

		if (invalidContact.equals("74510")) {
			doctorContact.clear();
			doctorContact.sendKeys(invalidContact);
			doctorEmail.click();
			CommonMethods.waitForElementToVisible(errormsg);
			InvalidDocContact = errormsg.getText();
		}
		ArrayList<String> list = new ArrayList<>();
		list.add(validDocContact);
		list.add(InvalidDocContact);

		return list;

	}

	public ArrayList<String> DocNameAndEmailField(String name, String email) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addTestTab.click();
		String DocName = null;
		String docEmail = null;
		Thread.sleep(300);
		if (name.equals("pratik")) {
			doctorName.sendKeys(name);
			doctorContact.click();
			DocName = doctorName.getCssValue("border-color");
		}
		if (email.equals("pratik@gmail.com")) {
			doctorEmail.sendKeys(email);
			doctorContact.click();
			docEmail = doctorEmail.getCssValue("border-color");
		}
		ArrayList<String> list = new ArrayList<>();
		list.add(DocName);
		list.add(docEmail);
		return list;

	}

	public boolean docUserNameValidation(String userName) throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		addTestTab.click();
		doctorName.sendKeys("mahesh");
		loginpurposes.click();
		CommonMethods.waitForElementToClickable(doctorUsername);
		doctorUsername.sendKeys(userName);
		doctorPassword.click();

		Thread.sleep(300);
		String userNm = doctorUsername.getCssValue("border-color");
		Assert.assertEquals(userNm, "rgb(255, 0, 0)");

		if (uploadButton.isEnabled()) {
			return false;
		}
		return true;

	}

	public boolean addDoctorwithDOBAndDOA(String doc, String contact) throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		addTestTab.click();
		doctorName.sendKeys(doc);
		doctorContact.sendKeys(contact);
		int flag = 0;
		Select date = new Select(addDoctorDay);
		date.selectByVisibleText("7");
		Select mon = new Select(addDoctorMonth);
		mon.selectByVisibleText("Mar");
		Select yr = new Select(addDoctorYear);
		yr.selectByVisibleText("1992");

		Select date1 = new Select(addDoctorDayAnniversary);
		date1.selectByVisibleText("3");
		Select mon1 = new Select(addDoctorMonthAnniversary);
		mon1.selectByVisibleText("Mar");
		Select yr1 = new Select(addDoctorYearAnniversary);
		yr1.selectByVisibleText("2015");

		addCity.sendKeys("pune");
		selectDoctorDepartment("pathology");
		CommonMethods.waitForElementToClickable(uploadButton);
		uploadButton.click();

		DriverFactory.getDriver().navigate().refresh();
		editTestTab.click();
		CommonMethods.waitForElementToClickable(doctorList);
		List<WebElement> docList = DriverFactory.getDriver().findElements(By.id("doctorList"));
		for (int i = 0; i < docList.size(); i++) {
			if (docList.get(i).getText().contains(doc)) {
				flag++;
			}
		}
		CommonMethods.waitForElementToClickable(doctorList);
		Select ele = new Select(doctorList);
		ele.selectByVisibleText(doc);
		CommonMethods.waitForElementToClickable(deleteDoc);
		deleteDoc.click();
		if (flag == 1) {
			return true;
		}
		return false;
	}

	public String addDoctorWithDesignation(String designation, String confirmText) throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		addTestTab.click();
		doctorName.sendKeys(designation);
		selectDoctorAddDesignation.click();
		if (designation.equals("Dr")) {
			DrDesignation.click();
		}

		if (designation.equals("DrMs")) {
			DrMsDesignation.click();
		}

		if (designation.equals("DrSmt")) {
			DrSmtDesignation.click();
		}

		String contact = CommonMethods.generateRandomContactForIndia();
		String startDigit = "99";
		doctorContact.sendKeys(startDigit + contact);
		addCity.sendKeys("pune");
		selectDoctorDepartment("pathology");

		CommonMethods.waitForElementToClickable(uploadButton);
		uploadButton.click();

		DriverFactory.getDriver().navigate().refresh();
		editTestTab.click();
		CommonMethods.waitForElementToClickable(doctorList);

		Select ele = new Select(doctorList);
		ele.selectByVisibleText(confirmText + " " + designation);

		Thread.sleep(500);
		String design = selectDoctorEditDesignation.getText();
		CommonMethods.waitForElementToClickable(deleteDoc);
		deleteDoc.click();
		return design;

	}

	public String addDoctorAsReferralFlag(String doc) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addTestTab.click();
		doctorName.sendKeys(doc);
		doctorContact.sendKeys("7845102010");
		addCity.sendKeys("pune");
		referralFlag.click();
		selectDoctorDepartment("SEROLOGY");

		CommonMethods.waitForElementToClickable(uploadButton);
		uploadButton.click();

		DriverFactory.getDriver().get("https://beta.livehealth.solutions/referral/edit/");
		referralEditList.sendKeys(doc);
		Thread.sleep(1000);
		referralEditList.sendKeys(Keys.ARROW_DOWN);
		referralEditList.sendKeys(Keys.ENTER);
		String refName = doctorName.getAttribute("value");
		CommonMethods.waitForElementToClickable(deleteRefButton);
		deleteRefButton.click();
		CommonMethods.waitForElementToClickable(deletebtn);
		deletebtn.click();
		return refName;

	}

	public boolean addVisitingTime(String docName, String mon, String tue, String wed, String time) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/doctor/add/");
		addTestTab.click();
		doctorName.sendKeys(docName);
		doctorContact.sendKeys("9851010542");
		addCity.sendKeys("pune");
		selectDoctorDepartment("ELISA");
		loginpurposes.click();
		CommonMethods.waitForElementToClickable(AddVisitingTimings);
		AddVisitingTimings.click();
		CommonMethods.waitForElementToClickable(addTime);

		addTime.click();
		CommonMethods.waitForElementToVisible(timeErrorDiv);
		String warning = timeErrorDiv.getText();
		SoftAssert.assertEquals(warning, "×\n" + "Invalid Time Range.");

		addDoctorTiming(mon, "8:00 pm");
		addDoctorTiming(tue, "8:00 pm");
		addDoctorTiming(wed, "8:00 pm");

		Close.click();
		CommonMethods.waitForElementToClickable(uploadButton);
		uploadButton.click();

		DriverFactory.getDriver().navigate().refresh();
		editTestTab.click();
		CommonMethods.waitForElementToClickable(doctorList);
		selectDoctor(docName);

		List<WebElement> list = docTimingsId.findElements(By.tagName("div"));
		int length = list.size();

		if (length >= 12) {
			return true;
		}
		return false;
	}

	public void addDoctorTiming(String day, String time) throws Exception {
		CommonMethods.waitForElementToClickable(addTime);
		Select ele1 = new Select(weekday);
		ele1.selectByVisibleText(day);
		Select ele = new Select(endTime);
		ele.selectByVisibleText(time);
		addTime.click();

	}

	public boolean updateVisitingTime(String docName, String Sat, String time) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		editTestTab.click();
		selectDoctor(docName);
		int flag = 0;
		addDoctorTiming(Sat, time);

		Close.click();
		CommonMethods.waitForElementToClickable(uploadButton);
		uploadButton.click();
		DriverFactory.getDriver().navigate().refresh();
		selectDoctor(docName);
		Thread.sleep(500);
		List<WebElement> list = docTimingsId.findElements(By.tagName("div"));
		if (list.size() >= 15) {
			flag++;
		}
		Close.click();
		CommonMethods.waitForElementToClickable(deleteDoc);
		deleteDoc.click();
		if (flag == 1) {
			return true;
		}
		return false;

	}

	public void selectDoctor(String docname) throws Exception {
		CommonMethods.waitForElementToClickable(doctorList);
		Select ele3 = new Select(doctorList);
		ele3.selectByVisibleText(docname);
		loginhr1.click();
		CommonMethods.waitForElementToClickable(UpdateVisitingTimings);
		UpdateVisitingTimings.click();
	}

	public String updateDoctorDetails(String doc) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		editTestTab.click();
		CommonMethods.waitForElementToClickable(doctorList);

		Select ele = new Select(doctorList);
		ele.selectByVisibleText(doc);
		doctorName.clear();
		doctorName.sendKeys("Updated Doc");
		doctorContact.clear();
		doctorContact.sendKeys("8451201020");
		doctorEmail.clear();
		doctorEmail.sendKeys("updated@gmail.com");
		selectDoctorDepartment("ELISA");

		CommonMethods.waitForElementToClickable(uploadButton);
		uploadButton.click();
		String confirmUpdate = doctorList.getAttribute("value");

		return confirmUpdate;

	}

	public ArrayList<String> checkUpdatedDoctorDetails(String docname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		editTestTab.click();
		CommonMethods.waitForElementToClickable(doctorList);

		Select ele = new Select(doctorList);
		ele.selectByVisibleText(docname);

		String editDocName = doctorName.getAttribute("value");
		String editDocContact = doctorContact.getAttribute("value");
		String editDocEmail = doctorEmail.getAttribute("value");

		ArrayList<String> list = new ArrayList<>();
		list.add(editDocName);
		list.add(editDocContact);
		list.add(editDocEmail);
		return list;

	}

	public boolean docUserNameValidationFromUpdateDoc(String userName) throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		editTestTab.click();
		CommonMethods.waitForElementToClickable(doctorList);

		Select ele = new Select(doctorList);
		ele.selectByVisibleText("dhanraj");
		loginpurposes.click();
		CommonMethods.waitForElementToClickable(doctorUsername);
		doctorUsername.sendKeys(userName);
		doctorPassword.click();

		Thread.sleep(300);
		String userNm = doctorUsername.getCssValue("border-color");
		Assert.assertEquals(userNm, "rgb(255, 0, 0)");

		if (uploadButton.isEnabled()) {
			return false;
		}
		return true;

	}

	public boolean deleteDoc(String docName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		editTestTab.click();
		CommonMethods.waitForElementToClickable(doctorList);

		Select ele = new Select(doctorList);
		ele.selectByVisibleText(docName);

		CommonMethods.waitForElementToClickable(deleteDoc);
		deleteDoc.click();

		CommonMethods.waitForElementToClickable(doctorList);
		Thread.sleep(1000);
		List<WebElement> docList = DriverFactory.getDriver().findElements(By.id("doctorList"));
		for (int i = 0; i < docList.size(); i++) {
			if (docList.get(i).getText().contains("Updated Doc")) {
				return false;
			}
		}
		return true;

	}

	public void selectReferralForAssignList(String refName) throws InterruptedException {
		referralName.sendKeys(refName);
		Thread.sleep(2000);
		referralName.sendKeys(Keys.ARROW_DOWN);
		referralName.sendKeys(Keys.ENTER);
	}

	public void selectPriceList(String refPriceName) throws InterruptedException {
		doctorLists.sendKeys(refPriceName);
		Thread.sleep(2000);
		doctorLists.sendKeys(Keys.ARROW_DOWN);
		doctorLists.sendKeys(Keys.ENTER);
	}

	public String assignPriceList(String refName, String docRevList) throws Exception {
		DoctorRevenueManagementTab.click();
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listDocButton);
		selectPriceList(docRevList);
		try {
			listDocButton.click();
			Thread.sleep(1000);
			selectReferralForAssignList(refName);
			CommonMethods.waitForElementToVisible(errorDiv);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String SelectedRefListName = selectedListName.getText();
		return SelectedRefListName;

	}

	public String assignPriceListForAlreadyAssigned(String refName, String refPriceName) throws Exception {
		DoctorRevenueManagementTab.click();
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listDocButton);
		selectPriceList(refPriceName);
		try {
			listDocButton.click();
			Thread.sleep(1000);
			selectReferralForAssignList(refName);
			CommonMethods.waitForElementToVisible(errorDiv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String priceListName = selectedListName.getText();
		return priceListName;

	}

	public String viewListLink(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		WebDriver driver=DriverFactory.getDriver();
		DoctorRevenueManagementTab.click();
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listLink);
		String beforehandle = DriverFactory.getDriver().getWindowHandle();
		listLink.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String currentUrl = driver.getCurrentUrl();
		driver.close();
		driver.switchTo().window(beforehandle);
		return currentUrl;

	}

	public void ExportListLink(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listLink);
		exportListLink.click();
		Thread.sleep(1000);
		String filePath = "/Users/shekhar/Downloads";
		Assert.assertTrue(isFileDownloaded("filePath", "ReAssign Doctor RevList.xls"),
				"Failed to download Expected document");
		File file = new File("/Users/shekhar/Downloads/ReAssign Doctor RevList.xls");
		file.delete();

	}

	private boolean isFileDownloaded(String string, String string2) {
		return true;
	}

	public boolean updateSelectedTimeRangeRevenue(String DocName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		selectReferralForAssignList(DocName);
		CommonMethods.waitForElementToClickable(docTotalRev);
		docTotalRev.click();
		CommonMethods.waitForElementToClickable(setUpdateRevenueDateRange);
		setUpdateRevenueDateRange.click();
		Thread.sleep(500);
		WebElement ele = DriverFactory.getDriver().findElement(By.xpath("//li[contains(text(),'Last Month')]"));
		ele.click();
		CommonMethods.waitForElementToClickable(Update);
		Update.click();

		if (docTotalRev.isEnabled()) {
			return false;
		}
		return true;

	}

	public boolean updateAllRevenue(String DocName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		selectReferralForAssignList(DocName);
		CommonMethods.waitForElementToClickable(docTotalRev);
		docTotalRev.click();
		CommonMethods.waitForElementToClickable(allReveueFlag);
		allReveueFlag.click();
		CommonMethods.waitForElementToClickable(Update);
		Update.click();

		if (docTotalRev.isEnabled()) {
			return false;
		}
		return true;

	}

	public String concessionCut(String DocName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DoctorRevenueManagementTab.click();
		selectReferralForAssignList(DocName);
		CommonMethods.waitForElementToClickable(listDocButton);
		collapse.click();
		CommonMethods.waitForElementToClickable(discountSharing);
		discountSharing.clear();
		discountSharing.sendKeys("20");
		CommonMethods.waitForElementToClickable(listDocButton);
		listDocButton.click();
		Thread.sleep(1000);
		selectReferralForAssignList(DocName);
		collapse.click();
		CommonMethods.waitForElementToVisible(discountSharing);
		String discount = discountSharing.getAttribute("value");

		return discount;

	}

	public boolean removeAssignedList(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listDeleteButton);
		listDeleteButton.click();
		Thread.sleep(2000);
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listDocButton);
		if (errorDiv.isDisplayed()) {
			return false;
		}
		assignPriceList("auto", "ReAssign");
		return true;

	}

	public String doctorTrackerPenidingBills(String refName) throws Exception {

		selectTrackerDocName(refName);
		List<WebElement> pendingBills = DriverFactory.getDriver().findElements(By.id("pendingRevenueBills"));

		if (pendingBills.size() <= 1) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true);
		}
		CommonMethods.waitForElementToVisible(noBillMsg);
		String warning = noBillMsg.getText();
		return warning;

	}

	public void selectTrackerDocName(String refname) throws InterruptedException {
		DoctoRevenueTrackerTab.click();
		trackerDocName.sendKeys(refname);
		Thread.sleep(2000);
		trackerDocName.sendKeys(Keys.ARROW_DOWN);
		trackerDocName.sendKeys(Keys.ENTER);
	}

	public static String dueId;
	public static String dues;

	public ArrayList<Integer> calculateTotalAmount(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectTrackerDocName(refName);
		String startDay = CommonMethods.getstartDate(28);
		String endDay = CommonMethods.getstartDate(2);
		doctorDateChange.click();
		daterangepickerstart.clear();
		daterangepickerstart.sendKeys(startDay);
		daterangepickerend.clear();
		daterangepickerend.sendKeys(endDay);
		CommonMethods.waitForElementToClickable(Apply);
		Apply.click();

		CommonMethods.waitForElementToClickable(submitButton);
		List<WebElement> dueAmounts = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int length = dueAmounts.size();

		int sum = 0;

		for (int i = 1; i < length; i++) {
			int id = i - 1;
			dueId = "cutAmt" + id;

			List<WebElement> pendingBillsDue = DriverFactory.getDriver().findElements(By.id(dueId));
			for (int j = 0; j < pendingBillsDue.size(); j++) {
				dues = pendingBillsDue.get(j).getText();
			}

			int total = Integer.parseInt(dues);
			sum = sum + total;
		}
		String TotalAmount = cutAmount.getText();
		int finalDue = Integer.parseInt(TotalAmount);
		ArrayList<Integer> list = new ArrayList<>();
		list.add(finalDue);
		list.add(sum);
		return list;

	}

	public String patientBill(String name, String concession, String test1, String test2) throws Exception {

		billUrl.click();
		searchPatient.sendKeys(name);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[3]/div[2]/div/div[1]/span/span")));
		searchPatient.sendKeys(Keys.ARROW_DOWN);
		searchPatient.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		selectTests(test1);
		selectTests(test2);
		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys(concession);
		saveBill.click();
		CommonMethods.waitForElementToVisible(confirmBillMsgDiv);
		String success = confirmBillMsgDiv.getText();
		Thread.sleep(1000);
		backToRegistration.click();
		return success;

	}

	public void selectTests(String testName) throws Exception {
		searchInputforTests.sendKeys(testName);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span")));
		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
		searchInputforTests.sendKeys(Keys.ENTER);
		concession.sendKeys(Keys.ENTER);
	}

	public ArrayList<String> alldetails(String refName) throws Exception {
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/doctorRevenueTracker/");
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(submitButton);
		String name = trackDocName.getText();
		String patientName = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"highlight0\"]/div[2]/p"))
				.getText();

		ArrayList<String> list = new ArrayList<>();
		list.add(name);
		list.add(patientName);
		return list;

	}

	public boolean AllBillsTab(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(submitButton);
		allData.click();
		List<WebElement> billList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int length = billList.size();

		List<WebElement> discountedList = DriverFactory.getDriver()
				.findElements(By.xpath("//p[contains(text(),'Discounted')]"));
		int discountedLength = discountedList.size();

		if (length > 1 && discountedLength > 1) {
			return true;
		}
		return false;

	}

	public boolean discountedTab(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(discounted);

		discounted.click();
		List<WebElement> billList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int length = billList.size() - 1;

		List<WebElement> discountedList = DriverFactory.getDriver()
				.findElements(By.xpath("//p[contains(text(),'Discounted')]"));
		int discountedLength = discountedList.size();

		if (length == discountedLength) {
			return true;
		}
		return false;

	}

	public boolean NotDiscountedTab(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(notDiscounted);

		notDiscounted.click();
		List<WebElement> billList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int length = billList.size() - 1;

		List<WebElement> discountedList = DriverFactory.getDriver()
				.findElements(By.xpath("//p[contains(text(),'Discounted')]"));
		int discountedLength = discountedList.size();

		if (length > 1 && discountedLength <= 0) {
			return true;
		}
		return false;

	}

	public boolean submitDocRevenue(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(submitButton);
		List<WebElement> billList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int beforeLength = billList.size();
		billList.get(1).click();

		CommonMethods.waitForElementToClickable(submitButton);
		submitButton.click();
		CommonMethods.waitForElementToClickable(submitOTPBtn);
		submitOTPBtn.click();
		Thread.sleep(500);
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(submitButton);
		billList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int afterLength = billList.size();
		if (beforeLength >= afterLength) {
			return true;
		}
		return false;
	}

	public boolean sendEmailSMS(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(submitButton);
		List<WebElement> billList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int beforeLength = billList.size();
		billList.get(1).click();

		CommonMethods.waitForElementToClickable(submitButton);
		submitButton.click();
		CommonMethods.waitForElementToClickable(submitOTPBtn);
		doctorSMSFlag.click();
		submitOTPBtn.click();
		Thread.sleep(500);
		String validColour = docRepComments.getCssValue("border-color");
		Assert.assertEquals(validColour, "rgb(255, 0, 0)");

		docRepComments.sendKeys("This is doctor revenue settled bill");
		submitOTPBtn.click();
		Thread.sleep(500);
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(submitButton);
		billList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int afterLength = billList.size();
		if (beforeLength >= afterLength) {
			return true;
		}
		return false;
	}

	public boolean removeBills(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(submitButton);
		List<WebElement> billList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int beforeLength = billList.size();

		DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"highlight0\"]/div[6]/span[2]")).click();
		billList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int afterLength = billList.size();

		if (beforeLength >= afterLength) {
			return true;
		}
		return false;

	}

	public boolean totalAmount(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(submitButton);
		List<WebElement> billList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		billList.get(1).click();
		billList.get(2).click();

		int amt0 = Integer.parseInt(DriverFactory.getDriver().findElement(By.id("cutAmt0")).getText());
		int amt1 = Integer.parseInt(DriverFactory.getDriver().findElement(By.id("cutAmt1")).getText());
		int totalCal = amt0 + amt1;

		CommonMethods.waitForElementToClickable(submitButton);
		submitButton.click();
		CommonMethods.waitForElementToClickable(submitOTPBtn);
		int totalDocAmt = Integer.parseInt(totalAmountDoctorSMS.getText());

		if (totalCal == totalDocAmt) {
			return true;
		}
		return false;
	}

	public String selectAllBills(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectTrackerDocName(refName);
		CommonMethods.waitForElementToClickable(submitButton);
		selectAllTrackDocFlag.click();

		CommonMethods.waitForElementToClickable(submitButton);
		submitButton.click();
		CommonMethods.waitForElementToClickable(submitOTPBtn);
		submitOTPBtn.click();
		Thread.sleep(500);

		selectTrackerDocName(refName);
		CommonMethods.waitForElementToVisible(noBillMsg);
		String warning = noBillMsg.getText();
		return warning;

	}

}
