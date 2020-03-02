package com.junyang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.junyang.entity.AdminUserEntity;

public interface AdminUserDao {

	@Select("select * from hosp_admin_user where acctive = #{acctive}")
	AdminUserEntity findAcctive(@Param("acctive")String acctive);

	@Insert("insert into hosp_admin_user (acctive,password,role) values(#{acctive},#{password},#{role})")
	void add(AdminUserEntity entity);

	@Select("select * from hosp_admin_user where id = #{id}")
	AdminUserEntity findById(@Param("id")Integer id);

	@Update("update hosp_admin_user set acctive = #{acctive},password = #{password} where id = #{id}")
	void update(AdminUserEntity entity);

	@Delete("delete from hosp_admin_user where id = #{id}")
	void remove(@Param("id")Integer id);

	@Select("select a.*,b.name as rolename from hosp_admin_user as a,hosp_admin_role as b where a.role = b.id")
	List<AdminUserEntity> findList();

	@Update("update hosp_admin_user set token = #{token} where id = #{id}")
	void uptoken(@Param("id")Integer id, @Param("token")String token);

	@Select("select * from hosp_admin_user where token = #{token}")
	AdminUserEntity findByToken(@Param("token")String token);

}
