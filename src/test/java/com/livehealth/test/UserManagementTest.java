package com.livehealth.test;

import java.util.ArrayList;
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

	@BeforeClass(groups = { "" })
	public void launchSite() {
		try {
			userManagementPage = pageLaunch.navigateToUserManagementPage();
			userManagementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test
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

	@Test(priority = 2)
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

	@Test(priority = 3)
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

	@Test(priority = 4)
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

	@Test(priority = 6)
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

	@Test(priority = 7)
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

	@Test(priority = 8)
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

	@Test(priority = 9)
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

	@Test(priority = 10)
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

	@Test(priority = 11, dataProvider = "billsData")
	public void verifyPatientBills(String amount) throws Exception {
		try {
			userManagementPage.patientBills(amount, "Dojwei", "HSV-1&2 (Herpes Simplex Virus-1&2)", "Protein Ascitic",
					"Albumin Serum");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 12)
	public void VerifyOperationViewOnlyAccess() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			DriverFactory.getDriver().get(Constants.LOGOUT_URL);
			list = userManagementPage.operationViewOnly(configProperties.getUsername(), configProperties.getPassword());
			softAssert.assertEquals(list.get(0),
					"×\n" + "You do not have privilege to edit report. If you want it, contact to your Admin.");
			softAssert.assertEquals(list.get(1),
					"×\n" + "You do not have privileges to dismiss report. If you want it,contact to your Admin.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 13)
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

	@Test(priority = 14)
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

	@Test(priority = 14)
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

	@Test(priority = 15)
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

	@Test(priority = 16)
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

	@Test(priority = 17)
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

	@Test(priority = 18)
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

	@Test(priority = 19)
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

	@Test(priority = 20)
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

	@DataProvider(name = "billsData")
	public static Object[][] getbillsData() {

		return new Object[][] { { "400" }, { "1070" }

		};
	}
}
