package com.livehealth.pageobject;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
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

		WebDriver driver = DriverFactory.getDriver();

		List<WebElement> sampleList = driver.findElements(By.className("waitingListPaitentNameMargin"));
		String firstId = sampleList.get(1).getText();

		dismissSampleConfirmation();

		confirmedSampleRemoval.click();

		DriverFactory.getDriver().navigate().refresh();

		List<WebElement> sample = driver.findElements(By.className("waitingListPaitentNameMargin"));

		String secondId = sample.get(1).getText();

		if (!firstId.equals(secondId)) {
			return true;
		}
		return false;

	}

	public String dismissSampleConfirmation() throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		List<WebElement> element = driver.findElements(By.xpath("//*[contains(text(),'Options')] "));

		element.get(1).click();

		WebElement dismissElement = driver.findElement(By.xpath("//a[contains(text(),'Dismiss Sample ')] "));

		dismissElement.click();
		rejectComments.sendKeys("reject");

		String confirm = myModalLabel.getText().trim();

		driver.navigate().refresh();

		return confirm;

	}

	public boolean receiveSample() throws Exception {

		WebDriver driver = DriverFactory.getDriver();

		List<WebElement> element = driver.findElements(By.xpath("//button[contains(text(),'Receive')] "));

		element.get(0).click();
		accessed.click();

		return false;

	}

	// public void searchToBilling(String userInfo) throws Exception {
	//
	// DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");
	// DriverFactory.getDriver().navigate().refresh();
	//
	// searchUserForBilling.sendKeys(userInfo);
	//
	// WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
	// wait.until(ExpectedConditions
	// .visibilityOfElementLocated(By.xpath("/html/body/section/div[3]/div[2]/div/div[1]/span/span")));
	//
	// List<WebElement> dropDowns = DriverFactory.getDriver()
	// .findElements(By.xpath("/html/body/section/div[3]/div[2]/div/div[1]/span/span"));
	//
	// dropDowns.get(0).click();
	//
	// }

	// public void selectTestName(String testName) throws Exception {
	// testList.sendKeys(testName);
	// WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
	// wait.until(ExpectedConditions.visibilityOfElementLocated(
	// By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span")));
	//
	// List<WebElement> dropDowns = DriverFactory.getDriver()
	// .findElements(By.xpath("/html/body/section/div[3]/div[4]/div[1]/div[7]/div[1]/div[1]/span/span"));
	//
	// dropDowns.get(0).click();
	//
	// concession.sendKeys(Keys.ENTER);
	// }

	// public boolean dismissSample(String userInfo) throws Exception {
	//
	// DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/billing/#");
	//
	// searchToBilling(userInfo);
	// selectTestName("Chloride");
	//
	// advanceAmount.clear();
	// advanceAmount.sendKeys(payableAmount.getText());
	//
	// saveBill.click();
	//
	// DriverFactory.getDriver().navigate().to("https://beta.livehealth.solutions/sampleAccession/");
	// Thread.sleep(1000);
	// CommonMethods.waitForElementToClickable(firstRow);
	//
	// String accessionId = firstRow.getText();
	//
	// JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
	//
	// DriverFactory.getDriver().findElement(By.id("options" +
	// accessionId)).click();
	// Thread.sleep(1000);
	// // element.click();
	// // js.executeScript("arguments[0].click();", element);
	//
	// dismissSample.click();
	//
	//// if (element.isDisplayed()) {
	//// return false;
	//// }
	// return true;
	//
	// }
}
