package com.livehealth.validator;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.testng.asserts.SoftAssert;

@Component
public class TestValidation {

	final static Logger logger = Logger.getLogger(TestValidation.class);

	public void verifyTestPrice(List<String> testListOne, List<String> testListTwo) {

		SoftAssert softAssert = new SoftAssert();
		try

		{
			softAssert.assertEquals(testListOne.get(0), testListTwo.get(0));
			softAssert.assertEquals(testListOne.get(1), testListTwo.get(1));
			softAssert.assertEquals(testListOne.get(2), testListTwo.get(2));

		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());

		}
		softAssert.assertAll();

	}

}
