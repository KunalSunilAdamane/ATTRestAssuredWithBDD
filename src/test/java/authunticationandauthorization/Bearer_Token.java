package authunticationandauthorization;

import java.util.HashMap;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class Bearer_Token {

	
	
	
  @Test
  public void bearerToken()
  {
	
	  HashMap<String, String>headers=new  HashMap<String, String>();
	  headers.put("Accept", "application/vnd.github+json");
	  headers.put("Authorization", "Bearer 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");
	  headers.put("X-GitHub-Api-Version", "2022-11-28");
	  
	  RequestSpecBuilder requestspec=new RequestSpecBuilder();
	  requestspec.setBaseUri("https://api.github.com");
	  requestspec.addHeaders(headers);
	  requestspec.log(LogDetail.ALL);
	  RequestSpecification requestSpecbuilder = requestspec.build();
	  
	  given(requestSpecbuilder)
	  
	  .body("{\r\n"
	  		+ "  \"name\": \"RestAssuredByEclipse\",\r\n"
	  		+ "  \"description\": \"Repository created by using Eclipse!\",\r\n"
	  		+ "  \"homepage\": \"https://github.com\",\r\n"
	  		+ "  \"private\": true,\r\n"
	  		+ "  \"is_template\": true\r\n"
	  		+ "}")
	  
	  .when()
	  
	  .post("/user/repos")
	  
	  .then()
	  
	  .log().all();
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
	
	
	
	
}
