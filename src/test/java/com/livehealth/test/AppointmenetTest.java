package com.livehealth.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.livehealth.base.DriverFactory;
import com.livehealth.config.ConfigProperties;
import com.livehealth.pageobject.AppointmentPage;
import com.livehealth.pageobject.HomePage;
import com.livehealth.util.CommonMethods;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppointmenetTest extends AbstractTestNGSpringContextTests {

	final static Logger logger = Logger.getLogger(RegisterTest.class);

	AppointmentPage appointmentPage;

	@Autowired
	HomePage pageLaunch;

	@Autowired
	CommonMethods commonMethods;

	@Autowired
	ConfigProperties configProperties;

	@BeforeClass(groups = { "Appointment" })
	public void launchSite() {
		try {
			appointmentPage = pageLaunch.navigateToAppointmentPage();
			appointmentPage.signIn(configProperties.getUsername(), configProperties.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}
	
	@Test(priority = 2,groups = { "Appointment" })
	public void verifyBookAppointmentValidations() {
		SoftAssert softAssert=new SoftAssert();
		ArrayList<String> list;
		try {
			list=appointmentPage.bookAppointment();
			softAssert.assertEquals(list.get(0), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(1), "rgb(255, 0, 0)");
			softAssert.assertEquals(list.get(2), "rgb(255, 0, 0)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 3,groups = { "Appointment" })
	public void verifyBookNewAppointmentWithAllPatientDetails() {
		String success;
		try {
			success=appointmentPage.bookNewAppointment("8275369428", "dhanraj", "25");
			Assert.assertEquals(success, "×\n" + "Appointment Booked Successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 4,groups = { "Appointment" })
	public void verifyBookedAppointmentPatientAllDetails() {
		SoftAssert softAssert=new SoftAssert();
		ArrayList<String> list;;
		try {
			list=appointmentPage.verifyAppointmentPatientDetails("8275369428", "dhanraj", "25");
			softAssert.assertEquals(list.get(0), "dhanraj");
			softAssert.assertEquals(list.get(1), "8275369428");
			softAssert.assertEquals(list.get(2), "comment for testing");
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 5,groups = { "Appointment" })
	public void bookNewAppointmentForExistingPatient() {
		String sucess;
		 try {
			sucess=appointmentPage.bookNewAppointmentForExistingPatient("mayu");
			Assert.assertEquals(sucess, "×\n" + "Appointment Booked Successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 6,groups = { "Appointment" })
	public void verifyBookNewAppointmentWithDateOfBirth() {
		String sucess;
		 try {
			sucess=appointmentPage.bookNewAppointmentWithDOB();
			Assert.assertEquals(sucess, "×\n" + "Appointment Booked Successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 7,groups = { "Appointment" })
	public void verifyRescheduleAppointment() {
		String alert;
		try {
			alert=appointmentPage.RescheduleAppointment(2);
			Assert.assertEquals(alert, "×\n" + "Appointment Reschedule Successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 8,groups = { "Appointment" })
	public void verifyConfirmAppointment() {
		String alert;
		try {
			alert=appointmentPage.confirmAppointment();
			Assert.assertEquals(alert, "×\n" + "Appointment confirm Successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 9,groups = { "Appointment" })
	public void verifyBookNewAppointmentWithSelectedDoctorName() {

		String doc;
		try {
			doc=appointmentPage.bookAppointmentWithSelectedDoc();
			Assert.assertEquals(doc, "53");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 10,groups = { "Appointment" })
	public void verifyRescheduleConfirmAppointment() {
		String alert;
		try {
			alert=appointmentPage.rescheduleConfirmAppointment();
			Assert.assertEquals(alert, "×\n" + "Appointment Reschedule Successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 12,groups = { "Appointment" })
	public void verifyCancelAppointment() {

		String cancel;
		try {
			cancel=appointmentPage.dismissAppointment();
			Assert.assertEquals(cancel, "×\n" + "Appointment Cancel Successfully.");
		} catch (Exception e) {
			logger.error(e.getMessage());
			Assert.assertTrue(false, e.getMessage());
		}
	}

	@Test(priority = 13, dataProvider = "patientTypes",groups = { "Appointment" })
	public void verifyBookNewAppointmentWithAllPatientTypes(String appointmentPatientType, String value) {
		SoftAssert softAssert=new SoftAssert();
		String patientTyp;
		try {
			patientTyp=appointmentPage.appontmentWithPatientType(appointmentPatientType, value);
			softAssert.assertEquals(patientTyp, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 14, dataProvider = "patientAgeCalculateData",groups = { "Appointment" })
	public void verifyAgeCalculate(String day, String mon, String yyr) {
		SoftAssert softAssert=new SoftAssert();
		 
		try {
			AppointmentPage.ageCalculate(day, mon, yyr);
			Date date = new SimpleDateFormat("MMM").parse(mon);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int monthNumber = cal.get(Calendar.MONTH);
			int finalAge = CommonMethods.getAge(Integer.parseInt(day), monthNumber, Integer.parseInt(yyr));
			softAssert.assertEquals(AppointmentPage.calAge, finalAge + "years");
	
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}

	@Test(priority = 15, dataProvider = "patientDesignations",groups = { "Appointment" })
	public void verifyBookNewAppointmentWithAllPatientDesingations(String PatientTypeDeignation, String value) {
		SoftAssert softAssert=new SoftAssert();
		String Designation;
		try {
			Designation=appointmentPage.appontmentWithDesignation(PatientTypeDeignation, value);
			softAssert.assertEquals(Designation, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
			softAssert.assertTrue(false, e.getMessage());
		}
		softAssert.assertAll();
	}
	
	
		@DataProvider(name="patientTypes") 
		public static Object[][] getPatientTypedataForAppointment(){

			return new Object[][] 
					{
				{ "Patient Type (Default : Direct)", "D" },
				{ "Indirect (I)", "I" },
				{ "OPD (OP)","OP"},
//				{ "IPD (IP)","IP"},
//				{"RB","RB"},
//				{"Main Lab (ML)","ML"},
//				{"Baby or Just Born (B/O)","B/O"},
//				{"Corporate (CC)","CC"},
    
					};
		}
		
		@DataProvider(name="patientDesignations") 
			public static Object[][] getPatientDesignationdataForAppointment(){
	
				return new Object[][] 
						{
					{ "Mr.", "Mr." },
					{ "Mrs.", "Mrs." },
					{ "Ms.", "Ms." },
//					{ "Master","Master"},
//					{ "Miss","Miss"},
//					{"Smt.","Smt."},
//					{"Dr.","Dr."},
//					{"Baby or Just Born (B/O)","B/O"},
        
						};
						
			}
		
		@DataProvider(name="patientAgeCalculateData") 
			public static Object[][] getpatientAgeCalculateData(){
	
				return new Object[][] 
						{
					{ "7", "Mar","1992"},
					{ "8", "Aug","2002"},
					{ "15", "Feb","2010"},
        
        
						};

			}
		
		@AfterClass(alwaysRun = true)
		public void tearDown() {
			DriverFactory.closeDriverObjects();

		}


}
