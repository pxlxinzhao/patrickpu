package com.gpstracker;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

//	public static final int REQUEST_CODE = 1;
	Button btn;
	EditText username,latitude,longtitude;
	String requesturl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button)findViewById(R.id.btn);
		username = (EditText)findViewById(R.id.username);
		latitude = (EditText)findViewById(R.id.latitude);
		longtitude = (EditText)findViewById(R.id.longtitude);
//		final Intent intent = new Intent(this, AddWordActivity.class);
		
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
//				requesturl = "http://10.0.2.2:8080/Spring4MVCHelloWorld/map.do"
//					+ "?user=" + username.toString() + "&lat=" + latitude.toString() + "&lon=" + longtitude.toString();
				requesturl = "http://10.0.2.2:8080/Spring4MVCHelloWorld/map.do"
						+ "?user=" + "xl" + "&lat=" + "25" + "&lon=" + "40";
				btn.setClickable(false);
				new LongRunningGetIO().execute();
				showtext();
				
//				startActivityForResult(intent, REQUEST_CODE);
				
//				Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show()
	
//				new RequestTask().execute("http://10.0.2.2:8080/Spring4MVCHelloWorld/map.do"
//						+ "?user=" + username + "&lat=" + latitude + "&lon=" + longtitude);
			}
		});
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
//	    	HttpGet httpGet = new HttpGet("http://10.0.2.2:5050/yyy/rest/curex/10/USD/CAD");
	    	
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
	    		
//	    	mytext.setText(results);

	    	}
	    	
	    	btn.setClickable(true);
	    	}
	    	}
	
	
//	  @Override
//	  protected void onActivityResult (int requestCode, int resultCode, Intent data){
//	     if(requestCode==REQUEST_CODE && resultCode == RESULT_OK){
//	         Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show(); 
//	      }
//	  }
//	
	
	 protected void showtext(){
		 Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show(); 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	class RequestTask extends AsyncTask<String, String, String>{
//
//	    @Override
//	    protected String doInBackground(String... uri) {
//	        HttpClient httpclient = new DefaultHttpClient();
//	        HttpResponse response;
//	        String responseString = null;
//	        try {
//	            response = httpclient.execute(new HttpGet(uri[0]));
//	            StatusLine statusLine = response.getStatusLine();
//	            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
//	                ByteArrayOutputStream out = new ByteArrayOutputStream();
//	                response.getEntity().writeTo(out);
//	                out.close();
//	                responseString = out.toString();
//	            } else{
//	                //Closes the connection.
//	                response.getEntity().getContent().close();
//	                throw new IOException(statusLine.getReasonPhrase());
//	            }
//	        } catch (ClientProtocolException e) {
//	            //TODO Handle problems..
//	        } catch (IOException e) {
//	            //TODO Handle problems..
//	        }
//	        return responseString;
//	    }
//
//	    @Override
//	    protected void onPostExecute(String result) {
//	        super.onPostExecute(result);
//	        //Do anything with response..
//	    }
//	}
}
