<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.osttra.to.User, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<style>
.disabled-link {
  pointer-events: none;
}
</style>
</head>
<body>


<%
	User user = (User) session.getAttribute("user");
User user1 = (User) session.getAttribute("user1");
List<User> users = (List<User>) session.getAttribute("users");
List<User> students = (List<User>) session.getAttribute("students");

%>
<jsp:include page="nav_bar.jsp"/>
<br>
${ updateSuccessMsg }
${ approveSuccessMsg }
<br>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">User Name</th>
      <th scope="col">Complete Name</th>
      <th scope="col">Email</th>
      <th scope="col">Role</th>
      <th scope="col">Delete</th>
      <th scope="col">Update</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">${ user.getUsername() }</th>
      <td>${ user.getCompleteName() }</td>
      <td>${ user.getEmail() }</td>
      <td>${ user.getRole()}</td>
      <td><a href = "/delete/${ user.getUsername() }">Delete</a></td>
      <td><a href = "/updatePage/${ user.getUsername() }">Update</a></td>
    </tr>
  </tbody>
</table>


<hr>
<%
if(users != null && user.getRole().equalsIgnoreCase("Admin") && users.size()>1) {
%>
<h4>Users:<h4>
<table class="table">
  <thead>
    <tr>
    <th scope="col">S.No</th>
      <th scope="col">Username</th>
      <th scope="col">Complete Name</th>
      <th scope="col">Email</th>
      <th scope="col">Role</th>
      <th scope="col">Delete</th>
      <th scope="col">Update</th>
      <th scope="col">Login Request</th>
      <th scope="col">Status</th>
    </tr>
  </thead>
  <tbody>
    
    <%
    int count = 0;
    	for(int i = 0; i < users.size(); i++) {
    		
    		if(!user.getUsername().equals(users.get(i).getUsername())) {
    			count++;
    %>
    <tr>
    <td><%= count%> </td>
      <td><%= users.get(i).getUsername()%> </td>
      <td><%= users.get(i).getCompleteName()%></td>
      <td><%= users.get(i).getEmail() %></td>
      <td><%= users.get(i).getRole() %></td>
      <td><a href = "/delete/<%= users.get(i).getUsername()%>">Delete</a></td>
      <td><a href = "/admin/updatePage/<%= users.get(i).getUsername()%>">Update</a></td>
      <% if (!users.get(i).getIsApproved().equals("true")){ %>
      
      <td><a href = "/admin/welcome_page/approved/<%= users.get(i).getUsername()%>" >Approve</a></td>
      <%} %><%else{
      %>
      <td><a href = "/admin/update/<%= users.get(i).getUsername()%>" class="disabled-link">Approve</a></td>
      <%} %>
      <td><%= users.get(i).getIsApproved() %></td>
    </tr>
    <%
    	}
    	 }
    	 	}%>
  </tbody>
</table>
<%
if(students != null && user.getRole().equalsIgnoreCase("teacher")) {
%>
<h4>Students:<h4>
<table class="table">
  <thead>
    <tr>
    <th scope="col">S.No</th>
      <th scope="col">Username</th>
      <th scope="col">Complete Name</th>
      <th scope="col">Email</th>
      <th scope="col">Role</th>
      
    
    </tr>
  </thead>
  <tbody>
    
    <%
    int count = 0;
    	for(int i = 0; i < students.size(); i++) {
    		
    			count++;
    %>
    <tr>
    <td><%= count%> </td>
      <td><%= students.get(i).getUsername()%> </td>
      <td><%= students.get(i).getCompleteName()%></td>
      <td><%= students.get(i).getEmail() %></td>
      <td><%= students.get(i).getRole() %></td>
    </tr>
    <%
    	}
    	 
    	 	}%>
  </tbody>
</table>

</body>
</html>