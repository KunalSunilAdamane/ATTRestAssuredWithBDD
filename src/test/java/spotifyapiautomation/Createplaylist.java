package spotifyapiautomation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;



public class Createplaylist {
	RequestSpecification request;
	ResponseSpecification respons;
	@BeforeClass
	public void requestandresponse()
	{
		
		RequestSpecBuilder requestspecbuilder=new RequestSpecBuilder();
		requestspecbuilder.setBaseUri("https://api.spotify.com");
		requestspecbuilder.addHeader("Authorization", "Bearer BQBw5P1vKjBoh-1Xx_fUeiiVx3PwVP1hiHD9Xc0zZgDx1j2DVg5WmtxWUhEnXRnWSn5azE2V2KxK5HeKX_hR8NNf66BJ3gNyQ42fo70Ag79VWjZKxA6vHizP7KKvXpORIvGxg1C3Oh7rOaSLjtBYYStLx7r48AiMqciF5dtBIb4GPSyemmaJXl219JPi6IuBEly-k4wjN6v0ej_JMQjWaPea-HRLrtzIdcCC1NFyfa1MVdW-QDWS0tSxlRcDeYt9XMbbv_tPa8BMA31D");
		requestspecbuilder.addHeader("Content-Type", "application/json");
		requestspecbuilder.log(LogDetail.ALL);
		request = requestspecbuilder.build();
		
		
	ResponseSpecBuilder	responssepcbuilder=new ResponseSpecBuilder();
	//responssepcbuilder.expectContentType(ContentType.JSON);
	responssepcbuilder.log(LogDetail.ALL);
	respons=responssepcbuilder.build();
	}
	
	
	@Test//(priority = 1)
	public void createplaylist()
	{
		given(request)
		
		.body("{\r\n"
				+ "    \"name\": \"Bhaktigeet \",\r\n"
				+ "    \"description\": \"Collection of petroitic\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.when()
		
		.post("/v1/users/31vmz6gfashymzdhmu3f6p5pmjly/playlists")
		
		.then()
		
		.spec(respons)
		
		.assertThat()
		
		.statusCode(201);
		
		
		
	}
	
	
	
	
	@Test (enabled = false)
	public void getPlyalists()
	{
	given(request)

		
		.when()
		
		.get("/v1/users/31vmz6gfashymzdhmu3f6p5pmjly/playlists")
		
		.then()
		
		.spec(respons)
		
		.extract()
		
		.response();
		
		
	}
	
	
	
	
	
}
