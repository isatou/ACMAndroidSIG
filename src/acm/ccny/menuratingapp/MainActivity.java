package acm.ccny.menuratingapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private EditText venueSearchEditText;

	public final static String EXTRA_MESSAGE = "acm.ccny.menuratingapp.MESSAGE";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    
        
        venueSearchEditText = (EditText) findViewById(R.id.venue_search_box);
        Button submitVenueSearchQueryButton = (Button) findViewById(R.id.venue_search_button);
        
        submitVenueSearchQueryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	String locationName = venueSearchEditText.getText().toString();

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
    	
    	
    }//function processSearch
}
