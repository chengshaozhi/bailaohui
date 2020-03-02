package com.junyang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.junyang.entity.BaijiUserEntity;

public interface BaijiUserDao {

	@Insert("insert into hosp_baiji_user (name,email,role,ssoid,state,jobcode) "
			+ "values(#{name},#{email},#{role},#{ssoid},#{state},#{jobcode})")
	int add(BaijiUserEntity entity);

	@Select("<script>"
			+ "select count(id) from hosp_baiji_user where 1=1 "
			+ "<if test = 'id != null'> and id = #{id}</if>"
			+ "<if test = 'name != null'> and name like '%${name}%'</if>"
			+ "<if test = 'email != null'> and email like '%${email}%'</if>"
			+ "<if test = 'role != null'> and role = #{role}</if>"
			+ "<if test = 'state != null'> and state = #{state}</if>"
			+ "<if test = 'jobcode != null'> and jobcode like '%${jobcode}%'</if> "
			+ "</script>")
	int findCount(BaijiUserEntity entity);

	@Select("<script>"
			+ "select * from hosp_baiji_user where 1=1 "
			+ "<if test = 'e.id != null'> and id = #{e.id}</if>"
			+ "<if test = 'e.name != null'> and name like '%${e.name}%'</if>"
			+ "<if test = 'e.email != null'> and email like '%${e.email}%'</if>"
			+ "<if test = 'e.role != null'> and role = #{e.role}</if>"
			+ "<if test = 'e.state != null'> and state = #{e.state}</if>"
			+ "<if test = 'e.jobcode != null'> and jobcode like '%${e.jobcode}%'</if>"
			+ " order by #{id} offset #{temp} row fetch next #{sizes} row only "
			+ "</script>")
	List<Map<String, Object>> findlist(@Param("e")BaijiUserEntity entity, @Param("temp")int temp, @Param("sizes")int sizes);

	@Select("select * from hosp_baiji_user where name like '%${name}%'")
	List<BaijiUserEntity> likename(@Param("name")String name);

	@Update("update hosp_baiji_user set jobcode = #{code} where id = #{userid}")
	void updateCode(@Param("userid")Integer userid, @Param("code")String code);

	@Select("select* from hosp_baiji_user where id = #{userid}")
	BaijiUserEntity findByid(@Param("userid")Integer userid);

}
