package com.mercury.AnimalShop.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name="order_product")
public class OrderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private long userId;
	@Column
	private int qty;
	@Column
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	private Order order;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	private Product product;

	public OrderProduct() {
		super();
	}

	public OrderProduct(long id,
						long userId,
						int qty,
						String status,
						Order order,
						Product product) {
		super();
		this.id = id;
		this.userId = userId;
		this.qty = qty;
		this.status = status;
		this.order = order;
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", userId=" + userId + ", qty=" + qty + ", status=" + status + ", order="
				+ order + ", product=" + product + "]";
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
	
	
	
}
