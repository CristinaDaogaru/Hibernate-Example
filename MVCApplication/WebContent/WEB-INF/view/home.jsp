<%@page import="java.util.List"%>
<%@page import="com.application.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.application.model.User"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Result Page</title>
</head>
<body>
	<center>
		<div id="container">
			<h1>Result Page</h1>
			<b>This is Sample Result Page</b><br />
			<%=new Date()%></br>
			<%
                 User user =(User) session.getAttribute("user");
             %>
			<b>Welcome <%%></b> <br /> <a href="/WEB-INF/view/logout.jsp">Logout</a>
			</p>

			<table>
				<thead>
					<tr>
						<th>User ID</th>
						<th>First Name</th>
						<th>Middle Name</th>
						<th>Last Name</th>
						<th>email</th>
					</tr>
				</thead>
				<tbody>
					<%
						LoginService loginService = new LoginService();
						List<User> list = loginService.getListOfUser();
						for(User u :list ){
					%>
					<tr>
						<td>
							<%=u.getUserId()%>
						</td>
						<td>
							<%=u.getFirstName()%>
						</td>
						<td>
							<%=u.getLastName()%>
						</td>
						<td>
							<%=u.getEmail()%>
						</td>
						
					</tr>
					<%}%>
				
				<tbody>
			</table>
			<br />
		</div>
	</center>
</body>
</html>
