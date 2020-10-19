package com.mercury.AnimalShop.bean;

import javax.persistence.*;

@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private int userId;
	@Column
	private String title;
	@Column
	private String description;

	public Feedback() {
		super();
	}

	public Feedback(long id, int userId, String title, String description) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userId=" + userId + ", title=" + title + ", description=" + description + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
