package com.livehealth.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
import com.livehealth.pageobject.OrganizationManagementPage;
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrganizationManagementTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	OrganizationManagementPage organizationManagementPage;

	BillSettlementPage billSettlementPage;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "OrgManagement" })
	public void launchSite() {
		try {
			organizationManagementPage = pageLaunch.navigateToOrganizationManagementPage();
			organizationManagementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 2, groups = { "OrgManagement" })
	public void verifyAddOrganizationValidation() {
		try {
			String waring = organizationManagementPage.addOrganisationValidation();
			Assert.assertEquals(waring, "×\n" + "Kindly check the required fields.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 3, groups = { "OrgManagement" })
	public void verifyAddOrganizationWithAllDetails() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = organizationManagementPage.addOrganzationWithAllDetails("Satara Hospital");
			softAssert.assertEquals(list.get(0), "Satara Hospital");
			softAssert.assertEquals(list.get(1), "8275369428");
			softAssert.assertEquals(list.get(2), "dhanraj.kshirsagar@livehealth.in");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();

	}

	@Test(priority = 4, dataProvider = "OrgContact", groups = { "OrgManagement" })
	public void verifyAddOrganizationContactValidation(String contact) {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = organizationManagementPage.contactFieldValidation(contact);
			softAssert.assertEquals(list.get(0), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(1), "Invalid number");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();

	}

	@Test(priority = 5, groups = { "OrgManagement" })
	public void verifyaddOrganizationWithAlreadyExistedEmail() {
		try {
			String emailborder = organizationManagementPage.alreadyExistedEmail("dhanraj.kshirsagar@livehealth.in");
			Assert.assertEquals(emailborder, "rgb(255, 0, 0)");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 6, groups = { "OrgManagement" })
	public void verifyaddOrganizationWithAlreadyExistedOrganizationAndUserName() {

		try {
			String validationColor = organizationManagementPage.alreadyExistedReferralAndUserName("Satara Hospital",
					"satara");
			Assert.assertEquals(validationColor, "rgba(255, 0, 0, 1)");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 7, dataProvider = "OrgPaymentType", groups = { "OrgManagement" })
	public void verifyaddOrganizationWithDifferentPaymentTypes(String payType, String orgName, String value) {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = organizationManagementPage.paymentType(payType, orgName);
			Assert.assertEquals(list.get(0), value);
			softAssert.assertEquals(list.get(1), "5000");
			softAssert.assertEquals(list.get(2), "5000");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();

	}

	@Test(priority = 8, dataProvider = "OrgNames", groups = { "OrgManagement" })
	public void verifyAddOrgnizationWithDifferentCCTypesAndAlsoAccessControlOfThem(String orgName) {
		try {

			organizationManagementPage.addCC(orgName);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 9, groups = { "OrgManagement" })
	public void verifyNonBillingCCAccessControl() {
		boolean flag;
		try {
			organizationManagementPage.logoutCurrentSession();
			organizationManagementPage.signIn("livep-NonBill", "Non@12345");
			flag = organizationManagementPage.verifyCC1Access();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 10, groups = { "OrgManagement" })
	public void verifyBillingCCAccessControl() {
		try {
			organizationManagementPage.signIn("livep-billing", "Billing@1234");
			organizationManagementPage.verifyCC2Access();
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 11, groups = { "OrgManagement" })
	public void verifyBillingCCPatientRegistrationAndUpdateAccessControl() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = organizationManagementPage.registrationAndUpdateAccess();
			softAssert.assertEquals(list.get(0), "https://beta.livehealth.solutions/billing/");
			softAssert.assertEquals(list.get(1), "×\n" + "Patient details has been updated successfully..");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();

	}

	@Test(priority = 12, groups = { "OrgManagement" })
	public void verifyUpdateOrganizationDetails() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			DriverFactory.getDriver().get("https://beta.livehealth.solutions/logout/");
			organizationManagementPage = pageLaunch.navigateToOrganizationManagementPage();
			organizationManagementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
			DriverFactory.getDriver().get("https://beta.livehealth.solutions/organization/edit/");
			list = organizationManagementPage.updateOrganizationDetails("Satara");
			softAssert.assertEquals(list.get(0), "8275369427");
			softAssert.assertEquals(list.get(1), "kshirsagardhanraj24@gmail.com");
			organizationManagementPage.deleteCCOrganization("Non Billing");
			organizationManagementPage.deleteCCOrganization("Billing CC");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();

	}

	@Test(priority = 13, groups = { "OrgManagement" })
	public void verifyDeleteOrganization() {
		boolean flag;
		try {
			flag = organizationManagementPage.deleteOrganization("Sample delete");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 14, groups = { "OrgManagement" })
	public void verifyDeleteAndTransferOrganization() {
		boolean flag;
		try {
			flag = organizationManagementPage.deleteAndTrasnferOrganization("Satara");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 15, groups = { "OrgManagement" })
	public void verifyAddOrganizationforThirdPartyAPIIntegration() {
		boolean flag;
		try {
			flag = organizationManagementPage.addThiredPartyIntegrationOrganization("API Integration");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 16, groups = { "OrgManagement" })
	public void verifyUpdateThirdPartyAPIIntegrationAccessForSelectedOrganization() {
		boolean flag;
		try {
			flag = organizationManagementPage.updatThiredPartyIntegrationOrganization("API Integration");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// --------In this we have to check validation on ledger organization amount and
	// verifying added advance and ledger Balance amounts
	@Test(priority = 17, groups = { "OrgManagement" })
	public void verifyManageLedgerForPrepaidOrganizationPaymentType() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = organizationManagementPage.manageLedgerValidation("Prepaid Ledger ", "5000");
			softAssert.assertEquals(list.get(0), "×\n" + "Error! Opening balance must be same as advance.");
			softAssert.assertEquals(list.get(1), "5000");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 18, groups = { "OrgManagement" })
	public void verifyManageLedgerForPostPaidOrganizationPaymentType() {
		try {
			String credit = organizationManagementPage.manageLedgerForPostPaid("PostpaidLedger Organization", "5000");
			Assert.assertEquals(credit, "5000");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 19, groups = { "OrgManagement" })
	public void verifyAssignOrganizationRevenueList() {
		try {

			String listName = organizationManagementPage.assignPriceList("auto", "Organization");
			Assert.assertEquals(listName, "Organization revenue list");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 20, groups = { "OrgManagement" })
	public void verifyReAssignOrganizationRevenueListForAlreadyAssignedList() {
		try {

			String listName = organizationManagementPage.assignPriceListForAlreadyAssigned("auto", "ReAssign");
			Assert.assertEquals(listName, "ReAssignOrgList");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 21, groups = { "OrgManagement" })
	public void verifyOrganizationRevenueViewListLink() {
		try {

			String URl = organizationManagementPage.viewListLink("auto");
			Assert.assertEquals(URl, "https://beta.livehealth.solutions/listManagement/#64");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 22, groups = { "OrgManagement" })
	public void verifyOrganizationRevenueExportLink() {
		try {
			organizationManagementPage.ExportListLink("auto");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 23, groups = { "OrgManagement" })
	public void verifyUpdateAllOrganizationRevenue() {
		boolean flag;
		try {
			flag = organizationManagementPage.updateAllRevenue("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 24, groups = { "OrgManagement" })
	public void verifyRemoveAssignedList() {
		boolean flag;
		try {
			flag = organizationManagementPage.removeAssignedList("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 25, groups = { "OrgManagement" })
	public void verifyEnableOrganization() {
		try {
			String actualName = organizationManagementPage.enableOrganization("DIRECT");
			Assert.assertEquals(actualName, "DIRECT");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 26, groups = { "OrgManagement" })
	public void verifyLoginCC() throws Exception {
		try {

			organizationManagementPage.logoutCurrentSession();
			organizationManagementPage.signIn("livep-prepaid", "Prepaid@123");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 27, groups = { "OrgManagement" })
	public void verifyAddCreditforCheckOrganisationLedger() {
		try {

			organizationManagementPage.verifyCC();
			organizationManagementPage.signIn("livep-full", "Password@123");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 28, groups = { "OrgManagement" })
	public void verifyOrganisationLedgerApproveAdvance() {
		try {

			String success = organizationManagementPage.approveAdvanceOrgAmount();
			Assert.assertEquals(success, "×\n" + "Credit amount approved successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 29, groups = { "OrgManagement" })
	public void verifyOrganisationLedgerRejectAdvance() {
		try {

			String success = organizationManagementPage.rejectAdvanceOrgAmount();
			Assert.assertEquals(success, "rgb(255, 0, 0)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}


	@Test(priority = 30, groups = { "OrgManagement" })
	public void verifyCalculatedOrganizationSettlementDueAmount() {
		ArrayList<Integer> list;
		try {
			list = organizationManagementPage.calculateOrgDue("auto");
			Assert.assertEquals(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 31, dataProvider = "testsData", groups = { "OrgManagement" })
	public void verifyPatientBills(String amount, String test1, String test2) {
		try {
			DriverFactory.getDriver().navigate().to(Constants.Billing_URL);

			for (int i = 0; i < 4; i++) {
				organizationManagementPage.patientBill("Manish", amount, test1, test2);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 32, groups = { "OrgManagement" })
	public void verifyOrganizationSettlementRecalculateDueAmountLink() {
		try {

			String success = organizationManagementPage.recalculateOrgDue("auto");
			Assert.assertEquals(success, "×\n" + "Successfully calculated.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 33, groups = { "OrgManagement" })
	public void verifyOrganizationSettlementEditBillLink() {
		try {
			String actual = organizationManagementPage.editBillLink("auto");
			Assert.assertEquals(actual, "https://beta.livehealth.solutions/billUpdate");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 34, groups = { "OrgManagement" })
	public void verifyOrganizationSettlementSubmitButton() {
		boolean flag;
		try {
			flag = organizationManagementPage.orgBillssettleAmount("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 35, groups = { "OrgManagement" })
	public void verifyBackDatedOrganizationSettlement() {
		boolean flag;
		try {
			flag = organizationManagementPage.backDatedSettlement("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 36, dataProvider = "paymentModes", groups = { "OrgManagement" })
	public void verifyOrganizationSettlementWithSelectedPaymentMode(String mode, String value) {
		boolean flag;
		try {
			flag = organizationManagementPage.paymentType(mode, value, "auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 37, groups = { "OrgManagement" })
	public void verifyOrganizationSettlementWithSelectAllBills() {
		boolean flag;
		try {
			flag = organizationManagementPage.selectAlls("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 38, groups = { "OrgManagement" })
	public void verifyBulkUploadOrganizationListUpload() {
		SoftAssert softAssert = new SoftAssert();
		try {
			String success = organizationManagementPage.bulkUploadOrganization("mumbail", "tarapur");
			softAssert.assertEquals(success, "×\n" + "Organizations saved successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 39, groups = { "OrgManagement" })
	public void verifyBulkUploadOrganizationWithInvalidFileInput() {
		SoftAssert softAssert = new SoftAssert();
		try {
			String warning = organizationManagementPage.invalidFileInput();
			softAssert.assertEquals(warning, "×\n" + 
					"rrrrError! File you have choosen in not excel file. Please choose only excel file to upload.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 40, groups = { "OrgManagement" })
	public void verifyExportExcelTemplateForOrganizationUpload() {
		try {
			organizationManagementPage.exportExcelTemplate();

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

		return new Object[][] { { "Cheque", "CHEQUE" }, { "Credit", "CREDIT" }, { "Credit Card", "CREDIT CARD" },
				{ "Debit Card", "DEBIT CARD" }, { "Free", "FREE" }, { "Other", "OTHER" },

		};
	}

	@DataProvider(name = "OrgPaymentType")
	public static Object[][] getOrgPaymentType() {

		return new Object[][] { { "Payment Type (Default: Walk-in)", "WalkIn", "2" }, { "Prepaid", "Prepaid", "1" },
				{ "Postpaid", "Postpaid", "0" },

		};
	}

	@DataProvider(name = "OrgNames")
	public static Object[][] getOrgNames() {

		return new Object[][] { { "Non Billing" }, { "Billing CC" },

		};
	}

	@DataProvider(name = "OrgContact")
	public static Object[][] getOrgContact() {

		return new Object[][] { { "8275369428" }, { "78452" },

		};
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}

}
