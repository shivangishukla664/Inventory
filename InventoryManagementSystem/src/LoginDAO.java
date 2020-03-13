

import com.sun.corba.se.pept.transport.Connection;

public class LoginDAO {
    public static boolean validate(String user_name,String password) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating connection with the database
            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3307/inventory","root","root");
           java.sql.PreparedStatement ps = con.prepareStatement("select * from admin where user_name=? and password=?");
            ps.setString(1, user_name);
            ps.setString(2, password);
            java.sql.ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}