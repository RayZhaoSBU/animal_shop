package com.mercury.AnimalShop.bean;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private int rate;

	public Review() {
		super();
	}
	public Review(long id,
				  String username,
				  String title,
				  String description,
				  int rate) {
		super();
		this.id = id;
		this.username = username;
		this.title = title;
		this.description = description;
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", username=" + username + ", title=" + title + ", description=" + description
				+ ", rate=" + rate + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
