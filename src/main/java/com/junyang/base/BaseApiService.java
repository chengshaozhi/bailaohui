package com.junyang.base;

import com.junyang.constants.Constants;
/**
 * 
 * @author csz
 *
 */
public class BaseApiService {
	
	//返回失败，可传msg
	public ResponseBase setResultError(String msg){
		return setResult(Constants.HTTP_RES_CODE_500, msg, null,0);
	}
	//返回成功，可传msg
	public  ResponseBase setResultSuccess(String msg){
		return setResult(Constants.HTTP_RES_CODE_200, msg, null,0);
	}
	//返回失败，可传msg
	public  ResponseBase setResultError(Object data,String msg){
			return setResult(Constants.HTTP_RES_CODE_500, msg, data,0);
		}
	
	//返回成功，可传data值,msg
	public ResponseBase setResultSuccess(Object data,String msg,Integer total){
		return setResult(Constants.HTTP_RES_CODE_200,msg, data,total);
	}
	
	//返回成功，可传data值
		public ResponseBase setResultSuccess(Object data,String msg){
			return setResult(Constants.HTTP_RES_CODE_200,msg,data,0);
		}
	
	//返回成功，没有data值
	public ResponseBase setResultSuccess(){
		return setResult(Constants.HTTP_RES_CODE_200,Constants.HTTP_RES_CODE_200_VALUE,null,0);
	}
	//通用封装
	public ResponseBase setResult(Integer code,String msg,Object data,Integer total){
		
		return new ResponseBase(code,msg,data,total);
	}

}
