package com.mercury.AnimalShop.bean;

import javax.persistence.*;

@Entity
@Table(name="Shipping")
public class Shipping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String type;
	@Column
	private int price;

	public Shipping() {
		super();
	}

	public Shipping(long id, String type, int price) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Shipping{" +
				"id=" + id +
				", type='" + type + '\'' +
				", price=" + price +
				'}';
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
