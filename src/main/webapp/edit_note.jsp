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

		<div class="card mt-3">
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<h6 class="card-subtitle mb-2 text-body-secondary">Card
					subtitle</h6>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="index.jsp"><button class="btn btn-danger">Cancel
						Updation</button></a>
			</div>
		</div>

		<form id="form-1" action="SaveNoteServlet">
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
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>
</body>

</html>