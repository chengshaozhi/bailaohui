package com.junyang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.junyang.entity.DicHospitalEntity;

public interface DicHospitalDao {

	@Select("select * from hosp_dic_hospital")
	List<DicHospitalEntity> findall();

}
