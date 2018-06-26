package com.livehealth.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

	// TC: 1
	@Test(groups = { "Accession" })
	public void verifyPendingList() {
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
	public void verifyDismissSample() {
		boolean dismissed;
		try {

			dismissed = accession.dismissSample();
			Assert.assertTrue(dismissed);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	// TC: 05
	@Test(groups = { "Accession" })
	public void verifyDismissSampleConfirmationModel() {
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
	public void verifyReceiveButton() {
		boolean recv;
		try {

			recv = accession.receiveSample();
			Assert.assertTrue(recv);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}
}
