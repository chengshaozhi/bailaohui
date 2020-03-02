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
import com.junyang.dao.BaijiJobDao;
import com.junyang.dao.BaijiUserDao;
import com.junyang.entity.BaijiJobEntity;
import com.junyang.entity.BaijiUserEntity;
import com.junyang.service.BaijiJobService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Transactional
@Slf4j
public class BaijiJobServiceImpl extends BaseApiService implements BaijiJobService{
	
	@Autowired
	private BaijiJobDao baijiJobDao;
	
	@Autowired
	private BaijiUserDao baijiUserDao;
	
	@Override
	public ResponseBase add(BaijiJobEntity entity) {
		try {
			BaijiJobEntity job = baijiJobDao.findCode(entity.getCode());
			if(job != null){
				log.info("此岗位编号已存在");
				return setResultError("此岗位编号已存在");
			}else{
				baijiJobDao.add(entity);
				if(entity.getUserid() != null){
					baijiUserDao.updateCode(entity.getUserid(),entity.getCode());
				}
				log.info(Constants.SUCCESS);
				return setResultSuccess(Constants.SUCCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase update(BaijiJobEntity entity) {
		try {
			BaijiJobEntity job = baijiJobDao.findById(entity.getId());
			if(job != null){
				baijiJobDao.update(entity);
				if(entity.getUserid() != null){
					baijiUserDao.updateCode(entity.getUserid(), entity.getCode());
				}
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
	public ResponseBase remove(@RequestParam("id")Integer id) {
		try {
			BaijiJobEntity entity = baijiJobDao.findById(id);
			if(entity != null){
				baijiJobDao.remove(id);
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
	public ResponseBase likesuperior(@RequestParam("code")String code) {
		try {
			List<BaijiJobEntity> list = baijiJobDao.likeCode(code);
			if(list != null && list.size() > 0){
				log.info(Constants.SUCCESS);
				return setResultSuccess(JSON.toJSON(list), Constants.SUCCESS);
			}else{
				log.info("没有相关数据");
				return setResultSuccess("没有相关数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase findlist(Integer id, String code, String username, Integer sup, Integer page, Integer size) {
		try {
			int sizes = size == null ? Constants.PAGE_SIZE:size;// 每页显示数
			int pages = page == null ? 1 : page;// 当前页码
			int count = baijiJobDao.findCount(id,code,username,sup);// 总记录数
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
			List<Map<String, Object>> list = baijiJobDao.findList(id,code,username,sup,temp,sizes);
			if(list != null && list.size() >0){
				for (Map<String, Object> map : list) {
					if(map.get("superior") != null || "".equals(map.get("superior"))){
						StringBuffer superior = new StringBuffer();
						BaijiJobEntity jobentity = baijiJobDao.findById(Integer.getInteger(map.get("superior").toString()));
						if(jobentity != null){
							superior.append(jobentity.getCode());
							if(jobentity.getUserid() != null){
								BaijiUserEntity userEntity = baijiUserDao.findByid(jobentity.getUserid());
								superior.append("-"+userEntity.getName());
							}
						}else{
							superior.append("");
						}
						map.put("superior", superior);
					}else{
						map.put("superior", "");
					}
				}
				return setResultSuccess(JSON.toJSON(list), Constants.SUCCESS,count);
			}else{
				log.info("没有相关数据");
				return setResultSuccess("没有相关数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}



}
