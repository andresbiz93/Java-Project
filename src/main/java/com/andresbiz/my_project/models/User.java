package com.andresbiz.my_project.models;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email(message = "Email must be valid.")
	private String email;
	
	@Size(min = 5, message = "Password must be greater than 5 characters")
	private String password;
	
	@Transient
	private transient String passwordConfirmation;
	
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;
	
	public User() {}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirmation() {
		return this.passwordConfirmation;
	}
	
	public void setPasswordConfirmation(String pwc) {
		this.passwordConfirmation = pwc;
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	
}
