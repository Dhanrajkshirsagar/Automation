package com.livehealth.pageobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;
import com.livehealth.model.BillData;
import com.livehealth.model.User;
import com.livehealth.util.CommonMethods;
import com.livehealth.util.WebContext;

@Component
public class BillUpdatePage {

	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement adminHover;

	@FindBy(how = How.LINK_TEXT, using = "Registration")
	private WebElement registration;

	@FindBy(how = How.XPATH, using = "//*[@id=\"pendingBills\"]/a")
	private WebElement pendingBills;

	@FindBy(how = How.ID, using = "userBillsContainer")
	private WebElement userBillsContainer;

	@FindBy(how = How.XPATH, using = "//*[@id=\"allBillListDateRange\"]/span")
	private WebElement selectDate;

	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div[3]/ul/li[2]")
	private WebElement yesterday;

	@FindBy(how = How.XPATH, using = "//*[@id=\"completedBills\"]/a")
	private WebElement completedBills;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPatientBar\"]/div/div[1]/button")
	private WebElement searchDropdown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPatientBar\"]/div/div[1]/ul/li[1]/a")
	private WebElement byRefName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPatientBar\"]/div/div[1]/ul/li[2]/a")
	private WebElement byUserName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPatientBar\"]/div/div[2]/span/input[2]")
	private WebElement searchTab;

	@FindBy(how = How.ID, using = "labelDiv0")
	private WebElement labelDiv0;

	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Completed')]") })
	public List<WebElement> completed;

	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Pending')]") })
	public List<WebElement> pending;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchBills\"]/a")
	private WebElement searchBills;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div/div[4]/div/div/div[2]/span/span")
	private WebElement selfReferrel;

	@FindBy(how = How.ID, using = "allBillListDateRange")
	private WebElement allBillListDateRange;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Last Quarter')]")
	public WebElement lastQuarter;

	@FindBy(how = How.ID, using = "newDirectFirstName")
	private WebElement newDirectFirstName;

	@FindBy(how = How.ID, using = "newDirectAge")
	private WebElement newDirectAge;

	@FindBy(how = How.ID, using = "newDirectRadiobutton")
	private WebElement newDirectRadiobutton;

	@FindBy(how = How.ID, using = "newDirectMobile")
	private WebElement newDirectMobile;

	@FindBy(how = How.ID, using = "newDirectSaveForm")
	private WebElement newDirectSaveForm;

	@FindBy(how = How.ID, using = "searchPatient")
	private WebElement searchUserForBilling;

	@FindBy(how = How.ID, using = "searchInputforTests")
	private WebElement testList;

	@FindBy(how = How.ID, using = "concession")
	private WebElement concession;

	@FindBy(how = How.XPATH, using = "//*[@id=\"otherInfo\"]/div[1]/span/i")
	private WebElement otherInfo;

	@FindBy(how = How.ID, using = "AdvanceAmount")
	private WebElement advanceAmount;

	@FindBy(how = How.ID, using = "totalAmount")
	private WebElement payableAmount;

	@FindBy(how = How.ID, using = "saveBill")
	private WebElement saveBill;

	@FindBy(how = How.ID, using = "totalAmount")
	private WebElement totalAmount;

	@FindAll({ @FindBy(xpath = "/html/body/section/div[3]/div[2]/div/div[1]/span/span") })
	public List<WebElement> searchUserDropdown;

	@FindAll({ @FindBy(xpath = "//*[@id=\"inputT\"]/span/span/div[1]") })
	public List<WebElement> testListDropdown;

	@FindBy(how = How.ID, using = "referralList")
	private WebElement referralList;

	@FindBy(how = How.ID, using = "billOrg")
	private WebElement billOrg;

	@FindBy(how = How.ID, using = "organizationList")
	private WebElement organizationList;

	@FindBy(how = How.ID, using = "confirmBillId")
	private WebElement confirmBillId;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userAmntDivId\"]/div[2]/b")
	private WebElement patientAdvance;

	@FindBy(how = How.XPATH, using = "//*[@id=\"organizationAmntDivId\"]/div[2]/b")
	private WebElement organizationAdvance;

	@FindBy(how = How.ID, using = "balanceAmount")
	private WebElement balanceAmount;

	@FindBy(how = How.ID, using = "reportModeFlag")
	private WebElement reportModeFlag;

	@FindBy(how = How.ID, using = "userAdvLabel")
	private WebElement userAdvLabel;

	@FindBy(how = How.ID, using = "billTotalAmountLabel")
	private WebElement billTotalAmountLabel;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[4]/div[12]/div/div[2]/p")
	private WebElement testPrice;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[4]/div[1]/div[8]/div/div[2]/p")
	private WebElement firstTestPrice;

	@FindBy(how = How.ID, using = "removeButton")
	private WebElement removeButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"allUpdateBtnsDiv\"]/div/ul/li[1]/a")
	private WebElement justCancelBill;

	@FindBy(how = How.ID, using = "bill_comment")
	private WebElement bill_comment;

	@FindBy(how = How.ID, using = "confirmedBillRemoval")
	private WebElement confirmedBillRemoval;

	@FindBy(how = How.XPATH, using = "//*[@id=\"labBillId\"]/span")
	private WebElement billStatus;

	@FindBy(how = How.ID, using = "submitForm")
	private WebElement submitForm;

	@FindBy(how = How.ID, using = "billLocked")
	private WebElement billLocked;

	@FindBy(how = How.ID, using = "confirmedBillUpdate")
	private WebElement confirmedBillUpdate;

	@FindBy(how = How.ID, using = "writeoffBtn")
	private WebElement writeoffBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"allUpdateBtnsDiv\"]/div/ul/li[3]/a")
	private WebElement removeLastoption;

	@FindBy(how = How.ID, using = "billAdvance")
	private WebElement billAdvance;

	@FindAll({ @FindBy(xpath = "//*[@id=\"parentBillUpdateDiv\"]/div[4]/span/span/div") })
	public List<WebElement> refDropdown;

	@FindAll({ @FindBy(xpath = "//*[@id=\"parentBillUpdateDiv\"]/div[6]/span/span/div") })
	public List<WebElement> orgDropdown;

	@FindBy(how = How.ID, using = "additionalCharges")
	private WebElement additionalCharges;

	@FindBy(how = How.ID, using = "additionalCost")
	private WebElement additionalCost;

	@FindBy(how = How.ID, using = "refundBtn")
	private WebElement refundBtn;

	@FindBy(how = How.ID, using = "clearBtn")
	private WebElement clearBtn;

	@FindBy(how = How.ID, using = "clearBillBtn")
	private WebElement clearBillBtn;

	@FindBy(how = How.ID, using = "editTest0")
	private WebElement editTest0;

	@FindBy(how = How.ID, using = "billTestRefund")
	private WebElement billTestRefund;

	@FindBy(how = How.ID, using = "testRefundComment")
	private WebElement testRefundComment;

	@FindBy(how = How.XPATH, using = "//*[@id=\"individualTestRefundConfirmModal\"]/div/div/div[3]/button[2]")
	private WebElement testRefundConfirmt;

	@FindBy(how = How.XPATH, using = "//*[@id=\"tName0\"]/span[1]")
	private WebElement testStatus;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editTestDiv\"]/ul/li[1]/a")
	private WebElement justCancelTest;

	@FindBy(how = How.ID, using = "testCancelComment")
	private WebElement testCancelComment;

	@FindBy(how = How.XPATH, using = "//*[@id=\"individualConfirmModal\"]/div/div/div[3]/button[2]")
	private WebElement individualConfirmModal;

	@FindBy(how = How.ID, using = "textInput")
	private WebElement textInput;

	@FindBy(how = How.ID, using = "editTestDiv")
	private WebElement editTestDiv;

	@FindBy(how = How.XPATH, using = "//*[@id=\"removeButton\"]")
	private WebElement removeTest;

	@FindBy(how = How.XPATH, using = "(//*[@id=\"removeButton\"])[2]")
	private WebElement removeTest_2;

	@FindBy(how = How.ID, using = "billTestAmount")
	private WebElement billTestAmount;

	@FindBy(how = How.ID, using = "docRevList")
	private WebElement docRevList;

	@FindBy(how = How.ID, using = "billTestConc")
	private WebElement billTestConc;

	@FindBy(how = How.ID, using = "docRevAmount")
	private WebElement docRevAmount;

	@FindBy(how = How.ID, using = "billTestSave")
	private WebElement billTestSave;

	@FindBy(how = How.ID, using = "billReferal")
	private WebElement billReferal;

	@FindBy(how = How.ID, using = "listName")
	private WebElement listName;

	@FindAll({ @FindBy(xpath = "//*[@id=\"listNameParent\"]/div/span/span/div") })
	public List<WebElement> listGrpDropdown;

	@FindBy(how = How.ID, using = "textInput12151")
	private WebElement textInput11869;

	@FindBy(how = How.ID, using = "editBillTestName")
	private WebElement editBillTestName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"test12151\"]/label")
	private WebElement bjpTest;

	@FindBy(how = How.ID, using = "outsourceList")
	private WebElement outsourceList;

	@FindBy(how = How.ID, using = "outsourceAmount")
	private WebElement outsourceAmount;

	@FindBy(how = How.XPATH, using = "//*[@id=\"listOfDoctorSearch\"]/div/div[1]/p")
	private WebElement premiumPlan;

	@FindBy(how = How.ID, using = "textInput12151")
	private WebElement textInput11840;

	@FindBy(how = How.XPATH, using = "//*[@id=\"test12151\"]/label")
	private WebElement proteinAscetic;

	@FindBy(how = How.ID, using = "linkUpdateRefRev")
	private WebElement linkUpdateRefRev;

	@FindBy(how = How.XPATH, using = "//*[@id=\"testListContainer\"]/div[2]/div[2]")
	private WebElement revenueTest;

	@FindBy(how = How.XPATH, using = "//*[@id=\"testListContainer\"]/div[2]/div[3]")
	private WebElement revenueTestPrice;

	@FindBy(how = How.XPATH, using = "//*[@id=\"testListContainer\"]/div[2]/div[4]")
	private WebElement docRevenueAmt;

	@FindBy(how = How.XPATH, using = "//*[@id=\"updateRevModal\"]/div/div/div[3]/button[2]")
	private WebElement updateAmt;

	@FindBy(how = How.XPATH, using = "//*[@id=\"updateRefPriceListModal\"]/div/div/div[3]/button[2]")
	private WebElement updateRefPriceList;

	@FindBy(how = How.XPATH, using = "//*[@id=\"updateOrgModal\"]/div/div/div[3]/button[2]")
	private WebElement updateOrgPriceList;

	@FindBy(how = How.ID, using = "testPrice11840")
	private WebElement testPrice11840;

	@FindBy(how = How.ID, using = "viewPayment")
	private WebElement viewPayment;

	@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[2]")
	private WebElement cashMode;

	@FindBy(how = How.XPATH, using = "//*[@id=\"1\"]/td[5]")
	private WebElement amount;

	@FindBy(how = How.ID, using = "addAnother")
	private WebElement addAnother;

	@FindBy(how = How.ID, using = "paymentAmount_2")
	private WebElement paymentAmount_2;

	@FindBy(how = How.ID, using = "savebillSetting")
	private WebElement savebillSetting;

	@FindBy(how = How.XPATH, using = "//*[@id=\"2\"]/td[2]")
	private WebElement cashMode_2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"2\"]/td[5]")
	private WebElement amount_2;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[4]/div[12]/div/div[2]/p")
	private WebElement test_Price;

	@FindBy(how = How.ID, using = "billLockError")
	private WebElement billLockError;

	@FindBy(how = How.ID, using = "testPrice12151")
	private WebElement testPrice12151;

	@FindBy(how = How.ID, using = "linkUpdateRefPriceList")
	private WebElement linkUpdateRefPriceList;

	@FindBy(how = How.ID, using = "tName0")
	private WebElement tName0;

	@FindBy(how = How.ID, using = "linkUpdateOrgPriceList")
	private WebElement linkUpdateOrgPriceList;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editTestDiv\"]/ul/li[2]/a")
	private WebElement tAmtToAdvance;

	@FindBy(how = How.XPATH, using = "(//*[@id=\"2\"])[3]")
	private WebElement close_2;

	@FindBy(how = How.ID, using = "companyList")
	private WebElement companyList;

	@FindBy(how = How.ID, using = "discountList")
	private WebElement discountList;

	@FindBy(how = How.ID, using = "totalConcessionAmt")
	private WebElement totalConcessionAmt;

	@FindBy(how = How.ID, using = "tName1")
	private WebElement tName1;

	@FindBy(how = How.ID, using = "tName2")
	private WebElement tName2;

	@FindBy(how = How.ID, using = "tName3")
	private WebElement tName3;

	@FindAll({ @FindBy(xpath = "//*[@id=\"inputT\"]/span/span/div[2]") })
	public List<WebElement> profileDropdown;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[4]/div[12]/div[1]/div[2]/p")
	private WebElement tPrice1;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[4]/div[12]/div[2]/div[2]/p")
	private WebElement tPrice2;

	@FindBy(how = How.ID, using = "textInput12347")
	private WebElement textInput12347;

	@FindBy(how = How.ID, using = "totalConcessionType")
	private WebElement totalConcessionType;

	@FindBy(how = How.XPATH, using = "//*[@id=\"viewPaymentModal\"]/div/div/div[4]/button[1]")
	private WebElement paymentModeClose;

	@FindBy(how = How.XPATH, using = "//*[@id=\"updateAmountError\"]/div")
	private WebElement updateAmountError;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Last Week')]")
	public WebElement lastWeek;

	@FindBy(how = How.XPATH, using = "//*[@id=\"updateError\"]/div")
	public WebElement updateError;

	@FindBy(how = How.ID, using = "editTest1")
	private WebElement editTest1;

	@FindBy(how = How.ID, using = "billUserName")
	private WebElement billUserName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userMetaInfo0\"]/div[2]/p/strong")
	public WebElement first_User;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userMetaInfo1\"]/div[2]/p/strong")
	public WebElement second_User;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userMetaInfo2\"]/div[2]/p/strong")
	public WebElement third_User;

	@FindBy(how = How.XPATH, using = "//*[@id=\"confirmBillTestList\"]/div/div[3]/button")
	public WebElement sampleRecived;

	@FindBy(how = How.XPATH, using = "//*[@id=\"testStatus0\"]/span")
	public WebElement testStatus0;

	@FindBy(how = How.XPATH, using = "(//*[@id=\"hoverDropdown\"]/a)[1]")
	public WebElement hoverDropdown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hoverDropdown\"]/ul/li[13]/a")
	public WebElement allDepartments;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userWaiting1317\"]/div/div[1]")
	public WebElement user;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[3]/div[3]/div[1]/div[1]/div[3]")
	public WebElement editFirst;

	@FindBy(how = How.ID, using = "quickSaveBtn")
	private WebElement quickSaveBtn;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'Submit')]") })
	public List<WebElement> submit;

	@FindBy(how = How.ID, using = "quickDefaultDocPass")
	private WebElement quickDefaultDocPass;

	@FindBy(how = How.ID, using = "quickSubmitBtn")
	private WebElement quickSubmitBtn;

	//
	@Autowired
	WebContext webContext;

	@Autowired
	CommonMethods commonMethods;

	@PostConstruct
	public void loadDriver() throws Exception {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}

	public void signIn(String userName, String password) throws Exception {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signIn.click();
		DriverFactory.getDriver().navigate().to(Constants.ALL_BILLSLIST_URL);
	}

	public boolean pendingBillList() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ALL_BILLSLIST_URL);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

//		CommonMethods.waitForElementToVisible(allBillListDateRange);
//		allBillListDateRange.click();
//		lastWeek.click();
		CommonMethods.waitForElementToVisible(pendingBills);
		CommonMethods.waitForElementToClickable(pendingBills);

		js.executeScript("arguments[0].click();", pendingBills);

		CommonMethods.waitForElementToVisible(labelDiv0);
		CommonMethods.waitForElementToClickable(labelDiv0);

		if (completed.size() > 0) {

			return false;
		}

		return true;
	}

	public boolean completedBillList() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ALL_BILLSLIST_URL);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		CommonMethods.waitForElementToVisible(completedBills);
		CommonMethods.waitForElementToClickable(completedBills);

		js.executeScript("arguments[0].click();", completedBills);

		CommonMethods.waitForElementToVisible(labelDiv0);
		CommonMethods.waitForElementToClickable(labelDiv0);

		if (pending.size() > 0) {

			return false;
		}

		return true;
	}

	public boolean searchBillListByRefName() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ALL_BILLSLIST_URL);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		CommonMethods.waitForElementToVisible(searchBills);
		CommonMethods.waitForElementToClickable(searchBills);

		js.executeScript("arguments[0].click();", searchBills);

		CommonMethods.waitForElementToVisible(searchDropdown);
		js.executeScript("arguments[0].click();", searchDropdown);
		CommonMethods.waitForElementToVisible(byRefName);
		js.executeScript("arguments[0].click();", byRefName);

		searchTab.sendKeys("Self");

		CommonMethods.waitForElementToVisible(selfReferrel);
		selfReferrel.click();

		CommonMethods.waitForElementToVisible(userBillsContainer);

		List<WebElement> elements = userBillsContainer.findElements(By.tagName("div"));

		if (elements.size() > 0) {
			return true;
		}

		return false;

	}

	public boolean searchBillListByUserName() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ALL_BILLSLIST_URL);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		CommonMethods.waitForElementToVisible(searchBills);
		CommonMethods.waitForElementToClickable(searchBills);

		js.executeScript("arguments[0].click();", searchBills);

		CommonMethods.waitForElementToVisible(searchDropdown);
		js.executeScript("arguments[0].click();", searchDropdown);
		CommonMethods.waitForElementToVisible(byUserName);
		js.executeScript("arguments[0].click();", byUserName);

		searchTab.sendKeys("Benedict");

		CommonMethods.waitForElementToVisible(selfReferrel);
		selfReferrel.click();

		CommonMethods.waitForElementToVisible(userBillsContainer);

		List<WebElement> elements = userBillsContainer.findElements(By.tagName("div"));

		if (elements.size() > 0) {
			return true;
		}

		return false;

	}

	public void searchToBilling(String userInfo) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.Billing_URL);

		CommonMethods.waitForElementToVisible(searchUserForBilling);
		searchUserForBilling.sendKeys(userInfo);

		CommonMethods.waitForAllElementsToVisible(searchUserDropdown);

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[3]/div[2]/div/div[1]/span/span"));

		dropDowns.get(0).click();
	}

	public void selectTestName(String testName) throws Exception {

		CommonMethods.waitForElementToVisible(testList);
		testList.sendKeys(testName);

		CommonMethods.waitForAllElementsToVisible(testListDropdown);

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[1]"));

		dropDowns.get(0).click();

		concession.sendKeys(Keys.ENTER);

	}

	public List<BillData> billingAndBillUpdate(User user, BillData bill) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		searchToBilling(user.getName());

		CommonMethods.waitForElementToVisible(referralList);
		Select selectRef = new Select(referralList);
		selectRef.selectByVisibleText(bill.getReferrelPriceList());

		selectTestName(bill.getTestName());

		otherInfo.click();
		otherInfo.click();

		Select selectOrganization = new Select(billOrg);
		selectOrganization.selectByVisibleText(bill.getOrganization());

		bill.setPatientAdvance(patientAdvance.getText().trim());
		bill.setPayableAmount(totalAmount.getText());
		bill.setTestPrice(firstTestPrice.getText().trim());

		Select selectReferrel = new Select(referralList);
		String ref = selectReferrel.getFirstSelectedOption().getText().trim();
		bill.setReferrelPriceList(ref);
		// bill.setOrganizationAdvance(organizationAdvance.getText());
		// bill.setBalanceRemaining(balanceAmount.getText());
		// bill.setReportModeFlag(reportModeFlag.isSelected());

		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());

		CommonMethods.waitForElementToVisible(saveBill);
		js.executeScript("arguments[0].click();", saveBill);

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();
		bill.setBillId(billId);

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		BillData updateData = new BillData();

		CommonMethods.waitForElementToVisible(referralList);
		updateData.setReferrelPriceList(referralList.getAttribute("value").trim());
		updateData.setOrganization(organizationList.getAttribute("value").trim());

		String text = userAdvLabel.getText();
		String userAdv = text.substring((text.length() - 6), text.length());

		updateData.setPatientAdvance(userAdv.trim());
		updateData.setPayableAmount(billTotalAmountLabel.getText());
		updateData.setTestPrice(testPrice.getText().trim());
		// updateData.setBalanceRemaining(balanceAmount.getText());

		return Arrays.asList(bill, updateData);
	}

	public List<String> justCancelBill(User user, BillData bill) throws Exception {

		List<BillData> billData = billingAndBillUpdate(user, bill);
		String billId = billData.get(0).getBillId();

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		unlockBill(billId);
		int attempts = 0;

		while (attempts < 2) {
			try {
				CommonMethods.waitForElementToVisible(removeButton);
				js.executeScript("arguments[0].click();", removeButton);

				CommonMethods.waitForElementToVisible(justCancelBill);
				js.executeScript("arguments[0].click();", justCancelBill);

				attempts = 4;
			} catch (Exception e) {
				driver.navigate().refresh();
				unlockBill(billId);
				attempts++;
			}
		}

		CommonMethods.waitForElementToVisible(bill_comment);
		bill_comment.sendKeys("remove");

		js.executeScript("arguments[0].click();", confirmedBillRemoval);

		driver.navigate().refresh();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		CommonMethods.waitForElementToVisible(billStatus);

		return Arrays.asList(billStatus.getText(), billId);
	}

	public void unlockBill(String billId) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		CommonMethods.waitForElementToVisible(submitForm);
		js.executeScript("arguments[0].click();", submitForm);

		CommonMethods.waitForElementToVisible(billLocked);

		if (billLocked.isSelected()) {
			js.executeScript("arguments[0].click();", billLocked);
		}
		confirmedBillUpdate.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
	}

	public String writeOffBill(User user, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<BillData> billData = billingAndBillUpdate(user, bill);
		String billId = billData.get(0).getBillId();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		unlockBill(billId);

		int attempts = 0;

		while (attempts < 2) {
			try {
				CommonMethods.waitForElementToVisible(writeoffBtn);
				js.executeScript("arguments[0].click();", writeoffBtn);

				attempts = 4;
			} catch (Exception e) {
				driver.navigate().refresh();
				unlockBill(billId);
				attempts++;
			}
		}

		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		CommonMethods.waitForElementToVisible(billStatus);
		return billStatus.getText();
	}

	public List<String> cancelAndClearBillPaymentAndAmount(User user, BillData bill) throws Exception {

		List<BillData> billData = billingAndBillUpdate(user, bill);
		String billId = billData.get(0).getBillId();

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		unlockBill(billId);

		CommonMethods.waitForElementToVisible(removeButton);
		js.executeScript("arguments[0].click();", removeButton);

		CommonMethods.waitForElementToVisible(removeLastoption);
		js.executeScript("arguments[0].click();", removeLastoption);

		CommonMethods.waitForElementToVisible(bill_comment);
		bill_comment.sendKeys("remove");

		js.executeScript("arguments[0].click();", confirmedBillRemoval);

		driver.navigate().refresh();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);
		String payableAmt = billTotalAmountLabel.getText();
		String advancePaid = billAdvance.getAttribute("value");

		return Arrays.asList(payableAmt, advancePaid);
	}

	public List<BillData> billUpdate(User user, BillData bill) throws Exception {

		List<BillData> billData = billingAndBillUpdate(user, bill);
		String billId = billData.get(0).getBillId();

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		unlockBill(billId);
		BillData billInfo = generatBillDataForUpdation();

		CommonMethods.waitForElementToVisible(referralList);
		referralList.clear();
		referralList.sendKeys(billInfo.getReferrelPriceList());

		CommonMethods.waitForAllElementsToVisible(refDropdown);
		refDropdown.get(0).click();

		organizationList.clear();
		organizationList.sendKeys(billInfo.getOrganization());

		CommonMethods.waitForAllElementsToVisible(orgDropdown);
		orgDropdown.get(0).click();

		Select services = new Select(additionalCharges);
		services.selectByVisibleText(billInfo.getAdditionalServices());

		additionalCost.clear();
		additionalCost.sendKeys(billInfo.getAdditionalPrice());

		submitForm.click();

		CommonMethods.waitForElementToVisible(confirmedBillUpdate);
		confirmedBillUpdate.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		BillData updated = new BillData();

		CommonMethods.waitForElementToVisible(referralList);
		updated.setReferrelPriceList(referralList.getAttribute("value"));
		updated.setOrganization(organizationList.getAttribute("value"));
		updated.setAdditionalServices(services.getFirstSelectedOption().getText());
		updated.setAdditionalPrice(additionalCost.getAttribute("value"));

		return Arrays.asList(billInfo, updated);
	}

	private BillData generatBillDataForUpdation() {

		BillData billData = new BillData();

		billData.setReferrelPriceList("SELF");
		billData.setOrganization("DIRECT");
		billData.setAdditionalServices("Home Visit Services");
		billData.setAdditionalPrice("5");

		return billData;
	}

	public String refundBill(User user, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<BillData> billData = billingAndBillUpdate(user, bill);
		String billId = billData.get(0).getBillId();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		unlockBill(billId);

		CommonMethods.waitForElementToVisible(refundBtn);
		js.executeScript("arguments[0].click();", refundBtn);

		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		boolean enabled = viewPayment.isEnabled();

		CommonMethods.waitForElementToVisible(billStatus);
		return billStatus.getText();
	}

	public String resetBill(String billId) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(clearBtn);
		js.executeScript("arguments[0].click();", clearBtn);

		CommonMethods.waitForElementToVisible(clearBillBtn);
		js.executeScript("arguments[0].click();", clearBillBtn);

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(billStatus);

		return billStatus.getText();
	}

	public List<String> singleTestRefund(String billId) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(editTest0);
		js.executeScript("arguments[0].click();", editTest0);

		CommonMethods.waitForElementToVisible(billTestRefund);
		js.executeScript("arguments[0].click();", billTestRefund);

		CommonMethods.waitForElementToVisible(testRefundComment);
		testRefundComment.sendKeys("refundtest");

		js.executeScript("arguments[0].click();", testRefundConfirmt);

		CommonMethods.waitForElementToVisible(submitForm);
		js.executeScript("arguments[0].click();", submitForm);

		CommonMethods.waitForElementToVisible(confirmedBillUpdate);
		js.executeScript("arguments[0].click();", confirmedBillUpdate);

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(testStatus);

		String status = testStatus.getText();

		String price = testPrice.getText().trim();

		return Arrays.asList(status, price);
	}

	public List<String> justCancelSingleTest(User user, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		searchToBilling(user.getName());
		selectTestName("Ionised Calcium");

		CommonMethods.waitForElementToVisible(saveBill);
		js.executeScript("arguments[0].click();", saveBill);

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();
		bill.setBillId(billId);

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		unlockBill(billId);

		CommonMethods.waitForElementToVisible(editTest0);
		js.executeScript("arguments[0].click();", editTest0);

		CommonMethods.waitForElementToVisible(removeTest_2);
		js.executeScript("arguments[0].click();", removeTest_2);

		CommonMethods.waitForElementToVisible(justCancelTest);
		js.executeScript("arguments[0].click();", justCancelTest);

		CommonMethods.waitForElementToVisible(testCancelComment);
		testCancelComment.sendKeys("remove");

		js.executeScript("arguments[0].click();", individualConfirmModal);

		CommonMethods.waitForElementToVisible(submitForm);
		js.executeScript("arguments[0].click();", submitForm);

		CommonMethods.waitForElementToVisible(confirmedBillUpdate);
		js.executeScript("arguments[0].click();", confirmedBillUpdate);

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);
		String payableAmt = billTotalAmountLabel.getText();
		String advancedpaid = test_Price.getText().trim();

		return Arrays.asList(payableAmt, advancedpaid);
	}

	public String cancelWithAddTestAmountToAdvance(String userName, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		getBillWithAddedReferrel(userName, bill);

		CommonMethods.waitForElementToVisible(editTest0);
		editTest0.click();

		CommonMethods.waitForElementToVisible(removeTest_2);
		removeTest_2.click();

		CommonMethods.waitForElementToVisible(tAmtToAdvance);
		tAmtToAdvance.click();

		CommonMethods.waitForElementToVisible(testCancelComment);
		testCancelComment.sendKeys("remove");

		individualConfirmModal.click();

		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(viewPayment);
		viewPayment.click();

		CommonMethods.waitForElementToVisible(close_2);
		close_2.click();

		savebillSetting.click();

		CommonMethods.waitForElementToVisible(submitForm);
		submitForm.click();

		CommonMethods.waitForElementToVisible(confirmedBillUpdate);
		confirmedBillUpdate.click();

		driver.navigate().to(Constants.BillingUpdate_URL + bill.getBillId());
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(userAdvLabel);
		String text = userAdvLabel.getText();
		String userAdv = text.substring((text.length() - 6), text.length());

		return userAdv.trim();

	}

	public List<BillData> editLinkVerification(User user, BillData bill) throws Exception {

		List<BillData> billData = billingAndBillUpdate(user, bill);
		String billId = billData.get(0).getBillId();

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		unlockBill(billId);
		BillData testInfo = testEditdata();

		CommonMethods.waitForElementToVisible(editTest0);
		js.executeScript("arguments[0].click();", editTest0);

		CommonMethods.waitForElementToVisible(billTestAmount);
		billTestAmount.clear();
		billTestAmount.sendKeys(testInfo.getTestPrice());

		billTestConc.clear();
		billTestConc.sendKeys(testInfo.getConcession());

		Select referrel = new Select(docRevList);
		referrel.selectByVisibleText(testInfo.getReferrel());

		docRevAmount.clear();
		docRevAmount.sendKeys(testInfo.getAmountPaid());

		js.executeScript("arguments[0].click();", billTestSave);

		CommonMethods.waitForElementToVisible(submitForm);
		js.executeScript("arguments[0].click();", submitForm);

		CommonMethods.waitForElementToVisible(confirmedBillUpdate);
		js.executeScript("arguments[0].click();", confirmedBillUpdate);

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(editTest0);
		js.executeScript("arguments[0].click();", editTest0);

		BillData testUpdated = new BillData();

		CommonMethods.waitForElementToVisible(docRevList);
		testUpdated.setTestPrice(billTestAmount.getAttribute("value"));
		testUpdated.setConcession(billTestConc.getAttribute("value"));
		testUpdated.setReferrel(referrel.getFirstSelectedOption().getText().trim());
		testUpdated.setAmountPaid(docRevAmount.getAttribute("value"));

		return Arrays.asList(testInfo, testUpdated);
	}

	private BillData testEditdata() {

		BillData billData = new BillData();

		billData.setTestPrice("300");
		billData.setConcession("10");
		billData.setReferrel("Delative");
		billData.setAmountPaid("10");

		return billData;
	}

	public List<BillData> doctorRevenueAmountVerification(String userName, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		getBillWithAddedReferrel(userName, bill);

		CommonMethods.waitForElementToVisible(editTest0);
		editTest0.click();

		CommonMethods.waitForElementToVisible(docRevList);
		Select select = new Select(docRevList);

		bill.setTestName(editBillTestName.getText().trim());
		bill.setReferrel(select.getFirstSelectedOption().getText().trim());
		bill.setAmountPaid(docRevAmount.getAttribute("value"));
		bill.setReferrelPriceList(null);
		bill.setOrganization(null);

		driver.navigate().to(Constants.ListAndGroupManagement_URL);

		BillData billData = new BillData();

		CommonMethods.waitForElementToVisible(listName);
		listName.sendKeys("Dr. Delative ");

		CommonMethods.waitForElementToVisible(listGrpDropdown.get(0));
		listGrpDropdown.get(0).click();

		CommonMethods.waitForElementToVisible(textInput11869);
		String test = bjpTest.getText().trim();
		String refRevenue = textInput11869.getAttribute("value");

		billData.setTestName(test);
		billData.setReferrel("Dhanraj");
		billData.setAmountPaid(refRevenue);

		return Arrays.asList(bill, billData);
	}

	public List<BillData> getBillWithAddedReferrel(String userName, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		searchToBilling(userName);
		selectTest(bill.getTestName());

		otherInfo.click();
		otherInfo.click();

		Select referrel = new Select(billReferal);
		referrel.selectByVisibleText("Dhanraj");

		Select org = new Select(billOrg);
		org.selectByVisibleText("Co Pay");

		BillData billData = new BillData();

		billData.setReferrel(referrel.getFirstSelectedOption().getText());
		billData.setOrganization(org.getFirstSelectedOption().getText());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();
		bill.setBillId(billId);

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		unlockBill(billId);

		BillData billInfo = new BillData();

		CommonMethods.waitForElementToVisible(referralList);
		billInfo.setReferrel(referralList.getAttribute("value"));
		billInfo.setOrganization(organizationList.getAttribute("value"));

		return Arrays.asList(billData, billInfo);
	}

	private void selectTest(String testName) throws Exception {

		CommonMethods.waitForElementToVisible(testList);
		testList.sendKeys(testName);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span"));

		dropDowns.get(0).click();

		concession.sendKeys(Keys.ENTER);
	}

	public List<BillData> outsourceAmountDetails(String userName, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		getBillWithAddedReferrel(userName, bill);

		CommonMethods.waitForElementToVisible(editTest0);
		editTest0.click();

		Select select = new Select(outsourceList);
		String outlistName = select.getFirstSelectedOption().getText();

		BillData billData = new BillData();

		billData.setOutSouceList(outlistName);
		billData.setAmountPaid(outsourceAmount.getAttribute("value"));
		billData.setTestName(editBillTestName.getText());

		driver.navigate().to(Constants.ListAndGroupManagement_URL);

		BillData billInfo = new BillData();

		CommonMethods.waitForElementToVisible(listName);
		listName.sendKeys("Normal Outsource");

		CommonMethods.waitForElementToVisible(listGrpDropdown.get(0));
		listGrpDropdown.get(0).click();

		billInfo.setOutSouceList(premiumPlan.getText().trim());
		billInfo.setAmountPaid(textInput11840.getAttribute("value"));
		billInfo.setTestName(proteinAscetic.getText());

		return Arrays.asList(billData, billInfo);
	}

	public List<BillData> updateDoctorRevenueLink(String userName, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		getBillWithAddedReferrel(userName, bill);

		CommonMethods.waitForElementToVisible(referralList);
		referralList.clear();
		referralList.sendKeys("dhanraj");

		CommonMethods.waitForAllElementsToVisible(refDropdown);
		refDropdown.get(0).click();

		CommonMethods.waitForElementToVisible(linkUpdateRefRev);
		linkUpdateRefRev.click();

		CommonMethods.waitForElementToVisible(revenueTest);
		String tName = revenueTest.getText();
		String tPrice = revenueTestPrice.getText();
		String revenAmt = docRevenueAmt.getText();

		BillData billData = new BillData();

		billData.setTestName(tName);
		billData.setTestPrice(tPrice);
		billData.setConcession(revenAmt);

		updateAmt.click();

		driver.navigate().to(Constants.ListAndGroupManagement_URL);

		BillData billInfo = new BillData();

		CommonMethods.waitForElementToVisible(listName);
		listName.sendKeys("Dr. Delative");

		CommonMethods.waitForElementToVisible(listGrpDropdown.get(0));
		listGrpDropdown.get(0).click();

		String t_Name = proteinAscetic.getText();
		String t_Price = testPrice12151.getAttribute("value");
		String t_Concession = textInput11840.getAttribute("value");

		billInfo.setTestName(t_Name);
		billInfo.setTestPrice(t_Price);
		billInfo.setConcession(t_Concession);

		return Arrays.asList(billData, billInfo);
	}

	public List<BillData> updatePriceListLink(String userName, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		getBillWithAddedReferrel(userName, bill);

		CommonMethods.waitForElementToVisible(referralList);
		referralList.clear();
		referralList.sendKeys("sumit");

		CommonMethods.waitForAllElementsToVisible(refDropdown);
		refDropdown.get(0).click();

		CommonMethods.waitForElementToVisible(linkUpdateRefPriceList);
		linkUpdateRefPriceList.click();

		CommonMethods.waitForElementToVisible(updateRefPriceList);
		updateRefPriceList.click();

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);
		String totalAmt = billTotalAmountLabel.getText();
		String tname = tName0.getText().trim();

		BillData billData = new BillData();

		billData.setTestName(tname);
		billData.setTestPrice(totalAmt);

		driver.navigate().to(Constants.ListAndGroupManagement_URL);

		BillData billInfo = new BillData();

		CommonMethods.waitForElementToVisible(listName);
		listName.sendKeys("Ref Dhanraj");

		CommonMethods.waitForElementToVisible(listGrpDropdown.get(0));
		listGrpDropdown.get(0).click();

		String t_Name = proteinAscetic.getText();
		String t_Price = textInput11840.getAttribute("value");

		billInfo.setTestName(t_Name);
		billInfo.setTestPrice(t_Price);

		return Arrays.asList(billData, billInfo);
	}

	public List<BillData> updateOrganizationPriceListLink(String userName, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		getBillWithAddedReferrel(userName, bill);

		CommonMethods.waitForElementToVisible(organizationList);
		organizationList.clear();
		organizationList.sendKeys("postpaid Organization");

		CommonMethods.waitForAllElementsToVisible(orgDropdown);
		orgDropdown.get(0).click();

		CommonMethods.waitForElementToVisible(linkUpdateOrgPriceList);
		linkUpdateOrgPriceList.click();

		CommonMethods.waitForElementToVisible(updateOrgPriceList);
		updateOrgPriceList.click();

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);
		String totalAmt = billTotalAmountLabel.getText();
		String tname = tName0.getText().trim();

		BillData billData = new BillData();

		billData.setTestName(tname);
		billData.setTestPrice(totalAmt);

		driver.navigate().to(Constants.ListAndGroupManagement_URL);

		BillData billInfo = new BillData();

		CommonMethods.waitForElementToVisible(listName);
		listName.sendKeys("Postpaid Organization");

		CommonMethods.waitForElementToVisible(listGrpDropdown.get(0));
		listGrpDropdown.get(0).click();

		String t_Name = proteinAscetic.getText();
		String t_Price = textInput11840.getAttribute("value");

		billInfo.setTestName(t_Name);
		billInfo.setTestPrice(t_Price);

		return Arrays.asList(billData, billInfo);
	}

	public List<BillData> viewPaymentLink(String userName, String testName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		searchToBilling(userName);
		selectTest(testName);

		BillData bill = new BillData();

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());

		bill.setTestPrice(totalAmount.getText());
		bill.setConcession("CASH");

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(viewPayment);
		viewPayment.click();

		BillData billing = new BillData();

		CommonMethods.waitForElementToVisible(cashMode);
		String cash = cashMode.getText();

		String amt = amount.getText();

		billing.setTestPrice(amt);
		billing.setConcession(cash);

		return Arrays.asList(bill, billing);
	}

	public List<BillData> submitButton(String userName, String testName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		searchToBilling(userName);
		selectTest(testName);

		BillData bill = new BillData();

		CommonMethods.waitForElementToVisible(totalAmount);
		bill.setTestPrice(totalAmount.getText());
		bill.setConcession("CASH");

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(viewPayment);
		viewPayment.click();

		BillData billing = new BillData();

		CommonMethods.waitForElementToVisible(addAnother);
		addAnother.click();

		CommonMethods.waitForElementToVisible(paymentAmount_2);
		paymentAmount_2.clear();
		paymentAmount_2.sendKeys(bill.getTestPrice());

		savebillSetting.click();
		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(viewPayment);
		viewPayment.click();

		CommonMethods.waitForElementToVisible(cashMode_2);
		String type = cashMode_2.getText();
		String amt = amount_2.getText();

		billing.setTestPrice(amt);
		billing.setConcession(type);

		return Arrays.asList(bill, billing);
	}

	public String lockBill(String billId) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(submitForm);
		js.executeScript("arguments[0].click();", submitForm);

		CommonMethods.waitForElementToVisible(billLocked);

		if (!billLocked.isSelected()) {
			js.executeScript("arguments[0].click();", billLocked);
		}
		confirmedBillUpdate.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(billLockError);
		String error = billLockError.getText();

		String errorMsg = error.substring(1, error.length());

		return errorMsg.trim();
	}

	public List<BillData> referrelPriceList(String userName, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		searchToBilling(userName);

		CommonMethods.waitForElementToVisible(referralList);
		Select selectRef = new Select(referralList);
		selectRef.selectByVisibleText(bill.getReferrelPriceList());

		selectTestName(bill.getTestName());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);
		String totalAmt = billTotalAmountLabel.getText();
		String tName = tName0.getText();

		BillData billData = new BillData();

		billData.setTestPrice(totalAmt);
		billData.setTestName(tName);

		driver.navigate().to(Constants.ListAndGroupManagement_URL);

		BillData billInfo = new BillData();

		CommonMethods.waitForElementToVisible(listName);
		listName.sendKeys("Ref Dhanraj");

		CommonMethods.waitForElementToVisible(listGrpDropdown.get(0));
		listGrpDropdown.get(0).click();

		String t_Name = proteinAscetic.getText();
		String t_Price = textInput11840.getAttribute("value");

		billInfo.setTestName(t_Name);
		billInfo.setTestPrice(t_Price);

		return Arrays.asList(billData, billInfo);
	}

	public List<BillData> organizationPriceList(String userName, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		searchToBilling(userName);
		organizationPriceListTest(bill.getTestName(), bill.getOrganizationPriceList());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);
		String totalAmt = billTotalAmountLabel.getText();
		String tName = tName0.getText();

		BillData billData = new BillData();

		billData.setTestPrice(totalAmt);
		billData.setTestName(tName);

		driver.navigate().to(Constants.ListAndGroupManagement_URL);

		BillData billInfo = new BillData();

		CommonMethods.waitForElementToVisible(listName);
		listName.sendKeys("Postpaid Organization");

		CommonMethods.waitForElementToVisible(listGrpDropdown.get(0));
		listGrpDropdown.get(0).click();

		String t_Name = proteinAscetic.getText();
		String t_Price = textInput11840.getAttribute("value");

		billInfo.setTestName(t_Name);
		billInfo.setTestPrice(t_Price);

		return Arrays.asList(billData, billInfo);
	}

	private void organizationPriceListTest(String testName, String company) throws Exception {

		CommonMethods.waitForElementToVisible(companyList);
		Select org = new Select(companyList);
		org.selectByVisibleText(company);

		CommonMethods.waitForElementToVisible(testList);
		testList.sendKeys(testName);

		CommonMethods.waitForAllElementsToVisible(testListDropdown);

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[1]"));

		dropDowns.get(0).click();

		concession.sendKeys(Keys.ENTER);

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());
	}

	public List<String> discountPriceList(String userName, BillData bill) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		searchToBilling(userName);

		CommonMethods.waitForElementToVisible(discountList);
		Select org = new Select(discountList);
		org.selectByVisibleText(bill.getDiscountPriceList());

		discountPriceListTest();

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(totalConcessionAmt);

		String concessn = totalConcessionAmt.getAttribute("value");

		driver.navigate().to(Constants.ListAndGroupManagement_URL);

		CommonMethods.waitForElementToVisible(listName);
		listName.sendKeys("Discount list");

		CommonMethods.waitForElementToVisible(listGrpDropdown.get(0));
		listGrpDropdown.get(0).click();

		int t1 = Integer.parseInt(textInput11840.getAttribute("value"));
		int t2 = Integer.parseInt(textInput12347.getAttribute("value"));

		String tAmt = String.valueOf(t1 + t2);

		return Arrays.asList(concessn, tAmt);
	}

	private void discountPriceListTest() throws Exception {

		String[] tList = { "Ionised Calcium", "Glucose PP" };

		for (int index = 0; index < tList.length; index++) {

			CommonMethods.waitForElementToVisible(testList);
			testList.sendKeys(tList[index]);

			CommonMethods.waitForAllElementsToVisible(profileDropdown);

			List<WebElement> dropDowns = DriverFactory.getDriver()
					.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]"));

			dropDowns.get(0).click();

			concession.sendKeys(Keys.ENTER);
		}
		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());
	}

	public List<String> profileTest(String userName, String profile) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		searchToBilling(userName);
		selectProfile(profile);

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(tName1);
		String t_Name1 = tName1.getText();
		String t_Name2 = tName2.getText();
		String t_Name3 = tName3.getText();

		List<String> tList = new ArrayList<String>();
		tList.add(t_Name1);
		tList.add(t_Name2);
		tList.add(t_Name3);

		return tList;
	}

	private void selectProfile(String profile) throws Exception {

		CommonMethods.waitForElementToVisible(testList);
		testList.sendKeys(profile);

		CommonMethods.waitForAllElementsToVisible(profileDropdown);

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]"));

		dropDowns.get(0).click();

		concession.sendKeys(Keys.ENTER);
	}

	public String cancelTestFromMultipleTest(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		createBill(userName);

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(editTest0);
		editTest0.click();
		CommonMethods.waitForElementToVisible(removeTest_2);
		removeTest_2.click();

		CommonMethods.waitForElementToVisible(justCancelTest);
		justCancelTest.click();

		CommonMethods.waitForElementToVisible(testCancelComment);
		testCancelComment.sendKeys("remove");

		individualConfirmModal.click();

		CommonMethods.waitForElementToVisible(submitForm);
		js.executeScript("arguments[0].click();", submitForm);

		CommonMethods.waitForElementToVisible(confirmedBillUpdate);
		confirmedBillUpdate.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);
		String payableAmt = billTotalAmountLabel.getText();

		return payableAmt;
	}

	private void createBill(String userName) throws Exception {

		String[] tests = { "Ionised Calcium", "Albumin Serum", "Protein Ascitic Fluid *" };

		searchToBilling(userName);

		for (int index = 0; index < tests.length; index++) {

			CommonMethods.waitForElementToVisible(testList);

			testList.sendKeys(tests[index]);

			CommonMethods.waitForAllElementsToVisible(profileDropdown);

			List<WebElement> dropDowns = DriverFactory.getDriver()
					.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]"));

			dropDowns.get(0).click();

			concession.sendKeys(Keys.ENTER);
		}
	}

	public String refundTestFromMultipleTest(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		createBill(userName);

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(editTest0);
		editTest0.click();

		CommonMethods.waitForElementToVisible(billTestRefund);
		billTestRefund.click();

		CommonMethods.waitForElementToVisible(testRefundComment);
		testRefundComment.sendKeys("refundtest");

		testRefundConfirmt.click();

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);

		return billTotalAmountLabel.getText();
	}

	public String percentagewiseConcession(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		createBill(userName);

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(totalConcessionType);
		Select org = new Select(totalConcessionType);
		org.selectByValue("Percentage");

		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("20");

		CommonMethods.waitForElementToVisible(submitForm);
		submitForm.click();

		CommonMethods.waitForElementToVisible(confirmedBillUpdate);
		confirmedBillUpdate.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);

		return billTotalAmountLabel.getText();
	}

	public String cashPaymentInCaseOfUserAdvance(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		searchToBilling(userName);

		CommonMethods.waitForElementToVisible(testList);

		testList.sendKeys("Ionised Calcium");

		CommonMethods.waitForAllElementsToVisible(profileDropdown);

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]"));

		dropDowns.get(0).click();

		concession.sendKeys(Keys.ENTER);

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(viewPayment);
		viewPayment.click();

		CommonMethods.waitForElementToVisible(cashMode);
		String mode = cashMode.getText();

		paymentModeClose.click();
		return mode;
	}

	public String moreThanAllowedDiscount() throws Exception {

		CommonMethods.waitForElementToVisible(totalConcessionType);
		Select org = new Select(totalConcessionType);
		org.selectByValue("Percentage");

		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("60");

		billTotalAmountLabel.click();
		CommonMethods.waitForElementToVisible(updateAmountError);
		String str = updateAmountError.getText();

		String erroMsg = str.substring(1, str.length()).trim();

		return erroMsg;
	}

	public String concessionInRupees() throws Exception {

		CommonMethods.waitForElementToVisible(totalConcessionType);
		Select org = new Select(totalConcessionType);
		org.selectByValue("Rupees");

		totalConcessionAmt.clear();
		billTotalAmountLabel.click();

		int beforeConession = Integer.parseInt(billTotalAmountLabel.getText());

		totalConcessionAmt.sendKeys("60");

		billTotalAmountLabel.click();

		int afterConession = Integer.parseInt(billTotalAmountLabel.getText());

		String discount = String.valueOf(beforeConession - afterConession);

		return discount;
	}

	public String additionalPriceVerification(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		createBill(userName);

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(additionalCost);
		additionalCost.clear();
		additionalCost.sendKeys("10");

		CommonMethods.waitForElementToVisible(submitForm);
		submitForm.click();

		CommonMethods.waitForElementToVisible(confirmedBillUpdate);
		confirmedBillUpdate.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);

		return billTotalAmountLabel.getText();
	}

	public String advancedPaidAmountGreaterThanPayableAmount(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		createBill(userName);
		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(viewPayment);
		viewPayment.click();

		CommonMethods.waitForElementToVisible(addAnother);
		addAnother.click();

		CommonMethods.waitForElementToVisible(paymentAmount_2);
		paymentAmount_2.clear();
		paymentAmount_2.sendKeys("10");

		savebillSetting.click();

		CommonMethods.waitForElementToVisible(submitForm);
		submitForm.click();

		CommonMethods.waitForElementToVisible(updateError);
		String str = updateError.getText();

		String errorMsg = str.substring(1, str.length()).trim();
		return errorMsg;
	}

	public String referrelNameAfterReset(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		createBill(userName);

		otherInfo.click();
		otherInfo.click();

		Select referrel = new Select(billReferal);
		referrel.selectByVisibleText("Dhanraj");

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(referralList);
		referralList.clear();
		referralList.sendKeys("delative");

		CommonMethods.waitForAllElementsToVisible(refDropdown);
		refDropdown.get(0).click();

		CommonMethods.waitForElementToVisible(linkUpdateRefRev);
		linkUpdateRefRev.click();

		CommonMethods.waitForElementToVisible(updateAmt);
		updateAmt.click();

		CommonMethods.waitForElementToVisible(submitForm);
		submitForm.click();

		CommonMethods.waitForElementToVisible(confirmedBillUpdate);
		confirmedBillUpdate.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(removeButton);
		removeButton.click();

		CommonMethods.waitForElementToVisible(justCancelBill);
		justCancelBill.click();

		CommonMethods.waitForElementToVisible(bill_comment);
		bill_comment.sendKeys("remove");

		confirmedBillRemoval.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		CommonMethods.waitForElementToVisible(clearBtn);
		clearBtn.click();

		CommonMethods.waitForElementToVisible(clearBillBtn);
		clearBillBtn.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		Thread.sleep(1000);
		driver.navigate().refresh();
		return referralList.getText();
	}

	public String refundAndCancelTests(String userName) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		WebDriver driver = DriverFactory.getDriver();

		createBill(userName);

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(editTest0);
		editTest0.click();

		CommonMethods.waitForElementToVisible(billTestRefund);
		billTestRefund.click();

		CommonMethods.waitForElementToVisible(testRefundComment);
		testRefundComment.sendKeys("refundtest");

		testRefundConfirmt.click();

		CommonMethods.waitForElementToVisible(editTest1);
		js.executeScript("arguments[0].click();", editTest1);

		CommonMethods.waitForElementToVisible(removeTest_2);
		removeTest_2.click();

		CommonMethods.waitForElementToVisible(justCancelTest);
		justCancelTest.click();

		CommonMethods.waitForElementToVisible(testCancelComment);
		testCancelComment.sendKeys("remove");

		individualConfirmModal.click();

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);
		return billTotalAmountLabel.getText();
	}

	public String checkStatusIfPaidTotalBillAmount(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		createBill(userName);

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(billStatus);

		return billStatus.getText();
	}

	public String checkStatusIfPaidPartialBillAmount(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		createBill(userName);

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys("100");

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(billStatus);

		return billStatus.getText();
	}

	public String nameGenderAgeVerification(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		createBill(userName);

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(billUserName);

		return billUserName.getText();
	}

	public String concessionToOutsourceTest(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		searchToBilling(userName);

		CommonMethods.waitForElementToVisible(testList);
		testList.sendKeys("Mantoux test Tuberculin test *");

		CommonMethods.waitForAllElementsToVisible(profileDropdown);

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]"));

		dropDowns.get(0).click();

		concession.sendKeys(Keys.ENTER);

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		driver.navigate().refresh();
		CommonMethods.waitForElementToVisible(totalConcessionAmt);
		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("50");

		billTotalAmountLabel.click();
		CommonMethods.waitForElementToVisible(updateAmountError);
		String str = updateAmountError.getText();

		String errorMsg = str.substring(1, str.length()).trim();

		return errorMsg;
	}

	public List<String> billOrder() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		String[] names = { "Firstuser", "Seconduser", "Thirduser" };

		for (String name : names) {
			createBill(name);
			CommonMethods.waitForElementToVisible(saveBill);
			saveBill.click();
			driver.navigate().to(Constants.Billing_URL);
		}

		driver.navigate().to(Constants.ALL_BILLSLIST_URL);

		CommonMethods.waitForElementToVisible(first_User);
		String user1 = first_User.getText().trim();
		String user2 = second_User.getText().trim();
		String user3 = third_User.getText().trim();

		List<String> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);

		return list;
	}

	public List<String> showingDueCorrectly(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		createBill(userName);

		String due = totalAmount.getText();
		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(userAdvLabel);
		String str = userAdvLabel.getText();

		String dueAmt = str.substring(str.indexOf("₹") + 1, str.length()).trim();

		return Arrays.asList(due, dueAmt);
	}

	public String payableAmountAfterRefund(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		createBill(userName);

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys("270");

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(refundBtn);
		refundBtn.click();
		Thread.sleep(10000);
		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);

		return billTotalAmountLabel.getText();
	}

	public List<String> partialPaymentBillUpdateVerification(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		createBill(userName);

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys("270");

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(viewPayment);
		viewPayment.click();

		CommonMethods.waitForElementToVisible(addAnother);
		addAnother.click();

		CommonMethods.waitForElementToVisible(paymentAmount_2);
		paymentAmount_2.clear();
		paymentAmount_2.sendKeys("500");

		savebillSetting.click();
		CommonMethods.waitForElementToVisible(submitForm);
		submitForm.click();

		CommonMethods.waitForElementToVisible(confirmedBillUpdate);
		confirmedBillUpdate.click();
		Thread.sleep(10000);
		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);
		String payableAmt = billTotalAmountLabel.getText();
		String balanceAmt = balanceAmount.getText();

		List<String> list = new ArrayList<>();
		list.add(payableAmt);
		list.add(balanceAmt);

		return list;
	}

	public List<String> partialPaymentWithProfileTest(String userName, String profile) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		searchToBilling(userName);
		selectProfile(profile);
		selectProfile("bjp");

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys("100");

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		CommonMethods.waitForElementToVisible(billTotalAmountLabel);
		String payableAmt = billTotalAmountLabel.getText();
		String balanceAmt = balanceAmount.getText();

		List<String> list = new ArrayList<>();
		list.add(payableAmt);
		list.add(balanceAmt);

		return list;
	}

	public String notFilledStatusVerification(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		String billId = receiveSample(userName);

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(testStatus0);

		return testStatus0.getText();
	}

	private String receiveSample(String userName) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		WebDriver driver = DriverFactory.getDriver();
		searchToBilling(userName);
		selectProfile("Mantoux test Tuberculin test");

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		String originalHandle = driver.getWindowHandle();

		CommonMethods.waitForElementToVisible(sampleRecived);
		js.executeScript("arguments[0].click();", sampleRecived);

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);

		return billId;
	}

	public String pendingApprovalStatusVerification(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		String billId = receiveSample(userName);

		driver.navigate().to(Constants.WAITING_LIST_URL);
		CommonMethods.waitForElementToVisible(hoverDropdown);
		hoverDropdown.click();

		CommonMethods.waitForElementToVisible(allDepartments);
		allDepartments.click();

		Thread.sleep(2000);
		// driver.navigate().refresh();

		CommonMethods.waitForElementToVisible(user);
		user.click();

		CommonMethods.waitForElementToVisible(editFirst);
		editFirst.click();

		CommonMethods.waitForElementToVisible(quickSaveBtn);
		quickSaveBtn.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(testStatus0);

		return testStatus0.getText();
	}

	public String pendingSubmitVerification(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		String billId = receiveSample(userName);

		driver.navigate().to(Constants.WAITING_LIST_URL);
		CommonMethods.waitForElementToVisible(hoverDropdown);
		hoverDropdown.click();

		CommonMethods.waitForElementToVisible(allDepartments);
		allDepartments.click();

		Thread.sleep(2000);
		CommonMethods.waitForElementToVisible(user);
		user.click();

		CommonMethods.waitForElementToVisible(editFirst);
		editFirst.click();

		CommonMethods.waitForElementToVisible(quickSubmitBtn);

		if (quickDefaultDocPass.isEnabled()) {
			CommonMethods.waitForElementToVisible(quickDefaultDocPass);
			quickDefaultDocPass.sendKeys("livehealth20");
		}

		quickSubmitBtn.click();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(testStatus0);

		return testStatus0.getText();
	}

	public String sampleNotReceivedStatus(String userName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		createBill(userName);

		CommonMethods.waitForElementToVisible(advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(totalAmount.getText());

		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();

		CommonMethods.waitForElementToVisible(confirmBillId);
		String billId = confirmBillId.getText();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);
		driver.navigate().refresh();
		unlockBill(billId);

		CommonMethods.waitForElementToVisible(testStatus0);

		return testStatus0.getText();
	}
	// public String paymentModeIfUserAdvanceIsAvailable(String userName) throws
	// Exception {
	//
	// WebDriver driver = DriverFactory.getDriver();
	//
	// createBill(userName);
	//
	// CommonMethods.waitForElementToVisible(saveBill);
	// saveBill.click();
	//
	// CommonMethods.waitForElementToVisible(confirmBillId);
	// String billId = confirmBillId.getText();
	//
	// driver.navigate().to(Constants.BillingUpdate_URL + billId);
	// driver.navigate().refresh();
	// unlockBill(billId);
	//
	// CommonMethods.waitForElementToVisible(viewPayment);
	// viewPayment.click();
	//
	// CommonMethods.waitForElementToVisible(cashMode);
	// String mode = cashMode.getText();
	//
	// paymentModeClose.click();
	// return mode;
	// }
}
