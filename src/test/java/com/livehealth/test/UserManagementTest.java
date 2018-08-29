package com.livehealth.test;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.livehealth.base.DriverFactory;
import com.livehealth.config.ConfigProperties;
import com.livehealth.config.Constants;
import com.livehealth.pageobject.HomePage;
import com.livehealth.pageobject.UserManagementPage;
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserManagementTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	UserManagementPage userManagementPage;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "AccessControl"})
	public void launchSite() {
		try {
			userManagementPage = pageLaunch.navigateToUserManagementPage();
			userManagementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 1,groups = { "AccessControl"})
	public void verifyAllowedDiscountOnBill() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = userManagementPage.allowedDiscountOnBill("20");
			softAssert.assertEquals(list.get(0), "×\n" + "Bill saved successfully.");
			softAssert.assertEquals(list.get(1), "×\n" + "You can give only 20% discount.");
			softAssert.assertEquals(list.get(2), "0");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 2,groups = { "AccessControl"})
	public void verifyLabUserPatientRegistrationAndUpdateAccess() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = userManagementPage.registrationAccess(configProperties.getUsername(),
					configProperties.getPassword());
			softAssert.assertEquals(list.get(0), "https://beta.livehealth.solutions/billing/");
			softAssert.assertEquals(list.get(1), "×\n" + "Patient details has been updated successfully..");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 3,groups = { "AccessControl"})
	public void verifyLabUserWithoutRegistrationAndUpdateAccess() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = userManagementPage.NotRegAndUpdateAccess(configProperties.getUsername(),
					configProperties.getPassword(), "Myebv");
			softAssert.assertEquals(list.get(0),
					"×\n" + "You don’t have new registration privilege. If you want it, contact to your Admin.");
			softAssert.assertEquals(list.get(1),
					"×\n" + "You don’t have update patient privilege. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 4,groups = { "AccessControl"})
	public void verifyLabUserRegistrationAllAccess() {
		boolean flag;
		try {
			flag = userManagementPage.registratioAllAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 6,groups = { "AccessControl"})
	public void VerifyBothFlagBillTestPriceAndConcessionEditable() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = userManagementPage.BothFlagBillTestPriceAndConcessionEditable("sad", "500", "100");
			softAssert.assertEquals(list.get(0), "500");
			softAssert.assertEquals(list.get(1), "100" + " ₹");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 7,groups = { "AccessControl"})
	public void VerifyBillTestPriceEditableFlag() {
		boolean flag;
		try {
			flag = userManagementPage.billTestPriceEditable(configProperties.getUsername(),
					configProperties.getPassword(), "sad", "500");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 8,groups = { "AccessControl"})
	public void VerifyBillTestConcessionEditableFlag() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.billTestConcessionEditable(configProperties.getUsername(),
					configProperties.getPassword(), "sad", "90");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 9,groups = { "AccessControl"})
	public void VerifyRemoveAllRegistrationAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.removeAllRegistrationAcess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 10,groups = { "AccessControl"})
	public void VerifyOperationAllAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.OperationAllAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 11, dataProvider = "billsData",groups = { "AccessControl"})
	public void verifyPatientBills(String amount) throws Exception {
		try {
			userManagementPage.patientBills(amount, "Dojwei", "HSV-1&2 (Herpes Simplex Virus-1&2)", "Protein Ascitic",
					"Albumin Serum");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 12,groups = { "AccessControl"})
	public void VerifyOperationViewOnlyAccess() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			list = userManagementPage.operationViewOnly(configProperties.getUsername(), configProperties.getPassword());
			softAssert.assertEquals(list.get(0),
					"×\n" + "You do not have privilege to edit report. If you want it, contact to your Admin.");
			softAssert.assertEquals(list.get(1),
					"×\n" + "You do not have privileges to dismiss report. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 13,groups = { "AccessControl"})
	public void VerifyhideDueAmountReports() throws Exception {
		DriverFactory.getDriver().get(Constants.LOGOUT_URL);
		boolean flag;
		try {
			flag = userManagementPage.hideDueAmountReports(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 14,groups = { "AccessControl"})
	public void VerifyUserWithClearReportAccess() {
		String success;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			success = userManagementPage.clearReportAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(success,
					"×\n" + UserManagementPage.testName + " reports value has been cleared successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 15,groups = { "AccessControl"})
	public void VerifyUserWithoutClearReportAccess() {

		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			String warning = userManagementPage.ClearReportNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(warning,
					"×\n" + "You do not have privilege to clear report. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 16,groups = { "AccessControl"})
	public void VerifyUserWithDissmissReportAccess() {
		String success;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			success = userManagementPage.dissMissReportAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(success, "×\n" + UserManagementPage.test + " report has been removed successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 17,groups = { "AccessControl"})
	public void VerifyUserWithRedoAccess() throws Exception {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.RedrawAndRedoReportAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 18,groups = { "AccessControl"})
	public void VerifyUserWithRedrawAccess() {
		boolean flag;
		try {
			flag = userManagementPage.redrawAccess();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 19,groups = { "AccessControl"})
	public void VerifyUserWithoutRedrawAndRedoAccess() {
		String warning;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			warning = userManagementPage.redoAndRedrawNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(warning,
					"×\n" + "You do not have privilege to redraw report. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 20,groups = { "AccessControl"})
	public void VerifyUserWithUpdateReportInfoAccess() {
		String age;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			age = userManagementPage.updateReportInfoAcess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(age, "20");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 21,groups = { "AccessControl"})
	public void VerifyUserWithoutUpdateReportInfoAccess() {
		String warning;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			warning = userManagementPage.withoutUpdateReportInfoAcess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(warning,
					"×\n" + "You do not have privilege to update report info. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 22,groups = { "AccessControl"})
	public void VerifyUserWithEditReportAccess() {
		String status;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			status = userManagementPage.withEditReportAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(status, "Pending Approval");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 23,groups = { "AccessControl"})
	public void VerifyUserWithOutEditReportAccess() {
		String status;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			status = userManagementPage.withOutEditReportAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(status,
					"×\n" + "You do not have privilege to edit report. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 24,groups = { "AccessControl"})
	public void VerifyUserWithShareReportAccess() {
		String success;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			success = userManagementPage.withShareReportAccess(configProperties.getUsername(),
					configProperties.getPassword(), "123" + "4");
			Assert.assertEquals(success, "×\n" + "Report has been shared successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 25,groups = { "AccessControl"})
	public void VerifyUserWithoutShareReportAccess() {
		String warning;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			warning = userManagementPage.withoutShareReportAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(warning,
					"×\n" + "You do not have privilege to share report. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 26,groups = { "AccessControl"})
	public void VerifyUserWithInventoryManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.inventoryAccess(configProperties.getUsername(), configProperties.getPassword());
			Assert.assertEquals(text, "Stock Management");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 27,groups = { "AccessControl"})
	public void VerifyUserWithoutInventoryManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.notInventoryAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Inventory Management");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 28,groups = { "AccessControl"})
	public void VerifyUserWithQualityControlAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.QualityControlAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Add Quality Control");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 29,groups = { "AccessControl"})
	public void VerifyUserWithoutQualityControlAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.notQualityControlAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Quality Control");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 30,groups = { "AccessControl"})
	public void VerifyUserWithoutEditSignedReportAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.notEditSignedReportAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "×\n"
					+ "Sorry, It seems you do not have permission to edit authorised reports! Please contact to Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 31,groups = { "AccessControl"})
	public void VerifyUserWithEditSubmittedReportAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.EditSubmittedReportAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "×\n" + userManagementPage.report + "has been edited successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 32,groups = { "AccessControl"})
	public void VerifyUserWithoutEditSubmittedReportAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.EditSubmittedReportNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	// ----------------TestCases on Admin Access control----------------------

	@Test(priority = 33,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithReferralManagementAcces() {
		SoftAssert softAssert = new SoftAssert();
		List<String> list;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			list = userManagementPage.referralManagementAccessFlag(configProperties.getUsername(),
					configProperties.getPassword());
			softAssert.assertEquals(list.get(0), "Referral Billing List");
			softAssert.assertEquals(list.get(1), "Referral Name");
			softAssert.assertEquals(list.get(2), "Referral Upload Excel");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 34,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutReferralManagementAcess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.withoutReferralManagementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 35,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithDeleteReferralAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.deleteReferralFlag(configProperties.getUsername(), configProperties.getPassword(),
					"Delete Access");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 36,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutDeleteReferralAccess() {
		String warning;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			warning = userManagementPage.NotdeleteReferralAccess(configProperties.getUsername(),
					configProperties.getPassword(), "Delete Not Access");
			Assert.assertEquals(warning, "×\n"
					+ "Sorry! You do not have privilege to delete a doctor. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 37,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithReferralSetlementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.ReferralSettlementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 38,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithOutReferralSetlementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.ReferralSettlementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 39,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithUpdateAllRevenueAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.updateAllRevenueAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Doctor Revenue Management");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 40,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithOutUpdateAllRevenueAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.updateAllRevenueNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Doctor Management");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 41,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithDoctorManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.doctorManagementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Doctor Name");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 42,groups = { "AccessControl"})
	public void VerifyUserWithoutDoctorManagementAccess() {
		String URL;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			URL = userManagementPage.doctorManagementnotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(URL, Constants.DoctorManagement_URL);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 43,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithDeleteDoctorAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.deleteDoctorAccess(configProperties.getUsername(), configProperties.getPassword(),
					"delete doc");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 44,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutDeleteDoctorAccess() {
		String warning;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			warning = userManagementPage.deleteDoctorNotAccess(configProperties.getUsername(),
					configProperties.getPassword(), "Delete not access");
			Assert.assertEquals(warning, "×\n"
					+ "Sorry! You do not have privilege to delete a doctor. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 45,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithDoctorRevenueTrackerAccess() {
		String warning;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			warning = userManagementPage.doctorRevenueTrackerAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(warning, "Doctor Revenue Tracker");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 46,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutDoctorRevenueTrackerAccess() {
		String URL;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			URL = userManagementPage.doctorRevenueTrackerNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(URL, Constants.DoctorManagement_URL);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 47,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserOrganizationManagementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.organizationManagementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 48,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutOrganizationManagementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.organizationManagementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 49,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithDeleteOrganizationAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.deleteOrganizationAccess(configProperties.getUsername(),
					configProperties.getPassword(), "Delete Access");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 50,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutOrganizationDeleteAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.deleteOrganizationNotAccess(configProperties.getUsername(),
					configProperties.getPassword(), "Delete Not Access");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 51,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithOrganizationSettlementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.organizationSettlemetAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 50,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutOrganizationSettlementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.organizationSettlemetNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 51,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithOutsourceMangementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.OutsourceMangementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Outsource Centre");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 52,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutOutsourceMangementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.OutsourceMangementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Outsourcing Management");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 53,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithListManagementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.listMangementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 54,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutListManagementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.listMangementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 55,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithDeleteListAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.deleteListAccess(configProperties.getUsername(), configProperties.getPassword(),
					"List delete Access");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 56,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutDeleteListAccess() {
		String warning;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			warning = userManagementPage.deleteListNotAccess(configProperties.getUsername(),
					configProperties.getPassword(), "List Access");
			Assert.assertEquals(warning, "×\n"
					+ "Sorry! You do not have permission to delete a list. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 57,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithReportManagementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.reportMangementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 58,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutReportManagementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.reportMangementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 59,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithAddEditProfileAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.addEditProfileAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 60,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutAddEditProfileNotAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.addEditProfileNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 61,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithAddEditReportAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.addEditReportAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 62,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutAddEditReportAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.addEditReportNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 63,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithBillSettingAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.billSettingAccess(configProperties.getUsername(), configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 64,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutBillSettingAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.billSettingNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 65,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithReportSettingAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.reportSettingAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 66,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutReportSettingAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.reportSettingNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 67,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithCancelTestsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.cancelTestsAccess(configProperties.getUsername(), configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 68,groups = { "AccessControl"})
	public void VerifyUserWithoutCancelTestsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.cancelTestsNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 69,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithDepartmentManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.departmentManagementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "New Department");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 70,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutDepartmentManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.departmentManagementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Department Management");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 71,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithMarketingManagementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.marketingManagementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 72,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutMarketingManagementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.marketingManagementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 73,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithDeleteMarketingMemberAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.deleteMarketingMemberAccess(configProperties.getUsername(),
					configProperties.getPassword(), "mayur");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 74,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutDeleteMarketingMemberAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.deleteMarketingMemberNotAccess(configProperties.getUsername(),
					configProperties.getPassword(), "akash");
			Assert.assertEquals(text, "×\n"
					+ "Sorry! You do not have privilege to delete a marketing member. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 75,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithCentreManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.centreManagementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Lab Name :");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 76,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutCentreManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.centreManagementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Center Management");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 77,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithResourcesAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.resourcesAccess(configProperties.getUsername(), configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 78,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutResourcesAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.resourcesNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 79,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithPackagesAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.packagesAccess(configProperties.getUsername(), configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 80,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutPackagesAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.packagesNotAccess(configProperties.getUsername(), configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 81,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithPromotionsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userPromotions(configProperties.getUsername(), configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 82,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutPromotionsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userPromotionsNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 83,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithFeedbackAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFeedbackAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 84,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutFeedbackAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFeedbackNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 85,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithUserManagementAccess() {
		String Url;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			Url = userManagementPage.userManagementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(Url, "https://beta.livehealth.solutions/addEditUser/");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 86,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutUserManagementAccess() {
		String Url;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			Url = userManagementPage.userManagementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(Url, "https://beta.livehealth.solutions/referralManagement/");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 87,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutDeleteUserNotAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.deleteUserNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "×\n"
					+ "Sorry! You do not have permission to delete a user. If you want it, contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 88,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithActivityLogsAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.ActivityLogsAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Track activity related to login users.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 89,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutActivityLogsAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.ActivityLogsNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Activity Log");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 90,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithSmsManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.smsManagementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Name");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 91,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithoutSmsManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.smsManagementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "SMS Management");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 92,groups = { "AccessControl","AdminAccess"})
	public void VerifyUserWithCampaignManagementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.CampaignManagementAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 93,groups = { "AccessControl","AdminAccess","AdminAccess"})
	public void VerifyUserWithoutCampaignManagementAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.CampaignManagementNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

// ------------------TestCases on Finance Access control--------------------------
	@Test(priority = 94,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithFinanceDashboardAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.financeDashboardAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Finance Dashboard - Graph View");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 95,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutFinanceDashboardAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.financeDashboardNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Finance Dashboard");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 96,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithFinanceExportAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceExportAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 97,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutFinanceExportAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceExportNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 98,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithBillListAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userBillListAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 99,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutBillListAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userBillListNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 100,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithFinanceAnalyticsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceAnalyticsAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 101,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutFinanceAnalyticsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceAnalyticsNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 102,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithFinanceDepartmentAnalyticsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceDepartmentAnalyticsAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 103,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutFinanceDepartmentAnalyticsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceDepartmentAnalyticsNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 104,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithFinanceOutsourceAnalyticsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceOutsourceAnalyticsAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 105,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutFinanceOutsourceAnalyticsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceOutsourceAnalyticsNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 106,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithFinanceMarketingAnalyticsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceMarketingAnalyticsAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 107,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutFinanceMarketingAnalyticsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceMarketingAnalyticsNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 108,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithFinanceTestAnalyticsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceTestAnalyticsAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 109,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutFinanceTestAnalyticsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceTestAnalyticsNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 110)
	public void VerifyUserWithFinanceMISReportsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceMISReportsAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 111,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutFinanceMISReportsAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userFinanceMISReportsNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 112,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithTATAnalysisAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.userTATAnalysisAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(text, "Overall");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 113,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutTATAnalysisAccess() {
		String Url;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			Url = userManagementPage.userTATAnalysisNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(Url, "Turn Around Time (TAT) Analysis");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 114,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithAnalyticsFlagAccess() {
		String url;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			url = userManagementPage.userAnalyticsFlagAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(url, "https://beta.livehealth.solutions/Finance/");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 115,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutAnalyticsFlagAccess() {
		String url;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			url = userManagementPage.userAnalyticsFlagNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(url, "https://beta.livehealth.solutions/referralManagement/");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 116,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithInvoiceMgtAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userInvoiceMgtAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 117,groups = { "AccessControl","FinanceAccess"})
	public void VerifyUserWithoutInvoiceMgtAccess() {
		boolean flag;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			flag = userManagementPage.userInvoiceMgtNotAccess(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@DataProvider(name = "billsData")
	public static Object[][] getbillsData() {

		return new Object[][] { { "400" }, { "1070" }

		};
	}
}
