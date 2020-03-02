package com.junyang.constants;
/**
 * 
 * @author csz
 *
 */
public interface Constants {
		
		String  SUCCESS="操作成功";
		
		String ERROR= "操作失败，请稍后再试";
		
		String IP_SITE= "http://192.168.64.1:8080/";
		
		String FILETE_HEAD="D://shuangsuiji//";
		
		String DISK_SITE="d:";

		Integer USER_LEVEL=3;
		
		Integer PAGE_SIZE = 20;
		
		// 响应请求成功
		String HTTP_RES_CODE_200_VALUE = "success";
		// 系统错误
		String HTTP_RES_CODE_500_VALUE = "fial";
		// 响应请求成功code
		Integer HTTP_RES_CODE_200 = 200;
		// 系统错误
		Integer HTTP_RES_CODE_500 = 500;
		//未关联QQ账号
		Integer HTTP_RES_CODE_201 = 201;
		// 发送邮件
		String MSG_EMAIL ="email";
		// 会员token
		String TOKEN_MEMBER ="TOKEN_MEMBER";
		// 用户有效期 90天
		Long TOKEN_MEMBER_TIME =(long) (60*60*24*90);
		int COOKIE_TOKEN_MEMBER_TIME =(60*60*24*90);
		// cookie 会员 totoken 名称
		String COOKIE_MEMBER_TOKEN ="cookie_member_token";

}
