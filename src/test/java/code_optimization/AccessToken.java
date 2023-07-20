package code_optimization;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AccessToken {

	
	public static String accessToken()
	{
		
		HashMap<String, String>tokenbody=new HashMap<String, String>();
		
		tokenbody.put("grant_type", "refresh_token");
		tokenbody.put("refresh_token", "AQBmnS3hv8MXIudSWktvjFAj_Y51Qinh6foLLqPbmlxvVs0WcSHyCyRmCKT2zVR9Km0bMuWv0R6XxVAr7cViw_vypVCNGCq3t-tgionbbD8rqVF063QaqkeH1aRTNh1xnkQ");
		tokenbody.put("client_id", "1704433358044c98a9d328e9a9c90733");
		tokenbody.put("client_secret", "2d1ea2eb1f9d4599a891d13b27b32d38");
		
		RestAssured.baseURI="https://accounts.spotify.com";
		
		Response myresponse = given()
		
		.contentType(ContentType.URLENC)
		
		.formParams(tokenbody)
		
		.when()
		
		.get("/api/token")
		
		.then()
		
		.extract()
		
		.response();
		
		if(myresponse.statusCode()!=200)
		{
			
		throw new RuntimeException("Failed ro create Access Token");
			
		}
		
		String accessToken = myresponse.path("access_token");
		
		return accessToken;
		
	}
	
	
	
	
	
}
