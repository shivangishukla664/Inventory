

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeInventory
 */
@WebServlet("WelcomeInventory")
public class WelcomeInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeInventory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String user=request.getParameter("user_name");
		String pass=request.getParameter("password");
		
		if(user.contentEquals("shivangi") && pass.contentEquals("shivi123"))
		{
			/*out.println("<html><body bgcolor='aqua',text='blue'>");
			out.println("<h3> Welcome " +user +"</h3>");
			out.println("</body></html>");*/
			
			RequestDispatcher rd=request.getRequestDispatcher("Index1");
			rd.forward(request,response);
		}
		else
		{
			out.println("<html><body text='red'><h3>Login Failed...</hr></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			//out.println("Login Failed!!!");
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
