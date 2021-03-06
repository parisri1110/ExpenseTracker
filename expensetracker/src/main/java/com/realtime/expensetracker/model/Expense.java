package com.realtime.expensetracker.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="expense")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	
	private String description;
	
	private Instant expensedate;
	
	private String location;
	
	// @JsonIgnore  // to ignore User field we can use JSON ignore
	@ManyToOne(optional = false)
	@JoinColumn(name="userid")
	private User user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Expense()
	{
		
	}


	public Expense(Integer id, String description, Instant expensedate, String location, User user, Category category) {
		super();
		this.id = id;
		this.description = description;
		this.expensedate = expensedate;
		this.location = location;
		this.user = user;
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(Instant expensedate) {
		this.expensedate = expensedate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
}
