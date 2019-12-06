package com.community.demo.provider;

import com.alibaba.fastjson.JSON;
import com.community.demo.dto.AccessTokenDTO;
import com.community.demo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

	public String getAccessToken(AccessTokenDTO accessTokenDTO) {
		MediaType mediaType = MediaType.get("application/json; charset=utf-8");
		OkHttpClient client = new OkHttpClient();
		RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
		Request request = new Request.Builder()
				.url("https://github.com/login/oauth/access_token?client_id=4f75c1aab09c21615b4f&client_secret=9d0ee91adae8b61e45c677a11e68874f8709c73f&" +
						"code="+accessTokenDTO.getCode()+"&redirect_uri=http://localhost:8080/callback&state="+accessTokenDTO.getState())
				.post(body)
				.build();
		try (Response response = client.newCall(request).execute()) {
			String str = response.body().string();
			System.out.println(str);
			return str;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  null;
	}

	public GithubUser getUser(String accessToken){
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("https://api.github.com/user?"+accessToken)
				.build();
		try (Response response = client.newCall(request).execute()) {
			String str = response.body().string();
			System.out.println(str);
			GithubUser githubUser = JSON.parseObject(str, GithubUser.class);
			return githubUser;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  null;
	}
}
