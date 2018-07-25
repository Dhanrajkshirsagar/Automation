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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.livehealth.base.DriverFactory;
import com.livehealth.config.ConfigProperties;
import com.livehealth.model.User;
import com.livehealth.pageobject.BillingPage;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;
import com.livehealth.validator.RegistrationValidator;
import com.livehealth.validator.TestValidation;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BillingTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	BillingPage billing;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	TestValidation testValidation;

	@Autowired
	RegistrationValidator registerValidator;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "Billing", "BillTest", "Test" })
	public void launchSite() {
		try {
			billing = pageLaunch.navigateToBillingPage();
			billing.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	// TC: 01
	@Test(groups = { "Billing" }, priority = 0)
	public void verifyBillingPage_TC_01() {

		String title;
		try {
			title = billing.getPageTitle();

			Assert.assertEquals(title, "Search using name or mobile number");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 02
	@Test(groups = { "Billing" })
	public void verifySearchUsingMobileNumber_TC_02() {
		CommonMethods.setTestDescription("Expected: Patient should be searched using patient mobile number");
		String title;
		try {
			User userInfo = getUserInfo();
			title = billing.getPageTitle(userInfo.getPhoneNumber());
			Assert.assertEquals(title, "Dhanraj");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 03
	@Test(groups = { "Billing" })
	public void verifySearchUsingName_TC_03() {
		CommonMethods.setTestDescription("Expected: Patient should be searched using patient name");
		String title;
		try {
			User userInfo = getUserInfo();
			title = billing.getPageTitle(userInfo.getName());
			Assert.assertEquals(title, "Dhanraj");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 04,06
	@Test(groups = { "Billing" })
	public void verifySearchingDirectUser_TC_04_06() {
		CommonMethods.setTestDescription("Expected: Select Patient field able to search direct patients");
		String title;
		try {
			title = billing.getPageTitle("dty");
			Assert.assertEquals(title, "Dtype");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 05
	@Test(groups = { "Billing" })
	public void verifySearchingIndirectUser_TC_05() {
		CommonMethods.setTestDescription("Expected: Select Patient field able to search indirect patients");
		String title;
		try {
			title = billing.getPageTitle("ityp");
			Assert.assertEquals(title, "Itype");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 07
	@Test(groups = { "Billing" })
	public void verifySearchPerEnteredNumber_TC_07() {
		CommonMethods.setTestDescription("Expected: Search as per entered number");
		String title;
		try {
			title = billing.getPageTitle("8275369");
			Assert.assertEquals(title, "Dhanraj");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 07
	// @Test(groups = { "billing" })
	// public void verifysearchLoader() {
	// boolean loader;
	// try {
	// User userInfo = getUserInfo();
	// loader = billing.searchLoader(userInfo.getName());
	// Assert.assertTrue(loader);
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 09
	// @Test(groups = { "bill" })
	// public void verifyRemainingDueAmt_09() {
	// CommonMethods.setTestDescription("Expected: Patient Due remaining amount");
	// List<String> billAmt;
	// try {
	// User userInfo = getUserInfo();
	// billAmt = billing.dueAmountVerification("jadeja");
	// Assert.assertEquals(billAmt.get(0), billAmt.get(1));
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 10
	@Test(groups = { "Billing" })
	public void verifyAdvanceAmount_TC_10() {
		CommonMethods.setTestDescription("Expected: patient Advance Should be 1000 in rupees");
		User userInfo = getUserInfo();
		userInfo.setName("smith");
		String advanceAmt;
		try {
			advanceAmt = billing.advanceAmountShownCorrectlyOrNot(userInfo.getName());
			Assert.assertEquals(advanceAmt, "₹ 1000");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 11
	@Test(groups = { "Billing" })
	public void verifyReferrelPriceList_TC_11() {
		CommonMethods.setTestDescription("Expected: Referral price List");
		User userInfo = getUserInfo();
		SoftAssert softAssert = new SoftAssert();
		List<String> referrel;
		try {
			referrel = billing.referrelPriceList(userInfo.getName());

			softAssert.assertEquals(referrel.get(1), "Referrel  with sumit");
			softAssert.assertEquals(referrel.get(2), "Referrel with livehealth");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 12
	@Test(groups = { "Billing" })
	public void verifyPriceListAsPerSelectedReferrel_TC_12() {
		CommonMethods.setTestDescription("Expected: Referral price List should be as per selected referral");
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		List<String> testListOne;
		List<String> testListTwo;
		try {
			testListOne = billing.priceListAsPerSelectedReferrel(userInfo.getName());
			testListTwo = billing.confirmPriceListAsPerSelectedReferrel();

			testValidation.verifyTestPrice(testListOne, testListTwo);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 13
	@Test(groups = { "Billing" })
	public void verifyCalculator_TC_13() {
		CommonMethods.setTestDescription("Expected: Calculated price should be 1050");
		String calculatedPrice;
		try {
			User userInfo = getUserInfo();
			calculatedPrice = billing.testCalculator(userInfo.getPhoneNumber());
			Assert.assertEquals(calculatedPrice, "1050");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 14
	@Test(groups = { "Billing" })
	public void verifyCompanyPriceList_TC_14() {
		User userInfo = getUserInfo();
		SoftAssert softAssert = new SoftAssert();
		List<String> orgList;
		try {
			orgList = billing.companyPriceList(userInfo.getName());

			softAssert.assertEquals(orgList.get(1), "Co Pay");
			softAssert.assertEquals(orgList.get(2), "DIRECT");
			softAssert.assertEquals(orgList.get(3), "postpaid Organization");
			softAssert.assertEquals(orgList.get(4), "Custom Org");
			softAssert.assertEquals(orgList.get(5), "Custom Prepaid");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 15
	@Test(groups = { "Billing" })
	public void verifyPriceListAsPerSelectedCompany_TC_15() {
		User userInfo = getUserInfo();
		List<String> testListOne;
		List<String> testListTwo;
		try {
			testListOne = billing.priceListAsPerSelectedCompany(userInfo.getName());
			testListTwo = billing.confirmPriceListAsPerSelectedCompany();

			testValidation.verifyTestPrice(testListOne, testListTwo);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 18
	@Test(groups = { "Billing" })
	public void verifyTypeTestNameField_TC_18() {
		User userInfo = getUserInfo();
		String searchTest;
		try {
			searchTest = billing.typeTestNameField(userInfo.getName());
			Assert.assertEquals(searchTest, "Albumin Serum");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 19
	@Test(groups = { "Billing" })
	public void verifyTestPriceAsPerSelectedTest_TC_19() {
		User userInfo = getUserInfo();
		List<String> testListOne;
		List<String> testListTwo;
		try {
			testListOne = billing.testPriceAsPerSelectedTest(userInfo.getName());
			testListTwo = billing.confirmTestPrice();

			testValidation.verifyTestPrice(testListOne, testListTwo);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 20,24
	@Test(groups = { "Billing" })
	public void verifyMultipleTestAddingSuccessfully_TC_20_24() {
		String calculatedPrice;
		try {
			User userInfo = getUserInfo();
			calculatedPrice = billing.multipleTestAddedSuccessfully(userInfo.getName());
			Assert.assertEquals(calculatedPrice, "1300");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 21
	@Test(groups = { "Billing" })
	public void verifySingleTestAddingSuccessfully_TC_21() {
		String calculatedPrice;
		try {
			User userInfo = getUserInfo();
			calculatedPrice = billing.singleTestAddedSuccessfully(userInfo.getName());
			Assert.assertEquals(calculatedPrice, "500");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 22
	@Test(groups = { "Billing" })
	public void verifyPercentageConcession_TC_22() {
		CommonMethods.setTestDescription("Expected: PercentageConcession should be calculated correctly");
		String concession;
		try {
			User userInfo = getUserInfo();
			concession = billing.isPercentageConcessionGettingSuccessfully(userInfo.getName());
			Assert.assertEquals(concession, "450");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 23
	@Test(groups = { "BillTest" })
	public void verifyCloseTestBtn_TC_23() {
		CommonMethods.setTestDescription("Expected:Close Test Btn Should close test");
		String amtAfterClosed;
		try {
			User userInfo = getUserInfo();
			amtAfterClosed = billing.removeTest(userInfo.getName());
			Assert.assertEquals(amtAfterClosed, "500");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 25
	@Test(groups = { "Billing" })
	public void verifyAlreadySelectedOrganization_TC_25() {
		List<String> orgNames;
		try {
			User userInfo = getUserInfo();
			orgNames = billing.alreadySelectedOrganization(userInfo.getName());

			Assert.assertEquals(orgNames.get(0), orgNames.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:26
	@Test(groups = { "Billing" })
	public void verifySelectOrganization_TC_26() {
		String selectedOrg;
		try {
			User userInfo = getUserInfo();
			selectedOrg = billing.selectOrganization(userInfo.getName());
			Assert.assertEquals(selectedOrg, "postpaid Organization");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:27
	@Test(groups = { "Billing" })
	public void verifyAddOrgLink_TC_27() {
		User userInfo = getUserInfo();
		String orgName;
		try {
			orgName = billing.addOrgLinkAbleToAddOrg(userInfo.getName(), "alpha");
			billing.deleteAddedOrgByAddOrgLink(orgName);

			Assert.assertEquals(orgName, "alpha");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:29
	@Test(groups = { "Billing" })
	public void verifyOtherReferrelField_TC_29() {
		boolean referelField;
		try {
			User userInfo = getUserInfo();
			referelField = billing.otherReferrelField(userInfo.getName());
			Assert.assertTrue(referelField);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:30
	@Test(groups = { "BillTest" }, priority = 20)
	public void verifySelectHomeDelivery_TC_30() {
		String selectedOption;
		try {
			User userInfo = getUserInfo();
			selectedOption = billing.selectHomeDelivery(userInfo.getName());

			Assert.assertEquals(selectedOption, "Home Delivery");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:32,33
	@Test(groups = { "BillTest" }, priority = 21)
	public void verifySelectCourierCollection_TC_32_33() {
		String selectedOption;
		try {
			User userInfo = getUserInfo();
			selectedOption = billing.selectCourierCollection(userInfo.getName());

			Assert.assertEquals(selectedOption, "Courier");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 34
	@Test(groups = { "Billing" })
	public void verifyDefaultPaymentMode_TC_34() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		String paymentMode;
		try {
			paymentMode = billing.defaultPaymentMode(userInfo.getName());
			Assert.assertEquals(paymentMode, "Payment Mode (Default: Cash)");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 35-42
	@Test(groups = { "Billing" }, dataProvider = "paymentMode")
	public void verifySetDefaultPaymentMode_TC_35To42(String setPaymentMode) {
		String paymentMode;
		try {
			paymentMode = billing.setDefaultPaymentMode("dtype", setPaymentMode);

			Assert.assertEquals(paymentMode, setPaymentMode);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 43
	@Test(groups = { "Billing" })
	public void verifyAddPaymentMode_TC_43() {
		String amount;
		try {
			User userInfo = getUserInfo();
			amount = billing.addPaymentMode(userInfo.getName());

			Assert.assertEquals(amount, "500");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 44
	@Test(groups = { "Billing" })
	public void verifyEditPaymentMode_TC_44() {
		String amount;
		try {
			User userInfo = getUserInfo();
			amount = billing.editPaymentMode(userInfo.getName());

			Assert.assertEquals(amount, "450");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 45
	@Test(groups = { "Billing" })
	public void verifyUniqueTestNameList_TC_45() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		String warningMsg;
		try {
			warningMsg = billing.uniqueTestNames(userInfo.getName());

			Assert.assertEquals(warningMsg, "Warning! This test is already added.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 46
	@Test(groups = { "Billing" })
	public void verifyUniqueTestNameForProfileTest_TC_46() {
		User userInfo = getUserInfo();
		String warningMsg;
		try {
			warningMsg = billing.uniqueTestNamesForProfile(userInfo.getName());

			Assert.assertEquals(warningMsg, "Warning! Some tests of this profile is already selected for bill");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 47
	@Test(groups = { "Billing" })
	public void verifyOrganizationAdvance_TC_47() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		String prepaidOrgAdv;
		try {
			prepaidOrgAdv = billing.organizationAdvance(userInfo.getName());

			Assert.assertEquals(prepaidOrgAdv, "₹ 1000");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 48
	@Test(groups = { "Billing" })
	public void verifyDueCutFromOrganizationAdvance_TC_48() {
		String organization = "Custom Prepaid ";
		String orgAmtDeduct;
		try {
			orgAmtDeduct = billing.dueCutFromOrganizationAdvance("nipun", organization);

			Assert.assertEquals(orgAmtDeduct, "₹ 550");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 49
	@Test(groups = { "Billing" })
	public void ifOrgAdvanceLessThanBillAmount_TC_49() {
		User userInfo = getUserInfo();
		userInfo.setName("roger");
		String saveBillErrorMsg;
		try {
			saveBillErrorMsg = billing.ifOrganizationAdvanceLessThanBillAmount(userInfo.getName());

			Assert.assertEquals(saveBillErrorMsg,
					"×\n" + "Sorry! This organization have a insufficient advance amount");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 50
	@Test(groups = { "Billing" })
	public void verifyOrgCreditLimitLessThanBillAmount_TC_50() {
		User userInfo = getUserInfo();
		userInfo.setName("roger");
		String saveBillErrorMsg;
		try {
			saveBillErrorMsg = billing.organisationCreditLimitLessThanBillAmount(userInfo.getName());

			Assert.assertEquals(saveBillErrorMsg, "Sorry! This organization have a insufficient credit amount");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 51
	@Test(groups = { "Billing" })
	public void verifyUserAdvanceAndPayableAmount_TC_51() {
		String deductedAdvance;
		try {
			deductedAdvance = billing.userAdvanceAndPayableAmount("krunal");
			Assert.assertEquals(deductedAdvance, "₹ 500");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 52
	@Test(groups = { "Billing" })
	public void verifyAdditionalPriceField_TC_52() {
		User userInfo = getUserInfo();
		String additionalPrice;
		try {
			additionalPrice = billing.additionalPriceField(userInfo.getName());

			Assert.assertEquals(additionalPrice, "1000");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 53
	@Test(groups = { "Billing" })
	public void verifyConcessionInRupees_TC_53() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		String amount;
		try {
			amount = billing.verifyConcessionInRupees(userInfo.getName());

			Assert.assertEquals(amount, "1000");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 54
	@Test(groups = { "Billing" })
	public void verifyConcessionInPercentage_TC_54() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		String amount;
		try {
			amount = billing.concessionInPercentage(userInfo.getName());

			Assert.assertEquals(amount, "945");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 55
	@Test(groups = { "Billing" })
	public void verifyDiscountCommentsFieldCompulsory_TC_55() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		boolean highlighted;
		try {
			highlighted = billing.discountCommentsField(userInfo.getName());

			Assert.assertTrue(highlighted);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 56   
	@Test(groups = { "Billing" })
	public void verifyCriticalEmergencyCheckBox_TC_56() {
		
		String label;
		try {
			label = billing.criticalAndEmergencyCheckBoxAbleToSet("benedict");
			
			 Assert.assertEquals(label, "Emergency Reports");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 57
	@Test(groups = { "Billing" })
	public void verifyReceiveSampleAndPrint_TC_57() {
		String status;
		try {
			status = billing.notFilledStatusVerification("user");
			Assert.assertEquals(status, "Not filled");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// // TC: 58
	// @Test(groups = { "Test" })
	// public void verifyCTConsentFormEditable() {
	// User inputUser = new User();
	// String name = commonMethods.getRandomString();
	// String phoneNo = commonMethods.getRandomNumber();
	//
	// String editUser;
	// try {
	// inputUser.setName(name);
	// inputUser.setPhoneNumber(phoneNo);
	// inputUser.setAge("11");
	//
	// editUser = billing.ctConsentForm("benedict");
	// Assert.assertTrue(true);
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 66
	@Test(groups = { "Billing" })
	public void verifyBackToRegistrationPage_TC_66() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		String title;
		try {
			title = billing.backToRegistrationPage(userInfo.getName());

			Assert.assertEquals(title, "Registration");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 67
	@Test(groups = { "BillTest" })
	public void verifyAdditionalServicesFlag_TC_67() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		String firstOption;
		try {
			firstOption = billing.additionalServicesFlag(userInfo.getName());

			Assert.assertEquals(firstOption, "Home Visit Services");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 70
	@Test(groups = { "Billing" })
	public void verifycollectedSampleType_TC_70() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		String selectedSampleType;
		try {
			selectedSampleType = billing.collectedSampleType(userInfo.getName());

			Assert.assertEquals(selectedSampleType, "Self");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 71,72
	@Test(groups = { "Billing" })
	public void verifyDiscountPriceList_TC_71_72() {
		User userInfo = getUserInfo();
		List<String> testListOne;
		List<String> testListTwo;
		try {
			testListOne = billing.discountPriceList(userInfo.getName());
			testListTwo = billing.confirmDiscountPriceList();

			Assert.assertEquals(testListOne.toString(), testListTwo.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
	
	// TC: 73
	@Test(groups = { "Billing" })
	public void verify​DefaultPriceList_TC_78() {
		String defaultPrice;
		try {
			defaultPrice = billing.defaultTestPriceList("benedict");

			Assert.assertEquals(defaultPrice, "500");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 74
	@Test(groups = { "Billing" })
	public void verify​TestQuantityOption_TC_74() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		int actual;
		try {
			actual = billing.testQuantityOptionFlag(userInfo.getName());

			Assert.assertEquals(actual, 3);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 76
	@Test(groups = { "default" })
	public void verify​BackDatedBillGettingSaved_TC_76() {
		User userInfo = getUserInfo();
		userInfo.setName("Benedict");
		String backdate;
		try {
			backdate = billing.backDatedBillGettingSaved(userInfo.getName());

			Assert.assertEquals(backdate, "7th May 2018");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 78
	@Test(groups = { "Billing" })
	public void verify​SearchAccessionNoBoxSearching_TC_78() {
		String useName;
		try {
			useName = billing.searchAccessionNo("123");

			Assert.assertEquals(useName, "Benedict");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 79
	// @Test(groups = { "Billing" })
	// public void verify​HomeCollectionBill() {
	// User userInfo = getUserInfo();
	// userInfo.setName("dtype");
	// HomeCollection collection = new HomeCollection();
	// try {
	// collection.setAddress("wakad");
	// collection.setCity("pune");
	// collection.setPinCode("461116");
	// HomeCollection address;
	//
	// address = billing.homeCollectionBill(userInfo.getName(), collection);
	//
	// Assert.assertEquals(address.toString(), collection.toString());
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 81
	@Test(groups = { "BillTest" })
	public void verify​DiscountToDiscountDiscardedTestFlag_TC_81() {
		User userInfo = getUserInfo();
		userInfo.setName("Benedict");
		String discountedAmt;
		try {
			discountedAmt = billing.discountToDiscountDiscardedTestFlag(userInfo.getName());

			Assert.assertEquals(discountedAmt, "1400");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 82
	// @Test(groups = { "Billing" })
	// public void verify​DiscountGettingDiscardedShowingWarningMsg() {
	// User userInfo = getUserInfo();
	// userInfo.setName("Benedict");
	// String message;
	// try {
	// message =
	// billing.discountGettingDiscardedShowingWarningMsg(userInfo.getName());
	//
	// Assert.assertEquals(message, "1400");
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 82
	@Test(groups = { "Billing" }, priority = 10)
	public void verifyAllowedDiscountOnBill_TC_82() {
		User userInfo = getUserInfo();
		userInfo.setName("benedict");
		String amount;
		try {
			amount = billing.allowedDiscountOnBill(userInfo.getName());

			Assert.assertEquals(amount, "250");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 83
	@Test(groups = { "Billing" })
	public void verifyMoreThanAllowedDiscountOnBill_TC_83() {
		User userInfo = getUserInfo();
		userInfo.setName("benedict");
		String errorMessage;
		try {
			errorMessage = billing.moreThanAllowedDiscountOnBill(userInfo.getName());

			Assert.assertEquals(errorMessage, "You can give only 50% discount.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 57
	// @Test(groups = { "Billing" })
	// public void verifySaveAndPrintBill() {
	// User userInfo = getUserInfo();
	// userInfo.setName("benedict");
	// String confirmMsg;
	// try {
	// confirmMsg = billing.saveAndPrintBill(userInfo.getName());
	//
	// Assert.assertEquals(confirmMsg, "Bill saved successfully.");
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 61
	@Test(groups = { "Billing" })
	public void verifyFormF_TC_61() {
		SoftAssert softAssert = new SoftAssert();
		List<String> list;
		try {
			list = billing.formFConsentForm("benedict");

			softAssert.assertEquals(list.get(0), "Benedict");
			softAssert.assertEquals(list.get(1), "Age - 10");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	private User getUserInfo() {
		User user = new User();
		user.setName("Dhanraj");
		user.setPhoneNumber("8275369428");

		return user;
	}

	@DataProvider(name = "paymentMode")
	public Object[][] getUserTypeData() {

		return new Object[][] { { "CHEQUE" }, { "CREDIT" }, { "CREDIT CARD" }, { "DEBIT CARD" }, { "FREE" },
				{ "ONLINE" } };
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}
}
