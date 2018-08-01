package com.livehealth.pageobject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;
import com.livehealth.util.CommonMethods;

@Component
public class BillSettlementPage {
	
	SoftAssert SoftAssert = new SoftAssert();

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

	@FindBy(xpath = "//*[@id=\"nav-sidebar\"]/div[3]/ul/li[6]/a")
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

	@FindBy(xpath = "//*[@id=\"nav-sidebar\"]/div[3]/ul/li[6]/ul/li[2]/a")
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

	public String billsettlementPage() {
		BillSettlemetTab.click();
		return billSettlementId.getCssValue("background-color");
	}

	public void patientBill(String name, String amount, String test1, String test2) throws Exception {
		billUrl.click();
		searchPatient.sendKeys(name);
		Thread.sleep(2000);
		searchPatient.sendKeys(Keys.ARROW_DOWN);
		searchPatient.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		selectTests(test1);
		selectTests(test2);
		AdvanceAmount.clear();
		AdvanceAmount.sendKeys(amount);
		saveBill.click();
		billId = confirmBillId.getText();
		String success = confirmBillMsgDiv.getText();
		SoftAssert.assertEquals(success, "×\n" + "Bill saved successfully.");
		SoftAssert.assertAll();
		Thread.sleep(1000);
		backToRegistration.click();

	}

	public void selectTests(String testName) throws InterruptedException {
		searchInputforTests.sendKeys(testName);
		Thread.sleep(500);
		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
		searchInputforTests.sendKeys(Keys.ENTER);
		concession.sendKeys(Keys.ENTER);
	}

	public void lockBillLabel(String duepatientName) throws Exception {
		selectPatient(duepatientName);
		Thread.sleep(1000);
		List<WebElement> list = DriverFactory.getDriver().findElements(By.className("label-position"));
		String color = "";
		for (int i = 0; i < list.size(); i++) {
			color = list.get(i).getCssValue("background-color");
		}
		Assert.assertEquals(color, "rgba(217, 83, 79, 1)");

	}

	public void verifydetails(String duepatientName) throws Exception {
		BillSettlemetTab.click();
		selectPatient(duepatientName);
		String name = custName.getText();
		SoftAssert.assertEquals(name, "Tushar");
		Thread.sleep(3000);
		java.util.List<WebElement> bills = billList.findElements(By.name("labBillId"));
		int length = bills.size();

		for (int i = 0; i < length; i++) {
			String billslist = bills.get(i).getText();
			try {

				if (billslist.contains(billId)) {
					SoftAssert.assertTrue(true, "Bill Id shown correctly");
					SoftAssert.assertAll();
				} else {
					Assert.assertFalse(false, "Bill Id shown Incorrectly");
				}
			} catch (Exception e) {
				System.out.println("verifyBillSettlementAllDetails getting fails");
			}
		}

	}

	public List<Integer> calculateDue(String duepatientName) throws Exception {
		selectPatient(duepatientName);
		Thread.sleep(1000);
		java.util.List<WebElement> dueAmounts = billList.findElements(By.name("dueId"));
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
			SoftAssert.assertEquals(success, "×\n" + "Successfully calculated.");
			Thread.sleep(1000);
			int finalDue = Integer.parseInt(dueAmount.getText());
			ArrayList<Integer> amounts=new ArrayList();
			amounts.add(sum);
			amounts.add(finalDue);
			return amounts;
			
	
	}

	public String editBillLink() throws Exception {
		List<WebElement> link = DriverFactory.getDriver().findElements(By.xpath("//a[contains(text(),'Edit Bill')] "));
		link.get(1).click();
		java.util.List<WebElement> bills = billList.findElements(By.name("labBillId"));
		String billId = bills.get(1).getText();
		String winHandleBefore = DriverFactory.getDriver().getWindowHandle();
		for (String winHandle : DriverFactory.getDriver().getWindowHandles()) {
			DriverFactory.getDriver().switchTo().window(winHandle);
		}
		DriverFactory.getDriver().close();
		DriverFactory.getDriver().switchTo().window(winHandleBefore);
		return billId;
	}

	public String billSettlement(String duepatientName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectPatient(duepatientName);
		Thread.sleep(2000);
		int currentDueAmount = Integer.parseInt(dueAmount.getText());

		DriverFactory.getDriver().findElement(By.id("tick0")).click();
		DriverFactory.getDriver().findElement(By.id("tick1")).click();
		Thread.sleep(1000);
		int settlementAmt = Integer.parseInt(settlementAmount.getAttribute("value"));

		java.util.List<WebElement> settleAmounts = billList.findElements(By.name("amount"));
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
		} else {
			SoftAssert.assertFalse(true);
		}

		SoftAssert.assertEquals(settlementAmt, sum);
		submit.click();
		Thread.sleep(1000);
		String success = successDiv.getText();
		
		SoftAssert.assertAll();
		return success;
		

	}

	public void selectPatient(String duepatientName) throws InterruptedException {
		BillSettlemetTab.click();
		searchCreditUsers.sendKeys(duepatientName);
		Thread.sleep(2000);
		searchCreditUsers.sendKeys(Keys.ARROW_DOWN);
		searchCreditUsers.sendKeys(Keys.ENTER);
	}

	public void settleHalfAmount(String duepatientName) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		selectPatient(duepatientName);
		Thread.sleep(2000);
		java.util.List<WebElement> settleAmounts = billList.findElements(By.name("amount"));
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
		} else {
			SoftAssert.assertFalse(false);
			System.out.println("Bill Settlement getting fails");
		}
		selectPatient(duepatientName);
		Thread.sleep(2000);
		try {
			String result = DriverFactory.getDriver().findElement(By.id("dueId0")).getText();
			if (result.equals(Integer.toString(halfAmount))) {
				Assert.assertTrue(true);
			} else {
				SoftAssert.assertFalse(false);
				System.out.println("Half amount Bill Settlement getting fails");
			}
			SoftAssert.assertAll();
		} catch (Exception e) {
			System.out.println("Issue in settleHalfAmount");
		}
	}
//
//	public void searchPatientUsingContactNumber(String patientConct) throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		selectPatient(patientConct);
//		Thread.sleep(1000);
//		String name = custName.getText();
//		SoftAssert.assertEquals(name, "Mayur");
//		TestBase.driver.findElement(By.id("linkDiv")).click();
//		String beforehandle = TestBase.driver.getWindowHandle();
//		for (String winHandle : TestBase.driver.getWindowHandles()) {
//			TestBase.driver.switchTo().window(winHandle);
//		}
//		String url = TestBase.driver.getCurrentUrl();
//		String subUrl = url.substring(0, 66);
//		SoftAssert.assertEquals(subUrl, "https://beta.livehealth.solutions/searchRegistration/#registration");
//		SoftAssert.assertAll();
//		TestBase.driver.close();
//		TestBase.driver.switchTo().window(beforehandle);
//
//	}
//
//	public void paymentMode(String name, String mode, String value) throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		selectPatient(name);
//		Thread.sleep(2000);
//		List<WebElement> bills = billList.findElements(By.tagName("li"));
//		bills.get(0).click();
//
//		if (mode.equals("Cheque")) {
//			Select ele = new Select(paymentType);
//			ele.selectByVisibleText("Cheque");
//		}
//
//		if (mode.equals("Credit")) {
//			Select ele = new Select(paymentType);
//			ele.selectByVisibleText("Credit");
//		}
//
//		if (mode.equals("Credit Card")) {
//			Select ele = new Select(paymentType);
//			ele.selectByVisibleText("Credit Card");
//		}
//
//		if (mode.equals("Debit Card")) {
//			Select ele = new Select(paymentType);
//			ele.selectByVisibleText("Debit Card");
//		}
//
//		if (mode.equals("Free")) {
//			Select ele = new Select(paymentType);
//			ele.selectByVisibleText("Free");
//		}
//
//		if (mode.equals("Other")) {
//			Select ele = new Select(paymentType);
//			ele.selectByVisibleText("Other");
//		}
//		Thread.sleep(1000);
//		submit.click();
//		JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
//		js.executeScript("arguments[0].scrollIntoView();", searchCreditUsers);
//		Thread.sleep(1000);
//		List<WebElement> link = TestBase.driver.findElements(By.xpath("//a[contains(text(),'Edit Bill')] "));
//		link.get(0).click();
//		String beforehandle = TestBase.driver.getWindowHandle();
//		for (String winHandle : TestBase.driver.getWindowHandles()) {
//			TestBase.driver.switchTo().window(winHandle);
//		}
//		Thread.sleep(1000);
//		TestBase.driver.findElement(By.id("textInput")).click();
//		Thread.sleep(1000);
//		try {
//			String billListPayMode = TestBase.driver.findElement(By.xpath("//td[contains(text(),'" + value + "')]"))
//					.getText();
//			SoftAssert.assertEquals(billListPayMode, value);
//			TestBase.driver.close();
//			TestBase.driver.switchTo().window(beforehandle);
//			SoftAssert.assertAll();
//		} catch (Exception e) {
//
//		}
//	}
//
//	public void pendingBillsTab() throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		BillSettlemetTab.click();
//		billPendingId.click();
//		Thread.sleep(2000);
//		List<WebElement> link = TestBase.driver.findElements(By.xpath("//label[contains(text(),'completed')] "));
//		int length = link.size();
//
//		if (length >= 1) {
//			Assert.assertFalse(true);
//		} else {
//			Assert.assertTrue(true);
//		}
//	}
//
//	public void commenBillAction(String option, String url, int length) throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		BillSettlemetTab.click();
//		billPendingId.click();
//		Thread.sleep(2000);
//		List<WebElement> opt = userBillsContainer.findElements(By.className("dropdown-toggle"));
//		opt.get(0).click();
//
//		if (option.equals("Complete & Print Bill")) {
//			WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			links.click();
//			Thread.sleep(1000);
//			String success = msg.getText();
//			SoftAssert.assertEquals(success, " ×\n" + "Success! Bill completed Successfully.");
//		}
//
//		if (option.equals("Print Bill")) {
//			WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			links.click();
//		}
//
//		if (option.equals("Edit Bill")) {
//			WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			links.click();
//		}
//
//		if (option.equals("View Transactions")) {
//			WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			links.click();
//		}
//		String beforehandle = TestBase.driver.getWindowHandle();
//		for (String winHandle : TestBase.driver.getWindowHandles()) {
//			TestBase.driver.switchTo().window(winHandle);
//		}
//		String Url = TestBase.driver.getCurrentUrl();
//		String actualUrl = Url.substring(0, length);
//		SoftAssert.assertEquals(actualUrl, url);
//		TestBase.driver.close();
//		TestBase.driver.switchTo().window(beforehandle);
//	}
//
//	public void completeBill() throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		BillSettlemetTab.click();
//		billPendingId.click();
//		Thread.sleep(2000);
//		List<WebElement> opt = userBillsContainer.findElements(By.className("dropdown-toggle"));
//		opt.get(0).click();
//		WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'Complete Bill')] "));
//		links.click();
//		Thread.sleep(1000);
//		try {
//			String success = msg.getText();
//			SoftAssert.assertEquals(success, "×\n" + "Success! Bill completed Successfully.");
//		} catch (Exception e) {
//			System.out.println("Complete link getting fails");
//		}
//
//		SoftAssert.assertAll();
//	}
//
//	public void sentBillSMSToPatient() throws InterruptedException {
//		BillSettlemetTab.click();
//		billPendingId.click();
//		List<WebElement> opt = userBillsContainer.findElements(By.className("dropdown-toggle"));
//		opt.get(0).click();
//		WebElement link = TestBase.driver.findElement(By.xpath("//a[contains(text(),'Send Bill SMS To Patient')] "));
//		link.click();
//		Thread.sleep(1000);
//		String alert = msg.getText();
//		Assert.assertEquals(alert, " ×\n" + "Please convert patient into direct.");
//		Thread.sleep(2000);
//		List<WebElement> links = userBillsContainer.findElements(By.tagName("p"));
//		for (int i = 0; i < links.size(); i++) {
//			if (links.get(i).getText().contains("Name : Mayur (M - 3 months)")) {
//				List<WebElement> opt1 = userBillsContainer.findElements(By.className("dropdown-toggle"));
//				opt1.get(i).click();
//				break;
//			}
//		}
//		WebElement option = TestBase.driver.findElement(By.xpath("//a[contains(text(),'Send Bill SMS To Patient')] "));
//		option.click();
//
//	}
//
//	public void completedBillsTab() throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		BillSettlemetTab.click();
//		billPendingId.click();
//		Thread.sleep(1000);
//		completedBills.click();
//		Thread.sleep(2000);
//		List<WebElement> link = TestBase.driver.findElements(By.xpath("//label[contains(text(),'Pending')] "));
//
//		int length = link.size();
//
//		if (length >= 1) {
//			Assert.assertFalse(true);
//		} else {
//			Assert.assertTrue(true);
//
//		}
//	}
//
//	public void completedBillsActions(String option, String url, int length) throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		BillSettlemetTab.click();
//		billPendingId.click();
//		Thread.sleep(1000);
//		completedBills.click();
//		Thread.sleep(1000);
//		List<WebElement> opt = userBillsContainer.findElements(By.className("dropdown-toggle"));
//		opt.get(0).click();
//
//		if (option.equals("Print Bill")) {
//			WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			links.click();
//		}
//
//		if (option.equals("Edit Bill")) {
//			WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			links.click();
//		}
//
//		if (option.equals("View Transactions")) {
//			WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			links.click();
//		}
//		String beforehandle = TestBase.driver.getWindowHandle();
//		for (String winHandle : TestBase.driver.getWindowHandles()) {
//			TestBase.driver.switchTo().window(winHandle);
//		}
//		try {
//			String Url = TestBase.driver.getCurrentUrl();
//			String actualUrl = Url.substring(0, length);
//			SoftAssert.assertEquals(actualUrl, url);
//			TestBase.driver.close();
//			TestBase.driver.switchTo().window(beforehandle);
//		} catch (Exception e) {
//			System.out.println("completedBillsActions fails");
//		}
//	}
//
//	public void searchReferralAndPatinetTab(String option, String name) throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		BillSettlemetTab.click();
//		billPendingId.click();
//		Thread.sleep(1000);
//		searchBills.click();
//		refAndPatientoptions.click();
//		if (option.equals("Search by Referral Name")) {
//			WebElement link = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			link.click();
//			searchBillsforRefAndPatient.sendKeys(name);
//			Thread.sleep(1000);
//			searchBillsforRefAndPatient.sendKeys(Keys.ARROW_DOWN);
//			searchBillsforRefAndPatient.sendKeys(Keys.DOWN);
//			searchBillsforRefAndPatient.sendKeys(Keys.ENTER);
//			Thread.sleep(2000);
//		}
//
//		if (option.equals("Search by Patient Name")) {
//			WebElement link = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			link.click();
//			searchBillsforRefAndPatient.sendKeys(name);
//			Thread.sleep(1000);
//			searchBillsforRefAndPatient.sendKeys(Keys.ARROW_DOWN);
//			searchBillsforRefAndPatient.sendKeys(Keys.ENTER);
//		}
//
//		if (option.equals("Search by Referral Name")) {
//			List<WebElement> list = TestBase.driver
//					.findElements(By.xpath("//label[contains(text(),'Referral - " + option + "')] "));
//
//			for (int i = 0; i < list.size(); i++) {
//				String actualText = list.get(i).getText();
//				if (actualText.equals("Referral - autoReferral")) {
//					Assert.assertTrue(true);
//				} else {
//					SoftAssert.assertFalse(false);
//					SoftAssert.assertAll();
//					System.out.println("Only selected referrals bills not showing");
//				}
//			}
//
//		} else {
//			if (option.equals("Search by Patient Name")) {
//				List<WebElement> links = userBillsContainer.findElements(By.tagName("p"));
//				for (int i = 0; i < links.size(); i++) {
//					if (links.get(i).getText().contains("Name : Mayur (M - 3 months)")) {
//						Assert.assertTrue(true);
//					} else {
//						SoftAssert.assertFalse(false);
//						System.out.println("Only selected patient bills not showing");
//						SoftAssert.assertAll();
//					}
//				}
//			}
//		}
//	}
//
//	public void searchedBillsActions(String option, String url, int length, String name) throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		BillSettlemetTab.click();
//		billPendingId.click();
//		Thread.sleep(1000);
//		searchBills.click();
//		refAndPatientoptions.click();
//		WebElement link = TestBase.driver.findElement(By.xpath("//a[contains(text(),'Search by Patient Name')] "));
//		link.click();
//		searchBillsforRefAndPatient.sendKeys(name);
//		Thread.sleep(1000);
//		searchBillsforRefAndPatient.sendKeys(Keys.ARROW_DOWN);
//		searchBillsforRefAndPatient.sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
//		List<WebElement> opt = userBillsContainer.findElements(By.className("dropdown-toggle"));
//		opt.get(0).click();
//		if (option.equals("Print Bill")) {
//			WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			links.click();
//		}
//
//		if (option.equals("Edit Bill")) {
//			WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			links.click();
//		}
//
//		if (option.equals("View Transactions")) {
//			WebElement links = TestBase.driver.findElement(By.xpath("//a[contains(text(),'" + option + "')] "));
//			links.click();
//		}
//		String beforehandle = TestBase.driver.getWindowHandle();
//		for (String winHandle : TestBase.driver.getWindowHandles()) {
//			TestBase.driver.switchTo().window(winHandle);
//		}
//		try {
//			String Url = TestBase.driver.getCurrentUrl();
//			String actualUrl = Url.substring(0, length);
//			SoftAssert.assertEquals(actualUrl, url);
//			TestBase.driver.close();
//			TestBase.driver.switchTo().window(beforehandle);
//		} catch (Exception e) {
//			System.out.println("searchedBillsActions fails");
//		}
//	}
//
//	public void viewAllBillsList() throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		BillSettlemetTab.click();
//		billPendingId.click();
//		Thread.sleep(1000);
//		allBills.click();
//		Thread.sleep(1000);
//		List<WebElement> completedBills = TestBase.driver
//				.findElements(By.xpath("//label[contains(text(),'completed')] "));
//		int CompletedLength = completedBills.size();
//		List<WebElement> pendingBills = TestBase.driver.findElements(By.xpath("//label[contains(text(),'Pending')] "));
//		int PendingLength = pendingBills.size();
//
//		if (CompletedLength > 0 && PendingLength > 0) {
//			Assert.assertTrue(true);
//		} else {
//			SoftAssert.fail("viewAllBillsList falis");
//			SoftAssert.assertAll();
//		}
//
//	}
//
//	public void generateInvoice(String invType, String name) throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		BillSettlemetTab.click();
//		invoiceReportTab.click();
//		if (invType.equals("Organization")) {
//			Select ele = new Select(invoiceType);
//			ele.selectByVisibleText("Organization");
//		}
//
//		if (invType.equals("Referral")) {
//			Select ele = new Select(invoiceType);
//			ele.selectByVisibleText("Referral");
//		}
//
//		if (invType.equals("Customer")) {
//			Select ele = new Select(invoiceType);
//			ele.selectByVisibleText("Customer");
//		}
//		searchInvoiceName.sendKeys(name);
//		Thread.sleep(2000);
//		searchInvoiceName.sendKeys(Keys.ARROW_DOWN);
//		searchInvoiceName.sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
//		GenerateInvoice.click();
//		try {
//			Thread.sleep(1000);
//			String success = errorDiv.getText();
//			SoftAssert.assertEquals(success,
//					"×\n" + "Invoice has been generated successfully! Click here to print the invoice.");
//			SoftAssert.assertAll();
//			String beforehandle = TestBase.driver.getWindowHandle();
//			for (String winHandle : TestBase.driver.getWindowHandles()) {
//				TestBase.driver.switchTo().window(winHandle);
//			}
//			String url = TestBase.driver.getCurrentUrl();
//			String actualUrl = url.substring(0, 46);
//			SoftAssert.assertEquals(actualUrl, "https://beta.livehealth.solutions/printInvoice");
//			TestBase.driver.close();
//			TestBase.driver.switchTo().window(beforehandle);
//			SoftAssert.assertAll();
//		} catch (Exception e) {
//
//		}
//
//	}
//
//	public void selectPatientForAddTestToBill(String name) throws InterruptedException {
//		BillSettlemetTab.click();
//		addTestToBill.click();
//		searchPatientBill.sendKeys(name);
//		Thread.sleep(2000);
//		searchPatientBill.sendKeys(Keys.ARROW_DOWN);
//		searchPatientBill.sendKeys(Keys.ENTER);
//
//	}
//
//	public void addTestToExistingBill(String name, String test1, String test2, String amount) throws Exception {
//		TestBase.driver.navigate().refresh();
//		selectPatientForAddTestToBill(name);
//		Thread.sleep(1000);
//		selectTests(test1);
//		selectTests(test2);
//		AdvanceAmount.clear();
//		AdvanceAmount.sendKeys(amount);
//		saveExistingBill.click();
//		CommenMethods.waitForElementToClickable(confirmedBillUpdate);
//		confirmedBillUpdate.click();
//		Thread.sleep(1000);
//		try {
//			String tittle = GetTittile.getText();
//			Assert.assertEquals(tittle, "Add Tests In Existing Bill");
//		} catch (Exception e) {
//			System.out.println("addTestToExistingBill fails");
//		}
//	}
//
//	public void addTestToNewBillWithSameSampleId(String name, String test1, String test2, String amount)
//			throws Exception {
//		TestBase.driver.navigate().refresh();
//		selectPatientForAddTestToBill(name);
//		Thread.sleep(1000);
//		List<WebElement> bills = billListDiv.findElements(By.className("userContainer"));
//		int beforeLength = bills.size();
//		selectTests(test1);
//		selectTests(test2);
//		AdvanceAmount.clear();
//		AdvanceAmount.sendKeys(amount);
//		saveNewBill.click();
//		CommenMethods.waitForElementToClickable(confirmedBillUpdate);
//		java.util.Date now = new java.util.Date();
//		SimpleDateFormat df2 = new SimpleDateFormat("d MMM, yyyy, hh:mm a");
//		String dateText = df2.format(now);
//		confirmedBillUpdate.click();
//		Thread.sleep(1000);
//		try {
//			String tittle = GetTittile.getText();
//			Assert.assertEquals(tittle, "Add Tests In Existing Bill");
//
//			selectPatientForAddTestToBill(name);
//			bills = billListDiv.findElements(By.className("userContainer"));
//			int afterLength = bills.size();
//			if (beforeLength < afterLength) {
//				String data = bills.get(0).getText();
//				if (data.contains(dateText)) {
//					Assert.assertTrue(true);
//				} else {
//					SoftAssert.assertFalse(true);
//					SoftAssert.assertAll();
//				}
//			}
//
//		} catch (Exception e) {
//			System.out.println("addTestToNewBillWithSameSampleId fails");
//		}
//
//	}
//
//	public void alreadyExistingTestAdd(String name, String name1, String test1) throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		selectPatientForAddTestToBill(name);
//		try {
//			Thread.sleep(1000);
//			String warning = errorDivNoBill.getText();
//			SoftAssert.assertEquals(warning, "×\n" + "Error!No existing bill found for this patient");
//		} catch (Exception e) {
//			System.out.println("Error!No existing bill found for this patient warning not shown");
//		}
//		selectPatientForAddTestToBill(name1);
//		Thread.sleep(2000);
//		selectTests(test1);
//		searchInputforTests.sendKeys(test1);
//		Thread.sleep(1000);
//		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
//		searchInputforTests.sendKeys(Keys.ENTER);
//		String existedWarning = warerrorDiv.getText();
//		SoftAssert.assertEquals(existedWarning, "×\n" + "Warning! This test is already added.");
//		SoftAssert.assertAll();
//
//	}
//
//	public void stopbill(String name, String test1) throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		selectPatientForAddTestToBill(name);
//		Thread.sleep(1000);
//		if (name.equals("pos")) {
//			selectTests(test1);
//			String mesg = saveBillError.getText();
//			SoftAssert.assertEquals(mesg, "×\n"
//					+ "Sorry! This organization have a insufficient advance amount to complete bill, This bill be in pending state");
//		}
//
//		if (name.equals("pramo")) {
//			selectTests(test1);
//			String mesg = saveBillError.getText();
//			SoftAssert.assertEquals(mesg, "×\n" + "Error! This organization have a insufficient advance amount");
//
//		}
//		SoftAssert.assertAll();
//
//	}
//
//	public void orgAdavanceCalc(String name, String amount, String test1) throws Exception {
//		TestBase.driver.navigate().refresh();
//		selectPatientForAddTestToBill(name);
//		Thread.sleep(1000);
//		selectTests(test1);
//		String orgAdvance = OrgAdvanceAmount.getText();
//		AdvanceAmount.clear();
//		AdvanceAmount.sendKeys(amount);
//		String due = balanceAmount.getText();
//
//		int advAmount = Integer.parseInt(orgAdvance.replaceAll("₹", "").trim());
//		int paidAmount = Integer.parseInt(due.replaceAll("₹", "").trim());
//		int finalAdv = advAmount - paidAmount;
//
//		AdvanceAmount.clear();
//		AdvanceAmount.sendKeys(amount);
//		saveExistingBill.click();
//		CommenMethods.waitForElementToClickable(confirmedBillUpdate);
//		confirmedBillUpdate.click();
//		Thread.sleep(2000);
//		selectPatientForAddTestToBill(name);
//		Thread.sleep(1000);
//		selectTests(test1);
//		try {
//			orgAdvance = OrgAdvanceAmount.getText();
//			int orgAdv = Integer.parseInt(orgAdvance.replaceAll("₹", "").trim());
//			Assert.assertEquals(orgAdv, finalAdv);
//		} catch (Exception e) {
//			System.out.println("orgAdavanceCalc fails");
//		}
//
//	}
//
//	public void discountRestrictionOnOutsourceTest(String test, String name, String discount) throws Exception {
//		TestBase.driver.navigate().refresh();
//		selectPatientForAddTestToBill(name);
//		Thread.sleep(1000);
//		List<WebElement> bills = TestBase.driver.findElements(By.name("lab"));
//		if (test.equals("Mumps Virus IgM Antibody")) {
//			bills.get(0).click();
//			getDiscount(test, discount);
//			String warningMegs = errorDiv.getText();
//			SoftAssert.assertEquals(warningMegs, "×\n" + "Error!Consession cannot be allowed for outsource test.");
//
//		}
//
//		if (test.equals("Cytology (Non-Gyn) Nipple")) {
//			bills.get(1).click();
//			getDiscount(test, discount);
//
//			int caltotal = Integer.parseInt(testPrice) - Integer.parseInt(discount);
//			int payableAmt = Integer.parseInt(totalAmount.getText());
//			SoftAssert.assertEquals(payableAmt, caltotal);
//			saveExistingBill.click();
//			CommenMethods.waitForElementToClickable(confirmedBillUpdate);
//			confirmedBillUpdate.click();
//
//		}
//		if (test.equals("Protein/Creatinine Ratio")) {
//			bills.get(2).click();
//			Select ele = new Select(changeConcession);
//			ele.selectByVisibleText("Concession (in %)");
//			getDiscount(test, discount);
//			try {
//				int num = (int) (Integer.parseInt(testPrice) * Integer.parseInt(discount) / 100);
//				int caltotal = Integer.parseInt(testPrice) - num;
//				int payableAmt = Integer.parseInt(totalAmount.getText());
//				SoftAssert.assertEquals(payableAmt, caltotal);
//				saveExistingBill.click();
//				CommenMethods.waitForElementToClickable(confirmedBillUpdate);
//				confirmedBillUpdate.click();
//			} catch (Exception e) {
//				System.out.println("% Discount not able to add ");
//			}
//		}
//
//		SoftAssert.assertAll();
//
//	}
//
//	String testPrice;
//
//	public void getDiscount(String testName, String discount) throws InterruptedException {
//		searchInputforTests.sendKeys(testName);
//		Thread.sleep(1000);
//		searchInputforTests.sendKeys(Keys.ARROW_DOWN);
//		searchInputforTests.sendKeys(Keys.ENTER);
//		testPrice = price.getAttribute("value");
//		concession.clear();
//		concession.sendKeys(discount);
//		concession.sendKeys(Keys.ENTER);
//	}
//
//	public void paymentType(String payMode, String value, String name, String test1, String paidAmt) throws Exception {
//		TestBase.driver.navigate().refresh();
//		selectPatientForAddTestToBill(name);
//		Thread.sleep(1000);
//		List<WebElement> bills = TestBase.driver.findElements(By.name("lab"));
//
//		if (payMode.equals("Cheque")) {
//			bills.get(0).click();
//			selectTests(test1);
//			Select ele = new Select(paymentMode);
//			ele.selectByVisibleText("Cheque");
//		}
//
//		if (payMode.equals("Credit")) {
//			bills.get(1).click();
//			selectTests(test1);
//			Select ele = new Select(paymentMode);
//			ele.selectByVisibleText("Credit");
//		}
//
//		if (payMode.equals("Credit Card")) {
//			bills.get(2).click();
//			selectTests(test1);
//			Select ele = new Select(paymentMode);
//			ele.selectByVisibleText("Credit Card");
//		}
//
//		if (payMode.equals("Debit Card")) {
//			bills.get(3).click();
//			selectTests(test1);
//			Select ele = new Select(paymentMode);
//			ele.selectByVisibleText("Debit Card");
//		}
//
//		if (payMode.equals("Free")) {
//			bills.get(4).click();
//			selectTests(test1);
//			Select ele = new Select(paymentMode);
//			ele.selectByVisibleText("Free");
//		}
//
//		if (payMode.equals("Other")) {
//			bills.get(5).click();
//			selectTests(test1);
//			Select ele = new Select(paymentMode);
//			ele.selectByVisibleText("Other");
//		}
//
//		AdvanceAmount.clear();
//		AdvanceAmount.sendKeys(paidAmt);
//		try {
//			saveExistingBill.click();
//			CommenMethods.waitForElementToClickable(confirmedBillUpdate);
//			confirmedBillUpdate.click();
//			Thread.sleep(1000);
//			String tittle = GetTittile.getText();
//			SoftAssert.assertEquals(tittle, "Add Tests In Existing Bill");
//			SoftAssert.assertAll();
//		} catch (Exception e) {
//			System.out.println("issue in add test to bill with selected payment type");
//		}
//	}
//
//	public void searchUsingAccessionNo(String AccesionNo) throws InterruptedException {
//		TestBase.driver.navigate().refresh();
//		BillSettlemetTab.click();
//		addTestToBill.click();
//		if (AccesionNo.equals("000117018")) {
//			searchByAccessionNo.sendKeys(AccesionNo);
//		}
//
//		if (AccesionNo.equals("000317018")) {
//			searchByAccessionNo.sendKeys(AccesionNo);
//		}
//		if (AccesionNo.equals("000217018")) {
//			searchByAccessionNo.sendKeys(AccesionNo);
//		}
//		Thread.sleep(1000);
//		searchAccBtn.click();
//		Thread.sleep(2000);
//		List<WebElement> list = billListDiv.findElements(By.className("userContainer"));
//		int length = list.size();
//		if (length > 0) {
//			Assert.assertTrue(true);
//		} else {
//			SoftAssert.assertFalse(true);
//			System.out.println("searchUsingAccessionNo not working");
//		}
//		SoftAssert.assertAll();
//	}
//}


}
