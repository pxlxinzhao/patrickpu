package com.javahash.spring.DAO;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Geoinfo {
	
	private static Geoinfo geo =null;
	
	private Geoinfo(){};
	
	private Map<String, List<String>> map = new HashMap<String, List<String>>();

	public Map<String, List<String>> getMap() {
		return map;
	}
	
	static boolean firstThread = true;

	
	public static Geoinfo getInstance() {
		if(geo == null) {
			
			
			synchronized(Geoinfo.class){ 
			
				if(geo == null) {
					// If the instance isn't needed it isn't created
					// This is known as lazy instantiation
			
					geo = new Geoinfo();
					
					return geo;
					
				}
			
			}
			
		}
		
		return geo;
	}

	public String print(){
		
		String newLine = System.getProperty("line.separator");
		
		String result="";
		
		Iterator<Entry<String, List<String>>> it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, List<String>> pairs = (Map.Entry<String, List<String>>) it.next();
	        
	        result = result + "userid: " + pairs.getKey()  + newLine + "latitude: " + pairs.getValue().get(0)
	        		+ newLine + "longtitude: " + pairs.getValue().get(1) + newLine + "----------------------"  + newLine;
	    	}
	
	    return result;
    }
}