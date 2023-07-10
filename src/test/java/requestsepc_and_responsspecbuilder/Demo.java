package requestsepc_and_responsspecbuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Demo {

	ResponseSpecification responsspecification;
	RequestSpecification requestspecification;
	@Test
	public void getpostmanworkspaces()
	
	{
	    RequestSpecBuilder requestspecbulider=new RequestSpecBuilder();
		requestspecbulider.setBaseUri("https://api.getpostman.com");
		requestspecbulider.addHeader("x-api-key","PMAK-6495bca84a4ce500388d0ee2-3ee41dc27fe16720ff7f7aedc09130aa00");
		requestspecbulider.log(LogDetail.ALL);
	    requestspecification = requestspecbulider.build();
		
		ResponseSpecBuilder  responsspecbuilder=new ResponseSpecBuilder();
		responsspecbuilder.expectStatusCode(200);
		responsspecbuilder.expectContentType(ContentType.JSON);
		responsspecbuilder.log(LogDetail.ALL);
	    responsspecification = responsspecbuilder.build();
		
		 
                given(requestspecification)
				
				.when()
				
				.get("/workspaces")
				
				.then()
				
				.spec(responsspecification);
				
				
		
		
	}

	
	
}
