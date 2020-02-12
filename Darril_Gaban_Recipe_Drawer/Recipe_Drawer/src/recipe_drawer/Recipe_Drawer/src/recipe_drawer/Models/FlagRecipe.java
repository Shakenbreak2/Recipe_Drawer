package recipe_drawer.Models;

public class FlagRecipe {
	private int flagId;
	private int recipeId;
	
	public FlagRecipe() {
		// TODO Auto-generated constructor stub
	}

	public FlagRecipe(int flagId, int recipeId) {
		super();
		this.flagId = flagId;
		this.recipeId = recipeId;
	}

	/**
	 * @return the flagId
	 */
	public int getFlagId() {
		return flagId;
	}

	/**
	 * @param flagId the flagId to set
	 */
	public void setFlagId(int flagId) {
		this.flagId = flagId;
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

}
