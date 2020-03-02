package com.junyang.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface AdminRole {

	@Select("select * from hosp_admin_role")
	Map<String, Object> findAll();

}
