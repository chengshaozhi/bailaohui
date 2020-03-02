package com.junyang.service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junyang.base.ResponseBase;
import com.junyang.entity.WeChatAcctiveEntity;

/**
 * @category 微信账号接口
 * @author csz
 *
 */

@RequestMapping("/wechatacctive")
public interface WeChatAcctiveService {
	
	/**
	 * @category 微信账号列表查询
	 * @param entity
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/findlist")
	public ResponseBase findlist(WeChatAcctiveEntity entity,Integer page,Integer size);
	
	@RequestMapping("/setadmin")
	public ResponseBase update(Integer id,Integer state);

}
