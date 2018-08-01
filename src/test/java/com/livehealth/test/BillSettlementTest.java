package com.livehealth.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

	@BeforeClass(groups = { "BillSettlement","Test"})
	public void launchSite() {
		try {
			billSettlementPage = pageLaunch.navigateToBillSettlementPage();
			billSettlementPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(dataProvider = "testsData", groups = { "BillSettlement"})
	public void verifyBill(String amount, String test1, String test2) {

		try {
			for (int i = 0; i < 3; i++) {
				billSettlementPage.patientBill("tusha", amount, test1, test2);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(groups = { "BillSettlement"})
	public void verifyBill() {

		try {
			for (int i = 0; i < 2; i++) {
				billSettlementPage.patientBill("82753694", "200", "CR", "li");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	  @Test(groups = { "BillSettlement"})
      public void verifyBillSettlementPage() {
    	
    	  try {
    		     String color=billSettlementPage.billsettlementPage();
    	         Assert.assertEquals(color, "rgba(91, 192, 222, 1)");
    	  }catch(Exception e) {
				logger.error(e.getMessage());
				Assert.assertTrue(false, e.getMessage());
			}
		}
     
     // In this case we have to verify patient name,bill ids,--------//
     @Test(groups = { "BillSettlement"})
      public void verifyBillSettlementAllDetails() {
    	
    	  try {
    		    billSettlementPage.verifydetails("tusha");
    	        
    	  }catch(Exception e) {
				logger.error(e.getMessage());
				Assert.assertTrue(false, e.getMessage());
			}
		}
     
     
     @Test(groups = { "BillSettlement"})
      public void verifySettlementBillLockLabel() {
    
    	  try {
    		    billSettlementPage.lockBillLabel("tusha");
    	        
    	  }catch(Exception e) {
				logger.error(e.getMessage());
				Assert.assertTrue(false, e.getMessage());
			}
		}
     
     @Test(groups = { "BillSettlement","Test"})
      public void verifyBillSettlementPatientDueAmount() {
    	 	List<Integer> amount;
    	  try {
    		    amount= billSettlementPage.calculateDue("tusha");
    		    Assert.assertEquals(amount.get(0), amount.get(1));
    	        
    	  }catch(Exception e) {
				logger.error(e.getMessage());
				Assert.assertTrue(false, e.getMessage());
			}
		}
     
	@Test(groups = { "BillSettlement" })
	public void verifyBillSettlementPatientEditBillLink() {
		String billId;
		try {
			WebDriver driver = DriverFactory.getDriver();
			billId = billSettlementPage.editBillLink();
			Assert.assertEquals(driver.getCurrentUrl(), Constants.BillingUpdate_URL + billId);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}
     
     @Test(groups = { "BillSettlement"})
      public void verifyBillSettlementPatientBillSettlement() {
    	 String success;
    	  try {
    		  success=billSettlementPage.billSettlement("tusha");
    		  if (success.contains("×\n" + "Close\n"
    					+ "Success! Click on below links to print the receipts for successful bill settlements")) {
    				Assert.assertTrue(true);
    			} else {
    				Assert.assertFalse(false);
    			}
    	  }catch(Exception e) {
				logger.error(e.getMessage());
				Assert.assertTrue(false, e.getMessage());
			}
		}
     
     @Test(groups = { "BillSettlement"})
      public void verifyPatientHalfBillSettlement() {
    	 
    	  try {
    		  billSettlementPage.settleHalfAmount("tusha");
    	        
    	  }catch(Exception e) {
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
 	
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}

}
