package recipe_drawer.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import recipe_drawer.Models.Login;
import recipe_drawer.function.SqlConnection;

public class LoginDao extends HttpServlet {
	private Login login;
	
	public LoginDao() {
		
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String un = request.getParameter("username");
	        String pw = request.getParameter("password");

	// Connect to mysql(mariadb) and verify username password

	        try {
	        	SqlConnection con = new SqlConnection();
	            Class.forName(con.conName());
	// loads driver
	            Connection c = DriverManager.getConnection(con.conDB()); // gets a new connection

	            PreparedStatement ps = c.prepareStatement("select userName,pass from student where userName=? and pass=?");
	            ps.setString(1, un);
	            ps.setString(2, pw);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                response.sendRedirect("success.html");
	                return;
	            }
	            response.sendRedirect("error.html");
	            return;
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	

}
