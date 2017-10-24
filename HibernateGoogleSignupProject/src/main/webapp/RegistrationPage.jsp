<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<script type="text/javascript" src="Script/loginScript.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/registrationPage.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<div class="panel panel-primary">
		<div class="panel-heading">*</div>
		<!-- can give button here in * -->
		<div class="panel-body">
			<h2 align="center">Registration Form</h2>
			<div class="container">
				<fieldset> 
					<form action="RegisterServlet" method="post" name="myform"
						onsubmit="return validateform();">
						<div class="form-group">
							<label>Full Name</label> <input type="text" name="name"
								class="form-control" placeholder="Enter User Name" />
						</div>
						<span id="name" style="color: red"></span>
						<%
							String nameError = (String) session.getAttribute("error1");
							//out.print(nameError);
							if (nameError != null) {
								out.print("<p style=\"color:red\"> " + nameError + "</p> <br>");
							}
							session.removeAttribute("error1");
						%>

						<div class="form-group">
							<label>Email id</label><input type="email" name="email"
								class="form-control" placeholder="Enter EmailId" />
						</div>
						<span id="email" style="color: red"></span>
						<%
							String emailError = (String) session.getAttribute("error2");
							if (emailError != null)
								out.print("<p style=\"color:red\"> " + emailError + " </p><br>");
							session.removeAttribute("error2");
						%>

						<div class="form-group">
							<label>PhoneNumber</label><input type="number" name="phoneNumber"
								class="form-control" placeholder="Enter 10 digit phone number"
								required />
						</div>
						<span id="phoneNumber" style="color: red"></span>
						<%
							String phoneNumberError = (String) session.getAttribute("error3");
							if (phoneNumberError != null)
							out.print("<p style=\"color:red\">" + phoneNumberError + "</p><br>");
							session.removeAttribute("error3");
						%>
						<div class="form-group">
							<label> Password</label><input type="password" name="password"
								required class="form-control" placeholder="Enter password" />
						</div>
						<span id="password" style="color: red"></span>
						<%
							String passwordError = (String) session.getAttribute("error4");
							if (passwordError != null)
								out.print("<p style=\"color:red\">" + passwordError + "</p><br>");
							session.removeAttribute("error4");
						%>

						<div class="form-group">
							<br> <input type="submit" value="Register" />
						</div>
						<br>
						<div class="form-group">
							<a href="/GoogleSignupProject/index.jsp">Already have an
								account</a>
						</div>
						
					</form>
				</fieldset>
			</div>
		</div>
	</div>
</body>
</html>