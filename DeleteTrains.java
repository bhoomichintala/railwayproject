package allserv;
import java.sql.*;
import packcon.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import packcon.GetConnection;

/**
 * Servlet implementation class DeleteTrains
 */
@WebServlet("/DeleteTrains")
public class DeleteTrains extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteTrains() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String rid=request.getParameter("rid");
			Connection cn=GetConnection.getCn();
			PreparedStatement ps=cn.prepareStatement("select * from train where rid=?");
			ps.setString(1, rid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				PreparedStatement ps1=cn.prepareStatement("delete from train where rid=?");
				ps1.setString(1, rid);
				ps1.execute();
				out.print("train deleted..");
				RequestDispatcher  rd=request.getRequestDispatcher("AdminHome2.html");
				rd.include(request, response);
				
			}else {
				out.print("no record found");
				RequestDispatcher rd=request.getRequestDispatcher("AdminHome2.html");
				rd.include(request, response);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	}

