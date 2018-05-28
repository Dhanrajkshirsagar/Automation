package com.livehealth.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.livehealth.model.Organization;
import com.livehealth.model.OrganizationResponse;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

public class OrganizationAPI {

	public static ArrayList<String> getOrganizationList() {
		
		List<Object> login=LoginAPI.login();
		
		String csrfToken=login.get(0).toString();
		Response redirectedResponse=(Response) login.get(1);
		
		HashMap<String,String> headers=new HashMap<>();
		headers.put("Referer", "https://beta.livehealth.solutions/billing/");
		headers.put("x-csrftoken", csrfToken);
		
		Cookies cookies2=  redirectedResponse.getDetailedCookies();
		
		Response orgListResponse = RestAssured.given()
				 .cookies(cookies2)
	             .when()
	             .headers(headers)
	             .get("https://beta.livehealth.solutions/getEditOrganizationListApi/")
	            .then()
	            .statusCode(200)
	            .extract()
	            .response();
		
		
		OrganizationResponse  orgList = orgListResponse.body().as(OrganizationResponse.class);
		
		ArrayList<Organization> orgObject=orgList.getOrganizationList();
		
		ArrayList<String> list = new ArrayList<String>();
		
		for (Organization org : orgObject) {

			list.add(org.getOrgFullName().toLowerCase());
		}
		
		Collections.sort(list);
		
		return list;
	}
		
}

