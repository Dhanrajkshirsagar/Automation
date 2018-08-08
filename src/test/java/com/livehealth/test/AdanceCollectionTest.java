package com.livehealth.test;

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
import com.livehealth.pageobject.AdvanceCollectionPage;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdanceCollectionTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	SoftAssert SoftAssert = new SoftAssert();

	AdvanceCollectionPage advanceCollectionPage;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "AdvCollection" })
	public void launchSite() {
		try {
			advanceCollectionPage = pageLaunch.navigateToAdvanceCollectionPage();
			advanceCollectionPage.signIn(configProperties.getUsername(), configProperties.getPassword());
			DriverFactory.getDriver().navigate().to(Constants.Billing_URL);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 1, groups = "AdvCollection")
	public void verifyAdvanceCollectionPage() {
		String actual;
		try {
			 actual = advanceCollectionPage.verifyAdvanceCollectionPage();
			Assert.assertEquals(actual, "Advance Collection");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 2, groups = "AdvCollection")
	public void verifyValidationOfAdvanceCollection() {
		String colour;
		try {
			colour=advanceCollectionPage.checkValidation("dhan");
			Assert.assertEquals(colour, "rgba(255, 0, 0, 1)");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 3, dataProvider = "adavanceCollection", groups = "AdvCollection")
	public void verifyAdvanceCollectionSubmitButton(String mobno, String amount) {

		try {
			advanceCollectionPage.collectAdvance(mobno, amount);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test(priority = 4, groups = "AdvCollection")
	public void verifyAdvanceCollectionSubmitAndPrintReceiptButton() {

		try {
			advanceCollectionPage.collectAdanceAndPrintReceipt("b", "100");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@DataProvider(name = "adavanceCollection")
	public static Object[][] getadavanceCollection() {

		return new Object[][] { { "827536", "500" }, { "774050", "300" }, { "441559", "200" },

		};
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}

}
