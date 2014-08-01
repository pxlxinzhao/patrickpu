<%-- <%  String user = (String) request.getAttribute ("user");
	String lat = (String) request.getAttribute ("lat");
    String lon = (String) request.getAttribute ("lon");
	Double latitude = Double.parseDouble(lat);
	Double longtitude = Double.parseDouble(lon);
%>
 --%>
<!DOCTYPE html>

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
    <script>
    
    time=new Array("Mercedes","Volvo","BMW","porche");


    $(function() {

          $('#user').change(function(){
            populateSelect();
        });
        
    });


    function populateSelect(){
        cat=$('#user').val();
        $('#time').html('');
        
        
        time.forEach(function(t) { 
            $('#time').append('<option>'+t+'</option>');
        });
        
/*         if(cat=='car'){
            cars.forEach(function(t) { 
                $('#item').append('<option>'+t+'</option>');
            });
        }
        
        if(cat=='phone'){
            phones.forEach(function(t) {
                $('#item').append('<option>'+t+'</option>');
            });
        } */
        
    } 
    
    
    
    
    
    
function initialize() {

/*   var myLatlng = new google.maps.LatLng(-25.363882,131.044922); */
  var myLatlng = new google.maps.LatLng(43.4, -79.2);
  var mapOptions = {
    zoom: 8,
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
		    <select name="user">
		        <c:forEach var="user" items="${alluser}">
		            <option value="${user}">
		                <c:out value="${user}"/>
		            </option>
		        </c:forEach>
		    </select>
	    </td>

  	    
	    
	    <td>
			 <select id="time">
			 
			 </select>
	    </td>



	</tr>
	</table>
	
    <div id="map-canvas"></div>
  </div>
  
  <script type="text/javascript" src="js/jquery.js"></script>
  </body>
</html>