package com.livehealth.pageobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livehealth.base.DriverFactory;
import com.livehealth.config.ConfigProperties;
import com.livehealth.model.HomeCollection;
import com.livehealth.model.User;
import com.livehealth.util.CommonMethods;
import com.livehealth.util.WebContext;

@Component
public class BillingPage {

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

	@FindBy(how = How.ID, using = "billUrl")
	private WebElement billUrl;

	@FindBy(how = How.ID, using = "searchInputforTests")
	private WebElement testList;

	@FindBy(how = How.ID, using = "searchPatient")
	private WebElement searchUserForBilling;

	@FindBy(how = How.ID, using = "userRegistrationNo")
	private WebElement userRegistrationNo;

	@FindBy(how = How.ID, using = "concession")
	private WebElement concession;

	@FindBy(how = How.XPATH, using = "(//button[@onclick=\"showTestCalculate();\"])[4]")
	private WebElement calculatorBtn;

	@FindBy(how = How.ID, using = "searchInputforOnlyTests")
	private WebElement searchInputforOnlyTests;

	@FindBy(how = How.XPATH, using = "/html/body/div[18]/div/div/div[2]/div[6]/span/span")
	private WebElement addTestSeacch;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"col-md-3 col-sm-3 col-xs-3\"])[2]")
	private WebElement test_1;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"col-md-3 col-sm-3 col-xs-3\"])[3]")
	private WebElement test_2;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"col-md-3 col-sm-3 col-xs-3\"])[4]")
	private WebElement test_3;

	@FindBy(how = How.XPATH, using = "//div[@testindex=\"0\"]")
	private WebElement testIndex_0;

	@FindBy(how = How.XPATH, using = "//div[@testindex=\"1\"]")
	private WebElement testIndex_1;

	@FindBy(how = How.XPATH, using = "//div[@testindex=\"2\"]")
	private WebElement testIndex_2;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[4]/div[1]/div[8]/div[1]/div[2]/p")
	private WebElement firstTestprice;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[4]/div[1]/div[8]/div[2]/div[2]/p")
	private WebElement seconfTestprice;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[4]/div[1]/div[8]/div[3]/div[2]/p")
	private WebElement thirdTestprice;

	@FindBy(how = How.ID, using = "balanceAmount")
	private WebElement balanceAmount;

	@FindBy(how = How.ID, using = "totalAmount")
	private WebElement payableAmount;

	@FindBy(how = How.ID, using = "totalConcessionType")
	private WebElement concessionType;

	@FindBy(how = How.ID, using = "totalConcessionAmt")
	private WebElement totalConcessionAmt;

	@FindBy(how = How.XPATH, using = "(//button[@class=\"close\"])[1]")
	private WebElement closeTestBtn;

	@FindBy(how = How.ID, using = "companyList")
	private WebElement companyList;

	@FindBy(how = How.ID, using = "calculateTotalAmount")
	private WebElement totalAmt;

	@FindBy(how = How.XPATH, using = "//*[@id=\"otherInfo\"]/div[1]/span/i")
	private WebElement otherInfo;

	@FindBy(how = How.ID, using = "addOrganization")
	private WebElement addOrganization;

	@FindBy(how = How.ID, using = "orgnName")
	private WebElement orgnName;

	@FindBy(how = How.ID, using = "addOrgButton")
	private WebElement addOrgButton;

	@FindBy(how = How.XPATH, using = "(//p[@class=\"billingTestList billingListPadding\"])[2]")
	private WebElement firstTestAmt;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userAmntDivId\"]/div[2]/b")
	private WebElement userAmntDivId;

	@FindBy(how = How.ID, using = "paymentMode")
	private WebElement paymentMode;

	@FindBy(how = How.XPATH, using = "//*[@id=\"errorDiv\"]/div")
	private WebElement errorDiv;

	@FindBy(how = How.XPATH, using = "circleLoader3")
	private WebElement circleLoader;

	@FindBy(how = How.ID, using = "referralList")
	private WebElement referralList;

	@FindBy(how = How.XPATH, using = "//*[@id=\"inputT\"]/span/span/div[1]")
	private WebElement testDropDown;

	@FindBy(how = How.LINK_TEXT, using = "Admin")
	private WebElement admin;

	@FindBy(how = How.LINK_TEXT, using = "List & Group Management")
	private WebElement listManagement;

	@FindBy(how = How.ID, using = "listName")
	private WebElement listName;

	@FindBy(how = How.ID, using = "textInput12012")
	private WebElement test1;

	@FindBy(how = How.ID, using = "textInput11937")
	private WebElement test2;

	@FindBy(how = How.ID, using = "textInput12493")
	private WebElement test3;

	@FindBy(how = How.ID, using = "textInput12530")
	private WebElement orgTest1;

	@FindBy(how = How.ID, using = "textInput11953")
	private WebElement orgTest2;

	@FindBy(how = How.ID, using = "textInput12493")
	private WebElement orgTest3;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[4]/div[1]/div[8]/div/div[1]/p")
	private WebElement tName;

	@FindBy(how = How.LINK_TEXT, using = "Profile & Report Management")
	private WebElement profileManagement;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editTest12097\"]/div[3]")
	private WebElement tPrice1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editTest12107\"]/div[3]")
	private WebElement tPrice2;

	@FindBy(how = How.XPATH, using = "//*[@id=\"editTest12151\"]/div[3]")
	private WebElement tPrice3;

	@FindBy(how = How.ID, using = "registerUrl")
	private WebElement registerUrl;

	@FindBy(how = How.ID, using = "newDirectPatientSelectBtn")
	private WebElement searchBtn;

	@FindBy(how = How.ID, using = "searchNewDirectPatient")
	private WebElement searchUser;

	@FindBy(how = How.ID, using = "newDirectOrganization")
	private WebElement newDirectOrganization;

	@FindBy(how = How.LINK_TEXT, using = "Billing")
	private WebElement billing;

	@FindBy(how = How.ID, using = "currentOrganization")
	private WebElement currentOrganization;

	@FindBy(how = How.ID, using = "orgnEmail")
	private WebElement orgnEmail;

	@FindBy(how = How.ID, using = "billOrg")
	private WebElement billOrg;

	@FindBy(how = How.LINK_TEXT, using = "Organization Management")
	private WebElement organizationManagement;

	@FindBy(how = How.LINK_TEXT, using = "Add / Edit Organization")
	private WebElement addEditOrganization;

	@FindBy(how = How.ID, using = "editOrgTab")
	private WebElement editOrgTab;

	@FindBy(how = How.ID, using = "orgEditList")
	private WebElement orgEditList;

	@FindBy(how = How.ID, using = "orgDeleteButton")
	private WebElement orgDeleteButton;

	@FindBy(how = How.ID, using = "orgDelete")
	private WebElement orgDelete;

	@FindBy(how = How.ID, using = "billCompany")
	private WebElement billCompany;

	@FindBy(how = How.ID, using = "service")
	private WebElement service;

	@FindBy(how = How.XPATH, using = "//a[@id=\"addPayment\"]")
	private WebElement addPayment;

	@FindBy(how = How.ID, using = "paymentType_1")
	private WebElement paymentType_1;

	@FindBy(how = How.ID, using = "paymentAmount_1")
	private WebElement paymentAmount_1;

	@FindBy(how = How.XPATH, using = "(//button[@id=\"savebillSetting\"])[2]")
	private WebElement savebillSetting;

	@FindBy(how = How.ID, using = "AdvanceAmount")
	private WebElement advanceAmount;

	@FindBy(how = How.ID, using = "chequeNo_1")
	private WebElement chequeNo_1;

	@FindBy(how = How.ID, using = "issueBankName_1")
	private WebElement issueBankName_1;

	@FindBy(how = How.XPATH, using = "//*[@id=\"organizationAmntDivId\"]/div[2]/b")
	private WebElement orgAdvance;

	@FindBy(how = How.ID, using = "editChkBoxManageLedger")
	private WebElement manageLedger;

	@FindBy(how = How.ID, using = "editOpeningBal")
	private WebElement editOpeningBal;

	@FindBy(how = How.ID, using = "orgUploadButton")
	private WebElement orgUploadButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"saveBillError\"]/div")
	private WebElement saveBillErrorMsg;

	@FindBy(how = How.ID, using = "saveBill")
	private WebElement saveBill;

	@FindBy(how = How.ID, using = "additionalCost")
	private WebElement additionalCost;

	@FindBy(how = How.ID, using = "comments")
	private WebElement comments;

	@FindBy(how = How.XPATH, using = "//button[@style=\"width:150px;\"]")
	private WebElement settings;

	@FindBy(how = How.ID, using = "discountConfCommentFlag")
	private WebElement discountConfCommentFlag;

	@FindBy(how = How.XPATH, using = "(//button[@id=\"savebillSetting\"])[1]")
	private WebElement saveSetting;

	@FindBy(how = How.ID, using = "backToRegistration")
	private WebElement backToRegistration;

	@FindBy(how = How.ID, using = "additionalServiceFlag")
	private WebElement additionalServiceFlag;

	@FindBy(how = How.ID, using = "additionalCharges")
	private WebElement additionalCharges;

	@FindBy(how = How.ID, using = "colledtedSampleFlag")
	private WebElement colledtedSampleFlag;

	@FindBy(how = How.ID, using = "collectedSample")
	private WebElement collectedSample;

	@FindBy(how = How.ID, using = "testQuantityOptionFlag")
	private WebElement testQuantityFlag;

	@FindBy(how = How.ID, using = "testQuantity0")
	private WebElement testQuantity;

	@FindBy(how = How.ID, using = "searchByAccessionNoFlag")
	private WebElement searchByAccessionNo;

	@FindBy(how = How.ID, using = "searchByAccessionNo")
	private WebElement searchByAccession;

	@FindBy(how = How.ID, using = "searchAccBtn")
	private WebElement searchAccBtn;

	@FindBy(how = How.ID, using = "isHomeCollectionBill")
	private WebElement isHomeCollectionBill;

	@FindBy(how = How.ID, using = "patientAddressBilling")
	private WebElement patientAddressBilling;

	@FindBy(how = How.ID, using = "locality")
	private WebElement locality;

	@FindBy(how = How.ID, using = "postal_code")
	private WebElement postal_code;

	@FindBy(how = How.ID, using = "takeNewBtn")
	private WebElement takeNewBtn;

	@FindBy(how = How.ID, using = "availableFromTime")
	private WebElement availableFromTime;

	@FindBy(how = How.XPATH, using = "/html/body/div[21]/ul/li[2]/a/span")
	private WebElement availableFrom;

	@FindBy(how = How.ID, using = "availableTillTime")
	private WebElement availableTillTime;

	@FindBy(how = How.XPATH, using = "/html/body/div[25]/ul/li[2]/a/span")
	private WebElement availableTill;

	@FindBy(how = How.XPATH, using = "/html/body/div[25]/ul/li[3]/div/div[1]/table/tbody/tr[1]/td[1]/a/span")
	private WebElement glyphicon;

	@FindBy(how = How.XPATH, using = "//*[@id=\"currentDate\"]/span/span")
	private WebElement calender;

	@FindBy(how = How.XPATH, using = "/html/body/div[19]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]")
	private WebElement month;

	@FindBy(how = How.XPATH, using = "/html/body/div[19]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[1]")
	private WebElement leftArrow;

	@FindBy(how = How.XPATH, using = "/html/body/div[19]/ul/li[1]/div/div[1]/table/tbody/tr[2]/td[2]")
	private WebElement selectDay;

	@FindBy(how = How.ID, using = "confirmBillDate")
	private WebElement confirmBillDate;

	@FindBy(how = How.ID, using = "discountOutsourceFlag")
	private WebElement discountOutsourceFlag;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[4]/div[1]/div[8]/div/div[3]/p")
	private WebElement concessionAmount;

	@FindBy(how = How.ID, using = "confirmBillId")
	private WebElement confirmBillId;

	@FindBy(how = How.ID, using = "billTotalAmountLabel")
	private WebElement billTotalAmountLabel;

	@FindBy(how = How.ID, using = "//*[@id=\"concessionErrorDiv\"]/div")
	private WebElement warningMsg;

	@FindBy(how = How.ID, using = "discountList")
	private WebElement discountList;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[4]/div[1]/div[8]/div[1]/div[3]/p")
	private WebElement discount_1;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[4]/div[1]/div[8]/div[2]/div[3]/p")
	private WebElement discount_2;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[4]/div[1]/div[8]/div[3]/div[3]/p")
	private WebElement discount_3;

	@FindBy(how = How.ID, using = "textInput12775")
	private WebElement hangingDrop;

	@FindBy(how = How.ID, using = "textInput12772")
	private WebElement eosinophils;

	@FindBy(how = How.ID, using = "textInput12771")
	private WebElement monocyte;

	@FindBy(how = How.ID, using = "reportModeFlag")
	private WebElement reportModeFlag;

	@FindBy(how = How.LINK_TEXT, using = "Operation")
	private WebElement operation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hoverDropdown\"]/ul/li[13]/a")
	private WebElement allDepartments;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hoverDropdown\"]/a")
	private WebElement selectDepartment;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userWaiting1318\"]/div/div[1]/span[2]/b")
	private WebElement selectRoger;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div/div[8]/div/div[5]/label")
	private WebElement emergencyFlag;

	@FindBy(how = How.NAME, using = "singleSampleRecBtn")
	private WebElement singleSampleRecBtn;

	@FindBy(how = How.ID, using = "navbar-content-title")
	private WebElement savePdf;

	@FindBy(how = How.ID, using = "billConsentForm")
	private WebElement billConsentForm;

	@FindBy(how = How.XPATH, using = "//*[@id=\"printConsentForm\"]/button[2]")
	private WebElement consentDropDown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"uploadedForms\"]/li[1]/a")
	private WebElement ctConsent;

	@FindBy(how = How.ID, using = "age")
	private WebElement age;

	@FindBy(how = How.ID, using = "radiobutton")
	private WebElement male;

	@FindBy(how = How.ID, using = "indirectUserSearch")
	private WebElement indirectUserSearch;

	@FindBy(how = How.ID, using = "mobile")
	private WebElement mobile;

	@FindBy(how = How.ID, using = "concessionErrorDiv")
	private WebElement concessionErrorDiv;

	@FindBy(how = How.ID, using = "oldVersionBillingPage")
	private WebElement oldVersionBillingPage;

	@FindBy(how = How.ID, using = "nextDiv")
	private WebElement nextDiv;

	@FindBy(how = How.ID, using = "savePrintBill")
	private WebElement savePrintBill;

	@FindBy(how = How.ID, using = "newVersionBillingPage")
	private WebElement newVersionBillingPage;

	@FindBy(how = How.XPATH, using = "//*[@id=\"confirmBillMsgDiv\"]/div")
	private WebElement confirmBillMsg;

	@FindBy(how = How.XPATH, using = "//*[@id=\"uploadedForms\"]/li[5]/a")
	private WebElement formF;

	@FindBy(how = How.ID, using = "pndtPatientName")
	private WebElement pndtPatientName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formFDetailsModal\"]/div[1]/div/div[1]/button")
	private WebElement closeFormF;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ctForm\"]/input[2]")
	private WebElement getPdf;

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
		CommonMethods.waitForElementToClickable(adminHover);
		Actions actions = new Actions(DriverFactory.getDriver());
		actions.moveToElement(adminHover).build().perform();
		CommonMethods.waitForElementToClickable(registration);
		registration.click();
		CommonMethods.waitForElementToClickable(billUrl);
		billUrl.click();
	}

	public String getPageTitle() throws Exception {
		CommonMethods.waitForElementToClickable(billUrl);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", billUrl);

		return searchUserForBilling.getAttribute("placeholder");

	}

	public void searchToBilling(String userInfo) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(billUrl);
		billUrl.click();
		searchUserForBilling.sendKeys(userInfo);

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[3]/div[2]/div/div[1]/span/span")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[3]/div[2]/div/div[1]/span/span"));

		dropDowns.get(0).click();

	}

	public String getPageTitle(String userInfo) throws Exception {

		searchToBilling(userInfo);
		CommonMethods.waitForElementToClickable(testList);

		return DriverFactory.getDriver().getTitle().trim();
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
	}

	public boolean searchLoader(String userInfo) throws Exception {
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(billUrl);
		billUrl.click();
		searchUserForBilling.sendKeys(userInfo);

		return circleLoader.isDisplayed();
	}

	public List<String> dueAmountVerification(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Albumin Serum");

		if (balanceAmount.getText().length() > 0) {
			return Arrays.asList(balanceAmount.getText().trim(), firstTestAmt.getText().trim());
		}
		return null;

	}

	public String advanceAmountShownCorrectlyOrNot(String userInfo) throws Exception {
		searchToBilling(userInfo);
		selectTestName("Albumin Serum");

		return userAmntDivId.getText();
	}

	public List<String> referrelPriceList(String userInfo) throws Exception {
		searchToBilling(userInfo);

		Select select = new Select(referralList);
		List<WebElement> options = select.getOptions();
		List<String> refList = new ArrayList<>();

		for (WebElement element : options) {
			refList.add(element.getText().trim());
		}

		return refList;
	}

	public List<String> priceListAsPerSelectedReferrel(String userInfo) throws Exception {

		searchToBilling(userInfo);

		Select select = new Select(referralList);
		select.selectByVisibleText("Referrel with livehealth ");

		List<String> list = new ArrayList<>();
		list.add("Cholesterol - Total");
		list.add("Chloride");
		list.add("Cholesterol LDL");

		for (String test : list) {
			testList.sendKeys(test);
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inputT\"]/span/span/div[1]")));

			List<WebElement> dropDowns = DriverFactory.getDriver()
					.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[1]"));

			dropDowns.get(0).click();

			concession.sendKeys(Keys.ENTER);
		}

		list.clear();

		list.add(firstTestprice.getText());
		list.add(seconfTestprice.getText());
		list.add(thirdTestprice.getText());

		return list;
	}

	public List<String> confirmPriceListAsPerSelectedReferrel() throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(adminHover);

		builder.moveToElement(adminHover).build().perform();

		CommonMethods.waitForElementToClickable(admin);
		admin.click();

		listManagement.click();

		listName.sendKeys("Ref Dhanraj");

		new WebDriverWait(DriverFactory.getDriver(), 10).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"listNameParent\"]/div/span/span/div")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"listNameParent\"]/div/span/span/div"));

		dropDowns.get(0).click();

		List<String> list = new ArrayList<>();

		new WebDriverWait(DriverFactory.getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("textInput12012")));

		list.add(test1.getAttribute("value"));
		list.add(test2.getAttribute("value"));
		list.add(test3.getAttribute("value"));

		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");

		return list;
	}

	public List<String> companyPriceList(String userInfo) throws Exception {
		searchToBilling(userInfo);

		Select select = new Select(companyList);
		List<WebElement> options = select.getOptions();
		List<String> orgList = new ArrayList<>();

		for (WebElement element : options) {
			orgList.add(element.getText().trim());
		}

		return orgList;
	}

	public List<String> priceListAsPerSelectedCompany(String userInfo) throws Exception {

		searchToBilling(userInfo);

		Select select = new Select(companyList);
		select.selectByVisibleText("DIRECT ");

		List<String> list = new ArrayList<>();
		list.add("Cholesterol - Total");
		list.add("Chloride");
		list.add("Cholesterol LDL");

		for (String test : list) {
			testList.sendKeys(test);
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inputT\"]/span/span/div[1]")));

			List<WebElement> dropDowns = DriverFactory.getDriver()
					.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[1]"));

			dropDowns.get(0).click();

			concession.sendKeys(Keys.ENTER);
		}

		list.clear();

		list.add(firstTestprice.getText());
		list.add(seconfTestprice.getText());
		list.add(thirdTestprice.getText());

		return list;
	}

	public List<String> confirmPriceListAsPerSelectedCompany() throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(adminHover);

		builder.moveToElement(adminHover).build().perform();

		CommonMethods.waitForElementToClickable(admin);
		admin.click();

		listManagement.click();

		listName.sendKeys("Postpaid Organization");

		new WebDriverWait(DriverFactory.getDriver(), 10).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"listNameParent\"]/div/span/span/div")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"listNameParent\"]/div/span/span/div"));

		dropDowns.get(0).click();

		List<String> list = new ArrayList<>();

		new WebDriverWait(DriverFactory.getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("textInput12530")));

		list.add(orgTest1.getAttribute("value"));
		list.add(orgTest2.getAttribute("value"));
		list.add(orgTest3.getAttribute("value"));

		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");

		return list;
	}

	public String typeTestNameField(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Albumin Ser");

		return tName.getText().trim();
	}

	public String testCalculator(String userInfo) throws Exception {

		searchToBilling(userInfo);
		calculatorBtn.click();
		List<String> testList = new ArrayList<>();
		testList.add("Cholesterol - Total");
		testList.add("Cold Agglutinin *");
		testList.add("Platelet Count Thrombocyte Count *");

		for (String test : testList) {

			searchInputforOnlyTests.sendKeys(test);
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[18]/div/div/div[2]/div[6]/span/span")));

			List<WebElement> dropDowns = DriverFactory.getDriver()
					.findElements(By.xpath("/html/body/div[18]/div/div/div[2]/div[6]/span/span"));

			dropDowns.get(0).click();

		}

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calculateTotalAmount")));

		int t1 = Integer.parseInt(test_1.getText());
		int t2 = Integer.parseInt(test_2.getText());
		int t3 = Integer.parseInt(test_3.getText());

		String addition = String.valueOf(t1 + t2 + t3);
		if (addition.equals(totalAmt.getText())) {

			String calculatedAmt = totalAmt.getText();

			return calculatedAmt;
		}

		return null;

	}

	public String multipleTestAddedSuccessfully(String userInfo) throws Exception {
		searchToBilling(userInfo);

		List<String> t_List = new ArrayList<>();
		t_List.add("Cholesterol - Total");
		t_List.add("Cold Agglutinin *");
		t_List.add(" Ionised Calcium");

		for (String test : t_List) {
			selectTestName(test);
		}

		int t1 = Integer.parseInt(firstTestprice.getText());
		int t2 = Integer.parseInt(seconfTestprice.getText());
		int t3 = Integer.parseInt(thirdTestprice.getText());

		String addition = String.valueOf(t1 + t2 + t3);
		if (addition.equals(payableAmount.getText())) {

			String calculatedAmt = payableAmount.getText();

			return calculatedAmt;
		}

		return null;

	}

	public String singleTestAddedSuccessfully(String userInfo) throws Exception {
		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		String testPrice = firstTestprice.getText();

		if (testPrice.equals(payableAmount.getText())) {

			String calculatedAmt = payableAmount.getText();

			return calculatedAmt;
		}
		return null;

	}

	public List<String> testPriceAsPerSelectedTest(String userInfo) throws Exception {

		searchToBilling(userInfo);

		List<String> list = new ArrayList<>();
		list.add(" Ionised Calcium");
		list.add("24 Hrs Urine Creatinine");
		list.add("24 Hrs. Urinary  Protein/Creatinine Ratio  *");

		for (String test : list) {
			selectTestName(test);
		}

		list.clear();

		list.add(firstTestprice.getText());
		list.add(seconfTestprice.getText());
		list.add(thirdTestprice.getText());

		return list;
	}

	public List<String> confirmTestPrice() throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(adminHover);

		builder.moveToElement(adminHover).build().perform();

		CommonMethods.waitForElementToClickable(admin);
		admin.click();

		profileManagement.click();

		new WebDriverWait(DriverFactory.getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"editTest12151\"]/div[3]")));

		List<String> list = new ArrayList<>();

		list.add(tPrice1.getText().trim());
		list.add(tPrice2.getText().trim());
		list.add(tPrice3.getText().trim());

		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");

		return list;

	}

	public String isPercentageConcessionGettingSuccessfully(String userInfo) throws Exception {
		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		Select select = new Select(concessionType);
		select.selectByValue("Percentage");

		String totalAmt = payableAmount.getText();

		String discount = totalAmt.substring(0, totalAmt.length() - 1);

		int totalAmtInt = Integer.parseInt(totalAmt);

		int discountInt = Integer.parseInt(discount);

		String discountedAmt = String.valueOf(totalAmtInt - discountInt);

		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("10");
		testList.clear();

		String amt = payableAmount.getText();

		if (amt.equals(discountedAmt)) {

			return amt;
		}
		return null;
	}

	public String removeTest(String userInfo) throws Exception {
		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");
		selectTestName("Cholesterol - Total");

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", closeTestBtn);

		Thread.sleep(1000);
		CommonMethods.waitForElementToClickable(testList);
		testList.clear();

		return payableAmount.getText().trim();

	}

	public List<String> alreadySelectedOrganization(String userInfo) throws Exception {

		registerUrl.click();
		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(userInfo.toLowerCase()).build().perform();

		new WebDriverWait(DriverFactory.getDriver(), 10).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"searchNewDirectPatientDiv\"]/span/span/div[2]")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"searchNewDirectPatientDiv\"]/span/span/div[2]"));

		dropDowns.get(0).click();

		CommonMethods.waitForElementToClickable(newDirectOrganization);

		Select select = new Select(newDirectOrganization);
		String selectedOrg = select.getFirstSelectedOption().getText().trim();

		billing.click();

		searchToBilling(userInfo);
		String currentOrg = currentOrganization.getText().trim();

		return Arrays.asList(selectedOrg, currentOrg);

	}

	public String selectOrganization(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		Select select = new Select(companyList);
		select.selectByVisibleText("link org ");

		String selectedOrg = select.getFirstSelectedOption().getText().trim();

		return selectedOrg;
	}

	public String addOrgLinkAbleToAddOrg(String userInfo, String orgName) throws Exception {
		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		otherInfo.click();
		otherInfo.click();

		CommonMethods.waitForElementToClickable(addOrganization);
		addOrganization.click();

		orgnName.sendKeys(orgName);

		orgnEmail.clear();

		CommonMethods.waitForElementToClickable(addOrgButton);
		addOrgButton.click();

		CommonMethods.waitForElementToClickable(billOrg);

		Select select = new Select(billOrg);
		List<WebElement> options = select.getOptions();

		for (WebElement element : options) {

			if (element.getText().trim().equals(orgName)) {
				return orgName;
			}
		}
		return null;

	}

	public void deleteAddedOrgByAddOrgLink(String orgName) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(adminHover);

		builder.moveToElement(adminHover).build().perform();

		CommonMethods.waitForElementToClickable(admin);
		admin.click();

		CommonMethods.waitForElementToClickable(organizationManagement);
		organizationManagement.click();

		CommonMethods.waitForElementToClickable(addEditOrganization);
		addEditOrganization.click();

		CommonMethods.waitForElementToClickable(editOrgTab);
		editOrgTab.click();

		CommonMethods.waitForElementToClickable(orgEditList);
		builder.moveToElement(orgEditList).click().sendKeys(orgName).build().perform();

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/div[1]/div[4]/div/div/span/span")));

		builder.moveToElement(
				orgEditList.findElement(By.xpath("/html/body/section/div[2]/div[1]/div[4]/div/div/span/span"))).click()
				.build().perform();

		builder.sendKeys(Keys.DOWN);

		CommonMethods.waitForElementToClickable(orgDeleteButton);
		orgDeleteButton.click();

		CommonMethods.waitForElementToClickable(orgDelete);
		orgDelete.click();

		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");

	}

	public boolean otherReferrelField(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		otherInfo.click();
		otherInfo.click();

		CommonMethods.waitForElementToClickable(billCompany);
		return billCompany.isDisplayed();
	}

	public String selectHomeDelivery(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		otherInfo.click();
		otherInfo.click();

		Select select = new Select(service);
		select.selectByValue("DELIVERY");

		return select.getFirstSelectedOption().getText().trim();

	}

	public String selectCourierCollection(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		otherInfo.click();
		otherInfo.click();

		Select select = new Select(service);
		select.selectByValue("COURIER");

		return select.getFirstSelectedOption().getText().trim();

	}

	public String defaultPaymentMode(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		Select select = new Select(paymentMode);

		return select.getFirstSelectedOption().getText().trim();

	}

	public String setDefaultPaymentMode(String userInfo, String defaultMode) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		Select select = new Select(paymentMode);
		select.selectByValue(defaultMode);

		testList.clear();

		return select.getFirstSelectedOption().getAttribute("value");

	}

	public String addPaymentMode(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", addPayment);

		new WebDriverWait(DriverFactory.getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentType_1")));

		Select select = new Select(paymentType_1);
		select.selectByVisibleText("Credit");

		chequeNo_1.sendKeys("1234");

		issueBankName_1.sendKeys("BOM");

		paymentAmount_1.sendKeys("500");

		savebillSetting.click();

		return advanceAmount.getText();
	}

	public String uniqueTestNames(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		testList.sendKeys("Ionised Calcium");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]"));

		dropDowns.get(0).click();

		testList.clear();

		String errorMsg = errorDiv.getText();
		String strOrgAdv = errorMsg.substring(1, errorMsg.length());

		return strOrgAdv.trim();

	}

	public String uniqueTestNamesForProfile(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Cholesterol - Total");

		testList.sendKeys("Profile livef");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]"));

		dropDowns.get(0).click();

		testList.clear();

		String errorMsg = errorDiv.getText();
		String strOrgAdv = errorMsg.substring(1, errorMsg.length());

		return strOrgAdv.trim();

	}

	public String organizationAdvance(String userInfo) throws Exception {

		setOrganizationAdvance("1000");

		searchToBilling(userInfo);
		selectTestName("Cholesterol - Total");

		otherInfo.click();
		otherInfo.click();

		Select select = new Select(billOrg);
		select.selectByVisibleText("prepaid Organization");
		CommonMethods.waitForElementToClickable(orgAdvance);

		return orgAdvance.getText().trim();

	}

	public List<String> dueCutFromOrganizationAdvance(String userInfo) throws Exception {

		setOrganizationAdvance("1000");

		searchToBilling(userInfo);
		selectTestName("Cholesterol - Total");

		otherInfo.click();
		otherInfo.click();

		Select select = new Select(billOrg);
		select.selectByVisibleText("prepaid Organization");

		String orgAdv = orgAdvance.getText().trim();

		String strOrgAdv = orgAdv.substring(2, orgAdv.length());

		int intOrgadv = Integer.parseInt(strOrgAdv);
		int tAmt = Integer.parseInt(payableAmount.getText().trim());

		String calRemainedAmt = String.valueOf(intOrgadv - tAmt);

		saveBill.click();

		String remainedAmt = organizationAdvance(userInfo);
		String strRemainedAmt = remainedAmt.substring(2, remainedAmt.length());

		return Arrays.asList(strRemainedAmt, calRemainedAmt);

	}

	public void setOrganizationAdvance(String advanceAmt) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(adminHover);

		builder.moveToElement(adminHover).build().perform();

		CommonMethods.waitForElementToClickable(admin);
		admin.click();

		CommonMethods.waitForElementToClickable(organizationManagement);
		organizationManagement.click();

		CommonMethods.waitForElementToClickable(addEditOrganization);
		addEditOrganization.click();

		CommonMethods.waitForElementToClickable(editOrgTab);
		editOrgTab.click();

		CommonMethods.waitForElementToClickable(orgEditList);
		builder.moveToElement(orgEditList).click().sendKeys("prepaid Organization").build().perform();

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"editOrgDiv\"]/div[4]/div/div/span/span/div")));

		builder.moveToElement(orgEditList.findElement(By.xpath("//*[@id=\"editOrgDiv\"]/div[4]/div/div/span/span/div")))
				.click().build().perform();

		builder.sendKeys(Keys.DOWN);

		manageLedger.click();
		manageLedger.click();

		editOpeningBal.clear();
		editOpeningBal.sendKeys(advanceAmt);

		orgUploadButton.click();

		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");

	}

	public String ifOrganizationAdvanceLessThanBillAmount(String userInfo) throws Exception {

		setOrganizationAdvance("100");

		searchToBilling(userInfo);
		selectTestName("Cholesterol - Total");

		otherInfo.click();
		otherInfo.click();

		Select select = new Select(billOrg);
		select.selectByVisibleText("prepaid Organization");

		String orgAdv = orgAdvance.getText().trim();

		String strOrgAdv = orgAdv.substring(2, orgAdv.length());

		int intOrgAdv = Integer.parseInt(strOrgAdv);
		int tAmt = Integer.parseInt(payableAmount.getText().trim());

		if (intOrgAdv < tAmt) {

			saveBill.click();
			String erorMsg = saveBillErrorMsg.getText().trim();

			return erorMsg;
		}
		return null;
	}

	public String organisationCreditLimitLessThanBillAmount(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Cholesterol - Total");
		selectTestName("Ionised Calcium");

		otherInfo.click();
		otherInfo.click();

		Select select = new Select(billOrg);
		select.selectByVisibleText("postpaid Organization");

		String errorMsg = saveBillErrorMsg.getText();

		String msg = errorMsg.substring(1, errorMsg.length());

		return msg.trim();

	}

	public List<String> userAdvanceAndPayableAmount(String userInfo) throws Exception {
		String payableAmt;

		searchToBilling(userInfo);
		selectTestName("Cholesterol - Total");
		selectTestName("Ionised Calcium");
		selectTestName("Cholesterol LDL");

		String userAdvance = userAmntDivId.getText();

		int t1 = Integer.parseInt(firstTestprice.getText());
		int t2 = Integer.parseInt(seconfTestprice.getText());
		int t3 = Integer.parseInt(thirdTestprice.getText());

		String addition = String.valueOf(t1 + t2 + t3);
		if (addition.equals(payableAmount.getText())) {

			payableAmt = payableAmount.getText();

			return Arrays.asList(userAdvance, payableAmt);
		}

		return null;
	}

	public String additionalPriceField(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Cholesterol - Total");
		selectTestName("Ionised Calcium");
		selectTestName("Cholesterol LDL");

		String payableAmtBefore = payableAmount.getText();

		additionalCost.clear();
		additionalCost.sendKeys("50");
		testList.clear();

		String payableAmtAfter = payableAmount.getText();

		int before = Integer.parseInt(payableAmtBefore);
		int after = Integer.parseInt(payableAmtAfter);

		int addedPrice = after - before;

		if (addedPrice == 50) {
			return payableAmtAfter;
		}
		return null;
	}

	public String verifyConcessionInRupees(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");
		selectTestName("CPK, Total");
		selectTestName("Cholesterol - Total");

		int t1 = Integer.parseInt(firstTestprice.getText());
		int t2 = Integer.parseInt(seconfTestprice.getText());
		int t3 = Integer.parseInt(thirdTestprice.getText());

		String addition = String.valueOf((t1 + t2 + t3) - 50);

		Select select = new Select(concessionType);
		select.selectByValue("Rupees");

		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("50");
		comments.sendKeys("concession");

		String amt = payableAmount.getText();

		if (addition.equals(amt)) {

			return amt;
		}

		return null;
	}

	public String concessionInPercentage(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");
		selectTestName("CPK, Total");
		selectTestName("Cholesterol - Total");

		int t1 = Integer.parseInt(firstTestprice.getText());
		int t2 = Integer.parseInt(seconfTestprice.getText());
		int t3 = Integer.parseInt(thirdTestprice.getText());

		String totalAmt = String.valueOf(t1 + t2 + t3);

		String discount = totalAmt.substring(0, totalAmt.length() - 1);

		int totalAmtInt = Integer.parseInt(totalAmt);

		int discountInt = Integer.parseInt(discount);

		String discountedAmt = String.valueOf(totalAmtInt - discountInt);

		Select select = new Select(concessionType);
		select.selectByValue("Percentage");

		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("10");
		comments.sendKeys("concession");

		String amt = payableAmount.getText();

		if (discountedAmt.equals(amt)) {

			return amt;
		}
		return null;

	}

	public boolean discountCommentsField(String userInfo) throws Exception {

		registerUrl.click();

		DriverFactory.getDriver().navigate().refresh();

		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(discountConfCommentFlag);

		if (!discountConfCommentFlag.isSelected()) {
			discountConfCommentFlag.click();
		}

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		billing.click();
		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		Select select = new Select(concessionType);
		select.selectByValue("Rupees");

		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("50");

		String borderColorBefore = comments.getCssValue("border-color");

		saveBill.click();

		String borderColorAfter = comments.getCssValue("border-color");

		if (borderColorBefore.equals(borderColorAfter)) {

			return false;
		} else {
			return true;
		}

	}

	public String criticalAndEmergencyCheckBoxAbleToSet(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		advanceAmount.clear();
		advanceAmount.sendKeys(payableAmount.getText());

		reportModeFlag.click();

		saveBill.click();

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(adminHover);

		builder.moveToElement(adminHover).build().perform();
		operation.click();

		CommonMethods.waitForElementToClickable(selectDepartment);
		selectDepartment.click();
		CommonMethods.waitForElementToClickable(allDepartments);
		allDepartments.click();

		new WebDriverWait(DriverFactory.getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("loadMoreUserList")));

		emergencyFlag.click();
		selectRoger.click();

		return null;
	}

	public String receiveSampleAndPrint(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		advanceAmount.clear();
		advanceAmount.sendKeys(payableAmount.getText());

		saveBill.click();

		new WebDriverWait(DriverFactory.getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("singleSampleRecBtn")));

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", singleSampleRecBtn);

		Thread.sleep(1000);
		// String pdf = savePdf.getText();
		//
		// System.out.println("==" + pdf);

		DriverFactory.getDriver().close();

		String rcvdStatus = singleSampleRecBtn.getText();

		return rcvdStatus;
	}

	public User ctConsentForm(User user, String userInfo) throws Exception {

		consentForm(userInfo);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		js.executeScript("arguments[0].click();", ctConsent);
		js.executeScript("arguments[0].scrollIntoView(true);", ctConsent);
		new WebDriverWait(DriverFactory.getDriver(), 20)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ctForm\"]/input[2]")));

		js.executeScript("arguments[0].click();", getPdf);

		// Actions builder = new Actions(DriverFactory.getDriver());
		//
		// DriverFactory.getDriver().navigate().refresh();
		//
		//
		// builder.moveToElement(mobile).sendKeys(user.getPhoneNumber());
		//
		// age.sendKeys(user.getAge());
		// builder.moveToElement(age).sendKeys(user.getAge());
		//
		// user.setName(indirectUserSearch.getAttribute("value"));
		// user.setPhoneNumber(mobile.getAttribute("value"));
		// user.setAge(age.getAttribute("value"));
		//
		// System.out.println(user.getName());
		// System.out.println(user.getPhoneNumber());
		// System.out.println(user.getAge());

		return user;
	}

	public String backToRegistrationPage(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		advanceAmount.clear();
		advanceAmount.sendKeys(payableAmount.getText());

		saveBill.click();

		CommonMethods.waitForElementToClickable(backToRegistration);

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", backToRegistration);

		return DriverFactory.getDriver().getTitle();

	}

	public String additionalServicesFlag(String userInfo) throws Exception {

		registerUrl.click();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(additionalServiceFlag);

		if (!additionalServiceFlag.isSelected()) {
			additionalServiceFlag.click();
		}

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		billing.click();
		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		otherInfo.click();
		otherInfo.click();

		Select select = new Select(additionalCharges);

		select.selectByValue("NONE");

		return select.getFirstSelectedOption().getText();

	}

	public String collectedSampleType(String userInfo) throws Exception {

		registerUrl.click();
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(colledtedSampleFlag);

		if (!colledtedSampleFlag.isSelected()) {
			colledtedSampleFlag.click();
		}

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		billing.click();
		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		otherInfo.click();
		otherInfo.click();

		Select select = new Select(collectedSample);
		select.selectByValue("Self");

		String firstSelected = select.getFirstSelectedOption().getAttribute("value");

		return firstSelected;

	}

	public List<String> discountPriceList(String userInfo) throws Exception {

		searchToBilling(userInfo);

		Select select = new Select(discountList);
		select.selectByVisibleText("Discount list ");

		List<String> list = new ArrayList<>();
		list.add("Hanging Drop Preparation *");
		list.add("Absolute Eosinophils Count *"); //
		list.add("Absolute Monocyte Count *");

		for (String test : list) {
			testList.sendKeys(test);
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]/span")));

			List<WebElement> dropDowns = DriverFactory.getDriver()
					.findElements(By.xpath("//*[@id=\"inputT\"]/span/span/div[2]/span"));

			dropDowns.get(0).click();

			concession.sendKeys(Keys.ENTER);
		}

		list.clear();

		String d1 = discount_1.getText().substring(0, discount_1.getText().length() - 2);
		String d2 = discount_2.getText().substring(0, discount_2.getText().length() - 2);
		String d3 = discount_3.getText().substring(0, discount_3.getText().length() - 2);

		list.add(d3);
		list.add(d2);
		list.add(d1);

		return list;
	}

	public List<String> confirmDiscountPriceList() throws Exception {

		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/newListManagement/");
		listName.sendKeys("Discount list");

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"listNameParent\"]/div/span/span/div")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"listNameParent\"]/div/span/span/div"));

		dropDowns.get(0).click(); //

		new WebDriverWait(DriverFactory.getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("textInput12775")));

		List<String> list = new ArrayList<>();

		list.add(hangingDrop.getAttribute("value"));
		list.add(eosinophils.getAttribute("value"));
		list.add(monocyte.getAttribute("value"));

		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");

		return list;
	}

	public int testQuantityOptionFlag(String userInfo) throws Exception {

		int cnt = 0;
		registerUrl.click();
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(testQuantityFlag);

		if (!testQuantityFlag.isSelected()) {
			testQuantityFlag.click();
		}

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		billing.click();
		searchToBilling(userInfo);

		for (int i = 0; i < 3; i++) {

			selectTestName("Ionised Calcium");

			cnt++;
		}

		int quantity = Integer.parseInt(testQuantity.getAttribute("value"));

		registerUrl.click();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(testQuantityFlag);

		if (testQuantityFlag.isSelected()) {
			testQuantityFlag.click();
		}

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		billing.click();

		if (cnt == quantity) {
			return quantity;
		}

		return 0;
	}

	public String searchAccessionNo(String accessionNum) throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		registerUrl.click();
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(searchByAccessionNo);

		if (!searchByAccessionNo.isSelected()) {
			searchByAccessionNo.click();
		}

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		billing.click();

		searchByAccession.sendKeys(accessionNum);
		searchAccBtn.click();

		CommonMethods.waitForElementToClickable(testList);

		return DriverFactory.getDriver().getTitle();

	}

	public HomeCollection homeCollectionBill(String userInfo, HomeCollection collection) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		otherInfo.click();
		otherInfo.click();

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", isHomeCollectionBill);

		patientAddressBilling.sendKeys(collection.getAddress());
		locality.sendKeys(collection.getCity());
		postal_code.sendKeys(collection.getPinCode());

		takeNewBtn.click();
		new WebDriverWait(DriverFactory.getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("availableTillTime")));

		js.executeScript("arguments[0].click();", availableTillTime);

		js.executeScript("arguments[0].click();", availableTill);

		new WebDriverWait(DriverFactory.getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[25]/ul/li[3]/div/div[1]/table/tbody/tr[1]/td[1]/a/span")));

		js.executeScript("arguments[0].click();", glyphicon);
		js.executeScript("arguments[0].click();", glyphicon);
		js.executeScript("arguments[0].click();", glyphicon);

		js.executeScript("arguments[0].click();", advanceAmount);
		advanceAmount.clear();
		advanceAmount.sendKeys(payableAmount.getText());

		saveBill.click();
		Thread.sleep(2000);
		return null;

	}

	public String backDatedBillGettingSaved(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		calender.click();
		String may = month.getText().trim();

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		do {
			js.executeScript("arguments[0].click();", leftArrow);
		} while (may.equalsIgnoreCase("May 2018"));

		js.executeScript("arguments[0].click();", selectDay);

		advanceAmount.clear();
		advanceAmount.sendKeys(payableAmount.getText());

		saveBill.click();

		String confirmDate = confirmBillDate.getText();
		String[] values = confirmDate.split(",");

		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");
		DriverFactory.getDriver().navigate().refresh();
		return values[0];
	}

	public String discountToDiscountDiscardedTestFlag(String userInfo) throws Exception {

		registerUrl.click();
		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(discountOutsourceFlag);

		if (!discountOutsourceFlag.isSelected()) {
			discountOutsourceFlag.click();
		}

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		billing.click();

		searchToBilling(userInfo);

		testList.sendKeys("Vitamin D Total - 25 Hydroxy");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span"));

		dropDowns.get(0).click();

		concession.clear();
		concession.sendKeys("50");
		concession.sendKeys(Keys.ENTER);

		String con = concessionAmount.getText();

		String discount = con.substring(0, 2).trim();
		String testPrice = firstTestprice.getText().trim();
		int priceInt = Integer.parseInt(testPrice);
		int discountInt = Integer.parseInt(discount);

		String pay = String.valueOf(priceInt - discountInt);

		if (pay.equals(payableAmount.getText().trim())) {

			advanceAmount.clear();
			advanceAmount.sendKeys(payableAmount.getText());
			saveBill.click();

			// String billId = confirmBillId.getText();
			//
			// DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billUpdate/"+billId);
			//
			// Thread.sleep(20000);
			// DriverFactory.getDriver().navigate().refresh();
			// String tAmt = billTotalAmountLabel.getText().trim();

			DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");

			return pay;
		}

		return null;
	}

	public String discountGettingDiscardedShowingWarningMsg(String userInfo) throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		registerUrl.click();
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(discountOutsourceFlag);

		if (discountOutsourceFlag.isSelected()) {
			discountOutsourceFlag.click();
		}

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		billing.click();

		searchToBilling(userInfo);
		selectTestName("Vitamin D Total - 25 Hydroxy");

		totalConcessionAmt.sendKeys("10");
		concession.click();

		String message = warningMsg.getText();
		System.out.println("==" + message);
		return message;

	}

	public String allowedDiscountOnBill(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		Select select = new Select(concessionType);
		select.selectByValue("Percentage");

		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("90");
		comments.sendKeys("concession");

		String totalAmt = firstTestprice.getText();
		String concessionAmt = concessionAmount.getText();

		String discount = concessionAmt.substring(0, concessionAmt.length() - 2);

		int totalAmtInt = Integer.parseInt(totalAmt);

		int discountInt = Integer.parseInt(discount);

		String discountedAmt = String.valueOf(totalAmtInt - discountInt);

		String amt = payableAmount.getText();

		if (discountedAmt.equals(amt)) {

			return amt;
		}
		return null;

	}

	public String moreThanAllowedDiscountOnBill(String userInfo) throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		Select select = new Select(concessionType);
		select.selectByValue("Percentage");

		totalConcessionAmt.clear();
		totalConcessionAmt.sendKeys("91");

		js.executeScript("arguments[0].click();", totalConcessionAmt);

		String concessionErrMsg = concessionErrorDiv.getText().trim();

		String msg = concessionErrMsg.substring(1, concessionErrMsg.length());

		return msg.trim();
	}

	public String saveAndPrintBill(String userInfo) throws Exception {

		registerUrl.click();
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(oldVersionBillingPage);
		oldVersionBillingPage.click();

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		billing.click();

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		nextDiv.click();

		advanceAmount.clear();
		advanceAmount.sendKeys(payableAmount.getText());
		savePrintBill.click();

		String confirmMsg = confirmBillMsg.getText();
		String msg = confirmMsg.substring(1, confirmMsg.length());

		DriverFactory.getDriver().close();
		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#directRegistration");

		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(newVersionBillingPage);
		newVersionBillingPage.click();

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		return msg.trim();

	}

	public void consentForm(String userInfo) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", registerUrl);

		js.executeScript("arguments[0].click();", settings);

		CommonMethods.waitForElementToClickable(billConsentForm);

		if (!billConsentForm.isSelected()) {
			billConsentForm.click();
		}

		saveSetting.click();
		DriverFactory.getDriver().navigate().refresh();

		billing.click();
		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		advanceAmount.clear();
		advanceAmount.sendKeys(payableAmount.getText());

		saveBill.click();

		js.executeScript("arguments[0].click();", consentDropDown);

		new WebDriverWait(DriverFactory.getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"uploadedForms\"]/li[1]/a")));

	}

	public String formFConsentForm(String userInfo) throws Exception {

		consentForm(userInfo);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		js.executeScript("arguments[0].click();", formF);

		new WebDriverWait(DriverFactory.getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("pndtPatientName")));

		String userName = pndtPatientName.getText().trim();

		closeFormF.click();
		DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");

		return userName;
	}
}
