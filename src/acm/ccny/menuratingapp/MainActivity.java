package acm.ccny.menuratingapp;

import java.util.Dictionary;
import java.util.Hashtable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText venueLocationEditText;
	private EditText itemTypeEditText;
	public final static String EXTRA_MESSAGE = "acm.ccny.menuratingapp.MESSAGE";
	
	private String data;
	private Dictionary venues_info=new Hashtable();	//dictionary to store results

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    
        
        venueLocationEditText = (EditText) findViewById(R.id.venue_location_edittext);
        itemTypeEditText = (EditText) findViewById(R.id.item_type_edittext);

        Button submitVenueSearchQueryButton = (Button) findViewById(R.id.venue_search_button);
        
        submitVenueSearchQueryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	String locationName = venueLocationEditText.getText().toString();
            	String itemTypeName = itemTypeEditText.getText().toString();

            	String queryURL = String.format("https://api.foursquare.com/v2/venues/search?near=%s&query=%s&client_id=YTOBZF505OFWDYY4MJVIJLUJGKMXC11OMQSU1MMNJOXICDB5&client_secret=MWUQPIKRTYSLLO23EPRPZTVEBIKXVS0APNXGH1JETJ2YPUX3&v=20121025", locationName, itemTypeName);
            	processSearch(queryURL);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
 
   
    //listener for search button
    public void processSearch (String queryURL) {
    	System.out.println(queryURL);    	
    }
    
    private Dictionary venueInfo(String query, String venueJSON) { //query is the search keyword, venueJSON is the venue JSON file
    	
        
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