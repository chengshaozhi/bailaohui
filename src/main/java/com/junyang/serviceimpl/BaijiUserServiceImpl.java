package com.junyang.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.junyang.base.BaseApiService;
import com.junyang.base.ResponseBase;
import com.junyang.constants.Constants;
import com.junyang.dao.BaijiUserDao;
import com.junyang.entity.BaijiUserEntity;
import com.junyang.service.BaijiUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Transactional
@Slf4j
public class BaijiUserServiceImpl extends BaseApiService implements BaijiUserService{
	
	@Autowired
	private BaijiUserDao baijiUserDao;
	
	@Override
	public ResponseBase add(BaijiUserEntity entity) {
		try {
			int temp = baijiUserDao.add(entity);
			if(temp > 0){
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
	public ResponseBase findlist(BaijiUserEntity entity, Integer page, Integer size) {
		try {
			int sizes = size == null ? Constants.PAGE_SIZE:size;// 每页显示数
			int pages = page == null ? 1 : page;// 当前页码
			int count = baijiUserDao.findCount(entity);// 总记录数
			int num = count % sizes == 0 ? count / sizes : count / sizes + 1;// 总页码
			if (pages > num) {
				log.info("页面超出范围");
				List<Object> list = new ArrayList<>();
				return setResultSuccess(list, "页面超出范围",0);
			}
			if (pages < 1) {
				pages = 1;
			}
			int temp = (pages - 1) * sizes;// 从第几条开始查询
			List<Map<String, Object>> list = baijiUserDao.findlist(entity,temp,sizes);
			if(list.size() > 0 && list != null){
				log.info(Constants.SUCCESS);
				return setResultSuccess(JSON.toJSON(list),Constants.SUCCESS,count);
			}else{
				log.info("没有相关试数据");
				return setResultSuccess(new ArrayList<>(),"没有相关数据", 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase likename(@RequestParam("name")String name) {
		List<BaijiUserEntity> list = baijiUserDao.likename(name);
		if(list != null && list.size() > 0){
			log.info(Constants.SUCCESS);
			return setResultSuccess(JSON.toJSON(list), Constants.SUCCESS);
		}else{
			log.info("没有相关数据");
			return setResultError("没有相关数据");
		}
	}


}
