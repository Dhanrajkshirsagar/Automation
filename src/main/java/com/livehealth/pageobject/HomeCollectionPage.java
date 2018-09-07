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
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;
import com.livehealth.util.CommonMethods;

public class HomeCollectionPage {
	SoftAssert SoftAssert = new SoftAssert();
	public static String expectedName;
	public static String expectedContact;
	public static String billSampleType1;
	public static String billSampleType2;
	public static String price1;
	public static String price2;
	public static List<WebElement> ele;

	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement adminHover;

	@FindBy(linkText = "Home Collection")
	private static WebElement HcTab;

	@FindBy(xpath = "//*[@id=\"registerUrl\"]/a")
	public WebElement registrationTab;

	@FindBy(xpath = "/html/body/section/div[2]/div[1]/div[2]/div[2]/button")
	private static WebElement TakeNewHcRequest;

	@FindBy(xpath = "/html/body/section/div[2]/div[1]/div[1]/h4/b")
	private static WebElement getTittle;

	@FindBy(id = "takeNewBtn")
	private static WebElement takeNewBtn;

	@FindBy(id = "patientReqName")
	private static WebElement patientReqName;

	@FindBy(id = "patientReqMobile")
	private static WebElement patientReqMobile;

	@FindBy(id = "patientReqAge")
	private static WebElement patientReqAge;

	@FindBy(id = "patientAddress")
	private static WebElement patientAddress;

	@FindBy(id = "gender")
	private static WebElement gender;

	@FindBy(id = "Designation")
	private static WebElement designation;

	@FindBy(id = "availableFromTime")
	private static WebElement availableFromTime;

	@FindBy(id = "availableTillTime")
	private static WebElement availableTillTime;

	@FindBy(id = "patientComments")
	private static WebElement patientComments;

	@FindBy(id = "newErrorDiv")
	private static WebElement newErrorDiv;

	@FindBy(id = "hcListContainer")
	private static WebElement hcListContainer;

	@FindBy(className = "dropdown-menu")
	private static WebElement dropdownmenu;

	@FindBy(className = "dropdown-toggle")
	private static WebElement dropdowntoggle;

	@FindBy(xpath = "	//*[@id=\"rescheduleRange\"]/span")
	private static WebElement clickToReschedule;

	@FindBy(xpath = "//*[@id=\"takeNewCollectionRequest\"]/div[1]/div/div[3]/button[1]")
	private static WebElement Close;

	@FindBy(xpath = "//*[@id=\"datetimepickerTime1\"]/input")
	private static WebElement datetimepickerTime1;

	@FindBy(xpath = "//*[@id=\"datetimepickerTime2\"]/input")
	private static WebElement datetimepickerTime2;

	@FindBy(xpath = "//*[@id=\"rescheduleModal\"]/div[1]/div/div[3]/button[2]")
	private static WebElement Confirm;

	@FindBy(id = "hcRescheduleErrorMsg")
	private static WebElement hcRescheduleErrorMsg;

	@FindBy(id = "patientNameSpan")
	private static WebElement patientNameSpan;

	@FindBy(id = "contactNo")
	private static WebElement contactNo;

	@FindBy(id = "address")
	private static WebElement address;

	@FindBy(xpath = "//*[@id=\"viewDetailsModal\"]/div/div/div[3]/button[1]")
	private static WebElement closeView;

	@FindBy(className = "userContainer")
	private static WebElement userContainer;

	@FindBy(id = "hcListDateRange")
	private static WebElement hcListDateRange;

	@FindBy(xpath = "/html/body/div[2]/div[3]/ul/li[4]")
	private static WebElement thisweek;

	@FindBy(xpath = "//*[@id=\"hcRescheduleErrorMsg\"]/div/button")
	private static WebElement close;

	@FindBy(id = "saveBill")
	private static WebElement saveBill;

	@FindBy(id = "searchInputforTests")
	private static WebElement searchTests;

	@FindBy(id = "concession")
	private static WebElement concession;

	@FindBy(id = "confirmBillMsgDiv")
	private static WebElement confirmBillMsg;

	@FindBy(id = "unassigned")
	private static WebElement unassigned;

	@FindBy(id = "AdvanceAmount")
	private static WebElement AdvanceAmount;

	@FindBy(id = "price")
	private static WebElement price;

	@FindBy(xpath = "//*[@id=\"rescheduleModal\"]/div[1]/div/div[3]/button[1]")
	private static WebElement rescheduleModal;

	@FindBy(xpath = "//*[@id=\"approveNassignModal\"]/div/div/div[3]/button[2]")
	private static WebElement confirmToAssign;

	@FindBy(id = "optionsCP")
	private static WebElement assign;

	@FindBy(id = "lstDrpdwn")
	private static WebElement lstDrpdwn;

	@FindBy(id = "ongiong")
	private static WebElement ongiong;

	@FindBy(id = "hcErrorMsg")
	private static WebElement hcErrorMsg;

	@FindBy(id = "pending")
	private static WebElement pending;

	@FindBy(css = "#rejectModal > div > div > div.modal-footer > button.btn.btn-primary")
	private static WebElement cancelHc;

	@FindBy(xpath = "//*[@id=\"rejectModal\"]/div/div/div[1]/button")
	private static WebElement CloseCancel;

	@FindBy(id = "hcRejectErrorMsg")
	private static WebElement hcRejectErrorMsg;

	@FindBy(id = "rejectComment")
	private static WebElement rejectComment;

	@FindBy(id = "newDirectFirstName")
	private static WebElement DirectFirstName;

	@FindBy(id = "newDirectDesignation")
	private static WebElement DirectDesignation;

	@FindBy(xpath = "//*[@id=\"rescheduleModal\"]/div[1]/div/div[3]/button[1]")
	private static WebElement CloseReschedule;

	@FindBy(id = "testListTable")
	private static WebElement testListTable;

	@FindBy(xpath = "//*[@id=\"assignedToDropdown\"]/select")
	private static WebElement dropDown;

	@FindAll({ @FindBy(className = "userContainer") })
	public List<WebElement> HCList;

	@FindBy(id = "assigned")
	private static WebElement assigned;

	@PostConstruct
	public void loadDriver() throws Exception {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}

	public String getHcTitle() {
		HcTab.click();
		return getTittle.getText();

	}

	public void signIn(String userName, String password) throws Exception {

		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signIn.click();
		CommonMethods.waitForElementToClickable(adminHover);
		DriverFactory.getDriver().navigate().to(Constants.Billing_URL);

	}

	public List<String> takeNewHcRequestValidations() throws Exception {
		Thread.sleep(1000);
		CommonMethods.waitForElementToClickable(TakeNewHcRequest);
		TakeNewHcRequest.click();
		CommonMethods.waitForElementToClickable(takeNewBtn);
		takeNewBtn.click();
		Thread.sleep(500);

		String patientName = patientReqName.getCssValue("border-color");

		String patientContact = patientReqMobile.getCssValue("border-color");

		String patientAge = patientReqAge.getCssValue("border-color");

		String patientAdd = patientAddress.getCssValue("border-color");

		String aviFromTime = availableFromTime.getCssValue("border-color");
		String aviTillTime = availableTillTime.getCssValue("border-color");

		ArrayList<String> list = new ArrayList<>();
		list.add(patientName);
		list.add(patientContact);
		list.add(patientAge);
		list.add(patientAdd);
		list.add(aviFromTime);
		list.add(aviTillTime);
		Close.click();
		return list;

	}

	public String takeNewHCRequest() throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		Thread.sleep(1000);
		CommonMethods.waitForElementToClickable(TakeNewHcRequest);
		TakeNewHcRequest.click();
		CommonMethods.waitForElementToVisible(takeNewBtn);
		expectedName = CommonMethods.generateRandomName();
		patientReqName.sendKeys(expectedName);
		expectedContact = CommonMethods.generateRandomContact();
		patientReqMobile.sendKeys(expectedContact);
		patientReqAge.sendKeys("22");
		patientAddress.sendKeys("pune");
		Thread.sleep(2000);
		patientAddress.sendKeys(Keys.DOWN);
		patientAddress.sendKeys(Keys.ENTER);
		availableFromTime.click();
		String TillTime = CommonMethods.reduceTime(2);
		String expectedUrl = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('availableTillTime').value = arguments[0];", TillTime);
		takeNewBtn.click();
		String errorMgs = newErrorDiv.getText();
		if (errorMgs.contains("×\n" + "Please try again later!")) {
			Assert.assertFalse(true);
		} else {
			Thread.sleep(1000);
			String winHandleBefore = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}

			String currentUrl = driver.getCurrentUrl();
			expectedUrl = currentUrl.substring(0, 41);
			DriverFactory.getDriver().close();
			driver.switchTo().window(winHandleBefore);

		}
		return expectedUrl;

	}

	public List<String> viewDetails() throws Exception {
		HcTab.click();
		DriverFactory.getDriver().navigate().refresh();
		Thread.sleep(2000);
		List<WebElement> droplist = hcListContainer.findElements(By.className("userContainer"));
		int size = droplist.size();
		WebElement elem = droplist.get(size - 1);
		elem.click();

		Thread.sleep(1000);
		String verifyName = patientNameSpan.getText();
		String actualName = verifyName.substring(0, 6);

		String actualContact = contactNo.getText();
		String contact = actualContact.replaceAll(" ", "");
		ArrayList<String> list = new ArrayList<>();
		list.add(actualName);
		list.add(contact);
		closeView.click();
		Thread.sleep(3000);
		return list;

	}

	public String takeNewHCForExistingPatient(String name) throws Exception {
		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/homeCollection/");
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("window.scrollBy(0,500)");
		WebDriver driver = DriverFactory.getDriver();
		// HcTab.click();
		Thread.sleep(1000);
		TakeNewHcRequest.click();
		CommonMethods.waitForElementToVisible(takeNewBtn);
		patientReqName.sendKeys(name);
		Thread.sleep(2000);
		patientReqName.sendKeys(Keys.DOWN);
		patientReqName.sendKeys(Keys.ENTER);
		patientAddress.clear();
		patientAddress.sendKeys("pune");
		Thread.sleep(1000);
		patientAddress.sendKeys(Keys.DOWN);
		patientAddress.sendKeys(Keys.ENTER);
		availableFromTime.click();
		String TillTime = CommonMethods.reduceTime(3);
		Thread.sleep(500);
		String subUrl = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('availableTillTime').value = arguments[0];", TillTime);
		takeNewBtn.click();
		String errorMgs = newErrorDiv.getText();
		if (errorMgs.contains("×\n" + "Please try again later!")) {
			Assert.assertFalse(true);

		} else {
			Thread.sleep(1000);
			String winHandleBefore = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			String url = driver.getCurrentUrl();
			subUrl = url.substring(0, 41);
			driver.close();
			driver.switchTo().window(winHandleBefore);

		}
		return subUrl;
	}

	public String rescheduleHCValidation() throws Exception {
		CommonMethods.waitForElementToVisible(pending);
		pending.click();
		CommonMethods.waitForElementToVisible(hcListContainer);
		Thread.sleep(1000);
		List<WebElement> dropdownlist = hcListContainer.findElements(By.className("dropdown-toggle"));
		dropdownlist.get(0).click();
		WebElement option = DriverFactory.getDriver().findElement(By.xpath("//a[contains(text(),'Reschedule')] "));
		option.click();
		Thread.sleep(500);
		clickToReschedule.click();
		datetimepickerTime1.click();
		Confirm.click();
		CommonMethods.waitForElementToVisible(hcRescheduleErrorMsg);
		String validationMgs = hcRescheduleErrorMsg.getText();
		return validationMgs;

	}

	public boolean rescheduleHcFromPendingTab() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		// pending.click();
		CommonMethods.waitForElementToVisible(hcListContainer);
		Thread.sleep(1500);
		List<WebElement> dropdownlist = hcListContainer.findElements(By.className("dropdown-toggle"));
		dropdownlist.get(0).click();
		WebElement option = DriverFactory.getDriver().findElement(By.xpath("//a[contains(text(),'Reschedule')] "));
		option.click();
		CommonMethods.waitForElementToVisible(clickToReschedule);
		clickToReschedule.click();
		String StartTime = CommonMethods.getTimeForReschedule(3);
		CommonMethods.waitForElementToVisible(datetimepickerTime1);
		datetimepickerTime1.click();
		String EndTime = CommonMethods.getTimeForReschedule(4);
		Thread.sleep(500);
		WebElement TimeBox1 = datetimepickerTime1;
		TimeBox1.sendKeys(Keys.TAB);
		TimeBox1.clear();
		TimeBox1.sendKeys(StartTime);
		Thread.sleep(500);
		WebElement TimeBox2 = datetimepickerTime2;
		TimeBox2.sendKeys(Keys.TAB);
		TimeBox2.clear();
		TimeBox2.sendKeys(EndTime);
		Confirm.click();
		String success = hcRescheduleErrorMsg.getText();
		if (success.equals("Please try again later.")) {
			return false;
		}
		return true;
	}

	public String proceedToBill(String test1, String test2, String advance) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		Thread.sleep(2000);
		List<WebElement> proceedToBill = userContainer
				.findElements(By.xpath("//button[text()=\"Proceed to billing\"]"));
		int length = proceedToBill.size();
		String success = null;
		if (length > 1) {
			length = 1;
		}
		while (length > 0) {

			proceedToBill = userContainer.findElements(By.xpath("//button[text()=\"Proceed to billing\"]"));
			length--;
			WebElement ele = proceedToBill.get(0);
			ele.click();
			String winHandleBefore = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			selectTests(test1);
			selectTests(test2);
			Thread.sleep(500);
			AdvanceAmount.clear();
			if (advance.equals("500")) {
				AdvanceAmount.sendKeys(advance);
			}
			if (advance.equals("850")) {
				AdvanceAmount.sendKeys(advance);
			}
			if (advance.equals("")) {
				AdvanceAmount.sendKeys(advance);
			}
			saveBill.click();
			Thread.sleep(500);
			List<WebElement> sampleList = DriverFactory.getDriver().findElements(By.className("billingTestList"));
			billSampleType1 = sampleList.get(0).getText();
			billSampleType2 = sampleList.get(1).getText();
			success = confirmBillMsg.getText();
			HcTab.click();
			driver.close();
			driver.switchTo().window(winHandleBefore);
			Thread.sleep(1000);

		}
		return success;

	}

	public static void selectTests(String testName) throws Exception {
		searchTests.sendKeys(testName);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span")));
		searchTests.sendKeys(Keys.ARROW_DOWN);
		searchTests.sendKeys(Keys.ENTER);
		if (testName.equals("Calcium/Creatinine Ratio Urine Spot *")) {
			price1 = price.getAttribute("value");
		} else {
			price2 = price.getAttribute("value");
		}
		concession.sendKeys(Keys.ENTER);
	}

	public String HcWithDesignations(String patientDesignation, String value) throws Exception {
		// HcTab.click();
		WebDriver driver = DriverFactory.getDriver();
		Thread.sleep(2000);
		TakeNewHcRequest.click();
		CommonMethods.waitForElementToVisible(takeNewBtn);
		String name = CommonMethods.generateRandomName();
		patientReqName.sendKeys(name);
		String contact = CommonMethods.generateRandomContact();
		patientReqMobile.sendKeys(contact);
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

		}
		if (patientDesignation.equals("Baby or Just Born (B/O)")) {
			Select MrPatient = new Select(designation);
			MrPatient.selectByVisibleText("Baby or Just Born (B/O)");

		}
		if (patientDesignation.equals("Baby")) {
			Select MrPatient = new Select(designation);
			MrPatient.selectByVisibleText("Baby");

		}
		patientReqAge.sendKeys("20");
		patientAddress.sendKeys("pune");
		Thread.sleep(500);
		patientAddress.sendKeys(Keys.DOWN);
		patientAddress.sendKeys(Keys.ENTER);
		availableFromTime.click();
		String startTime = CommonMethods.reduceTime(3);
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("document.getElementById('availableFromTime').value = arguments[0];", startTime);
		String TillTime = CommonMethods.reduceTime(4);
		Thread.sleep(500);
		JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getDriver();
		js1.executeScript("document.getElementById('availableTillTime').value = arguments[0];", TillTime);
		takeNewBtn.click();
		String Designation = null;
		String errorMgs = newErrorDiv.getText();
		if (errorMgs.equals("×\n" + "Please try again later!")) {
			Assert.assertFalse(true);
		} else {

			String winHandleBefore = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			Thread.sleep(1000);
			registrationTab.click();
			CommonMethods.waitForElementToVisible(DirectFirstName);
			DirectFirstName.sendKeys(name);
			Thread.sleep(2000);
			DirectFirstName.sendKeys(Keys.ARROW_DOWN);
			DirectFirstName.sendKeys(Keys.ENTER);

			Thread.sleep(1000);
			Designation = DirectDesignation.getAttribute("value");

			driver.close();
			driver.switchTo().window(winHandleBefore);

		}
		return Designation;

	}

	public List<String> datePicker() throws Exception {
		// HcTab.click();
		Thread.sleep(1000);
		CommonMethods.waitForElementToClickable(hcListDateRange);
		hcListDateRange.click();
		thisweek.click();
		List<WebElement> HcList = hcListContainer.findElements(By.className("userContainer"));
		int length = HcList.size();
		if (length > 4) {
			SoftAssert.assertTrue(true, "this week showing data properly");
		}
		String date = DriverFactory.getDriver().findElement(By.id("dateDiv0")).getText();
		java.util.Date now = new java.util.Date();
		SimpleDateFormat df2 = new SimpleDateFormat("MMMMM d, yyyy");
		String dateText = df2.format(now);
		ArrayList<String> list = new ArrayList<>();
		list.add(date);
		list.add(dateText);
		return list;

	}

	public boolean verifyPaidBills() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DriverFactory.getDriver().navigate().to(Constants.HomeCollection_URL);
		Thread.sleep(1000);
		CommonMethods.waitForElementToClickable(unassigned);
		unassigned.click();

		List<WebElement> HcList = hcListContainer.findElements(By.tagName("label"));
		for (int i = 0; i < HcList.size(); i++) {
			if (HcList.get(i).getText().equals("PAID : 850")) {
				return true;
			}
		}
		return false;

	}

	public boolean dueBills() throws Exception {
		CommonMethods.waitForElementToClickable(unassigned);
		unassigned.click();
		List<WebElement> HcList = hcListContainer.findElements(By.tagName("label"));
		for (int i = 0; i < HcList.size(); i++) {
			if (HcList.get(i).getText().equals("DUE : 350")) {
				return true;
			}
		}
		return false;
	}

	public boolean verifyTestDetails() throws Exception {
		HcTab.click();
		DriverFactory.getDriver().navigate().refresh();
		Thread.sleep(2000);
		unassigned.click();
		int flag = 0;
		List<WebElement> HcList = userContainer.findElements(By.xpath("//label[text()=\"PAID : 850\"]"));
		HcList.get(0).click();
		Thread.sleep(1000);
		List<WebElement> list = testListTable.findElements(By.tagName("td"));
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			if (text.equals("Calcium/Creatinine Ratio Urine Spot *")) {
				flag++;
			}
			if (text.equals("Urine")) {

				flag++;
			}
			if (text.equals("600")) {
				flag++;
			}
		}
		if (flag == 3) {
			return true;

		}
		return false;

	}

	public boolean rescheduleFromUnassignedTab() throws Exception {
//		HcTab.click();
		DriverFactory.getDriver().navigate().refresh();
		Thread.sleep(2000);
		unassigned.click();

		List<WebElement> dropdownlist = hcListContainer.findElements(By.className("dropdown-toggle"));
		dropdownlist.get(0).click();
		WebElement option = DriverFactory.getDriver().findElement(By.xpath("//a[contains(text(),'Reschedule')] "));
		option.click();
		CommonMethods.waitForElementToClickable(Confirm);
		clickToReschedule.click();
		String StartTime = CommonMethods.getTimeForReschedule(2);
		String EndTime = CommonMethods.getTimeForReschedule(3);
		Thread.sleep(500);
		datetimepickerTime1.click();
		WebElement TimeBox1 = datetimepickerTime1;
		TimeBox1.sendKeys(Keys.TAB);
		TimeBox1.clear();
		TimeBox1.sendKeys(StartTime);
		Thread.sleep(500);
		WebElement TimeBox2 = datetimepickerTime2;
		TimeBox2.sendKeys(Keys.TAB);
		TimeBox2.clear();
		TimeBox2.sendKeys(EndTime);
		Confirm.click();
		String success = hcRescheduleErrorMsg.getText();
		if (success.equals("Please try again later.")) {
			return false;
		}
		return true;
	}

	public List<String> assignCollectingPerson(String collectionPerson) throws Exception {
		// HcTab.click();
		DriverFactory.getDriver().navigate().refresh();
		Thread.sleep(2000);
		unassigned.click();
		assign.click();
		List<WebElement> select = lstDrpdwn.findElements(By.tagName("li"));
		if (collectionPerson.equals("Full")) {
			select.get(0).click();
		}
		if (collectionPerson.equals("mayur")) {
			select.get(1).click();
		}
		Thread.sleep(500);
		ArrayList<String> list = null;
		confirmToAssign.click();
		if (collectionPerson.equals("Full")) {
			String HCError = hcErrorMsg.getText();
			if (HCError.equals("Please try again later.")) {
				Assert.assertFalse(true);
			} else {
				Thread.sleep(2000);
				String colour = pending.getCssValue("background-color");
				CommonMethods.waitForElementToClickable(ongiong);
				ongiong.click();
				List<WebElement> ongoingList = hcListContainer.findElements(By.className("label-position"));
				int length = ongoingList.size();
				Thread.sleep(2000);
				String ongoingPersonName = ongoingList.get(length - 1).getText();
				list = new ArrayList<>();
				list.add(colour);
				list.add(ongoingPersonName);
			}
		}
		return list;
	}

	int beforelength;

	public void getCancelHCList() throws Exception {
//		HcTab.click();
		DriverFactory.getDriver().navigate().refresh();
		Thread.sleep(2000);
		unassigned.click();
		beforelength = HCList.size();
		if (assign.isEnabled()) {

			List<WebElement> dropdownlist = hcListContainer.findElements(By.className("dropdown-toggle"));
			for (int i = 0; i < dropdownlist.size(); i++) {
				dropdownlist.get(i).click();

				List<WebElement> dropdown = hcListContainer.findElements(By.tagName("ul"));
				String cancelText = dropdown.get(i).getText();
				if (cancelText.contains("Cancel")) {
					WebElement downlist = DriverFactory.getDriver()
							.findElement(By.xpath("//a[contains(text(),'Cancel')] "));
					downlist.click();
					break;
				}
			}
		}

	}

	public boolean checkCancel() throws Exception {
		getCancelHCList();
		CommonMethods.waitForElementToVisible(cancelHc);
		cancelHc.click();
		Thread.sleep(500);
		String warningmegs = hcRejectErrorMsg.getText();
		Assert.assertEquals(warningmegs, "×\n" + "Please enter rejection comment.");
		rejectComment.sendKeys("Cancel HC");
		CommonMethods.waitForElementToClickable(cancelHc);
		cancelHc.click();
		Thread.sleep(500);
		int afterLength = HCList.size();
		if (beforelength > afterLength) {
			return true;
		}
		return false;

	}

	public String reAssignPerson(String collectionPerson) throws Exception {
		// HcTab.click();
		DriverFactory.getDriver().navigate().refresh();
		Thread.sleep(2000);
		ongiong.click();
		assign.click();
		List<WebElement> select = lstDrpdwn.findElements(By.tagName("li"));
		String ongoingPersonName = null;
		select.get(0).click();
		Thread.sleep(1000);
		confirmToAssign.click();
		String HCError = hcErrorMsg.getText();
		if (HCError.contains("Please try again later.")) {
			Assert.assertFalse(true);
		} else {
			Thread.sleep(2000);
			String colour = pending.getCssValue("background-color");
			SoftAssert.assertEquals(colour, "rgba(91, 192, 222, 1)");
			ongiong.click();
			List<WebElement> ongoingList = hcListContainer.findElements(By.className("label-position"));
			Thread.sleep(2000);
			ongoingPersonName = ongoingList.get(1).getText();

		}
		return ongoingPersonName;

	}

	public boolean collectingPersonFilter() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		assignCollectingPerson("mayur");
		Thread.sleep(2000);
		ongiong.click();
		Select ele = new Select(dropDown);
		ele.selectByVisibleText("mayur");
		List<WebElement> list = hcListContainer.findElements(By.tagName("label"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals("Assigned To : Full")) {
				return false;
			}
		}
		return true;

	}

	public boolean assingedTab() throws Exception {
		Thread.sleep(1000);
		ongiong.click();
		CommonMethods.waitForElementToClickable(assigned);
		assigned.click();
		if (HCList.size() > 1) {
			return true;
		}
		return false;

	}

}
