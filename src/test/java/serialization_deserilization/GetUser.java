package serialization_deserilization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.Data;
import pojo.GetResponsebody;
import pojo.Support;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GetUser {

	
	@Test
	public void getuser()
	{
		RestAssured.baseURI="https://reqres.in";
		
		GetResponsebody response = given()
		
		.when()
		
		.get("/api/users?page=2")
		
		.then()
		
		.extract()
		
		.response().as(GetResponsebody.class);
		
		
		List<Data> datalist = response.getData();
		
		 Integer id = datalist.get(0).getId();
		
		System.out.println(id);
		
		Support supportvalues = response.getSupport();
		
		String mytext = supportvalues.getText();
		System.out.println(" "+mytext+" ");
	}
	
	
	
	
	
	
	
}
