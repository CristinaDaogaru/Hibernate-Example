<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${error }
	<form method="post" action="account?action=register">
		<table cellpadding="2" cellspacing="2">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" value="${account.username }"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" value="${account.password }"></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" value="${account.age }"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${account.email }"></td>
			</tr>
			<tr>
				<td>Website</td>
				<td><input type="text" name="website" value="${account.website }"></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save"></td>
			</tr>

		</table>

	</form>
</body>
</html>