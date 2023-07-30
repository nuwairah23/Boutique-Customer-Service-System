<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of reports</title>
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
<div class="container">
	<h1>List of Reports</h1><br>
<br><br>
<a href="ReportController?action=addComplaint" class="main" style="float:right">Add Complaint</a>
<table >
  <tr>
  	<th>Email</th>
  	<th>Customer Name</th>
    <th>Report Id</th>
    <th>Subject</th>
    <th>Date of report</th>
    <th>Type of report</th>

      
    <th colspan="3">Actions</th>
  </tr>
 <c:forEach items="${reports}" var="rep" varStatus="reports">
  <tr style="height:70px">
  	<td><c:out value="${rep.u_email}" /></td>
  	<td><c:out value="${rep.customer.u_name}" /></td>	
    <td><c:out value="${rep.report_id}" /></td>
    <td><c:out value="${rep.t_subject}" /></td>  
    <td><c:out value="${rep.t_date}" /></td>
    <td><c:out value="${rep.t_type}" /></td>  

   	
    <td><a href="ReportController?action=viewComplaint&report_id=<c:out value="${rep.report_id}" />" class="extra">View</a></td>
    <td><a href="ReportController?action=updateComplaint&report_id=<c:out value="${rep.report_id}" />" class="extra">Update</a></td>
    <td><input type="hidden" id="report_id-${reports.index}" value="<c:out value="${rep.report_id}"/>"><button onclick="confirmation('${reports.index}')">Delete</button></td>    
       
  </c:forEach>
</table>
</div>
<script>
		function confirmation(index){
			  var report_id = $("#report_id-" + index).val();
			 
			  console.log(report_id);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'ReportController?action=deleteComplaint&report_id=' + report_id;
				  alert("Complaint successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

</body>
</html>