package code_optimization;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqAndResspec {

	
	public static RequestSpecification  reqspec()
	{
		
	
	return	new RequestSpecBuilder()
		.setBaseUri("https://api.spotify.com")
		.addHeader("Content-Type", "application/json")
		.log(LogDetail.ALL)
		.build();	
		
	}
	
	public static ResponseSpecification resSpec()
	{	
	return new ResponseSpecBuilder()
	.log(LogDetail.ALL)
	.build();
	}
	
	
	
}
