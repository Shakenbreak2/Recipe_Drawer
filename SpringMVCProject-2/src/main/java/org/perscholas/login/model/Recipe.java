package org.perscholas.login.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rId")
	private int id;
	@Size(max = 125)
    @Column(name = "rName")
	private String name;
	@Size(max = 500)
	@Column(name="rDescirption")
	private String description;
	@Size(max = 500)
	@Column(name="rIngredience")
	private String ingredience;
	@Size(max = 500)
	@Column(name="rDirection")
	private String direction;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="rPicture", columnDefinition="BLOB")
	private byte[] picture;
	
	@ManyToMany
	@JoinTable(
	  name = "recipe_categories", 
	  joinColumns = @JoinColumn(name = "rId"), 
	  inverseJoinColumns = @JoinColumn(name = "catId"))
	private List<Category> category;
	
	@ManyToOne
	private Login login;
	
	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	public Recipe(int id, @Size(max = 125) String name,@Size(max = 500) String description, @Size(max = 500) String instruction,
			@Size(max = 500) String direction, byte[] picture, List<Category> category, Login login) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ingredience = instruction;
		this.direction = direction;
		this.picture = picture;
		this.category = category;
		this.login = login;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the instruction
	 */
	public String getInstruction() {
		return ingredience;
	}

	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(String instruction) {
		this.ingredience = instruction;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the picture
	 */
	public byte[] getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	/**
	 * @return the category
	 */
	public List<Category> getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(List<Category> category) {
		this.category = category;
	}

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}

	
}
