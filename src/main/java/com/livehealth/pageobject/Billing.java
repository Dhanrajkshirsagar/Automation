package com.livehealth.pageobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
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
import com.livehealth.util.CommonMethods;
import com.livehealth.util.WebContext;

@Component
public class Billing {

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

	@FindBy(how = How.ID, using = "addPayment")
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
		billUrl.click();

		return DriverFactory.getDriver().getTitle();

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

	public boolean removeTest(String userInfo) throws Exception {
		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		closeTestBtn.click();

		if (closeTestBtn.isDisplayed()) {
			return false;
		}
		return true;

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
		select.selectByVisibleText("Home Delivery");

		return select.getFirstSelectedOption().getText().trim();

	}

	public String selectCourierCollection(String userInfo) throws Exception {

		searchToBilling(userInfo);
		selectTestName("Ionised Calcium");

		otherInfo.click();
		otherInfo.click();

		Select select = new Select(service);
		select.selectByVisibleText("Courier");

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

		addPayment.click();

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
}
