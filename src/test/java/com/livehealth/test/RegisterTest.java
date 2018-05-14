package com.livehealth.test;

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
import org.testng.annotations.Test;

import com.livehealth.base.DriverFactory;
import com.livehealth.model.User;
import com.livehealth.pageobject.HomePage;
import com.livehealth.pageobject.Registration;
import com.livehealth.validator.RegistrationValidator;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RegisterTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	Registration registration;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	RegistrationValidator registerValidator;

	@BeforeClass
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
			User user =getSearchingUserDetails();

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
			User user =getSearchingUserDetails();
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
			User inputUser =getSearchingUserDetails();
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
		userSearch.setAlternateNumber("60001 24560");
		userSearch.setHeight("6");
		userSearch.setWeight("51");
		userSearch.setPincode("411057");
		return userSearch;
	}
	@AfterClass
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}

}
