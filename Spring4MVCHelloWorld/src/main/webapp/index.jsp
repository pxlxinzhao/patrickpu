<html>

<head>
<style>
div {margin-top: 50px;
	 margin-left: auto;
	 margin-right: auto;
	 padding-top: 1px;
	 text-align: center; 
	 width:50%;
	 background-color: #AD8533;
	}
table { margin-left: auto;
	    margin-right: auto;	
	  }
th {padding: 20px}
</style>

 <script  type="text/javascript">   
 	
 		raj();
 
 
      function raj(){   
        <% String str="Welcome to Hello World"; %>   
        var s="<%=str%>";   
        alert(s);   
      }   
    </script>  
</head>

<body>

<div>
	<h1 align="center">Hello World</h1>
	<table>
		<tr>
			<th><a href="http://localhost:8080/Spring4MVCHelloWorld/hello.do" > Hello World Example </a></th>
			<th><a href="http://localhost:8080/Spring4MVCHelloWorld/map.do" > Tracking Service</a></th>
		</tr>
	</table>
</div>
</body>
</html>