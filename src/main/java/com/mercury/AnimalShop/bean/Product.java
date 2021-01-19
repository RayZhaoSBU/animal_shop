package com.mercury.AnimalShop.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="product")
public class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private double price;
	@Column
	private String description;
	@Column
	private String tags;
	@Column
	private String brand;
	@Column
	private String type;
	@Column
	private String animalType;
	@Column
	private String lifeStage;
	@Column
	private int stock;
	@Column
	private Date releaseDate;
	@Column
	private int soldNumber;
	@Column
	private String image1;
	@Column
	private String image2;
	@Column
	private String image3;
	@Column
	private String image4;

	public Product() {
		super();
	}

	public Product(long id,
				   String name,
				   double price,
				   String description,
				   String tags,
				   String brand,
				   String type,
                   String animalType,
                   String lifeStage,
                   int stock,
				   Date releaseDate,
				   int soldNumber,
				   String image1,
				   String image2,
				   String image3,
				   String image4) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.tags = tags;
		this.brand = brand;
		this.type = type;
		this.animalType = animalType;
		this.lifeStage = lifeStage;
		this.stock = stock;
		this.releaseDate = releaseDate;
		this.soldNumber = soldNumber;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				", description='" + description + '\'' +
				", tags='" + tags + '\'' +
				", brand='" + brand + '\'' +
				", type='" + type + '\'' +
				", animalType='" + animalType + '\'' +
				", lifeStage='" + lifeStage + '\'' +
				", stock=" + stock +
				", releaseDate=" + releaseDate +
				", soldNumber=" + soldNumber +
				", image1='" + image1 + '\'' +
				", image2='" + image2 + '\'' +
				", image3='" + image3 + '\'' +
				", image4='" + image4 + '\'' +
				'}';
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getLifeStage() {
		return lifeStage;
	}

	public void setLifeStage(String lifeStage) {
		this.lifeStage = lifeStage;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getSoldNumber() {
		return soldNumber;
	}

	public void setSoldNumber(int soldNumber) {
		this.soldNumber = soldNumber;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}
}
