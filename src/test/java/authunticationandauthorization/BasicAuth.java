package authunticationandauthorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import  static io.restassured.RestAssured.*;

public class BasicAuth {

	
	@Test
	public void GetBasicAuth()
	{
		
	RestAssured.baseURI="https://postman-echo.com";
		
	given()
	
	//.auth()
	
//	.basic("Kunal Sunil Adamane", "Kunal@3527")
	
	.header("Authorization" ,"Basic cG9zdG1hbjpwYXNzd29yZA==")
		
	.log().all()
	
	.when()
	
	.get("/basic-auth")
	
	.then()
	
	.log().all()
	
	.extract()
	
	.response();
	
	     
	}
	
	
}
