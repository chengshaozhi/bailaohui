package com.junyang.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.junyang.base.ResponseBase;
import com.junyang.entity.AdminUserEntity;

/**
 * @category 登陆用户接口
 * @author csz
 *
 */
@RequestMapping("/admin")
public interface AdminUserService {

	/**
	 * @category 登陆接口
	 * @param acctive
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public ResponseBase login(String acctive,String password,HttpServletRequest request);
	
	/**
	 * @category 新增用户
	 * @param entity
	 * @return
	 */
	@RequestMapping("/add")
	public ResponseBase add(AdminUserEntity entity);
	
	/**
	 * @category 用户详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public ResponseBase info(Integer id);
	
	/**
	 * @category 用户编辑
	 * @param entity
	 * @return
	 */
	@RequestMapping("/update")
	public ResponseBase update(AdminUserEntity entity);
	
	/**
	 * @category 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/remove")
	public ResponseBase remove(Integer id);
	
	/**
	 * @category 用户列表 
	 * @return
	 */
	@RequestMapping("/findList")
	public ResponseBase findList();
	
}
