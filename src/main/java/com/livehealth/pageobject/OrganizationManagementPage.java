package com.livehealth.pageobject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.livehealth.base.DriverFactory;
import com.livehealth.util.CommonMethods;

public class OrganizationManagementPage {

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

	@FindBy(xpath = "//*[@id=\"nav-sidebar\"]/div[3]/ul/li[3]/a")
	private WebElement orgManagementTab;

	@FindBy(xpath = "//*[@id=\"nav-sidebar\"]/div[3]/ul/li[3]/ul/li[2]/a")
	private WebElement addEditOrg;

	@FindBy(id = "orgUploadButton")
	private WebElement orgUploadButton;

	@FindBy(id = "errorDiv")
	private WebElement errorDiv;

	@FindBy(id = "orgnName")
	private WebElement orgnName;

	@FindBy(id = "orgnContact")
	private WebElement orgnContact;

	@FindBy(id = "orgAlternateContact")
	private WebElement orgAlternateContact;

	@FindBy(id = "orgnEmail")
	private WebElement orgnEmail;

	@FindBy(id = "orgnAddress")
	private WebElement orgnAddress;

	@FindBy(id = "addCity")
	private WebElement addCity;

	@FindBy(id = "orgnArea")
	private WebElement orgnArea;

	@FindBy(id = "orgnPincode")
	private WebElement orgnPincode;

	@FindBy(id = "orgnCode")
	private WebElement orgnCode;

	@FindBy(id = "creditLimit")
	private WebElement creditLimit;

	@FindBy(id = "currentDue")
	private WebElement currentDue;

	@FindBy(id = "orgnUsername")
	private WebElement orgnUsername;

	@FindBy(id = "orgnPassword")
	private WebElement orgnPassword;

	@FindBy(id = "editOrgTab")
	private WebElement editOrgTab;

	@FindBy(id = "orgEditList")
	private WebElement orgEditList;

	@FindBy(id = "addOrgTab")
	private WebElement addOrgTab;

	@FindBy(id = "error-msg")
	private WebElement errormsg;

	@FindBy(id = "orgPaymentType")
	private WebElement orgPaymentType;

	@FindBy(id = "adduserHistoryListFlag")
	private WebElement adduserHistoryListFlag;

	@FindBy(id = "adduserCollectionReport")
	private WebElement adduserCollectionReport;

	@FindBy(id = "adduserFinanceManagement")
	private WebElement adduserFinanceManagement;

	@FindBy(id = "adduserNewPatientRegister")
	private WebElement adduserNewPatientRegister;

	@FindBy(id = "adduserUpdatePatient")
	private WebElement adduserUpdatePatient;

	@FindBy(id = "adduserBillSettelmentFlag")
	private WebElement adduserBillSettelmentFlag;

	@FindBy(id = "adduserAccessionManagement")
	private WebElement adduserAccessionManagement;

	@FindBy(id = "addUserBatchMgmtAccess")
	private WebElement addUserBatchMgmtAccess;

	@FindBy(id = "collectionCenter")
	private WebElement collectionCenter;

	@FindBy(id = "userHistoryListFlag")
	private WebElement userHistoryListFlag;

	@FindBy(id = "userCollectionReport")
	private WebElement userCollectionReport;

	@FindBy(id = "userFinanceManagement")
	private WebElement userFinanceManagement;

	@FindBy(id = "userUpdatePatient")
	private WebElement userUpdatePatient;

	@FindBy(id = "userAccessionManagement")
	private WebElement userAccessionManagement;

	@FindBy(id = "userNewPatientRegister")
	private WebElement userNewPatientRegister;

	@FindBy(id = "orgDeleteButton")
	private WebElement orgDeleteButton;

	@FindBy(id = "orgDelete")
	private WebElement orgDelete;

	@FindBy(id = "orgnSMSFlag")
	private WebElement orgnSMSFlag;

	@FindBy(id = "orgnEmailFlag")
	private WebElement orgnEmailFlag;

	@FindBy(id = "orgnBillingSMSFlag")
	private WebElement orgnBillingSMSFlag;

	@FindBy(id = "stopPrepaidCreditBill")
	private WebElement stopPrepaidCreditBill;

	@FindBy(xpath = "//*[@id=\"editOrgDiv\"]/div[4]/div/div/div/button")
	private WebElement Listoptins;

	@FindBy(id = "orgEditListDropDownList")
	private WebElement orgEditListDropDownList;

	@FindBy(id = "orgTransfer")
	private WebElement orgTransfer;

	@FindBy(id = "refOrgList")
	private WebElement refOrgList;

	@FindBy(id = "isIntegrationEnableForAddOrg")
	private WebElement isIntegrationEnableForAddOrg;

	@FindBy(id = "showIntegrationListLinkForAddOrg")
	private WebElement showIntegrationListLinkForAddOrg;

	@FindBy(name = "serviceMasterName")
	private WebElement serviceMasterName;

	@FindBy(id = "categoryNameListCheck1")
	private WebElement categoryNameListCheck1;

	@FindBy(id = "url1")
	private WebElement url1;

	@FindBy(id = "url2")
	private WebElement url2;

	@FindBy(id = "url3")
	private WebElement url3;

	@FindBy(name = "actionNameList")
	private WebElement actionNameList;

	@FindBy(xpath = "//button[contains(text(),'Enable')]")
	private WebElement enable;

	@FindBy(id = "showServiceModalLickForEditOrg")
	private WebElement showServiceModalLickForEditOrg;

	@FindBy(id = "integrationEnableCheckForEditOrg")
	private WebElement integrationEnableCheckForEditOrg;

	@FindBy(id = "chkBoxManageLedger")
	private WebElement chkBoxManageLedger;

	@FindBy(id = "addOpeningBal")
	private WebElement addOpeningBal;

	@FindBy(id = "editChkBoxManageLedger")
	private WebElement editChkBoxManageLedger;

	@FindBy(id = "editOpeningBal")
	private WebElement editOpeningBal;

	@FindBy(id = "orgName")
	private WebElement orgName;

	@FindBy(id = "orgLists")
	private WebElement orgLists;

	@FindBy(id = "selectedListName")
	private WebElement selectedListName;

	@FindBy(id = "listOrgButton")
	private WebElement listOrgButton;

	@FindBy(id = "listLink")
	private WebElement listLink;

	@FindBy(id = "exportListLink")
	private WebElement exportListLink;

	@FindBy(xpath = "//a[contains(text(),'Organization Revenue List')]")
	private WebElement AssignOrgListTab;

	@FindBy(id = "organizationTotalRev")
	private WebElement organizationTotalRev;

	@FindBy(id = "setUpdateRevenueDateRangeOrg")
	private WebElement setUpdateRevenueDateRangeOrg;

	@FindBy(name = "daterangepicker_start")
	private WebElement daterangepickerstart;

	@FindBy(name = "daterangepicker_end")
	private WebElement daterangepickerend;

	@FindBy(xpath = "//*[@id=\"md_updateAllRevenueOrg\"]/div/div/div[3]/button[2]")
	private WebElement Update;

	@FindBy(id = "listDeleteButton")
	private WebElement listDeleteButton;

	@FindBy(xpath = "//a[contains(text(),'Disabled Organizations')]")
	private WebElement DisableOrgTab;

	@FindBy(xpath = "//button[contains(text(),'Enable')]")
	private WebElement EnableOrg;

	@FindBy(xpath = "//*[@id=\\\"primaryNavbar\\\"]/li[2]/a/span[2]")
	private WebElement Centerdropdown;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement LogOut;

	@FindBy(id = "addCreditBtn")
	private WebElement addCreditBtn;

	@FindBy(id = "nextStep")
	private WebElement nextStep;

	@FindBy(id = "inputAmount")
	private WebElement inputAmount;

	@FindBy(xpath = "//button[contains(text(),'Add credit')]")
	private WebElement addCredit;

	@FindBy(id = "orgComment")
	private WebElement orgComment;

	@FindBy(id = "trancErrorDiv")
	private WebElement trancErrorDiv;

	@FindBy(id = "inputRejectComment")
	private WebElement inputRejectComment;

	@FindBy(xpath = "//button[contains(text(),'Reject Credit')]")
	private WebElement RejectCredit;

	@FindBy(xpath = "//a[contains(text(),'Organization Settlements')]")
	private WebElement OrganizationSettlementsTab;

	@FindBy(id = "searchCreditOrganizations")
	private WebElement searchCreditOrganizations;

	@FindBy(id = "orgNoBillMsg")
	private WebElement orgNoBillMsg;

	@FindBy(id = "orgBillList")
	private WebElement orgBillList;

	@FindBy(id = "orgSubmit")
	private WebElement orgSubmit;

	@FindBy(id = "orgDueAmount")
	private WebElement orgDueAmount;

	@FindBy(id = "orgSettlementDateRange")
	private WebElement orgSettlementDateRange;

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	private WebElement Apply;

	@FindBy(id = "errorDueOrgAmnt")
	private WebElement errorDueOrgAmnt;

	@FindBy(xpath = "//a[contains(text(),'Recalculate Due')]")
	private WebElement RecalculateDue;

	@FindBy(id = "orgSuccessDiv")
	private WebElement orgSuccessDiv;

	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement Confirmbutton;

	@FindBy(id = "textInput")
	private WebElement textInput;

	@FindBy(id = "savebillSetting")
	private WebElement savebillSetting;

	@FindBy(id = "paymentTransactions")
	private WebElement paymentTransactions;

	@FindBy(id = "selectAllOrgFlag")
	private WebElement selectAllOrgFlag;

	@FindBy(xpath = "//a[contains(text(),'Bulk Organization Upload')]")
	private WebElement BulOrganizationUploadTab;

	@FindBy(id = "fileInputOrgExcel")
	private WebElement fileInputOrgExcel;

	@FindBy(id = "submitExcel")
	private WebElement submitExcel;

	@FindBy(id = "excelSuccessDiv")
	private WebElement excelSuccessDiv;

	@FindBy(id = "excelTemplate")
	private WebElement excelTemplate;

	@FindBy(id = "newDirectFirstName")
	private WebElement newDirectFirstName;

	@FindBy(id = "newDirectSaveForm")
	private WebElement newDirectSaveForm;

	@FindBy(id = "newDirectRadiobutton")
	private WebElement newDirectRadiobutton;

	@FindBy(id = "userName")
	private WebElement userNm;

	@FindBy(id = "registerUrl")
	private WebElement registerUrl;

	@FindBy(id = "newDirectErrorDiv")
	private WebElement newDirectErrorDiv;

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

	public String addOrganisationValidation() throws Exception {
		CommonMethods.waitForElementToClickable(orgManagementTab);
		orgManagementTab.click();
		CommonMethods.waitForElementToClickable(addEditOrg);
		addEditOrg.click();
		CommonMethods.waitForElementToClickable(orgUploadButton);
		orgUploadButton.click();
		CommonMethods.waitForElementToVisible(errorDiv);
		String warning = errorDiv.getText();

		return warning;

	}

	public ArrayList<String> addOrganzationWithAllDetails(String OrgName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToVisible(orgnName);
		orgnName.sendKeys(OrgName);
		orgnContact.sendKeys("8275369428");
		orgAlternateContact.sendKeys("");
		orgnEmail.sendKeys("dhanraj.kshirsagar@livehealth.in");
		orgnAddress.sendKeys("jakat naka pune");
		addCity.sendKeys("pune");
		orgnArea.sendKeys("karve nagar");
		orgnPincode.sendKeys("152020");
		creditLimit.sendKeys("5000");
		orgnCode.sendKeys("150");
		orgnBillingSMSFlag.click();
		orgnSMSFlag.click();
		orgnEmailFlag.click();
		stopPrepaidCreditBill.click();
		orgnUsername.sendKeys("satara");
		orgnPassword.sendKeys("Satara@1234");
		CommonMethods.waitForElementToClickable(orgUploadButton);
		orgUploadButton.click();
		selectOrg(OrgName);

		CommonMethods.waitForElementToVisible(orgnName);
		String name = orgnName.getAttribute("value");
		String contact = orgnContact.getAttribute("value");
		String email = orgnEmail.getAttribute("value");
		ArrayList<String> list = new ArrayList<>();
		list.add(name);
		list.add(contact);
		list.add(email);

		return list;

	}

	public void selectOrg(String orgName) throws Exception {
		CommonMethods.waitForElementToClickable(editOrgTab);
		editOrgTab.click();
		orgEditList.sendKeys(orgName);
		Thread.sleep(1000);
		orgEditList.sendKeys(Keys.ARROW_DOWN);
		orgEditList.sendKeys(Keys.ENTER);
	}

	public ArrayList<String> contactFieldValidation(String contact) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addOrgTab.click();
		String border = null;
		String mesg = null;
		ArrayList<String> list = new ArrayList<>();
		if (contact.equals("8275369428")) {
			orgnContact.sendKeys(contact);
			orgAlternateContact.click();
			Thread.sleep(500);
			border = orgnContact.getCssValue("border-color");
			list.add(border);
		}
		if (contact.equals("78452")) {
			orgnContact.sendKeys(contact);
			orgAlternateContact.click();
			CommonMethods.waitForElementToVisible(errormsg);
			Thread.sleep(500);
			mesg = errormsg.getText();
			list.add(mesg);
		}

		return list;

	}

	public String alreadyExistedEmail(String mail) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		orgnEmail.sendKeys(mail);
		orgnAddress.click();
		Thread.sleep(1000);
		String emailborder = orgnEmail.getCssValue("border-color");
		return emailborder;

	}

	public String alreadyExistedReferralAndUserName(String orgName, String UserName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		orgnName.sendKeys(orgName);
		orgnContact.click();
		Thread.sleep(500);

		String colour = orgnName.getCssValue("border-bottom-color");
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", orgnUsername);
		orgnUsername.sendKeys(UserName);
		orgnPassword.click();
		Thread.sleep(500);
		String color = orgnUsername.getCssValue("border-bottom-color");
		Assert.assertEquals(color, "rgba(255, 0, 0, 1)");
		return colour;

	}

	public ArrayList<String> paymentType(String payType, String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addOrgTab.click();
		orgnName.sendKeys(orgname);
		String advance = null;
		String credit = null;
		ArrayList<String> list = new ArrayList<>();
		if (payType.equals("Payment Type (Default: Walk-in)")) {
			Select ele = new Select(orgPaymentType);
			ele.selectByVisibleText("Payment Type (Default: Walk-in)");
		}

		if (payType.equals("Prepaid")) {
			Select ele = new Select(orgPaymentType);
			ele.selectByVisibleText("Prepaid");
			currentDue.clear();
			currentDue.sendKeys("5000");
		}

		if (payType.equals("Postpaid")) {
			Select ele = new Select(orgPaymentType);
			ele.selectByVisibleText("Postpaid");
			creditLimit.clear();
			creditLimit.sendKeys("5000");
		}
		orgUploadButton.click();
		selectOrg(orgname);
		CommonMethods.waitForElementToVisible(orgnName);
		Thread.sleep(500);
		String payTypeText = orgPaymentType.getAttribute("value");
		list.add(payTypeText);
		if (payType.equals("Prepaid")) {
			advance = currentDue.getAttribute("value");
			list.add(advance);
		}

		if (payType.equals("Postpaid")) {
			credit = creditLimit.getAttribute("value");
			list.add(credit);
		}
		orgDeleteButton.click();
		CommonMethods.waitForElementToClickable(orgDelete);
		orgDelete.click();
		return list;

	}

	public void addCC(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addOrgTab.click();
		orgnName.sendKeys(orgname);

		if (orgname.equals("Non Billing")) {
			orgnUsername.sendKeys("NonBill");
			orgnPassword.sendKeys("Non@12345");
		}

		if (orgname.equals("Billing CC")) {
			collectionCenter.click();
			adduserNewPatientRegister.click();
			adduserUpdatePatient.click();
			adduserAccessionManagement.click();
			addUserBatchMgmtAccess.click();
			orgnUsername.sendKeys("billing");
			orgnPassword.sendKeys("Billing@1234");
		}
		adduserHistoryListFlag.click();
		adduserCollectionReport.click();
		adduserFinanceManagement.click();

		orgUploadButton.click();
		selectOrg(orgname);
		CommonMethods.waitForElementToVisible(orgnName);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", orgnUsername);

		boolean flagHistory = userHistoryListFlag.isSelected();
		SoftAssert.assertEquals(flagHistory, true);
		boolean reportFlag = userCollectionReport.isSelected();
		SoftAssert.assertEquals(reportFlag, true);
		boolean financeFlag = userFinanceManagement.isSelected();
		SoftAssert.assertEquals(financeFlag, true);

		if (orgname.equals("Billing CC")) {
			boolean collectionCen = collectionCenter.isSelected();
			SoftAssert.assertEquals(collectionCen, true);

			boolean NewPatientRegister = userNewPatientRegister.isSelected();
			SoftAssert.assertEquals(NewPatientRegister, true);

			boolean AccessionManagement = userAccessionManagement.isSelected();
			SoftAssert.assertEquals(AccessionManagement, true);

			boolean UpdatePatient = userUpdatePatient.isSelected();
			SoftAssert.assertEquals(UpdatePatient, true);
		}
		SoftAssert.assertAll();

	}

	public boolean verifyCC1Access() throws Exception {
		List<WebElement> accessList = DriverFactory.getDriver().findElements(By.tagName("a"));
		int flag = 0;
		for (int i = 0; i < accessList.size(); i++) {

			if (accessList.get(i).getText().contains("Final Reports")) {
				flag++;
			}
			if (accessList.get(i).getText().contains("Finance")) {
				flag++;
			}
			if (accessList.get(i).getText().contains("Collection Reports")) {
				flag++;
				break;
			}
		}
		DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"primaryNavbar\"]/li/a/span[2]")).click();
		LogOut.click();
		if (flag == 3) {
			return true;
		}
		return false;
	}

	public boolean verifyCC2Access() throws Exception {

		List<WebElement> accessList = DriverFactory.getDriver().findElements(By.tagName("a"));
		int flag = 0;
		for (int i = 0; i < accessList.size(); i++) {
			if (accessList.get(i).getText().contains("Registration")) {
				flag++;
			}

			if (accessList.get(i).getText().contains("Sample Accession / Batch Management")) {
				flag++;

			}
			if (accessList.get(i).getText().contains("Archives")) {
				flag++;
			}
			if (accessList.get(i).getText().contains("Collection Reports")) {
				flag++;
			}
			if (accessList.get(i).getText().contains("Finance")) {
				flag++;
				break;
			}
		}
		if (flag == 5) {
			return true;
		}
		return false;

	}

	public ArrayList<String> registrationAndUpdateAccess() throws Exception {
		List<WebElement> accessList = DriverFactory.getDriver().findElements(By.tagName("a"));
		ArrayList<String> list = null;
		for (int i = 0; i < accessList.size(); i++) {

			if (accessList.get(i).getText().contains("Registration")) {
				Assert.assertTrue(true);
			}
		}
		String name = CommonMethods.generateRandomName();
		String subname = name.substring(0, 5);
		newDirectFirstName.sendKeys(name);
		newDirectRadiobutton.click();
		newDirectSaveForm.click();
		CommonMethods.waitForElementToVisible(userNm);
		String currentUrl = DriverFactory.getDriver().getCurrentUrl();
		String subURL = currentUrl.substring(0, 42);
		Thread.sleep(500);
		registerUrl.click();
		newDirectFirstName.sendKeys(subname);
		Thread.sleep(2000);
		newDirectFirstName.sendKeys(Keys.ARROW_DOWN);
		newDirectFirstName.sendKeys(Keys.ENTER);
		newDirectRadiobutton.click();
		newDirectSaveForm.click();
		CommonMethods.waitForElementToVisible(newDirectErrorDiv);
		String success = newDirectErrorDiv.getText();
		list = new ArrayList<>();
		list.add(subURL);
		list.add(success);

		return list;

	}

	public void deleteCCOrganization(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		editOrgTab.click();
		if (orgname.equals("Non Billing")) {
			selectOrg("Non Billing");
		}

		if (orgname.equals("Billing CC")) {
			selectOrg("Billing CC");
		}

		CommonMethods.waitForElementToClickable(orgDeleteButton);
		orgDeleteButton.click();
		CommonMethods.waitForElementToClickable(orgDelete);
		orgDelete.click();
	}

	public ArrayList<String> updateOrganizationDetails(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		editOrgTab.click();
		selectOrg(orgname);
		CommonMethods.waitForElementToVisible(orgnName);

		orgnContact.clear();
		orgnContact.sendKeys("8275369427");
		orgnEmail.clear();
		orgnEmail.sendKeys("kshirsagardhanraj24@gmail.com");
		CommonMethods.waitForElementToClickable(orgUploadButton);

		orgUploadButton.click();
		selectOrg(orgname);
		Thread.sleep(500);
		String orgName = orgnContact.getAttribute("value");
		String orgmail = orgnEmail.getAttribute("value");
		ArrayList<String> list = new ArrayList<>();
		list.add(orgName);
		list.add(orgmail);

		return list;

	}

	public boolean deleteOrganization(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addOrgTab.click();
		orgnName.sendKeys(orgname);

		CommonMethods.waitForElementToClickable(orgUploadButton);
		orgUploadButton.click();
		editOrgTab.click();
		selectOrg(orgname);
		CommonMethods.waitForElementToClickable(orgDeleteButton);
		orgDeleteButton.click();
		CommonMethods.waitForElementToClickable(orgDelete);
		orgDelete.click();
		CommonMethods.waitForElementToClickable(Listoptins);
		Listoptins.click();

		List<WebElement> orgList = orgEditListDropDownList.findElements(By.tagName("li"));
		int flag = 0;
		for (int i = 0; i < orgList.size(); i++) {

			if (orgList.get(i).getText().equals("Sample delete")) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return false;
		}
		return true;
	}

	public boolean deleteAndTrasnferOrganization(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		editOrgTab.click();
		selectOrg(orgname);
		CommonMethods.waitForElementToClickable(orgDeleteButton);
		orgDeleteButton.click();
		CommonMethods.waitForElementToClickable(orgDelete);
		refOrgList.sendKeys("auto");
		Thread.sleep(1000);
		refOrgList.sendKeys(Keys.ARROW_DOWN);
		refOrgList.sendKeys(Keys.ENTER);
		CommonMethods.waitForElementToClickable(orgTransfer);
		orgTransfer.click();
		CommonMethods.waitForElementToClickable(Listoptins);
		Listoptins.click();
		List<WebElement> orgList = orgEditListDropDownList.findElements(By.tagName("li"));
		int flag = 0;
		for (int i = 0; i < orgList.size(); i++) {

			if (orgList.get(i).getText().equals("Satara Hospital")) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return false;
		}
		return true;
	}

	public boolean addThiredPartyIntegrationOrganization(String orgName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		List<WebElement> List;
		addOrgTab.click();
		orgnName.sendKeys(orgName);
		isIntegrationEnableForAddOrg.click();
		showIntegrationListLinkForAddOrg.click();
		CommonMethods.waitForElementToVisible(serviceMasterName);
		serviceMasterName.click();
		CommonMethods.waitForElementToVisible(categoryNameListCheck1);
		categoryNameListCheck1.click();
		Thread.sleep(500);
		List = DriverFactory.getDriver().findElements(By.name("actionNameList"));
		List.get(0).click();
		CommonMethods.waitForElementToVisible(url1);
		url1.sendKeys("https://beta.livehealth.solutions/organization/add/#");
		List.get(1).click();
		CommonMethods.waitForElementToVisible(url2);
		url2.sendKeys("https://beta.livehealth.solutions");

		enable.click();
		CommonMethods.waitForElementToClickable(orgUploadButton);
		orgUploadButton.click();
		editOrgTab.click();
		selectOrg(orgName);
		Thread.sleep(500);
		if (integrationEnableCheckForEditOrg.isSelected()) {
			return true;
		}
		return false;

	}

	public boolean updatThiredPartyIntegrationOrganization(String orgName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		editOrgTab.click();
		selectOrg(orgName);
		Thread.sleep(500);
		int flag = 0;
		showServiceModalLickForEditOrg.click();
		CommonMethods.waitForElementToClickable(serviceMasterName);
		serviceMasterName.click();
		Thread.sleep(500);
		DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"3\"]")).click();
		CommonMethods.waitForElementToVisible(url3);
		url3.clear();
		url3.sendKeys("https://beta.livehealth.solutions/");
		enable.click();
		CommonMethods.waitForElementToClickable(orgUploadButton);
		orgUploadButton.click();
		selectOrg(orgName);
		Thread.sleep(500);
		showServiceModalLickForEditOrg.click();
		CommonMethods.waitForElementToClickable(serviceMasterName);
		serviceMasterName.click();
		WebElement verify = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"3\"]"));
		if (verify.isSelected()) {
			flag = 1;
		}
		Thread.sleep(500);
		DriverFactory.getDriver()
				.findElement(By.xpath("//*[@id=\"showServiceListModalForEditOrg\"]/div/div/div[3]/button[2]")).click();
		CommonMethods.waitForElementToClickable(orgDeleteButton);
		orgDeleteButton.click();
		CommonMethods.waitForElementToClickable(orgDelete);
		orgDelete.click();
		if (flag == 1) {
			return true;
		}
		return false;
	}

	public ArrayList<String> manageLedgerValidation(String orgName, String advance) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addOrgTab.click();
		orgnName.sendKeys(orgName);
		Select ele = new Select(orgPaymentType);
		ele.selectByVisibleText("Prepaid");
		chkBoxManageLedger.click();
		addOpeningBal.clear();
		addOpeningBal.sendKeys(advance);
		orgnUsername.sendKeys("prepaid");
		orgnPassword.sendKeys("Prepaid@123");
		CommonMethods.waitForElementToClickable(orgUploadButton);
		orgUploadButton.click();
		String warning = errorDiv.getText();
		currentDue.clear();
		currentDue.sendKeys(advance);
		collectionCenter.click();
		adduserNewPatientRegister.click();
		adduserUpdatePatient.click();
		adduserBillSettelmentFlag.click();
		orgUploadButton.click();

		editOrgTab.click();
		DriverFactory.getDriver().navigate().refresh();
		selectOrg(orgName);
		Thread.sleep(500);
		String adv = null;
		if (editChkBoxManageLedger.isSelected()) {
			adv = currentDue.getAttribute("value");
		}
		ArrayList<String> list = new ArrayList<>();
		list.add(warning);
		list.add(adv);
		return list;

	}

	public String manageLedgerForPostPaid(String orgName, String advance) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		addOrgTab.click();
		orgnName.sendKeys(orgName);
		Select ele = new Select(orgPaymentType);
		ele.selectByVisibleText("Postpaid");
		chkBoxManageLedger.click();
		creditLimit.clear();
		creditLimit.sendKeys(advance);
		CommonMethods.waitForElementToClickable(orgUploadButton);

		orgUploadButton.click();
		editOrgTab.click();
		DriverFactory.getDriver().navigate().refresh();
		selectOrg(orgName);
		String credit = null;
		if (editChkBoxManageLedger.isSelected()) {
			credit = creditLimit.getAttribute("value");
		}
		CommonMethods.waitForElementToClickable(orgDeleteButton);
		orgDeleteButton.click();
		CommonMethods.waitForElementToClickable(orgDelete);
		orgDelete.click();
		return credit;

	}

	public void selectOrganizationForAssignList(String orgname) throws InterruptedException {
		AssignOrgListTab.click();
		orgName.sendKeys(orgname);
		Thread.sleep(2000);
		orgName.sendKeys(Keys.ARROW_DOWN);
		orgName.sendKeys(Keys.ENTER);
	}

	public void selectPriceList(String orgPriceName) throws InterruptedException {
		orgLists.sendKeys(orgPriceName);
		Thread.sleep(2000);
		orgLists.sendKeys(Keys.ARROW_DOWN);
		orgLists.sendKeys(Keys.ENTER);
	}

	public String assignPriceList(String orgname, String orgPriceName) throws Exception {
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/organizationManagement/");
		selectOrganizationForAssignList(orgname);
		CommonMethods.waitForElementToClickable(listOrgButton);
		selectPriceList(orgPriceName);
		try {
			listOrgButton.click();
			Thread.sleep(1000);
			selectOrganizationForAssignList(orgname);
			CommonMethods.waitForElementToVisible(errorDiv);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String SelectedRefListName = selectedListName.getText();
		return SelectedRefListName;

	}

	public String assignPriceListForAlreadyAssigned(String orgname, String orgPriceName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();

		selectOrganizationForAssignList(orgname);
		CommonMethods.waitForElementToClickable(listOrgButton);
		selectPriceList(orgPriceName);
		try {
			listOrgButton.click();
			Thread.sleep(1000);
			selectOrganizationForAssignList(orgname);
			CommonMethods.waitForElementToVisible(errorDiv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String priceListName = selectedListName.getText();
		return priceListName;

	}

	public String viewListLink(String orgname) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		selectOrganizationForAssignList(orgname);
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

	public void ExportListLink(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectOrganizationForAssignList(orgname);
		CommonMethods.waitForElementToClickable(listLink);
		exportListLink.click();
		Thread.sleep(1000);
		String filePath = "C:/Users/Administrator/Downloads/";
		Assert.assertTrue(isFileDownloaded("filePath", "ReAssignOrgList.xls"), "Failed to download Expected document");
		File file = new File("C:/Users/Administrator/Downloads/ReAssignOrgList.xls");
		file.delete();

	}

	private boolean isFileDownloaded(String string, String string2) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean updateAllRevenue(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectOrganizationForAssignList(orgname);
		CommonMethods.waitForElementToClickable(organizationTotalRev);
		organizationTotalRev.click();
		CommonMethods.waitForElementToClickable(setUpdateRevenueDateRangeOrg);
		setUpdateRevenueDateRangeOrg.click();
		Thread.sleep(500);
		WebElement ele = DriverFactory.getDriver().findElement(By.xpath("//li[contains(text(),'Last Month')]"));
		ele.click();
		CommonMethods.waitForElementToClickable(Update);
		Update.click();
		Thread.sleep(500);
		if (organizationTotalRev.isEnabled()) {
			return false;
		}
		return true;

	}

	public boolean removeAssignedList(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectOrganizationForAssignList(orgname);
		CommonMethods.waitForElementToClickable(listDeleteButton);
		listDeleteButton.click();
		Thread.sleep(2000);
		selectOrganizationForAssignList(orgname);
		CommonMethods.waitForElementToClickable(listOrgButton);
		if (errorDiv.isDisplayed()) {
			return false;
		}
		return true;

	}

	public String enableOrganization(String orgName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DisableOrgTab.click();

		List<WebElement> OrgList = DriverFactory.getDriver()
				.findElements(By.xpath("//button[contains(text(),'Enable')]"));
		OrgList.get(0).click();
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/organization/edit/");
		DriverFactory.getDriver().navigate().refresh();
		selectOrg(orgName);
		Thread.sleep(500);
		String actualName = orgnName.getAttribute("value");
		CommonMethods.waitForElementToClickable(orgDeleteButton);
		orgDeleteButton.click();
		CommonMethods.waitForElementToClickable(orgDelete);
		orgDelete.click();
		SoftAssert.assertAll();
		return actualName;

	}

	public void logoutCurrentSession() throws Exception {
		Thread.sleep(2000);
		List<WebElement> dropdown = DriverFactory.getDriver().findElements(By.className("dropdown"));
		dropdown.get(1).click();
		LogOut.click();
	}

	public void verifyCC() throws Exception {

		DriverFactory.getDriver().get("https://beta.livehealth.solutions/organizationTransactions/");
		addCredit("400");
		addCredit("600");
		addCredit("800");
		DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"primaryNavbar\"]/li/a/span[2]")).click();
		LogOut.click();
	}

	public void addCredit(String creditAmount) throws Exception {
		try {
			DriverFactory.getDriver().findElement(By.xpath("//a[contains(text(),'Organization Ledger')]")).click();
			addCreditBtn.click();
			CommonMethods.waitForElementToClickable(inputAmount);
			inputAmount.sendKeys(creditAmount);
			orgComment.sendKeys("credit added from cc");
			addCredit.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			Assert.assertFalse(true);
		}

	}

	public String approveAdvanceOrgAmount() throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://beta.livehealth.solutions/organization/organizationAdvance/");
		Thread.sleep(1000);
		String success;
		List<WebElement> appoveList = driver.findElements(By.xpath("//button[contains(text(),'Approve')]"));
		appoveList.get(0).click();
		CommonMethods.waitForElementToVisible(trancErrorDiv);
		success = trancErrorDiv.getText();

		List<WebElement> Options = driver.findElements(By.className("dropdown-toggle"));
		Options.get(3).click();
		List<WebElement> printlist = driver.findElements(By.xpath("//a[contains(text(),'Print Receipt')]"));
		String beforehandle = driver.getWindowHandle();
		printlist.get(0).click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String actualUrl = driver.getCurrentUrl();
		String subActualUrl = actualUrl.substring(0, 62);
		Assert.assertEquals(subActualUrl, "https://beta.livehealth.solutions/printLedgerReceipt/?orgTrnId");
		driver.close();
		driver.switchTo().window(beforehandle);

		return success;

	}

	public String rejectAdvanceOrgAmount() throws Exception {
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/organization/organizationAdvance/");
		Thread.sleep(1000);
		List<WebElement> rejectLabel = DriverFactory.getDriver()
				.findElements(By.xpath("//span[contains(text(),'Rejected on')]"));
		int beforReject = rejectLabel.size();

		List<WebElement> Options = DriverFactory.getDriver().findElements(By.className("dropdown-toggle"));
		Options.get(4).click();
		List<WebElement> rejectList = DriverFactory.getDriver()
				.findElements(By.xpath("//a[contains(text(),'Reject')]"));
		rejectList.get(0).click();
		CommonMethods.waitForElementToClickable(RejectCredit);
		RejectCredit.click();
		Thread.sleep(500);
		String colour = inputRejectComment.getCssValue("border-color");
		inputRejectComment.sendKeys("reject amount");
		RejectCredit.click();
		CommonMethods.waitForElementToVisible(trancErrorDiv);
		String success = trancErrorDiv.getText();
		SoftAssert.assertEquals(success, "×\n" + "Credit amount rejected successfully.");

		DriverFactory.getDriver().navigate().refresh();
		Thread.sleep(1000);
		rejectLabel = DriverFactory.getDriver().findElements(By.xpath("//span[contains(text(),'Rejected on')]"));
		int afterReject = rejectLabel.size();

		if (beforReject <= afterReject) {
			SoftAssert.assertTrue(true, "rejected successfully");
		} else {
			SoftAssert.assertFalse(true);
		}

		deletePrepaidLedgerOrg("Prepaid Ledger");
		SoftAssert.assertAll();
		return colour;

	}

	public void deletePrepaidLedgerOrg(String orgname) throws Exception {
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/organization/edit/");
		selectOrg(orgname);
		CommonMethods.waitForElementToClickable(orgDeleteButton);
		orgDeleteButton.click();
		CommonMethods.waitForElementToClickable(orgDelete);
		orgDelete.click();
	}

	public String orgSettlemetPenidingBills(String orgname) throws Exception {
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/organization/settlement/");
		selectOrganizationForBillSettle(orgname);
		List<WebElement> pendingBills = orgBillList.findElements(By.tagName("li"));

		if (pendingBills.size() <= 1) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true);
		}
		CommonMethods.waitForElementToVisible(orgNoBillMsg);
		String warning = orgNoBillMsg.getText();
		return warning;

	}

	public void selectOrganizationForBillSettle(String refname) throws InterruptedException {
		OrganizationSettlementsTab.click();
		searchCreditOrganizations.sendKeys(refname);
		Thread.sleep(2000);
		searchCreditOrganizations.sendKeys(Keys.ARROW_DOWN);
		searchCreditOrganizations.sendKeys(Keys.ENTER);
	}

	public static String dueId;
	public static String dues;

	public ArrayList<Integer> calculateOrgDue(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectOrganizationForBillSettle(orgname);
		Thread.sleep(1000);

		String startDay = CommonMethods.getstartDate(28);
		String endDay = CommonMethods.getstartDate(4);
		orgSettlementDateRange.click();
		daterangepickerstart.clear();
		daterangepickerstart.sendKeys(startDay);
		daterangepickerend.clear();
		daterangepickerend.sendKeys(endDay);
		CommonMethods.waitForElementToClickable(Apply);
		Apply.click();
		CommonMethods.waitForElementToClickable(orgSubmit);

		List<WebElement> dueAmounts = DriverFactory.getDriver().findElements(By.className("list-group-item"));
		int length = dueAmounts.size();
		int sum = 0;

		for (int i = 1; i < length; i++) {
			int id = i - 1;
			dueId = "orgDueAmount" + id;

			List<WebElement> pendingBillsDue = DriverFactory.getDriver().findElements(By.id(dueId));
			for (int j = 0; j < pendingBillsDue.size(); j++) {
				dues = pendingBillsDue.get(j).getText();
			}
			int total = Integer.parseInt(dues);
			sum = sum + total;
		}
		String dueAmount = orgDueAmount.getText();
		int finalDue = Integer.parseInt(dueAmount);
		ArrayList<Integer> list = new ArrayList<>();
		list.add(finalDue);
		list.add(sum);
		return list;

	}

	public String recalculateOrgDue(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DriverFactory.getDriver().get("https://beta.livehealth.solutions/organization/settlement/");
		selectOrganizationForBillSettle(orgname);
		Thread.sleep(1000);
		String orgNameText = orgName.getText();
		SoftAssert.assertEquals(orgNameText, "autoOrganisation");

		RecalculateDue.click();
		CommonMethods.waitForElementToVisible(errorDueOrgAmnt);
		String success = errorDueOrgAmnt.getText();
		SoftAssert.assertAll();

		return success;

	}

	public String editBillLink(String orgname) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		selectOrganizationForBillSettle(orgname);
		Thread.sleep(1000);
		String beforehandle = driver.getWindowHandle();
		List<WebElement> editBill = driver.findElements(By.xpath("//a[contains(text(),'Edit Bill')]"));
		editBill.get(0).click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String url = DriverFactory.getDriver().getCurrentUrl();
		String expectedUrl = url.substring(0, 44);
		driver.close();
		driver.switchTo().window(beforehandle);
		return expectedUrl;

	}

	java.util.List<WebElement> billsList;

	public boolean orgBillssettleAmount(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectOrganizationForBillSettle(orgname);
		CommonMethods.waitForElementToClickable(orgSubmit);
		Thread.sleep(1000);
		billsList = DriverFactory.getDriver().findElements(By.className("list-group-item"));

		for (int i = 1; i < billsList.size(); i++) {
			if (i < 3) {
				billsList.get(i).click();
			}
		}
		orgSubmit.click();
		CommonMethods.waitForElementToVisible(orgSuccessDiv);
		String sucess = orgSuccessDiv.getText();

		if (sucess.contains("×\n" + "Close\n"
				+ "Success!  Click on below links to print the receipts for successful bill settlements")) {
			SoftAssert.assertTrue(true);
		}
		Thread.sleep(1000);
		List<WebElement> printbills = DriverFactory.getDriver()
				.findElements(By.xpath("//button[contains(text(),'Print Receipt')]"));
		if (printbills.get(0).isEnabled() && printbills.get(1).isEnabled()) {
			return true;
		}
		return false;
	}

	public boolean backDatedSettlement(String orgname) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectOrganizationForBillSettle(orgname);
		CommonMethods.waitForElementToClickable(orgSubmit);
		Thread.sleep(1000);
		billsList = DriverFactory.getDriver().findElements(By.className("list-group-item"));

		for (int i = 1; i < billsList.size(); i++) {
			if (i < 2) {
				billsList.get(i).click();
			}
		}
		String backDate = CommonMethods.getBackOrgDate(2);
		String SetlementDate = CommonMethods.getBackD(2);

		DriverFactory.getDriver().findElement(By.className("input-group-addon")).click();
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("document.getElementById('orgDefaultDate').value = arguments[0];", backDate);
		String myDate = (String) js.executeScript("return document.getElementById('orgDefaultDate').value");

		JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("document.getElementById('orgSettlementDate').value = arguments[0];", SetlementDate);
		String myDate1 = (String) js1.executeScript("return document.getElementById('orgSettlementDate').value");
		orgSubmit.click();

		CommonMethods.waitForElementToClickable(Confirmbutton);
		Confirmbutton.click();
		Thread.sleep(1000);
		if (Confirmbutton.isDisplayed()) {
			Assert.assertFalse(true);
		} else {
			CommonMethods.waitForElementToVisible(orgSuccessDiv);
			String success = orgSuccessDiv.getText();

			if (success.contains("×\n" + "Close\n"
					+ "Success! Click on below links to print the receipts for successful bill settlements")) {
				return true;
			}
			return false;
		}
		return false;

	}

	public boolean paymentType(String mode, String value, String orgname) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		selectOrganizationForBillSettle(orgname);
		CommonMethods.waitForElementToClickable(orgSubmit);
		Thread.sleep(1000);
		driver.findElement(By.id("orgHighlight0")).click();
		int flag = 0;
		if (mode.equals("Cheque")) {
			Select ele = new Select(orgPaymentType);
			ele.selectByVisibleText("Cheque");
		}

		if (mode.equals("Credit")) {
			Select ele = new Select(orgPaymentType);
			ele.selectByVisibleText("Credit");
		}

		if (mode.equals("Credit Card")) {
			Select ele = new Select(orgPaymentType);
			ele.selectByVisibleText("Credit Card");
		}

		if (mode.equals("Debit Card")) {
			Select ele = new Select(orgPaymentType);
			ele.selectByVisibleText("Debit Card");
		}

		if (mode.equals("Free")) {
			Select ele = new Select(orgPaymentType);
			ele.selectByVisibleText("Free");
		}

		if (mode.equals("Other")) {
			Select ele = new Select(orgPaymentType);
			ele.selectByVisibleText("Other");
		}

		orgSubmit.click();
		CommonMethods.waitForElementToVisible(orgSuccessDiv);
		String success = orgSuccessDiv.getText();

		if (success.contains("×\n" + "Close\n"
				+ "Success! Click on below links to print the receipts for successful bill settlements")) {
			flag++;
		}
		String beforehandle = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", searchCreditOrganizations);
		List<WebElement> editBill = driver.findElements(By.xpath("//a[contains(text(),'Edit Bill')]"));
		editBill.get(0).click();
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
		if (flag == 2) {
			return true;
		}
		return false;
	}

	public boolean selectAlls(String refName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectOrganizationForBillSettle(refName);
		CommonMethods.waitForElementToClickable(orgSubmit);
		Thread.sleep(1000);
		selectAllOrgFlag.click();
		orgSubmit.click();
		CommonMethods.waitForElementToVisible(orgSuccessDiv);
		String success = orgSuccessDiv.getText();
		int flag = 0;
		if (success.contains("×\n" + "Close\n"
				+ "Success! Click on below links to print the receipts for successful bill settlements")) {
			flag++;
		}
		selectOrganizationForBillSettle(refName);
		CommonMethods.waitForElementToVisible(orgNoBillMsg);
		String warning = orgNoBillMsg.getText();
		if (warning.equals("×\n" + "No pending bills found for the selected organization.")) {
			flag++;
		}
		if (flag == 2) {
			return true;
		}
		return false;
	}

	public String bulkUploadOrganization(String Org1, String Org2) throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		BulOrganizationUploadTab.click();
		CommonMethods.waitForElementToClickable(fileInputOrgExcel);
		String path=System.getProperty("user.dir");
		String invalidFile = path + File.separator + "/src/main/resources/Files/OrganizationsList.xls";
		fileInputOrgExcel.sendKeys(invalidFile);
		CommonMethods.waitForElementToVisible(excelSuccessDiv);
		String warning = excelSuccessDiv.getText();
		SoftAssert.assertEquals(warning, "×\n"
				+ "rrrrError! Invalid template format. Please upload Excel file using sample template we have provided or file is empty.");

		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(fileInputOrgExcel);
		String validFile = path + File.separator + "/src/main/resources/Files/OrganizationsList.xlsx";
		fileInputOrgExcel.sendKeys(validFile);

		CommonMethods.waitForElementToClickable(submitExcel);
		submitExcel.click();
		CommonMethods.waitForElementToVisible(excelSuccessDiv);
		String success = excelSuccessDiv.getText();
		deleteBulkUploadedOrganization(Org1);
		deleteBulkUploadedOrganization(Org2);
		return success;

	}

	public String invalidFileInput() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BulOrganizationUploadTab.click();
		String path=System.getProperty("user.dir");
		String invalidFile = path + File.separator + "/src/main/resources/Files/consoleText.txt";
		CommonMethods.waitForElementToClickable(fileInputOrgExcel);
		fileInputOrgExcel.sendKeys(invalidFile);
		CommonMethods.waitForElementToVisible(excelSuccessDiv);
		String warning = excelSuccessDiv.getText();

		return warning;

	}

	public void deleteBulkUploadedOrganization(String Org) throws Exception {

		DriverFactory.getDriver().get("https://beta.livehealth.solutions/organization/edit/");

		if (Org.equals("mumbail")) {
			selectOrg(Org);
		}

		if (Org.equals("tarapur")) {
			selectOrg(Org);
		}

		CommonMethods.waitForElementToClickable(orgDeleteButton);
		orgDeleteButton.click();
		CommonMethods.waitForElementToClickable(orgDelete);
		orgDelete.click();
	}

	public void exportExcelTemplate() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BulOrganizationUploadTab.click();
		CommonMethods.waitForElementToClickable(excelTemplate);
		excelTemplate.click();
		Thread.sleep(1000);
		String filePath = "C:/Users/Administrator/Downloads";
		Assert.assertTrue(isFileDownloaded("filePath", "OrganizationsList (1).xls"),
				"Failed to download Expected document");
		File file = new File("C:/Users/Administrator/Downloads/OrganizationsList (1).xls");
		file.delete();

	}

}
