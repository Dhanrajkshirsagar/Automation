package com.livehealth.pageobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

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
import com.livehealth.util.CommonMethods;
import com.livehealth.util.WebContext;

@Component
public class AccessionPage {

	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement adminHover;

	@FindBy(how = How.LINK_TEXT, using = "Accession")
	private WebElement accession;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement waitingId;

	@FindBy(how = How.ID, using = "AdvanceAmount")
	private WebElement advanceAmount;

	@FindBy(how = How.ID, using = "totalAmount")
	private WebElement payableAmount;

	@FindBy(how = How.ID, using = "saveBill")
	private WebElement saveBill;

	@FindBy(how = How.XPATH, using = "(//label[@class=\"waitingListPaitentNameMargin\"])[1]")
	private WebElement firstRow;

	@FindBy(how = How.ID, using = "searchPatient")
	private WebElement searchUserForBilling;

	@FindBy(how = How.ID, using = "searchInputforTests")
	private WebElement testList;

	@FindBy(how = How.ID, using = "concession")
	private WebElement concession;

	@FindBy(how = How.ID, using = "pendingSampleList")
	private WebElement pendingSampleList;

	@FindBy(how = How.ID, using = "confirmBillId")
	private WebElement confirmBillId;

	@FindBy(how = How.ID, using = "rejectComments")
	private WebElement rejectComments;

	@FindBy(how = How.ID, using = "confirmedSampleRemoval")
	private WebElement confirmedSampleRemoval;

	@FindBy(how = How.ID, using = "myModalLabel")
	private WebElement myModalLabel;

	@FindBy(how = How.LINK_TEXT, using = "Accessed")
	private WebElement accessed;

	@FindAll({ @FindBy(className = "waitingListPaitentNameMargin") })
	public List<WebElement> sampleList;

	@FindAll({ @FindBy(className = "userWaitingListCard") })
	public List<WebElement> collectedSample;

	@FindAll({ @FindBy(xpath = "//*[contains(text(),'Options')]") })
	public List<WebElement> options;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Dismiss Sample')]")
	private WebElement dismissSample;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'Receive')]") })
	public List<WebElement> receive;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div/div[8]/div[1]/div[7]/input[2]")
	private WebElement redraw;

	@FindBy(how = How.ID, using = "redrawComments")
	private WebElement redrawComments;

	@FindBy(how = How.ID, using = "redrawCommentBtn")
	private WebElement redrawCommentBtn;

	@FindAll({ @FindBy(xpath = "//label[contains(text(),'Sample Redrawn')]") })
	public List<WebElement> sampleRedrawn;

	@FindBy(how = How.ID, using = "redrawCommentModalLabel")
	private WebElement redrawCommentModalLabel;

	@FindBy(how = How.LINK_TEXT, using = "Accession Settings")
	private WebElement accessionSettings;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[2]/div[2]/button")
	private WebElement addEdit;

	@FindBy(how = How.ID, using = "sampleTypeName")
	private WebElement sampleTypeName;

	@FindBy(how = How.ID, using = "typeOfSample")
	private WebElement typeOfSample;

	@FindBy(how = How.ID, using = "addNewSampleTypeModalLabel")
	private WebElement addNewSampleTypeModalLabel;

	@FindBy(how = How.ID, using = "addSampleBtn")
	private WebElement addSampleBtn;

	@FindBy(how = How.ID, using = "sampleNameTypeadhead")
	private WebElement sampleNameTypeadhead;

	@FindAll({ @FindBy(xpath = "/html/body/section/div[2]/div[2]/div[4]/div/span/span") })
	public List<WebElement> sampleDropDown;

	@FindBy(how = How.ID, using = "sampleType")
	private WebElement sampleType;

	@FindBy(how = How.ID, using = "sampleDeleteBtn")
	private WebElement sampleDeleteBtn;

	@FindBy(how = How.ID, using = "editSampleFlag")
	private WebElement editSampleFlag;

	@FindAll({ @FindBy(xpath = "/html/body/section/div[2]/div[2]/div[11]/div/div/div[2]/div[4]/span/span") })
	public List<WebElement> editSampleDropDown;

	@FindBy(how = How.ID, using = "addSampleTypeToTest")
	private WebElement addSampleTypeToTest;

	@FindAll({ @FindBy(xpath = "/html/body/section/div[2]/div[2]/div[6]/span/span") })
	public List<WebElement> addSampleTypeDropDown;

	@FindBy(how = How.ID, using = "sampleTestBtn")
	private WebElement sampleTestBtn;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Cholesterol - Total')]")
	public WebElement cholesterolTotal;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sampleTestList\"]/button[3]")
	private WebElement removeTest;

	@FindBy(how = How.ID, using = "error")
	private WebElement error;

	@FindBy(how = How.ID, using = "optionLink")
	private WebElement optionLink;

	@FindBy(how = How.ID, using = "searchSampleAccessionInput")
	private WebElement searchSampleAccessionInput;

	@FindAll({ @FindBy(xpath = "/html/body/section/div[2]/div/div[4]/div[1]/div[1]/span/span") })
	public List<WebElement> sampleIdDropDown;

	@FindAll({ @FindBy(className = "userWaitingListCard") })
	public List<WebElement> getSamples;

	@FindBy(how = How.ID, using = "searchReferral")
	private WebElement searchReferral;

	@FindAll({ @FindBy(xpath = "/html/body/section/div[2]/div/div[4]/div[1]/div[2]/span/span") })
	public List<WebElement> referrelSearch;

	@FindBy(how = How.ID, using = "searchOrganisation")
	private WebElement searchOrganisation;

	@FindAll({ @FindBy(xpath = "/html/body/section/div[2]/div/div[4]/div[1]/div[3]/span/span") })
	public List<WebElement> organizationSearch;

	@FindBy(how = How.ID, using = "outsourceSampleFlag")
	private WebElement outsourceSampleFlag;

	@FindBy(how = How.ID, using = "createBatchBtn")
	private WebElement createBatchBtn;

	@FindBy(how = How.ID, using = "checkBox0")
	private WebElement checkBox0;

	@FindBy(how = How.ID, using = "checkBox1")
	private WebElement checkBox1;

	@FindBy(how = How.ID, using = "accBatchCreateBtn")
	private WebElement accBatchCreateBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"pendingBatchPill\"]/a")
	private WebElement batchManagement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sampleOfBatchAppendDiv\"]/div[4]/button")
	private WebElement closeFirstSample;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sampleOfBatchAppendDiv\"]/div[8]/button")
	private WebElement closeSecondSample;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sampleOfBatchAppendDiv\"]/div[1]/p")
	private WebElement idToClose;

	@FindBy(how = How.ID, using = "searchSamplePatient")
	private WebElement searchSamplePatient;

	@FindAll({ @FindBy(xpath = "/html/body/section/div[2]/div/div[18]/div/div/div[2]/div[1]/div[1]/span/span") })
	public List<WebElement> sampleIdSearchBox;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'222')]")
	public WebElement sampleId;

	@FindBy(how = How.ID, using = "selectAllSampleBatchFlag")
	private WebElement selectAllSampleBatchFlag;

	@FindBy(how = How.ID, using = "containerCnt0")
	private WebElement containerCnt0;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sampleCreateTotal\"]/small")
	private WebElement sampleTotal;

	@FindBy(how = How.XPATH, using = "//*[@id=\"vacutainerTotal\"]/small")
	private WebElement vacutainerTotal;

	@FindBy(how = How.ID, using = "accessionDateRange")
	private WebElement accessionDateRange;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'This Week')]")
	public WebElement thisWeek;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Last Week')]")
	public WebElement lastWeek;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Last Month')]")
	public WebElement lastMonth;

	@FindBy(how = How.ID, using = "checkBox2")
	private WebElement checkBox2;

	@FindBy(how = How.ID, using = "batchRefNumber")
	private WebElement batchRefNumber;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'View & Receive')]") })
	public List<WebElement> viewReceive;

	@FindAll({ @FindBy(className = "reportViewFontSize") })
	public List<WebElement> batchFrom;

	@FindBy(how = How.ID, using = "sampleBatchViewModalLabel")
	private WebElement sampleBatchViewModalLabel;

	@FindBy(how = How.LINK_TEXT, using = "Uncollect Sample")
	private WebElement uncollectSample;

	@FindBy(how = How.ID, using = "selectAllTestFlag")
	private WebElement selectAllTestFlag;

	@FindBy(how = How.ID, using = "sampleUncollectComments")
	private WebElement sampleUncollectComments;

	@FindBy(how = How.ID, using = "uncollectSampleBtn")
	private WebElement uncollectSampleBtn;

	@FindBy(how = How.LINK_TEXT, using = "Pending Accession")
	private WebElement pendingAccession;

	@FindBy(how = How.ID, using = "allSampleInBatchQueue")
	private WebElement allSampleInBatchQueue;

	@FindAll({ @FindBy(id = "rejectSample") })
	public List<WebElement> reject;

	@FindBy(how = How.ID, using = "accessBatchBtn")
	private WebElement accessBatchBtn;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'Accept')]") })
	public List<WebElement> accept;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div/div[2]/ul/li[3]/a")
	public WebElement received;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Checkreceive (M - 10)')]")
	public WebElement checkReceive;

	@FindAll({ @FindBy(linkText = "Options") })
	public List<WebElement> optionsLinkText;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'Receive & Print')]") })
	public List<WebElement> receivePrint;

	@FindAll({ @FindBy(css = "btn btn-danger btn-sm") })
	public List<WebElement> redrawList;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div/div[8]/div[1]/div[8]/li")
	public WebElement firstOption;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div/div[1]/div[2]/div/div[1]/div/button[2]")
	public WebElement worklistDropdown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"workListOpe\"]/div/ul/li[5]/a")
	public WebElement simpleWorklist;

	@FindBy(how = How.XPATH, using = "//*[@id=\"customTestNameDiv\"]/div[2]/div/div/button")
	public WebElement testNameList;

	@FindBy(how = How.ID, using = "testDropDownList")
	private WebElement testDropDownList;

	@FindBy(how = How.XPATH, using = "//*[@id=\"workListOpe\"]/div/ul/li[7]/a")
	public WebElement simpleWorklistWithoutAccNo;

	@FindBy(how = How.XPATH, using = "//*[@id=\"workListOpe\"]/div/ul/li[3]/a")
	public WebElement departmentwiseWorklist;

	@FindBy(how = How.XPATH, using = "//*[@id=\"workListOpe\"]/div/ul/li[1]/a")
	public WebElement testwiseWorklist;

	@FindBy(how = How.XPATH, using = "//input[@value='Yes'][@id='addSampleBtn']")
	public WebElement addSampleYesBtn;

	@FindBy(how = How.XPATH, using = "//input[@value='Done'][@id='addSampleBtn']")
	public WebElement addSampleDoneBtn;

	@FindBy(how = How.XPATH, using = "//input[@value='Edit'][@id='addSampleBtn']")
	public WebElement addSampleEditBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sampleTestList\"]/button[2]")
	public WebElement remove;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sampleTestList\"]/button[1]")
	public WebElement removeFirst;

	@FindBy(how = How.ID, using = "newSampleIdForTest0")
	private WebElement newSampleIdForTest0;

	@FindBy(how = How.XPATH, using = "//*[@id=\"sampleTestList\"]/div[4]/label")
	public WebElement ionicCalcium;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'IONIC CALCIUM')]")
	public WebElement ionicTest;

	@FindAll({ @FindBy(className = "sampleTypecardlabel") })
	public List<WebElement> addedTests;

	@FindBy(how = How.ID, using = "newSampleIdForAllTest")
	private WebElement newSampleIdForAllTest;

	//
	@Autowired
	BillingPage billing;

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
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
	}

	public boolean pendingAccessionList() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessionDateRange.click();
		thisWeek.click();
		boolean flag = false;

		List<WebElement> elements = DriverFactory.getDriver().findElements(By.id("pendingSampleList"));

		for (WebElement element : elements) {
			if (element.getText().length() > 0) {
				flag = true;
			} else {
				return false;
			}
		}

		return flag;

	}

	public boolean dismissSample() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		CommonMethods.waitForElementToVisible(accessionDateRange);

		js.executeScript("arguments[0].click();", accessionDateRange);
		js.executeScript("arguments[0].click();", lastMonth);

		CommonMethods.waitForElementToVisible(sampleList.get(0));
		String firstId = sampleList.get(0).getText();

		js.executeScript("arguments[0].click();", options.get(1));

		CommonMethods.waitForElementToVisible(dismissSample);
		js.executeScript("arguments[0].click();", dismissSample);
		rejectComments.sendKeys("reject");

		js.executeScript("arguments[0].click();", confirmedSampleRemoval);

		Thread.sleep(2000);

		CommonMethods.waitForElementToVisible(accessionDateRange);

		js.executeScript("arguments[0].click();", accessionDateRange);
		js.executeScript("arguments[0].click();", lastMonth);

		Thread.sleep(2000);
		CommonMethods.waitForElementToVisible(sampleList.get(0));

		String sampleId = sampleList.get(0).getText();

		if (!firstId.equals(sampleId)) {
			return true;
		}
		return false;

	}

	public String dismissSampleConfirmation() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.ACCESSION_URL);

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		CommonMethods.waitForElementToVisible(accessionDateRange);

		js.executeScript("arguments[0].click();", accessionDateRange);
		js.executeScript("arguments[0].click();", lastMonth);

		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(options.get(1));
		CommonMethods.waitForElementToClickable(options.get(1));
		options.get(1).click();

		CommonMethods.waitForElementToVisible(dismissSample);
		dismissSample.click();
		rejectComments.sendKeys("reject");

		String confirm = myModalLabel.getText().trim();

		driver.navigate().refresh();

		return confirm;

	}

	public void searchToBilling(String userInfo) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.Billing_URL);

		CommonMethods.waitForElementToVisible(searchUserForBilling);
		searchUserForBilling.sendKeys(userInfo);

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[3]/div[2]/div/div[1]/span/span")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[3]/div[2]/div/div[1]/span/span"));

		dropDowns.get(0).click();
	}

	public void selectTestName(String testName) throws Exception {

		testList.sendKeys(testName);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span"));

		dropDowns.get(0).click();

		concession.sendKeys(Keys.ENTER);
		CommonMethods.waitForElementToVisible(saveBill);
		saveBill.click();
	}

	public void createBillForAccession(String userName) throws Exception {

		searchToBilling(userName);
		selectTestName("CPK, Total");

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.ACCESSION_URL);

	}

	public String receiveSample(String userName) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		createBillForAccession(userName);

		CommonMethods.waitForElementToVisible(receive.get(0));
		js.executeScript("arguments[0].click();", receive.get(0));

		js.executeScript("arguments[0].click();", accessed);

		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToVisible(accessionDateRange);
		CommonMethods.waitForElementToVisible(optionsLinkText.get(0));
		CommonMethods.waitForElementToVisible(sampleList.get(1));

		if (sampleList.get(1).isDisplayed()) {

			// CommonMethods.waitForElementToVisible(options.get(4));
			// js.executeScript("arguments[0].click();", options.get(4));
			//
			// CommonMethods.waitForElementToVisible(dismissSample);
			// js.executeScript("arguments[0].click();", dismissSample);
			//
			// rejectComments.sendKeys("reject");
			//
			// js.executeScript("arguments[0].click();", confirmedSampleRemoval);

			return sampleList.get(1).getText().trim();
		}

		return null;

	}

	public int testsNameListInSimpleWorkList() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.ACCESSION_URL);

		CommonMethods.waitForElementToVisible(worklistDropdown);
		js.executeScript("arguments[0].click();", worklistDropdown);

		CommonMethods.waitForElementToVisible(simpleWorklist);
		js.executeScript("arguments[0].click();", simpleWorklist);

		CommonMethods.waitForElementToVisible(testNameList);
		js.executeScript("arguments[0].click();", testNameList);

		CommonMethods.waitForElementToVisible(testDropDownList);
		List<WebElement> elements = testDropDownList.findElements(By.tagName("li"));

		return elements.size();

	}

	public int testsNameListInSimpleWorkListWithoutAccNo() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.ACCESSION_URL);

		CommonMethods.waitForElementToVisible(worklistDropdown);
		js.executeScript("arguments[0].click();", worklistDropdown);

		CommonMethods.waitForElementToVisible(simpleWorklistWithoutAccNo);
		js.executeScript("arguments[0].click();", simpleWorklistWithoutAccNo);

		CommonMethods.waitForElementToVisible(testNameList);
		js.executeScript("arguments[0].click();", testNameList);

		CommonMethods.waitForElementToVisible(testDropDownList);
		List<WebElement> elements = testDropDownList.findElements(By.tagName("li"));

		return elements.size();

	}

	public String receiveAndPrint() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// createBillForAccession();

		CommonMethods.waitForElementToVisible(receivePrint.get(0));
		js.executeScript("arguments[0].click();", receivePrint.get(0));

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(accessed);
		js.executeScript("arguments[0].click();", accessed);

		driver.navigate().refresh();
		CommonMethods.waitForElementToVisible(accessionDateRange);
		CommonMethods.waitForElementToVisible(optionsLinkText.get(0));
		CommonMethods.waitForElementToVisible(sampleList.get(1));

		if (sampleList.get(1).isDisplayed()) {

			return sampleList.get(1).getText().trim();
		}

		return null;

	}

	public List<String> accessedSampleListAbleToShowOnlyAccessedList(String userName) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		String accessedUser = receiveSample(userName);

		CommonMethods.waitForElementToVisible(redraw);
		js.executeScript("arguments[0].click();", redraw);

		CommonMethods.waitForElementToVisible(pendingAccession);
		js.executeScript("arguments[0].click();", pendingAccession);

		DriverFactory.getDriver().navigate().refresh();
		;
		CommonMethods.waitForElementToVisible(sampleList.get(1));
		CommonMethods.waitForElementToVisible(options.get(1));

		String userVerify = sampleList.get(1).getText();

		return Arrays.asList(accessedUser, userVerify);
	}

	public boolean accessionNumOnAccessedSample() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessed.click();

		int size = (sampleList.size() / 2);

		int size2 = collectedSample.size();

		if (size == size2) {
			DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
			return true;
		}

		return false;

	}

	public String redrawSample(String userName) throws Exception {

		// accessionDateRange.click();
		// lastWeek.click();
		// receive.get(0).click();
		// receiveSample(userName);

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessed.click();
		accessionDateRange.click();
		lastWeek.click();

		CommonMethods.waitForElementToVisible(redraw);
		redraw.click();
		CommonMethods.waitForElementToVisible(redrawComments);
		redrawComments.sendKeys("redraw");

		redrawCommentBtn.click();

		DriverFactory.getDriver().navigate().refresh();

		CommonMethods.waitForElementToVisible(sampleRedrawn.get(0));
		String var = sampleRedrawn.get(0).getText();

		return var;

	}

	public String redrawSampleConfirmation(String userName) throws Exception {

		// receiveSample(userName);

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.ACCESSION_URL);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", accessed);

		js.executeScript("arguments[0].click();", accessionDateRange);
		js.executeScript("arguments[0].click();", lastWeek);

		js.executeScript("arguments[0].click();", redraw);
		redrawComments.sendKeys("redraw");

		String var = redrawCommentModalLabel.getText();

		driver.navigate().to(Constants.ACCESSION_URL);

		return var;

	}

	public boolean uncollectSample() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.ACCESSION_URL);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", accessed);

		CommonMethods.waitForElementToVisible(accessionDateRange);

		CommonMethods.waitForElementToVisible(sampleList.get(0));
		String id = sampleList.get(0).getText();

		System.out.println("@" + id);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", options.get(2));
		// js.executeScript("arguments[0].click();", firstOption);
		// js.executeScript("arguments[0].click();", firstOption);

		CommonMethods.waitForElementToVisible(uncollectSample);

		js.executeScript("arguments[0].click();", uncollectSample);

		CommonMethods.waitForElementToVisible(selectAllTestFlag);
		selectAllTestFlag.click();

		sampleUncollectComments.sendKeys("uncollect");

		js.executeScript("arguments[0].click();", uncollectSampleBtn);

		driver.navigate().refresh();
		CommonMethods.waitForElementToVisible(sampleList.get(0));

		String uncollectedId = sampleList.get(0).getText();
		System.out.println("@" + uncollectedId);

		if (!id.equals(uncollectedId)) {

			return true;
		}
		return false;

	}

	public int testsNameListInDepartmentWiseWorkList() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.ACCESSION_URL);

		CommonMethods.waitForElementToVisible(accessed);
		js.executeScript("arguments[0].click();", accessed);

		CommonMethods.waitForElementToVisible(worklistDropdown);
		js.executeScript("arguments[0].click();", worklistDropdown);

		CommonMethods.waitForElementToVisible(departmentwiseWorklist);
		js.executeScript("arguments[0].click();", departmentwiseWorklist);

		CommonMethods.waitForElementToVisible(testNameList);
		js.executeScript("arguments[0].click();", testNameList);

		CommonMethods.waitForElementToVisible(testDropDownList);
		List<WebElement> elements = testDropDownList.findElements(By.tagName("li"));

		return elements.size();

	}

	public int testsNameListInTestwiseWorkList() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.ACCESSION_URL);

		CommonMethods.waitForElementToVisible(accessed);
		js.executeScript("arguments[0].click();", accessed);

		CommonMethods.waitForElementToVisible(worklistDropdown);
		js.executeScript("arguments[0].click();", worklistDropdown);

		CommonMethods.waitForElementToVisible(testwiseWorklist);
		js.executeScript("arguments[0].click();", testwiseWorklist);

		CommonMethods.waitForElementToVisible(testNameList);
		js.executeScript("arguments[0].click();", testNameList);

		CommonMethods.waitForElementToVisible(testDropDownList);
		List<WebElement> elements = testDropDownList.findElements(By.tagName("li"));

		return elements.size();

	}

	public int testsNameListInSimpleWorkList_Accessed() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.ACCESSION_URL);

		CommonMethods.waitForElementToVisible(accessed);
		js.executeScript("arguments[0].click();", accessed);

		CommonMethods.waitForElementToVisible(worklistDropdown);
		js.executeScript("arguments[0].click();", worklistDropdown);

		CommonMethods.waitForElementToVisible(simpleWorklist);
		js.executeScript("arguments[0].click();", simpleWorklist);

		CommonMethods.waitForElementToVisible(testNameList);
		js.executeScript("arguments[0].click();", testNameList);

		CommonMethods.waitForElementToVisible(testDropDownList);
		List<WebElement> elements = testDropDownList.findElements(By.tagName("li"));

		return elements.size();

	}

	public int testsNameInSimpleWorkListWithoutAccNo_Accessed() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.ACCESSION_URL);

		CommonMethods.waitForElementToVisible(accessed);
		js.executeScript("arguments[0].click();", accessed);

		CommonMethods.waitForElementToVisible(worklistDropdown);
		js.executeScript("arguments[0].click();", worklistDropdown);

		CommonMethods.waitForElementToVisible(simpleWorklistWithoutAccNo);
		js.executeScript("arguments[0].click();", simpleWorklistWithoutAccNo);

		CommonMethods.waitForElementToVisible(testNameList);
		js.executeScript("arguments[0].click();", testNameList);

		CommonMethods.waitForElementToVisible(testDropDownList);
		List<WebElement> elements = testDropDownList.findElements(By.tagName("li"));

		return elements.size();

	}

	public String addEditAccessionType() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessionSettings.click();
		addEdit.click();

		CommonMethods.waitForElementToVisible(sampleTypeName);
		if (sampleTypeName.isDisplayed() && typeOfSample.isDisplayed()) {

			String text = addNewSampleTypeModalLabel.getText();
			DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

			return text;
		}

		return null;

	}

	public void addNewSample(String sampleName) throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		CommonMethods.waitForElementToVisible(accessionSettings);
		accessionSettings.click();

		CommonMethods.waitForElementToVisible(addEdit);
		addEdit.click();

		CommonMethods.waitForElementToVisible(sampleTypeName);
		sampleTypeName.sendKeys(sampleName);
		typeOfSample.sendKeys("typeOfSample");

		js.executeScript("arguments[0].click();", addSampleBtn);

		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(sampleNameTypeadhead);
		sampleNameTypeadhead.sendKeys(sampleName);

		CommonMethods.waitForElementToVisible(sampleDropDown.get(0));
		sampleDropDown.get(0).click();

	}

	public String deleteSample(String sampleName) throws Exception {

		addNewSample(sampleName);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		String text = sampleType.getText();

		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(sampleDeleteBtn);
		CommonMethods.waitForElementToClickable(sampleDeleteBtn);
		js.executeScript("arguments[0].click();", sampleDeleteBtn);

		CommonMethods.waitForElementToVisible(addSampleYesBtn);
		js.executeScript("arguments[0].click();", addSampleYesBtn);

		return text;

	}

	public List<String> editSample(String typeSample) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.ACCESSION_URL);

		CommonMethods.waitForElementToVisible(accessionSettings);
		accessionSettings.click();

		editSampleType(js);

		CommonMethods.waitForElementToVisible(typeOfSample);
		typeOfSample.clear();
		typeOfSample.sendKeys(typeSample);

		CommonMethods.waitForElementToVisible(addSampleEditBtn);
		addSampleEditBtn.click();

		driver.navigate().refresh();
		editSampleType(js);

		CommonMethods.waitForElementToVisible(typeOfSample);
		String text = typeOfSample.getAttribute("value");

		return Arrays.asList(text, typeSample);

	}

	private void editSampleType(JavascriptExecutor js) throws Exception {

		CommonMethods.waitForElementToVisible(addEdit);
		js.executeScript("arguments[0].click();", addEdit);

		CommonMethods.waitForElementToVisible(editSampleFlag);
		js.executeScript("arguments[0].click();", editSampleFlag);

		CommonMethods.waitForElementToVisible(sampleTypeName);
		sampleTypeName.sendKeys("sample");

		CommonMethods.waitForElementToVisible(editSampleDropDown.get(0));
		editSampleDropDown.get(0).click();

	}

	public String searchSampleType() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessionSettings.click();

		CommonMethods.waitForElementToVisible(sampleNameTypeadhead);

		sampleNameTypeadhead.sendKeys("Ascitic Fluid");

		CommonMethods.waitForElementToVisible(sampleDropDown.get(0));

		sampleDropDown.get(0).click();

		String text = sampleType.getText();

		return text;

	}

	public String mappingTestAddForSelectedSample() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		accessionSettings.click();

		selectingSample();

		addSampleTypeToTest.sendKeys("Cholesterol - Total");

		CommonMethods.waitForElementToVisible(addSampleTypeDropDown.get(0));
		addSampleTypeDropDown.get(0).click();

		sampleTestBtn.click();

		selectingSample();

		String testName = cholesterolTotal.getText();

		removeTest.click();

		sampleTestBtn.click();

		js.executeScript("arguments[0].click();", addSampleBtn);

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

		return testName;

	}

	private void selectingSample() throws Exception {

		CommonMethods.waitForElementToVisible(sampleNameTypeadhead);

		sampleNameTypeadhead.sendKeys("Water");

		CommonMethods.waitForElementToVisible(sampleDropDown.get(0));

		sampleDropDown.get(0).click();
	}

	public String alreadyAddedTestNotAbleToAdd() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessionSettings.click();
		selectingSample();

		addSampleTypeToTest.sendKeys("Water Culture *");

		CommonMethods.waitForElementToVisible(addSampleTypeDropDown.get(0));
		addSampleTypeDropDown.get(0).click();

		String errorMsg = error.getText();

		return errorMsg;

	}

	public void removeSymbol() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.ACCESSION_URL);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		CommonMethods.waitForElementToVisible(accessionSettings);
		js.executeScript("arguments[0].click();", accessionSettings);

		CommonMethods.waitForElementToVisible(sampleNameTypeadhead);
		sampleNameTypeadhead.sendKeys("sample");

		CommonMethods.waitForElementToVisible(sampleDropDown.get(0));
		sampleDropDown.get(0).click();

		addSampleTypeToTest.sendKeys("IONIC CALCIUM");

		CommonMethods.waitForElementToVisible(addSampleTypeDropDown.get(0));
		addSampleTypeDropDown.get(0).click();

		CommonMethods.waitForElementToVisible(remove);
		js.executeScript("arguments[0].click();", remove);

		js.executeScript("arguments[0].click();", sampleTestBtn);

		CommonMethods.waitForElementToVisible(newSampleIdForTest0);
	}

	public String removedTestsAssignedToSelectedSample() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		removeSymbol();
		Select select = new Select(newSampleIdForTest0);
		select.selectByVisibleText("bajaj");

		js.executeScript("arguments[0].click();", addSampleDoneBtn);

		driver.navigate().refresh();
		CommonMethods.waitForElementToVisible(sampleNameTypeadhead);
		sampleNameTypeadhead.sendKeys("bajaj");

		CommonMethods.waitForElementToVisible(sampleDropDown.get(0));
		sampleDropDown.get(0).click();

		CommonMethods.waitForElementToVisible(ionicCalcium);
		String ionic = ionicCalcium.getText().trim();
		js.executeScript("arguments[0].click();", removeFirst);
		js.executeScript("arguments[0].click();", sampleTestBtn);
		js.executeScript("arguments[0].click();", addSampleDoneBtn);

		return ionic;
	}

	public String removedTestsAssignedToDefaultNoneSample() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		removeSymbol();
		Select select = new Select(newSampleIdForTest0);
		WebElement element = select.getFirstSelectedOption();

		js.executeScript("arguments[0].click();", addSampleDoneBtn);

		return element.getText().trim();
	}

	public List<String> deleteSampleAssignTestToSelectedSample(String sampleName) throws Exception {

		addNewSample(sampleName);

		String[] tNames = { "IONIC CALCIUM", "CPK, Total" };

		for (int index = 0; index < tNames.length; index++) {
			addSampleTypeToTest.sendKeys(tNames[index]);

			CommonMethods.waitForElementToVisible(addSampleTypeDropDown.get(0));
			addSampleTypeDropDown.get(0).click();
		}

		CommonMethods.waitForElementToVisible(sampleTestBtn);
		CommonMethods.waitForElementToClickable(sampleTestBtn);
		sampleTestBtn.click();

		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToVisible(sampleNameTypeadhead);
		sampleNameTypeadhead.sendKeys(sampleName);

		CommonMethods.waitForElementToVisible(sampleDropDown.get(0));
		sampleDropDown.get(0).click();

		CommonMethods.waitForElementToVisible(sampleDeleteBtn);
		CommonMethods.waitForElementToClickable(sampleDeleteBtn);
		sampleDeleteBtn.click();

		CommonMethods.waitForElementToVisible(newSampleIdForAllTest);
		Select select = new Select(newSampleIdForAllTest);
		select.selectByVisibleText("tosample");

		addSampleYesBtn.click();

		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToVisible(sampleNameTypeadhead);
		sampleNameTypeadhead.sendKeys("tosample");

		CommonMethods.waitForElementToVisible(sampleDropDown.get(0));
		sampleDropDown.get(0).click();

		CommonMethods.waitForElementToVisible(addedTests.get(3));
		String firstTest = addedTests.get(3).getText();
		String secondTest = addedTests.get(5).getText();

		removeFirst.click();
		removeFirst.click();

		sampleTestBtn.click();
		CommonMethods.waitForElementToVisible(addSampleDoneBtn);
		addSampleDoneBtn.click();

		return Arrays.asList(firstTest, secondTest);
	}

	public String deleteSampleAssignTestToDefaultNone(String sampleName) throws Exception {

		addNewSample(sampleName);

		String[] tNames = { "IONIC CALCIUM", "CPK, Total" };

		for (int index = 0; index < tNames.length; index++) {
			addSampleTypeToTest.sendKeys(tNames[index]);

			CommonMethods.waitForElementToVisible(addSampleTypeDropDown.get(0));
			addSampleTypeDropDown.get(0).click();
		}

		CommonMethods.waitForElementToVisible(sampleTestBtn);
		CommonMethods.waitForElementToClickable(sampleTestBtn);
		sampleTestBtn.click();

		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToVisible(sampleNameTypeadhead);
		sampleNameTypeadhead.sendKeys(sampleName);

		CommonMethods.waitForElementToVisible(sampleDropDown.get(0));
		sampleDropDown.get(0).click();

		CommonMethods.waitForElementToVisible(sampleDeleteBtn);
		CommonMethods.waitForElementToClickable(sampleDeleteBtn);
		sampleDeleteBtn.click();

		CommonMethods.waitForElementToVisible(newSampleIdForAllTest);
		Select select = new Select(newSampleIdForAllTest);
		WebElement element = select.getFirstSelectedOption();

		addSampleYesBtn.click();

		return element.getText();
	}

	public List<String> sampleTypeShouldShowAssignedTests(String sampleName) throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.ACCESSION_URL);

		CommonMethods.waitForElementToVisible(accessionSettings);
		accessionSettings.click();

		CommonMethods.waitForElementToVisible(sampleNameTypeadhead);
		sampleNameTypeadhead.sendKeys(sampleName);

		CommonMethods.waitForElementToVisible(sampleDropDown.get(0));
		sampleDropDown.get(0).click();

		CommonMethods.waitForElementToVisible(addedTests.get(3));
		String firstTest = addedTests.get(3).getText();
		String secondTest = addedTests.get(5).getText();

		return Arrays.asList(firstTest, secondTest);
	}

	public List<String> sampleSearchAbleToSelectSample() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		String sampleId = sampleList.get(0).getText();

		optionLink.click();

		searchSampleAccessionInput.sendKeys(sampleId);

		CommonMethods.waitForElementToVisible(sampleIdDropDown.get(0));

		sampleIdDropDown.get(0).click();

		String searchedId = sampleList.get(0).getText();

		return Arrays.asList(sampleId, searchedId);

	}

	public List<String> searchByUserName() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessionDateRange.click();
		thisWeek.click();
		String sample = sampleList.get(1).getText();

		String userName = sample.substring(0, (sample.length() - 8));

		optionLink.click();

		searchSampleAccessionInput.sendKeys(userName);

		CommonMethods.waitForElementToVisible(sampleIdDropDown.get(0));

		sampleIdDropDown.get(0).click();

		String searchedSample = sampleList.get(1).getText();

		String searchedUser = searchedSample.substring(0, (sample.length() - 8));

		return Arrays.asList(userName, searchedUser);

	}

	public boolean searchByReferrel() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessionDateRange.click();
		thisWeek.click();
		optionLink.click();

		searchReferral.sendKeys("self");

		CommonMethods.waitForElementToVisible(referrelSearch.get(0));

		referrelSearch.get(0).click();

		CommonMethods.waitForElementToVisible(getSamples.get(0));

		if (getSamples.size() > 0) {

			return true;
		}

		return false;
	}

	public boolean searchByOrganization() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessionDateRange.click();
		thisWeek.click();
		optionLink.click();

		searchOrganisation.sendKeys("DIRECT");

		CommonMethods.waitForElementToVisible(organizationSearch.get(0));

		organizationSearch.get(0).click();

		CommonMethods.waitForElementToVisible(getSamples.get(0));

		if (getSamples.size() > 0) {

			return true;
		}

		return false;
	}

	public List<String> outsourcedOnlySamples() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		// optionLink.click();

		List<WebElement> list = new ArrayList<>();

		// Select select = new Select(outsourceSampleFlag);
		// select.selectByValue("1");

		Thread.sleep(3000);
		// CommonMethods.waitForElementToVisible(getSamples.get(0));
		System.out.println("==" + getSamples.get(0).toString());
		System.out.println("==" + getSamples.get(1).toString());
		System.out.println("==" + getSamples.get(2).toString());

		for (int index = 1; index <= getSamples.size(); index++) {

			WebDriver driver = DriverFactory.getDriver();

			WebElement element = driver.findElement(
					By.xpath("/html/body/section/div[2]/div/div[7]/div[" + index + "]/div[5]/span/div/div"));

			list.add(element);
			System.out.println("==" + list.get(index).toString());
		}

		// System.out.println("=="+list.toString());
		return null;

	}

	public List<String> createBatch() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		driver.navigate().to(Constants.ACCESSION_URL);
		accessionDateRange.click();
		lastWeek.click();
		createBatchBtn.click();

		checkBox0.click();
		checkBox1.click();
		checkBox2.click();

		createBatchBtn.click();

		String refNum = batchRefNumber.getText();
		System.out.println("==1==" + refNum);
		Thread.sleep(5000);
		accBatchCreateBtn.click();
		Thread.sleep(5000);

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.close();
		driver.switchTo().window(tabs2.get(0));

		Thread.sleep(5000);
		batchManagement.click();

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + refNum + "')]"));
		System.out.println("==2==" + element.getText());

		return Arrays.asList(refNum, element.getText());
	}

	public List<Integer> addAllPending() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		accessionDateRange.click();
		lastWeek.click();
		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(sampleList.get(0));
		int size = (sampleList.size() / 2);

		js.executeScript("arguments[0].click();", createBatchBtn);

		checkBox0.click();
		checkBox1.click();

		createBatchBtn.click();
		CommonMethods.waitForElementToVisible(allSampleInBatchQueue);
		allSampleInBatchQueue.click();

		int totalSample = Integer.parseInt(containerCnt0.getAttribute("value"));

		return Arrays.asList(size, totalSample);

	}

	public boolean removeSampleFromBatch() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessionDateRange.click();
		thisWeek.click();
		createBatchBtn.click();

		checkBox0.click();
		checkBox1.click();

		createBatchBtn.click();

		String id1 = idToClose.getText();

		CommonMethods.waitForElementToVisible(closeFirstSample);
		closeFirstSample.click();

		String id2 = idToClose.getText();

		if (id1.equals(id2)) {
			DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
			return false;
		}
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		return true;

	}

	public String searchSample() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessionDateRange.click();
		thisWeek.click();
		createBatchBtn.click();

		checkBox0.click();
		checkBox1.click();

		createBatchBtn.click();

		CommonMethods.waitForElementToVisible(searchSamplePatient);
		searchSamplePatient.sendKeys("222");

		CommonMethods.waitForElementToVisible(sampleIdSearchBox.get(0));
		sampleIdSearchBox.get(0).click();

		String text = sampleId.getText();

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		return text;

	}

	public String batchCanNotEmpty() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		accessionDateRange.click();
		thisWeek.click();
		createBatchBtn.click();

		checkBox0.click();
		checkBox1.click();

		createBatchBtn.click();

		CommonMethods.waitForElementToVisible(closeFirstSample);
		closeFirstSample.click();
		searchSamplePatient.clear();
		closeFirstSample.click();

		CommonMethods.waitForElementToVisible(error);
		String errorMsg = error.getText();

		return errorMsg;

	}

	public List<Integer> vacutainerSummery() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

		// accessionDateRange.click();
		// thisWeek.click();

		int size = (sampleList.size() / 2);

		createBatchBtn.click();

		CommonMethods.waitForElementToVisible(selectAllSampleBatchFlag);
		selectAllSampleBatchFlag.click();
		createBatchBtn.click();

		int totalSample = Integer.parseInt(containerCnt0.getAttribute("value"));

		return Arrays.asList(size, totalSample);

	}

	public List<Integer> sampleTotal() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

		// accessionDateRange.click();
		// thisWeek.click();

		int size = (sampleList.size() / 2);

		createBatchBtn.click();

		CommonMethods.waitForElementToVisible(selectAllSampleBatchFlag);
		selectAllSampleBatchFlag.click();
		createBatchBtn.click();

		CommonMethods.waitForElementToVisible(sampleTotal);
		int totalSample = Integer.parseInt(sampleTotal.getText());

		return Arrays.asList(size, totalSample);

	}

	public List<Integer> vacutainerTotal() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

		// accessionDateRange.click();
		// thisWeek.click();

		int size = (sampleList.size() / 2);

		createBatchBtn.click();

		CommonMethods.waitForElementToVisible(selectAllSampleBatchFlag);
		selectAllSampleBatchFlag.click();
		createBatchBtn.click();

		CommonMethods.waitForElementToVisible(vacutainerTotal);
		int totalSample = Integer.parseInt(vacutainerTotal.getText());

		return Arrays.asList(size, totalSample);

	}

	public String viewAndReceiveButton() throws Exception {

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		batchManagement.click();

		accessionDateRange.click();
		lastWeek.click();

		String refNum = sampleList.get(0).getText().trim();

		System.out.println("==1==" + refNum);

		viewReceive.get(0).click();

		CommonMethods.waitForElementToVisible(batchFrom.get(2));

		String text = sampleBatchViewModalLabel.getText().trim();

		StringTokenizer st = new StringTokenizer(text, " ");

		while (st.hasMoreTokens()) {
			System.out.println("==token=" + st.nextToken());
			if (refNum.equals(st.nextToken())) {

				System.out.println("==3==" + batchFrom.get(2).getText());
				return batchFrom.get(2).getText();
			}
		}

		return null;

	}

	public boolean rejectLinkInViewAndReceive() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		batchManagement.click();

		CommonMethods.waitForElementToVisible(accessionDateRange);
		// accessionDateRange.click();
		// lastWeek.click();

		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(sampleList.get(0));
		String id1 = sampleList.get(0).getText();

		viewReceive.get(0).click();

		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(reject.get(0));

		for (int index = 0; index < reject.size(); index++) {

			js.executeScript("arguments[0].click();", reject.get(index));
		}

		Thread.sleep(1000);
		// accessBatchBtn.click();
		js.executeScript("arguments[0].click();", accessBatchBtn);

		Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(sampleList.get(0));
		String id2 = sampleList.get(0).getText();

		if (!id1.equals(id2)) {

			return true;
		}
		return false;

	}

	public List<String> acceptLinkInViewAndReceive() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to(Constants.ACCESSION_URL);
		batchManagement.click();

		CommonMethods.waitForElementToVisible(accessionDateRange);
		// accessionDateRange.click();
		// lastWeek.click();

		// Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(sampleList.get(0));
		String id1 = sampleList.get(0).getText();

		viewReceive.get(0).click();

		// Thread.sleep(1000);
		CommonMethods.waitForElementToVisible(accept.get(0));

		for (int index = 0; index < accept.size(); index++) {

			js.executeScript("arguments[0].click();", accept.get(index));
		}

		// Thread.sleep(1000);
		// accessBatchBtn.click();
		js.executeScript("arguments[0].click();", accessBatchBtn);

		CommonMethods.waitForElementToVisible(received);
		CommonMethods.waitForElementToClickable(received);
		js.executeScript("arguments[0].click();", received);

		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + id1 + "')]"));

		String text = element.getText();

		return Arrays.asList(text, id1);

	}
}
