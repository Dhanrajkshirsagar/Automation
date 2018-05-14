package com.livehealth.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.testng.asserts.SoftAssert;

import com.livehealth.model.User;

@Component
public class RegistrationValidator {

	final static Logger logger = Logger.getLogger(RegistrationValidator.class);

	public void verifyRegister(User inputUser, User createdUser) {

		SoftAssert softAssert = new SoftAssert();
		try

		{

			softAssert.assertEquals(inputUser.getName(), createdUser.getName());

			softAssert.assertEquals(inputUser.getEmail(), createdUser.getEmail());

			softAssert.assertEquals(inputUser.getAge(), createdUser.getAge());

			softAssert.assertEquals(inputUser.getPhoneNumber(), createdUser.getPhoneNumber());

			softAssert.assertEquals(inputUser.getAlternateNumber(), createdUser.getAlternateNumber());

			softAssert.assertEquals(inputUser.getHeight(), createdUser.getHeight());

			softAssert.assertEquals(inputUser.getWeight(), createdUser.getWeight());
			
			softAssert.assertEquals(inputUser.getPincode(), createdUser.getPincode());

			softAssert.assertEquals(inputUser.getGender(), createdUser.getGender());


		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());

		}
		softAssert.assertAll();

	}
}
