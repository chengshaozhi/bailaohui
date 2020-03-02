package com.junyang.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @category 岗位
 * @author csz
 *
 */
@Getter
@Setter
public class BaijiJobEntity {

	private Integer id;
	
	private String code;//编码
	
	private Integer userid;//百济内部用户id
	
	private Integer superior;//上级id
	
	private Integer mainjob;//主岗位

	public BaijiJobEntity() {
		super();
	}

	public BaijiJobEntity(Integer id, String code, Integer userid, Integer superior, Integer mainjob) {
		super();
		this.id = id;
		this.code = code;
		this.userid = userid;
		this.superior = superior;
		this.mainjob = mainjob;
	}
	
	
	

}
