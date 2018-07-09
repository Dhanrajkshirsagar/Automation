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

import com.livehealth.base.DriverFactory;
import com.livehealth.config.ConfigProperties;
import com.livehealth.model.BillData;
import com.livehealth.model.User;
import com.livehealth.pageobject.BillUpdatePage;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;
import com.livehealth.validator.BillUpdationValidation;

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
	
	@Autowired
	BillUpdationValidation billUpdationValidation;

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
	// @Test(groups = { "BillUpdate" }, priority = 0)
	// public void verifyPendingBillList_01() {
	//
	// boolean flag;
	// try {
	// flag = billUpdate.pendingBillList();
	//
	// Assert.assertTrue(flag);
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	//
	// }

	// TC: 02
//	@Test(groups = { "BillUpdate" })
//	public void verifyCompletedBillList_02() {
//
//		boolean flag;
//		try {
//			flag = billUpdate.completedBillList();
//
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//
//	}
//
//	// TC: 03
//	@Test(groups = { "BillUpdate" })
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
//	@Test(groups = { "BillUpdate" })
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

	// TC: 05
//	@Test(groups = { "BillUpdate" })
//	public void verifyBillingAndBillUpdate_05() {
//		List<BillData> list;
//		User user = new User();
//		user.setName("Robert");
//		try {
//			BillData bill = userBillingData();
//			list = billUpdate.billingAndBillUpdate(user, bill);
//			billUpdationValidation.verifyBillUpdation(list.get(0), list.get(1));
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}

	// TC: 06
	@Test(groups = { "BillUpdate" })
	public void verifyJustCancelBill_06() {
		User user = new User();
		user.setName("Robert");
		BillData bill = userBillingData();
		String status;
		try {
			status = billUpdate.justCancelBill(user, bill);
			Assert.assertEquals(status, "Cancel");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}
	
	private BillData userBillingData() {
		
		BillData bill =new BillData();
		bill.setReferrelPriceList("Referrel  with sumit ");
		bill.setTestName("Hanging Drop Preparation *");
		bill.setOrganization("prepaid Organization");
		return bill;
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}
}
