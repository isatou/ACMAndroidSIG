package acm.ccny.menuratingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "acm.ccny.menuratingapp.MESSAGE";
	
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
    
    //listener for search button
    public void processSearch (View view) {
    	
    	//create intent for a new activity
    	Intent intent = new Intent(this, ProcessSearchActivity.class);
    	
    	//get search field's value aka the query
    	EditText searchField = (EditText) findViewById(R.id.search_field);
    	String query = searchField.getText().toString();
    	
    	//include the query with the intent
    	intent.putExtra(EXTRA_MESSAGE, query);
    	
    	startActivity(intent);
    	
    }//function processSearch
}
