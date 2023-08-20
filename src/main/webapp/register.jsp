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
			<form action="RegisterServlet" method="post">

				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Email
						address</label> <input type="text" class="form-control"
						id="exampleFormControlInput1" name="email"
						placeholder="name@example.com">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Password</label>
					<input type="password" class="form-control"
						id="exampleFormControlInput1" placeholder="" name="password">
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">Confirm
						Password</label> <input type="password" class="form-control"
						id="exampleFormControlInput1" placeholder="" name="cpassword">
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary ">Register</button>
				</div>

			</form>

		</div>
		<%
		String res = (String) request.getAttribute("wrong");
		String emailNotValid = (String) request.getAttribute("emailNotValid");

		if (emailNotValid != null && emailNotValid.equals("True")) {
		%>
		<div class="alert alert-danger" role="alert">Email is not valid
			!!!</div>
		<%
		}
		if (res != null) {
		%>

		<div class="alert alert-danger" role="alert">Both Password filed
			should Match !!!</div>

		<%
		}

		String created = (String) request.getAttribute("user");
		if (created != null && created.equals("created")) {
		%>

		<div class="alert alert-success" role="alert">
			Registered Successfully !!! Login Page <a href="login.jsp">Login</a>
		</div>

		<%
		}
		else if (created != null && created.equals("exists")) {
		%>

		<div class="alert alert-danger" role="alert">
			User with this email already exists !!! Do u want to login ? <a href="login.jsp">Login</a>
		</div>

		<%
		}
		%>
	</div>
</body>

</html>