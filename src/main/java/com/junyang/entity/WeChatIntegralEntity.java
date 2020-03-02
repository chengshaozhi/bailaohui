package com.junyang.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @category 微信用户积分信息
 * @author csz
 *
 */
@Getter
@Setter
public class WeChatIntegralEntity {

	private Integer id;//主键
	
	private String type;//类型
	
	private Integer integral;//积分
	
	private String participate ;//参与物
	
	private Date setdate;//创建时间
	
	private String sign;//标记
	
	private Integer wechatuserid;//用户id

	public WeChatIntegralEntity() {
		super();
	}

	public WeChatIntegralEntity(Integer id, String type, Integer integral, String participate, Date setdate,
			String sign, Integer wechatuserid) {
		super();
		this.id = id;
		this.type = type;
		this.integral = integral;
		this.participate = participate;
		this.setdate = setdate;
		this.sign = sign;
		this.wechatuserid = wechatuserid;
	}
	
	
	
	

}
