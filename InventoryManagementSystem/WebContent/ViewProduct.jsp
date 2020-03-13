<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>

		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Categories</th>
			<th>Manufacturer</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>

		<%
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");  
		  		  //create  the connection object 
		  		  java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3307/inventory","root","root");  
		        
		     	 java.sql.Statement st = con.createStatement();
		     	java.sql.ResultSet rs= st.executeQuery("select * from product");
			
				
				
				while (rs.next()) {
					out.println("<tr><td>" + rs.getString("Pro_id") + 
							"</td><td>" + rs.getString("Pro_name") + 
							"</td><td>"	+ rs.getString("categories") +
							"</td><td>"	+ rs.getString("manufacturer") +
							"</td><td>"	+ rs.getString("quantity") +
							"</td><td>"	+ rs.getString("price") +
							"</td></tr>");
				}
			} catch (Exception e) {
			out.println(e.getMessage() + "\n\n\n\n\n\n");
			}
		%>

	</table>
</body>
</html>