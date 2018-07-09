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
import com.livehealth.pageobject.AccessionPage;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccessionTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(AccessionTest.class);

	AccessionPage accession;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "Accession" })
	public void launchSite() {
		try {
			accession = pageLaunch.navigateToAccessionPage();
			accession.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}
	/*
	// TC: 01
	@Test(groups = { "Accession" })
	public void verifyPendingList_01() {
		boolean pendingList;
		try {

			pendingList = accession.pendingAccessionList();
			Assert.assertTrue(pendingList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 04
	@Test(groups = { "Accession" })
	public void verifyDismissSample_04() {
		boolean dismissed;
		try {

			dismissed = accession.dismissSample();
			Assert.assertTrue(dismissed);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 05 F
	@Test(groups = { "Accession" })
	public void verifyDismissSampleConfirmationModel_05() {
		String confirmation;
		try {

			confirmation = accession.dismissSampleConfirmation();
			Assert.assertEquals(confirmation, "Do you want to dismiss this sample?");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 06
	@Test(groups = { "Accession" })
	public void verifyReceiveButton_06() {
		String recv;
		try {

			recv = accession.receiveSample("Checkreceive");
			Assert.assertEquals(recv, "Checkreceive (M - 10)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:07
	// @Test(groups = { "Accession" })
	// public void verifyReceivePrintButton() {
	// String recv;
	// try {
	//
	// recv = accession.receiveAndPrint();
	// Assert.assertEquals(recv, "Checkreceive (M - 10)");
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC:20
	@Test(groups = { "Accession" })
	public void verifyTestsNameListInSimpleWorkList_20() {
		int testList;
		try {

			testList = accession.testsNameListInSimpleWorkList();
			Assert.assertEquals(testList, 955);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:23
	@Test(groups = { "Accession" })
	public void verifySimpleWorklistWithoutAccessionNo_23() {
		int testList;
		try {

			testList = accession.testsNameListInSimpleWorkListWithoutAccNo();
			Assert.assertEquals(testList, 955);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:24,30
	@Test(groups = { "Accession" })
	public void verifyAccessedSampleList_24_30() {
		List<String> recv;
		try {

			recv = accession.accessedSampleListAbleToShowOnlyAccessedList("Accessedonly");
			Assert.assertEquals(recv.get(0), recv.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 28
	@Test(groups = { "Accession" })
	public void verifyAccessionNumOnAccessedSample_28() {
		boolean recv;
		try {

			recv = accession.accessionNumOnAccessedSample();
			Assert.assertTrue(recv);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 29
	@Test(groups = { "Accession" })
	public void verifyRedrawSample_29() {
		String redrawe;
		try {

			redrawe = accession.redrawSample("redraw");
			Assert.assertEquals(redrawe, "Sample Redrawn");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 30
	@Test(groups = { "Accession" })
	public void verifyRedrawSampleConfirmation_30() {
		String redrawConfirmation;
		try {

			redrawConfirmation = accession.redrawSampleConfirmation("redraw");
			Assert.assertEquals(redrawConfirmation, "Do you want to redraw this report?");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 33 (option not getting clicked)
	// @Test(groups = { "Accession" }/* ,dependsOnMethods="verifyReceiveButton"
	// public void verifyUncollectSample() {
	// boolean uncollect;
	// try {
	//
	// uncollect = accession.uncollectSample();
	// Assert.assertTrue(uncollect);
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 44
	@Test(groups = { "Accession" })
	public void verifyTestsNameInDepartmentWiseWorkList_44() {
		int testList;
		try {

			testList = accession.testsNameListInDepartmentWiseWorkList();
			Assert.assertEquals(testList, 955);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 45
	@Test(groups = { "Accession" })
	public void verifyTestsNameInTestWiseWorkList_45() {
		int testList;
		try {

			testList = accession.testsNameListInTestwiseWorkList();
			Assert.assertEquals(testList, 955);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 48
	@Test(groups = { "Accession" })
	public void verifySimpleWorklist_Accessed_48() {
		int testList;
		try {

			testList = accession.testsNameListInSimpleWorkList_Accessed();
			Assert.assertEquals(testList, 955);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 51
	@Test(groups = { "Accession" })
	public void verifySimpleWorklistWithoutAccessionNo_Accessed_51() {
		int testList;
		try {

			testList = accession.testsNameInSimpleWorkListWithoutAccNo_Accessed();
			Assert.assertEquals(testList, 955);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 52()
	@Test(groups = { "Accession" })
	public void verifyAddEditAccessionType_52() {
		String text;
		try {

			text = accession.addEditAccessionType();
			Assert.assertEquals(text, "Add new sample type");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 53
	@Test(groups = { "Accession" })
	public void verifyAddSampleCheckbox_53() {
		String text;
		try {

			text = accession.deleteSample("fromSample");
			Assert.assertEquals(text, "fromSample");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 54
	@Test(groups = { "Accession" })
	public void verifyEditSample_54() {
		List<String> list;
		try {
			String typeSample = commonMethods.getRandomString();
			list = accession.editSample(typeSample);
			Assert.assertEquals(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 55
	@Test(groups = { "Accession" })
	public void verifySearchSampleType_55() {
		String sampleType;
		try {

			sampleType = accession.searchSampleType();
			Assert.assertEquals(sampleType, "Ascitic Fluid");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 56 FF__Pending
	@Test(groups = { "Accession" })
	public void verifyAddTestField_56() {
		String testName;
		try {

			testName = accession.mappingTestAddForSelectedSample();
			Assert.assertEquals(testName, "Cholesterol - Total");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 57
	@Test(groups = { "Accession" })
	public void verifyAddingAlreadyAddedTest_57() {
		String errorMsg;
		try {

			errorMsg = accession.alreadyAddedTestNotAbleToAdd();
			Assert.assertEquals(errorMsg, "Exists! The tests you are trying to add already exist in this list.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 58
	@Test(groups = { "Accession" })
	public void verifyRemoveSymbol_58() {
		String assigned;
		try {

			assigned = accession.removedTestsAssignedToSelectedSample();
			Assert.assertEquals(assigned, "IONIC CALCIUM");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 59
	@Test(groups = { "Accession" })
	public void verifyRemoveSymbolForDefaultNone_59() {
		String assigned;
		try {

			assigned = accession.removedTestsAssignedToDefaultNoneSample();
			Assert.assertEquals(assigned, "None");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 60
	@Test(groups = { "Accession" })
	public void verifyDeleteSampleAssignTestToSelectedSample_60() {
		SoftAssert softAssert = new SoftAssert();
		List<String> testList;
		try {

			testList = accession.deleteSampleAssignTestToSelectedSample("fromSample");
			softAssert.assertEquals(testList.get(0), "IONIC CALCIUM");
			softAssert.assertEquals(testList.get(1), "CPK, Total");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 61,62
	@Test(groups = { "Accession" })
	public void verifyDeleteSymbolForDefaultNone_61() {
		String assigned;
		try {

			assigned = accession.deleteSampleAssignTestToDefaultNone("fromSample");
			Assert.assertEquals(assigned, "None");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 63
	@Test(groups = { "Accession" })
	public void verifyAssignedTestList_63() {
		SoftAssert softAssert = new SoftAssert();
		List<String> testList;
		try {

			testList = accession.sampleTypeShouldShowAssignedTests("Livehealth");
			softAssert.assertEquals(testList.get(0), "Protein Ascitic Fluid *");
			softAssert.assertEquals(testList.get(1), "CBC/ESR");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 65
	@Test(groups = { "Accession" })
	public void verifyEmergencyFlagPendingAccession_65() {
		String flag;
		try {

			flag = accession.emergencyFlagOnPendingAccession("Roger");
			Assert.assertEquals(flag, "Emergency Reports");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 66
	@Test(groups = { "Accession" },dependsOnMethods="verifyEmergencyFlagPendingAccession_65")
	public void verifyEmergencyFlagAccessedAccession_66() {
		String flag;
		try {

			flag = accession.emergencyFlagOnAccessedAccession();
			Assert.assertEquals(flag, "Emergency Reports");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}*/
/*	
	// TC: 68
	@Test(groups = { "Accession" })
	public void verifySampleSearch_68() {
		List<String> sampleIdList;
		try {

			sampleIdList = accession.sampleSearchAbleToSelectSample();
			Assert.assertEquals(sampleIdList.get(0), sampleIdList.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 69
	@Test(groups = { "Accession" })
	public void verifySearchByUserName_69() {
		List<String> sampleIdList;
		try {

			sampleIdList = accession.searchByUserName();
			Assert.assertEquals(sampleIdList.get(0), sampleIdList.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 70
	@Test(groups = { "Accession" }, priority = 0)
	public void verifyReferralSearch_70() {
		boolean referrel;
		try {

			referrel = accession.searchByReferrel();
			Assert.assertTrue(referrel);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 71
	@Test(groups = { "Accession" })
	public void verifyOrganizationSearch_71() {
		boolean referrel;
		try {

			referrel = accession.searchByOrganization();
			Assert.assertTrue(referrel);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}*/

	// TC: 72
	@Test(groups = { "Accession" })
	public void verifyAllSamplesDropdown_72() {
		boolean referrel;
		try {

			referrel = accession.allSamplesDropdown();
			Assert.assertTrue(referrel);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 73
	@Test(groups = { "Accession" })
	public void verifyOutsourcedOnlyDropdown_73() {
		boolean referrel;
		try {

			referrel = accession.outsourcedOnlyDropdown();
			Assert.assertTrue(referrel);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 74
	@Test(groups = { "Accession" })
	public void verifyNotOutsourcedOnlyDropdown_74() {
		boolean referrel;
		try {

			referrel = accession.notOutsourcedOnlyDropdown();
			Assert.assertTrue(referrel);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	
/*
	// TC: Batch_01
	@Test(groups = { "Accession" })
	public void verifyCreateBatch() {
		List<String> list;
		try {

			list = accession.createBatch();
			Assert.assertEquals(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: Batch_02
	@Test(groups = { "Accession" })
	public void verifyAddAllPendingButton() {
		List<Integer> list;
		try {

			list = accession.addAllPending();
			Assert.assertEquals(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: Batch_03
	@Test(groups = { "Accession" })
	public void verifyRemoveSampleFromBatch() {
		boolean referrel;
		try {

			referrel = accession.removeSampleFromBatch();
			Assert.assertTrue(referrel);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: Batch_04
	@Test(groups = { "Accession" })
	public void verifySearchSample() {
		String sampleId;
		try {

			sampleId = accession.searchSample();
			Assert.assertEquals(sampleId, "222");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: Batch_05
	@Test(groups = { "Accession" })
	public void verifyBatchCanNotEmpty() {
		String errorMsg;
		try {

			errorMsg = accession.batchCanNotEmpty();
			Assert.assertEquals(errorMsg, "Please add sample before deleting this sample.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: Batch_06 F
	@Test(groups = { "Accession" })
	public void verifyVacutainerSummary() {
		List<Integer> list;
		try {

			list = accession.vacutainerSummery();

			Assert.assertEquals(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: Batch_10 F
	@Test(groups = { "Accession" })
	public void verifyBatchSampleTotal() {
		List<Integer> list;
		try {

			list = accession.sampleTotal();

			Assert.assertEquals(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: Batch_11 F
	@Test(groups = { "Accession" })
	public void verifyVacutainerTotal() {
		List<Integer> list;
		try {

			list = accession.vacutainerTotal();

			Assert.assertEquals(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: Batch_14
	@Test(groups = { "Accession" })
	public void verifyViewAndReceiveButton() {
		String viewReceive;
		try {

			viewReceive = accession.viewAndReceiveButton();

			Assert.assertEquals(viewReceive, "Selenium Automation (Livehealth)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: Batch_15
	@Test(groups = { "Accession" })
	public void verifyRejectLinkInViewAndReceive() {
		boolean isRejected;
		try {

			isRejected = accession.rejectLinkInViewAndReceive();

			Assert.assertTrue(isRejected);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: Batch_16
	@Test(groups = { "Accession" })
	public void verifyAcceptLinkInViewAndReceive() {
		List<String> list;
		try {

			list = accession.acceptLinkInViewAndReceive();

			Assert.assertEquals(list.get(0), list.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}*/

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}
}
