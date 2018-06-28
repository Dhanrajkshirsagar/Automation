package com.livehealth.pageobject;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;
import com.livehealth.model.TestSample;
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
	
	@FindAll({@FindBy(className = "waitingListPaitentNameMargin")})
	public List<WebElement> sampleList;
	
	@FindAll({@FindBy(className = "userWaitingListCard")})
	public List<WebElement> collectedSample;

	@FindAll({@FindBy(xpath = "//*[contains(text(),'Options')]")})
	public List<WebElement> options;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Dismiss Sample ')]")
	private WebElement dismissSample;

	@FindAll({@FindBy(xpath = "//button[contains(text(),'Receive')]")})
	public List<WebElement> receive;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div/div[8]/div[1]/div[7]/input[2]")
	private WebElement redraw;

	@FindBy(how = How.ID, using = "redrawComments")
	private WebElement redrawComments;

	@FindBy(how = How.ID, using = "redrawCommentBtn")
	private WebElement redrawCommentBtn;

	@FindAll({@FindBy(xpath = "//label[contains(text(),'Sample Redrawn')]")})
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

	@FindAll({@FindBy(xpath = "/html/body/section/div[2]/div[2]/div[4]/div/span/span")})
	public List<WebElement> sampleDropDown;

	@FindBy(how = How.ID, using = "sampleType")
	private WebElement sampleType;

	@FindBy(how = How.ID, using = "sampleDeleteBtn")
	private WebElement sampleDeleteBtn;

	@FindBy(how = How.ID, using = "editSampleFlag")
	private WebElement editSampleFlag;

	@FindAll({@FindBy(xpath = "/html/body/section/div[2]/div[2]/div[11]/div/div/div[2]/div[4]/span/span")})
	public List<WebElement> editSampleDropDown;

	@FindBy(how = How.ID, using = "addSampleTypeToTest")
	private WebElement addSampleTypeToTest;

	@FindAll({@FindBy(xpath = "/html/body/section/div[2]/div[2]/div[6]/span/span")})
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

	@FindAll({@FindBy(xpath = "/html/body/section/div[2]/div/div[4]/div[1]/div[1]/span/span")})
	public List<WebElement> sampleIdDropDown;

	@FindAll({@FindBy(className = "userWaitingListCard")})
	public List<WebElement> getSamples;

	@FindBy(how = How.ID, using = "searchReferral")
	private WebElement searchReferral;

	@FindAll({@FindBy(xpath = "/html/body/section/div[2]/div/div[4]/div[1]/div[2]/span/span")})
	public List<WebElement> referrelSearch;

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

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		WebDriver driver = DriverFactory.getDriver();

//		List<WebElement> element = driver.findElements(By.xpath("//*[contains(text(),'Options')] "));

		options.get(1).click();

//		WebElement dismissElement = driver.findElement(By.xpath("//a[contains(text(),'Dismiss Sample ')] "));

		dismissSample.click();
		rejectComments.sendKeys("reject");

		String confirm = myModalLabel.getText().trim();

		driver.navigate().refresh();

		return confirm;

	}

	public boolean receiveSample() throws Exception {

		TestSample sample = new TestSample();
		
		WebDriver driver = DriverFactory.getDriver();

		List<WebElement> dates = driver.findElements(By.className("waitingListUserListTestText"));

		sample.setUserName(sampleList.get(2).getText());
		sample.setDate(dates.get(0).getText());
		sample.setTestName(dates.get(1).getText());

		List<WebElement> element = driver.findElements(By.xpath("//button[contains(text(),'Receive')] "));
		element.get(0).click();
		
		accessed.click();

		Thread.sleep(1000);
		
		TestSample verifySample = new TestSample();

		List<WebElement> accessedDate = driver.findElements(By.className("userwaitingListFontColor"));
		List<WebElement> accessedTest = driver.findElements(By.className("waitingListUserListTestText"));

		verifySample.setUserName(sampleList.get(2).getText());
		verifySample.setDate(accessedDate.get(1).getText()); 
		verifySample.setTestName(accessedTest.get(0).getText());
		
		System.out.println(sample.toString());
		System.out.println(verifySample.toString());

		return false;

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

	public String redrawSample() throws Exception {
		
		receive.get(0).click();
		accessed.click();
		
		redraw.click();
		redrawComments.sendKeys("redraw");
		
		redrawCommentBtn.click();
		
		DriverFactory.getDriver().navigate().refresh();
		
		String var = sampleRedrawn.get(0).getText();
		
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

		return var;
		
	}
	
	public String redrawSampleConfirmation() throws Exception {
		
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		
		receive.get(0).click();
		accessed.click();
		
		redraw.click();
		redrawComments.sendKeys("redraw");
		
		String var = redrawCommentModalLabel.getText();
		
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

		return var;
		
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
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

		return null;

	}
	
	public String addNewSample() throws Exception {
		
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		accessionSettings.click();
		addEdit.click();

		CommonMethods.waitForElementToVisible(sampleTypeName);
		sampleTypeName.sendKeys("sampleTypeName");
		typeOfSample.sendKeys("typeOfSample");
		
		addSampleBtn.click();
		
		CommonMethods.waitForElementToVisible(sampleNameTypeadhead);
		Thread.sleep(1000);

		sampleNameTypeadhead.sendKeys("sampleTypeName");
		
		CommonMethods.waitForElementToVisible(sampleDropDown.get(0));

		sampleDropDown.get(0).click();

		Thread.sleep(1000);
		String text = sampleType.getText();
		
		js.executeScript("arguments[0].click();", sampleDeleteBtn);
		js.executeScript("arguments[0].click();", addSampleBtn);
		
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

		return text; 
		
	}
	
	public List<String> editSample() throws Exception {
	
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		String typeSample = commonMethods.getRandomString();
		accessionSettings.click();
		editSampleType();
		
		typeOfSample.sendKeys(typeSample);

		addSampleBtn.click();

		editSampleType();
		
		String text = typeOfSample.getText();
		
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

		return Arrays.asList(text,typeSample);
		
	}
	
	private void editSampleType() throws Exception {
		addEdit.click();

		editSampleFlag.click();
		
		CommonMethods.waitForElementToVisible(sampleTypeName);
		sampleTypeName.sendKeys("sampleTypeName");
		
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

		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);

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
		
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		
		return errorMsg;
		
	}
	
	public List<String> sampleSearchAbleToSelectSample() throws Exception {
		
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		String sampleId = sampleList.get(0).getText();
		
		optionLink.click();
		
		searchSampleAccessionInput.sendKeys(sampleId);
		
		CommonMethods.waitForElementToVisible(sampleIdDropDown.get(0));
		
		sampleIdDropDown.get(0).click();
		
		String searchedId = sampleList.get(0).getText();
		
		return Arrays.asList(sampleId,searchedId);
		
	}
	
	public List<String> searchByUserName() throws Exception {
		
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		String sample = sampleList.get(1).getText();
		
		String userName=sample.substring(0, (sample.length()-8));
				
		optionLink.click();

		searchSampleAccessionInput.sendKeys(userName);
		
		CommonMethods.waitForElementToVisible(sampleIdDropDown.get(0));
		
		sampleIdDropDown.get(0).click();
		
		String searchedSample = sampleList.get(1).getText();
	
		String searchedUser=searchedSample.substring(0, (sample.length()-8));

		return Arrays.asList(userName,searchedUser);
		
	}
	
	public boolean searchByReferrel() throws Exception {
		
		DriverFactory.getDriver().navigate().to(Constants.ACCESSION_URL);
		optionLink.click();
		
		searchReferral.sendKeys("Referrel  with sumit");
		
		CommonMethods.waitForElementToVisible(referrelSearch.get(0));
		
		referrelSearch.get(0).click();
		
		CommonMethods.waitForElementToVisible(getSamples.get(0));
		
		if(getSamples.size()>0) {
			
			return true;
		}	
		
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
