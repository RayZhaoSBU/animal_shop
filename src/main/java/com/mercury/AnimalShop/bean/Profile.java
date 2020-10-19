package com.mercury.AnimalShop.bean;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="profile")
public class Profile implements GrantedAuthority {
	@Id
	private long id;
	@Column
	private String type;

	public Profile() {
		super();
	}

	public Profile(long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	public Profile(long id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", type=" + type + "]";
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

	@Override
	public String getAuthority() {
		return type;
	}
}
