package uploadanddownloadfile;

import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.codegen.model.OutputFile;
import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DownloadFile {
	
	@Test
	public void downloadimage() throws IOException
	{
		RestAssured.baseURI="https://github.com";
		
		byte[] response = given()
		
		.when()
		
		.log().all()
		
		.get("/KunalSunilAdamane/ATTRestAssuredWithBDD/blob/main/wallpaperflare.com_wallpaper.jpg")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response()
		
		.asByteArray();
		
		OutputStream myimage=new FileOutputStream(new File("C:\\Users\\Admin\\eclipse-workspace\\RestAssuredPractice\\Screenshot\\BhagvatGita.jpg"));
		
		myimage.write(response);
		
		myimage.close();
		
		
	}

}
