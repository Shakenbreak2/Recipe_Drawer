package recipe_drawer.function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlConnection {

	public SqlConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public String conName() {
		return "org.mariadb.jdbc.Driver";
	}
	
	public String conDB() {
		String str = "'jdbc:mariadb://localhost:3306/test', 'user', 'user'" ;
		return str;
	}

}
