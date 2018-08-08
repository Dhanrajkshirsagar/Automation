package com.livehealth.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.livehealth.model.Referrel;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReferrelAPI {

	public static ArrayList<String> getReferrelList() {
		
		List<Object> login=LoginAPI.login();
		
		String csrfToken=login.get(0).toString();
		Response redirectedResponse=(Response) login.get(1);
		
		HashMap<String,String> headers=new HashMap<>();
		headers.put("Referer", "https://beta.livehealth.solutions/billing/");
		headers.put("x-csrftoken", csrfToken);
		
		Cookies cookies2=  redirectedResponse.getDetailedCookies();
				
		JsonPath jsonPath = RestAssured.given()
				 .cookies(cookies2)
			     .when()
			     .headers(headers)
			     .get("https://beta.livehealth.solutions/getEditReferralListApi/")
			     .then()
			     .assertThat()
			     .statusCode(200)
			     .assertThat()
			     .extract().body().jsonPath();

			  List<Referrel> refObject = jsonPath.getList("", Referrel.class);
			  
		ArrayList<String> list = new ArrayList<String>();

		for (Referrel ref : refObject) {

			list.add(ref.getDocFullName().toLowerCase());
		}

		Collections.sort(list);
		
		return list;
	}
		

}
