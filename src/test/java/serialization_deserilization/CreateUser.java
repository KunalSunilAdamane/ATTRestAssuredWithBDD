package serialization_deserilization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import pojo.CreateResponseUserbody;
import pojo.CreateUserRequestBody;

public class CreateUser {

	@Test
	public void postuser()
	{
		CreateUserRequestBody request=new CreateUserRequestBody();
		request.setId(0);
		request.setUsername("Kunal Sunil Adamane");
		request.setFirstname("Kunal");
		request.setLastname("Adamane");
		request.setEmail("kunal123@gmail.com");
		request.setPassword("Kunal@123");
		request.setPhone("9022745590");
		request.setUserStatus(0);
		
		
		
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		   
		         CreateResponseUserbody responsebody = given()
		        
		        .body(request)
		        
		        .header("Content-Type","application/json")
		        
		        .log().all()
		        
		        .when()
		        
		        .post("/user")
		        
		        .then()
		        
		        .log().all()
		        
		        .extract()
		        
		        .response().as(CreateResponseUserbody.class);
		        
		       
		       System.out.println(responsebody.getCode());
		       System.out.println(responsebody.getType());
		       System.out.println(responsebody.getMessage());
		               
		
		
	}
	
	
	
	
	
	
	
	
	
}
