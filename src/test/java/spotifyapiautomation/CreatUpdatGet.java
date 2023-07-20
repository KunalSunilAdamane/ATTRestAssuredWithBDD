package spotifyapiautomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.pojo.Playlist;

import code_optimization.AccessToken;
import code_optimization.PlaylistApi;
import io.restassured.response.Response;

public class CreatUpdatGet {
	
	static String playlistid; 
	@Test (priority = 1)
	public void create()
	{
		Playlist playlist=new Playlist();
		playlist.setName(" NEW BANGALI  Songs");
		playlist.setDescription(" BANGALI songs Collection");
		playlist.setPublic(false);
		
	    Response response = PlaylistApi.createplaylist(playlist,AccessToken.accessToken());
	    Playlist playlistreaspomse = response.as(Playlist.class);
		 
        playlistid = playlistreaspomse.getId();
		System.out.println( playlistreaspomse.getName());
	}
	
	
	@Test (priority = 2)
	public void get()
	{
		
		Response response = PlaylistApi.getPlalist(playlistid ,AccessToken.accessToken());
		Playlist getresponse = response.as(Playlist.class);
		String actualid = getresponse.getId();
		
		Assert.assertEquals(actualid, playlistid);
	}
	
	
	@Test (priority = 3)
	public void update()// Therre is problem to get json thats ehy cannot get response od updated api.
	{
		Playlist playlist=new Playlist();
		playlist.setName(" OLD BANGALI  Songs");
		playlist.setDescription(" OLD BANGALI songs Collection");
		playlist.setPublic(false);
		
		Response response = PlaylistApi.updateplylist(playlist,playlistid,AccessToken.accessToken());

        int actualStatuscode = response.statusCode();
		
		Assert.assertEquals(actualStatuscode, 200);
	}
	
	
	
	
	
}
