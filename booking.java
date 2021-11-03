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
 * Servlet implementation class booking
 */
@WebServlet("/booking")
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public booking() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String spid=request.getParameter("rc");
			HttpSession s=request.getSession(false);
			String cid=(String)s.getAttribute("cid");
			String dte="22-10-21";
			
			Connection cn=GetConnection.getCn();
			PreparedStatement ps=cn.prepareStatement("insert into book values(?,?,?)");
			ps.setString(1, spid);
			ps.setString(2, cid);
			ps.setString(3, dte);
			ps.execute();
			
			PreparedStatement ps1=cn.prepareStatement("update train set status='booked' where rid=?");
			ps1.setString(1, spid);
			ps1.execute();
			
			out.print("Booking success...");
			RequestDispatcher rd=request.getRequestDispatcher("userhome2.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}



	}


