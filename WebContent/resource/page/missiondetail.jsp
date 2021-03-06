<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="c"%> 
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
	function showdetail(str){
		confirm(str);
	} 
</script>
</head>
<body>
	<%@ include file="head.inc.jsp"%>
	<div align=right>
	    <% if(request.getSession().getAttribute("role").equals("admin")){
	    %>
	    	<a href="adminindex.do">admin index</a>&nbsp;|&nbsp;
	    <%
	    }
	    %>

		<a href="index.do"><c:sr word="Index"/></a>&nbsp;|&nbsp;<a href="logout.do"><c:sr word="Logout"/></a>
	</div>
	<p class="lead text-info" style="margin-left: 20px"><strong><%= (String) request.getSession().getAttribute("username")%></strong> >> <%= request.getAttribute("mName")%></p>

	<div style="margin-left: 20px">
		<p class="text-success"><strong><c:sr word="M_detail_line"/></strong></p>
		<table class="table table-striped" style="width: 60%">
			<tr>
				<td><strong><c:sr word="Who"/> |</strong></td>
				<td><strong><c:sr word="Description"/> |</strong></td>
				<td><strong><c:sr word="Status"/> |</strong></td>
				<td><strong><c:sr word="Start_time"/> |</strong></td>
				<td><strong><c:sr word="End_time"/> |</strong></td>
				<td></td>
			</tr>
			<%
			List<DMissionBean> dmissions = (ArrayList<DMissionBean>) request.getAttribute("dmissions");
			for(int i =0;i<dmissions.size();i++){
			%>
			<tr>
			<td><%= dmissions.get(i).getHelper() %></td>
			<td><a href="" onclick="showdetail('<%= dmissions.get(i).getDescrip() %>')">detail</a></td>
			<td><strong><%= dmissions.get(i).getStatus() %></strong></td>
			<td><%= dmissions.get(i).getStartTime()%></td>
			<td><%= dmissions.get(i).getEndTime()%></td>
			<% 
			if(dmissions.get(i).getStatus().equals("running")){
			%>
			<td><a href="finishdm.do?missionid=<%= request.getAttribute("mid")%>&dmissionid=<%=dmissions.get(i).getId()%>">finish</a></td>
			<%	
			}else{
			%>
			<td></td>
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
	<p class="text-success" style="margin-left: 20px"><strong>add a new help</strong></p>
	<div class="addhelp" style="margin-left: 20px">
	<form action="addmdtetail.do" method="post">
	    <input type="hidden" name="missionid" value='<%= request.getAttribute("mid")%>'>
		<table class="table" style="width: 30%">
			<tr>
				<td><strong><c:sr word="Who"/></strong></td>
				<td>
				 <select name="helpername">
				  <%
				   List<String> names = (List<String>)request.getAttribute("names");
				   for(int i =0;i<names.size();i++){
					   if(names.get(i).equals((String) request.getSession().getAttribute("username"))){
						   
					   }else{
						   %>
						   <option value='<%=names.get(i)%>'><%=names.get(i)%></option>
						   <% 
					   }
				   }
				  %>
				 </select>
				</td>
			</tr>
			<tr>
				<td><strong><c:sr word="Description"/></strong></td>
				<td><!--<input type="text" name="content">-->
				<textarea name="content" rows=10 cols=40></textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value=<c:sr word="Add"/>>
	</form>
	</div>


</body>
</html>