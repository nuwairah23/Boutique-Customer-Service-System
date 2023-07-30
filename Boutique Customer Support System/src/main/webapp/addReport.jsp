<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Form</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/popup.css">

</head>
<body background="image/Botanical Branches.jfif" style="background-size:cover">
<div class="header">
  <div class="header-right">
    <a class="active" href="Home.jsp" style ="color:white">Home</a>
    <a href="#contact" style="color:white">Contact</a>
    <a href="ReportController?action=listComplaint" style="color:white">Reports</a>
  </div> 
</div>

<div style=" padding-top : 100px; padding-bottom : 100px;  height: 170px; text-align:center">
	<h1 style=" font-size: 50px;">Customer Service</h1>
	<h3>Contact us by email</h3><br>
	<h4>Haven't registered yet?<a href ="#myForm"> Register here</a></h4>
</div>
<div class="container" >
	<h1>Report Form</h1><br>
	<form action="ReportController" method="post">
		<b>Name:</b><br/>
		<input type="text" name="name" ><br/><br/>
		<b>Email: </b> <br/>
		<input type="text" name="email" ><br/><br/>
		<b>Date: </b><br><br>
		<input type="date" name="date" style="font-family:Times New Roman"><br/><br/>
		<b>Order ID:</b><br/>
		<input type="text" name="orderid"><br/><br/>
		<b>Type of report: </b><br><br>
			<input type = "radio" name="report" value="Refund">Refund
			<input type = "radio" name="report" value="Return">Return<br/><br/>
		<b>Amount of refund: RM</b><br/>
		<input type="text" name="refundamount" value=0><br/><br/>
		<b>Subject:</b><br/>
		<input type="text" name="subject"><br/><br/>
		<b>Description: </b><br>
		<textarea  name="description" rows="10" cols="50"></textarea><br><br>	
		<input type="submit" value="SUBMIT">
	</form>
	</div>
	
<div class="box">
		
	</div>
	<div class="overlay" id="myForm">
		<div class="wrapper">
			<h2>Register Customer</h2><a class="close" href="#">&times;</a>
			<div class="content">
				<div class="form-container">
					<form action="CustomerController" method="post">
						Email
						<input type="text" name="u_email" placeholder="Enter email..">
						Name
						<input type="text" name="u_name" placeholder="Enter name..">
						<input type="submit" value="Submit">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>