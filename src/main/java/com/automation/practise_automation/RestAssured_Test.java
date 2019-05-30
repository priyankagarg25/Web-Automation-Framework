package com.automation.practise_automation;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RestAssured_Test {

	@Test
	public void apiStatusCode() {
		given().get("https://jsonplaceholder.typicode.com/posts/3").then().statusCode(200).log().all();

	}

	@Test
	public void testToEqual() {
		given().get("https://jsonplaceholder.typicode.com/posts").then()
				.body("title[2]", Matchers.equalTo("ea molestias quasi exercitationem repellat qui ipsa sit aut"))
				.log().all();
	}

}
