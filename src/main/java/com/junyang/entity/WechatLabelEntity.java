package com.junyang.entity;

import lombok.Getter;
import lombok.Setter;


/**
 * @category 微信标签
 * @author csz
 *
 */
@Getter
@Setter
public class WechatLabelEntity {

	private Integer id;//主键
	
	private String name;//名称
	
	private Integer type;//类型 1普通，2状态，3群发
	
	private String code;//code编码
	
	private Integer wechatid;//微信id
	
	private Integer numbers;//人数

	public WechatLabelEntity() {
		super();
	}

	public WechatLabelEntity(Integer id, String name, Integer type, String code, Integer wechatid, Integer numbers) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.code = code;
		this.wechatid = wechatid;
		this.numbers = numbers;
	}
	
	
	
	
	
}
