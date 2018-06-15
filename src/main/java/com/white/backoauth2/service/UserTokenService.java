package com.white.backoauth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.white.backoauth2.model.UserToken;
import com.white.backoauth2.repository.UserTokenRepository;

@Service
public class UserTokenService {

	@Autowired
	UserTokenRepository userTokenRepository;

	public UserToken getUserEmailByToken(String token) {
		return userTokenRepository.findByToken(token);
	}

	public void saveUserToken(UserToken userToken) {
		userTokenRepository.save(userToken);
	}
}
