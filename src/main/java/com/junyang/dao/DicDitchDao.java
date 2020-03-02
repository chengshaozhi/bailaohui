package com.junyang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.junyang.entity.DicDitchEntity;

public interface DicDitchDao {

	@Select("select * from hosp_dic_ditch")
	List<DicDitchEntity> findall();

}
