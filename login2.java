package allserv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login2
 */
@WebServlet("/login2")
public class login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public login2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String aid=request.getParameter("aid");
			String apas=request.getParameter("apas");
			if(aid.equals("admin") && apas.equals("pass")) {
				RequestDispatcher rd=request.getRequestDispatcher("AdminHome2.html");
				rd.forward(request, response);
			}else {
				out.print("wrong userid or password");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}


	}


