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
	@Test(groups = { "BillUpdate" }, priority = 50)
	public void verifyPendingBillList_TC_01() {

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
	public void verifyCompletedBillList_TC_02() {

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
	public void verifySearchBillListByRefName_TC_03() {

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
	public void verifySearchBillListByUserName_TC_04() {

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
	public void verifyReferrelAndOrgName_TC_05() {
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
	public void verifyBillingAndBillUpdate_TC_06() {
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
	public void verifyBillUpdate_TC_07() {
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
	public void verifyJustCancelBill_TC_08() {
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
	public void verifyCancelAndClearBillPaymentAndAmount_TC_09() {
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
	public void verifyRefundBill_TC_10() {
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
	public void verifyWriteOffBill_TC_11() {
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
	@Test(groups = { "BillUpdate" }, dependsOnMethods = "verifyJustCancelBill_TC_08")
	public void verifyResetBill_TC_12() {
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
	public void verifySingleTestRefundBill_TC_13() {
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
	public void verifyJustCancelSingleTest_TC_14() {
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
	public void verifyEditLink_TC_15() {
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
	public void verifyDoctorRevenueDetails_TC_16() {
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
	public void verifyOutsouceAmountDetails_TC_17() {
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
	public void verifyUpdateDoctorRevenueLink_TC_18() {
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
	public void verifyUpdatePriceListlink_TC_19() {
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
	public void verifyUpdateOrganizationPriceListlink_TC_20() {
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
	public void verifyBillLock_TC_21() {

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
	public void verifyViewPaymentLink_TC_22() {
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
	public void verifySubmit_TC_23() {
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
	public void verifyReferrelPriceList_TC_24() {
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
	public void verifyOrganizationPriceList_TC_25() {
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
	public void verifyDiscountPriceList_TC_26() {
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
	public void verifyProfileTest_TC_27() {
		SoftAssert softAssert = new SoftAssert();
		String profileName = "verify bill update";
		List<String> tList;
		try {
			tList = billUpdate.profileTest("amar", profileName);
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
	public void verifyCancelTestFromMultipleTest_TC_28() {
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
	public void verifyRefundTestFromMultipleTest_TC_29() {
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
	public void verifyPercentageWiseConcession_TC_30() {
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
	public void verifyAdvancedPaidGreaterThanPayableAmt_TC_31() {
		String error;
		try {
			error = billUpdate.advancedPaidAmountGreaterThanPayableAmount("swapnil");
			Assert.assertEquals(error, "Error! Total amount is greater or equal to advance amount.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 32
	@Test(groups = { "BillUpdate" })
	public void verifyAdditionalPriceField_TC_32() {
		String error;
		try {
			error = billUpdate.additionalPriceVerification("swapnil");
			Assert.assertEquals(error, "980");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 33
	@Test(groups = { "BillUpdate" }, dependsOnMethods = "verifyMoreThanAllowedDiscount_TC_34")
	public void verifyConcessionInRupees_TC_33() {
		String error;
		try {
			error = billUpdate.concessionInRupees();
			Assert.assertEquals(error, "60");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 34
	@Test(groups = { "BillUpdate" }, dependsOnMethods = "verifyCashModeInCaseOfUserAdvance_TC_35")
	public void verifyMoreThanAllowedDiscount_TC_34() {
		String error;
		try {
			error = billUpdate.moreThanAllowedDiscount();
			Assert.assertEquals(error, "You can give only 50% discount.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 35
	@Test(groups = { "BillUpdate" })
	public void verifyCashModeInCaseOfUserAdvance_TC_35() {
		String amount;
		try {
			amount = billUpdate.cashPaymentInCaseOfUserAdvance("jordan");
			Assert.assertEquals(amount, "CASH");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 36
	@Test(groups = { "BillUpdate" })
	public void verifyRefundAndCancelTests_TC_36() {
		String billAmt;
		try {
			billAmt = billUpdate.refundAndCancelTests("referrel");
			Assert.assertEquals(billAmt, "270");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// // TC:
	// @Test(groups = { "" })
	// public void verifyUpdatedReferrelNameAfterReset_37() {
	// String refName;
	// try {
	// refName = billUpdate.referrelNameAfterReset("referrel");
	// Assert.assertEquals(refName, "Delative");
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 37
	@Test(groups = { "BillUpdate" })
	public void verifyBillStatusIfPaidTotalAmount_TC_37() {
		String refName;
		try {
			refName = billUpdate.checkStatusIfPaidTotalBillAmount("referrel");
			Assert.assertEquals(refName, "Completed");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 38
	@Test(groups = { "BillUpdate" })
	public void verifyBillStatusIfPaidPartialAmount_TC_38() {
		String refName;
		try {
			refName = billUpdate.checkStatusIfPaidPartialBillAmount("referrel");
			Assert.assertEquals(refName, "Pending");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 39
	@Test(groups = { "BillUpdate" })
	public void verifyNameAgeGender_TC_39() {
		String name;
		try {
			name = billUpdate.nameGenderAgeVerification("swapnil");
			Assert.assertEquals(name, "Bill Of Swapnil (M - 10)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 40
	@Test(groups = { "BillUpdate" })
	public void verifyConcessionToOutsourceTest_TC_40() {
		String name;
		try {
			name = billUpdate.concessionToOutsourceTest("benedict");
			Assert.assertEquals(name, "Sorry! you can not give concession on outsourced test.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 41
	@Test(groups = { "BillUpdate" })
	public void verifyBillOrder_TC_41() {
		SoftAssert softAssert = new SoftAssert();
		List<String> names;
		try {
			names = billUpdate.billOrder();
			softAssert.assertEquals(names.get(0), "Thirduser");
			softAssert.assertEquals(names.get(1), "Seconduser");
			softAssert.assertEquals(names.get(2), "Firstuser");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 42
	@Test(groups = { "BillUpdate" })
	public void verifySampleReceivedStatus_TC_42() {
		String status;
		try {
			status = billUpdate.notFilledStatusVerification("user");
			Assert.assertEquals(status, "Not filled");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 43
	@Test(groups = { "BillUpdate" })
	public void verifyPayableAmountAfterRefund_TC_43() {
		String payableAmount;
		try {
			payableAmount = billUpdate.payableAmountAfterRefund("user");
			Assert.assertEquals(payableAmount, "700");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 44
	@Test(groups = { "BillUpdate" })
	public void verifyPayableAmtIfBillPaidPartially_TC_44() {
		SoftAssert softAssert = new SoftAssert();
		List<String> list;
		try {
			list = billUpdate.partialPaymentBillUpdateVerification("user");
			softAssert.assertEquals(list.get(0), "970");
			softAssert.assertEquals(list.get(1), "200");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 45
	@Test(groups = { "BillUpdate" })
	public void verifyPayableAmtIfBillPaidPartiallyForProfile_TC_45() {
		SoftAssert softAssert = new SoftAssert();
		String profileName = "verify bill update";
		List<String> list;
		try {
			list = billUpdate.partialPaymentWithProfileTest("user", profileName);
			softAssert.assertEquals(list.get(0), "750");
			softAssert.assertEquals(list.get(1), "650");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 46
	@Test(groups = { "BillUpdate" })
	public void verifyPendingApprovalStatus_TC_46() {
		String status;
		try {
			status = billUpdate.pendingApprovalStatusVerification("user");
			Assert.assertEquals(status, "Pending approval");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 47
	@Test(groups = { "BillUpdate" })
	public void verifyPendingSubmitStatus_TC_47() {
		String status;
		try {
			status = billUpdate.pendingSubmitVerification("user");
			Assert.assertEquals(status, "Pending submit");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 48
	@Test(groups = { "BillUpdate" })
	public void verifySampleNotReceivedStatus_TC_48() {
		String status;
		try {
			status = billUpdate.sampleNotReceivedStatus("user");
			Assert.assertEquals(status, "Sample not received");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 47
	// @Test(groups = { "" })
	// public void verifyDueAmountShowingCorrectly_47() {
	//
	// List<String> price;
	// try {
	// price = billUpdate.showingDueCorrectly("advance");
	// Assert.assertEquals(price.get(0), price.get(1));
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

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
