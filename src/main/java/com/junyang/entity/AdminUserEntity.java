package com.junyang.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @category 登陆用户
 * @author csz
 *
 */
@Getter
@Setter
public class AdminUserEntity {

	private Integer id;//主键
	
	private String acctive;//账号
	
	private String password;//密码
	
	private Integer role;//角色
	
	private String rolename;//角色
	
	private String token;//
	
	public AdminUserEntity() {
		super();
	}

	public AdminUserEntity(Integer id, String acctive, String password, Integer role, String rolename, String token) {
		super();
		this.id = id;
		this.acctive = acctive;
		this.password = password;
		this.role = role;
		this.rolename = rolename;
		this.token = token;
	}
	
	

}
