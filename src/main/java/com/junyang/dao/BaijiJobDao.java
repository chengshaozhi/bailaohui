package com.junyang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.junyang.entity.BaijiJobEntity;

public interface BaijiJobDao {

	@Select("select * from hosp_baiji_job where code = #{code}")
	BaijiJobEntity findCode(@Param("code")String code);

	@Insert("insert into hosp_baiji_job(code,userid,superior,mainjob) "
			+ "values(#{code},#{userid},#{superior},#{mainjob})")
	void add(BaijiJobEntity entity);

	@Select("select * from hosp_baiji_job where id = #{id}")
	BaijiJobEntity findById(@Param("id")Integer id);

	@Update("update hosp_baiji_job set code = #{code},"
			+ "userid = #{userid},superior = #{superior},"
			+ "mainjob = #{mainjob} where id = #{id}")
	void update(BaijiJobEntity entity);

	@Delete("delete from hosp_baiji_job where id = #{id}")
	void remove(@Param("id")Integer id);

	@Select("select * from hosp_baiji_job where code like '%${code}%'")
	List<BaijiJobEntity> likeCode(@Param("code")String code);

	@Select("<script>"
			+ "select count(id) from hosp_baiji_job where 1=1 "
			+ "<if test = 'id != null'> and id = #{id}</if>"
			+ "<if test = 'code != null'> and code like '%${code}%'</if>"
			+ "<if test = 'username != null'> and userid in (select id from hosp_baiji_user where name like '%${username}%')</if>"
			+ "<if test = 'sup != null'> and superior = #{sup}</if>"
			+ "</script>")
	int findCount(@Param("id")Integer id, @Param("code")String code, @Param("username")String username, @Param("sup")Integer sup);

	@Select("<script>"
			+ "select a.*,b.name from  hosp_baiji_job a left join hosp_baiji_user b on a.userid = b.id where 1=1"
			+ "<if test = 'jobid != null'> and a.id = #{jobid}</if>"
			+ "<if test = 'code != null'> and code a.like '%${code}%'</if>"
			+ "<if test = 'username != null'> and a.userid in (select id from hosp_baiji_user where name like '%${username}%')</if>"
			+ "<if test = 'sup != null'> and a.superior = #{sup}</if>"
			+ " order by #{id} offset #{temp} row fetch next #{sizes} row only "
			+ "</script>")
	List<Map<String, Object>> findList(@Param("jobid")Integer jobid, @Param("code")String code, @Param("username")String username, @Param("sup")Integer sup, @Param("temp")int temp, @Param("sizes")int sizes);


}
