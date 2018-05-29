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
}
