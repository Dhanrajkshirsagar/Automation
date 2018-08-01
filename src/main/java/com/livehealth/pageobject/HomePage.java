package com.livehealth.pageobject;

import javax.annotation.PostConstruct;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livehealth.base.DriverFactory;
import com.livehealth.config.ConfigProperties;
import com.livehealth.util.CommonMethods;
import com.livehealth.util.WebContext;

@Component
public class HomePage {

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	WebContext webContext;

	@Autowired
	ConfigProperties configProperties;

	@PostConstruct
	public void loadDriver() throws Exception {
		PageFactory.initElements(DriverFactory.getDriver(), this);

	}

	public HomePage() {
		super();
	}

	public RegistrationPage launch() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), RegistrationPage.class);

	}

	public BillingPage navigateToBillingPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), BillingPage.class);

	}

	public BillUpdatePage navigateToBillUpdatePage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), BillUpdatePage.class);

	}

	public AccessionPage navigateToAccessionPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), AccessionPage.class);

	}
	
	public BillSettlementPage navigateToBillSettlementPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), BillSettlementPage.class);

	}


	public String getPageTitle() throws Exception {
		String title = DriverFactory.getDriver().getTitle();

		return title;
	}
}
