package spotifyapiautomation;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UpdatePlaylist {
	@Test (priority = 2)
	public void updatePlyalist()
	{
		 RestAssured.baseURI="https://api.spotify.com";
		 
          given()         
         
         
		
		.body("{\r\n"
				+ "    \"name\": \"sa-re-gam-pa-CARAVAN\",\r\n"
				+ "    \"description\": \"O Jamana Kare Diwana \",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
       
         .header("Authorization", "Bearer BQCa7i-B9xT9mszilxRvbniLllamfDKD3QeXRIxhNSxFIv4xpDCTtpj20STzgePqswFpqbqM3Sk9HEKMiLxFdEcsTkfBJjwMziZU-EgsMXM02Z8ujnFU9b8EzJrdiqiqx7JzSMxb0k6TeY2rHDRBubrr_NvkF-LPMTNh0MCL0vxfqauLVJeMsQB3KhEd4AIUa5zr8pdp9t75Scj5EQIRUxOTlGejepwobMS0bzAPIbmRFUC76OvdZwSVL6wbg9ZOKhDklmnhlJ5B0ETY")
		
         .header("Content-Type", "application/json")
         .log().all()
         
         .when()
		
		.put("/v1/playlists/7HSRMZXDHfyls5Ts3AbJpn")
		
		.then()
		 .log().all()
		.extract()
		
		.response();
		
		
		
		
	}
	
}
