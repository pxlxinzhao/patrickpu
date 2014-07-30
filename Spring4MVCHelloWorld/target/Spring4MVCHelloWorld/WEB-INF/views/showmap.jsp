<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script
    src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>
var map;
var lon, lat;

lat= -34.397;
lon= 150.644;

function g(){
    var url = location.href;
    var qs = url.substring(url.indexOf('?') + 1).split('&');
    for(var i = 0, result = {}; i < qs.length; i++){
        qs[i] = qs[i].split('=');
        result[qs[i][0]] = qs[i][1];
    }
    lat = qs[0][1];
    lon = qs[1][1];
    
    if (lat == null) {lat = -34.397;}
    if (lon == null) {lon= 150.644;}
}

function a(){
	
	alert("come on baby one more time");
}
	
function initialize() {
	/* var myLatlng = new google.maps.LatLng(-34.397, 150.644); */
	g();
	
	var myLatlng = new google.maps.LatLng(lat, lon);
  var mapOptions = {
    zoom: 8,
    center: myLatlng
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
  
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
 <div id="map-canvas" style="height:500px; width:800px"></div>
</body>
</html>