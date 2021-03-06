package com.mercury.AnimalShop.bean;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="\"order\"")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private long userId;
	@Column
	private Date date;
	@Column
	private String payment;
	@Column
	private String status;
	@Column
	private double total;
	@Column
	private double subtotal;
	@Column
	private double tax;
	@Column
	private double shipping;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Address address;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="order")
	private List<OrderProduct> purchases;

	public Order() {
		super();
	}

	public Order(long id,
				 long userId,
				 Date date,
				 String payment,
				 String status,
				 double total,
				 double subtotal,
				 double tax,
                 double shipping,
				 Address address,
				 List<OrderProduct> purchases) {
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.payment = payment;
		this.status = status;
		this.total = total;
		this.subtotal = subtotal;
		this.tax = tax;
		this.shipping = shipping;
		this.address = address;
		this.purchases = purchases;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<OrderProduct> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<OrderProduct> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", userId=" + userId +
				", date=" + date +
				", payment='" + payment + '\'' +
				", status='" + status + '\'' +
				", total=" + total +
				", subtotal=" + subtotal +
				", tax=" + tax +
				", shipping=" + shipping +
				", address=" + address +
				", purchases=" + purchases +
				'}';
	}
}
