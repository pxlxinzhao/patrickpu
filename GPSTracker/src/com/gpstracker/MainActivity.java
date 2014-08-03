package com.gpstracker;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	Button btnstart;
	Button btnstop;
	EditText username,latitude,longtitude;
	String requesturl;
	LocationManager lm;
	LocationListener ll;
	boolean b=true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnstart = (Button)findViewById(R.id.btnstart);
		btnstop  = (Button)findViewById(R.id.btnstop);
		username = (EditText)findViewById(R.id.username);
		latitude = (EditText)findViewById(R.id.latitude);
		longtitude = (EditText)findViewById(R.id.longtitude);
		
		btnstart.setOnClickListener(new View.OnClickListener() {
		
	
			@Override
			public void onClick(View v) {

				
				if (isEmpty(username)){ showfailure(); }
				
				else{
				
				lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
				ll = new mylocationlistener();
				lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
				
				showstarted();
				btnstart.setClickable(false);
				}
				
			}
		});
		
		btnstop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lm.removeUpdates(ll);
				showstoped();
				btnstart.setClickable(true);
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
				Calendar c = Calendar.getInstance(); 
				Date d = c.getTime();
			    String s = d.toString().trim();
			    String un = username.getText().toString();
			    
			    Log.v("tag", un);
				
				requesturl = "http://10.0.2.2:8080/Spring4MVCHelloWorld/map.do"
				+ "?user=" + un + "&lat=" + Double.toString(pLat) + "&lon=" + Double.toString(pLong);
//				+ "&date=" + "201314";
				
				new LongRunningGetIO().execute();
				
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
	
	
	  private class LongRunningGetIO extends AsyncTask <Void, Void, String> {
	    	
	    	
	    	protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
	    	InputStream in = entity.getContent();
	    	StringBuffer out = new StringBuffer();
	    	int n = 1;
	    	while (n>0) {
	    	byte[] b = new byte[4096];
	    	n =  in.read(b);
	    	if (n>0) out.append(new String(b, 0, n));
	    	}
	    	return out.toString();
	    	}
	    	

	    	@Override
	    	protected String doInBackground(Void... params) {
	    	HttpClient httpClient = new DefaultHttpClient();
	    	HttpContext localContext = new BasicHttpContext();
	    	HttpGet httpGet = new HttpGet(requesturl);
	    	String text = null;
	    	try {
	    	HttpResponse response = httpClient.execute(httpGet, localContext);
	    	HttpEntity entity = response.getEntity();
	    	text = getASCIIContentFromEntity(entity);
	    	} catch (Exception e) {
	    	return e.getLocalizedMessage();
	    	}
	    	return text;
	    	}
	    	

	    	protected void onPostExecute(String results) {
	    	if (results!=null) {
	    	}
	    	btnstart.setClickable(true);
	    	}
	    	}

//	 private void showsuccess(){
//		 Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show(); 
//	 }
	 private void showstarted(){
		 Toast.makeText(this, "Started", Toast.LENGTH_LONG).show(); 
	 }
	 private void showstoped(){
		 Toast.makeText(this, "Stoped", Toast.LENGTH_LONG).show(); 
	 }
	 private void showfailure(){
		 Toast.makeText(this, "username is required", Toast.LENGTH_SHORT).show(); 
	 }
	 private boolean isEmpty(EditText etText) {
	        return etText.getText().toString().trim().length() == 0;
	    }
}




