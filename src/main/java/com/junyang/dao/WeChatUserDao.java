package com.junyang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.junyang.entity.WeChatUserEntity;

public interface WeChatUserDao {

	
	@Select("<script>"
			+ "select count(id) from hosp_wechat_user where 1=1"
			+ "<if test ='id != null'> and id = #{id}</if>"
			+ "<if test = 'name != null'> and name like '%${name}%'</if>"
			+ "<if test = 'tel != null'> and tel like '%${tel}%'</if>"
			+ "<if test ='hospital != null'> and hospital = #{hospital}</if>"
			+ "<if test ='state != null'> and state = #{state}</if>"
			+ "<if test ='focus != null'> and focus = #{focus}</if>"
			+ "<if test ='doctor != null'> and doctor = #{doctor}</if>"
			+ "<if test ='ditch != null'> and ditch = #{ditch}</if>"
			+ "<if test ='notes != null'> and notes like '%${notes}%'</if>"
			+ "</script>")
	int findCount(WeChatUserEntity entity);

	@Select("<script>"
			+ "select a.*,b.name as hospname,c.name as ditchname,d.name as statename,e.name departmentname "
			+ "from  hosp_wechat_user a "
			+ "left join hosp_dic_hospital b on a.hospital = b.id "
			+ "left join hosp_dic_ditch c on a.ditch = c.id "
			+ "left join hosp_wechat_state d on a.state = d.id "
			+ "left join hosp_dic_department e on a.department = e.id where 1=1"
			+ "<if test = 'e.id != null'> and a.id = #{e.id}</if>"
			+ "<if test = 'e.name != null'> and a.name like '%${e.name}%'</if>"
			+ "<if test = 'e.tel != null'> and a.tel like '%${e.tel}%'</if>"
			+ "<if test = 'e.hospital != null'> and a.hospital = #{e.hospital}</if>"
			+ "<if test = 'e.state != null'> and a.state = #{e.state}</if>"
			+ "<if test = 'e.focus != null'> and a.focus = #{e.focus}</if>"
			+ "<if test = 'e.doctor != null'> and a.doctor = #{e.doctor}</if>"
			+ "<if test = 'e.ditch != null'> and a.ditch = #{e.ditch}</if>"
			+ "<if test = 'e.notes != null'> and a.notes like '%${e.notes}%'</if>"
			+ " order by #{id} offset #{temp} row fetch next #{sizes} row only "
			+ "</script>")
	List<Map<String, Object>> findlist(@Param("e")WeChatUserEntity entity, @Param("temp")int temp, @Param("size")int sizes);

	@Select("select a.*,b.name as hospname,c.name as ditchname,d.name as statename,e.name departmentname"
			+ "from  hosp_wechat_user a "
			+ "left join hosp_dic_hospital b on a.hospital = b.id "
			+ "left join hosp_dic_ditch c on a.ditch = c.id "
			+ "left join hosp_wechat_state d on a.state = d.id"
			+ "left join hosp_dic_department e on a.department = e.id"
			+ "where a.id = #{id}")
	Map<String, Object> findById(@Param("id")Integer id);

	@Update("update hosp_wechat_user set name = #{name},tel=#{tel},hospital=#{hospital},"
			+ "focus = #{focus},doctor=#{doctor},ditch=#{ditch},email=#{email},"
			+ "department=#{department},notes=#{notes},uptime = #{uptime} where id = #{id}")
	void update(WeChatUserEntity entity);

	@Update("update hosp_wechat_user set state=#{state} where id = #{id}")
	void updateState(@Param("id")Integer id, @Param("state")Integer state);

	@Select("select * from hosp_wechat_state")
	List<Map<String, Object>> findState();
	

}
