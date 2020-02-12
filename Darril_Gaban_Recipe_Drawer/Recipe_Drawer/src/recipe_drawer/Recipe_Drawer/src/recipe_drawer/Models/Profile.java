package recipe_drawer.Models;

public class Profile {
	private int userId;
	private String name;
	private String email;
	private String bio;
	private String userPicture;
	
	public Profile(String email, String name, String bio) {
		this.setBio(bio);
		this.setEmail(email);
		this.setName(name);
	}
	
	public Profile(int userId, String name, String email, String bio, String userPicture) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.bio = bio;
		this.userPicture = userPicture;
	}

	public Profile() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userPicture
	 */
	public String getUserPicture() {
		return userPicture;
	}

	/**
	 * @param userPicture the userPicture to set
	 */
	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

}
