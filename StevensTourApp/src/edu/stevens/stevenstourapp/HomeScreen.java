package edu.stevens.stevenstourapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.*;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class HomeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        
        TextView txtStevensTitle = (TextView)findViewById(R.id.stevensTitle);
        TextView txtStevensInstitute = (TextView)findViewById(R.id.stevensInstitute);
        TextView txtStevensOf = (TextView)findViewById(R.id.stevensOf);
        TextView txtStevensTechnology = (TextView)findViewById(R.id.stevensTechnology);
        TextView txtStevensTour = (TextView)findViewById(R.id.textStevensTour);
        
        Typeface anglt = Typeface.createFromAsset(getAssets(),"fonts/angltrr.ttf");
        Typeface catriel = Typeface.createFromAsset(getAssets(),"fonts/catriel regular.ttf");
        Typeface metaPlusItalic = Typeface.createFromAsset(getAssets(),"fonts/meta-plus-normal-italic.ttf");
        Typeface pacif = Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf");

        txtStevensTitle.setTypeface(anglt);
        txtStevensInstitute.setTypeface(catriel);
        txtStevensOf.setTypeface(metaPlusItalic);
        txtStevensTechnology.setTypeface(catriel);
        txtStevensTour.setTypeface(pacif);
        
        txtStevensTitle.setTextColor(Color.parseColor("#AFAFAF"));
        txtStevensInstitute.setTextColor(Color.parseColor("#AFAFAF"));
        txtStevensOf.setTextColor(Color.parseColor("#AFAFAF"));
        txtStevensTechnology.setTextColor(Color.parseColor("#AFAFAF"));
        txtStevensTour.setTextColor(Color.parseColor("#1A6D5D"));
        
        
        Button btnNextScreen = (Button) findViewById(R.id.btnTour);
 
        //Listening to button event
        btnNextScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), TourActivity.class);

                startActivity(nextScreen);
 
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
