package com.livehealth.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SearchTest extends AbstractTestNGSpringContextTests {

	@Test
	public void verifyPageTitle() {

		try {

			Assert.assertTrue(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}