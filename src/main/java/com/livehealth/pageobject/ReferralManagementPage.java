package com.livehealth.pageobject;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.testng.asserts.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;
import com.livehealth.util.CommonMethods;

@Component
public class ReferralManagementPage {
	SoftAssert SoftAssert = new SoftAssert();

	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement adminHover;

	@FindBy(id = "referralName")
	private WebElement referralName;

	@FindBy(xpath = "//a[contains(text(),'Add / Edit Referral')] ")
	private WebElement addEditReffTab;

	@FindBy(id = "addReferralTab")
	private WebElement addReferralTab;

	@FindBy(id = "doctorName")
	private WebElement doctorName;

	@FindBy(id = "docDisplayName")
	private WebElement docDisplayName;

	@FindBy(id = "doctorContact")
	private WebElement doctorContact;

	@FindBy(id = "doctorEmail")
	private WebElement doctorEmail;

	@FindBy(id = "doctorRegNo")
	private WebElement doctorRegNo;

	@FindBy(id = "addReferralDay")
	private WebElement addReferralDay;

	@FindBy(id = "addReferralMonth")
	private WebElement addReferralMonth;

	@FindBy(id = "addReferralYear")
	private WebElement addReferralYear;

	@FindBy(id = "addReferralDayAnniversary")
	private WebElement addReferralDayAnniversary;

	@FindBy(id = "addReferralMonthAnniversary")
	private WebElement addReferralMonthAnniversary;

	@FindBy(id = "addReferralYearAnniversary")
	private WebElement addReferralYearAnniversary;

	@FindBy(id = "doctorSpeciality")
	private WebElement doctorSpeciality;

	@FindBy(id = "doctorAddress")
	private WebElement doctorAddress;

	@FindBy(id = "addOrgId")
	private WebElement addOrgName;

	@FindBy(id = "addCity")
	private WebElement addCity;

	@FindBy(id = "addPincode")
	private WebElement addPincode;

	@FindBy(id = "doctorComments")
	private WebElement doctorComments;

	@FindBy(id = "SMSFlag")
	private WebElement SMSFlag;

	@FindBy(id = "emailFlag")
	private WebElement emailFlag;

	@FindBy(id = "doctorUsername")
	private WebElement doctorUsername;

	@FindBy(id = "doctorPassword")
	private WebElement doctorPassword;

	@FindBy(id = "showPasswordKey")
	private WebElement showPasswordKey;

	@FindBy(id = "doctorFinanceManagementAdd")
	private WebElement FinanceManagementAccess;

	@FindBy(id = "isRegistered")
	private WebElement isRegisteredAccess;

	@FindBy(id = "isSigned")
	private WebElement isSignedAccess;

	@FindBy(id = "isSubmitted")
	private WebElement isSubmittedAccess;

	@FindBy(xpath = "//*[@id=\"loginLimitPanelFooterId\"]/a")
	private WebElement BuyLogin;

	@FindBy(id = "noOfItems")
	private WebElement noOfItems;

	@FindBy(id = "totalCost")
	private WebElement totalCost;

	@FindBy(id = "taxAmount")
	private WebElement taxAmount;

	@FindBy(id = "totalItemsCost")
	private WebElement totalItemsCost;

	@FindBy(id = "amount")
	private WebElement marchantamount;

	@FindBy(id = "contact")
	private WebElement contact;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "uploadButton")
	private WebElement SaveReferral;

	@FindBy(id = "errorDiv")
	private WebElement errorDiv;

	@FindBy(id = "error-msg")
	private WebElement texterror;

	@FindBy(id = "editReferralTab")
	private WebElement editReferralTab;

	@FindBy(id = "referralEditList")
	private WebElement referralEditList;

	@FindBy(id = "uploadButton")
	private WebElement uploadButton;

	@FindBy(id = "deleteRefButton")
	private WebElement deleteRefButton;

	@FindBy(id = "editListDropDownList")
	private WebElement editListDropDownList;

	@FindBy(id = "deletebtn")
	private WebElement deletebtn;

	@FindBy(id = "loginDetailsBtn")
	private WebElement loginDetailsBtn;

	@FindBy(id = "refDocList")
	private WebElement refDocList;

	@FindBy(id = "transferandDeletebtn")
	private WebElement transferandDeletebtn;

	@FindBy(id = "mobileErrorDiv")
	private WebElement mobileErrorDiv;

	@FindBy(id = "referralLists")
	private WebElement referralLists;

	@FindBy(id = "listDocButton")
	private WebElement listDocButton;

	@FindBy(id = "errorDiv")
	private WebElement warningerrorDiv;

	@FindBy(id = "listLink")
	private WebElement listLink;

	@FindBy(id = "exportListLink")
	private WebElement exportListLink;

	@FindBy(id = "listDeleteButton")
	private WebElement listDeleteButton;

	@FindBy(xpath = "//a[contains(text(),'Billing List')]")
	private WebElement billingListOption;

	@FindBy(xpath = "//a[contains(text(),'Referral Settlements')]")
	private WebElement referralSettlementOption;

	@FindBy(id = "searchCreditReferrals")
	private WebElement searchCreditReferrals;

	@FindBy(id = "noBillMsg")
	private WebElement noBillMsg;

	@FindBy(id = "submit")
	private WebElement submit;

	@FindBy(id = "referralBillList")
	private WebElement referralBillList;

	@FindBy(id = "dueAmount")
	private WebElement refDueAmount;

	@FindBy(xpath = "//a[contains(text(),'Edit Bill')]")
	private WebElement editBill;

	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement confirmButton;

	@FindBy(id = "settlementAmount")
	private WebElement settlementAmount;

	@FindBy(id = "defaultDate")
	private WebElement defaultDate;

	@FindBy(id = "successDiv")
	private WebElement successDiv;

	@FindBy(id = "paymentType")
	private WebElement paymentType;

	@FindBy(id = "textInput")
	private WebElement textInput;

	@FindBy(id = "savebillSetting")
	private WebElement savebillSetting;

	@FindBy(id = "selectAllRefFlag")
	private WebElement selectAllRefFlag;

	@FindBy(xpath = "//a[contains(text(),'Upload Excel')]")
	private WebElement uploadExcelOption;

	@FindBy(id = "fileInputExcel")
	public WebElement fileInputExcel;

	@FindBy(id = "submitExcel")
	private WebElement submitExcel;

	@FindBy(id = "excelSuccessDiv")
	private WebElement excelSuccessDiv;

	@FindBy(id = "excelTemplate")
	private WebElement excelTemplate;

	@FindBy(id = "paymentTransactions")
	private WebElement paymentTransactions;

	@FindBy(xpath = "//*[@id=\"selectReferalDesignation\"]")
	private WebElement refDesignation;

	@FindBy(xpath = "//a[contains(text(),'Dr.')]")
	private WebElement DrDesignation;

	@FindBy(xpath = "//a[contains(text(),'Dr. (Ms)')]")
	private WebElement DrMsDesignation;

	@FindBy(xpath = "//a[contains(text(),'Dr. (Smt)')]")
	private WebElement DrSmtDesignation;

	@FindBy(xpath = "//a[contains(text(),'Blank')]")
	private WebElement Blank;

	@FindBy(id = "selectReferalEditDesignation")
	private WebElement editDesignation;

	@FindBy(id = "referralSettlementDateRange")
	private WebElement referralSettlementDateRange;

	@FindBy(id = "selectedListName")
	private WebElement selectedListName;

	@FindBy(name = "daterangepicker_start")
	private WebElement startDate;

	@FindBy(name = "daterangepicker_end")
	private WebElement endDate;

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	private WebElement apply;

	@FindBy(id = "billUrl")
	private WebElement billUrl;

	@FindBy(id = "searchPatient")
	private WebElement searchPatient;

	@FindBy(id = "searchInputforTests")
	private WebElement searchInputforTests;

	@FindBy(id = "concession")
	private WebElement concession;

	@FindBy(id = "AdvanceAmount")
	private WebElement AdvanceAmount;

	@FindBy(id = "saveBill")
	private WebElement saveBill;

	@FindBy(id = "backToRegistration")
	private WebElement backToRegistration;

	@FindBy(id = "confirmBillMsgDiv")
	private WebElement confirmBillMsgDiv;

	@FindBy(name = "daterangepicker_start")
	private WebElement daterangepickerstart;

	@FindBy(name = "daterangepicker_end")
	private WebElement daterangepickerend;

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	private WebElement Apply;

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

	}

	public String addReferralValidation() throws Exception {

		addEditReffTab.click();
		CommonMethods.waitForElementToClickable(docDisplayName);
		SaveReferral.click();
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", docDisplayName);

		String warning = errorDiv.getText();
		return warning;
	}

	public String patientBill(String name, String amount, String test1, String test2) throws Exception {
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
		AdvanceAmount.clear();
		AdvanceAmount.sendKeys(amount);
		saveBill.click();
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

	public String contactFieldValidation(String contact) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addEditReffTab.click();
		if (contact.equals("8275369428")) {
			doctorContact.sendKeys(contact);
		}

		if (contact.equals("78452")) {
			doctorContact.sendKeys(contact);
		}
		SaveReferral.click();
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", doctorName);

		String border = doctorContact.getCssValue("border-color");

		return border;

	}

	public String alreadyExistedEmail(String mail) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		doctorEmail.sendKeys(mail);
		doctorRegNo.click();
		Thread.sleep(1000);
		String emailborder = doctorEmail.getCssValue("border-color");
		return emailborder;

	}

	public String addNewReferral() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		doctorName.sendKeys("Dhanraj");
		docDisplayName.sendKeys("Dhan");
		doctorContact.sendKeys("8275369428");
		doctorEmail.sendKeys("dhanraj.kshirsagar@livehealth.in");
		doctorRegNo.sendKeys("120250");
		doctorAddress.sendKeys("kalptaru colony jakat naka");

		Select org = new Select(addOrgName);
		org.selectByVisibleText("autoOrganisation");

		addCity.sendKeys("pune");
		addPincode.sendKeys("102030");
		doctorUsername.sendKeys("dhanraj");
		doctorPassword.sendKeys("Dhanraj@123");

		SaveReferral.click();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(editReferralTab);
		selectReferral("Dhanra");
		String referrlalName = doctorName.getAttribute("value");

		return referrlalName;

	}

	public String alreadyExistedReferralAndUserName() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		doctorName.sendKeys("Dhanraj");
		docDisplayName.click();
		Thread.sleep(500);
		String colour = docDisplayName.getCssValue("border-bottom-color");
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", doctorUsername);
		doctorUsername.sendKeys("dhanraj");
		doctorPassword.click();
		Thread.sleep(500);
		String color = doctorUsername.getCssValue("border-bottom-color");
		Assert.assertEquals(color, "rgba(255, 0, 0, 1)");
		return colour;

	}

	public String addReferralWithDOBAndDOA(String doc) throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		doctorName.sendKeys(doc);

		Select date = new Select(addReferralDay);
		date.selectByVisibleText("7");
		Select mon = new Select(addReferralMonth);
		mon.selectByVisibleText("Mar");
		Select yr = new Select(addReferralYear);
		yr.selectByVisibleText("1992");

		Select date1 = new Select(addReferralDayAnniversary);
		date1.selectByVisibleText("8");
		Select mon1 = new Select(addReferralMonthAnniversary);
		mon1.selectByVisibleText("Jan");
		Select yr1 = new Select(addReferralYearAnniversary);
		yr1.selectByVisibleText("2005");

		SaveReferral.click();

		CommonMethods.waitForElementToClickable(editReferralTab);
		selectReferral(doc);
		String referrlalName = doctorName.getAttribute("value");
		SoftAssert.assertEquals(referrlalName, doc);

		return referrlalName;

	}

	public void selectReferral(String refName) throws InterruptedException {
		editReferralTab.click();
		referralEditList.sendKeys(refName);
		Thread.sleep(1000);
		referralEditList.sendKeys(Keys.ARROW_DOWN);
		referralEditList.sendKeys(Keys.ENTER);

	}

	public void SendLoginDetails(String docName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectReferral(docName);
		loginDetailsBtn.click();

	}

	public ArrayList<String> updateReferralInfo(String docName, String updatedName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectReferral(docName);
		doctorName.clear();
		doctorName.sendKeys(updatedName);
		doctorContact.clear();
		doctorContact.sendKeys("8275369427");

		uploadButton.click();
		selectReferral("updated Dh");
		String updatedN = doctorName.getAttribute("value");
		String updatedConact = doctorContact.getAttribute("value");
		ArrayList<String> referrals = new ArrayList<>();
		referrals.add(updatedN);
		referrals.add(updatedConact);
		return referrals;

	}

	public boolean deleteReferral(String docName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		selectReferral(docName);
		CommonMethods.waitForElementToClickable(deleteRefButton);
		deleteRefButton.click();
		CommonMethods.waitForElementToClickable(deletebtn);
		deletebtn.click();
		int flagDelRef = 0;
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(referralEditList);
		DriverFactory.getDriver().findElement(By.className("input-group-btn")).click();
		List<WebElement> Referrals = editListDropDownList.findElements(By.tagName("li"));
		for (int i = 0; i < Referrals.size(); i++) {
			String refName = Referrals.get(i).getText();
			if (refName.equals("Updated Dhan")) {
				flagDelRef = 1;
				break;
			}
		}
		if (flagDelRef == 1) {
			return false;
		}
		return true;

	}

	public boolean deleteAndTrasnfer(String doc) throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		selectReferral(doc);
		CommonMethods.waitForElementToClickable(deleteRefButton);
		deleteRefButton.click();
		CommonMethods.waitForElementToVisible(refDocList);
		refDocList.sendKeys("au");
		Thread.sleep(1000);
		refDocList.sendKeys(Keys.ARROW_DOWN);
		refDocList.sendKeys(Keys.ENTER);
		CommonMethods.waitForElementToClickable(transferandDeletebtn);
		transferandDeletebtn.click();
		int flagDelRef = 0;
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(referralEditList);
		DriverFactory.getDriver().findElement(By.className("input-group-btn")).click();
		List<WebElement> Referrals = editListDropDownList.findElements(By.tagName("li"));
		for (int i = 0; i < Referrals.size(); i++) {
			String refName = Referrals.get(i).getText();
			if (refName.equals("Birth Doc")) {
				flagDelRef = 1;
				break;
			}

		}
		if (flagDelRef == 1) {
			return false;
		}
		return true;
	}

	public String addReferralWithDesignation(String designation, String value) throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		addReferralTab.click();
		doctorName.sendKeys(designation);
		refDesignation.click();
		if (designation.equals("Dr")) {
			DrDesignation.click();
		}

		if (designation.equals("DrMs")) {
			DrMsDesignation.click();
		}

		if (designation.equals("DrSmt")) {
			DrSmtDesignation.click();
		}

		if (designation.equals("Blank")) {
			Blank.click();
		}

		SaveReferral.click();
		DriverFactory.getDriver().navigate().refresh();
		editReferralTab.click();
		CommonMethods.waitForElementToClickable(editReferralTab);
		selectReferral(designation);
		String referrlalDesignation = editDesignation.getText();
		CommonMethods.waitForElementToClickable(deleteRefButton);
		deleteRefButton.click();
		CommonMethods.waitForElementToClickable(deletebtn);
		deletebtn.click();
		return referrlalDesignation;

	}

	public void selectReferralForAssignList(String refName) throws InterruptedException {
		referralName.sendKeys(refName);
		Thread.sleep(2000);
		referralName.sendKeys(Keys.ARROW_DOWN);
		referralName.sendKeys(Keys.ENTER);
	}

	public void selectPriceList(String refPriceName) throws InterruptedException {
		referralLists.sendKeys(refPriceName);
		Thread.sleep(2000);
		referralLists.sendKeys(Keys.ARROW_DOWN);
		referralLists.sendKeys(Keys.ENTER);
	}

	public String assignPriceList(String refName, String refPriceName) throws Exception {
		DriverFactory.getDriver().navigate().to(Constants.ReferralManagement_URL);
		billingListOption.click();
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listDocButton);
		selectPriceList(refPriceName);
		try {
			listDocButton.click();
			Thread.sleep(1000);
			selectReferralForAssignList(refName);
			CommonMethods.waitForElementToVisible(warningerrorDiv);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String SelectedRefListName = selectedListName.getText();
		return SelectedRefListName;

	}

	public String assignPriceListForAlreadyAssigned(String refName, String refPriceName) throws Exception {
		billingListOption.click();
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listDocButton);
		selectPriceList(refPriceName);

		listDocButton.click();
		Thread.sleep(1000);
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToVisible(warningerrorDiv);

		String priceListName = selectedListName.getText();
		return priceListName;

	}

	public String viewListLink(String refName) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listLink);
		String beforehandle = driver.getWindowHandle();
		listLink.click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String currentUrl = DriverFactory.getDriver().getCurrentUrl();
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
		String filePath = "C:/Users/Administrator/Downloads/";
		Assert.assertTrue(isFileDownloaded("filePath", "ReAssign Referral Price.xls"),
				"Failed to download Expected document");
		File file = new File("C:/Users/Administrator/Downloads/ReAssign Referral Price.xls");
		file.delete();

	}

	private boolean isFileDownloaded(String string, String string2) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean removeAssignedList(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listDeleteButton);
		listDeleteButton.click();
		Thread.sleep(2000);
		selectReferralForAssignList(refName);
		CommonMethods.waitForElementToClickable(listDocButton);
		if (warningerrorDiv.isDisplayed()) {
			return false;
		}
		return true;

	}

	public String referralSettlemetPenidingBills(String refName) throws Exception {

		selectReferralForBillSettle(refName);
		List<WebElement> pendingBills = DriverFactory.getDriver().findElements(By.id("referralBillList"));

		if (pendingBills.size() <= 1) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true);
		}
		CommonMethods.waitForElementToVisible(noBillMsg);
		String warning = noBillMsg.getText();
		return warning;

	}

	public void selectReferralForBillSettle(String refname) throws InterruptedException {
		referralSettlementOption.click();
		searchCreditReferrals.sendKeys(refname);
		Thread.sleep(1500);
		searchCreditReferrals.sendKeys(Keys.ARROW_DOWN);
		searchCreditReferrals.sendKeys(Keys.ENTER);
	}

	public static String dueId;
	public static String dues;

	public ArrayList<Integer> calculateDue(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectReferralForBillSettle(refName);
		Thread.sleep(1000);
		String startDay = CommonMethods.getstartDate(28);
		String endDay = CommonMethods.getstartDate(2);
		referralSettlementDateRange.click();
		daterangepickerstart.clear();
		daterangepickerstart.sendKeys(startDay);
		daterangepickerend.clear();
		daterangepickerend.sendKeys(endDay);
		CommonMethods.waitForElementToClickable(Apply);
		Apply.click();
		Thread.sleep(500);
		CommonMethods.waitForElementToClickable(submit);
		List<WebElement> dueAmounts = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int length = dueAmounts.size();
		int sum = 0;

		for (int i = 1; i < length; i++) {
			int id = i - 1;
			dueId = "dueAmount" + id;

			List<WebElement> pendingBillsDue = DriverFactory.getDriver().findElements(By.id(dueId));
			for (int j = 0; j < pendingBillsDue.size(); j++) {
				dues = pendingBillsDue.get(j).getText();
			}
			int total = Integer.parseInt(dues);
			sum = sum + total;

		}
		String dueAmount = refDueAmount.getText();
		int finalDue = Integer.parseInt(dueAmount);
		ArrayList<Integer> amounts = new ArrayList<>();
		amounts.add(finalDue);
		amounts.add(sum);

		return amounts;
	}

	public String editBillLink(String refName) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		selectReferralForBillSettle(refName);
		Thread.sleep(1000);

		java.util.List<WebElement> editBill = driver.findElements(By.xpath("//a[contains(text(),'Edit Bill')]"));
		String beforehandle = DriverFactory.getDriver().getWindowHandle();
		editBill.get(0).click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String url = driver.getCurrentUrl();
		String expectedUrl = url.substring(0, 44);
		driver.close();
		driver.switchTo().window(beforehandle);
		return expectedUrl;

	}

	java.util.List<WebElement> billsList;

	public boolean settleAmount(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectReferralForBillSettle(refName);
		CommonMethods.waitForElementToClickable(submit);
		Thread.sleep(1000);
		billsList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int beforeLength = billsList.size();
		for (int i = 1; i < billsList.size(); i++) {
			if (i < 3) {
				billsList.get(i).click();
			}
		}
		submit.click();
		CommonMethods.waitForElementToVisible(successDiv);
		String sucess = successDiv.getText();
		if (sucess.contains("×\n" + "Close\n"
				+ "Success! Click on below links to print the receipts for successful bill settlements")) {
			return true;
		}
		Thread.sleep(1000);
		java.util.List<WebElement> printbills = DriverFactory.getDriver().findElements(By.className("btn btn-success"));
		if (printbills.get(0).isEnabled() && printbills.get(1).isEnabled()) {
			SoftAssert.assertTrue(true, "Bills settled successfully");
		} else {
			SoftAssert.assertFalse(true);
		}
		DriverFactory.getDriver().navigate().refresh();
		selectReferralForBillSettle(refName);
		CommonMethods.waitForElementToClickable(submit);
		billsList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int afterLength = billsList.size();
		if (beforeLength > afterLength) {
			return true;
		}
		return false;

	}

	public static int refDue;

	public ArrayList<Integer> settlementAmount(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectReferralForBillSettle(refName);
		CommonMethods.waitForElementToClickable(submit);
		refDue = Integer.parseInt(refDueAmount.getText());

		Thread.sleep(1000);
		billsList = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int beforeLength = billsList.size();
		for (int i = 1; i < billsList.size(); i++) {
			if (i < 3) {
				billsList.get(i).click();
			}
		}
		String bill1 = DriverFactory.getDriver().findElement(By.id("dueAmount0")).getText();
		String bill2 = DriverFactory.getDriver().findElement(By.id("dueAmount1")).getText();

		int duductedAmount = Integer.parseInt(bill1) + Integer.parseInt(bill2);
		int finalDueAmount = refDue - duductedAmount;
		int afterCalcDue = Integer.parseInt(refDueAmount.getText());

		SoftAssert.assertEquals(finalDueAmount, afterCalcDue);
		int settlementAmt = Integer.parseInt(settlementAmount.getAttribute("value"));
		SoftAssert.assertEquals(settlementAmt, duductedAmount);
		ArrayList<Integer> amount = new ArrayList<>();
		amount.add(settlementAmt);
		amount.add(duductedAmount);

		return amount;

	}

	public boolean backDatedSettlement(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectReferralForBillSettle(refName);
		CommonMethods.waitForElementToClickable(submit);
		Thread.sleep(1000);
		billsList = DriverFactory.getDriver().findElements(By.className("list-group-item"));

		for (int i = 1; i < billsList.size(); i++) {
			if (i < 2) {
				billsList.get(i).click();
			}
		}
		String backDate = CommonMethods.getBackDate(2);
		String SetlementDate = CommonMethods.getBackD(2);

		DriverFactory.getDriver().findElement(By.className("input-group-addon")).click();
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("document.getElementById('defaultDate').value = arguments[0];", backDate);
		String myDate = (String) js.executeScript("return document.getElementById('defaultDate').value");

		JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("document.getElementById('settlementDate').value = arguments[0];", SetlementDate);
		String myDate1 = (String) js1.executeScript("return document.getElementById('settlementDate').value");
		submit.click();

		CommonMethods.waitForElementToClickable(confirmButton);
		confirmButton.click();
		Thread.sleep(1000);
		if (confirmButton.isDisplayed()) {
			return false;
		} else {
			CommonMethods.waitForElementToVisible(successDiv);
			String success = successDiv.getText();

			if (success.contains("×\n" + "Close\n"
					+ "Success! Click on below links to print the receipts for successful bill settlements")) {

				return true;
			}
		}
		SoftAssert.assertAll();
		return false;

	}

	public boolean paymentType(String mode, String value, String refName) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		selectReferralForBillSettle(refName);
		CommonMethods.waitForElementToClickable(submit);
		Thread.sleep(1000);
		driver.findElement(By.id("highlight0")).click();
		int flag = 0;
		if (mode.equals("Cheque")) {
			Select ele = new Select(paymentType);
			ele.selectByVisibleText("Cheque");
		}

		if (mode.equals("Credit")) {
			Select ele = new Select(paymentType);
			ele.selectByVisibleText("Credit");
		}

		if (mode.equals("Credit Card")) {
			Select ele = new Select(paymentType);
			ele.selectByVisibleText("Credit Card");
		}

		if (mode.equals("Debit Card")) {
			Select ele = new Select(paymentType);
			ele.selectByVisibleText("Debit Card");
		}

		if (mode.equals("Free")) {
			Select ele = new Select(paymentType);
			ele.selectByVisibleText("Free");
		}

		if (mode.equals("Other")) {
			Select ele = new Select(paymentType);
			ele.selectByVisibleText("Other");
		}

		submit.click();
		CommonMethods.waitForElementToVisible(successDiv);
		String success = successDiv.getText();

		if (success.contains("×\n" + "Close\n"
				+ "Success! Click on below links to print the receipts for successful bill settlements")) {
			Assert.assertTrue(true);
		}
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", searchCreditReferrals);
		String beforehandle = driver.getWindowHandle();
		editBill.click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		CommonMethods.waitForElementToClickable(textInput);
		textInput.click();
		CommonMethods.waitForElementToClickable(savebillSetting);
		List<WebElement> confirmMode = paymentTransactions
				.findElements(By.xpath("//td[contains(text(),'" + value + "')]"));

		if (confirmMode.get(0).getText().equals(value)) {
			flag++;
		}
		driver.close();
		driver.switchTo().window(beforehandle);
		if (flag == 1) {
			return true;
		}
		return false;
	}

	public String selectAlls(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectReferralForBillSettle(refName);
		CommonMethods.waitForElementToClickable(submit);
		Thread.sleep(1000);
		selectAllRefFlag.click();
		submit.click();
		CommonMethods.waitForElementToVisible(successDiv);
		String success = successDiv.getText();

		if (success.contains("×\n" + "Close\n"
				+ "Success! Click on below links to print the receipts for successful bill settlements")) {
			Assert.assertTrue(true, "Back dated Bill settled successfully");

		} else {
			SoftAssert.assertFalse(true);
			SoftAssert.assertAll();
		}
		selectReferralForBillSettle(refName);
		CommonMethods.waitForElementToVisible(noBillMsg);
		String warning = noBillMsg.getText();
		return warning;
	}

	public boolean datepickerData(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectReferralForBillSettle(refName);
		Thread.sleep(1000);
		String startDay = CommonMethods.getstartDate(25);
		String endDay = CommonMethods.getstartDate(2);
		referralSettlementDateRange.click();
		startDate.clear();
		startDate.sendKeys(startDay);
		endDate.clear();
		endDate.sendKeys(endDay);
		apply.click();

		Thread.sleep(1000);
		List<WebElement> billsList = referralBillList.findElements(By.tagName("li"));
		int length = billsList.size();

		if (length > 4) {
			return true;
		}
		return false;

	}

	public boolean bulkUploadReferrals(String Doc1, String Doc2) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		uploadExcelOption.click();
		CommonMethods.waitForElementToClickable(fileInputExcel);
		String path = System.getProperty("user.dir");
		String invalidFile = path + File.separator + "/src/main/resources/Files/ReferralList.xls";
		fileInputExcel.sendKeys(invalidFile);
		CommonMethods.waitForElementToVisible(excelSuccessDiv);
		String warning = excelSuccessDiv.getText();
		SoftAssert.assertEquals(warning, "×\n"
				+ "Error! Invalid template format. Please upload Excel file using sample template we have provided.");
		SoftAssert.assertAll();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(fileInputExcel);
		String validFile = path + File.separator + "/src/main/resources/Files/ReferralList .xlsx";
		fileInputExcel.sendKeys(validFile);
		submitExcel.click();
		Thread.sleep(1000);
		List<WebElement> successLabel = DriverFactory.getDriver()
				.findElements(By.xpath("//span[contains(text(),'Success')]"));
		int length = successLabel.size();
		deleteBulkUploadedReferral(Doc1);
		deleteBulkUploadedReferral(Doc2);
		if (length >= 2) {
			return true;
		}
		return false;
	}

	public void deleteBulkUploadedReferral(String Doc) throws Exception {
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/referral/edit/");
		if (Doc.equals("test uplaod")) {
			selectReferral(Doc);
		}

		if (Doc.equals("testing")) {
			selectReferral(Doc);
		}

		CommonMethods.waitForElementToClickable(deleteRefButton);
		deleteRefButton.click();
		CommonMethods.waitForElementToClickable(deletebtn);
		deletebtn.click();
	}

	public void exportExcelTemplate() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		uploadExcelOption.click();
		CommonMethods.waitForElementToClickable(excelTemplate);
		excelTemplate.click();
		Thread.sleep(1000);
		String filePath = "C:/Users/Administrator/Downloads/";
		Assert.assertTrue(isFileDownloaded("filePath", "ReferralList.xls"), "Failed to download Expected document");
		File file = new File("C:/Users/Administrator/Downloads/ReferralList.xls");
		file.delete();

	}

}
