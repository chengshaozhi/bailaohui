package com.junyang.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
/**
 * @category hcp用户
 * @author csz
 *
 */
@Getter
@Setter
public class HcpUserEntity {

	private Integer id;//主键
	
	private String name;//姓名
	
	private String code;//code编码
	
	private String email;//邮箱
	
	private String tel;//手机号码
	
	private Integer hospital;//所属医院
	
	private Integer departments;//所属科室
	
	private Integer hospjob;//医院职称
	
	private Integer sciencejob;//学术职称
	
	private Date settime;//创建时间
	
	private Date uptime;//更新时间

	public HcpUserEntity() {
		super();
	}

	public HcpUserEntity(Integer id, String name, String code, String email, String tel, Integer hospital,
			Integer departments, Integer hospjob, Integer sciencejob, Date settime, Date uptime) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.email = email;
		this.tel = tel;
		this.hospital = hospital;
		this.departments = departments;
		this.hospjob = hospjob;
		this.sciencejob = sciencejob;
		this.settime = settime;
		this.uptime = uptime;
	}
	
	

}
