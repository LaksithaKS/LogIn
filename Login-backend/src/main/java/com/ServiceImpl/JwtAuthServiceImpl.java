package com.ServiceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.jwt.AuthenticationRequest;
import com.jwt.AuthenticationResponse;
import com.jwt.JwtUtil;
import com.security.MyUserDetails;
import com.security.MyUserDetailsService;
import com.service.JwtAuthService;

@Service
public class JwtAuthServiceImpl implements JwtAuthService {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;


	@Override
	public ResponseEntity<?> createAuthenticationToken(AuthenticationRequest authenticationRequest,HttpServletRequest request) throws Exception {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserId(),
				authenticationRequest.getPassword()));

		MyUserDetails userDetails = (MyUserDetails) userDetailsService
				.loadUserByUsername(authenticationRequest.getUserId());
		String jwt = jwtUtil.generateToken(userDetails);
		String userId = userDetails.getUserId();
		String username = userDetails.getUsername();
		String role = userDetails.getAuthorities().stream().map(r -> r.getAuthority()).findFirst().orElse("NULL");
		
		return ResponseEntity.ok(new AuthenticationResponse(userId, username, jwt, role));
	}

}
