package edu.stevens.stevenstourapp;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.content.Intent;
import android.location.*;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class TourActivity extends FragmentActivity{

	private GoogleMap map;
	private Criteria criteria;
	private String provider;
	private Location location;
	private LocationListener locationListener;
	private Button menuBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
				setContentView(R.layout.tourscreen);
				map = ((SupportMapFragment) this.getSupportFragmentManager().findFragmentById(R.id.mapView)).getMap();
				map.setMyLocationEnabled(true);
				// Getting LocationManager object from System Service LOCATION_SERVICE
		        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		        // Creating a criteria object to retrieve provider
		        criteria = new Criteria();

		        // Getting the name of the best provider
		        provider = locationManager.getBestProvider(criteria, true);

		        // Getting Current Location
		        location = locationManager.getLastKnownLocation(provider);

		        locationListener = new LocationListener() {
		        	public void onLocationChanged(Location location) {
		        		// redraw the marker when get location update.
		        		drawMarker(location);
		        	}

					@Override
					public void onStatusChanged(String provider, int status,
							Bundle extras) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onProviderEnabled(String provider) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onProviderDisabled(String provider) {
						// TODO Auto-generated method stub
						
					}
		        };
		        if(location!=null){
		           //PLACE THE INITIAL MARKER              
		           drawMarker(location);
		        }
		        locationManager.requestLocationUpdates(provider, 20000, 0, locationListener);
		        
		        menuBtn = (Button) findViewById(R.id.btnMenu);
		        
				try {
				View.OnClickListener handler = new View.OnClickListener() {
					public void onClick(View v) {
						switch (v.getId()) {
							case R.id.btnHome:
								finish();
								break;
							case R.id.btnMenu:
								
								PopupMenu popup = new PopupMenu(TourActivity.this, menuBtn);
								popup.getMenuInflater().inflate(R.menu.tourscreen_menu, popup.getMenu());
								
								//registering popup with OnMenuItemClickListener  
					            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {  
					            	@Override
					            	public boolean onMenuItemClick(MenuItem item) {  
					            		Toast.makeText(TourActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();  
					            		return true;  
					            	}

					            }); 
								popup.show();
							    break;
							     
							}
						}
					};
					findViewById(R.id.btnHome).setOnClickListener(handler);
				    findViewById(R.id.btnMenu).setOnClickListener(handler);
				}catch(Exception e){
			         Log.e("Android Button", e.toString());
			    }  
				
	}
	private void drawMarker(Location location){
		map.clear();
		LatLng currentPosition = new LatLng(location.getLatitude(),location.getLongitude());
		map.addMarker(new MarkerOptions().position(currentPosition).snippet("Lat:" + location.getLatitude() + "Lng:"+ location.getLongitude()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).title("ME"));
		
	}
}