package com.white.backoauth2.controller;

import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.white.backoauth2.model.UserToken;
import com.white.backoauth2.service.UserTokenService;

@Controller
public class MainController {

	@Autowired
	private OAuth2ClientContext ctx;

	@Autowired
	private UserTokenService userTokenService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirectAfterSuccessfulLogin(OAuth2Authentication authentication,
			RedirectAttributes redirectAttributes) {

		LinkedHashMap<String, Object> properties =
				(LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();

		String email = (String) properties.get("email");

		String token = ctx.getAccessToken().getValue();

		userTokenService.saveUserToken(new UserToken(email, token));

		redirectAttributes.addAttribute("access_token", token);
		return "redirect:(redirectUrl)";
	}
}
