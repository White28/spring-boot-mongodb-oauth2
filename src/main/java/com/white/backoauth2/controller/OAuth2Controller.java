package com.white.backoauth2.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.white.backoauth2.model.UserEmail;
import com.white.backoauth2.model.UserToken;
import com.white.backoauth2.service.UserTokenService;

@RestController
public class OAuth2Controller {

	@Autowired
	private UserTokenService userTokenService;

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getUserByToken")
	public ResponseEntity<?> getUserByToken(@RequestHeader("Authorization") String token,
			HttpServletResponse response) {
		try {
			response.setHeader("Authorization", token);

			String tokenValue = token.replace("Bearer", "").trim();

			UserToken userToken = userTokenService.getUserEmailByToken(tokenValue);

			UserEmail userEmail = new UserEmail(userToken.getEmail());

			return new ResponseEntity<>(userEmail, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
