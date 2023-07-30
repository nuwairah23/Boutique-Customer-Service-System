<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Report Form</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body background="image/Botanical Branches.jfif" style="background-size:cover">
<div class="header">
  <div class="header-right">
    <a class="active" href="Home.jsp" style ="color:white">Home</a>
    <a href="ReportController?action=addComplaint" style="color:white">Contact</a>
    <a href="ReportController?action=listComplaint" style="color:white">Reports</a>
  </div> 
</div>

<div style=" padding-top : 100px; padding-bottom : 100px;  height: 170px; text-align:center">
	<h1 style=" font-size: 50px;">Customer Service</h1>
	<h3>Contact us by email</h3><br>
</div>
<div class="container">
	<h1>Report</h1><br>
		<b>Report ID:</b> <c:out value="${report.report_id}"/><br>
    	<b>Date of report:</b> <c:out value="${report.t_date}" /><br>
    	<b>Type of report: </b><c:out value="${report.t_type}" /> <br>
    	<b>Order ID: </b><c:out value="${report.t_order_id}" /> <br>
    	<b>Refund amount:</b> <c:out value="${report.t_refund_amount}" /> <br>
    	<b>Subject: </b><c:out value="${report.t_subject}" /><br>
    	<b>Description: </b><c:out value="${report.t_description}" /> <br><br><br>
    			     
        <a href="ReportController?action=listComplaint" class="main">List of Reports</a>
        
	</div>
</body>
</html>