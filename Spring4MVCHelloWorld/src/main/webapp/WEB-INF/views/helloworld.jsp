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
      
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
    
    <script type="text/javascript">
    
  
    
function userchanged(){

	var name = document.getElementById("whichuser").value;

	insertParam("username", name);

/*     var s = "<c:forEach  var='i' items='${Patrick}'>" + "<option value='${i}'>"+"<c:out value='${i}'/>"+ "</option>" +  "</c:forEach>"; 

	document.getElementById("date").innerHTML = s; 
	
	
	console.log(name);  */
}


function datechanged(){

	var date = document.getElementById("date").value;

	insertParam("date", date);

/*     var s = "<c:forEach  var='i' items='${Patrick}'>" + "<option value='${i}'>"+"<c:out value='${i}'/>"+ "</option>" +  "</c:forEach>"; 

	document.getElementById("date").innerHTML = s; 
	
	
	console.log(name);  */
}

function insertParam(key, value)
{
    key = encodeURI(key); value = encodeURI(value);

    var kvp = document.location.search.substr(1).split('&');

    var i=kvp.length; var x; while(i--) 
    {
        x = kvp[i].split('=');

        if (x[0]==key)
        {
            x[1] = value;
            kvp[i] = x.join('=');
            break;
        }
    }

    if(i<0) {kvp[kvp.length] = [key,value].join('=');}

    //this will reload the page, it's likely better to store this until finished
    document.location.search = kvp.join('&'); 
}

function get(name){
	   if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
	      return decodeURIComponent(name[1]);
	}

</script>
    
    
<script>

    
function initialize() {

/*   var myLatlng = new google.maps.LatLng(-25.363882,131.044922); */
<%--   <%String latitude = request.getParameter("latitude");
	String longtitude = "35";%> --%>

<%-- var lat= "<%= latitude%>";
var lon= "<%= longtitude%>"; --%>

var lat= "${latitude}";
var lon= "${longtitude}";
console.log(lat);
console.log(lon);

var myLatlng = new google.maps.LatLng(lat, lon);
  
  var mapOptions = {
    zoom: 4,
    center: myLatlng
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
    <h1> Welcome to GPSTracking System</h1>
    
    
   <!--  label="select user" array="alluser"  -->
  <table id="usertable">
   <tr>
	   <td>
	 	  Please select the user:
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