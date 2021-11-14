package com.crud.prueba.controller;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.prueba.model.SignInDto;
import com.crud.prueba.security.JwtProvider;




@RestController
@RequestMapping("api")
public class LoginController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtProvider jwtProvider;
	
	@PostMapping("/login")
	public Map<String, String> signIn(@RequestBody @Valid SignInDto signInDto) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDto.getUsername(), signInDto.getPassword()));
			String token = jwtProvider.createToken(signInDto.getUsername());
			return Collections.singletonMap("token", token);
		} catch (AuthenticationException e){
            System.out.println("Log in failed for user, " + signInDto.getUsername());
        }

		return Collections.singletonMap("Error", "Error");
	}
}
