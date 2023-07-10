package uploadanddownloadfile;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UploadFile {
	@Test
	public void upload()
	{
	RestAssured.baseURI="https://the-internet.herokuapp.com";
	given()
	
	.multiPart("file", new File("C:\\Users\\Admin\\Downloads\\TestData.txt"))
	
	.log().all()
	
	.when()
	
	.post("/upload")
	
	.then()
	
	.log().all()
	
	.extract()
	
	.response();
	
	
	}
}
