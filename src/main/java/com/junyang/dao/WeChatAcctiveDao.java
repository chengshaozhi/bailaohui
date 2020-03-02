package com.junyang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.junyang.entity.WeChatAcctiveEntity;

public interface WeChatAcctiveDao {

	@Select("select * from hosp_wechat_acctive where openid = #{openid}")
	WeChatAcctiveEntity findOpenid(@Param("openid")String openid);

	@Select("<script>"
			+ "select count(id) from hosp_wechat_acctive where 1=1"
			+ "<if test = 'id != null'> and id = #{id}</if>"
			+ "<if test = 'nickname != null'> and nickname like '%${nickname}%'</if>"
			+ "<if test = 'sex != null'> and sex = #{sex}</if>"
			+ "<if test = 'openid != null'> and openid = #{openid}</if>"
			+ "<if test = 'unionid != null'> and unionid = #{unionid}</if>"
			+ "<if test = 'attention != null'> and attention = #{attention}</if>"
			+ "<if test = 'admin != null'> and admin = #{admin}</if>"
			+ "</script>")
	int findCount(WeChatAcctiveEntity entity);

	@Select("<script>"
			+ "select a.*,b.name from hosp_wechat_acctive a "
			+ "left join hosp_wechat_user b on a.wechatuid = b.id where 1=1"
			+ "<if test = 'e.id != null'> and a.id = #{e.id}</if>"
			+ "<if test = 'e.nickname != null'> and a.nickname like '%${e.nickname}%'</if>"
			+ "<if test = 'e.sex != null'> and a.sex = #{e.sex}</if>"
			+ "<if test = 'e.openid != null'> and a.openid = #{e.openid}</if>"
			+ "<if test = 'e.unionid != null'> and a.unionid = #{e.unionid}</if>"
			+ "<if test = 'e.attention != null'> and a.attention = #{e.attention}</if>"
			+ "<if test = 'e.admin != null'> and a.admin = #{e.admin}</if>"
			+ " order by #{id} offset #{temp} row fetch next #{sizes} row only "
			+ "</script>")
	List<Map<String, Object>> findlist(@Param("e")WeChatAcctiveEntity entity, @Param("temp")int temp, @Param("sizes")int sizes);

	@Select("select * from hosp_wechat_acctive where id = #{id}")
	WeChatAcctiveEntity findById(@Param("id")Integer id);

	@Update("update hosp_wechat_acctive set admin = #{state} where id = #{id}")
	void setAdmin(@Param("id")Integer id, @Param("state")Integer state);

}
