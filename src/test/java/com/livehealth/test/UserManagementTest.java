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

	@BeforeClass()
	public void launchSite() {
		try {
			userManagementPage = pageLaunch.navigateToUserManagementPage();
			userManagementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

//	@Test(priority = 1)
//	public void verifyAllowedDiscountOnBill() {
//		SoftAssert softAssert = new SoftAssert();
//		ArrayList<String> list;
//		try {
//			list = userManagementPage.allowedDiscountOnBill("20");
//			softAssert.assertEquals(list.get(0), "×\n" + "Bill saved successfully.");
//			softAssert.assertEquals(list.get(1), "×\n" + "You can give only 20% discount.");
//			softAssert.assertEquals(list.get(2), "0");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			softAssert.assertTrue(false, e.getMessage());
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 2)
//	public void verifyLabUserPatientRegistrationAndUpdateAccess() {
//		SoftAssert softAssert = new SoftAssert();
//		ArrayList<String> list;
//		try {
//			list = userManagementPage.registrationAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			softAssert.assertEquals(list.get(0), "https://beta.livehealth.solutions/billing/");
//			softAssert.assertEquals(list.get(1), "×\n" + "Patient details has been updated successfully..");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			softAssert.assertTrue(false, e.getMessage());
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 3)
//	public void verifyLabUserWithoutRegistrationAndUpdateAccess() {
//		SoftAssert softAssert = new SoftAssert();
//		ArrayList<String> list;
//		try {
//			list = userManagementPage.NotRegAndUpdateAccess(configProperties.getUsername(),
//					configProperties.getPassword(), "Myebv");
//			softAssert.assertEquals(list.get(0),
//					"×\n" + "You don’t have new registration privilege. If you want it, contact to your Admin.");
//			softAssert.assertEquals(list.get(1),
//					"×\n" + "You don’t have update patient privilege. If you want it, contact to your Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			softAssert.assertTrue(false, e.getMessage());
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 4)
//	public void verifyLabUserRegistrationAllAccess() {
//		boolean flag;
//		try {
//			flag = userManagementPage.registratioAllAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 6)
//	public void VerifyBothFlagBillTestPriceAndConcessionEditable() {
//		SoftAssert softAssert = new SoftAssert();
//		ArrayList<String> list;
//		try {
//			list = userManagementPage.BothFlagBillTestPriceAndConcessionEditable("sad", "500", "100");
//			softAssert.assertEquals(list.get(0), "500");
//			softAssert.assertEquals(list.get(1), "100" + " ₹");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			softAssert.assertTrue(false, e.getMessage());
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 7)
//	public void VerifyBillTestPriceEditableFlag() {
//		boolean flag;
//		try {
//			flag = userManagementPage.billTestPriceEditable(configProperties.getUsername(),
//					configProperties.getPassword(), "sad", "500");
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 8)
//	public void VerifyBillTestConcessionEditableFlag() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.billTestConcessionEditable(configProperties.getUsername(),
//					configProperties.getPassword(), "sad", "90");
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 9)
//	public void VerifyRemoveAllRegistrationAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.removeAllRegistrationAcess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 10)
//	public void VerifyOperationAllAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.OperationAllAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 11, dataProvider = "billsData")
//	public void verifyPatientBills(String amount) throws Exception {
//		try {
//			userManagementPage.patientBills(amount, "Dojwei", "HSV-1&2 (Herpes Simplex Virus-1&2)", "Protein Ascitic",
//					"Albumin Serum");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 12)
//	public void VerifyOperationViewOnlyAccess() {
//		SoftAssert softAssert = new SoftAssert();
//		ArrayList<String> list;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			list = userManagementPage.operationViewOnly(configProperties.getUsername(), configProperties.getPassword());
//			softAssert.assertEquals(list.get(0),
//					"×\n" + "You do not have privilege to edit report. If you want it, contact to your Admin.");
//			softAssert.assertEquals(list.get(1),
//					"×\n" + "You do not have privileges to dismiss report. If you want it, contact to your Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			softAssert.assertTrue(false, e.getMessage());
//		}
//		softAssert.assertAll();
//	}
//
//	@Test(priority = 13)
//	public void VerifyhideDueAmountReports() throws Exception {
//		DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//		boolean flag;
//		try {
//			flag = userManagementPage.hideDueAmountReports(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 14)
//	public void VerifyUserWithClearReportAccess() {
//		String success;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			success = userManagementPage.clearReportAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(success,
//					"×\n" + UserManagementPage.testName + " reports value has been cleared successfully.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 15)
//	public void VerifyUserWithoutClearReportAccess() {
//
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			String warning = userManagementPage.ClearReportNotAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(warning,
//					"×\n" + "You do not have privilege to clear report. If you want it, contact to your Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 16)
//	public void VerifyUserWithDissmissReportAccess() {
//		String success;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			success = userManagementPage.dissMissReportAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(success, "×\n" + UserManagementPage.test + " report has been removed successfully.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 17)
//	public void VerifyUserWithRedoAccess() throws Exception {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.RedrawAndRedoReportAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 18)
//	public void VerifyUserWithRedrawAccess() {
//		boolean flag;
//		try {
//			flag = userManagementPage.redrawAccess();
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 19)
//	public void VerifyUserWithoutRedrawAndRedoAccess() {
//		String warning;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			warning = userManagementPage.redoAndRedrawNotAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(warning,
//					"×\n" + "You do not have privilege to redraw report. If you want it, contact to your Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 20)
//	public void VerifyUserWithUpdateReportInfoAccess() {
//		String age;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			age = userManagementPage.updateReportInfoAcess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(age, "20");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 21)
//	public void VerifyUserWithoutUpdateReportInfoAccess() {
//		String warning;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			warning = userManagementPage.withoutUpdateReportInfoAcess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(warning,
//					"×\n" + "You do not have privilege to update report info. If you want it, contact to your Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 22)
//	public void VerifyUserWithEditReportAccess() {
//		String status;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			status = userManagementPage.withEditReportAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(status, "Pending Approval");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 23)
//	public void VerifyUserWithOutEditReportAccess() {
//		String status;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			status = userManagementPage.withOutEditReportAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(status,
//					"×\n" + "You do not have privilege to edit report. If you want it, contact to your Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 24)
//	public void VerifyUserWithShareReportAccess() {
//		String success;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			success = userManagementPage.withShareReportAccess(configProperties.getUsername(),
//					configProperties.getPassword(), "123" + "4");
//			Assert.assertEquals(success, "×\n" + "Report has been shared successfully.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 25)
//	public void VerifyUserWithoutShareReportAccess() {
//		String warning;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			warning = userManagementPage.withoutShareReportAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(warning,
//					"×\n" + "You do not have privilege to share report. If you want it, contact to your Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 26)
//	public void VerifyUserWithInventoryManagementAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.inventoryAccess(configProperties.getUsername(), configProperties.getPassword());
//			Assert.assertEquals(text, "Stock Management");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 27)
//	public void VerifyUserWithoutInventoryManagementAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.notInventoryAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(text, "Inventory Management");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 28)
//	public void VerifyUserWithQualityControlAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.QualityControlAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(text, "Add Quality Control");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 29)
//	public void VerifyUserWithoutQualityControlAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.notQualityControlAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(text, "Quality Control");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 30)
//	public void VerifyUserWithoutEditSignedReportAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.notEditSignedReportAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(text, "×\n"
//					+ "Sorry, It seems you do not have permission to edit authorised reports! Please contact to Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//
//	@Test(priority = 31)
//	public void VerifyUserWithEditSubmittedReportAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.EditSubmittedReportAccess(configProperties.getUsername(),
//					configProperties.getPassword());
//			Assert.assertEquals(text, "×\n" + userManagementPage.report+ "has been edited successfully.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 32)
//	public void VerifyUserWithoutEditSubmittedReportAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.EditSubmittedReportNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	//----------------TestCases on Admin Access control----------------------
//	
//	@Test(priority = 33)
//	public void VerifyUserWithReferralManagementAcces() {
//		SoftAssert softAssert=new SoftAssert();
//		List<String> list;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			list = userManagementPage.referralManagementAccessFlag(configProperties.getUsername(),configProperties.getPassword());
//			softAssert.assertEquals(list.get(0), "Referral Billing List");
//			softAssert.assertEquals(list.get(1), "Referral Name");
//			softAssert.assertEquals(list.get(2), "Referral Upload Excel");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			softAssert.assertTrue(false, e.getMessage());
//		}
//		softAssert.assertAll();
//	}
//	@Test(priority = 34)
//	public void VerifyUserWithoutReferralManagementAcess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.withoutReferralManagementAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 35)
//	public void VerifyUserWithDeleteReferralAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.deleteReferralFlag(configProperties.getUsername(),configProperties.getPassword(), "Delete Access");
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 36)
//	public void VerifyUserWithoutDeleteReferralAccess() {
//		String warning;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			warning = userManagementPage.NotdeleteReferralAccess(configProperties.getUsername(),configProperties.getPassword(), "Delete Not Access");
//			Assert.assertEquals(warning, "×\n" + 
//					"Sorry! You do not have privilege to delete a doctor. If you want it, contact to your Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 37)
//	public void VerifyUserWithReferralSetlementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.ReferralSettlementAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 38)
//	public void VerifyUserWithOutReferralSetlementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.ReferralSettlementNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 39)
//	public void VerifyUserWithUpdateAllRevenueAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.updateAllRevenueAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertEquals(text, "Doctor Revenue Management");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 40)
//	public void VerifyUserWithOutUpdateAllRevenueAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.updateAllRevenueNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertEquals(text, "Doctor Management");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 41)
//	public void VerifyUserWithDoctorManagementAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.doctorManagementAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertEquals(text, "Doctor Name");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 42)
//	public void VerifyUserWithoutDoctorManagementAccess() {
//		String URL;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			URL = userManagementPage.doctorManagementnotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertEquals(URL, Constants.DoctorManagement_URL);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 43)
//	public void VerifyUserWithDeleteDoctorAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.deleteDoctorAccess(configProperties.getUsername(),configProperties.getPassword(), "delete doc");
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 44)
//	public void VerifyUserWithoutDeleteDoctorAccess() {
//		String warning;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			warning = userManagementPage.deleteDoctorNotAccess(configProperties.getUsername(),configProperties.getPassword(), "Delete not access");
//			Assert.assertEquals(warning, "×\n" + 
//					"Sorry! You do not have privilege to delete a doctor. If you want it, contact to your Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 45)
//	public void VerifyUserWithDoctorRevenueTrackerAccess() {
//		String warning;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			warning = userManagementPage.doctorRevenueTrackerAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertEquals(warning, "Doctor Revenue Tracker");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 46)
//	public void VerifyUserWithoutDoctorRevenueTrackerAccess() {
//		String URL;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			URL = userManagementPage.doctorRevenueTrackerNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertEquals(URL,Constants.DoctorManagement_URL);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 47)
//	public void VerifyUserOrganizationManagementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.organizationManagementAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 48)
//	public void VerifyUserWithoutOrganizationManagementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.organizationManagementNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 49)
//	public void VerifyUserWithDeleteOrganizationAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.deleteOrganizationAccess(configProperties.getUsername(),configProperties.getPassword(), "Delete Access");
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 50)
//	public void VerifyUserWithoutOrganizationDeleteAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.deleteOrganizationNotAccess(configProperties.getUsername(),configProperties.getPassword(),"Delete Not Access");
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 51)
//	public void VerifyUserWithOrganizationSettlementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.organizationSettlemetAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 52)
//	public void VerifyUserWithoutOrganizationSettlementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.organizationSettlemetNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 53)
//	public void VerifyUserWithOutsourceMangementAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.OutsourceMangementAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertEquals(text, "Outsource Centre");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 54)
//	public void VerifyUserWithoutOutsourceMangementAccess() {
//		String text;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			text = userManagementPage.OutsourceMangementNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertEquals(text, "Outsourcing Management");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 55)
//	public void VerifyUserWithListManagementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.listMangementAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	
//	@Test(priority = 56)
//	public void VerifyUserWithoutListManagementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.listMangementNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 57)
//	public void VerifyUserWithDeleteListAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.deleteListAccess(configProperties.getUsername(),configProperties.getPassword(), "List delete Access");
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 58)
//	public void VerifyUserWithoutDeleteListAccess() {
//		String warning;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			warning = userManagementPage.deleteListNotAccess(configProperties.getUsername(),configProperties.getPassword(), "List Access");
//			Assert.assertEquals(warning, "×\n" + 
//					"Sorry! You do not have permission to delete a list. If you want it, contact to your Admin.");
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 58)
//	public void VerifyUserWithReportManagementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.reportMangementAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 59)
//	public void VerifyUserWithoutReportManagementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.reportMangementNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 59)
//	public void VerifyUserWithReportManagementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.addEditProfileAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 60)
//	public void VerifyUserWithoutReportManagementAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.addEditProfileNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 61)
//	public void VerifyUserWithAddEditReportAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.addEditReportAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 62)
//	public void VerifyUserWithoutAddEditReportAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.addEditReportNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 63)
//	public void VerifyUserWithBillSettingAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.billSettingAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 64)
//	public void VerifyUserWithoutBillSettingAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.billSettingNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 63)
//	public void VerifyUserWithBillSettingAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.billSettingAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 64)
//	public void VerifyUserWithoutBillSettingAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.billSettingNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 65)
//	public void VerifyUserWithReportSettingAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.reportSettingAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 65)
//	public void VerifyUserWithoutReportSettingAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.reportSettingNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 66)
//	public void VerifyUserWithCancelTestsAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.cancelTestsAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
//	
//	@Test(priority = 67)
//	public void VerifyUserWithoutCancelTestsAccess() {
//		boolean flag;
//		try {
//			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
//			flag = userManagementPage.cancelTestsNotAccess(configProperties.getUsername(),configProperties.getPassword());
//			Assert.assertTrue(flag);
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//			Assert.assertTrue(false, e.getMessage());
//		}
//	}
	
	@Test(priority = 68)
	public void VerifyUserWithDepartmentManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.departmentManagementAccess(configProperties.getUsername(),configProperties.getPassword());
			Assert.assertEquals(text, "New Department");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Test(priority = 69)
	public void VerifyUserWithoutDepartmentManagementAccess() {
		String text;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			text = userManagementPage.departmentManagementNotAccess(configProperties.getUsername(),configProperties.getPassword());
			Assert.assertEquals(text, "Department Management");
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
