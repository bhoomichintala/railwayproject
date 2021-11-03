package packcon;

import java.sql.*;
public class GetConnection {
	static Connection cn=null;
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/RailwayInformation";
	static String user="root";
	static String pass="varsa9698";
	public static Connection getCn() throws Exception{
		Class.forName(driver);
		cn=DriverManager.getConnection(url, user, pass);
		return cn;
	}
}
