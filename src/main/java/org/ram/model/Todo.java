package org.ram.model;

import java.time.LocalDate;


public class Todo {

	
	private Integer id;

	private String username;

	private String description;


	private LocalDate target_date;


	private String done;

	public Todo() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTarget_date() {
		return target_date;
	}

	public void setTarget_date(LocalDate target_date) {
		this.target_date = target_date;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", target_date="
				+ target_date + ", done=" + done + "]";
	}

	public Todo(Integer id, String username, String description, LocalDate target_date, String done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.target_date = target_date;
		this.done = done;
	}

}