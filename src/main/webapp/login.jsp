<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<%@include file="all_css_js.jsp"%>
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="login-form ">
			<form action="LoginServlet" method="post">

				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Email
						address</label> <input type="email" class="form-control"
						id="exampleFormControlInput1" placeholder="name@example.com" name="email">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Password</label>
					<input type="password" class="form-control"
						id="exampleFormControlInput1" placeholder="" name="password">
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary ">Login</button>
				</div>

			</form>

		</div>
		<%
		String user = (String) request.getAttribute("user");

		if (user != null && user.equals("false")) {
		%>
		<div class="alert alert-danger" role="alert">User Does Not Exists
			!!!<a href="register.jsp">Register</a></div>
		<%
		}
		if (user != null && user.equals("error")) {
		%>
		<div class="alert alert-danger" role="alert">Password Is Wrong
			!!!</div>
		<%
		}
		if (user != null && user.equals("success")) {
		%>
		<div class="alert alert-success" role="alert">Logged In Successfully
			!!!<a href="index.jsp">Home</a></div>
		<%
		}
		%>

	</div>
</body>

</html>