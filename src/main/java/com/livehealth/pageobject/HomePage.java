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
	
	public ReferralManagementPage navigateToReferralManagemetPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), ReferralManagementPage.class);

	}
	
	public DoctorManagementPage navigateToDoctorManagementPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), DoctorManagementPage.class);

	}
	
	public OrganizationManagementPage navigateToOrganizationManagementPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), OrganizationManagementPage.class);

	}
	
	public ListManagementPage navigateToListManagementPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), ListManagementPage.class);

	}
	
	public AdvanceCollectionPage navigateToAdvanceCollectionPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), AdvanceCollectionPage.class);

	}
	
	public AppointmentPage navigateToAppointmentPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), AppointmentPage.class);

	}
	
	public UserManagementPage navigateToUserManagementPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), UserManagementPage.class);

	}
	
	public HomeCollectionPage navigateToHomeCollectionPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), HomeCollectionPage.class);

	}
	
	public CCBatchManagementPage navigateToCCBatchManagementPage() throws Exception {

		DriverFactory.getDriver().get(configProperties.getLivehealthUrl());
		commonMethods.waitForPageToLoad();

		return PageFactory.initElements(DriverFactory.getWindowDriver("Livehealth"), CCBatchManagementPage.class);

	}

	

	public String getPageTitle() throws Exception {
		String title = DriverFactory.getDriver().getTitle();

		return title;
	}
}
