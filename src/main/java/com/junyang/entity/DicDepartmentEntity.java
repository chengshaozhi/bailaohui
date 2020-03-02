package com.junyang.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
/**
 * @category 科室
 * @author csz
 *
 */
@Getter
@Setter
public class DicDepartmentEntity {

	private Integer id;//主键
	
	private String name;//名称
	
	private String baijiid;//百济id
	
	private Date settime;//创建时间
	
	private Date uptime;//修改时间
	
	private String setuser;//创建人
	
	private String upuser;//修改人

	public DicDepartmentEntity() {
		super();
	}

	public DicDepartmentEntity(Integer id, String name, String baijiid, Date settime, Date uptime, String setuser,
			String upuser) {
		super();
		this.id = id;
		this.name = name;
		this.baijiid = baijiid;
		this.settime = settime;
		this.uptime = uptime;
		this.setuser = setuser;
		this.upuser = upuser;
	}
	
	


}
