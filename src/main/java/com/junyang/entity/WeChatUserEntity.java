package com.junyang.entity;
import lombok.Setter;

import java.util.Date;

import lombok.Getter;


/**
 * @category 微信用户
 * @author csz
 *
 */
@Getter
@Setter
public class WeChatUserEntity {

	private Integer id;//主键
	
	private String name;//姓名
	
	private String tel;//手机号码
	
	private Integer hospital;//医院
	
	private Integer state;//审核状态
	
	private Integer focus;//是否关注
	
	private Integer doctor;//是否为医生
	
	private Integer ditch;//渠道
	
	private String email;//邮箱
	
	private Integer department;//科室
	
	private String notes;//备注
	
	private Date settime;//创建时间
	
	private Date uptime;//更新时间
	
	private String openid;//微信openid

	public WeChatUserEntity() {
		super();
	}

	public WeChatUserEntity(Integer id, String name, String tel, Integer hospital, Integer state, Integer focus,
			Integer doctor, Integer ditch, String email, Integer department, String notes, Date settime, Date uptime,
			String openid) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.hospital = hospital;
		this.state = state;
		this.focus = focus;
		this.doctor = doctor;
		this.ditch = ditch;
		this.email = email;
		this.department = department;
		this.notes = notes;
		this.settime = settime;
		this.uptime = uptime;
		this.openid = openid;
	}
	
	
	


}
