package com.junyang.service;

import org.springframework.web.bind.annotation.RequestMapping;

import com.junyang.base.ResponseBase;
import com.junyang.entity.WeChatUserEntity;

/**
 * @category 微信用户接口
 * @author csz
 *
 */
@RequestMapping("/wechatuser")
public interface WeChatUserService {
	
	/**
	 * @category 微信用户列表查询
	 * @param entity
	 * @return
	 */
	@RequestMapping("/findlist")
	public ResponseBase findlist(WeChatUserEntity entity,Integer page,Integer size);
	
	/**
	 * @category 详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/findinfo")
	public ResponseBase findinfo(Integer id);
	
	/**
	 * @category 编辑
	 * @param entity
	 * @return
	 */
	@RequestMapping("/update")
	public ResponseBase update(WeChatUserEntity entity);
	
	/**
	 * @category 关注取消关注
	 * @param userid
	 * @param state
	 * @return
	 */
	@RequestMapping("/concern")
	public ResponseBase concern(Integer id,Integer state);
	
	/**
	 * @category 关联数据字典集合
	 * @return
	 */
	@RequestMapping("/dic")
	public ResponseBase dic();
	
	
	
}
