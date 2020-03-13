import java.sql.*;
import java.util.*;



public class LoginDAO {

	
	public static boolean checkUser(String user_name,String password) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventory","root","root");
            PreparedStatement ps = con.prepareStatement("select * from admin where user_name=? and password=?");
            ps.setString(1, user_name);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = (rs.next())?true:false;

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}
