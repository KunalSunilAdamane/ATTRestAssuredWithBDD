package code_optimization;

import static io.restassured.RestAssured.given;

import com.spotify.pojo.Playlist;

import io.restassured.response.Response;

public class PlaylistApi {
	
	public static Response createplaylist(Playlist playlist , String accessToken)
	{
		return given(ReqAndResspec.reqspec())
		
		.body(playlist)
		
		.when()
		
		.post("/v1/users/31vmz6gfashymzdhmu3f6p5pmjly/playlists")
		
		.then()
		
		.spec(ReqAndResspec.resSpec())
		
		.extract()
		
		.response();
			
		
	}
	
	public static Response updateplylist(Playlist playlist, String playlistid , String accessToken)
	
	{
		 
     return given(ReqAndResspec.reqspec())
		
		.body(playlist)
		
		.when()
		
		.put("/v1/playlists/"+playlistid)
		
		.then()
		
		.spec(ReqAndResspec.resSpec())
		
		.extract()
		
		.response();
		
		
	}
	
	public static Response getPlalist(String playlistid, String accessToken)
	{
		
       return given(ReqAndResspec.reqspec())

		
		.when()
		
		.get("/v1/playlists/"+playlistid)
		
		.then()
		
		.spec(ReqAndResspec.resSpec())
		
		.extract()
		
		.response();
			
		
	}
	
	
}
