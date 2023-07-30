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
<div class="container" >
	<h1>Report Form</h1><br>
	<form action="ReportController" method="post">
		<b>Report ID:</b><br/>
		<input type="text" name="report_id" value="<c:out value="${report.report_id}"/>"readonly><br/><br/>
		<b>Date: </b><br><br>
		<input type="date" name="date" style="font-family:Times New Roman" value="<c:out value="${report.t_date}"/>"readonly><br/><br/>
		<b>Order ID:</b><br/>
		<input type="text" name="orderid" value="<c:out value="${report.t_order_id}"/>"><br/><br/>
		<b>Type of report: </b><br><br>
			<input type = "text" name="report" value="<c:out value="${report.t_type}"/>"readonly><br/>
		<b>Amount of refund: RM</b><br/>
		<input type="text" name="refundamount" value="<c:out value="${report.t_refund_amount}"/>"><br/><br/>
		<b>Subject:</b><br/>
		<input type="text" name="subject" value="<c:out value="${report.t_subject}"/>"><br/><br/>
		<b>Description: </b><br>
		<textarea rows="10" cols="50" name="description"><c:out value="${report.t_description}"/></textarea><br><br>	
		<input type="submit" value="SUBMIT">
	</form>
	</div>
</body>
</html>
