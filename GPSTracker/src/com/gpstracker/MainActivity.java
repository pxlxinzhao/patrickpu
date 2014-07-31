package com.gpstracker;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	Button btn;
	EditText username,latitude,longtitude;
	String requesturl;
	LocationManager lm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button)findViewById(R.id.btn);
		username = (EditText)findViewById(R.id.username);
		latitude = (EditText)findViewById(R.id.latitude);
		longtitude = (EditText)findViewById(R.id.longtitude);
		
		
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

//				requesturl = "http://10.0.2.2:8080/Spring4MVCHelloWorld/map.do"
//					+ "?user=" + username.toString() + "&lat=" + latitude.toString() + "&lon=" + longtitude.toString();
//				requesturl = "http://10.0.2.2:8080/Spring4MVCHelloWorld/map.do"
//						+ "?user=" + "xl" + "&lat=" + "77" + "&lon=" + "77";
//				btn.setClickable(false);
//				new LongRunningGetIO().execute();
				
//				Double lat = getLastBestLocation().getLatitude();
//				Double lon = getLastBestLocation().getLongitude();

//				Log.v("tag", "The latitude is " + String.valueOf(lat) + "And the Longtitude is " + String.valueOf(lon));
				
				lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
				LocationListener ll = new mylocationlistener();
				lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
				
				
				
				
				
				showtext();
				
				
			}
		});
	}
	
	
	class mylocationlistener implements LocationListener{

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			if(location != null)
			{
				double pLong = location.getLongitude();
				double pLat = location.getLatitude();
				latitude.setText(Double.toString(pLat));
				longtitude.setText(Double.toString(pLong));
			}
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
		
		
	}
	
	
//	  private class LongRunningGetIO extends AsyncTask <Void, Void, String> {
//	    	
//	    	
//	    	protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
//	    	InputStream in = entity.getContent();
//	    	StringBuffer out = new StringBuffer();
//	    	int n = 1;
//	    	while (n>0) {
//	    	byte[] b = new byte[4096];
//	    	n =  in.read(b);
//	    	if (n>0) out.append(new String(b, 0, n));
//	    	}
//	    	return out.toString();
//	    	}
//	    	
//
//	    	@Override
//	    	protected String doInBackground(Void... params) {
//	    	HttpClient httpClient = new DefaultHttpClient();
//	    	HttpContext localContext = new BasicHttpContext();
//	    	HttpGet httpGet = new HttpGet(requesturl);
//	    	String text = null;
//	    	try {
//	    	HttpResponse response = httpClient.execute(httpGet, localContext);
//	    	HttpEntity entity = response.getEntity();
//	    	text = getASCIIContentFromEntity(entity);
//	    	} catch (Exception e) {
//	    	return e.getLocalizedMessage();
//	    	}
//	    	return text;
//	    	}
//	    	
//
//	    	protected void onPostExecute(String results) {
//	    	if (results!=null) {
//	    	}
//	    	btn.setClickable(true);
//	    	}
//	    	}

	 protected void showtext(){
		 Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show(); 
	 }

	 protected Location getLastBestLocation() {
		 
		    
		    lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
		    Criteria crit = new Criteria();
		    crit.setAccuracy(Criteria.ACCURACY_FINE);
		    crit.setPowerRequirement(Criteria.POWER_LOW); 
			String tower = lm.getBestProvider(crit, false);
		    Location location = lm.getLastKnownLocation(tower);
		    
		    return location;
		    
		
//		    Location locationGPS = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//		    Location locationNet = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//
//		    long GPSLocationTime = 0;
//		    if (null != locationGPS) { GPSLocationTime = locationGPS.getTime(); }
//
//		    long NetLocationTime = 0;
//
//		    if (null != locationNet) {
//		        NetLocationTime = locationNet.getTime();
//		    }
//
//		    if ( 0 < GPSLocationTime - NetLocationTime ) {
//		        return locationGPS;
//		    }
//		    else {
//		        return locationNet;
//		    }
		}
}
