

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductViewServlet
 */
@WebServlet("/ProductViewServlet")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
      //  int Pro_id = request.getParameter("Pro_id");
        String Pro_name = request.getParameter("Pro_name");
        String categories = request.getParameter("categories");
        String manufacture = request.getParameter("manufacture");
       // int quantity = request.getParameter("quantity");
       // int price = request.getParameter("price");
        ResultSet ris=ViewProduct.view();
        try {
        	HttpSession session=request.getSession();
        	int i=1;
			while(ris.next())
			{
			    
			    session.setAttribute("Pro_id"+i,ris.getInt("Pro_id"));
			    session.setAttribute("Pro_name"+i, ris.getString("Pro_name"));
			    session.setAttribute("categories"+i, ris.getString("categories"));
			    session.setAttribute("manufacture"+i, ris.getString("manufacture"));
			    session.setAttribute("quantity"+i, ris.getInt("quantity"));
			    session.setAttribute("price"+i, ris.getInt("price"));
			    i+=1;
			}
			session.setAttribute("loop",i);
			System.out.println(session.getAttribute("user"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
        	RequestDispatcher rs = request.getRequestDispatcher("ViewProduct.jsp");
            rs.forward(request, response);
        
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
