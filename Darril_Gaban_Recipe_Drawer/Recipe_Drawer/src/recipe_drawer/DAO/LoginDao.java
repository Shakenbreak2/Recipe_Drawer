package recipe_drawer.DAO;

import java.util.ArrayList;
import java.util.List;

import recipe_drawer.Models.Login;

public class LoginDao {
	private List<Login> loginlist = new ArrayList<Login>();
	
	public LoginDao() {
		// TODO Auto-generated constructor stub
	}
	
	private List<Login> getLogin() {
		return loginlist;
		
	}
	
	
	
	public boolean validateUser(String username, String password) {
		List<Login> loginValidate = getLogin();
		
		
		return false;
		
	}

}
