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
import javax.servlet.http.HttpSession;

import packcon.GetConnection;



/**
 * Servlet implementation class UpdateTrains
 */
@WebServlet("/UpdateTrains")
public class UpdateTrains extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateTrains() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			HttpSession s=request.getSession();
			String spid=(String)s.getAttribute("rid");
			String size=request.getParameter("size");
			String cost=request.getParameter("cost");
			Connection cn=GetConnection.getCn();
			PreparedStatement ps=cn.prepareStatement("update train set size=?,cost=? where rid=?");
			ps.setString(1, size);
			ps.setString(2, cost);
			ps.setString(3, spid);
			ps.execute();
			out.print("Record updated...");
			RequestDispatcher rd=request.getRequestDispatcher("AdminHome2.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}



	}


