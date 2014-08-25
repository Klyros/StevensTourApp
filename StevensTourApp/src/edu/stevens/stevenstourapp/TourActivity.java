package edu.stevens.stevenstourapp;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class TourActivity extends FragmentActivity{
// Google Map
private GoogleMap googleMap;
@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
		setContentView(R.layout.tourscreen);
			GoogleMap map;
			map = ((SupportMapFragment) this.getSupportFragmentManager().findFragmentById(R.id.mapView)).getMap();
            
            Button btnHome = (Button) findViewById(R.id.btnHome);
            btnHome.setOnClickListener(new View.OnClickListener() {
    			 
            public void onClick(View arg0) {
                    //Closing SecondScreen Activity
                    finish();
                }
            });
            
    }  

}