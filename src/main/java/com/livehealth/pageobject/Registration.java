package com.livehealth.pageobject;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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
import com.livehealth.model.Age;
import com.livehealth.model.User;
import com.livehealth.util.CommonMethods;
import com.livehealth.util.WebContext;

@Component
public class Registration {

	@FindBy(how = How.ID, using = "newError-msg")
	private WebElement errorText;

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

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[1]/div[2]/div[4]/button[1]")
	private WebElement calculator;

	@FindBy(how = How.ID, using = "searchInputforOnlyTestsSS")
	private WebElement priceCalc;

	@FindBy(how = How.ID, using = "calculateTotalAmount")
	private WebElement calculatedAmt;

	@FindBy(how = How.ID, using = "searchInputforOnlyTests")
	private WebElement typeTestName;

	@FindBy(how = How.ID, using = "newDirectPatientType")
	private WebElement userType;

	@FindBy(how = How.ID, using = "newDirectDesignation")
	private WebElement designation;

	@FindBy(how = How.ID, using = "newDirectFirstName")
	private WebElement firstName;

	@FindBy(how = How.ID, using = "newDirectSaveForm")
	private WebElement saveForm;

	@FindBy(how = How.ID, using = "searchInputforTests")
	private WebElement testList;

	@FindBy(how = How.ID, using = "registerUrl")
	private WebElement registerUrl;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[1]/div[2]/div[6]/div[3]/span/div/div/div")
	private WebElement country;

	@FindBy(how = How.ID, using = "newDirectEmail")
	private WebElement email;

	@FindBy(how = How.ID, using = "newDirectMobile")
	private WebElement phoneNumber;

	@FindBy(how = How.ID, using = "newDirectRadiobutton")
	private WebElement male;

	@FindBy(how = How.ID, using = "newDirectRadiobutton1")
	private WebElement female;

	@FindBy(how = How.ID, using = "newDirectRadiobutton2")
	private WebElement other;

	@FindBy(how = How.ID, using = "newDirectPatientSelectBtn")
	private WebElement searchBtn;

	@FindBy(how = How.ID, using = "searchNewDirectPatient")
	private WebElement searchUser;

	@FindBy(how = How.ID, using = "newDirectErrorDiv")
	private WebElement errorDiv;

	@FindBy(how = How.ID, using = "newDirectAge")
	private WebElement ageField;

	@FindBy(how = How.ID, using = "newDirectDay")
	private WebElement dayField;

	@FindBy(how = How.ID, using = "newDirectMonth")
	private WebElement monthField;

	@FindBy(how = How.ID, using = "newDirectYear")
	private WebElement yearField;

	@FindBy(how = How.ID, using = "newClearDirectUpdate")
	private WebElement clearBtn;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span")
	private WebElement searchBox;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"col-md-3 col-sm-3 col-xs-3\"])[2]")
	private WebElement test1;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"col-md-3 col-sm-3 col-xs-3\"])[3]")
	private WebElement test2;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"col-md-3 col-sm-3 col-xs-3\"])[4]")
	private WebElement test3;

	@FindBy(how = How.ID, using = "calculateTotalAmount")
	private WebElement totalAmt;

	@FindBy(how = How.CLASS_NAME, using = "close")
	private WebElement closeCalculator;

	@FindBy(how = How.ID, using = "alternateMobile")
	private WebElement alternateMobile;

	@FindBy(how = How.ID, using = "newDirectHeight")
	private WebElement height;

	@FindBy(how = How.ID, using = "newDirectWeight")
	private WebElement weight;

	@FindBy(how = How.ID, using = "newPincode")
	private WebElement pincode;

	@Autowired
	WebContext webContext;

	@Autowired
	CommonMethods commonMethods;

	@PostConstruct
	public void loadDriver() throws Exception {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}

	public String getErrorMessage() {
		return errorText.getText();
	}

	public User verifyRegistrationFields() throws Exception {

		User user = new User();

		user.setName(firstName.getAttribute("value"));
		user.setAge(ageField.getAttribute("value"));
		if (male.isSelected()) {
			user.setGender(male.getAttribute("value"));
		} else if (female.isSelected()) {
			user.setGender(female.getAttribute("value"));
		} else if (other.isSelected()) {
			user.setGender(other.getAttribute("value"));
		} else {
			user.setGender("");
		}
		user.setEmail(email.getAttribute("value"));
		user.setPhoneNumber(phoneNumber.getAttribute("value"));
		user.setAlternateNumber(alternateMobile.getAttribute("value"));
		user.setHeight(height.getAttribute("value"));
		user.setWeight(weight.getAttribute("value"));
		pincode.clear();
		user.setPincode(pincode.getAttribute("value"));

		return user;
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
	}

	public User searchUserByName(User outUser) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(outUser.getName().toLowerCase()).build().perform();

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span"));

		dropDowns.get(0).click();

		CommonMethods.waitForElementToClickable(firstName);

		outUser.setName(firstName.getAttribute("value"));
		outUser.setAge(ageField.getAttribute("value"));
		outUser.setGender(male.getAttribute("value"));
		outUser.setEmail(email.getAttribute("value"));
		outUser.setPhoneNumber(phoneNumber.getAttribute("value"));
		outUser.setAlternateNumber(alternateMobile.getAttribute("value"));
		outUser.setHeight(height.getAttribute("value"));
		outUser.setWeight(weight.getAttribute("value"));
		outUser.setPincode(pincode.getAttribute("value"));
		
		DriverFactory.getDriver().navigate().refresh();

		return outUser;

	}

	public User searchUserByPhoneNumber(User outUser) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(outUser.getPhoneNumber()).build().perform();

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span"));

		dropDowns.get(0).click();

		CommonMethods.waitForElementToClickable(firstName);

		outUser.setName(firstName.getAttribute("value"));
		outUser.setAge(ageField.getAttribute("value"));
		outUser.setGender(male.getAttribute("value"));
		outUser.setEmail(email.getAttribute("value"));
		outUser.setPhoneNumber(phoneNumber.getAttribute("value"));
		outUser.setAlternateNumber(alternateMobile.getAttribute("value"));
		outUser.setHeight(height.getAttribute("value"));
		outUser.setWeight(weight.getAttribute("value"));
		outUser.setPincode(pincode.getAttribute("value"));

		DriverFactory.getDriver().navigate().refresh();

		return outUser;

	}

	public User clearButton(User inputUser) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(inputUser.getName().toLowerCase()).build().perform();

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span")));

		builder.moveToElement(
				searchUser.findElement(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span"))).click()
				.build().perform();

		builder.sendKeys(Keys.DOWN);

		CommonMethods.waitForElementToClickable(firstName);

		String name = firstName.getAttribute("value");

		if (name.equalsIgnoreCase(inputUser.getName())) {
			CommonMethods.waitForElementToClickable(clearBtn);
			clearBtn.click();
			CommonMethods.waitForElementToClickable(firstName);

			inputUser.setName(firstName.getAttribute("value"));
			inputUser.setAge(ageField.getAttribute("value"));
			inputUser.setEmail(email.getAttribute("value"));
			if (male.isSelected()) {
				inputUser.setGender(male.getAttribute("value"));
			} else if (female.isSelected()) {
				inputUser.setGender(female.getAttribute("value"));
			} else if (other.isSelected()) {
				inputUser.setGender(other.getAttribute("value"));
			} else {
				inputUser.setGender("");
			}
			inputUser.setPhoneNumber(phoneNumber.getAttribute("value"));
			inputUser.setAlternateNumber(alternateMobile.getAttribute("value"));
			inputUser.setWeight(weight.getAttribute("value"));
			inputUser.setHeight(height.getAttribute("value"));
			inputUser.setPincode(pincode.getAttribute("value"));

			DriverFactory.getDriver().navigate().refresh();

			return inputUser;
		} else {
			DriverFactory.getDriver().navigate().refresh();

			return inputUser;
		}

	}

	public String testCalculator(List<String> testList) throws Exception {

		int attempts = 0;
		while (attempts < 2) {
			try {

				Actions builder = new Actions(DriverFactory.getDriver());

				CommonMethods.waitForElementToClickable(calculator);

				calculator.click();

				for (String test : testList) {

					typeTestName.sendKeys(test);

					WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("/html/body/div[18]/div/div/div[2]/div[6]/span/span")));

					builder.moveToElement(
							typeTestName.findElement(By.xpath("/html/body/div[18]/div/div/div[2]/div[6]/span/span")))
							.click().build().perform();

					builder.sendKeys(Keys.ARROW_DOWN);

				}

				WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calculateTotalAmount")));

				int t1 = Integer.parseInt(test1.getText());
				int t2 = Integer.parseInt(test2.getText());
				int t3 = Integer.parseInt(test3.getText());

				String addition = String.valueOf(t1 + t2 + t3);

				if (addition.equals(totalAmt.getText())) {

					return totalAmt.getText();
				}

			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}

		return null;
	}
	
	public User registerUser(User inUser) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());
		
		Select type = new Select(userType);
		type.selectByValue(inUser.getUserType());

		Select desig = new Select(designation);
		desig.selectByValue(inUser.getDesignation());

		email.sendKeys(inUser.getEmail());
		firstName.sendKeys(inUser.getName());
		ageField.sendKeys(inUser.getAge());
		alternateMobile.sendKeys(inUser.getAlternateNumber());
		height.sendKeys(inUser.getHeight());
		weight.sendKeys(inUser.getWeight());
		phoneNumber.sendKeys(inUser.getPhoneNumber());
		pincode.sendKeys(inUser.getPincode());
		
		if (inUser.getDesignation().equals("Dr.")) {
			((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].checked = true;",
					male);
		}
		if (inUser.getDesignation().equals("B/O")) {
			((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].checked = true;",
					female);
		}
		if (inUser.getDesignation().equals("Baby")) {
			((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].checked = true;",
					male);
		}

		saveForm.click();
		CommonMethods.waitForElementToClickable(testList);
		Thread.sleep(1000);

		registerUrl.click();

		return searchUserByName(inUser);
	}

	public boolean matchDesignationWithGender(String inputDesig) throws Exception {

		int attempts = 0;
		while (attempts<2) {
			try {
				boolean gender = false;

				Select desig = new Select(designation);
				desig.selectByValue(inputDesig);

				if (inputDesig.equals("Mr.")) {

					gender = male.isSelected();
					DriverFactory.getDriver().navigate().refresh();
					return gender;
				}
				if (inputDesig.equals("Mrs.")) {

					gender = female.isSelected();
					DriverFactory.getDriver().navigate().refresh();
					return gender;
				}

				DriverFactory.getDriver().navigate().refresh();

			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return false;
	}
	
	public boolean notNullFields(User user) throws Exception {
		boolean isErrorMsgDisplayed = false;
		CommonMethods.waitForElementToClickable(saveForm);

		Select desig = new Select(designation);
		desig.selectByValue(user.getDesignation());

		firstName.sendKeys(user.getName());
		ageField.sendKeys(user.getAge());

		saveForm.click();
		isErrorMsgDisplayed = errorDiv.isDisplayed();

		DriverFactory.getDriver().navigate().refresh();

		return isErrorMsgDisplayed;

	}
	
	public String ageAutoCalculator(Age age) throws Exception {
		Select day = new Select(dayField);
		day.selectByValue(age.getDay());

		Select month = new Select(monthField);
		month.selectByValue(age.getMonth());

		Select year = new Select(yearField);
		year.selectByValue(age.getYear());

		CommonMethods.waitForElementToClickable(ageField);

		String calculatedAge = ageField.getAttribute("value");

		if (calculatedAge.length() > 0) {

			DriverFactory.getDriver().navigate().refresh();
			return calculatedAge;
		}
		return null;
	}
	
	public User isRegisteredUnder(User user) throws Exception {

		int attempts = 0;
		while (attempts < 2) {
			try {

				Actions builder = new Actions(DriverFactory.getDriver());
				CommonMethods.waitForElementToClickable(firstName);

				firstName.sendKeys(user.getName());
				ageField.sendKeys(user.getAge());
				alternateMobile.sendKeys(user.getAlternateNumber());
				height.sendKeys(user.getHeight());
				weight.sendKeys(user.getWeight());
				pincode.sendKeys(user.getPincode());

				if (user.getGender().equals("Male")) {
					((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].checked = true;",
							male);

				} else {
					female.click();
				}

				saveForm.click();

				Thread.sleep(1000);
				CommonMethods.waitForElementToClickable(registerUrl);
				registerUrl.click();

				CommonMethods.waitForElementToClickable(searchBtn);
				searchBtn.click();

				builder.moveToElement(searchUser).click().sendKeys(user.getName().toLowerCase()).build().perform();

				WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span")));

				List<WebElement> dropDowns = DriverFactory.getDriver()
						.findElements(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span"));

				dropDowns.get(0).click();
				CommonMethods.waitForElementToClickable(firstName);

				if (male.isSelected()) {
					user.setGender("Male");
				} else if (female.isSelected()) {
					user.setGender("Female");
				}
				user.setAlternateNumber(alternateMobile.getAttribute("value"));
				user.setHeight(height.getAttribute("value"));
				user.setWeight(weight.getAttribute("value"));
				user.setPincode(pincode.getAttribute("value"));
				DriverFactory.getDriver().navigate().refresh();

				return user;
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;
	}

}
