package com.realtime.expensetracker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// Travel , Grocery
	private String name;
	
     /*
      * many categories can be assigned to one user
     */
	
		/*
		 * @ManyToOne(cascade = CascadeType.PERSIST) private User user;
		 */
	
	public Category()
	{
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

}
