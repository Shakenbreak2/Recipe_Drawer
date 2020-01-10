package recipe_drawer.Models;

public class Comment {
	private String name;
	private String text;
	private String time;
	
	public Comment() {
		
	}
	
	public Comment(String name, String text) {
		this.setName(name);
		this.setText(text);
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
