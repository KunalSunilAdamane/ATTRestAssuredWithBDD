package assertionusage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;
//In order to use REST assured effectively it's recommended to statically import methods from the above classes

public class AssertionTypes {

	@Test
	public void assertionApply()
	{
RestAssured.baseURI = "https://api.getpostman.com";
		
		
		given()
		
		.header("x-api-key", "PMAK-6495bca84a4ce500388d0ee2-3ee41dc27fe16720ff7f7aedc09130aa00")
		
		.when()
		
		.get("/workspaces")
		
		.then()
		
		.assertThat()
		
		.header("Transfer-Encoding", "chunked")
		
		.contentType(ContentType.JSON)
		
		.statusCode(200)
		
		.body("workspaces.name", contains("ATTWorkspace","ATTworkspace","UpdatedATTworkspacebycode","ATTworkspace1","NewATTworkspace1"))
		
		.body("workspaces.name", hasItem("NewATTworkspace1"))
		
		.body("workspaces[2]",  hasEntry("visibility", "personal"))
		
		.body("workspaces.id", containsInAnyOrder("a59646b1-3e2c-41d3-859c-ca910204c5e0","345103a1-33f9-4c6e-9ccf-96327081dd5f","1e64eae9-ed27-480f-8bac-3a468f6c00cb",
				"79235112-08d5-4c49-8d9d-22d006b2416d","0dbeba1d-e6df-40e5-8a83-994c1548444f"));
		
		
		       
		       
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
