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
import com.livehealth.config.ConfigProperties;
import com.livehealth.pageobject.BillUpdatePage;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BillUpdateTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	BillUpdatePage billUpdate;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "BillUpdate" })
	public void launchSite() {
		try {
			billUpdate = pageLaunch.navigateToBillUpdatePage();
			billUpdate.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	// TC: 01
	@Test(groups = { "BillUpdate" }, priority = 0)
	public void verifyPendingBillList_01() {

		boolean flag;
		try {
			flag = billUpdate.pendingBillList();

			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 02
	@Test(groups = { "BillUpdate" }, priority = 0)
	public void verifyCompletedBillList_02() {

		boolean flag;
		try {
			flag = billUpdate.completedBillList();

			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}
//
//	// TC: 03
//	@Test(groups = { "BillUpdate" }, priority = 0)
//	public void verifySearchBillListByRefName_03() {
//
//		boolean flag;
//		try {
//			flag = billUpdate.searchBillListByRefName();
//
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//
//	}
//
//	// TC: 04
//	@Test(groups = { "BillUpdate" }, priority = 0)
//	public void verifySearchBillListByUserName_04() {
//
//		boolean flag;
//		try {
//			flag = billUpdate.searchBillListByUserName();
//
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//
//	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}
}
