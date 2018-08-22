package com.livehealth.test;

import java.util.ArrayList;

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
import org.testng.asserts.SoftAssert;
import com.livehealth.base.DriverFactory;
import com.livehealth.config.ConfigProperties;
import com.livehealth.config.Constants;
import com.livehealth.pageobject.BillSettlementPage;
import com.livehealth.pageobject.HomePage;
import com.livehealth.pageobject.ReferralManagementPage;
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReferralManagementTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	ReferralManagementPage referralManagementPage;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "referralManagement" })
	public void launchSite() {
		try {
			referralManagementPage = pageLaunch.navigateToReferralManagemetPage();
			referralManagementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 2, groups = { "referralManagement" })
	public void verifyaddReferralValidationWarning() {
		try {

			String warning = referralManagementPage.addReferralValidation();
			Assert.assertEquals(warning, "×\n" + "Please fill the all required information.");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 3, groups = { "referralManagement" })
	public void verifyaddReferralWithAllDetails() {
		try {

			String referralName = referralManagementPage.addNewReferral();
			Assert.assertEquals(referralName, "Dhanraj");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 4, dataProvider = "OrgContact", groups = { "referralManagement" })
	public void verifyaddReferralContactValidation(String contact) {
		SoftAssert softAssert = new SoftAssert();
		try {
			String color = referralManagementPage.contactFieldValidation(contact);
			softAssert.assertEquals(color, "rgb(255, 0, 0)");
	
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 5, groups = { "referralManagement" })
	public void verifyaddReferralWithAlreadyExistedEmail() {
		try {

			String emailborder = referralManagementPage.alreadyExistedEmail("dhanraj.kshirsagar@livehealth.in");
			Assert.assertEquals(emailborder, "rgb(255, 0, 0)");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 6, groups = { "referralManagement" })
	public void verifyaddReferralWithAlreadyExistedReferralAndUserName() {
		try {

			String validationColor = referralManagementPage.alreadyExistedReferralAndUserName();
			Assert.assertEquals(validationColor, "rgba(102, 175, 233, 1)");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 7, groups = { "referralManagement" })
	public void verifyAlreadyExistedReferralAndUserNameValidation() {
		try {

			String validationColor = referralManagementPage.alreadyExistedReferralAndUserName();
			Assert.assertEquals(validationColor, "rgba(102, 175, 233, 1)");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 8, groups = { "referralManagement" })
	public void verifyAddReferralWithDOBAndDOA() {
		try {
			String referrlalName=referralManagementPage.addReferralWithDOBAndDOA("Birth Doc");
			Assert.assertEquals(referrlalName, "Birth Doc");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 9, groups = { "referralManagement" })
	public void verifyUpdateReferralInfo() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> referrals;
		try {
			referrals=referralManagementPage.updateReferralInfo("Dhanra", "Updated Dhan");
			softAssert.assertEquals(referrals.get(0), "Updated Dhan");
			softAssert.assertEquals(referrals.get(1), "8275369427");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 10, groups = { "referralManagement" })
	public void verifyDeleteReferral() {
		boolean flag;
		try {
			flag=referralManagementPage.deleteReferral("Updated Dh");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 11, groups = { "referralManagement" })
	public void verifyDeleteAndTransferReferral() {
		boolean flag;
		try {
			flag=referralManagementPage.deleteAndTrasnfer("Birth do");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 12, dataProvider = "ReferralDesignation", groups = { "referralManagement" })
	public void verifyAddReferralWithEachDesignation(String designation, String value) {
		SoftAssert softAssert = new SoftAssert();
		String referrlalDesignation;
		try {
			referrlalDesignation=referralManagementPage.addReferralWithDesignation(designation, value);
			softAssert.assertEquals(referrlalDesignation, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 13, groups = { "referralManagement" })
	public void verifyAssignReferralPriceList() {
		try {

			String megs = referralManagementPage.assignPriceList("auto", "Referral");
			Assert.assertEquals(megs, "Referral price list");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 14, groups = { "referralManagement" })
	public void verifyReAssignReferralPriceListToAlreadyAssignedReferral() {
		try {
			String refName = referralManagementPage.assignPriceList("auto", "ReAssign");
			Assert.assertEquals(refName, "ReAssign Referral Price");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 15, groups = { "referralManagement" })
	public void verifyViewListLink() {
		try {

			String URL = referralManagementPage.viewListLink("auto");
			Assert.assertEquals(URL, "https://beta.livehealth.solutions/listManagement/#356");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 16, groups = { "referralManagement" })
	public void verifyExportListLink() {
		try {
			referralManagementPage.ExportListLink("auto");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 17, groups = { "referralManagement" })
	public void verifyRemoveAssignedList() {
		boolean flag;
		try {
			flag=referralManagementPage.removeAssignedList("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}


	@Test(priority = 19, dataProvider = "testsData", groups = { "referralManagement" })
	public void verifyPatientBills(String amount, String test1, String test2) {
		SoftAssert softAssert = new SoftAssert();
		try {
			DriverFactory.getDriver().navigate().to(Constants.Billing_URL);

			for (int i = 0; i < 4; i++) {
				String success = referralManagementPage.patientBill("referral Settle", amount, test1, test2);
				softAssert.assertEquals(success, "×\n" + "Bill saved successfully.");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();

	}

	@Test(priority = 20, groups = { "referralManagement" })
	public void verifyReferralSettlementPendingBillsDueAmount() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<Integer> amounts;
		try {
			DriverFactory.getDriver().navigate().to(Constants.ReferralSettlemet_URL);
			amounts=referralManagementPage.calculateDue("auto");
			softAssert.assertEquals(amounts.get(0), amounts.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();

	}

	@Test(priority = 21, groups = { "referralManagement" })
	public void verifyEditBillLink() {
		String expectedUrl;
		try {
			expectedUrl=referralManagementPage.editBillLink("auto");
			Assert.assertEquals(expectedUrl, "https://beta.livehealth.solutions/billUpdate");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 22, groups = { "referralManagement" })
	public void verifyReferralSettlementSubmitButton() {
		boolean flag;
		try {
			flag=referralManagementPage.settleAmount("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 23, groups = { "referralManagement" })
	public void verifyReferralSettlementAmount() {
		ArrayList<Integer> amount;
		try {
			amount=referralManagementPage.settlementAmount("auto");
			Assert.assertEquals(amount.get(0),amount.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 24, groups = { "referralManagement" })
	public void verifyBackDatedReferralSettlement() {
		boolean flag;
		try {
			flag=referralManagementPage.backDatedSettlement("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 25, dataProvider = "paymentModes", groups = { "referralManagement" })
	public void verifyReferralSettlementWithAllPaymentTypes(String mode, String value) {
		boolean flag;
		try {
			flag=referralManagementPage.paymentType(mode, value, "auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 26, groups = { "referralManagement" })
	public void verifyReferralSettlementWithSelectAllBillsCheckBox() {
		try {
			String warning = referralManagementPage.selectAlls("auto");
			Assert.assertEquals(warning, "×\n" + "No pending bills found for the selected referral.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 27, groups = { "referralManagement" })
	public void verifyReferralSettlementWithBackDatedDataUsingDateFilter() {
		boolean flag;
		try {
			flag=referralManagementPage.datepickerData("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 28, groups = { "referralManagement" })
	public void verifyBulkUploadReferralsExcel() {
		boolean flag;
		try {
			flag=referralManagementPage.bulkUploadReferrals("test uplaod", "testing");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 29, groups = { "referralManagement" })
	public void verifyBulkUploadReferralExportExcelTemplate() {
		try {
			referralManagementPage.exportExcelTemplate();

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@DataProvider(name = "testsData")
	public static Object[][] getTestsData() {

		return new Object[][] { { "100", "Gr", "Calcium/Creatinine Ratio Urine Spot" },
				{ "200", "Gr", "Calcium/Creatinine Ratio Urine Spot" },
				{ "300", "Gr", "Calcium/Creatinine Ratio Urine Spot" },

		};
	}

	@DataProvider(name = "paymentModes")
	public static Object[][] getPaymentModes() {

		return new Object[][] { { "Cheque", "CHEQUE" }, { "Credit", "CREDIT" },{ "Credit Card", "CREDIT CARD" },
				{ "Debit Card", "DEBIT CARD" }, { "Free", "FREE" }, { "Other", "OTHER" },

		};
	}

	@DataProvider(name = "ReferralDesignation")
	public static Object[][] getReferralDesignation() {

		return new Object[][] { { "Dr", "Dr." }, { "DrMs", "Dr. (Ms)" }, { "DrSmt", "Dr. (Smt)" },
				{ "Blank", "Designation" },

		};
	}

	@DataProvider(name = "OrgContact")
	public static Object[][] getOrgContact() {

		return new Object[][] { { "8275369428" }, { "78452" },

		};
	}
	
//	@AfterClass(alwaysRun = true)
//	public void tearDown() {
//		DriverFactory.closeDriverObjects();
//
//	}

}
