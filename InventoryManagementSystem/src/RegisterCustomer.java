
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterCustomer
 */
@WebServlet("/RegisterCustomer")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterCustomer() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());

		Connection con;
		Statement st;
		ResultSet res;
		PreparedStatement ps;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// creating connection with the database
			con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3307/inventory2", "root", "root");

			

			// String cid=KB.readLine();

			String clname = request.getParameter("Last Name");
			String cfname = request.getParameter("FirstName");
			String cemail = request.getParameter("Email");
			String cuser =request.getParameter("Username");
			String cpassword = request.getParameter("Password");
			String ccfmpassword =request.getParameter("Confirm Password");

			String query = "insert into customers(customer_id,customer_first_name,customer_last_name,customer_email,customer_username,customer_password) values"
					+ "(customer_id,?,?,?,?,?)";

			// creating object of PreparedStatement class and passing parameter (?)
			PreparedStatement smt = con.prepareStatement(query);

			// set the values

			smt.setString(1, cfname);
			smt.setString(2, clname);
			smt.setString(3, cemail);
			smt.setString(4, cuser);
			smt.setString(5, cpassword);
			

			smt.executeUpdate();
			System.out.println("Record Updated....");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
