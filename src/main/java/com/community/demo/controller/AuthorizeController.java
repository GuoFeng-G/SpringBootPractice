package com.community.demo.controller;

import com.community.demo.dto.AccessTokenDTO;
import com.community.demo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorizeController {

	@Autowired
	private GithubProvider githubProvider;

	@GetMapping("/callback")
	@ResponseBody
	public String callback(@RequestParam(value = "code")String code, @RequestParam(value = "state")String state){
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setClientID("4f75c1aab09c21615b4f");
		accessTokenDTO.setClientSecret("9d0ee91adae8b61e45c677a11e68874f8709c73f");
		accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
		accessTokenDTO.setCode(code);
		accessTokenDTO.setState(state);
		githubProvider.getAccessToken(accessTokenDTO);
		return null;
	}
}
