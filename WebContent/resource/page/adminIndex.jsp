<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin index</title>
</head>
<body>
	<div>
		<h4>all missions</h4>
		<table>
		<tr>
		<td>name |</td>
		<td>owner |</td>
		<td>description |</td>
		<td>begintime |</td>
		<td>endtime |</td>
		<td>status |</td>
		<td></td>
		</tr>
		<tr>
		<td>zhangsan</td>
		<td>mission1</td>
		<td>2012-10-11</td>
		<td></td>
		<td>running</td>
		<td><a href="">detail</a></td>
		<td><a href="">finished</a></td>
		</tr>
		<tr>
		<td>lisi</td>
		<td>mission1</td>
		<td>2012-10-11</td>
		<td></td>
		<td>running</td>
		<td><a href="">detail</a></td>
		<td><a href="">finished</a></td>
		</tr>
		<tr>
		<td>zhangsan</td>
		<td>mission2</td>
		<td>2012-10-11</td>
		<td>2012-11-15</td>
		
		<td>finished</td>
		<td><a href="">detail</a></td>
		</tr>
		</table>
	</div>
	<div>
		<h4>
			get missions of <select name="selectAge" id="selectAge">
				<option value="1">zhangsan</option>
				<option value="2">lisi</option>
				<option value="3">wangwu</option>
			</select>
			<a href="">run</a>
		</h4>
		
	</div>
	<div>
	   <h4> all members</h4>
	</div>
</body>
</html>