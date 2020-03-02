package com.junyang.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.junyang.entity.HcpUserEntity;

public interface HcpUserDao {

	@Select("<script>"
			+ "select count(id) from hosp_hcp_user where 1=1 "
			+ "<if test = 'id != null'> and id = #{id}</if>"
			+ "<if test = 'name != null'> and name like '${name}'</if>"
			+ "<if test = 'code != null'>and code like '${code}'</if>"
			+ "<if test = 'tel != null'> and tel like '${tel}'</if>"
			+ "<if test = 'hospital != null'> and hospital = #{hospital}</if>"
			+ "<if test = 'departments != null'> and departments = #{departments}</if>"
			+ "<if test = 'hospjob != null'> and hospjob = #{hospjob}</if>"
			+ "<if test = 'sciencejob != null'> and sciencejob = #{sciencejob}</if>"
			+ "</script>")
	int findCount(HcpUserEntity entity);

	@Select("<script>"
			+ "select a.*,b.name as hospname,c.name as deptname,d.name as hospjobname,"
			+ "e.name as sciencejobname from  hosp_hcp_user a "
			+ "left join hosp_dic_hospital b on a.hospital = b.id "
			+ "left join hosp_dic_department c on a.departments =c.id "
			+ "left join hosp_dic_hospjob d on a.hospjob = d.id "
			+ "left join hosp_dic_sciencejob e on a.sciencejob = e.id where 1=1"
			+ "<if test = 'e.id != null'> and a.id = #{e.id}</if>"
			+ "<if test = 'e.name != null'> and a.name like '${e.name}'</if>"
			+ "<if test = 'e.code != null'>and a.code like '${e.code}'</if>"
			+ "<if test = 'e.tel != null'> and a.tel like '${e.tel}'</if>"
			+ "<if test = 'e.hospital != null'> and a.hospital = #{e.hospital}</if>"
			+ "<if test = 'e.departments != null'> and a.departments = #{e.departments}</if>"
			+ "<if test = 'e.hospjob != null'> and a.hospjob = #{e.hospjob}</if>"
			+ "<if test = 'e.sciencejob != null'> and a.sciencejob = #{e.sciencejob}</if>"
			+ " order by #{id} offset #{temp} row fetch next #{sizes} row only "
			+ "</script>")
	List<Map<String, Object>> findlist(@Param("e")HcpUserEntity entity, @Param("temp")int temp, @Param("sizes")int sizes);

	@Select("select * from hosp_hcp_user where id = #{id}")
	HcpUserEntity findById(@Param("id")Integer id);

	@Update("update hosp_hcp_user set name=#{name},code=#{code},email=#{email},tel=#{tel},"
			+ "hospital=#{hospital},departments=#{departments},hospjob=#{hospjob},"
			+ "sciencejob = #{sciencejob},uptime=#{uptime} where id = #{id}")
	void update(HcpUserEntity entity);

	@Select("select a.*,b.code,b.userid,c.name from hosp_hcp_job a "
			+ "LEFT JOIN hosp_baiji_job b ON a.jobid = b.id "
			+ "LEFT JOIN hosp_baiji_user c ON b.userid = c.id "
			+ "where a.hcpid = #{id}")
	List<Map<String, Object>> findJob(@Param("id")Integer id);

	@Insert("insert into hosp_hcp_job(hcpid,jobid) values(#{hcpid},#{jobid})")
	void addJob(@Param("hcpid")Integer hcpid, @Param("jobid")Integer jobid);

	@Select("select * from hosp_hcp_job where id = #{id}")
	Map<String, Object> findJobId(@Param("id")Integer id);

	@Delete("delete from hosp_hcp_job where id = #{id}")
	void removeJob(@Param("id")Integer id);

}
