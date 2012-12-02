<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>mission detail</title>
<%@ include file="common.inc.html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pan.bean.DMissionBean"%>
<style type="text/css">
.addhelp {
	
}
</style>
<script type="text/javascript">
	function addHelp() {
		alert("hello");
	}
</script>
</head>
<body>
	<p class="lead" style="background-color: #BBFFEE; height: 80px">Mission
		Track Management System</p>
	<div align=right>
		<a href="index.do">index</a>&nbsp;|&nbsp;<a href="logout.do">logout</a>
	</div>
	<p class="lead" style="margin-left: 20px"><%= (String) request.getSession().getAttribute("username")%> -- <%= request.getAttribute("mName")%></p>

	<div style="margin-left: 20px">
		<p class="lead">In order to finish this mission, I need help from:</p>
		<table class="table" style="width: 60%">
			<tr>
				<td>who |</td>
				<td>description |</td>
				<td>status |</td>
			</tr>
			<%
			List<DMissionBean> dmissions = (ArrayList<DMissionBean>) request.getAttribute("dmissions");
			for(int i =0;i<dmissions.size();i++){
			%>
			<tr>
			<td><%= dmissions.get(i).getHelper() %></td>
			<td><a href="" onclick="showdetail()">detail</a></td>
			<td><%= dmissions.get(i).getStatus() %></td>
			<% 
			if(dmissions.get(i).getStatus().equals("running")){
			%>
			<td><a href="finishdm.do?missionname=<%= request.getAttribute("mName")%>&dmissionid=<%=dmissions.get(i).getId()%>">finish</a></td>
			<%	
			}	
			%>
			</tr>
			<%
			}
			%>
		</table>

	</div>
	<br>
	<br>
	<p class="lead" style="margin-left: 20px">add a new help</p>
	<div class="addhelp" style="margin-left: 20px">
	<form action="addmdtetail.do" method="post">
	    <input type="hidden" name="missionname" value='<%= request.getAttribute("mName")%>'>
		<table class="table" style="width: 20%">
			<tr>
				<td>who</td>
				<td><input type="text" name = "helpername"></td>
			</tr>
			<tr>
				<td>content</td>
				<td><input type="text" name="content"></td>
			</tr>
		</table>
		<input type="submit" value="add">
	</form>
	</div>


</body>
</html>