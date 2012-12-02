<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index</title>
<%@ include file="common.inc.html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pan.bean.MissionBean"%>
</head>
<body>
	<p class="lead" style="background-color: #BBFFEE; height: 80px">Mission
		Track Management System</p>
	<div align=right>
		<a href="logout.do">logout</a>
	</div>
	<p class="lead" style="margin-left: 20px">User <%=request.getAttribute("username") %></p>

	<div>
		<p class="lead" style="margin-left: 20px">Existing Missions</p>
		<table class="table table-striped"
			style="width: 60%; margin-left: 20px">
			<tr>
				<td>mission name |</td>
				<td>description |</td>
				<td>status |</td>
				<td></td>
			</tr>
			<%
					List<MissionBean> missions = (ArrayList<MissionBean>) request.getAttribute("missions");
					for (int i = 0; i < missions.size(); i++) {
				%>
			<tr>
				
				<td><%=missions.get(i).getMissionname()%></td>
				<td><%=missions.get(i).getMissiondiscrip()%></td>
				<td><%=missions.get(i).getStatus()%></td>
				
					<%
						if (missions.get(i).getStatus().equals("finished")) {

						} else {
					%>
				           <td><a href="mdetail.do?missionid=<%=missions.get(i).getId() %>">manager</a></td>
				           <td><a href="finish.do?missionid=<%=missions.get(i).getId() %>">finish</a></td>
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
	<p class="lead" style="margin-left: 20px">New a Mission</p>
	<div class="new">
	<form action="addmission.do" method="post">
		<table style="margin-left: 20px">
			<tr>
				<td>mission name</td>
				<td><input type="text" name="missionname"></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td><input type="submit" value="add"></td>
			</tr>
		</table>
	</form>
	</div>

</body>
</html>