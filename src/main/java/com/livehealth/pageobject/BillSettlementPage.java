package com.livehealth.pageobject;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import com.livehealth.model.BillData;
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
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;
import com.livehealth.util.CommonMethods;

@Component
public class BillSettlementPage {

	public static String billId;

	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement adminHover;

	@FindBy(id = "searchCreditUsers")
	private WebElement searchCreditUsers;
	
	@FindBy(xpath = "//a[contains(text(),'Bill Settlements')]")
	private WebElement BillSettlemetTab;

	@FindBy(id = "searchByAccessionNo")
	private WebElement searchByAccessionNo;

	@FindBy(id = "searchAccBtn")
	private WebElement searchAccBtn;

	@FindBy(id = "custName")
	private WebElement custName;

	@FindBy(id = "dueAmount")
	private WebElement dueAmount;

	@FindBy(id = "recalculateDueLink")
	private WebElement recalculateDueLink;

	@FindBy(id = "billSettlementId")
	private WebElement billSettlementId;

	@FindBy(name = "labBillId")
	private WebElement labBillId;

	@FindBy(name = "settlementAmount")
	private WebElement settlementAmount;

	@FindBy(id = "billList")
	private WebElement billList;

	@FindBy(id = "errorDueAmnt")
	private WebElement errorDueAmnt;

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

	@FindBy(id = "confirmBillId")
	private WebElement confirmBillId;

	@FindBy(id = "submit")
	private WebElement submit;

	@FindBy(id = "successDiv")
	private WebElement successDiv;

	@FindBy(id = "paymentType")
	private WebElement paymentType;

	@FindBy(id = "billPendingId")
	private WebElement billPendingId;

	@FindBy(id = "userBillsContainer")
	private WebElement userBillsContainer;
	
	@FindAll({ @FindBy(id = "userBillsContainer") })
	public List<WebElement> userBillsContainerList;

	@FindBy(xpath = " //*[@id=\"userAmntDivId\"]/div[2]/b")
	public static WebElement patientDue;

	@FindBy(className = "dropdown-toggle")
	public static WebElement options;

	@FindBy(id = "msg")
	private WebElement msg;

	@FindBy(id = "completedBills")
	private WebElement completedBills;

	@FindBy(id = "searchBills")
	private WebElement searchBills;

	@FindBy(xpath = "//*[@id=\"searchPatientBar\"]/div/div[2]/span/input[2]")
	private WebElement searchBillsforRefAndPatient;

	@FindBy(xpath = "//*[@id=\"searchPatientBar\"]/div/div[1]/button")
	private WebElement refAndPatientoptions;

	@FindBy(id = "allBills")
	private WebElement allBills;

	@FindBy(id = "invoiceReportId")
	private WebElement invoiceReportTab;

	@FindBy(id = "invoiceType")
	private WebElement invoiceType;

	@FindBy(id = "searchInvoiceName")
	private WebElement searchInvoiceName;

	@FindBy(id = "errorDiv")
	private WebElement errorDiv;

	@FindBy(xpath = "//*[@id=\"invoiceDiv\"]/div[7]/div/button")
	private WebElement GenerateInvoice;
	
	@FindBy(xpath = "//a[contains(text(),'Add Tests To Bill')]")
	private WebElement addTestToBill;

	@FindBy(id = "searchPatientBill")
	private WebElement searchPatientBill;

	@FindBy(id = "saveExistingBill")
	private WebElement saveExistingBill;

	@FindBy(id = "confirmedBillUpdate")
	private WebElement confirmedBillUpdate;

	@FindBy(id = "saveNewBill")
	private WebElement saveNewBill;

	@FindBy(id = "billListDiv")
	private WebElement billListDiv;

	@FindBy(id = "errorDivNoBill")
	private WebElement errorDivNoBill;

	@FindBy(id = "errorDiv")
	private WebElement warerrorDiv;

	@FindBy(id = "saveBillError")
	private WebElement saveBillError;

	@FindBy(id = "totalAmount")
	private WebElement totalAmount;

	@FindBy(id = "balanceAmount")
	private WebElement balanceAmount;

	@FindBy(id = "price")
	private WebElement price;

	@FindBy(id = "paymentMode")
	private WebElement paymentMode;

	@FindBy(id = "changeConcession")
	private WebElement changeConcession;

	@FindBy(xpath = "//*[@id=\"billingDiv\"]/div[1]/h4/b")
	private WebElement GetTittile;

	@FindBy(xpath = "//*[@id=\"organizationAmntDivId\"]/div[2]/b")
	private WebElement OrgAdvanceAmount;

	@FindBy(xpath = "//*[@id=\"searchPatientBar\"]/div/div[1]/button")
	private WebElement searchPatientBar;
	
	@FindAll({ @FindBy(id = "billList") })
	public List<WebElement> billlist;


	@PostConstruct
	public void loadDriver() throws Exception {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}
	BillData bill = new BillData();
	public void signIn(String userName, String password) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signIn.click();
		CommonMethods.waitForElementToClickable(adminHover);

		driver.navigate().to(Constants.Billing_URL);

	}

	public String billsettlementPage() {
		BillSettlemetTab.click();
		return billSettlementId.getCssValue("background-color");
	}

	public String patientBill(String name, String amount, String test1, String test2) throws Exception {
		billUrl.click();
		searchPatient.sendKeys(name);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[3]/div[2]/div/div[1]/span/span")));
		searchPatient.sendKeys(Keys.ARROW_DOWN);
		searchPatient.sendKeys(Keys.ENTER);
		CommonMethods.waitForElementToVisible(searchInputforTests);
		selectTests(test1);
		selectTests(test2);
		AdvanceAmount.clear();
		AdvanceAmount.sendKeys(amount);
		saveBill.click();
		String billId=confirmBillId.getText();
		bill.setBillId(billId);
		String success = confirmBillMsgDiv.getText();
		Thread.sleep(500);
		backToRegistration.click();
		return success;

	}

	public void selectTests(String testName) throws Exception {
		searchInputforTests.sendKeys(testName);
		Thread.sleep(500);
		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
		searchInputforTests.sendKeys(Keys.ENTER);
		concession.sendKeys(Keys.ENTER);
	}

	public String lockBillLabel(String duepatientName) throws Exception {
		selectPatient(duepatientName);
		Thread.sleep(1000);
		List<WebElement> list = DriverFactory.getDriver().findElements(By.className("label-position"));
		String color = "";
		for (int i = 0; i < list.size(); i++) {
			color = list.get(i).getCssValue("background-color");
		}
		return color;

	}

	public boolean verifydetails(String duepatientName) throws Exception {
		BillSettlemetTab.click();
		selectPatient(duepatientName);
		String name = custName.getText();
		Assert.assertEquals(name, "Mayur");
		CommonMethods.waitForAllElementsToVisible(billlist);
		Thread.sleep(1000);
		List<WebElement> bills = billList.findElements(By.name("labBillId"));
		int length = bills.size();
		for (int i = 0; i < length; i++) {
			String billslist = bills.get(i).getText();
			System.out.println(billslist);
			System.out.println(bill.getBillId());
			if (billslist.contains(bill.getBillId())) {
				return true;
			}
		}
		return false;

	}

	public List<Integer> calculateDue(String duepatientName) throws Exception {
		selectPatient(duepatientName);
		CommonMethods.waitForElementToVisible(billList);
		List<WebElement> dueAmounts = billList.findElements(By.name("dueId"));
		int length = dueAmounts.size();
		int sum = 0;

		for (int i = 0; i < length; i++) {
			String billDue = dueAmounts.get(i).getText();
			int total = Integer.parseInt(billDue);
			sum = sum + Integer.parseInt(dueAmounts.get(i).getText());

		}
		recalculateDueLink.click();
		CommonMethods.waitForElementToVisible(errorDueAmnt);

		String success = errorDueAmnt.getText();
		Assert.assertEquals(success, "×\n" + "Successfully calculated.");
		Thread.sleep(1000);
		int finalDue = Integer.parseInt(dueAmount.getText());
		ArrayList<Integer> amounts = new ArrayList();
		amounts.add(sum);
		amounts.add(finalDue);
		return amounts;

	}

	public ArrayList<String> editBillLink(String patientName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		selectPatient(patientName);
		CommonMethods.waitForElementToVisible(billList);
		List<WebElement> bills = billList.findElements(By.name("labBillId"));
		String billId = bills.get(1).getText();

		String originalHandle = driver.getWindowHandle();
		List<WebElement> link = driver.findElements(By.xpath("//a[contains(text(),'Edit Bill')] "));
		link.get(1).click();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
			}
		}
		String Url = driver.getCurrentUrl();
		ArrayList<String> list = new ArrayList<>();
		list.add(billId);
		list.add(Url);
		driver.close();
		driver.switchTo().window(originalHandle);

		return list;
	}

	public boolean billSettlement(String duepatientName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectPatient(duepatientName);
		CommonMethods.waitForElementToVisible(billList);
		int currentDueAmount = Integer.parseInt(dueAmount.getText());

		DriverFactory.getDriver().findElement(By.id("tick0")).click();
		DriverFactory.getDriver().findElement(By.id("tick1")).click();
		Thread.sleep(1000);
		int settlementAmt = Integer.parseInt(settlementAmount.getAttribute("value"));

		List<WebElement> settleAmounts = billList.findElements(By.name("amount"));
		int length = settleAmounts.size();
		int sum = 0;
		int finalDue = 0;

		for (int i = 0; i < length; i++) {
			if (i < 2) {
				String amount = settleAmounts.get(i).getAttribute("value");
				sum = sum + Integer.parseInt(amount);
				finalDue = currentDueAmount - sum;
			}
		}

		int afterdeductedDueAmount = Integer.parseInt(dueAmount.getText());

		if (finalDue == afterdeductedDueAmount) {
			Assert.assertTrue(true);
		}
		Assert.assertEquals(settlementAmt, sum);
		submit.click();
		Thread.sleep(1000);
		String success = successDiv.getText();
		if (success.contains("×\n" + "Close\n"
				+ "Success! Click on below links to print the receipts for successful bill settlements")) {
			return true;
		}
		return false;
	}

	public void selectPatient(String duepatientName) throws InterruptedException {
		BillSettlemetTab.click();
		searchCreditUsers.sendKeys(duepatientName);
		Thread.sleep(1500);
		searchCreditUsers.sendKeys(Keys.ARROW_DOWN);
		searchCreditUsers.sendKeys(Keys.ENTER);
	}

	public boolean settleHalfAmount(String duepatientName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectPatient(duepatientName);
		CommonMethods.waitForElementToVisible(billList);
		List<WebElement> settleAmounts = billList.findElements(By.name("amount"));
		DriverFactory.getDriver().findElement(By.id("tick0")).click();
		int fullAmount = Integer.parseInt(settleAmounts.get(0).getAttribute("value"));
		int halfAmount = fullAmount / 2;
		settleAmounts.get(0).clear();
		settleAmounts.get(0).sendKeys(Integer.toString(halfAmount));
		submit.click();
		Thread.sleep(1000);
		String success = successDiv.getText();
		if (success.contains("×\n" + "Close\n"
				+ "Success! Click on below links to print the receipts for successful bill settlements")) {
			Assert.assertTrue(true);
		}
		selectPatient(duepatientName);
		Thread.sleep(1000);

		String result = DriverFactory.getDriver().findElement(By.id("dueId0")).getText();
		if (result.equals(Integer.toString(halfAmount))) {
			return true;
		}
		return false;

	}

	public ArrayList<String> searchPatientUsingContactNumber(String patientConct) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		WebDriver driver = DriverFactory.getDriver();
		selectPatient(patientConct);
		Thread.sleep(1000);
		String name = custName.getText();
		String originalHandle = DriverFactory.getDriver().getWindowHandle();
		driver.findElement(By.id("linkDiv")).click();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
			}
		}
		String url=driver.getCurrentUrl();
		ArrayList<String> list = new ArrayList<>();
		list.add(name);
		list.add(url);
		driver.close();
		driver.switchTo().window(originalHandle);
		return list;
	}

	public String paymentMode(String name, String mode, String value) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		WebDriver driver = DriverFactory.getDriver();
		selectPatient(name);
		CommonMethods.waitForElementToVisible(billList);
		List<WebElement> bills = billList.findElements(By.tagName("li"));
		bills.get(0).click();

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
		Thread.sleep(1000);
		submit.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", searchCreditUsers);
		Thread.sleep(1000);
		String beforehandle = driver.getWindowHandle();
		List<WebElement> link = driver.findElements(By.xpath("//a[contains(text(),'Edit Bill')] "));
		link.get(0).click();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(1000);
		driver.findElement(By.id("textInput")).click();
		Thread.sleep(1000);
		String billListPayMode = driver.findElement(By.xpath("//td[contains(text(),'" + value + "')]")).getText();
		driver.close();
		driver.switchTo().window(beforehandle);
		return billListPayMode;

	}

	public boolean pendingBillsTab() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BillSettlemetTab.click();
		billPendingId.click();
		Thread.sleep(2000);
		List<WebElement> link = DriverFactory.getDriver()
				.findElements(By.xpath("//label[contains(text(),'completed')] "));
		int length = link.size();
		if (length >= 1) {
			return false;
		}
		return true;

	}

	public String commenBillAction(String option, String url, int length) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BillSettlemetTab.click();
		billPendingId.click();
		Thread.sleep(2000);
		SoftAssert softAssert = new SoftAssert();
		WebDriver driver = DriverFactory.getDriver();
		List<WebElement> opt = userBillsContainer.findElements(By.className("dropdown-toggle"));
		opt.get(0).click();
		String beforehandle = driver.getWindowHandle();
		if (option.equals("Complete & Print Bill")) {
			WebElement links = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
			links.click();
			Thread.sleep(1000);
			String success = msg.getText();
			softAssert.assertEquals(success, "×\n" + "Success! Bill completed Successfully.");
		}

		if (option.equals("Print Bill")) {
			WebElement links = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
			links.click();
		}

		if (option.equals("Edit Bill")) {
			WebElement links = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
			links.click();
		}

		if (option.equals("View Transactions")) {
			WebElement links = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
			links.click();
		}
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String Url = driver.getCurrentUrl();
		String actualUrl = Url.substring(0, length);
		driver.close();
		driver.switchTo().window(beforehandle);
		softAssert.assertAll();
		return actualUrl;
	}

	public String completeBill() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BillSettlemetTab.click();
		billPendingId.click();
		Thread.sleep(2000);
		List<WebElement> opt = userBillsContainer.findElements(By.className("dropdown-toggle"));
		opt.get(0).click();
		WebElement links = DriverFactory.getDriver().findElement(By.xpath("//a[contains(text(),'Complete Bill')] "));
		links.click();
		Thread.sleep(1000);
		String success = msg.getText();
		return success;
	}

	public void sentBillSMSToPatient() throws Exception {
		BillSettlemetTab.click();
		billPendingId.click();
		List<WebElement> opt = userBillsContainer.findElements(By.className("dropdown-toggle"));
		opt.get(0).click();
		WebElement link = DriverFactory.getDriver()
				.findElement(By.xpath("//a[contains(text(),'Send Bill SMS To Patient')] "));
		link.click();
		Thread.sleep(1000);
		String alert = msg.getText();
		Assert.assertEquals(alert, " ×\n" + "Please convert patient into direct.");
		Thread.sleep(2000);
		List<WebElement> links = userBillsContainer.findElements(By.tagName("p"));
		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getText().contains("Name : Mayur (M - 3 months)")) {
				List<WebElement> opt1 = userBillsContainer.findElements(By.className("dropdown-toggle"));
				opt1.get(i).click();
				break;
			}
		}
		WebElement option = DriverFactory.getDriver()
				.findElement(By.xpath("//a[contains(text(),'Send Bill SMS To Patient')] "));
		option.click();

	}

	public boolean completedBillsTab() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BillSettlemetTab.click();
		billPendingId.click();
		Thread.sleep(1000);
		completedBills.click();
		Thread.sleep(2000);
		List<WebElement> link = DriverFactory.getDriver().findElements(By.xpath("//label[contains(text(),'Pending')]"));
		int length = link.size();

		if (length >= 1) {
			return false;
		}
		return true;
	}

	public String completedBillsActions(String option, String url, int length) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BillSettlemetTab.click();
		billPendingId.click();
		Thread.sleep(1000);
		completedBills.click();
		Thread.sleep(1000);
		WebDriver driver = DriverFactory.getDriver();
		List<WebElement> opt = userBillsContainer.findElements(By.className("dropdown-toggle"));
		opt.get(0).click();
		String beforehandle = driver.getWindowHandle();
		if (option.equals("Print Bill")) {
			WebElement links = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
			links.click();
		}

		if (option.equals("Edit Bill")) {
			WebElement links = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
			links.click();
		}

		if (option.equals("View Transactions")) {
			WebElement links = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
			links.click();
		}

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		String Url = DriverFactory.getDriver().getCurrentUrl();
		String actualUrl = Url.substring(0, length);
		Assert.assertEquals(actualUrl, url);
		driver.close();
		driver.switchTo().window(beforehandle);
		return actualUrl;

	}

	public boolean SearchByPatientName(String option, String name) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BillSettlemetTab.click();
		billPendingId.click();
		Thread.sleep(1000);
		searchBills.click();
		refAndPatientoptions.click();
		WebElement link = DriverFactory.getDriver().findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
		link.click();
		searchBillsforRefAndPatient.sendKeys(name);
		Thread.sleep(1000);
		searchBillsforRefAndPatient.sendKeys(Keys.ARROW_DOWN);
		searchBillsforRefAndPatient.sendKeys(Keys.ENTER);
		CommonMethods.waitForAllElementsToVisible(userBillsContainerList);
		List<WebElement> links = userBillsContainer.findElements(By.tagName("p"));
		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getText().contains("Name : Mayur (M - 3 months)")) {
				return true;
			}
		}
		return false;

	}

	public boolean SearchByReferralName(String option, String name) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BillSettlemetTab.click();
		billPendingId.click();
		Thread.sleep(1000);
		searchBills.click();
		refAndPatientoptions.click();
		WebElement link = DriverFactory.getDriver().findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
		link.click();
		searchBillsforRefAndPatient.sendKeys(name);
		Thread.sleep(1000);
		searchBillsforRefAndPatient.sendKeys(Keys.DOWN);
		searchBillsforRefAndPatient.sendKeys(Keys.ARROW_DOWN);
		searchBillsforRefAndPatient.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		List<WebElement> list = DriverFactory.getDriver()
				.findElements(By.xpath("//label[contains(text(),'Referral - Dr. autoReferral')]"));

		for (int i = 0; i < list.size(); i++) {
			String actualText = list.get(i).getText();
			if (actualText.equals("Referral - Dr. autoReferral")) {
				return true;
			}
		}
		return false;
	}

	public String searchedBillsActions(String option, String url, int length, String name) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BillSettlemetTab.click();
		billPendingId.click();
		Thread.sleep(1000);
		searchBills.click();
		searchPatientBar.click();
		WebDriver driver = DriverFactory.getDriver();
		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Search by Patient Name')] "));
		link.click();
		searchBillsforRefAndPatient.sendKeys(name);
		Thread.sleep(1000);
		searchBillsforRefAndPatient.sendKeys(Keys.ARROW_DOWN);
		searchBillsforRefAndPatient.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		List<WebElement> opt = userBillsContainer.findElements(By.className("dropdown-toggle"));
		opt.get(0).click();
		String beforehandle = driver.getWindowHandle();
		if (option.equals("Print Bill")) {
			WebElement links = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
			links.click();
		}

		if (option.equals("Edit Bill")) {
			WebElement links = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
			links.click();
		}

		if (option.equals("View Transactions")) {
			WebElement links = driver.findElement(By.xpath("//a[contains(text(),'" + option + "')]"));
			links.click();
		}

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String Url = DriverFactory.getDriver().getCurrentUrl();
		String actualUrl = Url.substring(0, length);
		Assert.assertEquals(actualUrl, url);
		driver.close();
		driver.switchTo().window(beforehandle);
		return actualUrl;

	}

	public boolean viewAllBillsList() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BillSettlemetTab.click();
		billPendingId.click();
		Thread.sleep(1000);
		allBills.click();
		Thread.sleep(1000);
		List<WebElement> completedBills = DriverFactory.getDriver()
				.findElements(By.xpath("//label[contains(text(),'completed')] "));
		int CompletedLength = completedBills.size();
		List<WebElement> pendingBills = DriverFactory.getDriver()
				.findElements(By.xpath("//label[contains(text(),'Pending')]"));
		int PendingLength = pendingBills.size();
		ArrayList<Integer> size = new ArrayList<>();
		size.add(CompletedLength);
		size.add(PendingLength);
		if (size.get(0) > 0 && size.get(1) > 0) {
			return true;
		}
		return false;

	}

	public String generateInvoice(String invType, String name) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		WebDriver driver = DriverFactory.getDriver();
		SoftAssert softAssert = new SoftAssert();
		BillSettlemetTab.click();
		invoiceReportTab.click();
		if (invType.equals("Organization")) {
			Select ele = new Select(invoiceType);
			ele.selectByVisibleText("Organization");
		}

		if (invType.equals("Referral")) {
			Select ele = new Select(invoiceType);
			ele.selectByVisibleText("Referral");
		}

		if (invType.equals("Customer")) {
			Select ele = new Select(invoiceType);
			ele.selectByVisibleText("Customer");
		}
		searchInvoiceName.sendKeys(name);
		Thread.sleep(1500);
		searchInvoiceName.sendKeys(Keys.ARROW_DOWN);
		searchInvoiceName.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String beforehandle = driver.getWindowHandle();
		GenerateInvoice.click();
		Thread.sleep(1000);
		String success = errorDiv.getText();
		softAssert.assertEquals(success,
				"×\n" + "Invoice has been generated successfully! Click here to print the invoice.");

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String url = DriverFactory.getDriver().getCurrentUrl();
		String actualUrl = url.substring(0, 46);
		driver.close();
		driver.switchTo().window(beforehandle);
		softAssert.assertAll();
		return actualUrl;

	}

	public void selectPatientForAddTestToBill(String name) throws InterruptedException {
		BillSettlemetTab.click();
		addTestToBill.click();
		searchPatientBill.sendKeys(name);
		Thread.sleep(1500);
		searchPatientBill.sendKeys(Keys.ARROW_DOWN);
		searchPatientBill.sendKeys(Keys.ENTER);

	}

	public String addTestToExistingBill(String name, String test1, String test2, String amount) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectPatientForAddTestToBill(name);
		Thread.sleep(1000);
		selectTests(test1);
		selectTests(test2);
		AdvanceAmount.clear();
		AdvanceAmount.sendKeys(amount);
		saveExistingBill.click();
		CommonMethods.waitForElementToClickable(confirmedBillUpdate);
		confirmedBillUpdate.click();
		Thread.sleep(1000);
		String tittle = GetTittile.getText();
		return tittle;
	}

	public boolean addTestToNewBillWithSameSampleId(String name, String test1, String test2, String amount)
			throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectPatientForAddTestToBill(name);
		Thread.sleep(1000);
		List<WebElement> bills = billListDiv.findElements(By.className("userContainer"));
		int beforeLength = bills.size();
		selectTests(test1);
		selectTests(test2);
		AdvanceAmount.clear();
		AdvanceAmount.sendKeys(amount);
		saveNewBill.click();
		CommonMethods.waitForElementToClickable(confirmedBillUpdate);
		confirmedBillUpdate.click();
		Thread.sleep(1000);
		String tittle = GetTittile.getText();
		Assert.assertEquals(tittle, "Add Tests In Existing Bill");

		selectPatientForAddTestToBill(name);
		Thread.sleep(1000);
		List<WebElement> bill = billListDiv.findElements(By.className("userContainer"));
		int afterLength = bill.size();
		if (beforeLength <= afterLength) {
			return true;
		}
		return false;

	}

	public ArrayList<String> alreadyExistingTestAdd(String name, String name1, String test1) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectPatientForAddTestToBill(name);
		Thread.sleep(1000);
		String warning = errorDivNoBill.getText();

		selectPatientForAddTestToBill(name1);
		Thread.sleep(2000);
		selectTests(test1);
		searchInputforTests.sendKeys(test1);
		Thread.sleep(1000);
		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
		searchInputforTests.sendKeys(Keys.ENTER);
		String existedWarning = warerrorDiv.getText();
		ArrayList<String> list = new ArrayList<>();
		list.add(warning);
		list.add(existedWarning);
		return list;
	}

	public void stopbill(String name, String test1) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		SoftAssert softAssert = new SoftAssert();
		selectPatientForAddTestToBill(name);
		Thread.sleep(1000);
		if (name.equals("pos")) {
			selectTests(test1);
			String mesg = saveBillError.getText();
			softAssert.assertEquals(mesg, "×\n"
					+ "Sorry! This organization have a insufficient advance amount to complete bill, This bill be in pending state");
		}

		if (name.equals("pramo")) {
			selectTests(test1);
			String mesg = saveBillError.getText();
			softAssert.assertEquals(mesg, "×\n" + "Error! This organization have a insufficient advance amount");
		}
		softAssert.assertAll();

	}

	public ArrayList<Integer> orgAdavanceCalc(String name, String amount, String test1) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectPatientForAddTestToBill(name);
		Thread.sleep(1000);
		selectTests(test1);
		String orgAdvance = OrgAdvanceAmount.getText();
		AdvanceAmount.clear();
		AdvanceAmount.sendKeys(amount);
		String due = balanceAmount.getText();

		int advAmount = Integer.parseInt(orgAdvance.replaceAll("₹", "").trim());
		int paidAmount = Integer.parseInt(due.replaceAll("₹", "").trim());
		int finalAdv = advAmount - paidAmount;

		AdvanceAmount.clear();
		AdvanceAmount.sendKeys(amount);
		saveExistingBill.click();
		CommonMethods.waitForElementToClickable(confirmedBillUpdate);
		confirmedBillUpdate.click();
		Thread.sleep(2000);
		selectPatientForAddTestToBill(name);
		Thread.sleep(1000);
		selectTests(test1);
		orgAdvance = OrgAdvanceAmount.getText();
		int orgAdv = Integer.parseInt(orgAdvance.replaceAll("₹", "").trim());
		ArrayList<Integer> orgAdvAmt = new ArrayList<>();
		orgAdvAmt.add(finalAdv);
		orgAdvAmt.add(orgAdv);
		return orgAdvAmt;

	}

	public void discountRestrictionOnOutsourceTest(String test, String name, String discount) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectPatientForAddTestToBill(name);
		SoftAssert softAssert=new SoftAssert();
		Thread.sleep(1000);
		List<WebElement> bills = DriverFactory.getDriver().findElements(By.name("lab"));
		if (test.equals("Mumps Virus IgM Antibody")) {
			bills.get(0).click();
			getDiscount(test, discount);
			String warningMegs = errorDiv.getText();
			softAssert.assertEquals(warningMegs, "×\n" + "Error!Consession cannot be allowed for outsource test.");

		}

		if (test.equals("Cytology (Non-Gyn) Nipple")) {
			bills.get(1).click();
			getDiscount(test, discount);

			int caltotal = Integer.parseInt(testPrice) - Integer.parseInt(discount);
			int payableAmt = Integer.parseInt(totalAmount.getText());
			softAssert.assertEquals(payableAmt, caltotal);
			saveExistingBill.click();
			CommonMethods.waitForElementToClickable(confirmedBillUpdate);
			confirmedBillUpdate.click();

		}
		if (test.equals("Protein/Creatinine Ratio")) {
			bills.get(2).click();
			Select ele = new Select(changeConcession);
			ele.selectByVisibleText("Concession (in %)");
			getDiscount(test, discount);

			int num = (int) (Integer.parseInt(testPrice) * Integer.parseInt(discount) / 100);
			int caltotal = Integer.parseInt(testPrice) - num;
			int payableAmt = Integer.parseInt(totalAmount.getText());
			softAssert.assertEquals(payableAmt, caltotal);
			saveExistingBill.click();
			CommonMethods.waitForElementToClickable(confirmedBillUpdate);
			confirmedBillUpdate.click();
			softAssert.assertAll();
		}

	}

	String testPrice;

	public void getDiscount(String testName, String discount) throws InterruptedException {
		searchInputforTests.sendKeys(testName);
		Thread.sleep(1000);
		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
		searchInputforTests.sendKeys(Keys.ENTER);
		testPrice = price.getAttribute("value");
		concession.clear();
		concession.sendKeys(discount);
		concession.sendKeys(Keys.ENTER);
	}

	public String paymentType(String payMode, String value, String name, String test1, String paidAmt)
			throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectPatientForAddTestToBill(name);
		Thread.sleep(1000);
		List<WebElement> bills = DriverFactory.getDriver().findElements(By.name("lab"));

		if (payMode.equals("Cheque")) {
			bills.get(0).click();
			selectTests(test1);
			Select ele = new Select(paymentMode);
			ele.selectByVisibleText("Cheque");
		}

		if (payMode.equals("Credit")) {
			bills.get(1).click();
			selectTests(test1);
			Select ele = new Select(paymentMode);
			ele.selectByVisibleText("Credit");
		}

		if (payMode.equals("Credit Card")) {
			bills.get(2).click();
			selectTests(test1);
			Select ele = new Select(paymentMode);
			ele.selectByVisibleText("Credit Card");
		}

		if (payMode.equals("Debit Card")) {
			bills.get(3).click();
			selectTests(test1);
			Select ele = new Select(paymentMode);
			ele.selectByVisibleText("Debit Card");
		}

		if (payMode.equals("Free")) {
			bills.get(4).click();
			selectTests(test1);
			Select ele = new Select(paymentMode);
			ele.selectByVisibleText("Free");
		}

		if (payMode.equals("Other")) {
			bills.get(5).click();
			selectTests(test1);
			Select ele = new Select(paymentMode);
			ele.selectByVisibleText("Other");
		}

		AdvanceAmount.clear();
		AdvanceAmount.sendKeys(paidAmt);
		saveExistingBill.click();
		CommonMethods.waitForElementToClickable(confirmedBillUpdate);
		confirmedBillUpdate.click();
		Thread.sleep(1000);
		String tittle = GetTittile.getText();
		return tittle;
	}

	public boolean searchUsingAccessionNo(String AccesionNo) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		BillSettlemetTab.click();
		addTestToBill.click();
		if (AccesionNo.equals("000117018")) {
			searchByAccessionNo.sendKeys(AccesionNo);
		}

		if (AccesionNo.equals("000317018")) {
			searchByAccessionNo.sendKeys(AccesionNo);
		}
		if (AccesionNo.equals("000217018")) {
			searchByAccessionNo.sendKeys(AccesionNo);
		}
		Thread.sleep(1000);
		searchAccBtn.click();
		Thread.sleep(1000);
		List<WebElement> list = billListDiv.findElements(By.className("userContainer"));
		int length = list.size();
		if (length > 0) {
			return true;
		}
		return false;
	}

}
