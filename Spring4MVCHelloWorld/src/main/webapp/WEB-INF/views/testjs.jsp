<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<script type="text/javascript">
    function getval(sel) {
          alert(sel.value)   ;
    }
</script>

<script type="text/javascript">
shit=new Array("Mercedes","Volvo","BMW","porche");
user=new Array("Pat","aaa","bbb","ccc");

function userchanged(){

	alert();
	var s;
	
	for (i=0; i<shit.length; i++){
		
		s = s +  "<option>" +  shit[i] + "</option>";
	}
	
	console.log ( s);
	document.getElementById("time").innerHTML = s; 
}


function populateSelect(){

    $('#time').html("<option> shit </option>");
}
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p onclick="alert('Works');" id="para">This is a paragraph</p>
	
	
	<select onchange="getval(this);">
    <option value="1">One</option>
    <option value="2">Two</option>
</select>

<!-- 	<tr>
	   <td>
	 	  Please select the user:
	   </td>
	   <td>
		    <select id="user" onchange="userchanged()">
		          <option value="pat">pat</option>
  				  <option value="aaa">aaa</option>
		    </select>
	    </td>
	    <td>
			 <select id="time">	 
			 
			 <option> ohman </option>
			 </select>
	    </td>
	</tr> -->

	<script type="text/javascript" src="js/jquery.js"></script>
</body>
</html>