package moukserverequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PostComplexJson {

	@Test
	public void complexJson()
	{
		
		List<Integer>arrayofId=new ArrayList<Integer>();
		arrayofId.add(5);
		arrayofId.add(9);
		
		HashMap<String, Object> batterhashmap1=new HashMap<String, Object>();
		batterhashmap1.put("id", "1001");
		batterhashmap1.put("type", "Regular");
		
		HashMap<String, Object>batterhashmap2=new HashMap<String, Object>();
		batterhashmap2.put("id", arrayofId);
		batterhashmap2.put("type", "Chocolate");
		
		List<HashMap<String, Object>>battearralist=new ArrayList<HashMap<String,Object>>();
		battearralist.add(batterhashmap1);
		battearralist.add(batterhashmap2);
		
		HashMap<String,List<HashMap<String, Object>>>batterhashmap=new HashMap<String, List<HashMap<String,Object>>>();
		batterhashmap.put("batter", battearralist);
		
		// Topping
		HashMap<String, String>topping1=new HashMap<String, String>();
		topping1.put("id", "5001");
		topping1.put("type", "None");
		
		HashMap<String, String>topping2=new HashMap<String, String>();
		topping2.put("id", "5002");
		topping2.put("type", "Glazed");
		
		HashMap<String, String>topping3=new HashMap<String, String>();
		topping3.put("id", "5005");
		topping3.put("type", "Sugar");
	
		
        List<HashMap<String, String>>toppingvalue=new ArrayList<HashMap<String,String>>();
        toppingvalue.add(topping1);
        toppingvalue.add(topping2);
        toppingvalue.add(topping3);
        
        HashMap<String, Object>mainObject=new HashMap<String, Object>();
        mainObject.put("id", "0001");
        mainObject.put("type", "donut");
        mainObject.put("name", "Cake");
        mainObject.put("ppu", 0.55);
        mainObject.put("batters", batterhashmap);
        mainObject.put("topping", toppingvalue);

		
	 RestAssured.baseURI="https://fc1520e9-3844-4fa9-9f6d-977a3707bc41.mock.pstmn.io";
	    
	              given()
	           
	            .header("x-mock-match-request-body","true")
	            
	            .header("Content-Type","application/json")
	            
	            .body(mainObject)
	           
	            .log().all()
	           
	            .when()
	           
	            .post("/complexjson")
	           
	            .then()
	           
	            .log().all()
	           
	            .extract()
	            
	            .response();
	      
	
	}
	
	
	
}
