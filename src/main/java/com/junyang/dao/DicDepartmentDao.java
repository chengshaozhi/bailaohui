package com.junyang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.junyang.entity.DicDepartmentEntity;

public interface DicDepartmentDao {

	@Select("select * from hosp_dic_department")
	List<DicDepartmentEntity> findall();

}
