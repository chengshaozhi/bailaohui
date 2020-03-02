package com.junyang.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.junyang.dao.DicDepartmentDao;
import com.junyang.dao.DicDitchDao;
import com.junyang.dao.DicHospitalDao;
import com.junyang.dao.WeChatAcctiveDao;
import com.junyang.dao.WeChatIntegralDao;
import com.junyang.dao.WeChatUserDao;
import com.junyang.entity.DicDepartmentEntity;
import com.junyang.entity.DicDitchEntity;
import com.junyang.entity.DicHospitalEntity;
import com.junyang.entity.WeChatAcctiveEntity;
import com.junyang.entity.WeChatIntegralEntity;
import com.junyang.entity.WeChatUserEntity;
import com.junyang.service.WeChatUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Transactional
@Slf4j
public class WeChatUserServiceImpl extends BaseApiService implements WeChatUserService {

	@Autowired
	private WeChatUserDao weChatUserDao;

	@Autowired
	private WeChatAcctiveDao weChatAcctiveDao;

	@Autowired
	private WeChatIntegralDao weChatIntegralDao;

	@Autowired
	private DicHospitalDao dicHospitalDao;

	@Autowired
	private DicDitchDao dicDitchDao;

	@Autowired
	private DicDepartmentDao dicDepartmentDao;

	@Override
	public ResponseBase findlist(WeChatUserEntity entity, Integer page, Integer size) {
		try {
			int sizes = size == null ? Constants.PAGE_SIZE : size;// 每页显示数
			int pages = page == null ? 1 : page;// 当前页码
			int count = weChatUserDao.findCount(entity);// 总记录数
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
			List<Map<String, Object>> list = weChatUserDao.findlist(entity, temp, sizes);
			if (list != null && list.size() > 0) {
				log.info(Constants.SUCCESS);
				return setResultSuccess(JSON.toJSON(list), Constants.SUCCESS,count);
			} else {
				log.info("没有相关数据");
				return setResultSuccess(new ArrayList<>(), "没有相关数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase findinfo(@RequestParam("id") Integer id) {
		try {
			Map<String, Object> user = weChatUserDao.findById(id);// 用户信息
			if (user != null && user.size() > 0) {
				Map<String, Object> map = new HashMap<>();
				map.put("wechatuesr", user);
				String openid = user.get("openid").toString();
				if (openid != null && openid.length() > 0) {// 账号信息
					WeChatAcctiveEntity acctive = weChatAcctiveDao.findOpenid(openid);
					if (acctive != null) {
						map.put("acctive", acctive);
					} else {
						map.put("acctive", new HashMap<>());
					}
				} else {
					map.put("acctive", new HashMap<>());
				}
				// 积分信息
				List<WeChatIntegralEntity> list = weChatIntegralDao
						.findWeChatUserid(Integer.parseInt(user.get("id").toString()));
				if (list != null && list.size() > 0) {
					map.put("integral", list);
				} else {
					map.put("integral", new ArrayList<>());
				}
				log.info(Constants.SUCCESS);
				return setResultSuccess(JSON.toJSON(map), Constants.SUCCESS);
			} else {
				log.info(Constants.ERROR);
				return setResultError(Constants.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase update(WeChatUserEntity entity) {
		try {
			Map<String, Object> user = weChatUserDao.findById(entity.getId());
			if (user != null && user.size() > 0) {
				entity.setUptime(new Date());
				weChatUserDao.update(entity);
				// 标签未处理
				log.info(Constants.SUCCESS);
				return setResultSuccess(JSON.toJSON(user), Constants.SUCCESS);
			} else {
				log.info(Constants.ERROR);
				return setResultError(Constants.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase concern(@RequestParam("id") Integer id, @RequestParam("state") Integer state) {
		try {
			Map<String, Object> entity = weChatUserDao.findById(id);
			if (entity != null) {
				weChatUserDao.updateState(id, state);
				log.info(Constants.SUCCESS);
				return setResultSuccess(Constants.SUCCESS);
			} else {
				log.info(Constants.ERROR);
				return setResultError(Constants.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public ResponseBase dic() {
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> state = weChatUserDao.findState();
		if (state != null && state.size() > 0) {
			map.put("state", state);
		} else {
			map.put("state", new ArrayList<>());
		}
		List<DicHospitalEntity> hosp = dicHospitalDao.findall();
		if (hosp != null && hosp.size() > 0) {
			map.put("hosp", hosp);
		} else {
			map.put("hosp", new ArrayList<>());
		}
		List<DicDitchEntity> ditch = dicDitchDao.findall();
		if (ditch != null && ditch.size() > 0) {
			map.put("ditch", ditch);
		} else {
			map.put("ditch", new ArrayList<>());
		}
		List<DicDepartmentEntity> department = dicDepartmentDao.findall();
		if (department != null && department.size() > 0) {
			map.put("department", department);
		} else {
			map.put("department", new ArrayList<>());
		}
		log.info(Constants.SUCCESS);
		return setResultSuccess(JSON.toJSON(map), Constants.SUCCESS);
	}

}
