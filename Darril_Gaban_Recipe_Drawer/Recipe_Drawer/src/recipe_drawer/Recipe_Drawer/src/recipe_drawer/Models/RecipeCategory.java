package recipe_drawer.Models;

public class RecipeCategory {
	private int categoryId;
	private int recipeId;
	
	public RecipeCategory() {
		// TODO Auto-generated constructor stub
	}

	public RecipeCategory(int categoryId, int recipeId) {
		super();
		this.categoryId = categoryId;
		this.recipeId = recipeId;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
