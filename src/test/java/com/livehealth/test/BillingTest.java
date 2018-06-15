package com.livehealth.test;

import java.io.File;
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
import com.livehealth.model.HomeCollection;
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

	@BeforeClass(groups = { "billing", "billing2" })
	public void launchSite() {
		try {
			billing = pageLaunch.navigateToBillingPage();
			billing.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	// TC: 01
	@Test(groups = { "billing" }, priority = 0)
	public void verifyBillingPage() {

		String title;
		try {
			title = billing.getPageTitle();

			Assert.assertEquals(title, "Billing");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}

	}

	// TC: 02
	@Test(groups = { "billing" })
	public void verifySearchUsingMobileNumber() {

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

	// TC: 02
	@Test(groups = { "billing" })
	public void verifySearchUsingName() {

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

	// TC: 03,06
	@Test(groups = { "billing" })
	public void verifySearchingDirectUser() {

		String title;
		try {
			title = billing.getPageTitle("dty");
			Assert.assertEquals(title, "Dtype");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 03
	@Test(groups = { "billing" })
	public void verifySearchingIndirectUser() {

		String title;
		try {
			title = billing.getPageTitle("ityp");
			Assert.assertEquals(title, "Itype");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 05
	@Test(groups = { "billing" })
	public void verifySearchPerEnteredNumber() {

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
	@Test(groups = { "billing" })
	public void verifyRemainingDueAmt() {
		List<String> billAmt;
		try {
			User userInfo = getUserInfo();
			billAmt = billing.dueAmountVerification(userInfo.getName());
			Assert.assertEquals(billAmt.get(0), billAmt.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 10
	@Test(groups = { "billing" })
	public void verifyAdvanceAmount() {
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
	@Test(groups = { "billing" })
	public void verifyReferrelPriceList() {
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
	@Test(groups = { "billing" })
	public void verifyPriceListAsPerSelectedReferrel() {
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
	@Test(groups = { "billing" })
	public void verifyCalculator() {
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
	@Test(groups = { "billing" })
	public void verifyCompanyPriceList() {
		User userInfo = getUserInfo();
		SoftAssert softAssert = new SoftAssert();
		List<String> orgList;
		try {
			orgList = billing.companyPriceList(userInfo.getName());

			softAssert.assertEquals(orgList.get(1), "link org");
			softAssert.assertEquals(orgList.get(2), "DIRECT");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 15
	@Test(groups = { "billing" })
	public void verifyPriceListAsPerSelectedCompany() {
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
	@Test(groups = { "billing" })
	public void verifyTypeTestNameField() {
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
	@Test(groups = { "billing" })
	public void verifyTestPriceAsPerSelectedTest() {
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
	@Test(groups = { "billing" })
	public void verifyMultipleTestAddingSuccessfully() {
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
	@Test()
	public void verifySingleTestAddingSuccessfully() {
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
	@Test(groups = { "billing" })
	public void verifyPercentageConcession() {
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
	@Test(groups = { "billing2" })
	public void verifyCloseTestBtn() {
		boolean isClosed;
		try {
			User userInfo = getUserInfo();
			isClosed = billing.removeTest(userInfo.getName());
			Assert.assertTrue(isClosed);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 25
	@Test(groups = { "billing" })
	public void verifyAlreadySelectedOrganization() {
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
	@Test()
	public void verifySelectOrganization() {
		String selectedOrg;
		try {
			User userInfo = getUserInfo();
			selectedOrg = billing.selectOrganization(userInfo.getName());
			Assert.assertEquals(selectedOrg, "link org");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:27
	@Test()
	public void verifyAddOrgLink() {
		User userInfo = getUserInfo();
		String orgName;
		try {
			orgName = billing.addOrgLinkAbleToAddOrg(userInfo.getName(), "live");
			billing.deleteAddedOrgByAddOrgLink(orgName);

			Assert.assertEquals(orgName, "live");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC:29
	@Test()
	public void verifyOtherReferrelField() {
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
	@Test(groups = { "billing3" })
	public void verifySelectHomeDelivery() {
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
	@Test(groups = { "billing3" })
	public void verifySelectCourierCollection() {
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
	@Test(groups = { "billing" })
	public void verifyDefaultPaymentMode() {
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
	@Test(groups = { "billing" }, dataProvider = "paymentMode")
	public void verifySetDefaultPaymentMode(String setPaymentMode) {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		String paymentMode;
		try {
			paymentMode = billing.setDefaultPaymentMode(userInfo.getName(), setPaymentMode);

			Assert.assertEquals(paymentMode, setPaymentMode);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 43,44
	@Test(groups = { "billing" })
	public void verifyAddPaymentMode() {
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

	// TC: 45
	@Test(groups = { "billing" })
	public void verifyUniqueTestNameList() {
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
	@Test(groups = { "billing" })
	public void verifyUniqueTestNameForProfileTest() {
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
	@Test(groups = { "billing" })
	public void verifyOrganizationAdvance() {
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
	@Test(groups = { "billing" })
	public void verifyDueCutFromOrganizationAdvance() {
		User userInfo = getUserInfo();
		userInfo.setName("roger");
		List<String> dueList;
		try {
			dueList = billing.dueCutFromOrganizationAdvance(userInfo.getName());

			Assert.assertEquals(dueList.get(0), dueList.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 49
	@Test(groups = { "billing" })
	public void ifOrgAdvanceLessThanBillAmount() {
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
	@Test(groups = { "billing" })
	public void verifyOrgCreditLimitLessThanBillAmount() {
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
	@Test(groups = { "billing" })
	public void verifyUserAdvanceAndPayableAmount() {
		User userInfo = getUserInfo();
		userInfo.setName("Smith");
		SoftAssert softAssert = new SoftAssert();
		List<String> amtAndAdvance;
		try {
			amtAndAdvance = billing.userAdvanceAndPayableAmount(userInfo.getName());

			softAssert.assertEquals(amtAndAdvance.get(0), "₹ 1000");
			softAssert.assertEquals(amtAndAdvance.get(1), "950");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	// TC: 52
	@Test(groups = { "billing" })
	public void verifyAdditionalPriceField() {
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
	@Test(groups = { "billing" })
	public void verifyConcessionInRupees() {
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
	@Test(groups = { "billing" })
	public void verifyConcessionInPercentage() {
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
	@Test(groups = { "billing" })
	public void verifyDiscountCommentsFieldCompulsory() {
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
	// @Test(groups = { "billing" })
	// public void verifyCriticalEmergencyCheckBox() {
	// User userInfo = getUserInfo();
	// userInfo.setName("roger");
	// String amount;
	// try {
	// amount = billing.criticalAndEmergencyCheckBoxAbleToSet(userInfo.getName());
	//
	// // Assert.assertEquals(amount, "945");
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 57
	// @Test(groups = { "billing" })
	// public void verifyReceiveSampleAndPrint() {
	//
	// SoftAssert softAssert = new SoftAssert();
	// String rcvSample;
	//
	// try {
	// rcvSample = billing.receiveSampleAndPrint("dtype");
	//
	// softAssert.assertEquals(rcvSample, "Received");
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// softAssert.assertAll();
	// }

	// TC: 58
	// @Test(groups = { "billing" })
	// public void verifyCTConsentFormEditable() {
	// User inputUser = new User();
	// String name = commonMethods.getRandomString();
	// String phoneNo = commonMethods.getRandomNumber();
	//
	// User editUser;
	// try {
	// inputUser.setName(name);
	// inputUser.setPhoneNumber(phoneNo);
	// inputUser.setAge("11");
	//
	// editUser = billing.ctConsentForm(inputUser);
	//
	// registerValidator.verifyRegister(inputUser, editUser);
	// } catch (Exception e) {
	// logger.error(e.getMessage());
	// Assert.assertTrue(false, e.getMessage());
	// }
	// }

	// TC: 66
	@Test(groups = { "billing" })
	public void verifyBackToRegistrationPage() {
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
	@Test(groups = { "billing2" })
	public void verifyAdditionalServicesFlag() {
		User userInfo = getUserInfo();
		userInfo.setName("dtype");
		String firstOption;
		try {
			firstOption = billing.additionalServicesFlag(userInfo.getName());

			Assert.assertEquals(firstOption, "Additional Services (Default: None)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 70
	@Test(groups = { "billing2" })
	public void verifycollectedSampleType() {
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
	@Test(groups = { "billing" })
	public void verifyDiscountPriceList() {
		User userInfo = getUserInfo();
		List<String> testListOne;
		List<String> testListTwo;
		try {
			testListOne = billing.discountPriceList(userInfo.getName());
			testListTwo = billing.confirmDiscountPriceList();

			System.out.println(testListOne.toString());
			System.out.println(testListTwo.toString());

			Assert.assertEquals(testListOne.toString(), testListTwo.toString());

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 74
	@Test(groups = { "billing" })
	public void verify​TestQuantityOption() {
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
	@Test(groups = { "billing" })
	public void verify​BackDatedBillGettingSaved() {
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
	@Test(groups = { "billing" })
	public void verify​SearchAccessionNoBoxSearching() {
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
	// @Test(groups = { "billing" })
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
	@Test(groups = { "billing2" })
	public void verify​DiscountToDiscountDiscardedTestFlag() {
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
	// @Test(groups = { "billing" })
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
	@Test(groups = { "billing" })
	public void verifyAllowedDiscountOnBill() {
		User userInfo = getUserInfo();
		userInfo.setName("benedict");
		String amount;
		try {
			amount = billing.allowedDiscountOnBill(userInfo.getName());

			Assert.assertEquals(amount, "50");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 83
	@Test(groups = { "billing" })
	public void verifyMoreThanAllowedDiscountOnBill() {
		User userInfo = getUserInfo();
		userInfo.setName("benedict");
		String errorMessage;
		try {
			errorMessage = billing.moreThanAllowedDiscountOnBill(userInfo.getName());

			Assert.assertEquals(errorMessage, "You can give only 90% discount.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 57
	// @Test(groups = { "billing" })
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
	@Test(groups = { "billing" })
	public void verifyFormF() {
		User userInfo = getUserInfo();
		userInfo.setName("benedict");
		String userName;
		try {
			userName = billing.formFConsentForm(userInfo.getName());

			Assert.assertEquals(userName, "Benedict");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
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
