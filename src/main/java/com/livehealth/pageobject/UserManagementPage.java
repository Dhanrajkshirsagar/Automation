package com.livehealth.pageobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;
import com.livehealth.util.CommonMethods;

public class UserManagementPage {

	org.testng.asserts.SoftAssert SoftAssert = new org.testng.asserts.SoftAssert();

	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement adminHover;

	@FindBy(xpath = "//a[contains(text(),'User Management')]")
	private WebElement userManagementTab;

	@FindBy(xpath = "//a[contains(text(),'Add / Edit User')]")
	private WebElement AddEditUser;

	@FindBy(id = "addUserDiv")
	private WebElement addUserDiv;

	@FindBy(id = "addUserTab")
	private WebElement addUserTab;

	@FindBy(id = "editUserTab")
	private WebElement editUserTab;

	@FindBy(id = "addUserSubmit")
	private WebElement addUserSubmit;

	@FindBy(id = "editUserName")
	private WebElement editUserName;

	@FindBy(id = "editAllowedDiscount")
	private WebElement editAllowedDiscount;

	@FindBy(id = "editShowUser")
	private WebElement editShowUser;

	@FindBy(id = "primaryNavbar")
	private WebElement primaryNavbar;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement LogOut;

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//*[@id=\"labContent\"]/form/input[2]")
	private WebElement ClickLogin;

	@FindBy(id = "searchPatient")
	private WebElement searchPatient;

	@FindBy(id = "searchInputforTests")
	private WebElement searchInputforTests;

	@FindBy(id = "totalConcessionAmt")
	private WebElement totalConcessionAmt;

	@FindBy(id = "saveBill")
	private WebElement saveBill;

	@FindBy(className = "alert-success")
	private WebElement billConfirmationDiv;

	@FindBy(id = "billUrl")
	private WebElement billUrl;

	@FindBy(id = "concession")
	private WebElement concession;

	@FindBy(id = "concessionErrorDiv")
	private WebElement concessionErrorDiv;

	@FindBy(id = "AdvanceAmount")
	private WebElement AdvanceAmount;

	@FindBy(className = "alert-warning")
	private WebElement regAccessWarning;

	@FindBy(id = "accordion1")
	private WebElement ClickRegistration;

	@FindBy(id = "selectAllRegistrationEditFlags")
	private WebElement selectAllRegistrationEditFlags;

	@FindBy(id = "newDirectFirstName")
	private WebElement newDirectFirstName;

	@FindBy(id = "newDirectRadiobutton")
	private WebElement newDirectRadiobutton;

	@FindBy(id = "newDirectSaveForm")
	private WebElement newDirectSaveForm;

	@FindBy(id = "registerUrl")
	private WebElement registerUrl;

	@FindBy(id = "userNewPatientRegister")
	private WebElement userNewPatientRegister;

	@FindBy(id = "userUpdatePatient")
	private WebElement userUpdatePatient;

	@FindBy(id = "nav-sidebar")
	private WebElement navsidebar;

	@FindBy(xpath = "//a[contains(text(),'Bill Settlements')]")
	private WebElement BillSettlements;

	@FindBy(xpath = "//a[contains(text(),'Add Tests To Bill')]")
	private WebElement AddTestsToBill;

	@FindBy(id = "price")
	private WebElement price;

	@FindBy(className = "addBillingDiv")
	private WebElement addBillingDiv;

	@FindBy(id = "usertestPriceEdit")
	private WebElement usertestPriceEdit;

	@FindBy(id = "usertestConcessionEdit")
	private WebElement usertestConcessionEdit;

	@FindBy(id = "selectAllOperationEditFlags")
	private WebElement selectAllOperationEditFlags;

	@FindBy(id = "accordion2")
	private WebElement accordion2;

	@FindBy(id = "OperationViewOnly")
	private WebElement OperationViewOnly;

	@FindBy(id = "printAllSampleId")
	private WebElement printAllSampleId;

	@FindBy(xpath = "//a[contains(text(),'All Departments')]")
	private WebElement AllDepartments;

	@FindBy(className = "userWaitingListCard")
	private WebElement userWaitingListCard;

	@FindBy(id = "container")
	private WebElement container;

	@FindAll({ @FindBy(className = "userWaitingListCard") })
	public List<WebElement> patientList;

	@FindAll({ @FindBy(className = "waitingListLabOptionList") })
	public List<WebElement> waitingListLabOptionList;

	@FindBy(id = "quickSaveBtn")
	private WebElement quickSaveBtn;

	@FindBy(id = "successDiv")
	private WebElement successDiv;

	@FindBy(xpath = "//a[contains(text(),'Redo Report')]")
	private WebElement RedoReport;

	@FindBy(xpath = "//a[contains(text(),'Redraw')]")
	private WebElement Redraw;

	@FindBy(xpath = "//a[contains(text(),'Dismiss this report')]")
	private WebElement dismiss;

	@FindBy(id = "dismissComments")
	private WebElement dismissComments;

	@FindBy(id = "dismissMsg")
	private WebElement dismissMsg;

	@FindBy(id = "confirmedBillRemoval")
	private WebElement confirmedBillRemoval;

	@FindBy(id = "ViewAmountDueReport")
	private WebElement ViewAmountDueReport;

	@FindBy(id = "waitingListLabels")
	private WebElement waitingListLabels;

	@FindBy(id = "OperationClearReport")
	private WebElement OperationClearReport;

	@FindBy(xpath = "//a[contains(text(),'Clear this report')]")
	private WebElement clearReport;

	@FindBy(id = "quickEntryModalLabel")
	private WebElement quickEntryModalLabel;

	@FindBy(id = "OperationDismissReport")
	private WebElement OperationDismissReport;

	@FindBy(id = "OperationRedrawRedo")
	private WebElement OperationRedrawRedo;

	@FindBy(id = "redrawComments")
	private WebElement redrawComments;

	@FindBy(id = "redrawCommentBtn")
	private WebElement redrawCommentBtn;

	@FindBy(id = "redoErr")
	private WebElement redoErr;

	@FindBy(id = "OperationUpdateReportInfo")
	private WebElement OperationUpdateReportInfo;

	@FindBy(xpath = "//a[contains(text(),'Update report info')]")
	private WebElement Updatereportinfo;

	@FindBy(id = "updateLabAge")
	private WebElement updateLabAge;

	@FindBy(id = "labReportPassword")
	private WebElement labReportPassword;

	@FindBy(id = "modalUpdateReportBtn")
	private WebElement modalUpdateReportBtn;

	@FindBy(id = "userUpdateErrorDiv")
	private WebElement userUpdateErrorDiv;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement Close;

	@FindBy(id = "OperationEditReport")
	private WebElement OperationEditReport;

	@FindBy(className = "reportViewStatusLabel")
	private WebElement reportViewStatusLabel;

	@FindBy(id = "OperationSharedReportAccess")
	private WebElement OperationSharedReportAccess;

	@FindBy(id = "quickDefaultDocPass")
	private WebElement quickDefaultDocPass;

	@FindBy(id = "quickSubmitBtn")
	private WebElement quickSubmitBtn;

	@FindBy(xpath = "//a[contains(text(),'Share Report')]")
	private WebElement ShareReport;

	@FindBy(id = "quickDoctorDefault")
	private WebElement quickDoctorDefault;

	@FindBy(id = "share_Btn")
	private WebElement share_Btn;

	@FindBy(id = "centerSharingId")
	private WebElement centerSharingId;

	@FindBy(id = "userInventoryManagement")
	private WebElement userInventoryManagement;

	@FindBy(xpath = "//a[contains(text(),'Inventory Management')]")
	private WebElement InventoryManagement;

	@FindBy(xpath = "//span[contains(text(),'Inventory Management')]")
	private WebElement LockedInventoryManagement;

	@FindBy(id = "QualityControlManagement")
	private WebElement QualityControlManagement;

	@FindBy(xpath = "//a[contains(text(),'Quality Control')]")
	private WebElement QualityControl;

	@FindBy(xpath = "//span[contains(text(),'Quality Control')]")
	private WebElement lockQualityControl;

	@FindBy(id = "editSignedReport")
	private WebElement editSignedReport;

	@FindBy(id = "editTestFlag")
	private WebElement editTestFlag;
	
	@FindBy(id = "submitReport")
	private WebElement submitReport;
	
	@FindBy(id = "historyTestList")
	private WebElement historyTestList;
	
	@FindBy(id = "historyli")
	private WebElement historyli;
	
	@FindBy(xpath = "//a[contains(text(),'Edit this test')]")
	private WebElement Editthistest;
	
	@FindBy(id = "historySuccessDiv")
	private WebElement historySuccessDiv;


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

	public ArrayList<String> allowedDiscountOnBill(String discount) throws Exception {
		selectLabUser();
		editAllowedDiscount.clear();
		editAllowedDiscount.sendKeys(discount);
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.Billing_URL);
		selectPatient("dhan");
		CommonMethods.waitForElementToVisible(searchInputforTests);
		selectTest("Calcium Urine 24H");
		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("60");
		saveBill.click();
		Thread.sleep(500);
		String success = billConfirmationDiv.getText();

		billUrl.click();
		selectPatient("dhan");
		CommonMethods.waitForElementToVisible(searchInputforTests);
		selectTest("Calcium Urine 24H");
		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("65");
		AdvanceAmount.click();
		String errorWarning = concessionErrorDiv.getText();
		String amount = totalConcessionAmt.getAttribute("value");

		labUserLogout();
		ArrayList<String> list = new ArrayList<>();
		list.add(success);
		list.add(errorWarning);
		list.add(amount);
		return list;
	}

	public void selectPatient(String patientName) throws Exception {
		searchPatient.sendKeys(patientName);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[3]/div[2]/div/div[1]/span/span")));
		searchPatient.sendKeys(Keys.ARROW_DOWN);
		searchPatient.sendKeys(Keys.ENTER);

	}

	public void selectTest(String testName) throws Exception {
		searchInputforTests.sendKeys(testName);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span")));
		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
		searchInputforTests.sendKeys(Keys.ENTER);
		concession.sendKeys(Keys.ENTER);
	}

	public void selectLabUser() throws Exception {
		userManagementTab.click();
		Thread.sleep(500);
		Select ele = new Select(editUserName);
		ele.selectByVisibleText("livep-dhan");
		CommonMethods.waitForElementToClickable(editAllowedDiscount);

	}

	public void labUserLogout() throws InterruptedException {

		Thread.sleep(500);
		List<WebElement> dropDown = primaryNavbar.findElements(By.tagName("span"));
		dropDown.get(1).click();
		LogOut.click();
	}

	public ArrayList<String> registrationAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		ClickRegistration.click();
		if (selectAllRegistrationEditFlags.isSelected()) {

		} else {
			selectAllRegistrationEditFlags.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.REGISTRATION_URL);
		CommonMethods.waitForElementToClickable(newDirectFirstName);
		String name = CommonMethods.generateRandomName();
		String subname = name.substring(0, 5);
		newDirectFirstName.sendKeys(name);
		newDirectRadiobutton.click();
		newDirectSaveForm.click();
		Thread.sleep(500);
		String url = DriverFactory.getDriver().getCurrentUrl();
		String subUrl = url.substring(0, 42);

		Thread.sleep(500);
		registerUrl.click();
		newDirectFirstName.sendKeys(subname);
		Thread.sleep(1500);
		newDirectFirstName.sendKeys(Keys.ARROW_DOWN);
		newDirectFirstName.sendKeys(Keys.ENTER);
		newDirectRadiobutton.click();
		newDirectSaveForm.click();
		CommonMethods.waitForElementToClickable(billConfirmationDiv);
		String success = billConfirmationDiv.getText();

		labUserLogout();
		ArrayList<String> list = new ArrayList<>();
		list.add(subUrl);
		list.add(success);
		return list;
	}

	public ArrayList<String> NotRegAndUpdateAccess(String userName, String password, String updatename)
			throws Exception {
		signIn(userName, password);
		selectLabUser();
		ClickRegistration.click();

		if (userNewPatientRegister.isSelected()) {
			userNewPatientRegister.click();
		}

		if (userUpdatePatient.isSelected()) {
			userUpdatePatient.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.REGISTRATION_URL);
		CommonMethods.waitForElementToClickable(newDirectFirstName);
		String name = CommonMethods.generateRandomName();
		newDirectFirstName.sendKeys(name);
		newDirectRadiobutton.click();
		newDirectSaveForm.click();
		Thread.sleep(500);
		String accessWarn = regAccessWarning.getText();
		DriverFactory.getDriver().navigate().refresh();
		newDirectFirstName.sendKeys(updatename);
		Thread.sleep(1500);
		newDirectFirstName.sendKeys(Keys.ARROW_DOWN);
		newDirectFirstName.sendKeys(Keys.ENTER);
		CommonMethods.waitForElementToClickable(newDirectSaveForm);
		newDirectSaveForm.click();
		Thread.sleep(500);
		String accessWarning = regAccessWarning.getText();

		labUserLogout();
		ArrayList<String> list = new ArrayList<>();
		list.add(accessWarn);
		list.add(accessWarning);
		return list;

	}

	public boolean registratioAllAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		ClickRegistration.click();

		if (!selectAllRegistrationEditFlags.isSelected()) {
			selectAllRegistrationEditFlags.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.REGISTRATION_URL);
		Thread.sleep(500);
		List<WebElement> accessList = navsidebar.findElements(By.tagName("a"));
		int flag = 0;
		for (int i = 0; i < accessList.size(); i++) {

			if (accessList.get(i).getText().equals("Registration")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Appointments")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Home Collection")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Bill Settlements")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Archives")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Collection Report")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Operational Status")) {
				flag++;
			}
		}
		BillSettlements.click();
		AddTestsToBill.click();
		WebElement confirmText = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"billingDiv\"]/div[1]/h4/b"));
		Assert.assertEquals(confirmText.getText(), "Add Tests In Existing Bill");
		if (flag == 7) {
			return true;
		}
		return false;
	}

	public void patientBills(String paidAmount, String patinetName, String test1, String test2, String test3)
			throws Exception {
		DriverFactory.getDriver().get(Constants.Billing_URL);
		WebDriver driver = DriverFactory.getDriver();
		selectPatient(patinetName);
		CommonMethods.waitForElementToClickable(searchInputforTests);
		selectTest(test1);
		selectTest(test2);
		selectTest(test3);
		AdvanceAmount.clear();
		if (paidAmount.equals("400")) {
			AdvanceAmount.sendKeys(paidAmount);
		}

		if (paidAmount.equals("1070")) {
			AdvanceAmount.sendKeys(paidAmount);
		}
		saveBill.click();
		CommonMethods.waitForElementToClickable(printAllSampleId);
		Thread.sleep(500);
		String parentWindow = driver.getWindowHandle();
		printAllSampleId.click();
		Thread.sleep(1000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.close();
		driver.switchTo().window(parentWindow);
		Thread.sleep(500);
		billUrl.click();

	}

	public ArrayList<String> BothFlagBillTestPriceAndConcessionEditable(String patinetName, String testPrice,
			String discount) throws Exception {
		DriverFactory.getDriver().get(Constants.Billing_URL);
		CommonMethods.waitForElementToClickable(searchPatient);
		selectPatient(patinetName);
		CommonMethods.waitForElementToClickable(searchInputforTests);
		searchInputforTests.sendKeys("Amylase Ser");
		Thread.sleep(500);
		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
		searchInputforTests.sendKeys(Keys.ENTER);
		price.clear();
		price.sendKeys(testPrice);
		concession.sendKeys(discount);
		concession.sendKeys(Keys.ENTER);
		Thread.sleep(100);
		List<WebElement> testpricee = addBillingDiv.findElements(By.tagName("p"));
		ArrayList<String> list = new ArrayList<>();
		list.add(testpricee.get(1).getText());
		list.add(testpricee.get(2).getText());
		labUserLogout();
		return list;
	}

	public boolean billTestPriceEditable(String userName, String password, String patinetName, String testPrice)
			throws Exception {
		signIn(userName, password);
		selectLabUser();
		ClickRegistration.click();

		if (!usertestPriceEdit.isSelected()) {
			usertestPriceEdit.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.Billing_URL);
		CommonMethods.waitForElementToClickable(searchPatient);
		selectPatient(patinetName);
		CommonMethods.waitForElementToClickable(searchInputforTests);
		searchInputforTests.sendKeys("Amylase Ser");
		Thread.sleep(500);
		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
		searchInputforTests.sendKeys(Keys.ENTER);
		if (price.isEnabled()) {
			price.clear();
			price.sendKeys(testPrice);
			price.sendKeys(Keys.ENTER);
			Thread.sleep(100);
			List<WebElement> testpricee = addBillingDiv.findElements(By.tagName("p"));
			Assert.assertEquals(testpricee.get(1).getText(), testPrice);
			if (concession.isEnabled()) {
				return false;
			}
		}
		return true;

	}

	public boolean billTestConcessionEditable(String userName, String password, String patinetName, String discount)
			throws Exception {

		signIn(userName, password);
		selectLabUser();
		ClickRegistration.click();

		if (!usertestConcessionEdit.isSelected()) {
			usertestConcessionEdit.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.Billing_URL);
		CommonMethods.waitForElementToClickable(searchPatient);
		selectPatient(patinetName);
		CommonMethods.waitForElementToClickable(searchInputforTests);
		searchInputforTests.sendKeys("Amylase Ser");
		Thread.sleep(500);
		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
		searchInputforTests.sendKeys(Keys.ENTER);
		concession.clear();
		concession.sendKeys(discount);
		concession.sendKeys(Keys.ENTER);
		Thread.sleep(100);
		List<WebElement> testpricee = addBillingDiv.findElements(By.tagName("p"));
		Assert.assertEquals(testpricee.get(2).getText(), discount + " ₹");
		if (price.isEnabled()) {
			return false;
		}
		return true;

	}

	public boolean removeAllRegistrationAcess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		ClickRegistration.click();

		if (!selectAllRegistrationEditFlags.isSelected()) {
			selectAllRegistrationEditFlags.click();
			selectAllRegistrationEditFlags.click();
		}
		userNewPatientRegister.click();
		CommonMethods.waitForElementToClickable(editShowUser);
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.Billing_URL);
		Thread.sleep(500);
		List<WebElement> accessList = navsidebar.findElements(By.tagName("a"));
		int flag = 0;
		for (int i = 0; i < accessList.size(); i++) {

			if (accessList.get(i).getText().equals("Appointments")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Home Collection")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Bill Settlements")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Archives")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Collection Report")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Operational Status")) {
				flag++;
			}
		}

		if (flag > 0) {
			return false;
		}
		return true;
	}

	public boolean OperationAllAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (!selectAllOperationEditFlags.isSelected()) {
			selectAllOperationEditFlags.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.WAITING_LIST_URL);

		Thread.sleep(500);
		int flag = 0;
		List<WebElement> accessList = navsidebar.findElements(By.tagName("a"));
		for (int i = 0; i < accessList.size(); i++) {
			if (accessList.get(i).getText().equals("Operation")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Cancelled Reports")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Shared Reports")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Inventory Management")) {
				flag++;
			}
			if (accessList.get(i).getText().equals("Quality Control")) {
				flag++;
			}
		}

		if (flag == 5) {
			return true;
		}
		return false;
	}

	public ArrayList<String> operationViewOnly(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (!OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		Thread.sleep(500);
		List<WebElement> patientList = container.findElements(By.className("userWaitingListCard"));
		patientList.get(0).click();
		CommonMethods.waitForElementToClickable(quickSaveBtn);
		quickSaveBtn.click();
		CommonMethods.waitForElementToVisible(successDiv);
		String success = successDiv.getText();

		Thread.sleep(500);
		waitingListLabOptionList.get(0).click();
		dismiss.click();
		CommonMethods.waitForElementToClickable(confirmedBillRemoval);
		dismissComments.sendKeys("dissmissed");
		confirmedBillRemoval.click();
		CommonMethods.waitForElementToVisible(dismissMsg);
		String warning = dismissMsg.getText();

		ArrayList<String> list = new ArrayList<>();
		list.add(success);
		list.add(warning);
		return list;
	}

	public boolean hideDueAmountReports(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (!ViewAmountDueReport.isSelected()) {
			ViewAmountDueReport.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		Thread.sleep(500);
		List<WebElement> label = container.findElements(By.xpath("//label[contains(text(),'Amount Due')]"));
		if (label.size() > 0) {
			return false;
		}
		return true;

	}

	public void clickOnPatientReport() throws Exception {
		DriverFactory.getDriver().get(Constants.WAITING_LIST_URL);
		List<WebElement> ele = DriverFactory.getDriver().findElements(By.className("dropdown-toggle"));
		ele.get(0).click();
		AllDepartments.click();
		CommonMethods.waitForElementToVisible(userWaitingListCard);
		patientList.get(0).click();
	}

	public static String testName;

	public String clearReportAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}

		if (!OperationClearReport.isSelected()) {
			OperationClearReport.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		Thread.sleep(500);
		List<WebElement> patientList = container.findElements(By.className("userWaitingListCard"));
		patientList.get(0).click();
		CommonMethods.waitForElementToClickable(quickSaveBtn);
		testName = quickEntryModalLabel.getText();
		quickSaveBtn.click();
		Thread.sleep(1300);
		waitingListLabOptionList.get(0).click();
		clearReport.click();
		Thread.sleep(300);
		String success = successDiv.getText();
		return success;
	}

	public String ClearReportNotAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}

		if (OperationClearReport.isSelected()) {
			OperationClearReport.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		Thread.sleep(500);
		List<WebElement> patientList = container.findElements(By.className("userWaitingListCard"));
		patientList.get(0).click();
		CommonMethods.waitForElementToClickable(quickSaveBtn);
		quickSaveBtn.click();
		Thread.sleep(1300);
		waitingListLabOptionList.get(0).click();
		clearReport.click();
		Thread.sleep(300);
		String success = successDiv.getText();
		return success;

	}

	public static String test;

	public String dissMissReportAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}

		if (!OperationDismissReport.isSelected()) {
			OperationDismissReport.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		Thread.sleep(500);
		List<WebElement> testName = DriverFactory.getDriver().findElements(By.className("pull-left"));
		test = testName.get(3).getText();
		waitingListLabOptionList.get(0).click();
		dismiss.click();
		CommonMethods.waitForElementToClickable(confirmedBillRemoval);
		dismissComments.sendKeys("dissmissed");
		confirmedBillRemoval.click();
		Thread.sleep(500);
		String success = successDiv.getText();
		return success;
	}

	public String withoutDismissReportAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}

		if (OperationDismissReport.isSelected()) {
			OperationDismissReport.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		Thread.sleep(500);
		waitingListLabOptionList.get(0).click();
		dismiss.click();
		CommonMethods.waitForElementToClickable(confirmedBillRemoval);
		dismissComments.sendKeys("dissmissed");
		confirmedBillRemoval.click();
		Thread.sleep(300);
		String success = dismissMsg.getText();
		return success;

	}

	public boolean RedrawAndRedoReportAccess(String userName, String password) throws Exception {

		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}

		if (!OperationRedrawRedo.isSelected()) {
			OperationRedrawRedo.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		Thread.sleep(500);
		List<WebElement> redoList = container.findElements(By.xpath("//span[contains(text(),'Redone')]"));
		int beforesize = redoList.size();
		List<WebElement> patientList = container.findElements(By.className("userWaitingListCard"));
		patientList.get(0).click();
		CommonMethods.waitForElementToClickable(quickSaveBtn);
		quickSaveBtn.click();
		Thread.sleep(1300);
		waitingListLabOptionList.get(0).click();
		RedoReport.click();
		CommonMethods.waitForElementToClickable(redrawCommentBtn);
		redrawComments.sendKeys("Redo Report");
		redrawCommentBtn.click();
		Thread.sleep(500);
		redoList = container.findElements(By.xpath("//span[contains(text(),'Redone')]"));
		int afterSize = redoList.size();
		if (beforesize <= afterSize) {
			return true;
		}
		DriverFactory.getDriver().findElement(By.id("ReloadPatientWaitingList")).click();
		return false;
	}

	public boolean redrawAccess() throws Exception {
		Thread.sleep(500);
		List<WebElement> redrawList = container.findElements(By.xpath("//span[contains(text(),'Sample Redrawn')]"));
		int beforRedrawSize = redrawList.size();
		waitingListLabOptionList.get(0).click();
		Redraw.click();
		CommonMethods.waitForElementToClickable(redrawCommentBtn);
		redrawComments.sendKeys("Redraw Report");
		redrawCommentBtn.click();
		Thread.sleep(500);
		redrawList = container.findElements(By.xpath("//span[contains(text(),'Sample Redrawn')]"));
		int afterSize = redrawList.size();

		if (beforRedrawSize <= afterSize) {
			return true;
		}
		return false;

	}

	public String redoAndRedrawNotAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}

		if (OperationRedrawRedo.isSelected()) {
			OperationRedrawRedo.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		waitingListLabOptionList.get(3).click();
		Redraw.click();
		CommonMethods.waitForElementToClickable(redrawCommentBtn);
		redrawComments.sendKeys("Redraw Report");
		redrawCommentBtn.click();
		Thread.sleep(300);
		String warning = redoErr.getText();
		return warning;
	}

	public String updateReportInfoAcess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}

		if (!OperationUpdateReportInfo.isSelected()) {
			OperationUpdateReportInfo.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		waitingListLabOptionList.get(0).click();
		Updatereportinfo.click();
		CommonMethods.waitForElementToClickable(updateLabAge);
		updateLabAge.clear();
		updateLabAge.sendKeys("20");
		labReportPassword.sendKeys(password);
		modalUpdateReportBtn.click();
		Thread.sleep(1000);
		waitingListLabOptionList.get(0).click();
		Updatereportinfo.click();
		String age = updateLabAge.getAttribute("value");
		return age;
	}

	public String withoutUpdateReportInfoAcess(String userName, String password) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}

		if (OperationUpdateReportInfo.isSelected()) {
			OperationUpdateReportInfo.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		waitingListLabOptionList.get(0).click();
		Updatereportinfo.click();
		CommonMethods.waitForElementToClickable(updateLabAge);
		updateLabAge.clear();
		updateLabAge.sendKeys("20");
		labReportPassword.sendKeys(password);
		modalUpdateReportBtn.click();
		CommonMethods.waitForElementToVisible(userUpdateErrorDiv);
		String warning = userUpdateErrorDiv.getText();
		return warning;
	}

	public String withEditReportAccess(String userName, String password) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}

		if (!OperationEditReport.isSelected()) {
			OperationEditReport.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		List<WebElement> patientList = container.findElements(By.className("userWaitingListCard"));
		patientList.get(3).click();
		CommonMethods.waitForElementToClickable(quickSaveBtn);
		quickSaveBtn.click();
		Thread.sleep(1000);
		patientList = container.findElements(By.className("userWaitingListCard"));
		patientList.get(3).click();
		CommonMethods.waitForElementToClickable(quickSaveBtn);
		quickSaveBtn.click();
		String status = reportViewStatusLabel.getText();
		return status;
	}

	public String withOutEditReportAccess(String userName, String password) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}

		if (OperationEditReport.isSelected()) {
			OperationEditReport.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		List<WebElement> patientList = container.findElements(By.className("userWaitingListCard"));
		patientList.get(3).click();
		CommonMethods.waitForElementToClickable(quickSaveBtn);
		quickSaveBtn.click();
		Thread.sleep(500);
		CommonMethods.waitForElementToVisible(successDiv);
		String status = successDiv.getText();
		return status;
	}

	public String withShareReportAccess(String userName, String password, String passkey) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}
		if (!OperationEditReport.isSelected()) {
			OperationEditReport.click();
		}
		if (!OperationSharedReportAccess.isSelected()) {
			OperationSharedReportAccess.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		List<WebElement> patientList = container.findElements(By.className("userWaitingListCard"));
		patientList.get(3).click();
		CommonMethods.waitForElementToClickable(quickSaveBtn);

		Select ele = new Select(quickDoctorDefault);
		ele.selectByVisibleText("dhanraj");
		quickDefaultDocPass.sendKeys(passkey);
		Thread.sleep(100);
		quickSubmitBtn.click();
		Thread.sleep(1000);
		waitingListLabOptionList.get(3).click();
		ShareReport.click();
		CommonMethods.waitForElementToClickable(share_Btn);
		Select shareCentre = new Select(centerSharingId);
		shareCentre.selectByVisibleText("Selenium Automation (Livehealth)");
		share_Btn.click();
		CommonMethods.waitForElementToVisible(successDiv);
		Thread.sleep(300);
		return successDiv.getText();

	}

	public String withoutShareReportAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (OperationViewOnly.isSelected()) {
			OperationViewOnly.click();
		}
		if (OperationSharedReportAccess.isSelected()) {
			OperationSharedReportAccess.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		Thread.sleep(500);
		waitingListLabOptionList.get(3).click();
		ShareReport.click();
		CommonMethods.waitForElementToClickable(share_Btn);
		Select shareCentre = new Select(centerSharingId);
		shareCentre.selectByVisibleText("Selenium Automation (Livehealth)");
		share_Btn.click();
		CommonMethods.waitForElementToVisible(successDiv);
		Thread.sleep(300);
		return successDiv.getText();
	}

	public String inventoryAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (selectAllOperationEditFlags.isSelected()) {
			selectAllOperationEditFlags.click();
		}
		if (!userInventoryManagement.isSelected()) {
			userInventoryManagement.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.WAITING_LIST_URL);
		Thread.sleep(500);
		InventoryManagement.click();
		WebElement confirmText = DriverFactory.getDriver()
				.findElement(By.xpath("//*[@id=\"inStockInventoryDiv\"]/div[1]/h4"));
		return confirmText.getText();
	}

	public String notInventoryAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (selectAllOperationEditFlags.isSelected()) {
			selectAllOperationEditFlags.click();
		}
		if (userInventoryManagement.isSelected()) {
			userInventoryManagement.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.WAITING_LIST_URL);
		Thread.sleep(500);
		LockedInventoryManagement.click();
		WebElement confirmText = DriverFactory.getDriver().findElement(By.className("text-center"));
		return confirmText.getText();
	}

	public String QualityControlAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (selectAllOperationEditFlags.isSelected()) {
			selectAllOperationEditFlags.click();
		}
		if (!QualityControlManagement.isSelected()) {
			QualityControlManagement.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.WAITING_LIST_URL);
		Thread.sleep(500);
		QualityControl.click();
		WebElement confirmText = DriverFactory.getDriver()
				.findElement(By.xpath("//*[@id=\"addQCValueParentDiv\"]/h4/b"));
		return confirmText.getText();
	}

	public String notQualityControlAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (selectAllOperationEditFlags.isSelected()) {
			selectAllOperationEditFlags.click();
		}
		if (QualityControlManagement.isSelected()) {
			QualityControlManagement.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		DriverFactory.getDriver().get(Constants.WAITING_LIST_URL);
		Thread.sleep(500);
		lockQualityControl.click();
		WebElement confirmText = DriverFactory.getDriver().findElement(By.className("text-center"));
		return confirmText.getText();
	}

	public String notEditSignedReportAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (selectAllOperationEditFlags.isSelected()) {
			selectAllOperationEditFlags.click();
		}
		if (editSignedReport.isSelected()) {
			editSignedReport.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		List<WebElement> patientList = container.findElements(By.className("userWaitingListCard"));
		patientList.get(3).click();
		Thread.sleep(200);
		return successDiv.getText();
	}
	public String report;
	public String EditSubmittedReportAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (selectAllOperationEditFlags.isSelected()) {
			selectAllOperationEditFlags.click();
		}
 		if (!editTestFlag.isSelected()) {
			editTestFlag.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		List<WebElement> reportList = userWaitingListCard.findElements(By.xpath("//button[text()=\"Submit\"]"));
		for (int i = 0; i < reportList.size(); i++) {
			if (reportList.get(i).getText().equals("Submit")) {
				reportList.get(i).click();
				break;
			}
		}
		CommonMethods.waitForElementToClickable(submitReport);
		submitReport.click();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(historyli);
		historyli.click();
		CommonMethods.waitForElementToVisible(userWaitingListCard);
		patientList.get(0).click();
		CommonMethods.waitForElementToVisible(historyTestList);
		List<WebElement> reportNames=historyTestList.findElements(By.tagName("b"));
		report=reportNames.get(1).getText();
		waitingListLabOptionList.get(0).click();
		Editthistest.click();
		CommonMethods.waitForElementToVisible(historySuccessDiv);
		return historySuccessDiv.getText();
	}
	
	public boolean EditSubmittedReportNotAccess(String userName, String password) throws Exception {
		signIn(userName, password);
		selectLabUser();
		accordion2.click();

		if (selectAllOperationEditFlags.isSelected()) {
			selectAllOperationEditFlags.click();
		}
 		if (editTestFlag.isSelected()) {
			editTestFlag.click();
		}
		editShowUser.click();
		labUserLogout();
		signIn("livep-dhan", "Password@123");
		clickOnPatientReport();
		List<WebElement> reportList = userWaitingListCard.findElements(By.xpath("//button[text()=\"Submit\"]"));
		for (int i = 0; i < reportList.size(); i++) {
			if (reportList.get(i).getText().equals("Submit")) {
				reportList.get(i).click();
				break;
			}
		}
		CommonMethods.waitForElementToClickable(submitReport);
		submitReport.click();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(historyli);
		historyli.click();
		CommonMethods.waitForElementToVisible(userWaitingListCard);
		patientList.get(0).click();
		CommonMethods.waitForElementToVisible(historyTestList);
		if(waitingListLabOptionList.size()>0) {
			return false;
		}
		return true;
	}

}
