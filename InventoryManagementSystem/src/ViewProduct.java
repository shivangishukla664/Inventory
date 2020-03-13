import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewProduct {

	 Connection con;
	 Statement st;
	 ResultSet res;
	
	 
	ViewProduct()
	{
		
	}
	
	public static ResultSet view() 
	{	 ResultSet res=null ;
	System.out.println("Helo\n\n\n\n\n\n\n\n");
	
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");  
  		  //create  the connection object 
  		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/inventory","root","root");  
        
     	 Statement st = con.createStatement();
     res= st.executeQuery("select * from product");

     	
     	  } 
     	  catch (Exception e) 
     	  {
     	  System.out.println("Error in fetching data" + e);
     	  }
                  return res;  
	}
}
