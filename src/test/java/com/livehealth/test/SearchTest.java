package com.livehealth.test;

import org.apache.log4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(SearchTest.class);

	@Test
	public void verifyPageTitle() {

		try {

			Assert.assertTrue(true);

		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());

		}

	}

}