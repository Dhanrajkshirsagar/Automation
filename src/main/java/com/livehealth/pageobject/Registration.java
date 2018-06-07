package com.livehealth.pageobject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
import com.livehealth.model.TestList;
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

	@FindBy(how = How.ID, using = "newDirectOrganization")
	private WebElement organization;

	@FindBy(how = How.ID, using = "newDirectAddOrganization")
	private WebElement addOrganizationBtn;

	@FindBy(how = How.ID, using = "orgnName")
	private WebElement orgnName;

	@FindBy(how = How.ID, using = "addOrgButton")
	private WebElement addOrgButton;

	@FindBy(how = How.ID, using = "newDirectBillReferal")
	private WebElement referrel;

	@FindBy(how = How.ID, using = "newDirectAddDoctor")
	private WebElement addReferel;

	@FindBy(how = How.ID, using = "doctorName")
	private WebElement referrelName;

	@FindBy(how = How.ID, using = "addDoctorButton")
	private WebElement addReferrelButton;

	@FindBy(how = How.CLASS_NAME, using = "dropdown-menu dropdown-menu-left")
	private WebElement referrelDesig;

	@FindBy(how = How.LINK_TEXT, using = "Admin")
	private WebElement admin;

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

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[1]/div[2]/div[1]/div[2]/button")
	private WebElement settings;

	@FindBy(how = How.ID, using = "orgListOrTypeFlag")
	private WebElement orgFlag;

	@FindBy(how = How.XPATH, using = "(//button[@id=\"savebillSetting\"])[1]")
	private WebElement savebillSetting;

	@FindBy(how = How.ID, using = "newDirectOrganizationTypeahead")
	private WebElement searchOrg;

	@FindBy(how = How.ID, using = "newPincode")
	private WebElement pincode;

	@FindBy(how = How.LINK_TEXT, using = "Add / Edit Referral")
	private WebElement addEditReferel;

	@FindBy(how = How.ID, using = "editReferralTab")
	private WebElement editReferralTab;

	@FindBy(how = How.ID, using = "referralEditList")
	private WebElement referralEditList;

	@FindBy(how = How.ID, using = "deleteRefButton")
	private WebElement deleteRefButton;

	@FindBy(how = How.ID, using = "deletebtn")
	private WebElement deletebtn;

	@FindBy(how = How.LINK_TEXT, using = "Upload Documents")
	private WebElement uploadDocuments;

	@FindBy(how = How.ID, using = "proofType")
	private WebElement proofType;

	@FindBy(how = How.ID, using = "proofID")
	private WebElement proofID;

	@FindBy(how = How.ID, using = "filesContent")
	private WebElement filesContent;

	@FindBy(how = How.XPATH, using = "//input[@value=\"Upload\"]")
	private WebElement uploadProofFile;

	@FindBy(how = How.ID, using = "referralDocList")
	private WebElement referralDocList;

	@FindBy(how = How.ID, using = "newDirectReferralDocTypeahead")
	private WebElement searchReferrel;

	@FindBy(how = How.ID, using = "selectReferalEditDesignation")
	private WebElement selectReferalEditDesignation;

	@FindBy(how = How.ID, using = "selectRefDoctorAddDesignation")
	private WebElement selectRefDesig;

	@FindBy(how = How.LINK_TEXT, using = "Dr.")
	private WebElement refDesig;

	@FindBy(how = How.ID, using = "newFileInputprofile")
	private WebElement newFileInputprofile;

	@FindBy(how = How.XPATH, using = "(//div[@class=\"jcrop-tracker\"])[1]")
	private WebElement uploadProfilePic;

	// @FindBy(how = How.XPATH, using =
	// "/html/body/section/div[2]/div[1]/div[2]/div[6]/div[32]/div[3]/div/div[2]")
	// private WebElement uploadProfilePic;

	@FindBy(how = How.LINK_TEXT, using = "View Documents")
	private WebElement viewDocuments;

	@FindBy(how = How.XPATH, using = "/html/body/div[17]/div/div/div[3]/button[2]")
	private WebElement clickDone;

	@FindBy(how = How.LINK_TEXT, using = "View")
	private WebElement view;

	@FindBy(how = How.ID, using = "patientTypeBillSetting")
	private WebElement patientTypeBillSetting;

	@FindBy(how = How.ID, using = "defaultDocReferral")
	private WebElement defaultDocReferral;

	@FindBy(how = How.ID, using = "defaultOrganization")
	private WebElement defaultOrganization;

	@FindBy(how = How.ID, using = "newDirectProceedBilling")
	private WebElement proceedToBilling;

	@FindBy(how = How.ID, using = "showCardnumber")
	private WebElement showCardnumber;

	@FindBy(how = How.ID, using = "newDirectCardNumber")
	private WebElement newDirectCardNumber;

	@FindBy(how = How.XPATH, using = "//a[@onclick=\"setCardNumber(0)\"]")
	private WebElement firstCard;

	@FindBy(how = How.XPATH, using = "//a[@onclick=\"setCardNumber(1)\"]")
	private WebElement secondCard;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div[1]/div[2]/div[6]/div[8]/div/div/button")
	private WebElement cardListDropDown;

	@FindBy(how = How.XPATH, using = "/html/body/div[17]/div/div/div[1]/button")
	private WebElement closeView;

	@FindBy(how = How.XPATH, using = "/html/body/div[18]/div/div/div[1]/button")
	private WebElement closeCal;

	@FindBy(how = How.ID, using = "strictCheck")
	private WebElement strictCheck;

	@FindBy(how = How.XPATH, using = "//*[@id=\"changeDetailsTxt\"]/label[2]")
	private WebElement registrationDate;

	@FindBy(how = How.ID, using = "showReportsCheckbox")
	private WebElement showReportsCheckbox;

	@FindBy(how = How.XPATH, using = "(//span[@id=\"billTotalAmount\"])[1]")
	private WebElement billAmt;

	@FindBy(how = How.XPATH, using = "(//span[@id=\"billTotalAmount\"])[2]")
	private WebElement bill_Two;

	@FindBy(how = How.XPATH, using = "(//span[@id=\"billTotalAmount\"])[3]")
	private WebElement bill_Three;

	@FindBy(how = How.XPATH, using = "(//span[@id=\"billTotalAmount\"])[4]")
	private WebElement bill_Four;

	@FindBy(how = How.XPATH, using = "/html/body/div[13]/div/div/div[4]/button[1]")
	private WebElement cancelUpdate;

	@FindBy(how = How.LINK_TEXT, using = "Advanced Search")
	private WebElement advancedSearch;

	@FindBy(how = How.ID, using = "searchBillInfo")
	private WebElement searchBillInfo;

	@FindBy(how = How.ID, using = "searchByName")
	private WebElement searchByName;

	@FindBy(how = How.ID, using = "btnAdvSearchBill")
	private WebElement btnAdvSearchBill;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[2]/div[9]/div[2]/ul/li/p[5]")
	private WebElement billOne;

	@FindBy(how = How.XPATH, using = "/html/body/div[13]/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div/div/label")
	private WebElement testName;

	@FindBy(how = How.XPATH, using = "/html/body/div[13]/div/div/div[2]/div[3]/div[1]/div[2]/div/div/div/div/p/span")
	private WebElement testStatus;

	@FindBy(how = How.ID, using = "searchUserInfo")
	private WebElement searchUserInfo;

	@FindBy(how = How.ID, using = "searchByuserName")
	private WebElement searchByuserName;

	@FindBy(how = How.ID, using = "btnSearchUser")
	private WebElement btnSearchUser;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[3]/div[9]/div[1]/ul/li/div[1]/p[6]")
	private WebElement clickToOpen;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[3]/div[9]/div[1]/ul/li/div[2]/ul[2]/li/p[1]")
	private WebElement tName;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[3]/div[3]/div[9]/div[1]/ul/li/div[2]/ul[2]/li/p[2]/span")
	private WebElement tStatus;

	@FindBy(how = How.LINK_TEXT, using = "Privilege Card Management")
	private WebElement cardManagement;

	@FindBy(how = How.LINK_TEXT, using = "Assign Cards")
	private WebElement assignCards;

	@FindBy(how = How.ID, using = "searchPatient")
	private WebElement searchPatient;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div/div[4]/div[2]/div[2]/li[2]/div[1]/div[2]")
	private WebElement cardOne;

	@FindBy(how = How.XPATH, using = "/html/body/section/div[2]/div/div[4]/div[2]/div[2]/li[3]/div[1]/div[2]")
	private WebElement cardTwo;

	@FindBy(how = How.ID, using = "adminPasswordForDeauthTxt")
	private WebElement adminPasswordForDeauthTxt;

	@FindBy(how = How.ID, using = "adminPasswordForDeauth")
	private WebElement adminPasswordForDeauth;

	@FindBy(how = How.ID, using = "btnUpdateConfirm")
	private WebElement btnUpdateConfirm;
	//
	@FindBy(how = How.XPATH, using = "//*[@id=\"newDirectErrorDiv\"]/div/strong")
	private WebElement newDirectErrorDiv;

	@FindBy(how = How.LINK_TEXT, using = "Operation")
	private WebElement operation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hoverDropdown\"]/a")
	private WebElement departmentsDropDown;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hoverDropdown\"]/ul/li[13]/a")
	private WebElement allDepartments;

	@FindBy(how = How.XPATH, using = "//*[@id=\"userWaiting1932\"]/div/div[1]/span[2]/b")
	private WebElement userWaiting;

	@FindBy(how = How.XPATH, using = "//*[@id=\"labels4431\"]/span[2]/b")
	private WebElement clickOnTest;

	@FindBy(how = How.XPATH, using = "//label[@class=\"label reportViewStatusLabel\"]")
	private WebElement pendingApproval;

	@FindBy(how = How.ID, using = "quickDefaultDocPass")
	private WebElement quickDefaultDocPass;

	@FindBy(how = How.ID, using = "quickSubmitBtn")
	private WebElement quickSubmitBtn;

	@FindBy(how = How.ID, using = "btnCreateNewReg")
	private WebElement btnCreateNewReg;

	@FindBy(how = How.ID, using = "filterReferralByOrgFlag")
	private WebElement filterReferral;

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
		System.out.println("login done");
	//	CommonMethods.waitForElementToClickable(registration);
		registration.click();
		System.out.println("login done 2");

	}

	public void selectSearchingUser() throws Exception {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[5]/span/span"));

		dropDowns.get(0).click();

		CommonMethods.waitForElementToClickable(firstName);
	}

	public User searchUserByName(User outUser) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(outUser.getName().toLowerCase()).build().perform();

		selectSearchingUser();

		outUser.setName(firstName.getAttribute("value"));
		outUser.setAge(ageField.getAttribute("value"));
		outUser.setGender(male.getAttribute("value"));
		outUser.setEmail(email.getAttribute("value"));
		outUser.setPhoneNumber(phoneNumber.getAttribute("value"));
		outUser.setAlternateNumber(alternateMobile.getAttribute("value"));
		outUser.setHeight(height.getAttribute("value"));
		outUser.setWeight(weight.getAttribute("value"));
		outUser.setPincode(pincode.getAttribute("value"));
		outUser.setUserType(userType.getAttribute("value"));

		DriverFactory.getDriver().navigate().refresh();

		return outUser;

	}

	public User searchUserByPhoneNumber(User outUser) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(outUser.getPhoneNumber()).build().perform();

		selectSearchingUser();

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

		DriverFactory.getDriver().navigate().refresh();

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(inputUser.getName().toLowerCase()).build().perform();

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"searchNewDirectPatientDiv\"]/span/span/div[2]")));

		builder.moveToElement(
				searchUser.findElement(By.xpath("//*[@id=\"searchNewDirectPatientDiv\"]/span/span/div[2]"))).click()
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
					String total = totalAmt.getText();
					closeCal.click();
					return total;
				}

			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}

		return null;
	}

	public User registerUser(User inUser) throws Exception {

		int attempts = 0;
		while (attempts < 2) {
			try {

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
				DriverFactory.getDriver().navigate().refresh();

				CommonMethods.waitForElementToClickable(registerUrl);
				Thread.sleep(1000);

				registerUrl.click();

				return searchUserByName(inUser);

			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;
	}

	public boolean matchDesignationWithGender(String inputDesig) throws Exception {

		int attempts = 0;
		while (attempts < 2) {
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

		int attempts = 0;
		while (attempts < 2) {
			try {
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
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
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

				selectSearchingUser();

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

	public void selectUnselectOrgList() throws Exception {

		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(orgFlag);

		if (orgFlag.isSelected()) {
			orgFlag.click();
		} else {
			orgFlag.click();
		}

		CommonMethods.waitForElementToClickable(referralDocList);

		if (referralDocList.isSelected()) {
			referralDocList.click();
		} else {
			referralDocList.click();
		}
		CommonMethods.waitForElementToClickable(savebillSetting);

		savebillSetting.click();
	}

	public String searchOrganizationName(String organizationName) throws Exception {
		int attempts = 0;
		while (attempts < 2) {
			try {
				String searchedOrg;

				selectUnselectOrgList();

				CommonMethods.waitForElementToClickable(searchOrg);
				searchOrg.clear();
				searchOrg.sendKeys(organizationName);

				List<WebElement> dropDowns = DriverFactory.getDriver().findElements(
						By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[6]/div[17]/div[3]/span/span"));

				if (dropDowns.size() > 0) {
					dropDowns.get(0).click();
					searchedOrg = searchOrg.getAttribute("value");

					DriverFactory.getDriver().navigate().refresh();
					CommonMethods.waitForElementToClickable(settings);

					selectUnselectOrgList();
					return searchedOrg;
				}
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;
	}

	public String addOrganization(String orgName) throws Exception {
		int attempts = 0;
		while (attempts < 2) {
			try {
				Actions builder = new Actions(DriverFactory.getDriver());

				CommonMethods.waitForElementToClickable(addOrganizationBtn);
				addOrganizationBtn.click();

				CommonMethods.waitForElementToClickable(orgnName);
				orgnName.sendKeys(orgName);

				addOrgButton.click();

				CommonMethods.waitForElementToClickable(organization);

				List<WebElement> listElements = organization
						.findElements(By.xpath("//select[@id=\"newDirectOrganization\"]//*"));

				for (WebElement element : listElements) {

					String searchedOrg = element.getText().trim();

					if (searchedOrg.equalsIgnoreCase(orgName)) {

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
						wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("/html/body/section/div[2]/div[1]/div[4]/div/div/span/span")));

						builder.moveToElement(orgEditList
								.findElement(By.xpath("/html/body/section/div[2]/div[1]/div[4]/div/div/span/span")))
								.click().build().perform();

						builder.sendKeys(Keys.DOWN);

						CommonMethods.waitForElementToClickable(orgDeleteButton);
						orgDeleteButton.click();

						CommonMethods.waitForElementToClickable(orgDelete);
						orgDelete.click();

						CommonMethods.waitForElementToClickable(adminHover);
						builder.moveToElement(adminHover).build().perform();

						CommonMethods.waitForElementToClickable(registration);
						registration.click();
						CommonMethods.waitForElementToClickable(firstName);

						return searchedOrg;
					}
				}
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;
	}

	public String searchReferrelName(String referrelName) throws Exception {
		int attempts = 0;
		while (attempts < 2) {
			try {
				String searchedRef;
				// Thread.sleep(1000);
				selectUnselectOrgList();

				CommonMethods.waitForElementToClickable(searchReferrel);

				searchReferrel.sendKeys(referrelName);
				List<WebElement> dropDowns = DriverFactory.getDriver()
						.findElements(By.xpath("/html/body/section/div[2]/div[1]/div[2]/div[6]/div[20]/span/span"));
				// //div[@class=\"tt-dataset-23\"]

				if (dropDowns.size() > 0) {
					dropDowns.get(0).click();
					searchedRef = searchReferrel.getAttribute("value");

					DriverFactory.getDriver().navigate().refresh();
					CommonMethods.waitForElementToClickable(settings);

					selectUnselectOrgList();
					return searchedRef;
				}
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;

	}

	public List<String> addReferel(String refName) throws Exception {
		int attempts = 0;
		while (attempts < 2) {
			try {
				Actions builder = new Actions(DriverFactory.getDriver());

				CommonMethods.waitForElementToClickable(addReferel);
				addReferel.click();

				CommonMethods.waitForElementToClickable(selectRefDesig);
				selectRefDesig.click();
				refDesig.click();

				CommonMethods.waitForElementToClickable(referrelName);
				referrelName.sendKeys(refName);

				addReferrelButton.click();
				Thread.sleep(1000);
				CommonMethods.waitForElementToClickable(referrel);
				List<WebElement> listElements = referrel
						.findElements(By.xpath("//select[@id=\"newDirectBillReferal\"]//*"));

				for (WebElement element : listElements) {

					String searchedReferel = element.getText().trim();

					if (searchedReferel.equalsIgnoreCase(refName)) {

						CommonMethods.waitForElementToClickable(adminHover);

						builder.moveToElement(adminHover).build().perform();

						CommonMethods.waitForElementToClickable(admin);
						admin.click();

						CommonMethods.waitForElementToClickable(addEditReferel);
						addEditReferel.click();

						CommonMethods.waitForElementToClickable(editReferralTab);
						editReferralTab.click();

						CommonMethods.waitForElementToClickable(referralEditList);
						builder.moveToElement(referralEditList).click().sendKeys(refName).build().perform();

						WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//div[@class=\"tt-dataset-4\"]")));

						builder.moveToElement(referralEditList.findElement(By.xpath("//div[@class=\"tt-dataset-4\"]")))
								.click().build().perform();

						builder.sendKeys(Keys.DOWN);

						String refDesig = selectReferalEditDesignation.getText();

						List<String> referrel = new ArrayList<>();
						referrel.add(searchedReferel);
						referrel.add(refDesig);

						CommonMethods.waitForElementToClickable(deleteRefButton);
						deleteRefButton.click();

						CommonMethods.waitForElementToClickable(deletebtn);
						deletebtn.click();

						CommonMethods.waitForElementToClickable(adminHover);
						builder.moveToElement(adminHover).build().perform();

						CommonMethods.waitForElementToClickable(registration);
						registration.click();

						return referrel;
					}
				}
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;
	}

	public String uploadFile(User user) throws Exception {

		CommonMethods.waitForElementToClickable(uploadDocuments);
		uploadDocuments.click();

		CommonMethods.waitForElementToClickable(proofType);
		Select getProofType = new Select(proofType);
		getProofType.selectByValue("Aadhar Card");

		proofID.sendKeys("123");

		File tempfile = new File("src/main/resources/livehealth.png");

		filesContent.sendKeys(tempfile.getAbsolutePath());
		uploadProofFile.click();

		clickDone.click();

		CommonMethods.waitForElementToClickable(firstName);
		firstName.sendKeys(user.getName());
		ageField.sendKeys(user.getAge());
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].checked = true;", male);

		saveForm.click();

		DriverFactory.getDriver().navigate().refresh();
		Thread.sleep(1000);
		CommonMethods.waitForElementToClickable(registerUrl);
		registerUrl.click();

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(user.getName().toLowerCase()).build().perform();

		selectSearchingUser();

		firstName.clear();
		CommonMethods.waitForElementToClickable(viewDocuments);
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click();", viewDocuments);
		CommonMethods.waitForElementToClickable(view);

		String text = view.getText().trim();
		closeView.click();
		DriverFactory.getDriver().navigate().refresh();

		return text;
	}

	public void addingProfilePic() throws Exception {

		// boolean notDisplayed=uploadProfilePic.isDisplayed();
		File tempfile = new File("src/main/resources/livehealth.png");

		// System.out.println("notDisplayed=="+notDisplayed);
		// Actions builder = new Actions(DriverFactory.getDriver());
		// builder.moveToElement(newFileInputprofile).sendKeys(tempfile.getAbsolutePath());

		newFileInputprofile.sendKeys(tempfile.getAbsolutePath());
		boolean displayed = uploadProfilePic.isDisplayed();

		System.out.println("displayed==" + displayed);
		//
		// if(displayed) {
		// return true;
		// }
		// return false;

	}

	public String defaultUserTypeSettings(String defaultUserType) throws Exception {

		int attempts = 0;
		while (attempts < 2) {
			try {
				DriverFactory.getDriver().navigate().refresh();
				CommonMethods.waitForElementToClickable(settings);
				settings.click();

				CommonMethods.waitForElementToClickable(patientTypeBillSetting);

				patientTypeBillSetting.click();
				Select userTypeSetting = new Select(patientTypeBillSetting);
				userTypeSetting.selectByVisibleText(defaultUserType);

				savebillSetting.click();

				CommonMethods.waitForElementToClickable(userType);

				Select select = new Select(userType);
				WebElement tmp = select.getFirstSelectedOption();

				return tmp.getText().trim();
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;

	}

	public String defaultReferrelSettings(String defaultReferrel) throws Exception {

		int attempts = 0;
		while (attempts < 2) {
			try {
				CommonMethods.waitForElementToClickable(settings);
				settings.click();

				CommonMethods.waitForElementToClickable(defaultDocReferral);

				defaultDocReferral.click();
				Select userTypeSetting = new Select(defaultDocReferral);
				userTypeSetting.selectByVisibleText(defaultReferrel);

				savebillSetting.click();

				DriverFactory.getDriver().navigate().refresh();
				
				CommonMethods.waitForElementToClickable(referrel);

				Select select = new Select(referrel);
				WebElement tmp = select.getFirstSelectedOption();
				CommonMethods.waitForElementToClickable(firstName);

				return tmp.getText().trim();

			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;

	}

	public String defaultOrganizationSettings(String defaultOrg) throws Exception {

		int attempts = 0;
		while (attempts < 2) {
			try {
				CommonMethods.waitForElementToClickable(settings);
				settings.click();

				CommonMethods.waitForElementToClickable(defaultOrganization);

				defaultOrganization.click();
				Select userTypeSetting = new Select(defaultOrganization);
				userTypeSetting.selectByVisibleText(defaultOrg);

				savebillSetting.click();

				DriverFactory.getDriver().navigate().refresh();

				CommonMethods.waitForElementToClickable(organization);

				Select select = new Select(organization);
				WebElement tmp = select.getFirstSelectedOption();
				CommonMethods.waitForElementToClickable(firstName);

				return tmp.getText().trim();

			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;

	}

	public User userTypeWithOrWithoutMobileNumber(User user) throws Exception {

		int attempts = 0;
		while (attempts < 2) {
			try {
				CommonMethods.waitForElementToClickable(firstName);

				Select desig = new Select(designation);
				desig.selectByValue(user.getDesignation());

				firstName.sendKeys(user.getName());
				ageField.sendKeys(user.getAge());

				if (user.getPhoneNumber() != null) {

					phoneNumber.sendKeys(user.getPhoneNumber());
				}

				CommonMethods.waitForElementToClickable(female);

				if (user.getAlternateNumber() != null) {

					alternateMobile.sendKeys(user.getAlternateNumber());
				}
				saveForm.click();

				Thread.sleep(1000);
				CommonMethods.waitForElementToClickable(registerUrl);
				registerUrl.click();

				return searchUserByName(user);

			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;

	}

	public User updateExistingUser(User updateUser) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(updateUser.getName().toLowerCase()).build().perform();

		selectSearchingUser();

		CommonMethods.waitForElementToClickable(alternateMobile);

		alternateMobile.clear();
		alternateMobile.sendKeys(updateUser.getAlternateNumber());
		CommonMethods.waitForElementToClickable(saveForm);
		saveForm.click();

		DriverFactory.getDriver().navigate().refresh();

		return searchUserByName(updateUser);

	}

	public String updateAndProceedToBilling(User updateUser) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(updateUser.getName().toLowerCase()).build().perform();

		selectSearchingUser();

		CommonMethods.waitForElementToClickable(alternateMobile);

		alternateMobile.clear();
		alternateMobile.sendKeys(updateUser.getAlternateNumber());

		proceedToBilling.click();
		CommonMethods.waitForElementToClickable(testList);

		String pageTitle = DriverFactory.getDriver().getTitle();
		Thread.sleep(1000);
		CommonMethods.waitForElementToClickable(registerUrl);
		registerUrl.click();
		CommonMethods.waitForElementToClickable(firstName);

		return pageTitle.trim();

	}

	public void checkCardNumberListFlag() throws Exception {
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(showCardnumber);

		if (!showCardnumber.isSelected()) {
			showCardnumber.click();
		}
		CommonMethods.waitForElementToClickable(savebillSetting);
		savebillSetting.click();
	}

	public Boolean cardNumberListBox() throws Exception {

		checkCardNumberListFlag();

		return newDirectCardNumber.isDisplayed();

	}

	public List<String> showCardList(String username) throws Exception {
		int attempts = 0;
		while (attempts < 2) {
			try {
				Actions builder = new Actions(DriverFactory.getDriver());

				DriverFactory.getDriver().navigate().refresh();

				CommonMethods.waitForElementToClickable(searchBtn);
				searchBtn.click();
				builder.moveToElement(searchUser).click().sendKeys(username.toLowerCase()).build().perform();

				selectSearchingUser();

				cardListDropDown.click();

				String cardFirst = firstCard.getText().substring(0, 7).trim();
				String cardSecond = secondCard.getText().substring(0, 7).trim();

				List<String> cardList = new ArrayList<>();
				cardList.add(cardFirst);
				cardList.add(cardSecond);

				return cardList;
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;
	}

	public Boolean strictCheckCheckBoxAvailibility() throws Exception {
		int attempts = 0;
		while (attempts < 2) {
			try {
				CommonMethods.waitForElementToClickable(settings);
				settings.click();

				CommonMethods.waitForElementToClickable(strictCheck);
				boolean isShown = strictCheck.isDisplayed();
				CommonMethods.waitForElementToClickable(savebillSetting);
				savebillSetting.click();
				CommonMethods.waitForElementToClickable(firstName);

				return isShown;
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;
	}

	public String confirmationModel(User updateUser) throws Exception {
		int attempts = 0;
		while (attempts < 2) {
			try {
				Actions builder = new Actions(DriverFactory.getDriver());

				CommonMethods.waitForElementToClickable(searchBtn);
				searchBtn.click();

				builder.moveToElement(searchUser).click().sendKeys(updateUser.getName().toLowerCase()).build()
						.perform();

				selectSearchingUser();

				CommonMethods.waitForElementToClickable(male);

				if (male.isSelected()) {
					female.click();
				} else {
					male.click();
				}

				saveForm.click();
				CommonMethods.waitForElementToClickable(registrationDate);

				return registrationDate.getText();
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;
	}

	private TestList determiningBillingDetails(User updateUser) throws Exception {

		TestList test = new TestList();

		confirmationModel(updateUser);

		CommonMethods.waitForElementToClickable(showReportsCheckbox);
		showReportsCheckbox.click();

		CommonMethods.waitForElementToClickable(billAmt);
		test.setTestAmount(billAmt.getText().trim());

		test.setTestName(testName.getText().trim());

		test.setTestStatus(testStatus.getText().trim());

		cancelUpdate.click();

		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(advancedSearch);

		advancedSearch.click();

		return test;
	}

	public List<TestList> billingDetails(User updateUser) throws Exception {

		TestList updateDetails = determiningBillingDetails(updateUser);

		searchByName.sendKeys(updateUser.getName());

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[3]/div[2]/div[1]/span/span")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[3]/div[2]/div[1]/span/span"));

		dropDowns.get(0).click();

		btnAdvSearchBill.click();

		TestList storedDetails = new TestList();

		storedDetails.setTestAmount(billOne.getText().trim());

		searchUserInfo.click();

		searchByuserName.sendKeys(updateUser.getName());

		WebDriverWait w = new WebDriverWait(DriverFactory.getDriver(), 10);
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/section/div[3]/div[3]/div[1]/span/span")));

		List<WebElement> dDowns = DriverFactory.getDriver()
				.findElements(By.xpath("/html/body/section/div[3]/div[3]/div[1]/span/span"));

		dDowns.get(0).click();

		btnSearchUser.click();

		new WebDriverWait(DriverFactory.getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/section/div[3]/div[3]/div[9]/div[1]/ul/li/div[1]/p[6]")));

		clickToOpen.click();
		new WebDriverWait(DriverFactory.getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/section/div[3]/div[3]/div[9]/div[1]/ul/li/div[2]/ul[2]/li/p[1]")));

		storedDetails.setTestName(tName.getText().trim());

		storedDetails.setTestStatus(tStatus.getText().trim());

		List<TestList> list = new ArrayList<>();
		list.add(updateDetails);
		list.add(storedDetails);

		return list;
	}

	public String updateWithStrictCheck(User updateUser) throws Exception {

		int attempts = 0;
		while (attempts < 2) {
			try {
				Actions builder = new Actions(DriverFactory.getDriver());

				DriverFactory.getDriver().navigate().refresh();

				CommonMethods.waitForElementToClickable(settings);
				settings.click();

				CommonMethods.waitForElementToClickable(strictCheck);

				if (!strictCheck.isSelected()) {
					strictCheck.click();
				}

				CommonMethods.waitForElementToClickable(savebillSetting);
				savebillSetting.click();

				DriverFactory.getDriver().navigate().refresh();

				CommonMethods.waitForElementToClickable(searchBtn);
				searchBtn.click();

				builder.moveToElement(searchUser).click().sendKeys(updateUser.getName().toLowerCase()).build()
						.perform();

				selectSearchingUser();

				CommonMethods.waitForElementToClickable(male);

				if (male.isSelected()) {
					female.click();
				} else {
					male.click();
				}

				saveForm.click();
				CommonMethods.waitForElementToClickable(adminPasswordForDeauthTxt);

				adminPasswordForDeauthTxt.sendKeys("livehealth20");
				adminPasswordForDeauth.click();

				CommonMethods.waitForElementToClickable(btnUpdateConfirm);

				btnUpdateConfirm.click();
				CommonMethods.waitForElementToClickable(newDirectErrorDiv);

				return newDirectErrorDiv.getText();
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;
	}

	public String updateWithoutStrictCheck(User updateUser) throws Exception {

		Actions builder = new Actions(DriverFactory.getDriver());

		DriverFactory.getDriver().navigate().refresh();
		CommonMethods.waitForElementToClickable(settings);
		settings.click();

		CommonMethods.waitForElementToClickable(strictCheck);

		if (strictCheck.isSelected()) {
			strictCheck.click();
		}

		CommonMethods.waitForElementToClickable(savebillSetting);
		savebillSetting.click();

		DriverFactory.getDriver().navigate().refresh();

		CommonMethods.waitForElementToClickable(searchBtn);
		searchBtn.click();

		builder.moveToElement(searchUser).click().sendKeys(updateUser.getName().toLowerCase()).build().perform();

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"searchNewDirectPatientDiv\"]/span/span/div[2]")));

		List<WebElement> dropDowns = DriverFactory.getDriver()
				.findElements(By.xpath("//*[@id=\"searchNewDirectPatientDiv\"]/span/span/div[2]"));

		dropDowns.get(0).click();

		CommonMethods.waitForElementToClickable(male);

		if (male.isSelected()) {
			female.click();
		} else {
			male.click();
		}

		saveForm.click();

		CommonMethods.waitForElementToClickable(btnUpdateConfirm);

		btnUpdateConfirm.click();

		CommonMethods.waitForElementToClickable(adminHover);

		builder.moveToElement(adminHover).build().perform();

		CommonMethods.waitForElementToClickable(operation);
		operation.click();

		CommonMethods.waitForElementToClickable(departmentsDropDown);

		builder.moveToElement(departmentsDropDown).build().perform();
		allDepartments.click();

		CommonMethods.waitForElementToClickable(userWaiting);

		userWaiting.click();
		clickOnTest.click();
		CommonMethods.waitForElementToClickable(pendingApproval);

		String approvalMsg = pendingApproval.getText();

		quickDefaultDocPass.sendKeys("livehealth20");
		CommonMethods.waitForElementToClickable(quickSubmitBtn);
		quickSubmitBtn.click();

		CommonMethods.waitForElementToClickable(adminHover);
		builder.moveToElement(adminHover).build().perform();

		CommonMethods.waitForElementToClickable(registration);
		registration.click();

		return approvalMsg.trim();
	}

	public String updateUserDetailsForDirectIndirect(User updateUser) throws Exception {

		int attempts = 0;
		while (attempts < 2) {
			try {
				Actions builder = new Actions(DriverFactory.getDriver());

				DriverFactory.getDriver().navigate().refresh();

				CommonMethods.waitForElementToClickable(settings);
				settings.click();

				CommonMethods.waitForElementToClickable(strictCheck);

				if (strictCheck.isSelected()) {
					strictCheck.click();
				}

				CommonMethods.waitForElementToClickable(savebillSetting);
				savebillSetting.click();

				DriverFactory.getDriver().navigate().refresh();

				CommonMethods.waitForElementToClickable(searchBtn);
				searchBtn.click();

				builder.moveToElement(searchUser).click().sendKeys(updateUser.getName().toLowerCase()).build()
						.perform();

				WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"searchNewDirectPatientDiv\"]/span/span/div[2]")));

				builder.moveToElement(
						searchUser.findElement(By.xpath("//*[@id=\"searchNewDirectPatientDiv\"]/span/span/div[2]")))
						.click().build().perform();

				builder.sendKeys(Keys.ARROW_DOWN);

				CommonMethods.waitForElementToClickable(male);

				if (male.isSelected()) {
					female.click();
				} else {
					male.click();
				}

				saveForm.click();

				CommonMethods.waitForElementToClickable(btnUpdateConfirm);

				btnUpdateConfirm.click();
				CommonMethods.waitForElementToClickable(newDirectErrorDiv);

				return newDirectErrorDiv.getText();
			} catch (StaleElementReferenceException e) {
				attempts++;
			}
		}
		return null;
	}

	public ArrayList<String> showAllAddedOrganizationNames() throws Exception {

		// if (!organization.isDisplayed()) {
		// DriverFactory.getDriver().navigate().refresh();
		//
		// CommonMethods.waitForElementToClickable(settings);
		// settings.click();
		//
		// CommonMethods.waitForElementToClickable(orgFlag);
		//
		// if (!orgFlag.isSelected()) {
		// orgFlag.click();
		// }
		// CommonMethods.waitForElementToClickable(savebillSetting);
		// savebillSetting.click();
		// DriverFactory.getDriver().navigate().refresh();
		// }

		Select selectOrg = new Select(organization);
		List<WebElement> options = selectOrg.getOptions();

		ArrayList<String> orgNames = new ArrayList<String>();

		for (WebElement element : options) {
			String org = element.getText().toLowerCase().trim();
			orgNames.add(org);
		}

		return orgNames;
	}

	public ArrayList<String> showAllAddedReferrelNames() throws Exception {

		Select selectOrg = new Select(referrel);
		List<WebElement> options = selectOrg.getOptions();

		ArrayList<String> orgNames = new ArrayList<String>();

		for (WebElement element : options) {
			String org = element.getText().toLowerCase().trim();
			orgNames.add(org);
		}

		return orgNames;
	}

	public ArrayList<String> filterReferrelByOrg() throws Exception {

//		DriverFactory.getDriver().navigate().refresh();
//
//		CommonMethods.waitForElementToClickable(settings);
//		settings.click();
//
//		if (!filterReferral.isSelected()) {
//			filterReferral.click();
//		}
//
//		CommonMethods.waitForElementToClickable(savebillSetting);
//		savebillSetting.click();

		DriverFactory.getDriver().navigate().refresh();

		Select selectOrg = new Select(organization);
		selectOrg.selectByVisibleText("postpaid Organization ");

		Select selectRef = new Select(referrel);
		List<WebElement> options = selectRef.getOptions();

		ArrayList<String> refNames = new ArrayList<String>();

		for (WebElement element : options) {
			String org = element.getText().trim();
			refNames.add(org);
		}

		return refNames;
	}
}
