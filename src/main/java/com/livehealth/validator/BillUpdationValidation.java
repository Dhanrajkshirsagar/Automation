package com.livehealth.validator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.testng.asserts.SoftAssert;

import com.livehealth.model.BillData;

@Component
public class BillUpdationValidation {

	final static Logger logger = Logger.getLogger(BillUpdationValidation.class);

	public void verifyBillUpdation(BillData inputBill, BillData updateBill) {

		SoftAssert softAssert = new SoftAssert();
		try {
			softAssert.assertEquals(inputBill.getReferrelPriceList(), updateBill.getReferrelPriceList());

			softAssert.assertEquals(inputBill.getOrganization(), updateBill.getOrganization());

			softAssert.assertEquals(inputBill.getPatientAdvance(), updateBill.getPatientAdvance());

			softAssert.assertEquals(inputBill.getPayableAmount(), updateBill.getPayableAmount());

			softAssert.assertEquals(inputBill.getTestPrice(), updateBill.getTestPrice());

		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());

		}
		softAssert.assertAll();

	}

}
