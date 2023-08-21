<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<%@include file="all_css_js.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-12">

				<h1>
				<%
				int user_id = session.getAttribute("user_id")!=null?(int)session.getAttribute("user_id"):0 ;
				
				String user_email = session.getAttribute("user_email")!=null?(String)session.getAttribute("user_email"):"";
				
				if(user_id==0){
					response.sendRedirect("login.jsp");
				}
				else{
					out.println("User Email is : "+user_email);
					
				}
				%>
				</h1>
				<div class="card mt-3" >
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<h6 class="card-subtitle mb-2 text-body-secondary">Card
							subtitle</h6>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<button href="#" class="btn btn-danger">Delete</button> <button href="#" class="ml-2 btn btn-warning">Edit</button>
					</div>
				</div>


				<div class="card mt-3" >
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<h6 class="card-subtitle mb-2 text-body-secondary">Card
							subtitle</h6>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<button href="#" class="btn btn-danger">Delete</button> <button href="#" class="ml-2 btn btn-warning">Edit</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>