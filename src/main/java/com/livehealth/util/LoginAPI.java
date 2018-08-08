package com.livehealth.util;

import java.util.Arrays;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;


public class LoginAPI {
	

private static Cookies cookies=null;

	public static List<Object> login() {
		
		Response loginResponse = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .contentType("multipart/form-data")
	            .multiPart("username", "auto-livehealth")
	            .multiPart("password", "livehealth20")
	            .when()
	             .post("https://beta.livehealth.solutions/labLogin/")
	            .then()
	            .statusCode(302)
	            .extract()
	            .response();
		cookies=  loginResponse.getDetailedCookies();
	          
		Response redirectedResponse = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .cookies(cookies)
	             .when()
	             .get("https://beta.livehealth.solutions/referralManagement/")
	            .then()
	            .statusCode(200)
	            .extract()
	            .response();
		
		String csrfToken=redirectedResponse.getCookie("csrftoken");
		
		return Arrays.asList(csrfToken,redirectedResponse);
	}
}


		
	
		
		

	


