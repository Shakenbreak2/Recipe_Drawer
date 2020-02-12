package recipe_drawer.Models;

public class Recipe {
	private int recipeId;
	private String recipeUser;
	private String recipeName;
	private String recipeInsruction;
	private String recipeDirection;
	private String recipePicture;
	
	public Recipe() {
	}

	public Recipe(int recipeId, String recipeUser, String recipeName, String recipeInsruction, String recipeDirection,
			String recipePicture) {
		super();
		this.recipeId = recipeId;
		this.recipeUser = recipeUser;
		this.recipeName = recipeName;
		this.recipeInsruction = recipeInsruction;
		this.recipeDirection = recipeDirection;
		this.recipePicture = recipePicture;
	}

	/**
	 * @return the recipeId
	 */
	public int getRecipeId() {
		return recipeId;
	}

	/**
	 * @param recipeId the recipeId to set
	 */
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	/**
	 * @return the recipeUser
	 */
	public String getRecipeUser() {
		return recipeUser;
	}

	/**
	 * @param recipeUser the recipeUser to set
	 */
	public void setRecipeUser(String recipeUser) {
		this.recipeUser = recipeUser;
	}

	/**
	 * @return the recipeName
	 */
	public String getRecipeName() {
		return recipeName;
	}

	/**
	 * @param recipeName the recipeName to set
	 */
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	/**
	 * @return the recipeInsruction
	 */
	public String getRecipeInsruction() {
		return recipeInsruction;
	}

	/**
	 * @param recipeInsruction the recipeInsruction to set
	 */
	public void setRecipeInsruction(String recipeInsruction) {
		this.recipeInsruction = recipeInsruction;
	}

	/**
	 * @return the recipeDirection
	 */
	public String getRecipeDirection() {
		return recipeDirection;
	}

	/**
	 * @param recipeDirection the recipeDirection to set
	 */
	public void setRecipeDirection(String recipeDirection) {
		this.recipeDirection = recipeDirection;
	}

	/**
	 * @return the recipePicture
	 */
	public String getRecipePicture() {
		return recipePicture;
	}

	/**
	 * @param recipePicture the recipePicture to set
	 */
	public void setRecipePicture(String recipePicture) {
		this.recipePicture = recipePicture;
	}
	
}
