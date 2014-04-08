<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<%@ include file="common.inc.html"%>
</head>
<body>
<%@ include file="head.inc.jsp"%>
	<div class="login">
		<p class="lead text-info" style="margin-left: 20px"><c:sr word="Login"/></p>
		<div class= "text-error" style="margin-left: 20px"><strong><%
			Object message = request.getAttribute("message");
			if (message != null) {
				out.println(message.toString());
			}
		%></strong></div>
		<form method="post" action="./auth.do" style="margin-left: 20px">
			<div id="message"></div>
			<table class="table" style="width: 25%">
				<tr>
					<td><p class="text-success"><strong><c:sr word="Username"/></strong></p></td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td><p class="text-success"><strong><c:sr word="Password"/></strong></p></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><p class="text-success"><input type="radio" value="admin" name="role"><strong><c:sr word="Admin"/></strong></p></td>
					<td><p class="text-success"><input type="radio" value="user" name="role"><strong><c:sr word="User"/></strong></p></td>
				</tr>
			</table>
			<input type="submit" value=<c:sr word="Login_submit"/> />
		</form>
	</div>
	<!-- 
	<div style="position: absolute;margin-left:400px;top: 30%;;background-color: #BBFFEE">
		<p>Noticed:if you are an admin,plz select admin radio, otherwise,user radio </p>
	</div>
	 -->
</body>
</html>