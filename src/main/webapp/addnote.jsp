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
	<h1>
		<%
		int user_id = session.getAttribute("user_id") != null ? (int) session.getAttribute("user_id") : 0;

		String user_email = session.getAttribute("user_email") != null ? (String) session.getAttribute("user_email") : "";

		if (user_id == 0) {
			response.sendRedirect("login.jsp");
		} else {
			out.println("User Email is : " + user_email);

		}
		%>
	</h1>

		<form id="form-1" action="AddNoteServlet" method="post">
			<div class="mb-3 mt-5">
				<label for="exampleFormControlInput1" class="form-label">Title
				</label> <input type="text" class="form-control" name="title"
					id="exampleFormControlInput1" placeholder="Title">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">
					Content</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3" name="content"></textarea>
			</div>
			<input type="hidden" value="<%= user_id %>" name="user_id">
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>

</html>