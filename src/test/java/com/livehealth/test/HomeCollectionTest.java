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
import com.livehealth.model.BillData;
import com.livehealth.pageobject.HomeCollectionPage;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HomeCollectionTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	HomeCollectionPage homeCollectionPage;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "HomeCollection" })
	public void launchSite() {
		try {
			homeCollectionPage = pageLaunch.navigateToHomeCollectionPage();
			homeCollectionPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority=1,groups = { "HomeCollection" })
	public void verifyHcTittle() {

		try {
			String tittle = homeCollectionPage.getHcTitle();
			Assert.assertEquals(tittle, "Home Collection");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}


	@Test(priority=2,groups = { "HomeCollection" })
	public void verifyHcAllFieldsValidation() {
		SoftAssert softAssert = new SoftAssert();
		List<String> list ;
		try {
			list = homeCollectionPage.takeNewHcRequestValidations();
			softAssert.assertEquals(list.get(0), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(1), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(2), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(3), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(4), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(5), "rgb(255, 0, 0)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority=3,groups = { "HomeCollection" })
	public void verifyHcRequestWithAllDetails() {
		String Url;
		try {
			Url = homeCollectionPage.takeNewHCRequest();
			Assert.assertEquals(Url, "https://beta.livehealth.solutions/billing");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority=4,groups = { "HomeCollection" })
	public void VerifyViewDetailsLink() {
		SoftAssert softAssert = new SoftAssert();
		List<String> list;
		try {
			list = homeCollectionPage.viewDetails();
			softAssert.assertEquals(list.get(0), HomeCollectionPage.expectedName);
			softAssert.assertEquals(list.get(1), HomeCollectionPage.expectedContact);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();

	}

	@Test(priority=5,groups = { "HomeCollection" })
	public void verifyHcRequestForExistingPatient() {
		SoftAssert softAssert = new SoftAssert();
		String Url;
		try {
			Url = homeCollectionPage.takeNewHCForExistingPatient("mayu");
			softAssert.assertEquals(Url, "https://beta.livehealth.solutions/billing");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();

	}
	@Test(priority=6,groups = { "HomeCollection" })
	public void verifyRescheduleHcValidation() {
		String text;
		try {
			text = homeCollectionPage.rescheduleHCValidation();
			Assert.assertEquals(text, "×\n" + 
					"Please select valid time range.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority=7,groups = { "HomeCollection" })
	public void verifyRescheduleHcRequestFormPendingTab() {
		boolean flag;
		try {
			flag = homeCollectionPage.rescheduleHcFromPendingTab();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority=8,dataProvider = "patientDesignationData",groups = { "HomeCollection" })
	public void verifyHcWithDesignations(String designation, String value) {
		SoftAssert softAssert = new SoftAssert();
		String desingation;
		try {
			desingation = homeCollectionPage.HcWithDesignations(designation, value);
			softAssert.assertEquals(desingation, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority=9,dataProvider = "adavanceAmounts",groups = { "HomeCollection" })
	public void verifyproceedToBillButton(String advance) {
		SoftAssert softAssert = new SoftAssert();
		String success;
		try {
			success = homeCollectionPage.proceedToBill("Calcium/Creatinine Ratio Urine Spot *", "GRAM STAIN *", advance);
			softAssert.assertEquals(success, "×\n" + "Bill saved successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority=10,groups = { "HomeCollection" })
	public void verifydatePicker() {

		List<String> list;
		try {
			list = homeCollectionPage.datePicker();
			Assert.assertEquals(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority=11,groups = { "HomeCollection" })
	public void verifyRescheduleHcRequestFromUnAssingedTab() {
		boolean flag;
		try {
			flag=homeCollectionPage.rescheduleFromUnassignedTab();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority=12,groups = { "HomeCollection" })
	public void verifyPaidBillsFromUnasignedHcTab() {
	boolean flag;
		try {
			flag=homeCollectionPage.verifyPaidBills();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}
	@Test(priority=13,groups = { "HomeCollection" })
	public void verifyDueBillsFromUnasignedHcTab() {
	boolean flag;
		try {
			flag=homeCollectionPage.dueBills();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority=14,groups = { "HomeCollection" })
	public void verifyTestAndBillDetails() {
		boolean flag;
		try {
			flag=homeCollectionPage.verifyTestDetails();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority=15,groups = { "HomeCollection" })
	public void verifyAssignCollectingPersonFromUnasignedHcTab() {
		List<String> personName;
		try {
			personName=homeCollectionPage.assignCollectingPerson("Full");
			Assert.assertEquals(personName.get(0), "rgba(91, 192, 222, 1)");
			Assert.assertEquals(personName.get(1), "Assigned To : " + "Full");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority=16,groups = { "HomeCollection" })
	public void verifyCancelHCFromUnasignedHcTab() {
		boolean flag;
		try {
			flag=homeCollectionPage.checkCancel();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	@Test(priority=17,groups = { "HomeCollection" })
	public void verifyReAssignPerson() {
		String personName;
		try {
			personName=homeCollectionPage.reAssignPerson("Full");
			Assert.assertEquals(personName, "Assigned To : " + "Full");
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Test(priority=18,groups = { "HomeCollection" })
	public void verifyCollectingPersonFilter() {
		boolean flag;
		try {
			flag=homeCollectionPage.collectingPersonFilter();
			Assert.assertTrue(flag);
			} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@Test(priority=19,groups = { "HomeCollection" })
	public void verifyOngoningAssingedHCTab() {
		boolean flag;
		try {
			flag=homeCollectionPage.assingedTab();
			Assert.assertTrue(flag);
			} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	@DataProvider(name="adavanceAmounts") 
		public static Object[][] getaAdavanceAmounts(){

			return new Object[][] {
				{ "500" },
				{ "850" },
				{ "" },

					};
		}
	
	@DataProvider(name="patientDesignationData") 
		public static Object[][] getPatientDesignationdata(){

			return new Object[][] {
				{ "Mr.", "Mr." },
				{ "Mrs.", "Mrs." },
//				{ "Ms.", "Ms." },
//				{ "Master","Master"},
				{ "Miss","Miss"},
				{"Smt.","Smt."},
				{"Dr.","Dr."},
//				{"Baby or Just Born (B/O)","B/O"},
//				{"Baby","Baby"},   
    
					};
					
		}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}

}
