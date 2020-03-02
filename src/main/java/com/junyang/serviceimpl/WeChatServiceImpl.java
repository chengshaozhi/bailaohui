package com.junyang.serviceimpl;

import org.springframework.web.bind.annotation.ResponseBody;

import com.junyang.service.WeChatService;

public class WeChatServiceImpl implements WeChatService {

	@Override
	@ResponseBody
	public String access(String signature, String timestamp, String nonce, String echostr) {
		System.out.println("微信加密签名" + signature);
		System.out.println("时间戳" + timestamp);
		System.out.println("随机数" + nonce);
		System.out.println("随机字符串" + echostr);
		// 1）将token、timestamp、nonce三个参数进行字典序排序
		/*
		 * String[] arr = {WeixinUtil.TOKEN,timestamp,nonce}; Arrays.sort(arr);
		 * //2）将三个参数字符串拼接成一个字符串进行sha1加密 StringBuilder sb = new StringBuilder();
		 * for (String temp : arr) { sb.append(temp); } //自己加密的签名 String
		 * mySignature = SecurityUtil.SHA1(sb.toString());
		 * //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		 * if(mySignature.equals(signature)){ //请原样返回echostr参数内容，则接入生效，成为开发者成功
		 * System.out.println("接入成功"); return echostr; } //否则接入失败
		 * System.out.println("接入失败");
		 */
		return echostr;
	}

}
