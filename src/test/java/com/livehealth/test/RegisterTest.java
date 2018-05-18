package com.livehealth.test;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.livehealth.base.DriverFactory;
import com.livehealth.config.Constants;
import com.livehealth.model.Age;
import com.livehealth.model.User;
import com.livehealth.pageobject.HomePage;
import com.livehealth.pageobject.Registration;
import com.livehealth.util.CommonMethods;
import com.livehealth.validator.RegistrationValidator;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RegisterTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	Registration registration;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	RegistrationValidator registerValidator;

	@Autowired
	CommonMethods commonMethods;

	@BeforeClass(groups = { "Notnullfields", "Searching", "Registration", "SearchingOrgAndReferel" })
	public void launchSite() {
		try {
			registration = pageLaunch.launch();
			registration.signIn("auto-livehealth", "livehealth20");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	// TC: 01
	@Test(priority = 0)
	public void verifyRegistrationPage() {

		User registrationFields;
		try {
			User user = getBlankUser();
			registrationFields = registration.verifyRegistrationFields();
			registerValidator.verifyRegister(registrationFields, user);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 02
	@Test(groups = { "Searching" })
	public void isPatientGettingSearchedByName() {
		User searchedUser;
		try {
			User user = getSearchingUserDetails();

			searchedUser = registration.searchUserByName(user);

			registerValidator.verifyRegister(searchedUser, user);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());

		}
	}

	// TC: 03
	@Test(groups = { "Searching" })
	public void isPatientGettingSearchedByPhoneNumber() {
		User searchedUser;
		try {
			User user = getSearchingUserDetails();
			searchedUser = registration.searchUserByPhoneNumber(user);

			registerValidator.verifyRegister(searchedUser, user);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());

		}
	}

	// TC: 04
	// @Test(groups = { "Searching" })
	// public void isLatestRegisteredUserShowingFirst() {
	// User inputUser = new User();
	// try {
	// inputUser.setName("rohit");
	//
	// User searchedUser = registration.searchUser(inputUser);
	//
	// Assert.assertEquals(searchedUser.getName(), "Rohit2");
	//
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	//
	// }
	//
	// }

	// TC: 06
	@Test()
	public void verifyClearButton() {
		User searchedUser;
		try {
			User inputUser = getSearchingUserDetails();
			inputUser.setName("Akbrnmxj");

			searchedUser = registration.clearButton(inputUser);

			inputUser.setName(""); // checking with clear btn
			registerValidator.verifyRegister(searchedUser, inputUser);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());

		}
	}

	// TC: 07
	@Test(priority = 7)
	public void verifyCalculator() {
		List<String> testList = new ArrayList<>();
		testList.add("CPK, Total");
		testList.add("Cholesterol - Total");
		testList.add("Alkaline Phosphatase");
		String calcuulatedAmt;
		try {
			calcuulatedAmt = registration.testCalculator(testList);

			Assert.assertEquals(calcuulatedAmt, "750");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:08-16,18
	@Test(dataProvider = "typeOfUser", groups = { "Registration" })
	public void verifyUserType(String userType) {
		User inputUser = new User();
		String name = commonMethods.getRandomString();
		String phoneNo = commonMethods.getRandomNumber();
		User createdUser;
		try {
			inputUser.setName(name);
			inputUser.setDesignation("Mr.");
			inputUser.setAge("10");
			inputUser.setUserType(userType);
			inputUser.setEmail(Constants.EMAIL);
			inputUser.setAlternateNumber(phoneNo);
			inputUser.setHeight("6");
			inputUser.setWeight("51");
			inputUser.setPhoneNumber(phoneNo);
			inputUser.setPincode("461157");
			inputUser.setGender("Male");

			createdUser = registration.registerUser(inputUser);

			registerValidator.verifyRegister(inputUser, createdUser);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC:19-20
	@Test(dataProvider = "mrAndMrs")
	public void verifyDesignationWithGender(String designation) {
		boolean selectedGender;
		try {
			selectedGender = registration.matchDesignationWithGender(designation);

			Assert.assertTrue(selectedGender);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// Tc:21-26
	@Test(dataProvider = "typeOfDesignation", groups = { "Registration" })
	public void verifyRegisteredUserDesignation(String desigType) {
		User inputUser = new User();
		String name = commonMethods.getRandomString();
		String phoneNo = commonMethods.getRandomNumber();
		User createdUser;
		try {
			inputUser.setName(name);
			inputUser.setDesignation(desigType);
			inputUser.setAge("10");
			inputUser.setUserType("D");
			inputUser.setEmail(Constants.EMAIL);
			inputUser.setAlternateNumber(phoneNo);
			inputUser.setHeight("6");
			inputUser.setWeight("51");
			inputUser.setPincode("461157");
			inputUser.setPhoneNumber(phoneNo);

			createdUser = registration.registerUser(inputUser);

			registerValidator.verifyRegister(inputUser, createdUser);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:27 error msg should be shown in case of null name field
	@Test(groups = { "Notnullfields" })
	public void verifyNameFieldNotNull() {
		boolean errorMsg;
		User user = new User();
		try {
			user.setDesignation("Mr.");
			user.setName("");
			user.setAge("10");

			errorMsg = registration.notNullFields(user);

			Assert.assertTrue(errorMsg);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:28 error msg should be shown in case of null age field
	@Test(groups = { "Notnullfields" })
	public void verifyAgeFieldNotNull() {
		boolean errorMsg;
		User user = new User();
		String name = commonMethods.getRandomString();

		try {
			user.setDesignation("Mr.");
			user.setName(name);
			user.setAge("");

			errorMsg = registration.notNullFields(user);

			Assert.assertTrue(errorMsg);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:29
	@Test(groups = { "Registration" })
	public void isAgeCalculating() {
		String calculatedAge;
		Age age = new Age();
		try {
			age.setDay("1");
			age.setMonth("1");
			age.setYear("1994");

			calculatedAge = registration.ageAutoCalculator(age);

			Assert.assertEquals(calculateAge(age) + " years", calculatedAge);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:30
	@Test(groups = { "Registration" })
	public void verifyGenderCheckBox() {
		String name = commonMethods.getRandomString();
		String phoneNum = commonMethods.getRandomNumber();

		try {
			User user = getSearchingUserDetails();
			user.setName(name);
			user.setAlternateNumber(phoneNum);
			user.setPhoneNumber(phoneNum);
			user.setEmail(Constants.EMAIL);

			User searchedUser = registration.isRegisteredUnder(user);

			Assert.assertEquals(user.getGender(), searchedUser.getGender());

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC:31
	@Test(groups = { "Registration" })
	public void isRegisteredUnderAlternateMobile() {
		String name = commonMethods.getRandomString();
		String phoneNum = commonMethods.getRandomNumber();

		try {
			User user = getSearchingUserDetails();
			user.setName(name);
			user.setAlternateNumber(phoneNum);
			user.setPhoneNumber(phoneNum);
			user.setEmail(Constants.EMAIL);

			User searchedUser = registration.isRegisteredUnder(user);

			Assert.assertEquals(user.getAlternateNumber(), searchedUser.getAlternateNumber());

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC:32
	@Test(groups = { "Registration" })
	public void verifyHeight() {
		String name = commonMethods.getRandomString();
		String phoneNum = commonMethods.getRandomNumber();

		try {
			User user = getSearchingUserDetails();
			user.setName(name);
			user.setAlternateNumber(phoneNum);
			user.setPhoneNumber(phoneNum);
			user.setEmail(Constants.EMAIL);

			User searchedUser = registration.isRegisteredUnder(user);

			Assert.assertEquals(user.getHeight(), searchedUser.getHeight());

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC:33,34
	@Test(groups = { "Registration" })
	public void verifyWeight() {
		String name = commonMethods.getRandomString();
		String phoneNum = commonMethods.getRandomNumber();

		try {
			User user = getSearchingUserDetails();
			user.setName(name);
			user.setAlternateNumber(phoneNum);
			user.setPhoneNumber(phoneNum);
			user.setEmail(Constants.EMAIL);

			User searchedUser = registration.isRegisteredUnder(user);

			Assert.assertEquals(user.getWeight(), searchedUser.getWeight());

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC:36
	@Test(groups = { "SearchingOrgAndReferel" })
	public void verifySearchOrganization() {
		String searchedOrg;

		try {
			searchedOrg = registration.searchOrganizationName("DIRE");

			Assert.assertEquals("DIRECT", searchedOrg);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC:37
	@Test(groups = { "Registration" })
	public void verifyAddOrganization() {
		String addedOrganizationName;

		try {
			addedOrganizationName = registration.addOrganization("abcdorg");

			Assert.assertEquals("abcdorg", addedOrganizationName);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:39
	@Test(groups = { "Registration" })
	public void verifySearchReferrel() {
		String searchedRef;

		try {
			searchedRef = registration.searchReferrelName("log");

			Assert.assertEquals("login", searchedRef);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC:40
	@Test(groups = { "Registration" })
	public void verifyAddReferrel() {
		List<String> searchedRef;

		try {
			searchedRef = registration.addReferel("testreferel");

			Assert.assertEquals("testreferel", searchedRef.get(0));

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:42
	@Test(groups = { "Registration" })
	public void verifyReferrelAddedWithDesignation() {
		List<String> searchedRef;

		try {
			searchedRef = registration.addReferel("testreferel");

			Assert.assertEquals(searchedRef.get(1), "Dr.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:45
	@Test(groups = { "Registration" })
	public void verifyPincode() {
		try {
			User user = userForRegisterdUnder();

			User searchedUser = registration.isRegisteredUnder(user);

			Assert.assertEquals(user.getPincode(), searchedUser.getPincode());

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC:47
	@Test()
	public void verifyUploadFile() {
		String name = commonMethods.getRandomString();

		User user = new User();
		user.setName(name);
		user.setAge("10");
		user.setGender("Male");

		try {
			String file = registration.uploadFile(user);
			Assert.assertEquals(file, "View");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());

		}
	}

	// TC:49
	@Test()
	public void isProfilePicGettingAdded() {
			boolean isAdded;
		try {
			 isAdded = registration.addingProfilePic();
			Assert.assertTrue(isAdded);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());

		}
	}
	
	private User getBlankUser() {
		User user = new User();
		user.setName("");
		user.setAge("");
		user.setEmail("");
		user.setGender("");
		user.setPhoneNumber("");
		user.setAlternateNumber("");
		user.setHeight("");
		user.setWeight("");
		user.setPincode("");
		return user;
	}

	private User getSearchingUserDetails() {
		User userSearch = new User();
		userSearch.setName("Directtype");
		userSearch.setAge("10");
		userSearch.setEmail("directtype@gmail.com");
		userSearch.setGender("Male");
		userSearch.setPhoneNumber("6000147852");
		userSearch.setAlternateNumber("6000124560");
		userSearch.setHeight("6");
		userSearch.setWeight("51");
		userSearch.setPincode("411057");
		return userSearch;
	}

	private String calculateAge(Age age) {

		int year = Integer.parseInt(age.getYear());
		int month = Integer.parseInt(age.getMonth());
		int day = Integer.parseInt(age.getDay());

		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(year, month, day);

		Period p = Period.between(birthday, today);
		String calculatedAge = String.valueOf(p.getYears());

		return calculatedAge;
	}

	private User userForRegisterdUnder() {

		User user = new User();
		String name = commonMethods.getRandomString();
		String phoneNum = commonMethods.getRandomNumber();

		user.setName(name);
		user.setAge("10");
		user.setGender("Male");
		user.setAlternateNumber(phoneNum);
		user.setHeight("6");
		user.setWeight("54");
		user.setPincode("461116");

		return user;
	}

	@DataProvider(name = "typeOfUser")
	public Object[][] getUserTypeData() {

		return new Object[][] { { "D" }, { "I" }, { "OP" }, { "IP" }, { "G" }, { "R" }, { "RB" }, { "ML" }, { "HC" },
				{ "CC" } };
	}

	@DataProvider(name = "mrAndMrs")
	public Object[][] getMrAndMrsType() {

		return new Object[][] { { "Mr." }, { "Mrs." } };
	}

	@DataProvider(name = "typeOfDesignation")
	public Object[][] getDesignationTypeAndData() {

		return new Object[][] { { "Ms." }, { "Master" }, { "Miss" }, { "Smt." }, { "Dr." }, { "B/O" }, { "Baby" } };
	}

	@AfterClass
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}

}
