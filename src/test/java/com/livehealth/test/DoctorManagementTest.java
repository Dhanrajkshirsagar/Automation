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
import com.livehealth.pageobject.DoctorManagementPage;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DoctorManagementTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);


	DoctorManagementPage doctorManagementPage;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "DocManagement" })
	public void launchSite() {
		try {
			doctorManagementPage = pageLaunch.navigateToDoctorManagementPage();
			doctorManagementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 1, groups = { "DocManagement" })
	public void verifyDoctorAddPage() {

		try {
			doctorManagementPage.addEditDoc();
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 2, groups = { "DocManagement" })
	public void verifyDoctorAddValidation() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list=doctorManagementPage.addDocValidation("9960502012");
			softAssert.assertEquals(list.get(0), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(1), "×\n" + "Error! Please fill the contact.");
			softAssert.assertEquals(list.get(2), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(3), "rgb(255, 0, 0)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 3, groups = { "DocManagement" })
	public void verifyAddDoctorAddWithAllDetails() {
		boolean flag;
		try {
			flag=doctorManagementPage.addDoctorWithAllDetails("pratik", "7451202020", "pratik@gmail.com");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 4, groups = { "DocManagement" })
	public void verifyAddedDoctorAllDetailsFromUpdateTab() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list=doctorManagementPage.addedDoctordetails("pratik", "7451202020", "pratik@gmail.com");
			softAssert.assertEquals(list.get(0), "pratik");
			softAssert.assertEquals(list.get(1), "7451202020");
			softAssert.assertEquals(list.get(2), "pratik@gmail.com");
			softAssert.assertEquals(list.get(3), "1234");
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 5, groups = { "DocManagement" })
	public void verifyContactFieldValidation() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list=doctorManagementPage.contactFieldValidation("7451202020", "74510");
			softAssert.assertEquals(list.get(0), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(1), "Invalid number");
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 6, groups = { "DocManagement" })
	public void verifyAlreadyExistedDoctorNameAndEmailValidation() {
		boolean flag;
		try {
			flag=doctorManagementPage.docUserNameValidation("pratik");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Test(priority = 7, groups = { "DocManagement" })
	public void verifyDoctorNameAndEmailValidation() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list=doctorManagementPage.DocNameAndEmailField("pratik", "pratik@gmail.com");
			softAssert.assertEquals(list.get(0), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(1), "rgb(255, 0, 0)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 8, groups = { "DocManagement" })
	public void verifyAddDoctorUsingDOBAndDOA() {
		boolean flag;
		try {
			flag=doctorManagementPage.addDoctorwithDOBAndDOA("manish", "7410263200");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 9, dataProvider = "DoctorDesignation", groups = { "DocManagement" })
	public void verifyAddDoctorUsingAllDesignation(String designation, String confirmText) {
		String Docdesignation;
		try {
			Docdesignation=doctorManagementPage.addDoctorWithDesignation(designation, confirmText);
			Assert.assertEquals(Docdesignation, confirmText);
	
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 10, groups = { "DocManagement" })
	public void verifyAddDoctorUsingAsReferralFlag() {
		String DocName;
		try {
			DocName=doctorManagementPage.addDoctorAsReferralFlag("DocAsReflag");
			Assert.assertEquals(DocName, "DocAsReflag");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 11, groups = { "DocManagement" })
	public void verifyAddDoctorWithAddVisitingTime() {
		boolean flag;
		try {
			flag=doctorManagementPage.addVisitingTime("Visiting Doc", "Mon", "Tue", "Wed", "8:00 pm");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 12, groups = { "DocManagement" })
	public void verifyUpdateDoctorWithUpdateVisitingTime() {
		boolean flag;
		try {
			flag=doctorManagementPage.updateVisitingTime("Visiting Doc", "Sat", "8:00 pm");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 13, groups = { "DocManagement" })
	public void verifyUpdateDoctorDetails() {
		String confirmUpdate ;
		try {
			confirmUpdate=doctorManagementPage.updateDoctorDetails("pratik");
			Assert.assertEquals(confirmUpdate, "0");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 14, groups = { "DocManagement" })
	public void verifyUpdatedDoctorDetailsFromUpdate() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list=doctorManagementPage.checkUpdatedDoctorDetails("Updated Doc");
			softAssert.assertEquals(list.get(0), "Updated Doc");
			softAssert.assertEquals(list.get(1), "8451201020");
			softAssert.assertEquals(list.get(2), "updated@gmail.com");

		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 15, groups = { "DocManagement" })
	public void verifyDoctorUserNameValidationFromUpdateDoctor() {
		boolean flag;
		try {
			flag=doctorManagementPage.docUserNameValidationFromUpdateDoc("pratik");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 16, groups = { "DocManagement" })
	public void verifyDeleteDoctorButton() {
		boolean flag;
		try {
			flag=doctorManagementPage.deleteDoc("Updated Doc");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 17, groups = { "DocManagement" })
	public void verifyAssignDoctorRevenueList() {

		try {
			String listName = doctorManagementPage.assignPriceList("auto", "doctor");
			Assert.assertEquals(listName, "Doctor revenue");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 18, groups = { "DocManagement" })
	public void verifyReAssignNewDoctorRevenueListForAlreadyAssignedDoctor() {

		try {
			String listName = doctorManagementPage.assignPriceListForAlreadyAssigned("auto", "ReAssign Doctor");
			Assert.assertEquals(listName, "ReAssign Doctor RevList");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 19, groups = { "DocManagement" })
	public void verifyviewListLink() {

		try {
			String URL = doctorManagementPage.viewListLink("auto");
			Assert.assertEquals(URL, "https://beta.livehealth.solutions/listManagement/#65");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 20, groups = { "DocManagement" })
	public void verifyExportListLink() {

		try {
			doctorManagementPage.ExportListLink("auto");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 21, groups = { "DocManagement" })
	public void verifyUpdateSelectedTimeRangeRevenue() {
		boolean flag;
		try {
			flag=doctorManagementPage.updateSelectedTimeRangeRevenue("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 22, groups = { "DocManagement" })
	public void verifyUpdateAllRevenueFlag() {
		boolean flag;
		try {
			flag=doctorManagementPage.updateAllRevenue("auto");
			Assert.assertTrue(flag);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 23, groups = { "DocManagement" })
	public void verifyAssignPriceListAddConcessionCut() {

		try {
			String discount=doctorManagementPage.concessionCut("auto");
			Assert.assertEquals(discount, "20");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 24, groups = { "DocManagement" })
	public void verifyRemoveAssignedList() {
		boolean flag;
		try {
			flag=doctorManagementPage.removeAssignedList("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 25, groups = { "DocManagement" })
	public void verifyCalculatedDocRevenueTrackerAmount() {
		ArrayList<Integer> list;
		try {
			list=doctorManagementPage.calculateTotalAmount("auto");
			Assert.assertEquals(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 26, dataProvider = "testsDataForDocRev", groups = { "DocManagement" })
	public void verifyPatientBills(String concession, String test1, String test2) {

		try {
			DriverFactory.getDriver().navigate().to(Constants.Billing_URL);
			for (int i = 0; i < 2; i++) {
					doctorManagementPage.patientBill("Manis", concession, test1, test2);
			}
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 27, groups = { "DocManagement" })
	public void verifyPatientBillsDetails() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list=doctorManagementPage.alldetails("auto");
			softAssert.assertEquals(list.get(0), "autoReferral");
			softAssert.assertEquals(list.get(1), "Manish");
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();

	}

	@Test(priority = 28, groups = { "DocManagement" })
	public void verifyAllBillsTab() {
		boolean flag;
		try {
			flag=doctorManagementPage.AllBillsTab("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 29, groups = { "DocManagement" })
	public void verifyDiscountedTab() {
		boolean flag;
		try {
			flag=doctorManagementPage.discountedTab("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 30, groups = { "DocManagement" })
	public void verifyNotDiscountedTab() {
		boolean flag;
		try {
			flag=doctorManagementPage.NotDiscountedTab("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 31, groups = { "DocManagement" })
	public void verifySubmitDocRevenue() {
		boolean flag;
		try {
			flag=doctorManagementPage.submitDocRevenue("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 32, groups = { "DocManagement" })
	public void verifySendEmailSMSFlag() {
		boolean flag;
		try {
			flag=doctorManagementPage.sendEmailSMS("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 33, groups = { "DocManagement" })
	public void verifyRemoveBillsIcon() {
		boolean flag;
		try {
			flag=doctorManagementPage.removeBills("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 34, groups = { "DocManagement" })
	public void verifyTotalDoctorRevenueAmountfromConfirmationModal() {
		boolean flag;
		try {
			flag=doctorManagementPage.totalAmount("auto");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority = 35, groups = { "DocManagement" })
	public void verifySelectAllBillsFlags() {

		try {
			String warning=doctorManagementPage.selectAllBills("auto");
			Assert.assertEquals(warning, "×\n" + "No pending bills found for the selected doctor.");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@DataProvider(name = "DoctorDesignation")
	public static Object[][] getDoctorDesignation() {

		return new Object[][] { { "Dr", "Dr." }, { "DrMs", "Dr. (Ms)" }, { "DrSmt", "Dr. (Smt)" },

		};
	}

	@DataProvider(name = "testsDataForDocRev")
	public static Object[][] GetTestsDataForDocRev() {

		return new Object[][] { { "100", "Alpha Feto Protein Serum -AFP", "Calcium/Creatinine Ratio Urine Spot" },
				{ "0", "Alpha Feto Protein Serum -AFP", "Calcium/Creatinine Ratio Urine Spot" },
				{ "0", "Alpha Feto Protein Serum -AFP", "Calcium/Creatinine Ratio Urine Spot" },
				{ "200", "Alpha Feto Protein Serum -AFP", "Calcium/Creatinine Ratio Urine Spot" },

		};
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}

}
