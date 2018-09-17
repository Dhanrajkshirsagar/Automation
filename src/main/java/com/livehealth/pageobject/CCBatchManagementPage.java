package com.livehealth.pageobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;
import com.livehealth.util.CommonMethods;

import ch.qos.logback.core.net.SyslogOutputStream;

public class CCBatchManagementPage {

	@FindBy(how = How.ID, using = "username")
	public WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	public WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	public WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	public WebElement adminHover;

	@FindBy(id = "userAccessionManagement")
	private WebElement userAccessionManagement;

	@FindBy(id = "addUserBatchMgmtAccess")
	private WebElement addUserBatchMgmtAccess;

	@FindBy(id = "orgEditList")
	private WebElement orgEditList;

	@FindBy(id = "orgUploadButton")
	private WebElement orgUploadButton;

	@FindBy(id = "nav-sidebar")
	private WebElement navsidebar;

	@FindBy(xpath = "//a[contains(text(),'Sample Accession / Batch Management')]")
	private WebElement SampleAccessionTab;

	@FindBy(xpath = "//a[contains(text(),'Print')]")
	private WebElement Print;

	@FindBy(xpath = "//*[@id=\"userContainer28742\"]/div[7]/input")
	private WebElement PrintButton;

	@FindAll({ @FindBy(className = "userWaitingListCard") })
	private List<WebElement> pendingSampleList;

	@FindBy(id = "billUrl")
	private WebElement billUrl;

	@FindBy(id = "manualSampleId")
	private WebElement manualSampleId;

	@FindBy(id = "registerUrl")
	private WebElement registerUrl;

	@FindBy(id = "newDirectPatientType")
	private WebElement newDirectPatientType;

	@FindBy(id = "searchPatient")
	private WebElement searchPatient;

	@FindBy(id = "newDirectFirstName")
	private WebElement newDirectFirstName;

	@FindBy(id = "newDirectBillReferal")
	private WebElement newDirectBillReferal;

	@FindBy(id = "newDirectProceedBilling")
	private WebElement newDirectProceedBilling;

	@FindBy(id = "searchInputforTests")
	private WebElement searchInputforTests;

	@FindBy(id = "concession")
	private WebElement concession;

	@FindBy(id = "saveBill")
	private WebElement saveBill;

	@FindBy(id = "backToRegistration")
	private WebElement backToRegistration;

	@FindBy(id = "confirmBillMsgDiv")
	private WebElement confirmBillMsgDiv;

	@FindAll({ @FindBy(className = "waitingListPaitentNameMargin") })
	private List<WebElement> patientNameList;

	@FindAll({ @FindBy(className = "waitingListLabOptionList") })
	private List<WebElement> optionsList;

	@FindBy(xpath = "//a[contains(text(),'Dismiss Sample')]")
	private WebElement DismissSample;

	@FindBy(xpath = "//button[contains(text(),'Receive')]")
	private WebElement receiveButton;

	@FindBy(xpath = "//button[contains(text(),'Receive & Print')]")
	private WebElement ReceivePrint;

	@FindBy(id = "rejectComments")
	private WebElement rejectComments;

	@FindBy(id = "updateAccessBtn")
	private WebElement updateAccessBtn;

	@FindBy(id = "confirmedSampleRemoval")
	private WebElement confirmedSampleRemoval;

	@FindBy(id = "permissionError")
	private WebElement permissionError;

	@FindBy(id = "errorMsg")
	private WebElement errorMsg;

	@FindBy(id = "updateSampleDate1")
	private WebElement updateSampleDate1;

	@FindBy(xpath = "//a[contains(text(),'Update Sample Date')]")
	private WebElement UpdateSampleDate;

	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement Update;

	@FindBy(xpath = "//a[contains(text(),'Rejected Samples')]")
	private WebElement RejectedSamples;

	@FindBy(xpath = "//a[contains(text(),'Accessed')]")
	private WebElement Accessed;

	@FindBy(id = "createBatchBtn")
	private WebElement createBatchBtn;

	@FindBy(id = "allSampleInBatchQueue")
	private WebElement allSampleInBatchQueue;

	@FindBy(xpath = "//*[@id=\"sampleCreateTotal\"]/small")
	private WebElement sampleConunt;

	@FindBy(id = "searchSamplePatient")
	private WebElement searchSamplePatient;

	@FindBy(id = "sampleOfBatchAppendDiv")
	private WebElement sampleOfBatchAppendDiv;

	@FindBy(xpath = "//*[@id=\"sampleOfBatchAppendDiv\"]/div[1]/p")
	private WebElement sampleId;

	@FindBy(id = "selectAllSampleBatchFlag")
	private WebElement selectAllSampleBatchFlag;

	@FindBy(id = "searchSampleAccessionInput")
	private WebElement searchSampleAccessionInput;

	@FindBy(id = "searchReferral")
	private WebElement searchReferral;

	@FindBy(id = "patientTypeFilter")
	private WebElement patientTypeFilter;

	@FindBy(id = "clearFilterLink")
	private WebElement clearFilterLink;

	@FindBy(id = "accBatchCreateBtn")
	private WebElement accBatchCreateBtn;

	@FindBy(id = "batchTemp")
	private WebElement batchTemp;

	@FindBy(xpath = "//*[@id=\"summeryTotalDiv\"]/small")
	private WebElement reportViewFontSize;

	@FindBy(id = "batchCollectingPerson")
	private WebElement batchCollectingPerson;

	@FindAll({ @FindBy(name = "createPendingBatch") })
	private List<WebElement> selectAll;

	@FindBy(id = "pendingBatchPill")
	private WebElement pendingBatchPill;

	@FindBy(id = "toBeReceivedPill")
	private WebElement toBeReceivedPill;

	@FindBy(id = "rejectSample")
	private WebElement rejectSample;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'View & Print')]") })
	private List<WebElement> viewAndPrintbutton;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'View & Receive')]") })
	private List<WebElement> ViewReceive;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'Accept')]") })
	private List<WebElement> AcceptButton;

	@FindAll({ @FindBy(xpath = "//a[contains(text(),'Reject')]") })
	private List<WebElement> Reject;

	@FindBy(xpath = "//*[@id=\"logisticDetailsDiv\"]/div[5]/small")
	private WebElement temp;

	@FindBy(xpath = "//*[@id=\"logisticDetailsDiv\"]/div[2]/small")
	private WebElement fromCentre;

	@FindBy(xpath = "//*[@id=\"logisticDetailsDiv\"]/div[3]/small")
	private WebElement ToCentre;

	@FindBy(xpath = "//*[@id=\"logisticDetailsDiv\"]/div[4]/small")
	private WebElement createdBy;

	@FindBy(xpath = "//*[@id=\"logisticDetailsDiv\"]/div[6]/small")
	private WebElement collectingPerson;

	@FindBy(id = "batchViewAppendDiv")
	private WebElement batchViewAppendDiv;

	@FindBy(xpath = "//*[@id=\"batchHistAppendDiv\"]/div[2]/p")
	private WebElement batchHistory;

	@FindBy(id = "sampleBatchViewModalLabel")
	private WebElement sampleBatchViewModalLabel;

	@FindBy(xpath = "//a[contains(text(),'View Batch Activity Details')]")
	private WebElement ViewBatch;

	@FindBy(xpath = "//*[@id=\"batchViewAppendDiv\"]/div[4]/button")
	private WebElement Printbarcode;

	@FindBy(xpath = "//button[contains(text(),'Accept Selected')]")
	private WebElement AcceptSelected;

	@FindBy(xpath = "//button[contains(text(),'Accept All Batch')]")
	private WebElement AcceptAllBatch;

	@FindBy(xpath = "//a[contains(text(),'Enable')]")
	private WebElement Enable;

	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Dismissed')]") })
	private List<WebElement> dissmissLabel;

	public void signIn(String userName, String password) throws Exception {

		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signIn.click();
		CommonMethods.waitForElementToClickable(adminHover);

	}

	public boolean batchManagementAccessionAccess(String userName, String password, String OrgName) throws Exception {
		DriverFactory.getDriver().get(Constants.EDIT_ORGANIZATION_URL);
		CommonMethods.waitForElementToVisible(orgEditList);
		orgEditList.sendKeys(OrgName);
		Thread.sleep(500);
		orgEditList.sendKeys(Keys.ARROW_DOWN);
		orgEditList.sendKeys(Keys.ENTER);
		if (!userAccessionManagement.isSelected()) {
			userAccessionManagement.click();
		}
		if (!addUserBatchMgmtAccess.isSelected()) {
			addUserBatchMgmtAccess.click();
		}
		CommonMethods.waitForElementToClickable(orgUploadButton);
		orgUploadButton.click();
		Thread.sleep(300);
		DriverFactory.getDriver().get(Constants.LOGOUT_URL);
		signIn(userName, password);
		List<WebElement> list = navsidebar.findElements(By.tagName("a"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals("Sample Accession / Batch Management")) {
				return true;
			}
		}
		return false;
	}

	public String patientBill(String name, String test1, String test2, String test3) throws Exception {
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
		selectTests(test3);
		saveBill.click();
		String success = confirmBillMsgDiv.getText();
		Thread.sleep(500);
		backToRegistration.click();
		return success;

	}

	public String createBillWithReferrel(String name, String test1, String test2, String test3) throws Exception {
		registerUrl.click();
		selectPatient(name);
		Select ele = new Select(newDirectBillReferal);
		ele.selectByVisibleText("Rahul");
		CommonMethods.waitForElementToClickable(newDirectProceedBilling);
		newDirectProceedBilling.click();
		CommonMethods.waitForElementToVisible(searchInputforTests);
		selectTests(test1);
		selectTests(test2);
		selectTests(test3);
		saveBill.click();
		String success = confirmBillMsgDiv.getText();
		Thread.sleep(500);
		backToRegistration.click();
		return success;

	}

	public String createBillWithPatientType(String patientType, String name, String test1, String test2, String test3)
			throws Exception {
		DriverFactory.getDriver().navigate().to(Constants.REGISTRATION_URL);
		Select type = new Select(newDirectPatientType);
		if (patientType.equals("Health Camp (HC)")) {
			selectPatient(name);
			type.selectByVisibleText("Health Camp (HC)");
		}
		if (patientType.equals("Red (R)")) {
			selectPatient(name);
			type.selectByVisibleText("Red (R)");
		}
		if (patientType.equals("Green (G)")) {
			selectPatient(name);
			type.selectByVisibleText("Green (G)");
		}
		CommonMethods.waitForElementToClickable(newDirectProceedBilling);
		newDirectProceedBilling.click();
		CommonMethods.waitForElementToVisible(searchInputforTests);
		selectTests(test1);
		selectTests(test2);
		selectTests(test3);
		saveBill.click();
		String success = confirmBillMsgDiv.getText();
		Thread.sleep(500);
		backToRegistration.click();
		return success;

	}

	public void selectPatient(String name) throws InterruptedException {
		newDirectFirstName.sendKeys(name);
		Thread.sleep(1500);
		newDirectFirstName.sendKeys(Keys.ARROW_DOWN);
		newDirectFirstName.sendKeys(Keys.ENTER);
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

	public boolean pendingSampleList() throws Exception {
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		if (pendingSampleList.size() > 0) {
			return true;
		}

		return false;
	}

	public String patientName() throws Exception {
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		String name = patientNameList.get(1).getText();
		return name;

	}

	public List<String> printSampleBarcode() throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		String sampleid = patientNameList.get(0).getText();
		optionsList.get(0).click();
		String beforeWindowHandle = driver.getWindowHandle();
		Print.click();
		for (String afterWindowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(afterWindowHandle);
		}
		String Url = driver.getCurrentUrl();
		ArrayList<String> list = new ArrayList<>();
		list.add(sampleid);
		list.add(Url);
		driver.close();
		driver.switchTo().window(beforeWindowHandle);
		return list;

	}

	public String dissmissLockedBill() throws Exception {
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		optionsList.get(0).click();
		DismissSample.click();
		CommonMethods.waitForElementToClickable(confirmedSampleRemoval);
		rejectComments.sendKeys("Sample Dissmiss");
		confirmedSampleRemoval.click();
		Thread.sleep(500);
		return permissionError.getText();
	}

	public boolean receiveSample() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		int beforeLength = pendingSampleList.size();
		receiveButton.click();
		Thread.sleep(500);
		int afterLength = pendingSampleList.size();
		if (beforeLength > afterLength) {
			return true;
		}
		return false;
	}

	public List<String> receiveAndPrintButton() throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		String sampleid = patientNameList.get(0).getText();
		String beforeWindowHandle = driver.getWindowHandle();
		ReceivePrint.click();
		Thread.sleep(1000);
		for (String afterWindowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(afterWindowHandle);
		}
		String Url = driver.getCurrentUrl();
		ArrayList<String> list = new ArrayList<>();
		list.add(sampleid);
		list.add(Url);
		driver.close();
		driver.switchTo().window(beforeWindowHandle);
		return list;

	}

	public List<String> updateSampleDate() throws Exception {
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		optionsList.get(0).click();
		CommonMethods.waitForElementToClickable(UpdateSampleDate);
		UpdateSampleDate.click();
		Thread.sleep(1000);
		String backDate = CommonMethods.getBackDatee(1);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("document.getElementById('updateSampleDate1').value = arguments[0];", backDate);
		String myDate = (String) js.executeScript("return document.getElementById('updateSampleDate1').value");
		Update.click();
		CommonMethods.waitForElementToVisible(errorMsg);
		String success = errorMsg.getText();
		optionsList.get(0).click();
		CommonMethods.waitForElementToClickable(UpdateSampleDate);
		UpdateSampleDate.click();
		Thread.sleep(500);
		String dateTime = updateSampleDate1.getAttribute("value");
		ArrayList<String> list = new ArrayList<>();
		list.add(success);
		list.add(dateTime);
		list.add(backDate);
		return list;

	}

	public boolean dismissSample() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		int beforeLength = pendingSampleList.size();
		optionsList.get(0).click();
		CommonMethods.waitForElementToClickable(DismissSample);
		DismissSample.click();
		CommonMethods.waitForElementToClickable(confirmedSampleRemoval);
		rejectComments.sendKeys("Sample Dissmiss");
		confirmedSampleRemoval.click();
		Thread.sleep(1000);
		int afterLength = pendingSampleList.size();
		if (beforeLength > afterLength) {
			return true;
		}
		return false;
	}

	public ArrayList<String> searchSampleFilter() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		String sampleId = patientNameList.get(4).getText();
		createBatchBtn.click();
		CommonMethods.waitForElementToVisible(searchSampleAccessionInput);
		searchSampleAccessionInput.sendKeys(sampleId);
		Thread.sleep(100);
		searchSampleAccessionInput.sendKeys(Keys.ARROW_DOWN);
		searchSampleAccessionInput.sendKeys(Keys.ENTER);
		Thread.sleep(100);
		String sample = patientNameList.get(0).getText();
		ArrayList<String> list = new ArrayList<>();
		list.add(sampleId);
		list.add(sample);
		return list;

	}

	public boolean searchPatientSampleFilter(String name) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		createBatchBtn.click();
		CommonMethods.waitForElementToVisible(searchSampleAccessionInput);
		searchSampleAccessionInput.sendKeys(name);
		Thread.sleep(100);
		searchSampleAccessionInput.sendKeys(Keys.ARROW_DOWN);
		searchSampleAccessionInput.sendKeys(Keys.ENTER);
		Thread.sleep(100);
		for (int i = 0; i < patientNameList.size(); i++) {
			if ((i % 2) == 0) {
			} else {
				if (!patientNameList.get(i).getText().equals("Pratik (M - 0)")) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean searchReferralFilter(String name) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DriverFactory.getDriver().navigate().to(Constants.REGISTRATION_URL);
		createBillWithReferrel("sham", "T3,Total (Tri Iodothyronine)", "Androstenedione", "G6PD Quantitative");
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		createBatchBtn.click();
		CommonMethods.waitForElementToVisible(searchSampleAccessionInput);
		searchReferral.sendKeys(name);
		Thread.sleep(100);
		searchReferral.sendKeys(Keys.ARROW_DOWN);
		searchReferral.sendKeys(Keys.ENTER);
		Thread.sleep(100);
		for (int i = 0; i < patientNameList.size(); i++) {
			if ((i % 2) == 0) {
			} else {
				if (!patientNameList.get(i).getText().equals("Sham (M - 0)")) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean patientTypeFilter(String patientType, String name) throws Exception {
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		int flag = 0;
		if (patientType.equals("Health Camp (HC)")) {
			SampleAccessionTab.click();
			CommonMethods.waitForAllElementsToVisible(pendingSampleList);
			createBatchBtn.click();
			Select ele = new Select(patientTypeFilter);
			CommonMethods.waitForElementToVisible(searchSampleAccessionInput);
			ele.selectByVisibleText("Health Camp (HC)");
		}
		if (patientType.equals("Red (R)")) {
			Select ele = new Select(patientTypeFilter);
			ele.selectByVisibleText("Red (R)");
		}
		if (patientType.equals("Green (G)")) {
			Select ele = new Select(patientTypeFilter);
			ele.selectByVisibleText("Green (G)");
		}
		Thread.sleep(1000);
		for (int i = 0; i < patientNameList.size(); i++) {
			if ((i % 2) == 0) {
			} else {
				if (!patientNameList.get(i).getText().equals(name + " (M - 0)")) {
					flag++;
				}
			}
		}
		if (flag == 1) {
			return false;
		}
		return true;
	}

	public String clearFilter() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		createBatchBtn.click();
		Select ele = new Select(patientTypeFilter);
		CommonMethods.waitForElementToVisible(searchSampleAccessionInput);
		ele.selectByVisibleText("Health Camp (HC)");
		clearFilterLink.click();
		Thread.sleep(500);
		String value = patientTypeFilter.getAttribute("value");
		return value;

	}

	public boolean selectAllCheckBox() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		createBatchBtn.click();
		CommonMethods.waitForElementToClickable(selectAllSampleBatchFlag);
		int flag = 0;
		selectAllSampleBatchFlag.click();
		int length = selectAll.size();
		Thread.sleep(500);
		for (int i = 0; i < selectAll.size(); i++) {
			if (selectAll.get(i).isSelected()) {
				flag++;
			}
		}
		if (flag == length) {
			return true;
		}
		return false;
	}

	public List<String> searchSampleFromCreateBatch() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		createBatchBtn.click();
		CommonMethods.waitForElementToClickable(selectAllSampleBatchFlag);
		String sampleid = patientNameList.get(0).getText();
		createBatchBtn.click();
		CommonMethods.waitForElementToVisible(searchSamplePatient);
		searchSamplePatient.sendKeys(sampleid);
		Thread.sleep(1500);
		searchSamplePatient.sendKeys(Keys.ARROW_DOWN);
		searchSamplePatient.sendKeys(Keys.ENTER);
		CommonMethods.waitForElementToVisible(sampleId);
		String sampleText = sampleId.getText();
		return Arrays.asList(sampleid, sampleText);
	}

	public List<String> addAllPendingSample() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		String beforeLength = Integer.toString(pendingSampleList.size());
		createBatchBtn.click();
		CommonMethods.waitForElementToClickable(selectAllSampleBatchFlag);
		createBatchBtn.click();
		CommonMethods.waitForElementToClickable(allSampleInBatchQueue);
		allSampleInBatchQueue.click();
		String totalSample = sampleConunt.getText();
		return Arrays.asList(beforeLength, totalSample);
	}

	public String removeSampleFromBatch() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		createBatchBtn.click();
		CommonMethods.waitForElementToClickable(selectAllSampleBatchFlag);
		selectAll.get(0).click();
		selectAll.get(1).click();
		selectAll.get(2).click();
		selectAll.get(3).click();
		CommonMethods.waitForElementToClickable(createBatchBtn);
		createBatchBtn.click();
		CommonMethods.waitForElementToClickable(accBatchCreateBtn);
		List<WebElement> removeIcon = sampleOfBatchAppendDiv.findElements(By.tagName("button"));
		removeIcon.get(0).click();
		removeIcon = sampleOfBatchAppendDiv.findElements(By.tagName("button"));
		removeIcon.get(1).click();
		String afterRemovetotal = sampleConunt.getText().trim();
		return afterRemovetotal;
	}

	public boolean receiveSampleManually(String SampleId) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		int beforeLength = pendingSampleList.size();
		pendingSampleList.get(0).click();
		CommonMethods.waitForElementToClickable(updateAccessBtn);
		manualSampleId.sendKeys(SampleId);
		updateAccessBtn.click();
		Thread.sleep(1000);
		int afterLength = pendingSampleList.size();
		if (beforeLength > afterLength) {
			return true;
		}
		return false;
	}

	public List<String> tempretureAndCollectingPerson(String batTemp, String Pname) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		createBatchBtn.click();
		CommonMethods.waitForElementToClickable(selectAllSampleBatchFlag);
		selectAll.get(0).click();
		selectAll.get(1).click();
		CommonMethods.waitForElementToClickable(createBatchBtn);
		createBatchBtn.click();
		CommonMethods.waitForElementToClickable(accBatchCreateBtn);
		batchTemp.sendKeys(batTemp);
		batchCollectingPerson.sendKeys(Pname);
		String beforeWindowSwitch = driver.getWindowHandle();
		accBatchCreateBtn.click();
		Thread.sleep(500);
		for (String afterWindow : driver.getWindowHandles()) {
			driver.switchTo().window(afterWindow);
		}
		driver.close();
		driver.switchTo().window(beforeWindowSwitch);
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(viewAndPrintbutton);
		viewAndPrintbutton.get(viewAndPrintbutton.size() - 1).click();
		Thread.sleep(1000);
		String tempreture = temp.getText();
		String Cperson = collectingPerson.getText();
		return Arrays.asList(tempreture, Cperson);
	}

	public List<String> logisticSummery() throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(viewAndPrintbutton);
		viewAndPrintbutton.get(viewAndPrintbutton.size() - 1).click();
		Thread.sleep(1000);
		String from = fromCentre.getText();
		String to = ToCentre.getText();
		String created = createdBy.getText();
		return Arrays.asList(from, to, created);
	}

	public List<String> batchActivityDetails() throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(viewAndPrintbutton);
		viewAndPrintbutton.get(viewAndPrintbutton.size() - 1).click();
		Thread.sleep(1000);
		List<WebElement> details = batchViewAppendDiv.findElements(By.tagName("p"));
		String sampleId = details.get(0).getText();
		String name = details.get(1).getText();
		String batchNo = sampleBatchViewModalLabel.getText();
		String finalBatchNo = batchNo.substring(10, batchNo.length()).trim();
		String[] arr = finalBatchNo.split("\\(");
		String finalBatch = arr[0];
		List<WebElement> sampleType = batchViewAppendDiv.findElements(By.tagName("span"));
		String type = sampleType.get(1).getText();
		String[] array = name.split("\\(");
		String finalName = array[0];
		ViewBatch.click();
		CommonMethods.waitForElementToVisible(batchHistory);
		String history = batchHistory.getText();
		return Arrays.asList(sampleId, finalName, type, history, finalBatch);
	}

	public List<String> printBarcode() throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(viewAndPrintbutton);
		viewAndPrintbutton.get(viewAndPrintbutton.size() - 1).click();
		Thread.sleep(1000);
		List<WebElement> details = batchViewAppendDiv.findElements(By.tagName("p"));
		String sampleId = details.get(0).getText();
		String beforeWindowSwitch = driver.getWindowHandle();
		Printbarcode.click();
		Thread.sleep(500);
		for (String afterWindow : driver.getWindowHandles()) {
			driver.switchTo().window(afterWindow);
		}
		String Url = driver.getCurrentUrl();
		driver.close();
		driver.switchTo().window(beforeWindowSwitch);
		return Arrays.asList(sampleId, Url);
	}

	public String samplesfromMainCentre(String userName, String password) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		createBatchBtn.click();
		CommonMethods.waitForElementToClickable(selectAllSampleBatchFlag);
		selectAll.get(0).click();
		selectAll.get(1).click();
		selectAll.get(2).click();
		selectAll.get(4).click();
		CommonMethods.waitForElementToClickable(createBatchBtn);
		createBatchBtn.click();
		String beforeWindowSwitch = driver.getWindowHandle();
		CommonMethods.waitForElementToClickable(accBatchCreateBtn);
		accBatchCreateBtn.click();
		Thread.sleep(500);
		for (String afterWindow : driver.getWindowHandles()) {
			driver.switchTo().window(afterWindow);
		}
		driver.close();
		driver.switchTo().window(beforeWindowSwitch);
		driver.get(Constants.LOGOUT_URL);
		signIn(userName, password);
		driver.navigate().to(Constants.ACCESSION_URL);
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(ViewReceive);
		ViewReceive.get(ViewReceive.size() - 1).click();
		Thread.sleep(1000);
		String totalSampleCount = reportViewFontSize.getText().trim();
		return totalSampleCount;

	}

	public boolean acceptBatchSampleFromMainCentre() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(ViewReceive);
		ViewReceive.get(ViewReceive.size() - 1).click();
		Thread.sleep(1000);
		int beforeAccept = Integer.parseInt(reportViewFontSize.getText().trim());
		AcceptButton.get(0).click();
		CommonMethods.waitForElementToClickable(AcceptSelected);
		AcceptSelected.click();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(ViewReceive);
		ViewReceive.get(ViewReceive.size() - 1).click();
		Thread.sleep(1000);
		int afterAccept = Integer.parseInt(reportViewFontSize.getText().trim());
		if (beforeAccept > afterAccept) {
			return true;
		}
		return false;
	}

	public boolean rejectBatchSampleFromMainCentre(String userName, String password) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(ViewReceive);
		ViewReceive.get(ViewReceive.size() - 1).click();
		Thread.sleep(1000);
		List<WebElement> details = batchViewAppendDiv.findElements(By.tagName("p"));
		String sampleId = details.get(0).getText();
		CommonMethods.waitForElementToClickable(rejectSample);
		rejectSample.click();
		CommonMethods.waitForElementToClickable(AcceptSelected);
		AcceptSelected.click();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(ViewReceive);
		ViewReceive.get(ViewReceive.size() - 1).click();
		CommonMethods.waitForElementToClickable(rejectSample);
		rejectSample.click();
		CommonMethods.waitForElementToClickable(AcceptSelected);
		AcceptSelected.click();
		DriverFactory.getDriver().get(Constants.LOGOUT_URL);
		signIn(userName, password);
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		RejectedSamples.click();
		Thread.sleep(1000);
		for (int i = 0; i < patientNameList.size(); i++) {
			if ((i % 2) == 0) {
				if (patientNameList.get(i).getText().equals(sampleId)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean acceptAllBatch(String userName, String password, String user, String pwd) throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		createBatchBtn.click();
		CommonMethods.waitForElementToClickable(selectAllSampleBatchFlag);
		selectAll.get(0).click();
		selectAll.get(1).click();
		selectAll.get(2).click();
		CommonMethods.waitForElementToClickable(createBatchBtn);
		createBatchBtn.click();
		String beforeWindowSwitch = driver.getWindowHandle();
		CommonMethods.waitForElementToClickable(accBatchCreateBtn);
		accBatchCreateBtn.click();
		Thread.sleep(500);
		for (String afterWindow : driver.getWindowHandles()) {
			driver.switchTo().window(afterWindow);
		}
		driver.close();
		driver.switchTo().window(beforeWindowSwitch);
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		int beforeBatchLength = pendingSampleList.size();
		driver.get(Constants.LOGOUT_URL);
		signIn(userName, password);
		driver.navigate().to(Constants.ACCESSION_URL);
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(ViewReceive);
		ViewReceive.get(ViewReceive.size() - 1).click();
		CommonMethods.waitForElementToClickable(AcceptAllBatch);
		AcceptAllBatch.click();
		driver.get(Constants.LOGOUT_URL);
		signIn(user, pwd);
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		CommonMethods.waitForElementToClickable(pendingBatchPill);
		pendingBatchPill.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		int afterBatchLength = pendingSampleList.size();
		if (beforeBatchLength > afterBatchLength) {
			return true;
		}
		return false;
	}

	public boolean enableRejectedSample() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		RejectedSamples.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		int beforeLength = pendingSampleList.size();
		optionsList.get(0).click();
		optionsList.get(0).click();
		Enable.click();
		Thread.sleep(500);
		int afterLength = pendingSampleList.size();
		if (beforeLength > afterLength) {
			return true;
		}
		return false;
	}

	public boolean dissmissRejectedSample() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		RejectedSamples.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		int beforeLength = dissmissLabel.size();
		optionsList.get(0).click();
		optionsList.get(0).click();
		DismissSample.click();
		CommonMethods.waitForElementToClickable(confirmedSampleRemoval);
		rejectComments.sendKeys("Rejected Sample Dissmissed");
		confirmedSampleRemoval.click();
		Thread.sleep(500);
		int afterLength = dissmissLabel.size();
		if (beforeLength > afterLength) {
			return true;
		}
		return false;
	}

	public List<String> printBarcodeFromAccessed() throws Exception {
		WebDriver driver = DriverFactory.getDriver();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		Accessed.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		String sampleId = patientNameList.get(0).getText();
		String beforeWindowSwitch = driver.getWindowHandle();
		PrintButton.click();
		Thread.sleep(500);
		for (String afterWindow : driver.getWindowHandles()) {
			driver.switchTo().window(afterWindow);
		}
		String Url = DriverFactory.getDriver().getCurrentUrl();
		driver.close();
		driver.switchTo().window(beforeWindowSwitch);
		return Arrays.asList(sampleId, Url);

	}

	public boolean searchPatientUsingSampleId() throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		Accessed.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		String sampleId = patientNameList.get(0).getText();
		DriverFactory.getDriver().findElement(By.id("optionLink")).click();
		searchSampleAccessionInput.sendKeys(sampleId);
		Thread.sleep(100);
		searchSampleAccessionInput.sendKeys(Keys.ARROW_DOWN);
		searchSampleAccessionInput.sendKeys(Keys.ENTER);
		for (int i = 0; i < patientNameList.size(); i++) {
			if ((i % 2) == 0) {
				if (patientNameList.get(i).getText().equals(sampleId)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean searchPatientUsingPatientName(String name) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(SampleAccessionTab);
		SampleAccessionTab.click();
		Accessed.click();
		CommonMethods.waitForAllElementsToVisible(pendingSampleList);
		DriverFactory.getDriver().findElement(By.id("optionLink")).click();
		searchSampleAccessionInput.sendKeys(name);
		Thread.sleep(100);
		searchSampleAccessionInput.sendKeys(Keys.ARROW_DOWN);
		searchSampleAccessionInput.sendKeys(Keys.ENTER);
		for (int i = 0; i < patientNameList.size(); i++) {
			if ((i % 2) == 0) {
			} else {
				if (!patientNameList.get(i).getText().equals("Pratik (M - 0)")) {
					return false;
				}
			}
		}
		return true;
	}
}
