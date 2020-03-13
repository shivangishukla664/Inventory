
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginToInventory
 */
@WebServlet("/LoginToInventory")
public class LoginToInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginToInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// creating connection with the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventory2", "root", "root");
			String sql = "select * from customers where customer_email=? and customer_password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, request.getParameter("email"));
			pst.setString(2, request.getParameter("Password"));
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("email", rs.getString("customer_email"));
				System.out.println(rs.getString("customer_email"));
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/profile.jsp");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		doGet(request, response);
	}

}
