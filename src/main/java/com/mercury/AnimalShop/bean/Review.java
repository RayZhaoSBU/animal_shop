package com.mercury.AnimalShop.bean;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private long userId;
	@Column
	private long productId;
	@Column
	private String title;
	@Column(length=3000)
	private String description;
	@Column
	private int rate;
	public Review() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	public Review(long id, long userId, long productId, String title, String description, int rate) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.title = title;
		this.description = description;
		this.rate = rate;
	}

}
