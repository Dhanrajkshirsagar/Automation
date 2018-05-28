package com.livehealth.test;

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
import com.livehealth.pageobject.Billing;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BillingTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	Billing billing;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@BeforeClass
	public void launchSite() {
		try {
			billing = pageLaunch.navigateToBillingPage();
			billing.signIn("auto-livehealth", "livehealth20");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	// TC: 01
	@Test(groups = { "billing" }, priority = 0)
	public void verifyBillingPage() {

		String title;
		try {
			title = billing.getPageTitle();

			Assert.assertEquals(title, "Billing");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 02
	@Test(groups = { "billing" })
	public void verifySearchUsingMobileNumber() {

		String title;
		try {
			User userInfo = getUserInfo();
			title = billing.getPageTitle(userInfo.getPhoneNumber());
			Assert.assertEquals(title, "Dhanraj");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 02
	@Test(groups = { "billing" })
	public void verifySearchUsingName() {

		String title;
		try {
			User userInfo = getUserInfo();
			title = billing.getPageTitle(userInfo.getName());
			Assert.assertEquals(title, "Dhanraj");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 03,06
	@Test(groups = { "billing" })
	public void verifySearchingDirectUser() {

		String title;
		try {
			title = billing.getPageTitle("dty");
			Assert.assertEquals(title, "Dtype");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 03
	@Test(groups = { "billing" })
	public void verifySearchingIndirectUser() {

		String title;
		try {
			title = billing.getPageTitle("ityp");
			Assert.assertEquals(title, "Itype");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 05
	@Test(groups = { "billing" })
	public void verifySearchPerEnteredNumber() {

		String title;
		try {
			title = billing.getPageTitle("8275369");
			Assert.assertEquals(title, "Dhanraj");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	private User getUserInfo() {
		User user = new User();
		user.setName("Dhanraj");
		user.setPhoneNumber("8275369428");

		return user;
	}

	@AfterClass
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}
}
