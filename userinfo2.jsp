<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
margin-left: auto;
margin-right: auto;
}
ul{
list-style-type: none;
margin: 0;
padding: 0;
overflow: hidden;
background-color: #333;
}
li{
float: left;
}
li a {
display: block;
color: white;
text-align: center;
padding: 14px 16px;
text-decoration: none;
}
li a:hover {
	background-color: #111;
}
</style>

</head>
<body>
<%@page import="java.sql.*,packcon.*" %>
<table>
<tr>
<td>
<ul>

<li><a href="alltraininfo.jsp">Train status</a></li>
<li><a href="userinfo2.jsp">Details</a></li>
<li><a href="indexhome.html">Logout</a></li>
</ul>
</td>
</tr>
</table>
<table style="background-color: cyan">
<tr><th colspan="6">Personal Info</th></tr>
<tr><th>Customer ID</th><th>Password</th><th>Name</th><th>Address</th><th>Phone</th><th>Email</th></tr>
<%
try{
	Connection cn=GetConnection.getCn();
	session=request.getSession(false);
	String cid=(String)session.getAttribute("cid");
	PreparedStatement ps=cn.prepareStatement("Select * from customer where cid=?");
	ps.setString(1, cid);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>
<br><br>
<table style="background-color: cyan">
<tr><th colspan="6">Space Booking info</th></tr>
<tr><th>Train ID</th><th>Date of Booking</th></tr>
<%
try{
	Connection cn=GetConnection.getCn();
	session=request.getSession(false);
	String cid=(String)session.getAttribute("cid");
	PreparedStatement ps=cn.prepareStatement("Select rid,dte from book where cid=?");
	ps.setString(1, cid);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>

</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>

</body>
</html>
