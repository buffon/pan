<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="c"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>index</title>

<%@ include file="common.inc.html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pan.bean.MissionBean"%>
<style type="text/css">

</style>
<script type="text/javascript">
function showDetail(str){
	confirm(str);
}

</script>
</head>
<body>
<%@ include file="head.inc.jsp"%>

	<div align=right>
	<%
	if(request.getSession().getAttribute("role").equals("admin")){
	%>
	<a href="index.do">as user</a>&nbsp;|&nbsp;<a href="adminindex.do">as admin</a>&nbsp;|&nbsp;
	<%
	}
	%>
		<a href="logout.do"><c:sr word="Logout"/></a>
	</div>
	<p class="lead text-info" style="margin-left: 20px"><c:sr word="User"/> <strong><%=request.getSession().getAttribute("username") %></strong></p>

	<div>
		<p class="text-success" style="margin-left: 20px"><strong><c:sr word="Existing_mission"/></strong></p>
		<table class="table table-striped"
			style="width: 60%; margin-left: 20px">
			<tr>
				<td><strong><c:sr word="Mission_name"/> |</strong></td>
				<td><strong><c:sr word="Description"/> |</strong></td>
				<td><strong><c:sr word="Start_time"/></strong></td>
				<td><strong><c:sr word="End_time"/></strong></td>
				<td><strong><c:sr word="Status"/> |</strong></td>
				<td></td>
				<td></td>
			</tr>
			<%
					List<MissionBean> missions = (ArrayList<MissionBean>) request.getAttribute("missions");
					for (int i = 0; i < missions.size(); i++) {
				%>
			<tr>
				
				<td><%=missions.get(i).getMissionname()%></td>
				<td><a href="" onclick="showDetail('<%=missions.get(i).getMissiondiscrip()%>')">detail</a></td>
				<td><%=missions.get(i).getStartTime()%></td>
				<td><%=missions.get(i).getEndTime()%></td>
				<td><strong><%=missions.get(i).getStatus()%></strong></td>
				
					<%
						if (missions.get(i).getStatus().equals("finished")) {
                    %>
                    <td></td>
                    <td></td>
                    <% 
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
	<p class="text-success" style="margin-left: 20px"><strong><c:sr word="New_mission"/></strong></p>
	<div class="new">
	<form action="addmission.do" method="post">
		<table style="margin-left: 20px">
			<tr>
				<td><strong><c:sr word="Mission_name"/></strong></td>
				<td><input type="text" name="missionname" size=47></td>
			</tr>
			<tr>
				<td><strong><c:sr word="Description"/></strong></td>
				<td><!-- <input type="text" name="description"> -->
				  <textarea name="description" rows=10 cols=40></textarea>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value=<c:sr word="Add"/>></td>
			</tr>
		</table>
	</form>
	</div>

</body>
</html>