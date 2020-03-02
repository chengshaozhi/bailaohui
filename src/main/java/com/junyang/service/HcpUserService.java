package com.junyang.service;

import org.springframework.web.bind.annotation.RequestMapping;
import com.junyang.base.ResponseBase;
import com.junyang.entity.HcpUserEntity;


/**
 * @category hcp用户接口
 * @author csz
 *
 */
@RequestMapping("/hcp")
public interface HcpUserService {
	
	/**
	 * @category 列表查询
	 * @param entity
	 * @return
	 */
	@RequestMapping("/findlist")
	public ResponseBase findlist(HcpUserEntity entity,Integer page,Integer size);
	
	/**
	 * hcp用户编辑
	 * @param entity
	 * @return
	 */
	@RequestMapping("/update")
	public ResponseBase update(HcpUserEntity entity);
	
	/**
	 * @category 用户详情，关联岗位信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/findinfo")
	public ResponseBase findinfo(Integer id);
	
	/**
	 * @category 新增关联岗位
	 * @param code
	 * @return
	 */
	@RequestMapping("/addjob")
	public ResponseBase addjob(String code,Integer hcpid);
	

	/**
	 * @category 删除关联岗位
	 * @param id
	 * @return
	 */
	@RequestMapping("/removejob")
	public ResponseBase removejob(Integer id);
	
	
	
	
}
