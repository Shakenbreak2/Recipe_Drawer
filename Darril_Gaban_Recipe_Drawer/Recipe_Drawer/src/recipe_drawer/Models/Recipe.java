package recipe_drawer.Models;

public class Recipe {
	private String recipeName;
	private String email;
	private String recipePicture;
	private String recipeIngredience;
	private String recipeDirection;
	private String[] tags;
	
	public Recipe() {
	}
	

	/**
	 * @return the rname
	 */
	public String getRname() {
		return recipeName;
	}

	/**
	 * @param rname the rname to set
	 */
	public void setRname(String rname) {
		recipeName = rname;
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
	 * @return the rpicture
	 */
	public String getRpicture() {
		return recipePicture;
	}

	/**
	 * @param rpicture the rpicture to set
	 */
	public void setRpicture(String rpicture) {
		recipePicture = rpicture;
	}

	/**
	 * @return the ringredience
	 */
	public String getRingredience() {
		return recipeIngredience;
	}

	/**
	 * @param ringredience the ringredience to set
	 */
	public void setRingredience(String ringredience) {
		recipeIngredience = ringredience;
	}

	/**
	 * @return the rdirection
	 */
	public String getRdirection() {
		return recipeDirection;
	}

	/**
	 * @param rdirection the rdirection to set
	 */
	public void setRdirection(String rdirection) {
		recipeDirection = rdirection;
	}

	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	

}
