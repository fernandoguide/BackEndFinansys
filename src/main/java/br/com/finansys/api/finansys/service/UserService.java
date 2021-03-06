package br.com.finansys.api.finansys.service;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.finansys.api.finansys.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
