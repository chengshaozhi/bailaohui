package com.junyang.entity;

import lombok.Getter;
import lombok.Setter;
/**
 * @category 渠道
 * @author csz
 *
 */
@Getter
@Setter
public class DicDitchEntity {

	private Integer id;//主键
	
	private Integer type;//类型 1系统，2第三方
	
	private String name;//名称
	
	private String code;//code编码
	
	private String notes;//简介

	public DicDitchEntity() {
		super();
	}

	public DicDitchEntity(Integer id, Integer type, String name, String code, String notes) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.code = code;
		this.notes = notes;
	}
	
	
	

}
