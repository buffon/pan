<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<%@ include file="common.inc.html"%>
<style type="text/css">
.login {
	
}
</style>
<!--  
<script type="text/javascript">
var message = '<%=request.getAttribute("message")%>';
if(message != null){
	 var _tst = document.getElementById("message");
	 _tst.innerHTML = message;
	
}
</script>
-->
</head>
<body>
<%@ include file="head.inc.html"%>
	<div class="login">
		<p class="lead text-info" style="margin-left: 20px">welcome to login</p>
		<%
			Object message = request.getParameter("message");
			if (message != null) {
				out.println(message.toString());
			}
		%>
		<form method="post" action="./auth.do" style="margin-left: 20px">
			<div id="message"></div>
			<table class="table" style="width: 20%">
				<tr>
					<td><p class="text-success"><strong>username</strong></p></td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td><p class="text-success"><strong>password</strong></p></td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td><p class="text-success"><input type="radio" value="admin" name="role"><strong>admin</strong></p></td>
					<td><p class="text-success"><input type="radio" value="user" name="role"><strong>user</strong></p></td>
				</tr>
			</table>
			<input type="submit" value="login" />
		</form>
	</div>
	<!-- 
	<div style="position: absolute;margin-left:400px;top: 30%;;background-color: #BBFFEE">
		<p>Noticed:if you are an admin,plz select admin radio, otherwise,user radio </p>
	</div>
	 -->
</body>
</html>