package com.livehealth.test;

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
import org.testng.asserts.SoftAssert;

import com.livehealth.base.DriverFactory;
import com.livehealth.model.User;
import com.livehealth.pageobject.Billing;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;
import com.livehealth.validator.TestValidation;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BillingTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	Billing billing;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	TestValidation testValidation;

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

	// TC: 07
	// @Test(groups = { "billing" })
	// public void verifysearchLoader() {
	// boolean loader;
	// try {
	// User userInfo = getUserInfo();
	// loader = billing.searchLoader(userInfo.getName());
	// Assert.assertTrue(loader);
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 09
	@Test(groups = { "billing" })
	public void verifyRemainingDueAmt() {
		List<String> billAmt;
		try {
			User userInfo = getUserInfo();
			billAmt = billing.dueAmountVerification(userInfo.getName());
			Assert.assertEquals(billAmt.get(0), billAmt.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 10
	@Test(groups = { "billing" })
	public void verifyAdvanceAmount() {
		User userInfo = getUserInfo();
		String advanceAmt;
		try {
			advanceAmt = billing.advanceAmountShownCorrectlyOrNot(userInfo.getName());
			Assert.assertEquals(advanceAmt, "₹ 1000");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 11
	@Test(groups = { "billing" })
	public void verifyReferrelPriceList() {
		User userInfo = getUserInfo();
		SoftAssert softAssert = new SoftAssert();
		List<String> referrel;
		try {
			referrel = billing.referrelPriceList(userInfo.getName());

			softAssert.assertEquals(referrel.get(1), "Referrel  with sumit");
			softAssert.assertEquals(referrel.get(2), "Referrel with livehealth");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 12
	@Test(groups = { "billing" })
	public void verifyPriceListAsPerSelectedReferrel() {
		User userInfo = getUserInfo();
		List<String> testListOne;
		List<String> testListTwo;
		try {
			testListOne = billing.priceListAsPerSelectedReferrel(userInfo.getName());
			testListTwo = billing.confirmPriceListAsPerSelectedReferrel();

			testValidation.verifyTestPrice(testListOne, testListTwo);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 13
	@Test(groups = { "billing" })
	public void verifyCalculator() {
		String calculatedPrice;
		try {
			User userInfo = getUserInfo();
			calculatedPrice = billing.testCalculator(userInfo.getPhoneNumber());
			Assert.assertEquals(calculatedPrice, "1050");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 14
	@Test(groups = { "billing" })
	public void verifyCompanyPriceList() {
		User userInfo = getUserInfo();
		SoftAssert softAssert = new SoftAssert();
		List<String> orgList;
		try {
			orgList = billing.companyPriceList(userInfo.getName());

			softAssert.assertEquals(orgList.get(1), "link org");
			softAssert.assertEquals(orgList.get(2), "DIRECT");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 15
	@Test(groups = { "billing" })
	public void verifyPriceListAsPerSelectedCompany() {
		User userInfo = getUserInfo();
		List<String> testListOne;
		List<String> testListTwo;
		try {
			testListOne = billing.priceListAsPerSelectedCompany(userInfo.getName());
			testListTwo = billing.confirmPriceListAsPerSelectedCompany();

			testValidation.verifyTestPrice(testListOne, testListTwo);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 18
	@Test(groups = { "billing" })
	public void verifyTypeTestNameField() {
		User userInfo = getUserInfo();
		String searchTest;
		try {
			searchTest = billing.typeTestNameField(userInfo.getName());
			Assert.assertEquals(searchTest, "Albumin Serum");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 19
	@Test(groups = { "billing" })
	public void verifyTestPriceAsPerSelectedTest() {
		User userInfo = getUserInfo();
		List<String> testListOne;
		List<String> testListTwo;
		try {
			testListOne = billing.testPriceAsPerSelectedTest(userInfo.getName());
			testListTwo = billing.confirmTestPrice();

			testValidation.verifyTestPrice(testListOne, testListTwo);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 20
	@Test(groups = { "billing" })
	public void verifyMultipleTestAddingSuccessfully() {
		String calculatedPrice;
		try {
			User userInfo = getUserInfo();
			calculatedPrice = billing.multipleTestAddedSuccessfully(userInfo.getName());
			Assert.assertEquals(calculatedPrice, "1300");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 21
	@Test()
	public void verifySingleTestAddingSuccessfully() {
		String calculatedPrice;
		try {
			User userInfo = getUserInfo();
			calculatedPrice = billing.singleTestAddedSuccessfully(userInfo.getName());
			Assert.assertEquals(calculatedPrice, "500");
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
