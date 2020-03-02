package com.junyang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.junyang.entity.WeChatIntegralEntity;

public interface WeChatIntegralDao {

	@Select("select * from hosp_wechat_integral where wechatuserid = #{wechatuserid}")
	List<WeChatIntegralEntity> findWeChatUserid(@Param("wechatuserid")int wechatuserid);

}
