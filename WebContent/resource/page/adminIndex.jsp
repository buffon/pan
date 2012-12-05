<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>admin index</title>
<%@ include file="common.inc.html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pan.bean.MissionBean"%>
<script type="text/javascript">
function showDetail(str){
	confirm(str);
}
</script>
</head>
<body>
    <%@ include file="head.inc.html"%>
    <div align=right>
		<a href="index.do">as user</a>&nbsp;|&nbsp;<a href="adminindex.do">as admin</a>&nbsp;|&nbsp;<a href="logout.do">logout</a>
	</div>
    <p class="lead text-info" style="margin-left: 20px">admin <strong> <%=request.getSession().getAttribute("username") %></strong></p>
	<div>
		<div>
		<form action="filteruser.do" method="post">
		<h4>
			<span class="text-success" style="margin-left: 20px">get missions of</span> <select name="selectedname">
			
			<%
			if(request.getAttribute("currentname") == null){
			%>
			<option value='all'>all</option>
			<%
			} else if(request.getAttribute("currentname").equals("all")) {
				%>
				<option value='all'>all</option>
				<%
				
			} else {
			
			%>
			<option value='<%= request.getAttribute("currentname") %>'><%= request.getAttribute("currentname") %></option>
			<%
			  List<String> users = (List<String>) request.getAttribute("users");
			  users.remove(request.getAttribute("currentname"));
			  request.setAttribute("users", users);
			%>
			<option value='all'>all</option>
			<%
			}
			 %>
			<%
	
			List<String> users =(List<String>) request.getAttribute("users");
			for(int i = 0; i<users.size(); i ++){	
			%>
			 <option value='<%=users.get(i)%>'><%=users.get(i)%></option>
			<%
			}
	
			%>
			</select>
			<input type="submit" value="run"/>
		</h4>
		</form>
	</div>
		<table class="table table-striped"
			style="width: 80%; margin-left: 20px">
		<tr>
		<td><strong>mission_name |</strong></td>
		<td><strong>owner |</strong></td>
		<td><strong>description |</strong></td>
		<td><strong>start_time |</strong></td>
		<td><strong>end_time |</strong></td>
		<td><strong>status |</strong></td>
		<td></td>
		<td></td>
		</tr>
		<%
		List<MissionBean> beans =(List<MissionBean>) request.getAttribute("missions");
		for(int i =0;i<beans.size();i++){
		%>
		<tr>
		<td><%=beans.get(i).getMissionname() %></td>
		<td><%=beans.get(i).getUsername() %></td>
		<!-- <td><%=beans.get(i).getMissiondiscrip() %></td>  -->
		<td><a href="" onclick="showDetail('<%=beans.get(i).getMissiondiscrip()%>')">detail</a></td>
		<td><%=beans.get(i).getStartTime() %></td>
		<td><%=beans.get(i).getEndTime() %></td>
		<td><strong><%=beans.get(i).getStatus() %></strong></td>
		
					<%
						if (beans.get(i).getStatus().equals("finished")) {
                    %>
                         <td></td>
                         <td></td>
                    <%
						} else {
					%>
				           <td><a href="mdetail.do?missionid=<%=beans.get(i).getId() %>">manager</a></td>
				           <td><a href="adminfinishm.do?currentname=<%= request.getAttribute("currentname")%>&missionid=<%=beans.get(i).getId() %>">finish</a></td>
				   <%
					   }
				   %>
		</tr>
		<%
		}
		%>
		
		</table>
	</div>

</body>
</html>