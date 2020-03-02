package com.junyang.serviceimpl;
import com.junyang.service.HcpUserService;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Date;
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
import com.junyang.dao.HcpUserDao;
import com.junyang.entity.BaijiJobEntity;
import com.junyang.entity.HcpUserEntity;

@RestController
@Transactional
@Slf4j
public class HcpUserServiceImpl extends BaseApiService implements HcpUserService{
	
	@Autowired
	private HcpUserDao hcpUserDao;
	
	@Autowired
	private BaijiJobDao baijiJobDao;
	

	@Override
	public ResponseBase findlist(HcpUserEntity entity,Integer page,Integer size) {
		try {
			int sizes = size == null ? Constants.PAGE_SIZE : size;// 每页显示数
			int pages = page == null ? 1 : page;// 当前页码
			int count = hcpUserDao.findCount(entity);// 总记录数
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
			List<Map<String, Object>> list = hcpUserDao.findlist(entity, temp, sizes);
			if(list != null && list.size() > 0){
				log.info(Constants.SUCCESS);
				return setResultSuccess(JSON.toJSON(list), Constants.SUCCESS,count);
			}else{
				log.info("没有相关数据");
				return setResultSuccess(new ArrayList<>(), "没有相关数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}


	@Override
	public ResponseBase update(HcpUserEntity entity) {
		try {
			HcpUserEntity hcpUser = hcpUserDao.findById(entity.getId());
			if(hcpUser != null){
				entity.setUptime(new Date());
				hcpUserDao.update(entity);
				log.info(Constants.SUCCESS);
				return setResultSuccess(entity, Constants.SUCCESS);
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
	public ResponseBase findinfo(@RequestParam("id")Integer id) {
		try {
			List<Map<String, Object>> list = hcpUserDao.findJob(id);
			if(list != null && list.size() > 0){
				log.info(Constants.SUCCESS);
				return setResultSuccess(JSON.toJSON(list), Constants.SUCCESS);
			}else{
				log.info("没有相关数据");
				return setResultError("没有相关数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw  new RuntimeException();
		}
	}


	@Override
	public ResponseBase addjob(@RequestParam("code")String code,@RequestParam("hcpid")Integer hcpid) {
		try {
			BaijiJobEntity entity = baijiJobDao.findCode(code);
			if(entity != null){
				hcpUserDao.addJob(hcpid,entity.getId());
				log.info(Constants.SUCCESS);
				return setResultSuccess(Constants.SUCCESS);
			}else{
				log.info("此岗位不存在");
				return setResultError("此岗位不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}


	@Override
	public ResponseBase removejob(@RequestParam("id")Integer id) {
		try {
			Map<String, Object> map = hcpUserDao.findJobId(id);
			if(map != null && map.size() > 0){
				hcpUserDao.removeJob(id);
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
