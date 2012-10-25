package acm.ccny.menuratingapp;

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

            	String queryURL = String.format("https://api.foursquare.com/v2/venues/search?near=%s&query=%s&oauth_token=QACJSDUFJ3DOW052FAJISK2XECZ212RC5YJ3KVXCSABUQ5X3&v=20121025", locationName, itemTypeName);
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
}
