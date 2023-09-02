<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<section class="vh-100 gradient-custom ">
  <div class="container py-5 h-100 ">
  <h1 style="margin-left: 400px">School Management System</h1>
  
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-3 mt-md-4 pb-0">

              <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
              <p class="text-white-50 mb-5">Please enter your username and password!</p>
              <p class="text-danger mb-5">${ errorMessage }</p>
              <p class="text-danger mb-5">${ deleteSucessMsg }</p>
              <p class="text-danger mb-5">${ errorApproveMsg }</p>
              <p class="text-danger mb-5">${ logoutMessage }</p>
              <p class="text-danger mb-5">${ errorMessage }</p>
              <form action="/login" method="post">
              <div class="form-outline form-white mb-4">
                              <label class="form-label" for="typeEmailX">Username</label>
                <input type="text" id="typeEmailX" class="form-control form-control-lg" name="username"/>

              </div>

              <div class="form-outline form-white mb-4">
              <label class="form-label" for="typePasswordX">Password</label>
                <input type="password" id="typePasswordX" class="form-control form-control-lg" name="password" />  
              </div>


              <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
              </form>
            <div>
              <p class="mt-3">Don't have an account? <a href="/register" class="text-white-50 fw-bold">Register</a>
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