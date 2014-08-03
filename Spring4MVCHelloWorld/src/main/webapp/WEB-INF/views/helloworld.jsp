<!DOCTYPE html>

<%@ page import="java.util.ArrayList" %>
<% String selecteduser = request.getParameter("username");
	if(selecteduser==null) selecteduser = "";
	String userlist = request.getParameter("selecteduser");  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Simple markers</title>
      
    <style type="text/css">
    <%@include file="css/style.css" %>
    </style>
    
    <script type="text/javascript">
    <%@include file="js/js.js" %>
    </script>
      
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
    
<script>

    
function initialize() {

var lat= "${latitude}";
var lon= "${longtitude}";
console.log(lat);
console.log(lon);

var myLatlng = new google.maps.LatLng(lat, lon);
  
  var mapOptions = {
    zoom: 4,
    center: myLatlng,
    mapTypeControlOptions: {
        mapTypeIds: [google.maps.MapTypeId.SATELLITE, 
                     google.maps.MapTypeId.HYBRID,
                     google.maps.MapTypeId.ROADMAP]
    },
    mapTypeId: google.maps.MapTypeId.ROADMAP
  }
  var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

  var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      title: 'Hello World!'
  });
}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>
  </head>
  <body>
  
  <div id="big-canvas">
    <h1> Welcome to GPS Tracking System</h1>
    
    
   <!--  label="select user" array="alluser"  -->
  <table id="usertable">
   <tr>
	   <td>
	 	  Please select a user:
	   </td>
	   <td>
		    <select id="whichuser" name="user" onchange="userchanged()">
		    <option selected="selected"><%= selecteduser %></option>
		        <c:forEach var="user"  items="${alluser}" >
		            <option value="${user}">
		                <c:out value="${user}"/>
		            </option>
		        </c:forEach>
		    </select>
	    </td>	  
	    <td>
	 	  Please select a time:
	   </td>
	    <td>
			 <select id="date" onchange="datechanged()">
					<c:forEach var="i" items="${user}" >
			            <option value="${i}">
			                <c:out value="${i}"/>
			            </option>
			        </c:forEach>
			 </select>
	    </td>
	</tr>
	</table>	
    <div id="map-canvas"></div>
  </div> 
  <script type="text/javascript" src="js/jquery.js"></script>
  </body>
</html>