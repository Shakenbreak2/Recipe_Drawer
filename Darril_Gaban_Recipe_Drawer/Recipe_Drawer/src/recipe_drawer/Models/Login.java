package recipe_drawer.Models;

public class Login {
	private String username;
	private String password;
	
	public Login() {
		
	}
	
	public Login(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

}
