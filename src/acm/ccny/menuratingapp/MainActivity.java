package acm.ccny.menuratingapp;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	private String data;
	private Dictionary venues_info=new Hashtable();	//dictionary to store results

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    


    
    private Dictionary venueInfo(String query, String venueJSON) { //query is the search keyword, venueJSON is the venue JSON file
    	
    	//Isatou
    	try {
			
        JSONObject venue_data= new JSONObject(venueJSON);	
        //JSONObject meta= venue_data.getJSONObject("meta");
        JSONObject response=venue_data.getJSONObject("response");
        JSONArray venuesArray=response.getJSONArray("venues");
       
     
        //Dictionary venues_info=new Hashtable();	//dictionary to store results
        
    	int i;
		for(i=0; i<venuesArray.length(); i++)
		{
			JSONObject venues= venuesArray.getJSONObject(i);

			String id= venues.getString("id");
		    String name= venues.getString("name");
		    
		    if(query==name)	//only venue names that match the query are put in the dictionary
		    {
		    	//does having the same key overwrite the previously stored values in the dictionary?
		    	venues_info.put("id", id);
				venues_info.put("name", name);
		    }
		        
		}
		
    	} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return venues_info;	//dictionary of the matched venues are returned
				
    }
    
   
}
