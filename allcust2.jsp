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

<table>
<tr>
<td>
<ul>
<li><a href="AdminHome2.html">Home</a></li>
<li><a href="Add Trains.html">Add Trains</a></li>
<li><a href="UpdateTrains.html">Modify trains</a></li>
<li><a href="DeleteTrains.html">Delete trains</a></li>
<li><a href="alltrains.jsp">Show all trains</a></li>
<li><a href="allcust2.jsp">Customer Info</a></li>
<li><a href="indexhome.html">Logout</a></li>
</ul>
</td>
</tr>
</table>
<%@page import="java.sql.*,packcon.*" %>
<table border="2">
<tr><th>Customer ID</th><th>Name</th><th>Address</th><th>Phone</th><th>Email</th></tr>
<%
try{
	Connection cn=GetConnection.getCn();  
	PreparedStatement ps=cn.prepareStatement("Select cid,cname,cadr,cphn,cmail from customer");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	out.print(e);
} %>
</table>

</body>
</html>


