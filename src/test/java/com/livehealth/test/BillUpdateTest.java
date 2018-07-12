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

	private String billId = "0";

	BillUpdatePage billUpdate;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@Autowired
	BillUpdationValidation billUpdationValidation;

	@BeforeClass(groups = { "BillUpdate", "Update" })
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
	// @Test(groups = { "BillUpdate" })
	// public void verifyCompletedBillList_02() {
	//
	// boolean flag;
	// try {
	// flag = billUpdate.completedBillList();
	//
	// Assert.assertTrue(flag);
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	//
	// }

	// TC: 03
	@Test(groups = { "BillUpdate" })
	public void verifySearchBillListByRefName_03() {

		boolean flag;
		try {
			flag = billUpdate.searchBillListByRefName();

			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 04
	@Test(groups = { "BillUpdate" })
	public void verifySearchBillListByUserName_04() {

		boolean flag;
		try {
			flag = billUpdate.searchBillListByUserName();

			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 05
	@Test(groups = { "BillUpdate" })
	public void verifyBillingAndBillUpdate_05() {
		List<BillData> list;
		User user = new User();
		user.setName("Robert");
		try {
			BillData bill = userBillingData();
			list = billUpdate.billingAndBillUpdate(user, bill);
			billUpdationValidation.verifyBillUpdation(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 06
	@Test(groups = { "BillUpdate" }, priority = 0)
	public void verifyJustCancelBill_06() {
		User user = new User();
		user.setName("Uthappa");
		BillData bill = userBillingData();
		List<String> status;
		try {
			status = billUpdate.justCancelBill(user, bill);
			billId = status.get(1);
			Assert.assertEquals(status.get(0), "Cancel");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 11
	@Test(groups = { "BillUpdate" }, dependsOnMethods = "verifyJustCancelBill_06")
	public void verifyResetBill_11() {
		String status;
		try {
			status = billUpdate.resetBill(billId);
			Assert.assertEquals(status, "Completed");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 07
	@Test(groups = { "BillUpdate" })
	public void verifyWriteOffBill_07() {
		User user = new User();
		user.setName("Jaysurya");
		BillData bill = userBillingData();
		String status;
		try {
			status = billUpdate.writeOffBill(user, bill);
			Assert.assertEquals(status, "Write Off");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 08
	@Test(groups = { "BillUpdate" })
	public void verifyCancelAndClearBillPaymentAndAmount_08() {
		User user = new User();
		user.setName("Jaysurya");
		BillData bill = userBillingData();
		List<String> billAmt;
		try {
			billAmt = billUpdate.cancelAndClearBillPaymentAndAmount(user, bill);
			Assert.assertEquals(billAmt.toString(), "[0, 0]");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 09
	@Test(groups = { "BillUpdate" })
	public void verifybillUpdate_09() {
		User user = new User();
		user.setName("Uthappa");
		BillData bill = userBillingData();
		List<BillData> billList;
		try {
			billList = billUpdate.billUpdate(user, bill);
			billUpdationValidation.verifyBillUpdation(billList.get(0), billList.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 10
	@Test(groups = { "BillUpdate" })
	public void verifyRefundBill_10() {
		User user = new User();
		user.setName("Rabada");
		BillData bill = userBillingData();
		String status;
		try {
			status = billUpdate.refundBill(user, bill);
			Assert.assertEquals(status, "Refund");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 12
	@Test(groups = { "BillUpdate" })
	public void verifySingleTestRefundBill_12() {
		SoftAssert softAssert = new SoftAssert();
		List<String> status;
		try {
			status = billUpdate.singleTestRefund(billId);
			softAssert.assertEquals(status.get(0), "Refunded");
			softAssert.assertEquals(status.get(1), "0");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 13
	@Test(groups = { "BillUpdate" })
	public void verifyJustCancelSingleTest_13() {
		User user = new User();
		user.setName("Gayle");
		BillData bill = userBillingData();
		List<String> billAmt;
		try {
			billAmt = billUpdate.justCancelSingleTest(user, bill);
			Assert.assertEquals(billAmt.toString(), "[0, 0]");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 14
	@Test(groups = { "BillUpdate" })
	public void verifyEditLink_14() {
		User user = new User();
		user.setName("Robert");
		BillData bill = userBillingData();
		List<BillData> billData;
		try {
			billData = billUpdate.editLinkVerification(user, bill);

			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 15
	// @Test(groups = { "BillUpdate" })
	// public void verifyDoctorRevenueDetails_15() {
	// BillData bill = userBillingData();
	// bill.setTestName("Bence Jones Protein - BJP Qualitative *");
	// List<BillData> billData;
	// try {
	// billData = billUpdate.doctorRevenueAmountVerification("Chahal", bill);
	//
	// System.out.println("=1=" + billData.get(0).toString());
	// System.out.println("=2=" + billData.get(1).toString());
	//
	// billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 16
	// @Test(groups = { "BillUpdate" })
	// public void verifyOutsouceAmountDetails_16() {
	// String testName = "Protein Ascitic Fluid *";
	// List<BillData> billData;
	// try {
	// billData = billUpdate.outsourceAmountDetails("Chahal", testName);
	//
	// System.out.println("=1=" + billData.get(0).toString());
	// System.out.println("=2=" + billData.get(1).toString());
	//
	// billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// // TC: 17
	// @Test(groups = { "Update" })
	// public void verifyUpdateDoctorRevenueLink_16() {
	// String testName = "Protein Ascitic Fluid *";
	// List<BillData> billData;
	// try {
	// billData = billUpdate.updateDoctorRevenueLink("Malinga", testName);
	//
	//// System.out.println("=1=" + billData.get(0).toString());
	//// System.out.println("=2=" + billData.get(1).toString());
	//
	// billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 18 Date Format
	@Test(groups = { "BillUpdate" })
	public void verifyViewPaymentLink_18() {
		String testName = "Protein Ascitic Fluid *";
		List<BillData> billData;
		try {
			billData = billUpdate.viewPaymentLink("Pujara", testName);
			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 19
	@Test(groups = { "BillUpdate" })
	public void verifySubmit_19() {
		String testName = "Protein Ascitic Fluid *";
		List<BillData> billData;
		try {
			billData = billUpdate.submitButton("malinga", testName);
			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 20
	@Test(groups = { "Update" })
	public void verifyBillLock_20() {

		String error;
		try {
			error = billUpdate.lockBill("555");
			Assert.assertEquals(error, "The bill is locked. Please unlock bill.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	private BillData userBillingData() {

		BillData bill = new BillData();
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
