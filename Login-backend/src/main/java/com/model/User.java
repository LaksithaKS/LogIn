package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class User {
	@Id
	@Column(name = "user_id", length = 100)
	private String userId;
	
	@Column(length = 50, nullable = false)
	private String userName;
	
	@Column(length = 50, nullable = false)
	private String password;
	
	@Column(length = 50, nullable = false)
	private String role;
	
	private boolean active;
}
