package com.livehealth.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.livehealth.base.DriverFactory;
import com.livehealth.config.ConfigProperties;
import com.livehealth.pageobject.CCBatchManagementPage;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;
import org.testng.Assert;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CCBatchManagementTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	CCBatchManagementPage ccBatchManagementPage;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "CCBatch" })
	public void launchSite() {
		try {
			ccBatchManagementPage = pageLaunch.navigateToCCBatchManagementPage();
			ccBatchManagementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 1, groups = { "CCBatch" })
	public void verifybatchManagementAccess() {
		boolean flag;
		try {
			flag = ccBatchManagementPage.batchManagementAccessionAccess("livep-cc", "Password@123", "CC2");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 2, groups = { "CCBatch" })
	public void VerifyPatientBillFromCC() {
		SoftAssert softassert = new SoftAssert();
		String success;
		try {
			success = ccBatchManagementPage.patientBill("Nitin", "T3,Total (Tri Iodothyronine)", "Androstenedione *",
					"G6PD Quantitative ");
			success = ccBatchManagementPage.patientBill("pratik", "T3,Total (Tri Iodothyronine)", "Androstenedione *",
					"G6PD Quantitative ");
			softassert.assertEquals(success, "×\n" + "Bill saved successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softassert.assertTrue(false, e.getMessage());
		}
		softassert.assertAll();
	}

	@Test(priority = 3, groups = { "CCBatch" })
	public void VerifyPendingSampleList() {
		boolean flag;
		try {
			flag = ccBatchManagementPage.pendingSampleList();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 4, groups = { "CCBatch" })
	public void VerifyPatientName() {
		String name;
		try {
			name = ccBatchManagementPage.patientName();
			Assert.assertEquals(name, "Pratik (M - 0)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 5, groups = { "CCBatch" })
	public void VerifyPrintSampleBarcodeOption() {
		List<String> list;
		try {
			list = ccBatchManagementPage.printSampleBarcode();
			Assert.assertEquals(list.get(1), "https://beta.livehealth.solutions/generateBarcode/" + list.get(0) + "/");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 6, groups = { "CCBatch" })
	public void VerifyDissmissActionOnLackedBill() {
		String warning;
		try {
			warning = ccBatchManagementPage.dissmissLockedBill();
			Assert.assertEquals(warning, "×\n"
					+ "The bill is locked because another operation is being performed on this. Please try again after a while.\n"
					+ "Check bill Status");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 7, groups = { "CCBatch" })
	public void VerifyReceiveSampleButton() {
		boolean flag;
		try {
			flag = ccBatchManagementPage.receiveSample();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 8, groups = { "CCBatch" })
	public void VerifyReceiveAndPrintButton() {
		List<String> list;
		try {
			list = ccBatchManagementPage.receiveAndPrintButton();
			Assert.assertEquals(list.get(1), "https://beta.livehealth.solutions/generateBarcode/" + list.get(0) + "/");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 9, groups = { "CCBatch" })
	public void VerifyUpdateSampleDate() {
		SoftAssert softassert = new SoftAssert();
		List<String> list;
		try {
			list = ccBatchManagementPage.updateSampleDate();
			softassert.assertEquals(list.get(0), "×\n" + "Sample date has been updated successfully.");
			softassert.assertEquals(list.get(1), list.get(2));
		} catch (Exception e) {
			logger.error(e.getMessage());
			softassert.assertTrue(false, e.getMessage());
		}
		softassert.assertAll();
	}

	@Test(priority = 11, groups = { "CCBatch" })
	public void VerifySearchSampleFilterUsingSampleId() {
		ArrayList<String> list;
		try {
			list = ccBatchManagementPage.searchSampleFilter();
			Assert.assertEquals(list.get(1), list.get(0));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 12, groups = { "CCBatch" })
	public void VerifySearchSampleFilterUsingPatientName() {
		boolean flag;
		try {
			flag = ccBatchManagementPage.searchPatientSampleFilter("Pratik");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 13, groups = { "CCBatch" })
	public void VerifySearchSampleUsingReferralFilter() {
		boolean flag;
		try {
			flag = ccBatchManagementPage.searchReferralFilter("Rahul");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 14, groups = { "CCBatch" }, dataProvider = "patientTypes")
	public void VerifyBillsWithPatientTypes(String patientType, String name) {
		String success;
		try {
			success = ccBatchManagementPage.createBillWithPatientType(patientType, name, "T3,Total (Tri Iodothyronine)",
					"Androstenedione *", "G6PD Quantitative ");
			Assert.assertEquals(success, "×\n" + "Bill saved successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 15, groups = { "CCBatch" }, dataProvider = "patientTypes")
	public void VerifyPatientTypeFilters(String patientType, String name) {
		boolean flag;
		try {
			flag = ccBatchManagementPage.patientTypeFilter(patientType, name);
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 16, groups = { "CCBatch" })
	public void VerifyClearFilterLink() {
		String value;
		try {
			value = ccBatchManagementPage.clearFilter();
			Assert.assertEquals(value, "0");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 17, groups = { "CCBatch" })
	public void VerifySelectAllCheckBox() {
		boolean flag;
		try {
			flag = ccBatchManagementPage.selectAllCheckBox();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 18, groups = { "CCBatch" })
	public void VerifySearchSampleFromCreateBatch() {
		List<String> sampleId;
		try {
			sampleId = ccBatchManagementPage.searchSampleFromCreateBatch();
			Assert.assertEquals(sampleId.get(0), sampleId.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 19, groups = { "CCBatch" })
	public void VerifyRemoveSampleFromBatch() {
		String sampleCount;
		try {
			sampleCount = ccBatchManagementPage.removeSampleFromBatch();
			Assert.assertEquals(sampleCount, "2");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 20, groups = { "CCBatch" })
	public void VerifyReceiveSampleWithManualSampleId() {
		boolean flag;
		try {
			flag = ccBatchManagementPage.receiveSampleManually("12350");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 21, groups = { "CCBatch" })
	public void VerifyBatchTempretureAndCollectingPerson() {
		SoftAssert softAssert = new SoftAssert();
		List<String> data;
		try {
			data = ccBatchManagementPage.tempretureAndCollectingPerson("12", "Dhanraj");
			softAssert.assertEquals(data.get(0), "12");
			softAssert.assertEquals(data.get(1), "Dhanraj");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 22, groups = { "CCBatch" })
	public void VerifyLogisticSummery() {
		SoftAssert softAssert = new SoftAssert();
		List<String> data;
		try {
			data = ccBatchManagementPage.logisticSummery();
			softAssert.assertEquals(data.get(0), "CC2");
			softAssert.assertEquals(data.get(1), "Livehealth (Premium plan)");
			softAssert.assertEquals(data.get(2), "CC2");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 24, groups = { "CCBatch" })
	public void VerifyBatchActivityDetails() {

		List<String> data;
		try {
			data = ccBatchManagementPage.batchActivityDetails();
			Assert.assertEquals(data.get(3) + " ", "Sample of " + data.get(1) + "(Sample ID : " + data.get(0)
					+ " , Sample Type : " + data.get(2) + ") has been add in Batch No : " + data.get(4) + "");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 25, groups = { "CCBatch" })
	public void VerifyPrintBarcodeFromBatch() {

		List<String> data;
		try {
			data = ccBatchManagementPage.printBarcode();
			Assert.assertEquals(data.get(1), "https://beta.livehealth.solutions/generateBarcode/" + data.get(0) + "/");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 26, groups = { "CCBatch" })
	public void VerifyTotalSampleCountFromMainCentreIfWeCreatedBatchFromCC() {

		String sampleCount;
		try {
			sampleCount = ccBatchManagementPage.samplesfromMainCentre(configProperties.getUsername(),
					configProperties.getPassword());
			Assert.assertEquals(sampleCount, "4");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 27, groups = { "CCBatch" })
	public void VerifyAcceptBatchSampleFromMainCentre() {

		boolean flag;
		try {
			flag = ccBatchManagementPage.acceptBatchSampleFromMainCentre();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 28, groups = { "CCBatch" })
	public void VerifyRejectBatchSampleFromMainCentre() {

		boolean flag;
		try {
			flag = ccBatchManagementPage.rejectBatchSampleFromMainCentre("livep-cc", "Password@123");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 29, groups = { "CCBatch" })
	public void VerifyAcceptAllBatchFromMainCentre() {

		boolean flag;
		try {
			flag = ccBatchManagementPage.acceptAllBatch(configProperties.getUsername(), configProperties.getPassword(),
					"livep-cc", "Password@123");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 30, groups = { "CCBatch" })
	public void VerifyEnableRejectedSample() {

		boolean flag;
		try {
			flag = ccBatchManagementPage.enableRejectedSample();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 31, groups = { "CCBatch" })
	public void VerifyDissmissRejectedSample() {

		boolean flag;
		try {
			flag = ccBatchManagementPage.dissmissRejectedSample();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 32, groups = { "CCBatch" })
	public void VerifyDissmissSampleOption() {
		boolean flag;
		try {
			flag = ccBatchManagementPage.dismissSample();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 33, groups = { "CCBatch" })
	public void VerifyPrintBarcodeFromAccessed() {
		List<String> data;
		try {
			data = ccBatchManagementPage.printBarcodeFromAccessed();
			Assert.assertEquals(data.get(1), "https://beta.livehealth.solutions/generateBarcode/" + data.get(0) + "/");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 34, groups = { "CCBatch" })
	public void VerifySearchPatientUsingSampleIdFromAccessed() {
		boolean flag;
		try {
			flag = ccBatchManagementPage.searchPatientUsingSampleId();
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 35, groups = { "CCBatch" })
	public void VerifysearchSearchPatientUsingPatientNameFromAccessed() {
		boolean flag;
		try {
			flag = ccBatchManagementPage.searchPatientUsingPatientName("Pratik");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@DataProvider(name = "patientTypes")
	public static Object[][] getPatientTypedataForAppointment() {

		return new Object[][] { { "Health Camp (HC)", "Health Camp" }, { "Red (R)", "Red" }, { "Green (G)", "Green" },

		};
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}
}
