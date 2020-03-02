package com.junyang.entity;

import lombok.Setter;

import lombok.Getter;

/**
 * @category 百济内部用户
 * @author csz
 *
 */
@Getter
@Setter
public class BaijiUserEntity {

	private Integer id;//主键
	
	private String name;//姓名
	
	private String email;//邮箱
	
	private Integer role;//角色
		
	private String ssoid;//ssoid
	
	private Integer state;//状态
	
	private String jobcode;//岗位编码

	public BaijiUserEntity() {
		super();
	}

	public BaijiUserEntity(Integer id, String name, String email, Integer role, String ssoid, Integer state,
			String jobcode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.ssoid = ssoid;
		this.state = state;
		this.jobcode = jobcode;
	}

	


	
	

}
