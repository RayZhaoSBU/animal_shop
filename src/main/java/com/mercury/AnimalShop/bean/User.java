package com.mercury.AnimalShop.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name="user")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	private String password;
	
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinTable(
			name="user_profile",
			joinColumns= {
					@JoinColumn(name="user_id",referencedColumnName="id")
			},
			inverseJoinColumns= {
					@JoinColumn(name="profile_id",referencedColumnName="id")
			}
			)
	private List<Profile> profiles;


	public User() {
		super();
	}


	public User(long id,
				String username,
				String password,
				List<Profile> profiles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.profiles = profiles;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", profiles=" + profiles + "]";
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Profile> getProfiles() {
		return profiles;
	}


	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return profiles;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
	

	
	

	
}
