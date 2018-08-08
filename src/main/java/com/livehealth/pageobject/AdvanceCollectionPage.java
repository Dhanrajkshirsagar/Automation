package com.livehealth.pageobject;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.livehealth.base.DriverFactory;
import com.livehealth.util.CommonMethods;

public class AdvanceCollectionPage {

	SoftAssert SoftAssert = new SoftAssert();
	Log4JLogger logger;
	
	@FindBy(how = How.ID, using = "username")
	private WebElement userNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/ul/div[1]/form/input[2]")
	private WebElement signIn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[1]/div[3]/ul/ul/li/a")
	private WebElement adminHover;

	@FindBy(xpath = "//*[@id=\"nav-sidebar\"]/div[3]/ul/li[5]/a")
	private WebElement advanceCollectionTab;

	@FindBy(id = "searchPatient")
	private WebElement searchPatient;

	@FindBy(xpath = "/html/body/section/div[2]/h4")
	private WebElement pagetittle;

	@FindBy(id = "submit")
	private WebElement submit;

	@FindBy(id = "advanceAmount")
	private WebElement advanceAmount;

	@FindBy(id = "advanceGiven")
	private WebElement advanceGiven;

	@FindBy(id = "print")
	private WebElement submitAndPrint;

	@PostConstruct
	public void loadDriver() throws Exception {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}

	public void signIn(String userName, String password) throws Exception {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signIn.click();
		CommonMethods.waitForElementToClickable(adminHover);

	}

	public String verifyAdvanceCollectionPage() {
		advanceCollectionTab.click();
		return pagetittle.getText();
	}

	public void selectPatient(String name) throws InterruptedException {
		searchPatient.sendKeys(name);
		Thread.sleep(2000);
		searchPatient.sendKeys(Keys.ARROW_DOWN);
		searchPatient.sendKeys(Keys.ENTER);

	}

	public String checkValidation(String name) throws InterruptedException {
		// advanceCollectionTab.click();
		String colour = null;
		if (submit.isEnabled()) {
			Assert.assertFalse(true);
		} else {
			selectPatient(name);
			if (submit.isEnabled()) {
				SoftAssert.assertFalse(false);
				submit.click();
				Thread.sleep(1000);
				 colour = advanceAmount.getCssValue("border-bottom-color");
			}
		}
		return colour;

	}

	public void collectAdvance(String mobNo, String amount) throws InterruptedException {
		advanceCollectionTab.click();
		searchPatient.clear();
		if (mobNo.equals("827536")) {
			selectPatient(mobNo);
		}
		if (mobNo.equals("774050")) {
			selectPatient(mobNo);
		}
		if (mobNo.equals("441559")) {
			selectPatient(mobNo);
		}

		String actualadvance = advanceGiven.getText();
		int expectedAdv = Integer.parseInt(actualadvance);
		int finalAdv = expectedAdv + Integer.parseInt(amount);
		String advAmount = Integer.toString(finalAdv);
		searchPatient.clear();
		selectPatient(mobNo);
		advanceAmount.sendKeys(amount);
		submit.click();
		searchPatient.clear();
		selectPatient(mobNo);
		String actualAdvAmt = advanceGiven.getText();
		SoftAssert.assertEquals(actualAdvAmt, advAmount);
		SoftAssert.assertAll();

	}

	public void collectAdanceAndPrintReceipt(String name, String amount) throws Exception {
		// advanceCollectionTab.click();
		searchPatient.clear();
		selectPatient(name);
		advanceAmount.sendKeys(amount);
		submitAndPrint.click();
		String winHandleBefore = DriverFactory.getDriver().getWindowHandle();
		for (String winHandle : DriverFactory.getDriver().getWindowHandles()) {
			DriverFactory.getDriver().switchTo().window(winHandle);
		}
		String actualUrl = DriverFactory.getDriver().getCurrentUrl();
		String afterSubmitUrl = actualUrl.substring(0, 53);
		Assert.assertEquals(afterSubmitUrl, "https://beta.livehealth.solutions/printAdvanceReceipt");
//		DriverFactory.getDriver().close();
		DriverFactory.getDriver().switchTo().window(winHandleBefore);
	}

}
