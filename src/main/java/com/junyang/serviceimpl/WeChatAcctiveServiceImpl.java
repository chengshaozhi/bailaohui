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
import com.junyang.dao.WeChatAcctiveDao;
import com.junyang.entity.WeChatAcctiveEntity;
import com.junyang.service.WeChatAcctiveService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Transactional
@Slf4j
public class WeChatAcctiveServiceImpl extends BaseApiService implements WeChatAcctiveService{

	@Autowired
	private WeChatAcctiveDao weChatAcctiveDao;
	
	@Override
	public ResponseBase findlist(WeChatAcctiveEntity entity, Integer page, Integer size) {
		try {
			int sizes = size == null ? Constants.PAGE_SIZE : size;// 每页显示数
			int pages = page == null ? 1 : page;// 当前页码
			int count = weChatAcctiveDao.findCount(entity);// 总记录数
			int num = count % sizes == 0 ? count / sizes : count / sizes + 1;// 总页码
			if (pages > num) {
				log.info("页面超出范围");
				List<Object> list = new ArrayList<>();
				return setResultSuccess(list, "页面超出范围", 0);
			}
			if (pages < 1) {
				pages = 1;
			}
			int temp = (pages - 1) * sizes;// 从第几条开始查询
			List<Map<String, Object>> list = weChatAcctiveDao.findlist(entity, temp, sizes);
			if(list != null && list.size() > 0){
				log.info(Constants.SUCCESS);
				return setResultSuccess(JSON.toJSON(list),Constants.SUCCESS,count);
			}else{
				log.info("没有相关数据");
				return setResultError("没有相关数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase update(@RequestParam("id")Integer id, @RequestParam("state")Integer state) {
		try {
			WeChatAcctiveEntity entity = weChatAcctiveDao.findById(id);
			if(entity != null){
				weChatAcctiveDao.setAdmin(id,state);
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

	

}
