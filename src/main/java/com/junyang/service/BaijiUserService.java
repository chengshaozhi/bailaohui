package com.junyang.service;

import org.springframework.web.bind.annotation.RequestMapping;

import com.junyang.base.ResponseBase;
import com.junyang.entity.BaijiUserEntity;

/**
 * @category 百济内部员工接口
 * @author csz
 *
 */
@RequestMapping("/baijiuser")
public interface BaijiUserService {
	
	/**
	 * @category 新增百济内部用户
	 * @param entity
	 * @return
	 */
	@RequestMapping("/add")
	public ResponseBase add(BaijiUserEntity entity);
	
	/**
	 * @category 用户列表查询
	 * @param entity
	 * @return
	 */
	@RequestMapping("/findlist")
	public ResponseBase findlist(BaijiUserEntity entity,Integer page,Integer size);
	
	/**
	 * @category 用户姓名模糊查询
	 * @param name
	 * @return
	 */
	@RequestMapping("/likename")
	public ResponseBase likename(String name);

}
