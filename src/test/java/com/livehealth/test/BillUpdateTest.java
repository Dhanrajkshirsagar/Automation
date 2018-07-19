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
	@Test(groups = { "" }, priority = 0)
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
	@Test(groups = { "BillUpdate" })
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
	public void verifyReferrelAndOrgName_05() {
		BillData bill = userBillingData();
		List<BillData> billData;
		try {
			billData = billUpdate.getBillWithAddedReferrel("Jadeja", bill);
			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 06
	@Test(groups = { "BillUpdate" })
	public void verifyBillingAndBillUpdate_06() {
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

	// TC: 07
	@Test(groups = { "BillUpdate" })
	public void verifyBillUpdate_07() {
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

	// TC: 08
	@Test(groups = { "BillUpdate" }, priority = 0)
	public void verifyJustCancelBill_08() {
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

	// TC: 09
	@Test(groups = { "BillUpdate" })
	public void verifyCancelAndClearBillPaymentAndAmount_09() {
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

	// TC: 11
	@Test(groups = { "BillUpdate" })
	public void verifyWriteOffBill_11() {
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

	// TC: 12
	@Test(groups = { "BillUpdate" }, dependsOnMethods = "verifyJustCancelBill_08")
	public void verifyResetBill_12() {
		String status;
		try {
			status = billUpdate.resetBill(billId);
			Assert.assertEquals(status, "Completed");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 13
	@Test(groups = { "BillUpdate" })
	public void verifySingleTestRefundBill_13() {
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

	// TC: 14
	@Test(groups = { "BillUpdate" })
	public void verifyJustCancelSingleTest_14() {
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

	// TC: 
	@Test(groups = { "verify" })
	public void verifyCancelwithAddTestAmountToAdvance() {
		BillData bill = userBillingData();
		String billAmt;
		try {
			billAmt = billUpdate.cancelWithAddTestAmountToAdvance("Jonty Rhodes", bill);
			Assert.assertEquals(billAmt.toString(), "₹ 700");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 15
	@Test(groups = { "BillUpdate" })
	public void verifyEditLink_15() {
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

	// TC: 16
	@Test(groups = { "BillUpdate" })
	public void verifyDoctorRevenueDetails_16() {
		BillData bill = userBillingData();
		bill.setTestName("Ionised Calcium");
		List<BillData> billData;
		try {
			billData = billUpdate.doctorRevenueAmountVerification("Chahal", bill);
			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 17
	@Test(groups = { "BillUpdate" })
	public void verifyOutsouceAmountDetails_17() {
		BillData bill = userBillingData();
		bill.setTestName("Ionised Calcium");
		List<BillData> billData;
		try {
			billData = billUpdate.outsourceAmountDetails("Chahal", bill);
			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 18
	@Test(groups = { "BillUpdate" })
	public void verifyUpdateDoctorRevenueLink_18() {
		BillData bill = userBillingData();
		bill.setTestName("Ionised Calcium");
		List<BillData> billData;
		try {
			billData = billUpdate.updateDoctorRevenueLink("Malinga", bill);
			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 19
	@Test(groups = { "BillUpdate" })
	public void verifyUpdatePriceListlink_19() {
		BillData bill = userBillingData();
		bill.setTestName("Ionised Calcium");
		List<BillData> billData;
		try {
			billData = billUpdate.updatePriceListLink("Pujara", bill);
			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 20
	@Test(groups = { "BillUpdate" })
	public void verifyUpdateOrganizationPriceListlink_20() {
		BillData bill = userBillingData();
		bill.setTestName("Ionised Calcium");
		List<BillData> billData;
		try {
			billData = billUpdate.updateOrganizationPriceListLink("Pujara", bill);
			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 21
	@Test(groups = { "BillUpdate" })
	public void verifyBillLock_21() {

		String error;
		try {
			error = billUpdate.lockBill("555");
			Assert.assertEquals(error, "The bill is locked. Please unlock bill.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 22 Date Format
	@Test(groups = { "BillUpdate" })
	public void verifyViewPaymentLink_22() {
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

	// TC: 23
	@Test(groups = { "BillUpdate" })
	public void verifySubmit_23() {
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

	// TC: 24
	@Test(groups = { "BillUpdate" })
	public void verifyReferrelPriceList_24() {
		BillData bill = userBillingData();
		bill.setTestName("Ionised Calcium");
		List<BillData> billData;
		try {
			billData = billUpdate.referrelPriceList("Pujara", bill);
			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 25
	@Test(groups = { "BillUpdate" })
	public void verifyOrganizationPriceList_25() {
		BillData bill = userBillingData();
		bill.setTestName("Ionised Calcium");
		bill.setOrganizationPriceList("DIRECT ");
		List<BillData> billData;
		try {
			billData = billUpdate.organizationPriceList("Cheteshwar", bill);
			billUpdationValidation.verifyBillUpdation(billData.get(0), billData.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 26
	@Test(groups = { "BillUpdate" })
	public void verifyDiscountPriceList_26() {
		SoftAssert softAssert = new SoftAssert();
		BillData bill = userBillingData();
		bill.setDiscountPriceList("Discount list ");
	
		List<String> price;
		try {
			price = billUpdate.discountPriceList("Neymar", bill);
			softAssert.assertEquals(price.get(0), price.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}
	
	// TC: 27
	@Test(groups = { "BillUpdate" })
	public void verifyProfileTest_27() {
		SoftAssert softAssert = new SoftAssert();
		String profileName = "verify bill update";		
		List<String> tList;
		try {
			tList = billUpdate.profileTest("amar",profileName);
			softAssert.assertEquals(tList.get(0), "Ionised CalciumProfile - verify bill update");
			softAssert.assertEquals(tList.get(1), "Protein Ascitic Fluid *Profile - verify bill update");
			softAssert.assertEquals(tList.get(2), "Albumin SerumProfile - verify bill update");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}
	
	// TC: 28
	@Test(groups = { "BillUpdate" })
	public void verifyCancelTestFromMultipleTest_28() {
		String amount;
		try {
			amount = billUpdate.cancelTestFromMultipleTest("profile");
			Assert.assertEquals(amount, "470");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 29
	@Test(groups = { "BillUpdate" })
	public void verifyRefundTestFromMultipleTest_29() {
		String amount;
		try {
			amount = billUpdate.refundTestFromMultipleTest("neymar");
			Assert.assertEquals(amount, "470");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 30
	@Test(groups = { "BillUpdate" })
	public void verifyPercentageWiseConcession_30() {
		String amount;
		try {
			amount = billUpdate.percentagewiseConcession("neymar");
			Assert.assertEquals(amount, "776");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 31
	@Test(groups = { "BillUpdate" })
	public void verifyCashModeInCaseOfUserAdvance_31() {
		String amount;
		try {
			amount = billUpdate.cashPaymentInCaseOfUserAdvance("jordan");
			Assert.assertEquals(amount, "CASH");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 32
	@Test(groups = { "BillUpdate" }, dependsOnMethods = "verifyCashModeInCaseOfUserAdvance_31")
	public void verifyMoreThanAllowedDiscount_32() {
		String error;
		try {
			error = billUpdate.moreThanAllowedDiscount();
			Assert.assertEquals(error, "You can give only 50% discount.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 33
	@Test(groups = { "BillUpdate" }, dependsOnMethods = "verifyMoreThanAllowedDiscount_32")
	public void verifyConcessionInRupees_33() {
		String error;
		try {
			error = billUpdate.concessionInRupees();
			Assert.assertEquals(error, "60");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 36
	@Test(groups = { "BillUpdate" })
	public void verifyAdditionalPriceField_34() {
		String error;
		try {
			error = billUpdate.additionalPriceVerification("swapnil");
			Assert.assertEquals(error, "980");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 37
	@Test(groups = { "BillUpdate" })
	public void verifyAdvancedPaidGreaterThanPayableAmt_35() {
		String error;
		try {
			error = billUpdate.advancedPaidAmountGreaterThanPayableAmount("swapnil");
			Assert.assertEquals(error, "Error! Total amount is greater or equal to advance amount.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 36
	@Test(groups = { "Update" })
	public void verifyUpdatedReferrelNameAfterReset_35() {
		String refName;
		try {
			refName = billUpdate.referrelNameAfterReset("referrel");
			Assert.assertEquals(refName, "Delative");
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
