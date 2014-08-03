package com.javahash.spring.DAO;


// Authored by Patrick Pu
// This is a test case for Geoinfo, two entries of user info are put in memory and printed out
// Run this as Java Application

public class GeoTest {
	
	public static void main(String args[]){
		
		String name = "Patrick";
		String s = "<c:forEach  var='date' items='${" + name + "}'>" + "<option value='${date}'>"+	"<c:out value='${date}'/>"+ "</option>" +  "</c:forEach>";
//		List<String> list = new ArrayList<String>();
//		List<String> list2 = new ArrayList<String>();
//		
//		String userid = "Patrick";
//		String lat = "35";
//		String lon = "35";
//		
//		String userid2 = "Leon";
//		String lat2 = "40";
//		String lon2 = "40";
//		
//		list.add(lat);
//		list.add(lon);
//		list2.add(lat2);
//		list2.add(lon2);
//		
//		Geoinfo geo = Geoinfo.getInstance();
//	
//		geo.getMap().put(userid, list);
//		geo.getMap().put(userid2, list2);
		
//		Calendar c = Calendar.getInstance(); 
//		Date d = c.getTime();
//	    String s = d.toString().trim();
//	    s.replaceAll("", "&");
		
		System.out.println(s);
	}
}
