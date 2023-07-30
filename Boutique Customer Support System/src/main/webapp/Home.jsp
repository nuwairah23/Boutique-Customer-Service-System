<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body background="image/HomeBackground.png" style="background-size:cover">
<div class="header">
  <div class="header-right">
    <a class="active" href="Home.jsp" style ="color:white">Home</a>
    <a href="ReportController?action=addComplaint" style="color:white">Contact</a>
    <a href="ReportController?action=listComplaint" style="color:white">Reports</a>
  </div> 
</div>
<div style="padding-top:450px; text-align:center;">

  <h1  style="font-size:48px;">Customer Service</h1><br>
  <h3><a href="ReportController?action=addComplaint" class="main" style="border-radius:50px;">Contact us</a></h3>
  </div>

</body>
</html>