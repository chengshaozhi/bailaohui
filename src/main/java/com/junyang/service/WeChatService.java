package com.junyang.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公众号接入
 * @author Administrator
 *
 */
@RequestMapping("/wechat")
public interface WeChatService {

	/**
	 * 公众号接入接口
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@GetMapping("/access")
	public String access(String signature, String timestamp, String nonce, String echostr);
}
