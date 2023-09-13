<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">

		<h1>
			---------- KG CLUB ----------
			</h3>
			<form action="registerForm" method="post">
				Name : <input type="text" name="name1"><br> <br>
				Email : <input type="text" name="email1"><br> <br>
				Password : <input type="password" name="pass1"><br> <br>
				Gender : <input type="radio" name="gender1"> Male <input
					type="radio" name="gender1"> Female<br> <br> City
				: <select name="city1">
					<option>Select City</option>
					<option>Udgir</option>
					<option>Tondar</option>
					<option>Pune</option>
					<option>Banglore</option>

				</select> <br /> <br />
				<input type="submit" value="register"> <br /> <br />




			</form>

			<form action="Alogin" method="post">
				Already User
				<br>
				<input type="submit" value="login">

			</form>
	</div>

</body>
</html>