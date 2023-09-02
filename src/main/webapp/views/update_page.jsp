<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.osttra.to.User, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</head>
<body>
<%
	User user = (User) session.getAttribute("user");

%>
	<section class="vh-100 gradient-custom ">
		<div class="container py-5 h-100 ">
			<h1 style="margin-left: 400px">School Management System</h1>

			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card bg-dark text-white" style="border-radius: 1rem;">
						<div class="card-body p-5 text-center">

							<div class="mb-md-3 mt-md-4 pb-0">

								<h2 class="fw-bold mb-2 text-uppercase">Update</h2>
								<p class="text-white-50 mb-5">Please update your details!</p>
                                <form action="/update" method="get">
								<div class="form-outline form-white mb-4 disabled">
									<label class="form-label" for="typeEmailX">Username</label> 
									<input
										type="text" id="typeEmailX" name="username"
										class="form-control form-control-lg " disabled  value="${user.getUsername()}" />
                                      
								</div>

								<div class="form-outline form-white mb-4">
									<label class="form-label" for="typePasswordX">Email
										</label> <input type="text" id="typePasswordX" name="email"
										class="form-control form-control-lg" value="${user.getEmail()}"/>
								</div>
								<div class="form-outline form-white mb-4">
									<label class="form-label" for="typePasswordX">Complete
										Name</label> <input type="text" id="typePasswordX" name="completeName"
										class="form-control form-control-lg" value="${user.getCompleteName()}"/>
								</div>
                              <br>
								<button class="btn btn-outline-light btn-lg px-5" type="submit">Submit</button>
                                 </form>
								<div>
									<p class="mt-3">
										Back to Home Page? <a href="/login"
											class="text-white-50 fw-bold">Home</a>
									</p>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
</body>
</html>