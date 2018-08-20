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
import com.livehealth.pageobject.HomePage;
import com.livehealth.pageobject.ListManagementPage;
import com.livehealth.util.CommonMethods;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ListManagementTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	ListManagementPage listManagementPage;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "ListManagement" })
	public void launchSite() {
		try {
			listManagementPage = pageLaunch.navigateToListManagementPage();
			listManagementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 2, groups = { "ListManagement" })
	public void verifyAddListValidation() {

		try {
			String css = listManagementPage.addValidation();
			Assert.assertEquals(css, "rgb(255, 0, 0)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 3, dataProvider = "listTypes", groups = { "ListManagement" })
	public void verifyAddListWithAllTypes(String listType, String listName) {
		SoftAssert softAssert = new SoftAssert();
		String text;
		try {
			text = listManagementPage.addList(listType, listName);
			softAssert.assertEquals(text, listType);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 4, dataProvider = "listTypes", groups = { "ListManagement" })
	public void verifyAddTestsInListAndUpdateAndAssign(String listType, String listName) {
		SoftAssert softAssert = new SoftAssert();
		boolean flag;
		try {
			ArrayList<String> testList = new ArrayList<String>();
			testList.add("Alpha Feto Protein Serum -AFP");
			testList.add("Amylase Serum");
			testList.add("Calcium/Creatinine");
			testList.add("Cortisol - 4PM");
			testList.add("DNA");
			testList.add("Cold Agglutinin");
			flag = listManagementPage.addTestInAddedListType(listType, listName, testList);
			softAssert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 5, groups = { "ListManagement" })
	public void verifyUpdateTestPricesWithPercentageWiseCommesionType() {
		boolean flag;
		try {
			flag = listManagementPage.percentageWise("% of test price", "35", "Auto Referral Price");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 6, groups = { "ListManagement" })
	public void verifyUpdateTestPricesWithSubtractFromAllTestsCommesionType() {
		boolean flag;
		try {
			flag = listManagementPage.subtractFroemAllTests("₹ subtract from all test prices", "200",
					"Auto Referral Price");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 7, groups = { "ListManagement" })
	public void verifyUpdateTestPricesWithSameForAllCommesionType() {
		boolean flag;
		try {
			flag = listManagementPage.sameForAllTests("₹ for all tests", "250", "Auto Referral Price");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 8, groups = { "ListManagement" })
	public void verifyAddAllTestButton() {
		boolean flag;
		try {
			flag = listManagementPage.addAllTest("Auto Referral Price");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 9, groups = { "ListManagement" })
	public void verifyRemoveTestIcon() {
		boolean flag;
		try {
			flag = listManagementPage.removeTestsFromList("Auto Doctor Revenue");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 10, dataProvider = "displayType", groups = { "ListManagement" })
	public void verifyDepartmentWiseAndCategoryWiseDisplayTypeLink(String type) {
		SoftAssert softAssert = new SoftAssert();
		boolean flag;
		try {
			flag = listManagementPage.displayTypes(type, "Auto Organization Price");
			softAssert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 11, dataProvider = "displayType", groups = { "ListManagement" })
	public void verifyUpdateTestPriceAndAmountsFromOptionsForCategoryAndDepartmentWise(String type) {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = listManagementPage.updateTestAndAmountPrices(type, "Auto Organization Revenue", "301");
			softAssert.assertEquals(list.get(0), "2");
			softAssert.assertEquals(list.get(1), "301");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 12, groups = { "ListManagement" })
	public void verifyAssignReferralNameToReferralPriceList() {
		boolean flag;
		try {
			flag = listManagementPage.assignListToReferrals("Auto ReAssign Referral", "autoReferral");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 13, groups = { "ListManagement" })
	public void verifyAssignReferralGroupToReferralPriceList() {
		boolean flag;
		try {
			flag = listManagementPage.assignGroupToReferrals("Auto ReAssign Referral", "Pune Referrals");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 14, groups = { "ListManagement" })
	public void verifyRemoveAssignedReferrals() {
		boolean flag;
		try {
			flag = listManagementPage.removeAssignReferral("Auto ReAssign Referral");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 15, groups = { "ListManagement" })
	public void verifyAssignMultipeReferralsToSameList() {
		boolean flag;
		try {
			flag = listManagementPage.assignMultipleReferral("Auto ReAssign Referral", "Rahul", "Prithvi");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 16, groups = { "ListManagement" })
	public void verifyAssignDoctorNameToDoctorRevList() {
		boolean flag;
		try {
			flag = listManagementPage.assignListToReferrals("Auto Doctor Revenue", "autoReferral");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 17, groups = { "ListManagement" })
	public void verifyAssignDoctorGroupToDoctorRevList() {
		boolean flag;
		try {
			flag = listManagementPage.assignGroupToReferrals("Auto Doctor Revenue", "Pune Referrals");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 18, groups = { "ListManagement" })
	public void verifyRemoveAssignedDoctors() {
		boolean flag;
		try {
			flag = listManagementPage.removeAssignReferral("Auto Doctor Revenue");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 19, groups = { "ListManagement" })
	public void verifyAssignMultipleDoctorsToDoctorRevenueList() {
		boolean flag;
		try {
			flag = listManagementPage.assignMultipleReferral("Auto Doctor Revenue", "Rahul", "Prithvi");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 20, groups = { "ListManagement" })
	public void verifyAssignOrganizationNameToOrgPriceList() {
		boolean flag;
		try {
			flag = listManagementPage.assignListToReferrals("Auto Organization Price", "autoOrganisation");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 21, groups = { "ListManagement" })
	public void verifyAssignOrganizationGroupToOrgPriceList() {
		boolean flag;
		try {
			flag = listManagementPage.assignGroupToReferrals("Auto Organization Price", "Jio Orga");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 22, groups = { "ListManagement" })
	public void verifyRemoveAssignedOrganization() {
		boolean flag;
		try {
			flag = listManagementPage.removeAssignReferral("Auto Organization Price");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 23, groups = { "ListManagement" })
	public void verifyAssignMultipleOrganizationToOrgRevenueList() {
		boolean flag;
		try {
			flag = listManagementPage.assignMultipleReferral("Auto Organization Price", "nobel hospit", "princes la");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 24, groups = { "ListManagement" })
	public void verifyAssignOrganizationNameToOrgRevenueList() {
		boolean flag;
		try {
			flag = listManagementPage.assignListToReferrals("Auto Organization Revenue", "autoOrganisation");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 25, groups = { "ListManagement" })
	public void verifyAssignOrganizationGroupToOrgRevList() {
		boolean flag;
		try {
			flag = listManagementPage.assignGroupToReferrals("Auto Organization Revenue", "Jio Orga");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 26, groups = { "ListManagement" })
	public void verifyRemoveAssignedOrganizationNameForOrgRenueList() {
		boolean flag;
		try {
			flag = listManagementPage.removeAssignReferral("Auto Organization Revenue");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 27, groups = { "ListManagement" })
	public void verifyAssignMultipleOrganizationToOragRevenueList() {
		boolean flag;
		try {
			flag = listManagementPage.assignMultipleReferral("Auto Organization Revenue", "nobel hospit",
					"princes lab");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 28, groups = { "ListManagement" })
	public void verifyAssignOrganizationNameToOrgCoPayList() {
		boolean flag;
		try {
			flag = listManagementPage.assignListToReferrals("Auto Organization Co-Pay List", "autoOrganisation");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 29, groups = { "ListManagement" })
	public void verifyAssignOrganizationGroupToOrgCoPaymentList() {
		boolean flag;
		try {
			flag = listManagementPage.assignGroupToReferrals("Auto Organization Co-Pay List", "Jio Orga");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 30, groups = { "ListManagement" })
	public void verifyRemoveAssignedOrganizationNameForOrgCopaymentList() {
		boolean flag;
		try {
			flag = listManagementPage.removeAssignReferral("Auto Organization Co-Pay List");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 31, groups = { "ListManagement" })
	public void verifyAssignMultipleOrganizationToOrgCoPaymentList() {
		boolean flag;
		try {
			flag = listManagementPage.assignMultipleReferral("Auto Organization Co-Pay List", "nobel hospit",
					"princes lab");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 32, groups = { "ListManagement" })
	public void verifyAssignDoctorNameForDoctorSigningList() {
		boolean flag;
		try {
			flag = listManagementPage.assignListToDoctor("Auto Doctor Signing", "tester");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 33, groups = { "ListManagement" })
	public void verifyRemoveAssignedDoctorNameForDoctorSigningList() {
		boolean flag;
		try {
			flag = listManagementPage.removeDoctor("Auto Doctor Signing");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 34, groups = { "ListManagement" })
	public void verifyAssignMultipleDoctorToDoctorSigningList() {
		boolean flag;
		try {
			flag = listManagementPage.assignMultipleDoc("Auto Doctor Signing", "mayur", "dhanraj", "tester");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 35, groups = { "ListManagement" })
	public void verifyAssignOutsourceNameForNormalOutsourceList() {
		boolean flag;
		try {
			flag = listManagementPage.assignListToDoctor("Auto Outsouce Price", "full feature");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 36, groups = { "ListManagement" })
	public void verifyRemoveAssignedOutsourceNameForNormalOutsourceList() {
		boolean flag;
		try {
			flag = listManagementPage.removeDoctor("Auto Outsouce Price");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 37, groups = { "ListManagement" })
	public void verifyAlreadyAssignedOutsourceWarning() {
		String warning;
		try {
			warning = listManagementPage.outsourceWarning("Auto Outsouce Price", "Full", "Self");
			Assert.assertEquals(warning, "×\n" + "You can assign only one list to one outsource.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 38, groups = { "ListManagement" })
	public void verifyAddBidirectionalList() {
		boolean flag;
		try {
			flag = listManagementPage.addBidirectionalList("Auto Bidirectional List");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 39, groups = { "ListManagement" })
	public void verifyMapTestsToBiDirectionalList() {
		boolean flag;
		try {
			flag = listManagementPage.mapBidirectionalList("Auto Bidirectional List", "Cold Agglutinin",
					"Cholesterol - Total", "Vitamin D Total - 25 Hydroxy");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 40, groups = { "ListManagement" })
	public void verifyExportAndEditListLink() {
		String name;
		try {
			name = listManagementPage.exportList("Auto Test Discount", "Auto Updated");
			Assert.assertEquals(name, "Auto Updated");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 41, groups = { "ListManagement" })
	public void verifyDeleteListLink() {
		SoftAssert softAssert = new SoftAssert();
		boolean flag;
		try {
			flag = listManagementPage.deleteList("Auto Updated");
			flag = listManagementPage.deleteList("Auto Bidirectional");
			flag = listManagementPage.deleteList("Auto Outsouce Price");
			softAssert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 42, groups = { "ListManagement" })
	public void verifyExportTemplateUsingTestSearchBox() {
		boolean flag;
		try {
			ArrayList<String> TestList = new ArrayList<>();
			TestList.add("Digoxin *");
			TestList.add("Uric Acid");
			TestList.add("Bicarbonate *");
			flag = listManagementPage.exportTemplateUsingTestSearch(TestList);
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 43, groups = { "ListManagement" })
	public void verifyExportTemplateUsingCategoryFilter() {
		boolean flag;
		try {
			flag = listManagementPage.exportUsingCategory("Biochemistry", "Clinical Pathology");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test(priority = 44, groups = { "ListManagement" })
	public void verifyExportTemplateUsingDepartmentFilter() {
		boolean flag;
		try {
			flag = listManagementPage.exportUsingCategory("BIOCHEMISTRY", "HAEMATOLOGY");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 45, groups = { "ListManagement" })
	public void verifyExportTemplateUsingCategoryAndDepartmentFilter() {

		try {
			listManagementPage.exportWithBothFilters("Biochemistry", "Clinical Pathology", "BIOCHEMISTRY",
					"HAEMATOLOGY");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 46, groups = { "ListManagement" })
	public void verifyRemoveFiltersCheckBox() {
		SoftAssert softAssert = new SoftAssert();
		ArrayList<String> list;
		try {
			list = listManagementPage.exportWithBothFilters("Clinical Pathology", "Immunoassay", "BIOCHEMISTRY",
					"HAEMATOLOGY");
			softAssert.assertEquals(list.get(0), "-");
			softAssert.assertEquals(list.get(1), "0");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 47, groups = { "ListManagement" })
	public void verifyExportAllCheckBox() {

		try {
			listManagementPage.exportAllFlag();
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 48, groups = { "ListManagement" })
	public void verifyBulkUploadList() {
		boolean flag;
		try {
			flag = listManagementPage.bulkUploadList("Bulk Upload List");
			Assert.assertTrue(flag);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 49, groups = { "ListManagement" })
	public void verifyUpdateGroup() {
		ArrayList<String> cities;
		try {
			cities = listManagementPage.updateGroup("Livehealth Doctors");
			Assert.assertEquals(cities.get(0), cities.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 50, groups = { "ListManagement" })
	public void verifyEditPatientGroup() {
		ArrayList<String> groups;
		try {
			groups = listManagementPage.editPatientGroup("Tata");
			Assert.assertEquals(groups.get(0), groups.get(1));
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 51, groups = { "ListManagement" })
	public void verifyAddTestsToListWithBulk() {

		try {
			listManagementPage.bulkAddTestToList("Bulk referral list", "Bulk Org list");

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 52, groups = { "ListManagement" })
	public void verifyAllListCheckBox() {

		try {
			listManagementPage.listCount();

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@DataProvider(name = "listTypes")
	public static Object[][] getListTypes() {

		return new Object[][] { { "Referral Price List", "Auto Referral Price" },
				{ "Referral Price List", "Auto ReAssign Referral Price" },
				{ "Doctor Revenue List", "Auto Doctor Revenue" },
				{ "Organization Price List", "Auto Organization Price" },
				{ "Outsource Price List", "Auto Outsouce Price" },
				{ "Organization Co-payment List", "Auto Organization Co-Pay List" },
				{ "Organization Revenue List", "Auto Organization Revenue" },
				{ "Test Discount Price List", "Auto Test Discount" }, { "Doctor Signing List", "Auto Doctor Signing" },

		};
	}

	@DataProvider(name = "displayType")
	public static Object[][] getdisplayType() {

		return new Object[][] { { "Category wise" }, { "Department wise" },

		};
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}

}
