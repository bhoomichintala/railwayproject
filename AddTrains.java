package allserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import packcon.GetConnection;

/**
 * Servlet implementation class AddTrains
 */
@WebServlet("/AddTrains")
public class AddTrains extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddTrains() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			int rid=(int)(Math.random()*1000);
			String status="free";
			String size=request.getParameter("size");
			String cost=request.getParameter("cost");
			Connection cn=GetConnection.getCn();
			PreparedStatement ps=cn.prepareStatement("insert into train values(?,?,?,?)");
			ps.setInt(1, rid);
			ps.setString(2, size);
			ps.setString(3, cost);
			ps.setString(4, status);
			ps.execute();
			
			out.print("Record saved...");
			RequestDispatcher  rd=request.getRequestDispatcher("AdminHome2.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

	


