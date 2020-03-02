package com.junyang.entity;

import lombok.Getter;
import lombok.Setter;
/**
 * @category 医院
 * @author csz
 *
 */
@Getter
@Setter
public class DicHospitalEntity {
	
	private Integer id;//主键
	
	private String name;//名称
	
	private String alias;//别名
	
	private String rank;//级别
	
	private Integer province;//省份
	
	private Integer city;//城市
	
	private String notes;//简介

	public DicHospitalEntity() {
		super();
	}

	public DicHospitalEntity(Integer id, String name, String alias, String rank, Integer province, Integer city,
			String notes) {
		super();
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.rank = rank;
		this.province = province;
		this.city = city;
		this.notes = notes;
	}
	
	
	

}
