package com.spotify.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spotify.pojo.Playlist;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;
public class GetUserPlaylist {
	
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
	
	@Test 
	public void getPlyalists()
	{
	     Playlist responsplaylist = given(request)
		
		.when()
		
		.get("/v1/playlists/0mEEBGz3nzNFRt6Y4puCv2")
		
		.then()
		
		.spec(respons)
		
		.assertThat()
		
		.statusCode(200)
		
		.extract()
		
		
		.response().as(Playlist.class);
		
	     String playlistname = responsplaylist.getName();
		 String description = responsplaylist.getDescription();
		 Boolean playlistpublic = responsplaylist.getPublic();
		 
		 System.out.println(playlistname);
		 System.out.println(playlistpublic);
		 
		
	}
	
	
	
}
