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
<li><a href="indexhome.html">Home</a></li>
<li><a href="Register.html">useregister</a></li>
<li><a href="login2.html">User Login</a></li>
<li><a href="alltraininfo.jsp">train Information</a></li>
<li><a href="contact2.html">Contact Us</a></li>
<li><a href="About.html">About Us</a></li>
</ul>
</td>
</tr>
</table>
<table border="2">
<tr><th>train name</th><th>Cost</th><th>Status</th></tr>
<%
try{
	Connection cn=GetConnection.getCn();
	PreparedStatement ps=cn.prepareStatement("Select name,cost,status from train");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>

</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>
</body>
</html>

