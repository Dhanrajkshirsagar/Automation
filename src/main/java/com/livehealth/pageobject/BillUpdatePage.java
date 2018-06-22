package com.livehealth.pageobject;

import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class BillUpdatePage {

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

	@FindBy(how = How.ID, using = "pendingBills")
	private WebElement pendingBills;

	@FindBy(how = How.ID, using = "userBillsContainer")
	private WebElement userBillsContainer;

	@FindBy(how = How.XPATH, using = "//*[@id=\"allBillListDateRange\"]/span")
	private WebElement selectDate;

	@FindBy(how = How.XPATH, using = "/html/body/div[5]/div[3]/ul/li[2]")
	private WebElement yesterday;

	@FindBy(how = How.ID, using = "completedBills")
	private WebElement completedBills;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPatientBar\"]/div/div[1]/button")
	private WebElement searchDropdown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPatientBar\"]/div/div[1]/ul/li[1]/a")
	private WebElement byRefName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPatientBar\"]/div/div[2]/span")
	private WebElement searchTab;

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
		DriverFactory.getDriver().navigate().to(Constants.ALL_BILLSLIST_URL);
	}

	public boolean pendingBillList() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		WebDriver driver = DriverFactory.getDriver();
		Thread.sleep(2000);
		pendingBills.click();

		List<WebElement> webElements = driver.findElements(By.id("userBillsContainer"));

		if (!(webElements.size() > 1)) {
			
			js.executeScript("arguments[0].click();", selectDate);
			js.executeScript("arguments[0].click();", yesterday);
			js.executeScript("arguments[0].click();", pendingBills);

		}
		List<WebElement> elements = driver.findElements(By.xpath("//label[contains(text(),'Pending')] "));

		for (WebElement element : elements) {
			
			if (element.getText().equals("Completed")) {
				return false;
			}

		}

		return true;
	}

	public boolean completedBillList() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();

		WebDriver driver = DriverFactory.getDriver();
		Thread.sleep(2000);
		completedBills.click();

		List<WebElement> webElements = driver.findElements(By.id("userBillsContainer"));

		if (!(webElements.size() > 1)) {

			js.executeScript("arguments[0].click();", selectDate);
			js.executeScript("arguments[0].click();", yesterday);
			js.executeScript("arguments[0].click();", completedBills);

		}

		List<WebElement> elements = driver.findElements(By.xpath("//label[contains(text(),'Completed')] "));

		for (WebElement element : elements) {

			if (element.getText().equals("Pending")) {
				return false;
			}

		}

		return true;
	}

	public boolean searchBillListByRefName() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		Thread.sleep(2000);
		searchDropdown.click();
		byRefName.click();

		searchTab.sendKeys("Referrel with livehealth");

		List<WebElement> elements = driver
				.findElements(By.xpath("//span[contains(text(),'Referral - Referrel with livehealth')] "));

		for (WebElement element : elements) {

			if (element.getText().equals("Referrel with livehealth")) {
				return true;
			}

		}

		return false;

	}
	
	public boolean searchBillListByUserName() throws Exception {

		WebDriver driver = DriverFactory.getDriver();
		Thread.sleep(2000);
		searchDropdown.click();
		byRefName.click();

		searchTab.sendKeys("benedict");

		List<WebElement> elements = driver
				.findElements(By.xpath("//span[contains(text(),'Benedict')] "));

		for (WebElement element : elements) {

			if (element.getText().equals("Benedict")) {
				return true;
			}

		}

		return false;

	}
}
