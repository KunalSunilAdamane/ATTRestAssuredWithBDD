package moukserverequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class GetMouckrequest {
@Test
public void GetMouck()
{
	HashMap<String, String> obj1=new HashMap<String, String>();
	obj1.put("name", "mockRequestNotFoundError");
	obj1.put("message", "Double check your method and the request path and try again.");
	obj1.put("header", "No matching requests");
	
	HashMap<String, Object>jsonobject=new HashMap<String, Object>();
	jsonobject.put("error", obj1);
	
	
 RestAssured.baseURI="https://fc1520e9-3844-4fa9-9f6d-977a3707bc41.mock.pstmn.io";
    
           given()
           
           .body(jsonobject)
           
           .log().all()
           
           .when()
           
           .get("/post")
           
           .then()
           
           .log().all()
           
           .extract()
           
           .response();
      

  

	
	
	
}
}
