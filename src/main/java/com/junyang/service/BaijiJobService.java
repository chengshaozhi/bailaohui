package com.junyang.service;

import org.springframework.web.bind.annotation.RequestMapping;

import com.junyang.base.ResponseBase;
import com.junyang.entity.BaijiJobEntity;

/**
 * @category 百济岗位接口
 * @author csz
 *
 */
@RequestMapping("/baijijob")
public interface BaijiJobService {

	/**
	 * @category 岗位新增
	 * @param entity
	 * @return
	 */
	@RequestMapping("/add")
	public ResponseBase add(BaijiJobEntity entity);
	
	/**
	 * @category 岗位编辑
	 * @param entity
	 * @return
	 */
	@RequestMapping("/update")
	public ResponseBase update(BaijiJobEntity entity);
	
	/**
	 * @category 岗位删除
	 * @param id
	 * @return
	 */
	@RequestMapping("remove")
	public ResponseBase remove(Integer id);
	
	/**
	 * @category 模糊查询上级编码
	 * @param code
	 * @return
	 */
	@RequestMapping("/likesuperior")
	public ResponseBase likesuperior(String code);
	
	
	/**
	 * @category 岗位列表
	 * @param id
	 * @param code
	 * @param username
	 * @param sup
	 * @return
	 */
	@RequestMapping("/findlist")
	public ResponseBase findlist(Integer id,String code,String username,Integer sup,Integer page,Integer size);
	
}
