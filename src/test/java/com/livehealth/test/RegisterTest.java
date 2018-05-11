package com.livehealth.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.livehealth.base.DriverFactory;
import com.livehealth.pageobject.HomePage;
import com.livehealth.pageobject.Register;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RegisterTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	@Autowired
	HomePage pageLaunch;

	Register registerPage;

	@Test(groups = { "unit" })
	public void launchSite() {
		try {
			registerPage = pageLaunch.launch();
			registerPage.signIn("auto-livehealth", "livehealth20");

			Assert.assertTrue(true);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());

		}

	}

	@AfterClass
	public void tearDown() {
		DriverFactory.closeDriverObjects();

	}

}
