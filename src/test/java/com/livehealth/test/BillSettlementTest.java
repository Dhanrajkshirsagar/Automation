package com.livehealth.test;

import java.util.ArrayList;
import java.util.List;

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
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BillSettlementTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	BillSettlementPage billSettlementPage;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "BillSettlement", "Test" })
	public void launchSite() {
		try {
			billSettlementPage = pageLaunch.navigateToBillSettlementPage();
			billSettlementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 1, dataProvider = "testsData", groups = { "BillSettlement" })
	public void verifyBill(String amount, String test1, String test2) {
		SoftAssert softAssert = new SoftAssert();
		String success;
		try {
			for (int i = 0; i < 3; i++) {
				success = billSettlementPage.patientBill("tushar", amount, test1, test2);
				softAssert.assertEquals(success, "×\n" + "Bill saved successfully.");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 2, groups = { "BillSettlement" })
	public void verifyBill() {
		SoftAssert softAssert = new SoftAssert();
		String success;
		try {
			for (int i = 0; i < 3; i++) {
				success = billSettlementPage.patientBill("8275369427", "200", "CR", "li");
				softAssert.assertEquals(success, "×\n" + "Bill saved successfully.");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 3, groups = { "BillSettlement" })
	public void verifyBillSettlementPage() {

		try {
			String color = billSettlementPage.billsettlementPage();
			Assert.assertEquals(color, "rgba(91, 192, 222, 1)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// In this case we have to verify patient name,bill ids,--------//
	@Test(priority = 4, groups = { "BillSettlement" })
	public void verifyBillSettlementAllDetails() {
		boolean flag;
		try {
			flag = billSettlementPage.verifydetails("tushar");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 5, groups = { "BillSettlement", "Test" })
	public void verifySettlementBillLockLabel() {
		String color;
		try {
			color = billSettlementPage.lockBillLabel("tushar");
			Assert.assertEquals(color, "rgba(217, 83, 79, 1)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 6, groups = { "BillSettlement" })
	public void verifyBillSettlementPatientDueAmount() {
		List<Integer> amount;
		try {
			amount = billSettlementPage.calculateDue("tushar");
			Assert.assertEquals(amount.get(0), amount.get(1));

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 7, groups = { "BillSettlement", "Test" })
	public void verifyBillSettlementPatientEditBillLink() {
		List<String> list;
		try {
			list = billSettlementPage.editBillLink("Tushar");
			Assert.assertEquals(list.get(1), Constants.BillingUpdate_URL + list.get(0));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 8, groups = { "BillSettlement" })
	public void verifyBillSettlementPatientBillSettlement() {
		boolean flag;
		try {
			flag = billSettlementPage.billSettlement("tushar");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 9, groups = { "BillSettlement", "Test" })
	public void verifyPatientHalfBillSettlement() {
		boolean flag;
		try {
			flag = billSettlementPage.settleHalfAmount("tusha");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 10, groups = "BillSettlement")
	public void verifyViewTransactionLinkUsingSearchPatientWithContactNumber() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = billSettlementPage.searchPatientUsingContactNumber("8275369427");
			softAssert.assertEquals(list.get(0), "Mayur");
			softAssert.assertEquals(list.get(1),
					"https://beta.livehealth.solutions/searchRegistration/#registration/bills/userName=2646");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 11, dataProvider = "paymentModes", groups = "BillSettlement")
	public void verifyPatientBillSettlementWithAllPaymentMode(String payMode, String Value) {
		SoftAssert softAssert = new SoftAssert();
		String billListPayMode;
		try {
			billListPayMode = billSettlementPage.paymentMode("tushar", payMode, Value);
			softAssert.assertEquals(billListPayMode, Value);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 12, groups = "BillSettlement")
	public void verifyAllBillsPendingBillsTab() {
		boolean flag;
		try {
			flag = billSettlementPage.pendingBillsTab();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 13, dataProvider = "PendingTabbillActions", groups = "BillSettlement")
	public void verifyPatientBillListActions(String option, String URLs, int length) {
		SoftAssert softAssert = new SoftAssert();
		String actualUrl;
		try {
			actualUrl = billSettlementPage.commenBillAction(option, URLs, length);
			softAssert.assertEquals(actualUrl, URLs);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 14, groups = "BillSettlement")
	public void VerifyCompletedBillsTab() {
		boolean flag;
		try {
			flag = billSettlementPage.completedBillsTab();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Test(priority = 15, dataProvider = "CompletedTabBillActions", groups = "BillSettlement")
	public void verifyCompletedTabBillsActions(String option, String URLs, int length) {
		SoftAssert softAssert = new SoftAssert();
		String url;
		try {
			url = billSettlementPage.completedBillsActions(option, URLs, length);
			softAssert.assertEquals(url, URLs);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 16, groups = "BillSettlement")
	public void verifyAllBillsPatientSearch() {
		boolean flag;
		try {
			flag = billSettlementPage.SearchByPatientName("Search by Patient Name", "mayur");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 17, groups = "BillSettlement")
	public void verifyAllBillsReferralsSearch() {
		boolean flag;
		try {
			flag = billSettlementPage.SearchByPatientName("Search by Referral Name", "auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 18, dataProvider = "CompletedTabBillActions", groups = "BillSettlement")
	public void verifySearchedPatientBillsActions(String option, String URLs, int length) {
		SoftAssert softAssert = new SoftAssert();
		String url;
		try {
			url = billSettlementPage.searchedBillsActions(option, URLs, length, "tushar");
			softAssert.assertEquals(url, URLs);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 19, groups = "BillSettlement")
	public void verifySearchedPatientBillsActions() {
		boolean flag;
		try {
			flag = billSettlementPage.viewAllBillsList();
			Assert.assertTrue(flag);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 20, groups = "BillSettlement")
	public void verifyPatientCompletedBillAction() {

		try {
			String success = billSettlementPage.completeBill();
			Assert.assertEquals(success, "×\n" + "Success! Bill completed Successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 21, dataProvider = "InvoiceTypesData", groups = "BillSettlement")
	public void verifySearchedPatientBillsActions(String invoiceTyoe, String name) {
		SoftAssert softAssert = new SoftAssert();
		String actualUrl;
		try {
			actualUrl = billSettlementPage.generateInvoice(invoiceTyoe, name);
			softAssert.assertEquals(actualUrl, "https://beta.livehealth.solutions/printInvoice");

		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 22, groups = "BillSettlement")
	public void verifyAddTestToExistingBill() {
		String tittle;
		try {
			tittle = billSettlementPage.addTestToExistingBill("akkas",
					"WBC:Total & Differential Counts Leucocytes Body ", "Calcium/Creatinine Ratio Urine Spot *", "500");
			Assert.assertEquals(tittle, "Add Tests In Existing Bill");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 23, groups = "BillSettlement")
	public void verifyAddTestToNewBillWithSameSampleId() {
		boolean flag;
		try {
			flag = billSettlementPage.addTestToNewBillWithSameSampleId("akkas",
					"WBC:Total & Differential Counts Leucocytes Body ", "Calcium/Creatinine Ratio Urine Spot *", "500");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 24, groups = "BillSettlement")
	public void verifyAlreadyExistedTestAddInSameBill() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = billSettlementPage.alreadyExistingTestAdd("atyh", "akkas", "Calcium/Creatinine Ratio Urine Spot  ");
			softAssert.assertEquals(list.get(0), "×\n" + "Error!No existing bill found for this patient");
			softAssert.assertEquals(list.get(1), "×\n" + "Warning! This test is already added.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 25, dataProvider = "patientData", groups = "BillSettlement")
	public void verifyStopBillWhenCreditExcedatedOrgFlag(String name) {

		try {
			billSettlementPage.stopbill(name, "Calcium/Creatinine Ratio Urine Spot  ");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 26, groups = "BillSettlement")
	public void verifyStopBillWhenCreditExcedatedOrgFlag() {
		ArrayList<Integer> orgAdvAmt;
		try {
			orgAdvAmt = billSettlementPage.orgAdavanceCalc("sumi", "400", "Calcium/Creatinine Ratio Urine Spot  ");
			Assert.assertEquals(orgAdvAmt.get(0), orgAdvAmt.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 27, dataProvider = "concessionData", groups = "BillSettlement")
	public void verifyDiscountRestrictionOnOutsourceTestAndTestWiseDiscountAndDiscountInPercentage(String test) {

		try {
			billSettlementPage.discountRestrictionOnOutsourceTest(test, "bko", "50");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 28, dataProvider = "paymentModes", groups = "BillSettlement")
	public void verifyAddTestToBillUsingDifferentPaymentMode(String mode, String value) {
		SoftAssert softAssert = new SoftAssert();
		String tittle;
		try {
			tittle = billSettlementPage.paymentType(mode, value, "sah", "Cholesterol - Tot", "100");
			softAssert.assertEquals(tittle, "Add Tests In Existing Bill");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 29, dataProvider = "AccessionNoData", groups = "BillSettlement")
	public void verifySearchUsingAccessionNo(String accessionNo) {

		boolean length;
		try {
			length = billSettlementPage.searchUsingAccessionNo(accessionNo);
			Assert.assertTrue(length);
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
				// { "Debit Card","DEBIT CARD"},
				// { "Free","FREE"},
				// { "Other","OTHER"},

		};
	}

	@DataProvider(name = "PendingTabbillActions")
	public static Object[][] getPendingTabbillActions() {

		return new Object[][] { { "Complete & Print Bill", "https://beta.livehealth.solutions/printReceipt", 46 },
				{ "Print Bill", "https://beta.livehealth.solutions/printReceipt", 46 },
				{ "Edit Bill", "https://beta.livehealth.solutions/billUpdate", 44 },
				{ "View Transactions", "https://beta.livehealth.solutions/searchRegistration/#registration", 66 },

		};
	}

	@DataProvider(name = "CompletedTabBillActions")
	public static Object[][] getCompletedTabBillActions() {

		return new Object[][] { { "Print Bill", "https://beta.livehealth.solutions/printReceipt", 46 },
				{ "Edit Bill", "https://beta.livehealth.solutions/billUpdate", 44 },
				{ "View Transactions", "https://beta.livehealth.solutions/searchRegistration/#registration", 66 },

		};
	}

	@DataProvider(name = "AccessionNoData")
	public static Object[][] getccessionNoData() {

		return new Object[][] { { "000117018" }, { "000317018" }, { "000217018" },

		};
	}

	@DataProvider(name = "patientData")
	public static Object[][] getpatientData() {

		return new Object[][] { { "pos" }, { "pramo" },

		};
	}

	@DataProvider(name = "InvoiceTypesData")
	public static Object[][] getInvoiceTypesData() {

		return new Object[][] { { "Organization", "auto" }, { "Referral", "auto" }, { "Customer", "tusha" },

		};
	}

	@DataProvider(name = "concessionData")
	public static Object[][] getConcessionData() {

		return new Object[][] { { "Mumps Virus IgM Antibody" }, { "Cytology (Non-Gyn) Nipple" },
				{ "Protein/Creatinine Ratio" },

		};
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}

}
