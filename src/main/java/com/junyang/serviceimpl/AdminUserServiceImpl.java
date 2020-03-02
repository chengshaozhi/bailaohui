package com.junyang.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.junyang.base.BaseApiService;
import com.junyang.base.ResponseBase;
import com.junyang.constants.Constants;
import com.junyang.dao.AdminRole;
import com.junyang.dao.AdminUserDao;
import com.junyang.entity.AdminUserEntity;
import com.junyang.service.AdminUserService;
import com.junyang.util.MD5Util;

import lombok.extern.slf4j.Slf4j;

@RestController
@Transactional
@Slf4j
public class AdminUserServiceImpl extends BaseApiService implements AdminUserService{

	
	@Autowired
	private AdminUserDao adminUserDao;
	
	@Autowired
	private AdminRole adminRole;
	
	@Override
	public ResponseBase login(@RequestParam("acctive")String acctive, @RequestParam("password")String password,HttpServletRequest request) {
		try {
			AdminUserEntity entity = adminUserDao.findAcctive(acctive);
			if(entity != null && MD5Util.mD5(password).equals(entity.getPassword())){
				adminUserDao.uptoken(entity.getId(),UUID.randomUUID().toString().replace("-", ""));
				log.info(Constants.SUCCESS);
				return setResultSuccess(JSON.toJSON(entity),Constants.SUCCESS);
			}else{
				log.info(Constants.ERROR);
				return setResultError(Constants.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase add(AdminUserEntity entity) {
		try {
			AdminUserEntity userEntity = adminUserDao.findAcctive(entity.getAcctive());
			if(userEntity != null){
				log.info("账号已存在");
				return setResultError("账号已存在");
			}else{
				entity.setPassword(MD5Util.mD5(entity.getPassword()));
				adminUserDao.add(entity);
				log.info(Constants.SUCCESS);
				return setResultSuccess(Constants.SUCCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase info(@RequestParam("id")Integer id) {
		try {
			Map<String, Object> map;
			AdminUserEntity user = adminUserDao.findById(id);
			if(user != null){
				map = new HashMap<>();
				Map<String, Object> role = adminRole.findAll();
				map.put("user", user);
				map.put("role", role);
				log.info(Constants.SUCCESS);
				return setResultSuccess(JSON.toJSON(map),Constants.SUCCESS);
			}else{
				log.info(Constants.ERROR);
				return setResultError(Constants.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase update(AdminUserEntity entity) {
		try {
			AdminUserEntity userEntity = adminUserDao.findById(entity.getId());
			if(userEntity != null){
				AdminUserEntity user = adminUserDao.findAcctive(entity.getAcctive());
				if(user != null){
					log.info("此账号已存在");
					return setResultError("此账号已存在");
				}else{
					adminUserDao.update(entity);
					log.info(Constants.SUCCESS);
					return setResultSuccess(Constants.SUCCESS);
				}
			}else{
				log.info(Constants.ERROR);
				return setResultError(Constants.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase remove(@RequestParam("id")Integer id) {
		try {
			AdminUserEntity entity = adminUserDao.findById(id);
			if(entity != null){
				adminUserDao.remove(id);
				log.info(Constants.SUCCESS);
				return setResultSuccess(Constants.SUCCESS);
			}else{
				log.info(Constants.ERROR);
				return setResultError(Constants.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase findList() {
		List<AdminUserEntity> list = adminUserDao.findList();
		if(list != null && list.size() > 0){
			log.info(Constants.SUCCESS);
			return setResultSuccess(JSON.toJSON(list), Constants.SUCCESS);
		}else{
			log.info("没有相关数据");
			return setResultSuccess(new ArrayList<>(), "没有想过数据");
		}
	}




}
