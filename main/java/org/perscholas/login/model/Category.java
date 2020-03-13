package org.perscholas.login.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="catId")
	private int id;
	
	@Size(max = 125)
    @Column(name = "catName")
	private String name;
	
	@ManyToMany(mappedBy="category",fetch= FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Recipe> recipe;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

}
