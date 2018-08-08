package com.livehealth.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.testng.asserts.SoftAssert;

import com.livehealth.model.TestList;

@Component
public class BillingDetailsValidator {

	final static Logger logger = Logger.getLogger(BillingDetailsValidator.class);

	public void verifyBillingDetails(TestList updatingDetails, TestList storedDetails) {

		SoftAssert softAssert = new SoftAssert();
		try

		{
			softAssert.assertEquals(updatingDetails.getTestName(), storedDetails.getTestName());

			softAssert.assertEquals(updatingDetails.getTestAmount(), storedDetails.getTestAmount());

			softAssert.assertEquals(updatingDetails.getTestStatus(), storedDetails.getTestStatus());

		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());

		}
		softAssert.assertAll();

	}
}
