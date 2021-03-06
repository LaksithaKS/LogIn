package com.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.model.User;

import lombok.AllArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
public class MyUserDetails implements UserDetails {

	User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isActive();
	}


	@Override
	public boolean isEnabled() {
		return user.isActive();
	}
	
	public String getUserId() {
		return user.getUserId();
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
}
