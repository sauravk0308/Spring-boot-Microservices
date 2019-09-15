<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 Welcome to my first page
 
 <form action="/addStudent"method="post"> 
 	Enter your id : <input type="text" name="id"><br/>
 	Enter your name : <input type="text" name="name"><br/>
 	<input type="submit" value="Submit">
 </form>
 </hr>
 <form action="/findByName"method="get"> 
 	Enter your name : <input type="text" name="name"><br/>
 	<input type="submit" value="Submit">
 </form>
</body>
</html>