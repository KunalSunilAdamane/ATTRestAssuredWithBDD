package apichaining;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Demo {
	String userId ;
	@Test
	public void postRequest()
	{
		
		HashMap<String, String>value=new HashMap<String, String>();
		value.put("name", "ATTObjectWorkspace2");
		value.put("description", "Creation of workspace using java object as body");
		value.put("type", "personal");

		HashMap<String, Object>jsonobject=new HashMap<String, Object>();
		jsonobject.put("workspace", value);
		
		RestAssured.baseURI="https://api.getpostman.com";
		
		Response response = given()
		
		.header("x-api-key" , "PMAK-6495bca84a4ce500388d0ee2-3ee41dc27fe16720ff7f7aedc09130aa00")
		
		.body(jsonobject)
		
		.log().all()
		
		.when()
		
		.post("/workspaces")
		
		.then()
		
		//.log().all()
		
		.extract()
		
		.response();
	        
		System.out.println(response.asPrettyString());
			
		  JsonPath js = response.jsonPath();   
		   userId = js.getString("workspace.id");
		              
		    System.out.println("user Id is : " +userId);
		
		
	}

	@Test
	public void getuserDetail()
	
	{
		RestAssured.baseURI="https://www.getpostman.com";
		given()
		
		.header("x-api-key" , "PMAK-6495bca84a4ce500388d0ee2-3ee41dc27fe16720ff7f7aedc09130aa00")
		
		.log().all()
		
		.when()
		
		.get("/workspaces/")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
