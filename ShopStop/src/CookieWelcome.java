

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieWelcome
 */
@WebServlet("/CookieWelcome")
public class CookieWelcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieWelcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			try{
			response.setContentType("text/html");
			PrintWriter pwriter=response.getWriter();
			//Reading cookies
			
			Cookie[] c=request.getCookies();
			
			//Displaying User name value from cookie

			pwriter.print("Session Id: "+c[0].getValue());
			pwriter.print("Name here: "+c[1].getValue());
			pwriter.print("Password: "+c[2].getValue());
			pwriter.close();
			
			}
			catch(Exception exp)
			{
			System.out.println(exp);
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
