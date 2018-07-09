package com.livehealth.pageobject;

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

		CommonMethods.waitForElementToVisible(allBillListDateRange);
		allBillListDateRange.click();
		lastQuarter.click();
		CommonMethods.waitForElementToVisible(pendingBills);
		CommonMethods.waitForElementToClickable(pendingBills);

		js.executeScript("arguments[0].click();", pendingBills);
		
		CommonMethods.waitForElementToVisible(labelDiv0);
		CommonMethods.waitForElementToClickable(labelDiv0);

		if(completed.size()>0) {
			
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

		if(pending.size()>0) {
			
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
		
		if(elements.size()>0) {
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
		
		if(elements.size()>0) {
			return true;
		}
		
		return false;

	}
	
//	public void registerUser(User user) throws Exception {
//		
//		CommonMethods.waitForElementToVisible(newDirectMobile);
//		newDirectMobile.sendKeys(user.getPhoneNumber());
//
//		CommonMethods.waitForElementToVisible(newDirectFirstName);
//		newDirectFirstName.sendKeys(user.getName());
//		
//		CommonMethods.waitForElementToVisible(newDirectAge);
//		newDirectAge.sendKeys("10");
//		
//		CommonMethods.waitForElementToVisible(newDirectRadiobutton);
//		newDirectRadiobutton.click();
//		
//		newDirectSaveForm.click();
//		
//	}
	
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

	public void selectTestName(String testName,String referrel) throws Exception {

		CommonMethods.waitForElementToVisible(referralList);
		Select selectReferrel = new Select(referralList);
		selectReferrel.selectByVisibleText(referrel);

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
		selectTestName(bill.getTestName(), bill.getReferrelPriceList());

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
	
	public String justCancelBill(User user, BillData bill) throws Exception {

		List<BillData> billData = billingAndBillUpdate(user, bill);
		String billId = billData.get(0).getBillId();

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(removeButton);
		removeButton.click();

		CommonMethods.waitForElementToVisible(justCancelBill);
		justCancelBill.click();

		CommonMethods.waitForElementToVisible(bill_comment);
		bill_comment.click();

		confirmedBillRemoval.click();
		driver.navigate().refresh();

		driver.navigate().to(Constants.BillingUpdate_URL + billId);

		return billStatus.getText();
	}
}
