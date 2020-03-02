package com.junyang.util;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class MobanxiaoxiUtile {

	public static final String APPID = "wx6f2a207f0cd9bbaa";
	public static final String APPSECRET = "6f31deac337180c9e85f3232c4232e90";
	public static String accessToken;
	public static long expiresTime;

	public static String getAccessToken() {
		if ((accessToken == null) || (new Date().getTime() > expiresTime)) {
			String result = HttpUtil
					.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET"
							.replace("APPID", "wx6f2a207f0cd9bbaa")
							.replace("APPSECRET", "6f31deac337180c9e85f3232c4232e90"));
			System.out.println(result);
			JSONObject json = JSONObject.parseObject(result);
			accessToken = json.getString("access_token");
			Long expires_in = json.getLong("expires_in");
			expiresTime = new Date().getTime() + (expires_in.longValue() - 60L) * 1000L;
		}

		return accessToken;
	}
	
	public static String sendTemplate(String data) {
		String result = HttpUtil
				.post("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN"
						.replace("ACCESS_TOKEN", getAccessToken()), data);
		System.out.println(result);
		return result;
	}
}
